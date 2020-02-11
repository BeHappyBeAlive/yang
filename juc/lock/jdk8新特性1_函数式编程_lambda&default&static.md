## 函数式编程：

jdk8的一个新特性就是出现了函数接口，即可以用lambda表达式实现，在以前的版本中，只能定义方法名，而不能包含方法的具体实现代码。但是在我们在尝试强化Java 8 Collections API，让其支持lambda表达式的时候，就面临了这样的挑战。即lambda只能够在接口内只存在一个方法的时候才能使用，为了克服这个困难，Java 8中引入了一个新的概念，叫做default方法，也可以称为Defender方法，或者虚拟扩展方法


## lambda口诀：

中括号（包含参数）-> 大括号（实现接口对应方法）

## 注意
1.  如果定义一个接口，里面有且仅有一个方法，那么jdk 8 会自动把该接口认定为函数接口，加上注解@FunctionalInterface，然而如果一个接口里面定义了多个方法，则不能够加上该注解，这个时候就可以采用default方法，或者在接口中添加静态方法，正如下面这段代码：
    

		@FunctionalInterface
		interface Foo{
	    public void sayHello();
	
	    public default int mul(int x,int y){
	        return x * y;
	    }
	
	    public static int div(int x,int y){
	        return x/y;
	    }
	    //public int add(int x,int y);
		}

2.  在实现该接口的时候，如果就采用定义的默认方法，那么不需要重写其方法，只需要创建接口对象，通过其对象调用其default方法
    
		Foo foo = () -> {
		    System.out.println("hello...");
		};

		foo.sayHello();


		int mul = foo.mul(2, 3);
		System.out.println("2*3 = "+mul);
3.  如果采用静态方法，直接接口名.方法名
    
		int div = Foo.div(6, 3);
		System.out.println("6/3 = "+div);
