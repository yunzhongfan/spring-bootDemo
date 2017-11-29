package annotation.override;



/***
 * @Deprecated，标记已过时： 同
 * 样Deprecated也是一个标记注解。当一个类型或者类型成员使用@Deprecated修饰的话，编译器将不鼓励使用这个被标注的程序元素。
 * 而且这种修饰具有一定的
 * “延续性”：如果我们在代码中通过继承或者覆盖的方式使用了这个过时的类型或者成员，虽然继承或者覆盖后的类型或者成员并不是被声明为 @Deprecated，
 * 但编译器仍然要报警。
 * 值得注意，@Deprecated这个annotation类型和javadoc中的 @deprecated这个tag是有区别的：前者是java编译器识别的，
 * 而后者是被javadoc工具所识别用来生成文档（包含程序成员为什么已经过 时、它应当如何被禁止或者替代的描述）。
 * 在java5.0，java编译器仍然象其从前版本那样寻找@deprecated这个javadoc
 * tag，并使用它们产生警告信息。但是这种状况将在后续版本中改变，我们应在现在就开始使用@Deprecated来修饰过时的方法而不是 @deprecated
 * javadoc tag。 下面一段程序中使用了@Deprecated注解标示方法过期，同时在方法注释中用@deprecated tag
 * 标示该方法已经过时，代码如下：
 * 
 * @author nbc
 *
 */
public class Fruit {
	
	@Override
	 public void displayName(){
	        System.out.println("水果的名字是：*****");
	    }

	 
	public void displayname() {
		// TODO Auto-generated method stub
		
	}
}
