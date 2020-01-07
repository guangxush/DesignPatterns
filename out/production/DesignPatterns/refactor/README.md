## 重构

### 面向对象的五大原则

面向对象的五大原则：

- 单一职责： 一个类只负责一个职责。 目的在于解耦增强内聚。
- 开闭原则：对于扩展是开放的，对于修改是关闭的。可利用多态、抽象类等实现扩展，超类不应该做改变。
- 里氏替换原则：子类必能代替父类。
- 依赖倒转原则：高层次的模块不应该依赖于低层次的模块，他们都应该依赖于抽象；抽象不应该依赖于具体实现，具体实现应该依赖于抽象
- 接口隔离原则：一个类对另一个类的依赖应该建立在最小的接口上，使用多个专门的接口比使用单一的总接口要好
- 迪米特原则（最小知识原则）：一个对象应当对其他对象有尽可能少的了解。


### 重构原则

重构的目的是使软件更容易被理解和修改，不会改变软件的可观察行为

### 代码的坏味道

- 重复代码： 提炼代码放到超类，提取模版函数，提取到独立类放在合适的地方

- 过长函数： 积极的分解函数，明确函数应该做什么， 当有大量的参数和临时变量时，可以将临时变量作为参数或者封装为对象，或者使用查询代替临时变量
处理好条件表达式和循环，将重复代码放到循环外面

- 过大的类：如果类中某些字段有着相同的前缀或者后缀，可以尝试提炼到一个新的类，如果类中代码重复可以提取超类，提取单独的类甚至提炼出一个接口，甚至将
领域模型与动作进行分类

- 过长的参数列表：可以创建一个参数对象，用内部字段替换参数，将参数抽取到方法中单独设置

- 发散式变化：如果修改一个地方需要同时修改多个地方，比如更换数据库。这种需要将这种行为提取到一个单独的类中

- 霰弹式修改：一种变化引起多个类相应的修改，可以使用内联类把相关行为放入同一个类

- 依恋情结：将数据和对数据的操作行为包装在一起，将大函数分解为小函数放置于不同的地点，将总是一起变化的东西放在一块

- 数据泥团： 两个类中使用了相同的字段或者签名，请找出这些字段出现的地方，减少字段和参数的个数，缩短参数列表，简化函数调用

- 基本类型偏执：对象模糊类基本数据类型和较大的类之间的界限，可以将成对出现的数据存成对象，或者将数据值转换成对象，提取超类，使用策略代替代码等

- switch: 少用switch，多用多态优雅的解决，一旦完成继承体系之后，如果仍需要switch还是可以用，如果存在一些选择实例，可以采用Null对象

- 平行继承体系：每当某个类需要增加一个子类的时候，另一个类也必须增加相应的子类，这种是平行继承，可以让一个继承体系的实例引用另一个体系的实例解决这种继承

- 冗余类： 对于几乎不会变化不被调用的类，可以用内联类解决

- 夸夸其谈未来性：如果抽象类作用不大，很多参数没有用，可以尝试委托，等未来值得做再去做

- 令人迷惑的暂时字段：如果参数列表很长，可以把参数放入字段中

- 过度耦合的消息链：A请求B，B请求C，耦合太多，在消息链的不同位置解耦，隐藏委托或者采用中间人的方式减少过长的消息链

- 中间人：过度使用委托导致某个类不干实事，可以采用内联类或者转换成实责对象的子类

- 狎昵关系：继承会造成类之间过度亲密，可以采用更多的方法或者字段划清界限

- 异曲同工的类：两个函数有着不同的签名但是做相同的使其，可以重命名并移动到新的类

- 不完美的库类：如果想修改库类的一两个函数，可以使用外部方法，如果需要添加一堆额外的行为要使用局部提取的方式

- 纯稚的数据类：注意字段是否需要public, 对不能修改的字段进行封装和隐藏，通过设置函数和取值函数灵活获取

- 被拒绝的遗赠：子类应该继承超类的函数和数据，如果不想被继承，可以下移字段或者方法，超类只保持共享的内容

- 过多的注释：将不清晰的代码加入注释，通过重构减少过多的注释


### 1.重新组织函数

#### 1.1提炼函数

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

3. 有局部变量的情况

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

4. 有参数的情况

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

#### 1.2内联函数

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

#### 1.3内联临时变量

重构前的代码

```java
double basePrice = anOrder.basePrice();
return (basePrice > 1000)
```

重构后的代码

```java
return anOrder.basePrice() > 1000;
```

#### 1.4以查询取代临时变量

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

#### 1.5引入解释性的变量

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

#### 1.6分解临时变量


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

#### 1.7移除对参数的赋值


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

#### 1.8以函数对象取代函数

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


#### 1.9替换算法

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

#### 1.10搬移函数

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

#### 1.11搬迁字段

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

#### 1.12提炼类

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

#### 1.13将类内联化

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


#### 1.14隐藏委托关系

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

#### 1.15移除委托函数

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


#### 1.16加入外加函数

为提供服务的类增加一个函数，但是你无法修改这个类

程序中需要跨过一个收费周期，代码像这样：

```java
Date newStart = new Date(prevoiusEnd.getYear(), prevoiusEnd.getMonth(), prevoiusEnd.getDate() + 1);
```

这个方法可能会被多次使用，因此我们提炼到一个单独的函数里面去使用

```java
private static Date newDay(Date arg){
    //foreign method, should be on date
    return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
}
```

#### 1.17引入本地扩展

声明一个包装类

```java
class MfDateWarp{
    private Date _original;
}
```

之前只是执行一个单纯的的委托动作

```java
public MfDateWrap(String dataString){
    _original = new Date(dataString);
}
```

转型的构造函数是对实例变量赋值

```java
public MfDataWrap(Date arg){
    _original = arg;
}
```

为所有的原始类提供委托函数

```java
public int getYear(){
    return _original.getYear();
}

public boolean equals(Object arg){
    if(this == arg){
        return true;
    }
    if(!(arg instanceof MyDateWrap)){
        return false;
    }
    MyDataWrap other = (MfDatWrap) arg;
    return (_original.equals(other._original));
}
```

### 2.重新组织数据


#### 2.1自封装字段

修改前的类
```java
class IntRange {

    private int _low;
    private int _high;

    boolean include(int arg) {
        return arg >= _low && arg <= _high;
    }
    
    void grow(int factor){
        _high = _high * factor;
    }
}

```


重构后的类：

```java
class IntRange {

    private int _low;
    private int _high;

    public int get_low() {
        return _low;
    }

    public void set_low(int _low) {
        this._low = _low;
    }

    public int get_high() {
        return _high;
    }

    public void set_high(int _high) {
        this._high = _high;
    }
    
    IntRange(int low, int high){
        initialize(low, high);
    }

    /**
     * 防止后面修改初始化的值
     * @param low
     * @param high
     */
    private void initialize(int low, int high){
        _low = low;
        _high = high;
    }

    boolean include(int arg) {
        return arg >= get_low() && arg <= get_high();
    }
    
    void grow(int factor){
        set_high(get_high() * factor);
    }
}
```

子类中对父类的方法进行访问时，封装可以体现出优势

```java
class CappedRange extends IntRange {

    private int _cap;

    CappedRange(int low, int high, int cap) {
        super(low, high);
        _cap = cap;
    }
    
    int get_cap(){
        return _cap;
    }

    /**
     * 不必修改IntRange的行为，即可定义范围上限
     * @return
     */
    int getHigh(){
        return Math.min(super.get_high(), get_cap());
    }
}
```

#### 2.2以对象取代数据值

订单类

```java
class Order {

    private String _customer;

    public Order(String customer) {
        _customer = customer;
    }

    public String get_customer() {
        return _customer;
    }

    public void set_customer(String _customer) {
        this._customer = _customer;
    }
    
    //使用过程过于冗余
    private static int numberOfOrdersFor(Collection orders, String customer){
        int result = 0;
        Iterator iter = orders.iterator();
        while(iter.hasNext()){
            Order each = (Order) orders.iterator();
            if(each.get_customer().equals(customer)){
                result ++;
            }
        }
        return result;
    }
}
```

将订单类中的客户单独提取出一个类

```java
class Order {

    private Customer _customer;

    public Order(String customer) {
        _customer = new Customer(customer);
    }

    public Customer get_customer() {
        return _customer;
    }
    
    public String getCustomerName(){
        return _customer.get_name();
    }

    public void set_customer(String _customer) {
        this._customer = new Customer(_customer);
    }
}

class Customer{
    private final String _name;

    public Customer(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }
}
```


#### 2.3将值对象改为引用对象


一个客户拥有不同的订单，多个订单共享同一个Customer时，需要在Customer中创建工厂函数。


```java
class Order {

    private Customer _customer;

    public Order(String customer) {
        _customer = Customer.create(customer);
    }

    public Customer get_customer() {
        return _customer;
    }

    public String getCustomerName(){
        return _customer.get_name();
    }

    public void set_customer(String _customer) {
        this._customer = Customer.create(_customer);
    }
}

class Customer{
    private final String _name;
    
    public static Customer create(String name){
        return new Customer(name);
    }

    //声明为私有的
    private Customer(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }
}
```

在程序启动的时候进行初始化，修改为工厂模式

```java
class Customer {
    private  String _instance;

    public static Customer create(String name) {
        return new Customer(name);
    }

    //声明为私有的
    private Customer(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }

    static void loadCustomers() {
        new Customer("Lemon Car Hire").store();
        new Customer("Lemon Car Hire").store();
        new Customer("Lemon Car Hire").store();
    }

    private void store() {
        _instance.put(this.get_name(), this);
    }
    
    //用它返回既有的对象
    public static Customer getNamed(String name){
        return (Customer)_instance.get(name);
    }
}
```

#### 2.4将引用对象改为值对象

货币种类

```java
class Currency{
    private String _code;

    private Currency(String _code) {
        this._code = _code;
    }

    public String get_code() {
        return _code;
    }
}
```

获取货币类型的实例：

```java
Currency usd = Currency.get("USD");
```

要把一个对象变成值对象，要检查它是否可变，可变的对象会造成别名问题 ，因此为他定义equals

```java
class Currency{
    private String _code;

    public Currency(String _code) {
        this._code = _code;
    }

    public String get_code() {
        return _code;
    }

    @Override
    public boolean equals(Object arg){
        if(!(arg instanceof Currency)){
            return false;
        }
        Currency other = (Currency) arg;
        return (_code.equals(other._code));
    }
}
```

同时也要定义hashcode方法
```java
@Override
public int hashCode(){
    return _code.hashCode();
}
```


#### 2.5以对象取代数组

```java
String[] row = new String[3];
row[0] = "Hello";
row[1] = "15";
```

取代之后的
```java
Performance row = new Performance();
row.setName("Hello");
row.setWins("15");
int wins= row.getWins();
```

#### 2.6复制""被监视数据"

将代码分类为模型-视图-控制器

```java
public class IntervalWindows extends Frame {
    TextField stratField;
    TextField endField;
    TextField lengthField;

    class SysFocus extends FocusAdapter {
        @Override
        public void focusLost(FocusEvent event) {
            Object obejct = event.getSource();
            if (obejct == stratField) {

            }
        }
    }
    
    //设置开始值
    void startFieldFocusLost(FocusEvent event) {
        if (isNotInteger(stratField.getText())) {
            stratField.setText("0");
        }
        calculateLength();
    }

    //设置结束值
    void endFieldFocusLost(FocusEvent event) {
        if (isNotInteger(stratField.getText())) {
            stratField.setText("0");
        }
        calculateLength();
    }

    //设置长度
    void lengthFieldFocusLost(FocusEvent event) {
        if (isNotInteger(stratField.getText())) {
            stratField.setText("0");
        }
        calculateEnd();
    }

    private boolean isNotInteger(String text) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(text).matches();
    }

    //计算长度
    void calculateLength() {
        try {
            int start = Integer.parseInt(stratField.getText());
            int end = Integer.parseInt(endField.getText());
            int length = end - start;
            lengthField.setText(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Number format Error");
        }
    }

    //计算结束位置
    void calculateEnd() {
        try {
            int start = Integer.parseInt(stratField.getText());
            int length = Integer.parseInt(lengthField.getText());
            int end = start + length;
            endField.setText(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Number format Error");
        }
    }
}
```

将上述与显示无关的代码抽离出来, 采用观察者模式对时间进行监听

```java
public class IntervalWindows extends Frame implements Observer {
    TextField stratField;
    TextField endField;
    TextField lengthField;

    Interval subject = new Interval();

    subject.addObserver(this);
    
    @Override
    public void update(Observable observed, Object arg) {
        endField.setText(subject.getEnd());
    }

    String getEnd() {
        return subject.getEnd();
    }

    void setEnd(String arg) {
        subject.setEnd(arg);
    }

    class SysFocus extends FocusAdapter {
        @Override
        public void focusLost(FocusEvent event) {
            Object obejct = event.getSource();
            if (obejct == stratField) {

            }
        }
    }

    void startFieldFocusLost(FocusEvent event) {
        if (isNotInteger(stratField.getText())) {
            stratField.setText("0");
        }
        calculateLength();
    }

    void endFieldFocusLost(FocusEvent event) {
        setEnd(endField.getText());
        if (isNotInteger(stratField.getText())) {
            stratField.setText("0");
        }
        calculateLength();
    }

    void lengthFieldFocusLost(FocusEvent event) {
        if (isNotInteger(getEnd())) {
            setEnd("0");
        }
        calculateEnd();
    }

    private boolean isNotInteger(String text) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(text).matches();
    }

    void calculateLength() {
        try {
            int start = Integer.parseInt(stratField.getText());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            setEnd(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Number format Error");
        }
    }

    void calculateEnd() {
        try {
            int start = Integer.parseInt(stratField.getText());
            int length = Integer.parseInt(getEnd());
            int end = start + length;
            endField.setText(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Number format Error");
        }
    }
}

class Interval extends Observable {
    private Interval subject;

    private String end = "0";
    
    String getEnd(){
        return end;
    }
    
    void setEnd(String arg){
        end = arg;
        setChanged();
        notifyObservers();
    }
}
```


#### 2.7将单向关联改为双向关联

添加一个反向指针，并使修改函数能够同时更新两条连接

```java
class Order {

    private Customer customer;

    Customer getCustomer() {
        return customer;
    }

    void setCustomer(Customer arg) {
        if (customer != null) {
            customer.friendOrders().remove(this);
        }
        customer = arg;
        if (customer != null) {
            customer.friendOrders().add(this);
        }
    }
}
```

订单和客户是多对对的关系

```java
class Order {

    private Customer customer;

    Customer getCustomer() {
        return customer;
    }

    void setCustomer(Customer arg) {
        if (customer != null) {
            customer.friendOrders().remove(this);
        }
        customer = arg;
        if (customer != null) {
            customer.friendOrders().add(this);
        }
    }
    
    void addOrder(Order arg){
        arg.setCustomer(this);
    }
    
}

class Customer {
    private Set order = new HashSet();

    //添加一个辅助函数，让Order直接访问_orders集合
    Set friendOrders() {
        return order;
    }

    void addOrder(Order arg){
        arg.addCustomer(this);
    }

    void removeOrder(Order arg){
        arg.removeCustomer(this);
    }
}
```

#### 2.8将双向关联改为单向关联

原来的例子
```java
class Order {

    private Customer customer;

    Customer getCustomer() {
        return customer;
    }

    double getDiscountedPrice(){
        return getGrossProce() * (1 - customer.getDiscount());
    }
    
}
```

现在的例子 将Customer作为参数传进去

```java
class Order {


    Customer getCustomer() {
        return customer;
    }

    double getDiscountedPrice(Customer customer){
        return getGrossProce() * (1 - customer.getDiscount());
    }
    
}
```


#### 2.9以字面常量取代魔法数

```java
double potentialEnergy(double mass, double heigh){
    return masss * 9.81 * heigh;
}
```

```java
static final double CONSTANT = 9.81;
double potentialEnergy(double mass, double heigh){
    return mass * CONSTANT * heigh;
}
```

#### 2.10封装字段

```java
public String name;
```

把它封装为字段并提供相应的访问函数

```java
private String name;
public String getName(){
    return name;
}
public void setName(String arg){
    name = arg;
}
```


#### 2.11封装集合

```java
class Person {
    private Vector courses;

    public Vector getCourses(){
        return courses;
    }

    public void setCourses(Vector args){
        courses = args;
    }
}
```

修改为

```java
class Person {
    private Vector courses = new Vector();

    public void addCourse(Course arg){
        courses.addElement(arg);
    }

    public void removeCourse(Course arg){
        courses.removeElement(arg);
    }
}
```

原来

```java
kent.getCourse().addElement(new Course("scra", false));
```

修改为

```java
kent.addCourse(new Course("scra", false));
```

#### 2.12以数据类取代记录

```java
class Person {
    public static final int O = Bloo;
    public static final int A = 1;
    public static final int B = 2;
    public static final int AB = 3;
    
    private int bloodGroup;
    
    public Person(int bloodGroup){
        this.bloodGroup = bloodGroup;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(int bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
```

建立一个血型类用以表示血型

```java
class BloodGroup {
    public static final BloodGroup O = new BloodGroup(0);
    public static final BloodGroup A = new BloodGroup(1);
    public static final BloodGroup B = new BloodGroup(2);
    public static final BloodGroup AB = new BloodGroup(3);

    public static final BloodGroup[] values = {O, A, B, AB};
    
    private final int code;

    public BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BloodGroup code(int arg) {
        return values[arg];
    }
}
```

修改后的Person类

```java
class Person {
    public static final int O = BloodGroup.O.getCode();
    public static final int A = BloodGroup.A.getCode();
    public static final int B = BloodGroup.B.getCode();
    public static final int AB = BloodGroup.AB.getCode();

    private int bloodGroup;

    public Person(int bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(int bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
```

继续简化Person代码
```java
class Person {

    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    
    public Person(BloodGroup bloodGroup){
        bloodGroup = bloodGroup;
    }
}

class BloodGroup {
    public static final BloodGroup O = new BloodGroup(0);
    public static final BloodGroup A = new BloodGroup(1);
    public static final BloodGroup B = new BloodGroup(2);
    public static final BloodGroup AB = new BloodGroup(3);

    public static final BloodGroup[] values = {O, A, B, AB};

    private final int code;

    public BloodGroup(int code) {
        this.code = code;
    }
    
    //不会在使用了
    private int getCode() {
        return code;
    }

    private static BloodGroup code(int arg) {
        return values[arg];
    }
}

```


#### 2.13以子类取代类型码

 
原来的代码
  
```java
class Employee{
    private int type;

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    Employee(int type){
        this.type = type;
    }

    int getType(){
        return type;
    }
}
```

建立一个子类
```java
class Enginner extends Employee{
    Enginner(int type) {
        super(type);
    }

    @Override
    int getType(){
        return Employee.ENGINEER;
    }
}
```

修改工厂函数，让其返回合适的对象

```java
abstract class Employee{
    private int type;

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    Employee(int type){
        this.type = type;
    }
    
    static Employee create(int type){
        switch (type){
            case ENGINEER:
                return new Enginner();
            case SALESMAN:
                return new Saleman();
            case MANAGER:
                return new Manager();
            default:
                throw new IllegalArgumentException("incorrect type code");
        }
    }

    abstract getType();
}
```

#### 2.14以State/Strategy取代类型码

```java
abstract class Person {

   abstract boolean isMale();
   abstract char getCode();

}

class Male extends Person{

    @Override
    boolean isMale() {
        return true;
    }

    @Override
    char getCode() {
        return 'M';
    }
}

class Female extends Person{

    @Override
    boolean isMale() {
        return false;
    }

    @Override
    char getCode() {
        return 'F';
    }
}
```

为每个子类建立一个工厂函数

```java
class Person {

   private final boolean isMale;
   private final char code;

    Person(boolean isMale, char code) {
        this.isMale = isMale;
        this.code = code;
    }
}

class Male extends Person{

    Male() {
        super(true, 'M');
    }
}

class Female extends Person{

    Female() {
        super(false, 'F');
    }
}
```


### 3.简化条件表达式

#### 3.1分解条件表达式

```java
if(date.before(SUMMER_START) || date.fater(SUMER_END)){
    charge = quantity * winterRate * winterServiceCharge;
}else{
    charge = quantity * summerRate;
}
```

转换成

```java
if(noSummer(date)){
    charge = winterCharge(quantity);
}else{
    charge = summerCharge(quantity);
}
```

提高代码的可读性

#### 3.2合并条件表达式

```java
double disabilityAmount(){
    if(seniority < 2) return 0;
    if(monthsDisabled > 12) return 0;
    if(isPartTime) return 0;
}
```

转换为

```java
double disabilityAmount(){
    if(isNotEligableForDisability()) reeturn 0;
}

boolean isNotEligableForDisability(){
    return (seniority < 2 || monthsDisabled > 12 || isPartTime);
}
```

#### 3.3合并重复的条件片段

```java
if(isSpecialDeal()){
    total = price * 0.15;
    send();
}else{
    total = price * 0.18;
    send();
}
```

将重复代码搬移到表达式之外

```java
if(isSpecialDeal()){
    total = price * 0.15;
}else{
    total = price * 0.18;
}
send();
```

#### 3.4移除控制标记

```java
void checkSecurity(String[] people){
    boolean flag = false;
    for(int i=0;i<people.length;i++){
        if(!found){
            if(people[i].equals("Don")){
                sendAlert();
                found = true;
            }
            if(people[i].equals("John")){
                sendAlert();
                found = true;
            }
        }
    }
}
```

增加break移除控制标记

```java
void checkSecurity(String[] people){
    boolean flag = false;
    for(int i=0;i<people.length;i++){
        if(!found){
            if(people[i].equals("Don")){
                sendAlert();
                break;
            }
            if(people[i].equals("John")){
                sendAlert();
                break;
            }
        }
    }
}
```

继续移除

```java
void checkSecurity(String[] people){
    boolean flag = false;
    for(int i=0;i<people.length;i++){
        if(people[i].equals("Don")){
            sendAlert();
            break;
        }
        if(people[i].equals("John")){
            sendAlert();
            break;
        }
    }
}
```

以return返回控制标记

```java
void checkSecurity(String[] people){
    String found = "";
    for(int i=0;i<people.length;i++){
        if(found.equals("")){
            if(people[i].equals("Don")){
                sendAlert();
                found = "Don";
            }
            if(people[i].equals("John")){
                sendAlert();
                found = "John";
            }
        }
    }
    someLayerCode(found);
}
```

修改为如下代码

```java
String foundMisCrent(String[] people){
    for(int i=0;i<people.length;i++){
        if(found.equals("")){
            if(people[i].equals("Don")){
                sendAlert();
                return "Don";
            }
            if(people[i].equals("John")){
                sendAlert();
                return "John";
            }
        }
    }
    return "";
}
```

#### 3.5以卫语句取代嵌套的条件表达式

```java
double getPayAmount(){
    double result;
    if(isDead) result = deadAmount();
    else{
        if(isSeparated) result = separatedAmoint();
        else{
            if(isRetired) result = retiredAmount();
            else result = normalPayAmount();
        }
    }
    return result;
}
```

修改后

```java
double getPayAmount(){
    if(isDead) return deadAmount();
    if(isSeparated) return separatedAmoint();
    if(isRetired) return retiredAmount();
    return normalPayAmount();
}
```

#### 3.6以多态取代条件表达式

```java
class Employee{

    int payAmount(){
        switch (getType()){
            case EmployeeType.ENGINEER:
                return monthSalray;
            case EmployeeType.SALESMAN:
                return monthSalray + commission;
            case EmployeeType.MANAGER:
                return monthSalray + bonus;
            default:
                throw new IllegalArgumentException("incorrect type code");
        }
    }

    ...
}
```

将其放入EmployeeType中

```java
class EmployeeType{
    int payAmount(Employee emp){
        switch (getType()){
            case EmployeeType.ENGINEER:
                return emp.getMonthSalray();
            case EmployeeType.SALESMAN:
                return emp.getMonthSalray() + emp.getCommission();
            case EmployeeType.MANAGER:
                return emp.getMonthSalray() + emp.getBonus();
            default:
                throw new IllegalArgumentException("incorrect type code");
        }
    }
}
```

将计算的方式放到子类中

```java
class Saleman extends Employee{
    int payAmount(Employee emp){
        return emp.getMonthSalary() + emp.getCommission();
    }
}
```

#### 3.7引入Null对象

判断null的表达式太多了

```java
Customer customer = site.getCustomer();
BillingPlan plan;
if(customer == null){
    plan = BillingPlan.basic();
}else{
    plan = customer.getPlan();
}
...
```

新建一个NullCustomer并修改为Customer,使其支持"对象是否为null的检测"

```java
class NullCustomer extends Customer{
    public boolean isNull(){
        return true;
    }
}

class Customer{
    public boolean isNull(){
        return false;
    }
}
```

#### 3.8引入断言

```java
double getExpenseLimit(){
    return (expenseLimit != NULL_EXPENSE) ? expenseLimit : primaryProject.getMemberExpenseLimit();
}
```

加入断言之后

```java
double getExpenseLimit(){
    Assert.isTrue(expenseLimit != NULL_EXPENSE || primaryProject!=null);
    return (expenseLimit != NULL_EXPENSE) ? expenseLimit : primaryProject.getMemberExpenseLimit();
}
```


### 4.简化函数调用

#### 4.1函数改名

```java
public String getTelePhoneNumber(){
    return "(" + officeAreaCode + ")" + officeNumber;
}
```

建立新函数把原来函数代码换过来或直接调用

```java
class Person{
    public String getTelephoneNumber(){
        return getTelePhoneNumber(); 
    }
}
```

#### 4.2添加参数

```java
public int getContact(){
    ....
}
```

修改参数

```java
public int getContact(Date date){
    ....
}
```

#### 4.3移除参数

```java
public int getContact(){
    ....
}
```

#### 4.4将查询函数与修改函数分离

```java
String foundMiscreant(String[] people){
    for(int i=0;i<people.length;i++){
        if(people[i].equals("Don")){
            sendAlert();
            return "Don";
        }
        if(people[i].equals("John")){
            sendAlert();
            return "John";
        }
    }
    return "";
}
```

该函数将被如下方法调用

```java
void checkSecurity(String[] people){
    String found = foundMiscreat(people);
    someLateCode(found);
}
```

现在将alert和find函数分离

```java
String foundMiscreant(String[] people){
    for(int i=0;i<people.length;i++){
        if(people[i].equals("Don")){
            return "Don";
        }
        if(people[i].equals("John")){
            return "John";
        }
    }
    return "";
}
```

alert函数

```java
void alert(){
    for(int i=0;i<people.length;i++){
        if(people[i].equals("Don")){
            sendAlert();
            return;
        }
        if(people[i].equals("John")){
            sendAlert();
            return;
        }
    }
}
```

#### 4.5令函数携带参数

```java
class Employee{
    void tenPercentRaise(){
        salary *= 1.1;
    }
    void fivePercentRaise(){
        salary *= 1.05;
    }
}
```

修改后：

```java
void raise(double factor){
    salary *= (1 + factor);
}
```

#### 4.6以明确函数取代参数

```java
void setValue(String name, int value){
    if(name.equals("heigh")){
        height = value;
        return;
    }
    if(name.equals("weight")){
        weight = value;
        return;
    }
}
```

修改为

```java
void setHeight(int arg){
    height = arg;
}
void setWeight(int arg){
    weigt = arg;
}
```

#### 4.7保证对象完整

```java
int low = daysTempRange().getLow();
int high = daysTempRange().getHight();
withinPlan = plan.withinRange(low, high);
```

直接传入对象

```java
withinPlan = plan.withinRange(daysTempRange());
```

#### 4.8以函数取代参数

```java
int basePrice = quantity * itemPrice;
discountLevel = getDiscountLevel();
double finalPrice = discountedPrice(basePrice, discountLevel);
```
让参数接收者去除该项参数，并直接调用前一个函数

```java
int basePrice = quantity * itemPrice;
double finalPrice = discountedPrice(basePrice);
```

#### 4.9引入参数对象

```java
Entry(Date satrt, Date end){
    ....
}
```

使用范围对象取代start和end

```java
Class DateRange{
    DateRange(Date strat, Date end){
        start = strat;
        end = end;
    }
}
Entry(DateRange){
    ....
}
```

#### 4.10移除设值函数

```java
class Account{
    private String id;
    Account(String id){
        setId(id);
    }
    
    void setId(String arg){
        id = arg;
    }
}
```

如果setId不会被使用可以去掉

```java
class Account{
    private String id;
    Account(String id){
        setId(id);
    }
}
```

或者

```java
class Account{
    private String id;
    Account(String id){
        initializedId(id);
    }
    
    private void initializedId(String arg){
        id = "ZZ" + arg;
    }
}
```

#### 4.11隐藏函数

降低函数的可见性

#### 4.12以工厂函数取代构造函数

```java
Employee(int type){
    type = type;
}
```

修改为工厂模式

```java
static Emplyee create(int type){
    return new Employee(type);
}
```

#### 4.13封装向下转型

```java
Object lastReading(){
    return reading.lastElement();
}
```

```java
Reading lastReading(){
    return (Reading)reading.lastElement();
}
```

#### 4.14以异常取代错误码

```java
int withdraw(int amount){
    if(amount > balance){
        // -1表示错误码
        return -1;
    }else{
        balance -= amount;
        return 0;
    }
}
```

改用异常

```java
void withdraw(int amount) throws BalanceException{
    if(amount > balance){
        throw new BalanceException();
    }
    balance -= amount;
}
```

#### 4.15以测试取代异常

```java
double getValueForPeriod(int periodNumber){
    try{
        return values[periodNumber];
    }catch(ArrayIndexOutOfBoundsException e){
        return 0;
    }
}
```

修改调用者，使他在调用之前先做检查

```java
double getValueForPeriod(int periodNumber){
    if(periodNumber >= values.length)  return 0;
    return values[periodNumber];
}
```


### 5.处理概括关系

#### 5.1字段上移

两个子类拥有相同的字段，可以将该字段上移到超类

#### 5.2函数上移

如果函数在不同的子类产生完全相同的结果，可以上移到超类

#### 5.3构造函数本体上移

在子类中有一些构造函数跟本体完全一致

```java
public Manager(String name, String id, int grade){
    super(name, id);
    grade = grade;
}
```

#### 5.4函数下移

超类中某个函数只与一部分子类相关，将这个函数下放到相关的子类中

#### 5.5字段下移

超类中的字段只被部分子类使用，下放到子类中

#### 5.6提炼子类

新建一个类，将部分特征提取到子类中

#### 5.7提炼超类

为两个类似的类提炼一个超类，将相同的特征放入超类

#### 5.8提炼接口

将相同的子集提炼到一个独立的接口中

#### 5.9折叠继承体系

超类和子类无太大的区别，将他们合为一体

#### 5.10塑造模板函数

有一些子类，其中相应的某些函数以相同的顺序执行类似的操作，但是各个操作细节上有所不同，将这些函数分别放入独立的函数中，并保持同样的签名，然后将这些函数上移到超类

#### 5.11以委托取代继承

在子类中新建一个字段用以保存超类，调整子类函数，令他改为委托函数，然后去掉两者的继承关系

继承并不是最有效的方式，尤其对于超类中不适用于子类的情况。

#### 5.12以继承取代委托

如果在两个类之间需要太多的委托关系，并经常为了整个接口编写过多的委托函数时，可以采用继承代替委托类


### 6.大型重构

#### 6.1梳理并分解继承体系

建立两个继承体系，并通过委托让其中一个调用另一个

#### 6.2将过程化设计转换为对象设计

将数据记录变成对象，将大块行为切分成小块，并将行为移动到相关的对象中

#### 6.3将领域与表达/显示分离

采用MVC的设计模式进行解耦

#### 6.4提炼继承体系

建立继承体系，以一个子类表示一种特殊情况




