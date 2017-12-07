package proxy;

public interface Subject {   //1、定义抽象角色
	
	 public void Request();

	/** 
	* @Title: rent 
	* @Description: TODO
	* @param    
	* @return void   
	* @throws 
	*/
	public void rent();

	/** 
	* @Title: hello 
	* @Description: TODO
	* @param @param string   
	* @return void   
	* @throws 
	*/
	public void hello(String string);
	 	
}
