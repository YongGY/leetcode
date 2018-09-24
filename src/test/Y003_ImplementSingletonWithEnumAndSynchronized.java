package test;

public class Y003_ImplementSingletonWithEnumAndSynchronized {

	/**
	 * 由JVM保证线程安全 Creation of Enum instance is thread-safe
	 * 序列化和反射攻击已经被枚举解决 Enum Singletons handled Serialization by themselves
	 * 
	 * 缺点是枚举类型有些不灵活;例如，它不允许延迟初始化。
	 * The drawback is that the enum type is somewhat inflexible; for example, it does not allow lazy initialization.
	 * 
	 * 
	 * enums are inherently serializable we don’t need to implement it with serializable interface. 
	 * Reflection problem is also not there. 
	 * Therefore, it is 100% guaranteed that only one instance of the singleton is present within a JVM. 
	 * Thus, this method is recommended as the best method of making singletons in java.
	 * 
	 * @author yongguo
	 *
	 */

	public enum MySingleton {
		INSTANCE;

		public void sayHello() {
			System.out.println("Hellod");
		}

		public void sayBye() {
			System.out.println("Bye");
		}

	}

	public static void main(String[] args) {
		//	Obviously the sayHello() and sayBye() is not thread safe( since we have not made them thread safe).

		MySingleton.INSTANCE.sayHello();
		MySingleton.INSTANCE.sayBye();
		
		// But as far as creation of singleton instance is concern ‘It is completely thread safe’. 
		// Also since enum is special type of java class and it can have methods and other variables. 
		// So we can add all other required stuff to the enum class and use where ever required. 
		// For example :
		
		MySingleton singleton = MySingleton.INSTANCE;
		singleton.sayHello();
		singleton.sayBye();
		
		// As we see here writing a singleton using enum is very simple 
		// and effective without worrying too much on concurrency and other stuff.
	}
	
	

	
	
	
//	public class Singleton {
//	    private static final Singleton INSTANCE = new Singleton();
//	    // 私有化构造函数
//	    private Singleton(){}
//
//	    public static Singleton getInstance(){
//	        return INSTANCE;
//	    }
//	}

}
