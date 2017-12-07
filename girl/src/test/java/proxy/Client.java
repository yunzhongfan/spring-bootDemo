package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class Client {

	public static void main(String[] args) {
		// 我们要代理的真实对象
		Subject realSubject = new RealSubject();
		// 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
		InvocationHandler handler = new DynamicSubject((Object) realSubject);
		/*
		 * 可能我以为返回的这个代理对象会是Subject类型的对象，或者是InvocationHandler的对象，结果却不是，
		 * 首先我们解释一下为什么我们这里可以将其转化为Subject类型的对象？原因就是在newProxyInstance这个方法的第二个参数上，
		 * 我们给这个代理对象提供了一组什么接口，那么我这个代理对象就会实现了这组接口，
		 * 这个时候我们当然可以将这个代理对象强制类型转化为这组接口中的任意一个，因为这里的接口是Subject类型，
		 * 所以就可以将其转化为Subject类型了
		 * 
		 * 
		 * 同时我们一定要记住，通过 Proxy.newProxyInstance
		 * 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型，
		 * 而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。
		 * 
		 * 接着我们来看看这两句
		 * 
		 * subject.rent(); subject.hello("world");
		 * 
		 * 这里是通过代理对象来调用实现的那种接口中的方法，这个时候程序就会跳转到由这个代理对象关联到的 handler
		 * 中的invoke方法去执行，而我们的这个 handler 对象又接受了一个
		 * RealSubject类型的参数，表示我要代理的就是这个真实对象，所以此时就会调用 handler 中的invoke方法去执行：
		 * 
		 * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数 第一个参数
		 * handler.getClass().getClassLoader()
		 * ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
		 * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口
		 * ，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了 第三个参数handler， 我们这里将这个代理对象关联到了上方的
		 * InvocationHandler 这个对象上
		 */
		Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
				realSubject.getClass().getInterfaces(), handler);

		System.out.println(subject.getClass().getName());
		subject.rent();
		subject.hello("world");
	}

	@Test
	public void TestMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Subject subject = new RealSubject();
		Method method = subject.getClass().getMethod("Request");
		method.invoke(RealSubject.class.newInstance());

	}

}
