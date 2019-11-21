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
public class Father {
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
```
