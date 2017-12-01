package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass extends Myclass {

	private String date;
	private String name;

	public TestClass() {
		// TODO Auto-generated constructor stub
	}

	public TestClass(String str) {
		// TODO Auto-generated constructor stub
	}

	public void getTestClassMethod() {
		System.out.println("getTestClassMethod");
	}

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		/**
		 * 1、获取类的 Class 对象
		 */
		Boolean var1 = true;
		Class<?> classType2 = var1.getClass();
		System.out.println(classType2);

		System.out.println("=====================");
		System.out.println(Boolean.class);
		System.out.println("=====================1");
		Class<?> classType5 = Class.forName("java.lang.Boolean");
		System.out.println(classType5);

		System.out.println("=====================2");
		Class<?> classType3 = Boolean.TYPE;
		System.out.println(classType3);
		Class<?> classType4 = Character.TYPE;
		System.out.println(classType4);

		/**
		 * 2、获取类的 Fields
		 */
		System.out.println("=====================获取类的 Fields");
		Field[] fields = TestClass.class.getFields();
		for (Field f : fields) {
			System.out.println(f);
		}
		System.out.println("DeclaredFields===============");

		// 使用 getDeclaredFields 获取属性

		fields = TestClass.class.getDeclaredFields();
		for (Field f : fields)

		{
			System.out.println(f);
		}
		/**
		 * 3.返回Method
		 */

		System.out.println("=====================获取类的 Method");
		Class<TestClass> classType = TestClass.class;
		Method[] methods = classType.getMethods();
		for (Method m : methods) {
			System.out.println(m);
		} 
		//使用 getDeclaredMethods 获取函数 methods =
		System.out.println("=====================获取类的 getDeclaredMethods");
		Method[] methods1 = classType.getDeclaredMethods();
		for (Method m : methods1) {
			System.out.println(m);
		}

		/***
		 * 
		 * 4、获取类的 Constructor
		 */
		System.out.println("=====================获取类的  Constructor");
		Constructor<?> constructor = TestClass.class.getConstructor();
		System.out.println(constructor);
		/***
		 * 5、新建类的实例
		 */
		System.out.println("=====================新建类的实例");
		// ①调用类的 Class对象的 newInstance方法，该方法会调用对象的默认ctor构造器，如果没有默认构造器，会调用失败.
		Class<?> classType1 = TestClass.class;
		Object inst = classType1.newInstance();
		System.out.println("=====================新建类的实例newInstance()");
		System.out.println(inst);
		// ②、调用默认 Constructor 对象的 newInstance 方法
		System.out.println("=====================新建类的实例getConstructor()");
		Constructor<?> constructor1 = classType1.getConstructor();
		Object ont = constructor1.newInstance();
		System.out.println(ont);

		// ③、调用带参数 Constructor 对象的 newInstance 方法
		 System.out.println("=====================新建类的实例getConstructor()的调用带参数 Constructor 对象的 newInstance 方法"); 
		 Constructor<?> constructor3 = classType1.getDeclaredConstructor(String.class);
		 Object ont1 = constructor3.newInstance();
		 System.out.println(ont1);
		 
		/**
		 * 
		 * 6、调用类的函数 通过反射获取类 Method 对象，调用 Field 的 Invoke 方法调用函数。
		 */
		System.out.println("=====================调用类的函数");
		Class<?> classType51 = TestClass.class;
		Object inst1 = classType51.newInstance();
		Method logMethod = classType51.getDeclaredMethod("Log", String.class);
		logMethod.invoke(inst, "test");

		/**
		 * 7、设置/获取类的属性值
		 */
		System.out.println("=====================7、设置/获取类的属性值");
		Class<?> classType31 = TestClass.class;
		Object inst2 = classType31.newInstance();
		Field intField = classType31.getField("pubIntExtendField");
		intField.setInt(inst, 100);
		int value = intField.getInt(inst);
	}

}
