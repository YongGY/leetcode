
public class Student {
	
	
	private String name;
	private int age;
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		if(obj instanceof Student) {
			Student stu = (Student)obj;
			return stu.name.equals(this.name) && stu.age == this.age;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// hashcode不相同，用equals()方法判断的返回的一定为false。
		// hashcode相同，equals()方法返回值不能确认，可能为true，可能为false。
		
		// 注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。如下
		//(1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true 
		//(2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false
		
		int res = 17;
		res = res * 37 + this.name.hashCode();
		res = res * 37 + this.age;
		return res;
	}

	public static void main(String[] args) {
		Student s1 = new Student("William",20);
		Student s2 = new Student("William",20);
		System.out.println(s1.equals(s2));
		
	}

}
