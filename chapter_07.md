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























