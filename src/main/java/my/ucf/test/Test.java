package my.ucf.test;

import demo.testObjects.Company;
import demo.testObjects.Person;

/**
 * @author Sanjeev
 * 
 * @Note: Main can be also present in non public class in a file and that file can be run using non-public main method

public class Test {

	public void m1() {
		System.out.print("A.m1");
		} 
	}
		      
class B { 
	  public static void main(String[] args) { 
		  Test a = new Test(); 
		  a.m1();
	 	}
	}
  
*/

/**
 * 
 * @author Sanjeev
 * 
 * Implicit super constructor SuperClass() is undefined. Must explicitly invoke another constructor
 * 
 * If a sub-class constructor does not explicitly invoke a superclass constructor, the Java compiler automatically 
 * inserts a call to the no-argument constructor of the superclass.
 * 
 * If the super class does not have a no-argument constructor, you will get a compile-time error. 
 * Object does have such a constructor, so if Object is the only superclass, there is no problem.
 * 

 	class SuperClass{ 
 		int i=0; 
 		SuperClass(String s){ 
 			i=10; 
 	} 
 	//SuperClass(){
 		//System.out.println("");
 	//}
 	} 

 class Test extends SuperClass { 
	 Test(String s){
	 i=20; 
 } 
	 public static void main(String args[]) { 
		 Test b=new Test("hello"); 
		 System.out.println(b.i); 
	 } 
 }  
 */

/**
 * 
 * @author Sanjeev
 *
 *@Note: There is not keyword or variable as "unsigned" in Java.

	public class Test{
	
	public static void main(String args[]){
		
		unsigned byte b=25; // This declaration having some problem.
		b--;
		System.out.println(b);
		}
	}
 */

/**
 * 
 * @author Sanjeev
 * 
 * super() Constructor call must be the first statement in a constructor
 * 
 * Sub-class can make a instance object of type Super class but vice-versa is not true.
 * For e.g; SuperClass instanceOfSuperClass = new SubClass(); is allowed
 * For e.g; SubClass instanceOfSubClass = new SuperClass(); is not allowed
 */

/**
 * 
 * @author Sanjeev
 * 
 * this() keyword can never be used in a Static method.
 * 
 * <b>Output:<b>
 * no arg
 * 8
 * here
 * 4
 *

public class Test{
	public static void main(String args[]){
		new Test(4L);
	}
	
	public Test(int x){
		this();
		System.out.println(""+(x*2));
	}
	
	public Test(long x){
		this((int)x);
		System.out.println("here");
		System.out.println(""+x);
	}
	
	public Test(){
		System.out.println("no arg");
	}
}
 */

/**
 * 
 * @author Sanjeev
 * 
 * @Error: The type Test must implement the inherited Abstract method testt.method1()
 *
 * Whenever a class extend an Abstract class, it must implement the Abstract methods or else above 
 * error will thrown. If the sub-class doesn't implement the Abstract method then the sub-class will 
 * also become Abstract class.
 * 
 * An Abstract method will always be in a Abstract class only. But an Abstract class may contain 
 * Abstract and non-Abstract methods.

 abstract class testt{
	abstract int method1();
	public int method2(){
		return 6;
	}
}

public class Test extends testt{
	
	public static void main(String []args){
		System.out.println("hi");
	}
}
 */

/**
 * 
 * @author Sanjeev
 * 
 * Any Character(i.e. 'a','b' or '*') are always written in single-quote and will be auto-boxed to int, float
 * or double if assigned to any such variable.
 * Character byte starts from 'a'=97.
 * 
 * @Output:true
 *

public class Test{
	static double a;
	static float b;
	static int c;
	static char d;
	
	public static void main(String args[]){
		a=b=c=d='a';
		System.out.println((a+b+c+d)==4*'a');
	}
}
 */


/**
 * 
 * @author Sanjeev
 * 
 * String().trim() will remove any leading and trailing white space in the string.
 * 
 * String is immutable. So,composite.concat("server") didn't able to alter composite since
 * it is not re-assigned to composite.For e.g.  composite = composite.concat("server")
 * 
 * @Output:
 * windows
 * 7
 *
 
public class Test{
	public static void main(String args[]){
		String space=" ";
		String composite=space+"windows"+space+space;
		
		composite.concat("server");
		System.out.println(composite);
		
		String trimmed=composite.trim();
		System.out.println(trimmed.length());
	}
}
*/

/**
 * 
 * @author Sanjeev
 * 
 * append() method is in StringBuffer and StringBuilder only whereas concat() method is in String.
 *

public class Test {
	
	public static void main(String args[]){
		String b="bookkeeper";
		b.append("woo");
		System.out.println(b);
	}
  }
 */

/**
 * 
 * @author Sanjeev
 * 
 * "=" doesn't change the variable value till it is not returned via a return and again being assigned in that particular variable.
 * For e.g, if return y=x; and y = operate(x,y) then only value of "Y" will be changed. While append directly affect "x".
 * Hence the answer.
 * 
 * @Output:
 * SunJava, Java
 *
 
public class Test{
	static void operate(StringBuffer x, StringBuffer y){
		x.append(y);
		y=x;
	}

	public static void main(String args[]){
		StringBuffer x=new StringBuffer("Sun");
		StringBuffer y=new StringBuffer("Java");

		operate(x,y);
		System.out.println(x+","+y);
	}
}
*/

/**
 * 
 * @author Sanjeev
 * 
 * Range of byte is -127 to +127. Hence assigning value to a byte variable outside this range will throw
 * compilation error.
 *  
 *  byte b1 = 128 will through error.
 *
class Test{
	public static void main(String args[]){
	
		byte b1=128;
		byte b2=14;
		System.out.println(b1+b2);
	}
}
*/

/**
 * 
 * @author Sanjeev
 * 
 * Can't create a Super Class object of type Sub-class, if created must be type-cast to sub class
 * which will remove compile time error but will through Runtime exception. Hence we can't create 
 * a super class object of type Sub-class.
 * Exception: Base cannot be cast to my.ucf.test.Sub
 * i.e, Sub s2= (Sub)new Base();
 *
 
interface I1{}
interface I2{}
class Base implements I1{}
class Sub extends Base implements I2{}
class Red{
	public static void main(String args[]){
		Sub s1=new Sub();
		I2 i2=s1;
		I1 i1=s1;
		Base base=s1;
		Sub s2= new Base();//wrong
	}
}
*/

/**
 * 
 * @author Sanjeev
 * 
 * A ref1 = new C();
 * This above line of code will override method of A. Any method reference will now be referenced to methods
 * of class C since the "new" object creation is of C class.
 * 
 * Output:2 d
 *

public class Test {
    public static void main(String[] args) {
        A ref1 = new C();
        B ref2 = (B) ref1;
        System.out.println(ref2.f());
System.out.println("abcdef".charAt(3));
    }
}

class A { int f() { return 0; } }
class B extends A { int f() { return 1; } }
class C extends B { int f() { return 2; } }
 */

/**
 * 
 * @author Sanjeev
 * 
 * Compilation Error: Illegal modifier for the class NewTreeSet; only public, abstract & final are permitted.
 * If final, the class method cannot be overridden.
 *

public class Test extends NewTreeSet{
	public static void main(String args[]){
		Test t=new Test();
		t.count();
	}
}

protected class NewTreeSet{
	void count(){
		System.out.println("hi da");
	}
}
 */

/**
 * 
 * @author Sanjeev
 * 
 * Since "func()" method is accessed by "ref" object which is a static, so "func()" method need not to be
 * "static".
 * Output: It will sun fine and print nothing.
 *

public class Test{

	static Test ref;
	String []arguments;

	public static void main(String []args){
		ref=new Test();
		ref.func(args);
	}

	public void func(String []args){
		ref.arguments=args;
	}
}
 */

/**
 * 
 * @author Sanjeev
 * 
 * (==) work with compatible Data Types. So Line no. 6 will give a compilation error.
 *
 
public class Test{
	public static void main(String args[]){
		String s="hello";
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();
	//	if(s==sb)								//Line no. 6
	//	System.out.println("a");

		boolean bValue = s instanceof String;

		System.out.println(bValue);				//true
		System.out.println((s.equals(sb)));		//false
		System.out.println((sb.equals(s)));		//false
		}
	}
	*/

/**
 * 
 * @author Sanjeev
 * 
 * The Below will throw Runtime exception for main() method.
 * 
 * Output:Exception in thread "main" java.lang.RuntimeException
 * 				at my.ucf.test.Test.main(Test.java:395)

public class Test{
	public static void main(String args[]){
		RuntimeException re = new RuntimeException();
		throw re;
	}
}
 */

/**
 * 
 * @author Sanjeev
 * 
 * Output: 29
 *

public class Test{
	public static void main(String args[]){
		C c=new C();
		System.out.println(c.max(13,29));
	}
}

class A{
	int max(int x,int y){
		if(x>y)
			{System.out.println(x);
			return x;}
		else
			return y;
	}
}

class B extends A{
	int max(int x,int y){
		return super.max(y,x)-10;
	}
}

class C extends B{
	int max(int x,int y){
		return super.max(x+10,y+10);
	}
}
*/



/**
 * 
 * @author Sanjeev
 * 
 * "native" method never have a body. If line 5 is removed then the below output will
 * be printed and one text file will generated with content as "z".
 * 
 * Output: false
 * 		   false
 * 		   true
 * 		   -1
 * 		   true - false
 *

import java.io.*;

public class Test{
	static boolean b1;
	
	static final void m1(){}
	transient private native void m2(){}		//Line number 5
	synchronized public final void m3(){}
	private native void m4();

	public static void main(String []args){
		boolean []array=new boolean[1];
		boolean b2=true;
		
		System.out.println(b1);//false
		System.out.println(array[0]);//false
		System.out.println(b2); //true

		byte b =-1;
		switch(b){
		case -1:
			System.out.println(b); break;//print -1
		case 2:
			System.out.println("b"); break;
		default:
			System.out.println("default"); break;
		}

		FileOutputStream out=null;
		try{
			out = new FileOutputStream("text.txt");
			out.write(122);
		}
		catch(IOException io){
			System.out.println("jhgsdf");
		}
		finally{
			try {
				out.close();
			} catch (IOException e) {
				System.out.println("Exception occured while closing file writer");
				e.printStackTrace();
			}
		}

		String s = "ab"+"12";
		String t = "ab"+12;
		String u = new String("ab12");
		System.out.println((s==t)+" - "+(s==u)); //false-false

		}
	}
 */











