package se.day33;

public class Person {
	public String name;
	private int age;
	private String address;
	
	public Person() {
		super();
	}
	
	private Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}
	

    // 成员方法
    // 没有返回值没有参数的方法
    public void method1() {
        System.out.println("没有返回值没有参数的方法");
    }

    // 没有返回值，有参数的方法
    public void method2(String name) {
        System.out.println("没有返回值，有参数的方法 name= " + name);
    }

    // 有返回值，没有参数
    public int method3() {
        System.out.println("有返回值，没有参数的方法");
        return 123;
    }

    // 有返回值，有参数的方法
    public String method4(String name) {
        System.out.println("有返回值，有参数的方法");
        return "哈哈" + name;
    }

    // 私有方法
    private void method5() {
        System.out.println("私有方法");
    }

}
