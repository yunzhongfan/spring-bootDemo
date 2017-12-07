package annotation.deprecated;

import annotation.test.Apple;

public class FruitRun {
	 @SuppressWarnings("deprecation")
	public static void main(String[] args) {
	        Apple apple=new Apple();
	        apple.displayName();    
	        
	        AppleService appleService=new AppleService();
	        appleService.showTaste();
	        appleService.showTaste(0);
	        appleService.showTaste(2);
	    }
}
