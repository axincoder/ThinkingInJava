### 第九章   接口 ###
--------------------------


##### 9.1 抽象类和抽象方法  
1. 抽象方法  
* Java中提供了一种**只有申明，没有实现的方法，叫做抽象方法**  
* 抽象方法的申明格式为：  
```
abstract void f();
```

2. 抽象类  
* 如果一个类中包涵一个或多个抽象方法，该类应该被限定为**抽象类**, 抽象类是不允许创建对象的    
* 没有抽象方法的类，也可以申明为抽象类，但是这个类不可以创建对象  
* 如果一个导出类继承于一个抽象类，如果该继承类需要创建对象，该导出类必须实现所有的抽象方法 
* 抽象类的申明格式:  
```
abstractr class Test {

}
```



##### 9.2 接口
1. 接口  
* interface定义的类为**接口**，接口是一个只有定义，没有实现的抽象的类  
* 接口中可以定义成员变量，默认是static和final的，在定义的时候必须初始化    
* 接口中的定义的方法，可以显式的指定为public类型，即使不申明为public，默认也是public  
* 使用implements要一个类遵循一个多多个接口  


##### 9.3 完全解耦  


##### 9.4 Java的多重继承  
1. Java支持**多继承接口**，只支持**单继承类**  

2.示例代码：  
```
package com.jacky.interfaces.multi;

/*
 * 定义三个接口
 */
interface CanFight {
    void fight();
};

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

/*
 * 定义一个类，这个类有fight()方法的实现
 */
class ActionCharacter {
    public void fight() {
    }
}

/*
 * 定义一个类，继承ActionCharacter，实现CanFight、CanSwim、CanFly
 */
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void fly() {
        // TODO Auto-generated method stub
    }

    @Override
    public void swim() {
        // TODO Auto-generated method stub
    }

    /*
     * 三个接口，有三个需要实现的方法，但Hero实现了两个即可，因为有一个被其基类ActionCharacter实现
     */

}

public class Adventure {
    
    public static void t(CanFight x) {
        x.fight();
    }
    public static void u(CanSwim x) {
        x.swim();
    }
    public static void v(CanFly x) {
        x.fly();
    }
    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        
        t(h);
        u(h);
        v(h);
        w(h);

    }

}
```


##### 9.5 通过继承类扩展接口  
1. 通过继承在新接口中扩展接口  
```
package com.jacky.interfaces.multi;

//第一个接口
interface Monster {
    void menace();
}
//第二个接口，通过继承扩展接口，注意哦，这里用的是extends关键字
interface DangerousMonster extends Monster {
    void destory();
}
//第三个接口
interface Lethal {
    void kill();
}
//第四个接口，通过继承，继续扩展接口
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

/*
 * 定义第一个实现类(根据接口扩展，需要实现2个方法）
 */
class DragonZilla implements DangerousMonster {

    @Override
    public void menace() {}
    
    @Override
    public void destory() {}
    
}

/*
 * 定义一个实现类（根据接口扩展，需要实现4个方法）
 */
class VeryBadVampire implements Vampire {

    @Override
    public void destory() {}

    @Override
    public void menace() {}

    @Override
    public void kill() {}

    @Override
    public void drinkBlood() {}
    
}


public class HorrorShow {

}
```


2. 组合接口时的名字冲突  
* 在实现多重继承时，如果方法仅仅返回类型不同（其他都一样），这样时无法识别的。  
```
package com.jacky.interfaces.multi;

interface I1 {
    void f();
}
interface I2 {
    int f(int i);
}
interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {
    public void f() {}
    
    public int f(int i) {
        return 1;
    }
}

class C3 extends C implements I2 {
    public int f(int i) {
        return 1;
    }
}

class C4 extends C implements I3 {
    /*
     * 继承关系：
     * 1、C：public int f()
     * 2、I3:int f();
     */
    public int f() {
        System.out.println("C4");
        return 1;
    }
}

class C5 extends C implements I1 {
    /*
     * 这种继承、实现的方式是有问题的，原因为：
     * 1、C中有方法：public int f()
     * 2、I1中有接口：void f();
     * C中的int f()与I1中的void f()只有返回类型不同，编译器无法通过
     */
}


public class InterfaceCollision {
    public static void main(String[] args) {
        C c1 = new C();
        C2 c2 = new C2();
        C3 c3 = new C3();
        C4 c4 = new C4();

    }
}
```



##### 9.6 适配器接口  
1. 接口最吸引人的地方就是允许同一个接口有不同的具体实现  

2. 接口的一种常见用法就是**策略设计模式**  


##### 9.7 接口中的域  
1. 接口中的任何成员变量自动为 public & static & final，因此接口成为一种便捷的创建常量组的工具，示例：  
``` 
import java.util.Random;

//接口可以便捷的创建常量工作
//接口的成员变量为 public & static & final 类型（自动的）
interface RandVals {
    Random RAND =  new Random(47);
    
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextFloat() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
    
}

public class TestRandVals {


    public static void main(String[] args) {
        System.out.println(RandVals.RANDOM_INT);
        System.out.println(RandVals.RANDOM_LONG);
        System.out.println(RandVals.RANDOM_LONG);
        System.out.println(RandVals.RANDOM_FLOAT);
        System.out.println(RandVals.RANDOM_DOUBLE);
    }

}
```
