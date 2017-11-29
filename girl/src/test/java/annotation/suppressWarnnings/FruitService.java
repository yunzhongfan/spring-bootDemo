package annotation.suppressWarnnings;

import java.util.ArrayList;
import java.util.List;

import annotation.override.Fruit;

/*@SuppressWarnings 被用于有选择的关闭编译器对类、方法、成员变量、变量初始化的警告。在java5.0，
 * sun提供的javac编译器为我们提供了-Xlint选项来使编译器对合法的程序代码提出警告，此种警告从某种程度上代表了程序错误。
 * 例如当我们使用一个generic collection类而又没有提供它的类型时，编译器将提示出"unchecked warning"的警告。
 * 通常当这种情况发生时，
 * 我们就需要查找引起警告的代码。如果它真的表示错误，我们就需要纠正它。例如如果警告信息表明我们代码中的switch语句没有覆盖所有可能的case，
 * 那么我们就应增加一个默认的case来避免这种警告。
有时我们无法避免这种警告，例如，我们使用必须和非generic的旧代码交互的generic collection类时，
我们不能避免这个unchecked warning。此时@SuppressWarning就要派上用场了，在调用的方法前增加@SuppressWarnings修饰，
告诉编译器停止对此方法的警告。
SuppressWarning不是一个标记注解。它有一个类型为String[]的成员，这个成员的值为被禁止的警告名。对于javac编译器来讲，
被-Xlint选项有效的警告 名也同样对@SuppressWarings有效，同时编译器忽略掉无法识别的警告名。
annotation语法允许在annotation名后跟括号，括号中是使用逗号分割的name=value对用于为annotation的成员赋值。实例如下：*/

/*	在这个例子中SuppressWarnings annotation类型只定义了一个单一的成员，所以只有一个简单的value={...}作为name=value对。
 * 又由于成员值是一个数组，故使用大括号来声明数组值。注意：
 * 我们可以在下面的情况中缩写annotation：当annotation只有单一成员，并成员命名为"value="。
 * 这时可以省去"value="。比如将上面方法getFruit()的SuppressWarnings annotation就是缩写的。

			 　 SuppressWarnings注解的常见参数值的简单说明：

			　　　　1.deprecation：使用了不赞成使用的类或方法时的警告；
			　　　　2.unchecked：执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型; 
			　　　　3.fallthrough：当 Switch 程序块直接通往下一种情况而没有 Break 时的警告;
			　　　　4.path：在类路径、源文件路径等中有不存在的路径时的警告; 
			　　　　5.serial：当在可序列化的类上缺少 serialVersionUID 定义时的警告; 
			　　　　6.finally：任何 finally 子句不能正常完成时的警告; 
			　　　　7.all：关于以上所有情况的警告。*/

public class FruitService {
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	public static List<Fruit> getFruitList() {
		List<Fruit> fruitList = new ArrayList();
		return fruitList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Fruit> getFruit() {
		List<Fruit> fruitList = new ArrayList();
		return fruitList;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
	}
	
	
	

}
