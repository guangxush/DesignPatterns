## 重构

### 重新组织函数

#### 提炼函数

1. 案例1

原来的代码
```java
void printOwing(double amount){
    printBanner();
    
    //print detail
    System.out.println("name: "+_name);
    System.out.println("amount: "+amount);
}
```

提炼之后的代码 

```java
void printOwing(double amount){
    printBanner();
    printDetails(amount); 
}
void printDeatils(double amount){
    System.out.println("name: "+_name);
    System.out.println("amount: "+amount);
}
```

2. 无局部变量的情况下：

修改前：

```java
void printOwing(){
    Enumeration e = _orders.elements();
    double outstanding = 0.0;
    // print banner
    System.out.println("**********************");
    System.out.println("****Customer Owes*****");
    System.out.println("**********************");
    
    //calculate outstanding
    while(e.hasMoreElements()){
        Order each = (Order)e.nextElement();
        outstanding += each.getAmount();
    }
    
    // print details
    System.out.println("name: "+_name);
    System.out.println("amount: "+amount);
    }
```

修改后：

```java
void printOwing(){
    Enumeration e = _orders.elements();
    double outstanding = 0.0;
    // print banner
    printBanner();
    
    //calculate outstanding
    while(e.hasMoreElements()){
        Order each = (Order)e.nextElement();
        outstanding += each.getAmount();
    }
    
    // print details
    System.out.println("name: "+_name);
    System.out.println("amount: "+amount);
}

void printBanner(){
    System.out.println("**********************");
    System.out.println("****Customer Owes*****");
    System.out.println("**********************");
}
```

2. 有局部变量的情况

```java
void printOwing(){
    Enumeration e = _orders.elements();
    double outstanding = 0.0;
    // print banner
    printBanner();
    
    //calculate outstanding
    while(e.hasMoreElements()){
        Order each = (Order)e.nextElement();
        outstanding += each.getAmount();
    }
    //传入局部变量
    printDetails(outstanding);
}

void printDetails(double outstanding){
    // print details
    System.out.println("name: "+_name);
    System.out.println("amount: "+outstanding);
}
```

把计算的部分提取出来作为一个函数

```java
void printOwing(){
    
    // print banner
    printBanner();

    double outstanding = getOutstanding();

    printDetails(outstanding);
}

double getOutstanding(){
    Enumeration e = _orders.elements();
    //注意变量的命名
    double result = 0.0;
    //calculate outstanding
    while(e.hasMoreElements()){
        Order each = (Order)e.nextElement();
        result += each.getAmount();
    }
    return result;
}
```

3. 有参数的情况

```java
void printOwing(double previousAmount){

    Enumeration e = _orders.elements();
    double outstanding = previousAmount * 1.2;
    // print banner
    printBanner();

    outstanding = getOutstanding(outstanding);

    printDetails(outstanding);
}

double getOutstanding(double initialValue){
    Enumeration e = _orders.elements();
    double result = 0.0;
    //calculate outstanding
    while(e.hasMoreElements()){
        Order each = (Order)e.nextElement();
        result += each.getAmount();
    }
    return result;
}
```

#### 内联函数

原来的代码

```java
int getRating() {
    return (moreThanFiveLateDeliveries()) ? 2 : 1;
}

boolean moreThanFiveLateDeliveries(){
    return _numberOfLateDeliveries > 5;
}
```

重构后的代码

```java
int getRating() {
    return (_numberOfLateDeliveries > 5) ? 2 : 1;
}
```

#### 内联临时变量

重构前的代码

```java
double basePrice = anOrder.basePrice();
return (basePrice > 1000)
```

重构后的代码

```java
return anOrder.basePrice() > 1000;
```

#### 以查询取代临时变量

重构前的代码


```java
double basePrice = _quantity * _itemPrice;
if(basePrice > 1000){
    return basePrice * 0.95;
}else{
    return basePrice * 0.98;
}

```

重构后的代码

```java
if(basePrice() > 1000){
    return basePrice() * 0.95;
}else{
    return basePrice() * 0.98;
}
double basePrice(){
    return _quantity * _itemPrice
}
```

继续重构

```java
double getPrice(){
    reeturn basePrice() * discountFactor();
}

...

private double discpuntFactor(){
    if(basePrice()>1000){
        return 0.95;
    }else{
        return 0.98;
    }
}
```

#### 引入解释性的变量

将复杂的表达式转换成临时变量来解释意图

重构前

```java
if(platform.toUpperCase().indexOf("MAC") > -1 &&
   brower.toUpperCase().indexOf("IE") > -1 &&
   wasInitialized() && resize > 0){
    // do something
   }
```

重构后

```java
final boolean isMacOS = platform.toUpperCase().indexOf("MAC") > -1;
final boolean isIEBrower = brower.toUpperCase().indexOf("IE") > -1;
final boolean wasResized = resize > 0;

if(isMacOS && isIEBrower && wasInitialized && wasResized){
    // do something
}
```

#### 分解临时变量


重构前的代码

```java
double temp = 2 * (_height + _width);
System.out.println(temp);
temp = _height * _width;
System.out.println(temp);
```

重构后

```java
final double perimeter = 2 * (_height + _width);
System.out.println(perimeter);
final double area = _height * _width;
System.out.println(area);
```

#### 移除对参数的赋值


```java
int discount (int inputVal, int quantity, int yearToDate){
    if(inputValue > 50){
        inputValue -= 2;
    }
}
```

以一个临时变量取代该参数的位置(Java只有按值传递)


```java
int discount (int inputVal, int quantity, int yearToDate){
    int result = inputVal;
    if(inputValue > 50){
        result -= 2;
    }
}
```

#### 以函数对象取代函数

```java
class Account {
    int gamma(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        //and so on
        return importantValue3 - 2 * importantValue1;
    }
}
```

将函数转变为一个函数对象

```java
class Account {
    int gamma(int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }
}


class Gamma{
    private final Account _account;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;

    public Gamma(Account _account, int inputVal, int quantity, int yearToDate) {
        this._account = _account;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }
    
    int compute(){
        importantValue1 = (inputVal * quantity) + delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
        importantValue3 = importantValue2 * 7;
        //and so on
        return importantValue3 - 2 * importantValue1;
    }
}
```

好处是很方便的对compute()进行重构，而不用担心参数传递的问题

```java
int compute(){
    importantValue1 = (inputVal * quantity) + delta();
    importantValue2 = (inputVal * yearToDate) + 100;
    importantThing();
    importantValue3 = importantValue2 * 7;
    //and so on
    return importantValue3 - 2 * importantValue1;
}

void importantThing(){
    if ((yearToDate - importantValue1) > 100) {
        importantValue2 -= 20;
    }
}
```


#### 替换算法

将函数本体替换为另一个算法

```java
String foundPerson(String[] people){
    for(int i=0;i<people.length;i++){
        if(people[i].equals("Don")){
            return "Don";
        }
        if(people[i].equals("John")){
            return "John";
        }
        if(people[i].equals("Kent")){
            return "Kent";
        }
    }
    return "";
}
```


重构后：

```java
String foundPerson(String[] people){
    List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
    for(int i=0;i<people.length;i++){
        if(candidates.contains(people[i])){
            return people[i];
        }
    }
    return "";
}
```

#### 搬移函数

如果一个类有太多行为或者一个类与另一个类有太多合作而形成的高度耦合，就会使用搬迁函数，即在最常
引用的类里面建立一个有着类似行为的新函数，将旧函数变成一个单纯的委托函数或者完全移除

```java
class Account {
    private AccountType _type;
    private int _daysOverdrawn;
    
    double overdraftCharge(){
        if(_type.isPermium()) {
            double result = 10;
            if (_daysOverdrawn > 7)
                result += (_daysOverdrawn - 7) * 0.85;
            return result;
        }else{
            return _daysOverdrawn * 1.75;
        }
    }
    
    double bankCharge(){
        double result = 4.5;
        if(_daysOverdrawn > 0){
            result += overdraftCharge();
        }
        return result;
    }
}
```


将overdraftCharge()搬迁到AccountType中

```java
class Account {
    private AccountType _type;
    private int _daysOverdrawn;

    double overdraftCharge(){
        return _type.overdraftCharge(_daysOverdrawn);
    }
    
    double bankCharge(){
        double result = 4.5;
        if(_daysOverdrawn > 0){
            result += overdraftCharge();
        }
        return result;
    }
}

class AccountType{
    double overdraftCharge(int daysOverdrawn){
        if(isPermium()) {
            double result = 10;
            if (daysOverdrawn > 7)
                result += (daysOverdrawn - 7) * 0.85;
            return result;
        }else{
            return daysOverdrawn * 1.75;
        }
    }
}
```

多个字段的情况下，传递Account给函数而不是只是参数

```java
class AccountType{
    double overdraftCharge(Account account){
        if(isPermium()) {
            double result = 10;
            if (account.getDaysOverdrawn() > 7)
                result += (account.getDaysOverdrawn() - 7) * 0.85;
            return result;
        }else{
            return account.getDaysOverdrawn() * 1.75;
        }
    }
}
```

#### 搬迁字段

在目标新类中创建一个字段，修改源字段的所有用户，让他们改用新字段


使用自我封装

```java
class Account {
    private AccountType _type;
    private double _interestRate;

    double interestForAmount_days(double amount, int day){
        return getInterestRate() * amount * days / 365;
    }

    public double getInterestRate() {
        return _interestRate;
    }

    public void setInterestRate(double _interestRate) {
        this._interestRate = _interestRate;
    }
}
```

搬迁字段之后需要修改访问函数


```java
class Account {
    private AccountType _type;
    private double _interestRate;

    double interestForAmount_days(double amount, int day){
        return getInterestRate() * amount * days / 365;
    }

    public double getInterestRate() {
        return _type.getInterestRate();
    }

    public void setInterestRate(double _interestRate) {
        _type.setInterestRate(_interestRate);
    }
}
```

#### 提炼类

建立一个新的类，将相关的字段的函数从旧类搬迁到新类，目的是为了明确每个类的职责

```java
class Person{
    private String _name;
    private String _officeAreaCode;
    private String _officeNumber;

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_officeAreaCode() {
        return _officeAreaCode;
    }

    public void set_officeAreaCode(String _officeAreaCode) {
        this._officeAreaCode = _officeAreaCode;
    }

    public String get_officeNumber() {
        return _officeNumber;
    }

    public void set_officeNumber(String _officeNumber) {
        this._officeNumber = _officeNumber;
    }
}
```

定义一个电话号码类，将相关行为进行分离

```java
class Person{
    private String _name;
    private String _officeAreaCode;

    private TelephoneNumber _officeTelephone = new TelephoneNumber();

    public String getTetephhoneNumber(){
       return  _officeTelephone.getTelePhoneNumber();
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_officeAreaCode() {
        return _officeAreaCode;
    }

    public void set_officeAreaCode(String _officeAreaCode) {
        this._officeAreaCode = _officeAreaCode;
    }
}
```

电话号码类需不需要修改，会不会存在事务并发问题，需要去考虑

#### 将类内联化

```java
class Person{
    private String _name;
    private String _officeAreaCode;

    private TelephoneNumber _officeTelephone = new TelephoneNumber();

    TelephoneNumber getOfficeTelephone(){
        return _officeTelephone;
    }
    
    public String getTetephhoneNumber(){
       return  _officeTelephone.getTelePhoneNumber();
    }
    
    // 隐藏细节
    void setAreaCode(String arg){
        _officeTelephone.set_areaCode(arg);
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_officeAreaCode() {
        return _officeAreaCode;
    }

    public void set_officeAreaCode(String _officeAreaCode) {
        this._officeAreaCode = _officeAreaCode;
    }

    class TelephoneNumber{
        private String _areaCode;
        private String _officeNumber;

        public String getTelePhoneNumber(){
            return _areaCode + _officeNumber;
        }

        public String get_areaCode() {
            return _areaCode;
        }

        public void set_areaCode(String _areaCode) {
            this._areaCode = _areaCode;
        }

        public String get_officeNumber() {
            return _officeNumber;
        }

        public void set_officeNumber(String _officeNumber) {
            this._officeNumber = _officeNumber;
        }
    }
}
```


#### 隐藏委托关系

```java
class Person{
    Department _department;
    
    public Department getDepartment(){
        return _department;
    }
    
    public void setDepartment(Department arg){
        this._department = arg;
    }
}
class Department{
    private String _chargeCode;
    private Person _manager;
    
    public Department(Person _manager){
        _manager = _manager;
    }
    
    public Person getManager(){
        return _manager;
    }
}
```

使用的时候
```java
manager = john.getDepartMent().getManager();
```

为了隐藏细节，在Person中建立委托韩素

```java
public Person getManager(){
    return _department.getManager();
}
```

修改后使用新函数

```java
manager = john.getManager();
```

#### 移除委托函数

上述方法虽然简单，但是如果大量函数需要这么做，会增加过多的委托关系
因此还是可以回到原来的方式

```java
class Person{
    Department _department;
    
    public Department getDepartment(){
        return _department;
    }
    
    public void setDepartment(Department arg){
        this._department = arg;
    }
}
class Department{
    private String _chargeCode;
    private Person _manager;
    
    public Department(Person _manager){
        _manager = _manager;
    }
    
    public Person getManager(){
        return _manager;
    }
}
```

使用的时候
```java
manager = john.getDepartMent().getManager();
```


#### 加入外加函数

为提供服务的类增加一个函数，但是你无法修改这个类

