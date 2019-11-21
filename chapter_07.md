### 第七章   复用类 ###
--------------------------


##### 7.1 组合语法  

1. 什么是组合语法？  
在一个类中，定义引用使用其他对象的方式，就是组合语法


2. 引用初始化的位置  

* 在定义对象的地方(这种初始化会在构造器初始化之前执行)  
```
public class Bath {
    private String s1 = "Happy";  //在定义对象的地方初始化

    public Bath() {
        this.s1 = "Happy2";    //后执行 
    }
}
```

* 在类的构造器中  
```
public class Bath {
    private String s;

    public Bath() {
        this.s = "hello";    //在类的构造器中初始化
    }
}
```

* 在使用对象的地方(惰性初始化，其实该对象并不是每次都要生存，此种方式减少额外负担)  
```
public class Bath {
    public String s; //定义的地方未初始化，其实编译器默认初始化为 null

    public Bath() {
        //构造函数中未对s进行初始化  
    }

    public void printBath() {
        this.s = "hello";    //使用时初始化
        Sysout.Out.Println(this.s);
    }
}
```


##### 7.2 继承语法

1. 写法  
```
//Child类，继承了Father类
class Father {
    private String name;

    // 构造器 
    public Father() {
        this.name = "hello";
    }
    
    // 私有型方法:  只能在本类中被使用
    private String p1() {
        return this.name
    }  

    // 保护型方法:  只能本类，子类中被使用
    protected String p2() {
        return this.name
    }  

    // 无权限修饰符方法: 只能在包（package）中被使用
    String p3() {
        return this.name
    }  

    // 公有型方法:  最大权限，都可以使用
    public String p4() {
        return this.name
    }  

}

// 继承的写法，使用extends关键字, 父类的哪些方法或属性在子类中可以使用，主要看权限修饰符
public class Child extends Father {
    //.....
}

```

2. 初始化基类  

* 导出类(子类)继承了基类(父类), 在生成导出类对象时，会涉及到导出类和基类的初始化顺序，Java的顺序是先初始化基类，再初始化导出类。示例代码如下：   
```
class Art {
    Art() {
        System.out.println("Art Constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        Sysout.out.println("Drawing Constructor");
    }
}

public class Cartoon extends Drawing {
    Carton() {
        System.out.println("Cartonn Constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();    
    }
}


//输出结果为：
Art Constructor
Drawing Constructor
Cartoon Constructor
```

* 带参数的构造器  
```
//如果基类没有默认的无参构造器，则导出类必须使用super显示的调用基类的构造方法，示例为：

class Game {
    public Game(int i) { 
        System.out.println("Game Constructor"); 
    }
}


class BoardGame extends Game {
    public BoardGame(int i) {
        super(i);
        System.out.println("BoardGame Constructor");
    }
}
```




##### 7.3 代理  

1. 代理的介绍
* Java没有直接提供代理功能，而是通过继承，组合等方式实现代理的功能  

* 代理的作用：
  假定被代理类A有4个方法可以提供对外使用，因需求和权限控制等原因， 需要将代理类A中的2个方法提供出来，同时需要增加新的1个方法，此时就可以新增一个代理类B，B的功能是代理A提供原2个方法，同时新增1个方法。
```
public class A {
    public void A1() {}
    public void A2() {}
    public void A3() {}
    public void A4() {}
}

public class B {
    A a = new A(); //示例化被代理类

    public void A1() { a.A1(); } //提供A1功能
                                 //屏蔽了A2功能
    public void A3() { a.A3(); } //提供A3功能
                                 //屏蔽了A4功能
    
    public void B1() { ... } //提供新增的B1功能
} 
```


##### 7.4 结合使用组合和继承

1. 示例代码  
```
// 基类
class Plate {
    Plate(int i) {
        System.out.println("Plate Constructor.");
    }
}

// 继承
class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i); //初始化基类的构造方法
        System.out.println("DinnerPlate Constructor.");
    }
}

// 基类
class Utensil {
    Utensil(int i) {
        System.out.println("Utensil Constructor.");
    }
}

// 继承
class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        System.out.println("Spoon Constructor.");
    }
}

// 继承
class Fork extends Utensil {
    Fork(int i) {
        super(i);
        System.out.println("Fork Constructor.");
    }
}

// 继承
class Knife extends Utensil {
    Knife(int i) {
        super(i);
        System.out.println("Knife Constructor.");
    }
}

// 基类
class Custom {
    Custom(int i) {
        System.out.println("Custom Constructor.");
    }
}

// 继承
public class PlaceSetting extend Custom {
    // 定义“引用”
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public PlaceSetting(int i) {
        // 初始化基类的构造函数
        super( i+1 );
        
        // 初始化组合的对象 
        sp = new Spoon( i+2 );
        frk = new Fork( i+3 );
        kn = new Knife( i+4 );
        pl = new DinnerPlate( i+5 );

        System.out.println("PlaceSetting Constructor.");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
}
```

2. 确保清理  
* 基类中有需要清理的内容，继承(extends)基类的导出类应该如何处理，示例：  
```
// 基类(含清理方法)
class Shape {
    Shape(int i) {
        System.out.println("Shape constructor");
    }
    void dispose() {
        System.out.println("Shape dispose");
    }
}

// 导出类(继承基类，同时重写了清理方法dispose()
class Circle extends Shape {
    Circle(int i) {
        super(i);
        System.err.println("Drawing Circle");
    }
   
    //清理 
    void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}


// 再使用的时候，用try{} finally{}对资源进行初始化，如
Circle c = new Circle(10);
try{
   //...逻辑处理 
} finally {
    c.dispose(); //同时完成了Circle、Shape类的清理
}
```


3. 屏蔽名字  
```
package com.jacky.ThinkingInJava;

// 基类中定义了两个名称相同，但是参数列表不同的方法（多态）
class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }
    
    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class MilHouse {}

class Bart extends Homer {
    // 继承了基类，同时又增加了一个名称相同，参数列表不同的方法
    // 到这个时候，doh方法就有了三个不同形式的参数列表了，也就是三个不同的方法
    //注意：这里是不可以使用@override，基类中没有相同的方法（返回值、方法名、参数列表都相同）
    void doh(MilHouse m) {
        System.out.println("doh(MilHouse)");
    }
    
    //这里可以使用@override，因为基类中有相同的方法（返回值、方法名、参数列表都相同），因此可以重载
    @Override
    char doh(char x) {
        System.out.println("doh(char)-@override");
        return 'x';
    }
}

public class Hide {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Bart b = new Bart();
        
        b.doh(1);
        b.doh('x');  //该方法被子类重载了
        b.doh(1.0f);
        b.doh(new MilHouse());
    }
}

//输出：
doh(float)
doh(char)-@override
doh(float)
doh(MilHouse)
```


##### 7.6 在组合与继承间选择  

1. 再此说明组合，继承是什么？  
* 组合：在一个类中，定义引用使用其他对象的方式，就是组合语法
* 继承: 使用extends关键字，导出类继承基类功能 

2. 如何选择  
* **新类**只是希望使用**现有类**的功能，用于实现新类本身的功能，而并不需要使用现有类的接口，此时使用**组合技术**
* **新类**使用某个**现有类**，并开发它的一个新版本，此时使用**继承技术** 
