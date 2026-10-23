package singletonPattern;

public class SingletonClassDemo {
	
	public static SingletonClassDemo object = null;
	
	private SingletonClassDemo() {}
	
	public static SingletonClassDemo method () {
		
         if (object == null) {
        	 object = new SingletonClassDemo();
         }
		return object;
	}
	
	public static void main (String [] args) {
		
		SingletonClassDemo var = SingletonClassDemo.method();
		System.out.println("classone value : "+ System.identityHashCode(var));
	}
	
	
	
	

}
