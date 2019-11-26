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
