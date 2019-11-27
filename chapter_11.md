### 第十一章   持有对象 ###
--------------------------

1. 为什么要谈持有对象？  
* 程序在运行时才知道满足某些条件去创建对象，在此之前并不知道所需对象的数量，甚至不知道确切的类型；  
* 为了解决这个普遍存在的问题，编程语言需要支持在任意时刻，任意位置创建数量的对象  


##### 10.1 泛型和类型安全的容器  
1. 为什么要使用泛型  
* 未使用泛型，可以将不同的对象添加到Java容器中(如ArrayList)，编译时不会检查，当从容器中取出对象时，如果没有做好类型转换，就很容易出错。示例代码如下： 
```
package com.jacky.chapter_11.holding;

import java.util.ArrayList;

/*
 * 演示不使用泛型，可能产生的程序错误
 */

//定义Apple类，用于创建对象放入容器中
class Apple {
    private static long counter;
    private final long id = counter++;
    
    public long id() {
        return this.id;
    }
}
//定义Orange类，用于创建对象放入容器
class Orange{}


public class ApplesAndOrangesWithoutGenerics {

    public static void main(String[] args) {
        ArrayList apples = new ArrayList();//未使用泛型
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple()); //向ArrayList容器添加Apple对象
        }
        
        apples.add(new Orange());//向ArrayList容器添加Orange对象
        
        for (int i = 0; i < apples.size(); i++) {
            ((Apple)apples.get(i)).id();   //编译不会出错，运行会出错
        }

    }

}
```

* 使用泛型后，编译阶段就会进行类型的检查，不会引起运行时错误，代码如下：
```
package com.jacky.chapter_11.holding;

import java.util.ArrayList;

public class ApplesAndOrangesWithGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();   //<Apple>就表示使用了泛型
        
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());  //添加Apple对象，和泛型指定的一致，编译时通过
        }
        
        //apples.add(new Orange());  //因为使用了泛型，是无法添加不同类型的，编译时不通过

        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i).id());  //使用泛型以后，取出数据时就不用进行强制类型转换了
        }
        
        for (Apple c : apples) {
            System.out.println(c.id());  //不用类型转换了，泛型真好用吧
        }
    }

}
```

* 使用泛型以后，可以将泛型指定的引用类型的子类添加进去。



##### 10.2 基本概念   
