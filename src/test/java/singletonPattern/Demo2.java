package singletonPattern;

public class Demo2 {
	
	
	
	public static void main (String [] args) {
		SingletonClassDemo var2 = SingletonClassDemo.method();
		System.out.println("value 2 : "+System.identityHashCode(var2));
		
	}

}
