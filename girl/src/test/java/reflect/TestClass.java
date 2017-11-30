package reflect;

public class TestClass {
	
			public TestClass() {
				// TODO Auto-generated constructor stub
			}
			
			
			public static void main(String[] args) {
				Boolean var1 = true; 
				Class<?> classType2 = var1.getClass();
				System.out.println(classType2);
				
				System.out.println("=====================");
				System.out.println(Boolean.class);
				
			}
		
}
