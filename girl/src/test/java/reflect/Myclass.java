package reflect;

public class Myclass {
	
	private String data1="我是父类的data1属性";
	
	public String data2="我是父类的data2属性";
	
	
	public void getTestClassMethod() {
		System.out.println("Myclass.getTestClassMethod，代理方法1");
	}
	public void getTestClassMethod(String str) {
		System.out.println("Myclass.getTestClassMethod1，代理方法2");
	}
	
	public void getTestClassMethod(String str,String str1) {
		System.out.println("Myclass.getTestClassMethod2，代理方法3");
	}
	
	public void  myclassOne(){
		System.out.println("myclassOne");
	}
	
	public void  myclassTwo(){
		System.out.println("myclassTwo");
	}

}
