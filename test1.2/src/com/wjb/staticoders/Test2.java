package com.wjb.staticoders;

public class Test2 extends Test1{
	  
	static{
	    new Print("a");
	 }
	      
    public static Print obj1 = new Print("b");
      
    public Print obj2 = new Print("c");
     
    public Test2(){
        new Print("d");
    }
     
    public static Print obj3 = new Print("e");
     
    public Print obj4 = new Print("f");
     
    public static void main(String [] args){
         Test1 obj1 = new Test2();
         Test1 obj2 = new Test2();
    }
}
