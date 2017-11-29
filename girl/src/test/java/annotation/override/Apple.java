package annotation.override;


/**
 * 
 * 　注解的语法比较简单，除了@符号的使用外，他基本与Java固有的语法一致，JavaSE中内置三个标准注解，定义在java.lang中：
　　　　@Override：用于修饰此方法覆盖了父类的方法;
　　　　@Deprecated：用于修饰已经过时的方法;
　　　　@SuppressWarnnings:用于通知java编译器禁止特定的编译警告。

　　下面我们依次看看三个内置标准注解的作用和使用场景。

 　　@Override，限定重写父类方法：

　　@Override 是一个标记注解类型，它被用作标注方法。它说明了被标注的方法重载了父类的方法，起到了断言的作用。
如果我们使用了这种Annotation在一个没有覆盖父类方法的方法时，java编译器将以一个编译错误来警示。这个annotaton常常在我们试图覆盖父类方法而确又写错了方法名时发挥威力。使用方法极其简单：在使用此annotation时只要在被修饰的方法前面加上@Override即可。
下面的代码是一个使用@Override修饰一个企图重载父类的displayName()方法，而又存在拼写错误的实例：
 * @author nbc
 *
 */

class Apple extends Fruit {
    @Override
    public void displayname(){
        System.out.println("水果的名字是：苹果");
    }
}
