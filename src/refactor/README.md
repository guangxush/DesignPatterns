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