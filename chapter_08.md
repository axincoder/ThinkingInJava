### 第八章   多态 ###
--------------------------


##### 8.1再论向上转型  
1. 参数向上转型  
基类做为一个方法的形参，在实际使用时，实参可以传入基类的对象，同时也可以传入该基类子类的对象，可以直接使用子类的对象。


##### 8.2 转机  
1. 形参用基类，实参用导出类的对象，可以正常转型（自动转型，无需显示）  

2. 基类的引用，指向导出类的对象

3. private方法  
* private方法是类范围使用的，对导出类**是屏蔽的**, 无法继承和重载   
* 基类中有一个private方法，导出类中也有一个相同的方法(返回值，方法名，参数列表)，不过，导出类中的是一个完全新的方法，和基类中的private方法没有关系  
* final修饰的方法，默认是private类型的，因此和private类型修饰的方法一样，对导出类是**屏蔽的**  

4. 域  
* 如果基类中有一个非private类型的域(成员变量), 导出类中有一个同名的域，从导出类中看，这个变量并不是被覆盖，而是分配了两个空间来存储，调用基类的域直接写域的名称，如a，调用基类则使用super.a  

* 没有特殊需要，类中的成员变量最好定义为private类型的，如果方法就使用getter，setter模式，这样就不会容易混淆  

5. 静态方法  
```
class StaticSuper {
    // 静态方法
    public static void staticGet() {System.out.println("1");}

    public void dynamicGet() {System.out.println("2");}
}

class StaticSub extends StaticSuper {
    // 静态方法
    public static void staticGet() {System.out.println("3");}

    public void dynamicGet() {System.out.println("4");}

}

public class StaticTest {
    public static void main(String[] args) {
        StaticSuper s = new StaticSub();  //基类的引用，指向导出类的对象  
        
        s.staticGet();   // 输出为: 1    静态方法是对于类的,是根据引用类执行的
        s.dynamicGet();  //输出为4       被重载的方法，因此调用了导出类的方法
    }
}
```


##### 8.3 构造器和多态  
1. 调用顺序
* 调用基类的构造器  
* 按照定义的顺序，初始化成员的初始化方法
* 调用导出类的构造器

2. 继承与清理  
* 通常情况下，清理动作无序考虑，留给java垃圾回收器处理即可  
* 如果显示定义清理，可以定义dispose()方法
* 导出类中要覆盖基类的dispose()方法，同时要使用super.dispose()调用基类的初始化方法，才能保证清理彻底  


