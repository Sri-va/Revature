package com.lambdaexpression;

public class NoParameterLamda {
    public static void main(String[] args) {
   /*saySomething =new SaySomething() {
          public String say() {
               return "Hello Without Lambda";
           }
        };
        System.out.println(saySomething.say());

     SaySomething s=()-> "This is from Lambda Expression Without Parameter.";
        
       System.out.println(s.say());
       SaySomething s2= name ->"Hello, "+name; ;
       System.out.println(s2.sayName("Paul")); */
       SaySomething saySomething=(fName, lastName,middleName) -> { return   "Hello, "+fName+" "+lastName+" "+middleName; };
       System.out.println(saySomething.sayFullName("Jasdhir","Singh","Middle"));
      



   SaySomething saySomething1=(String firstName, String lName,String mName) -> { return "Hello, "+firstName+" "+lName;  };
    System.out.println(saySomething1.sayFullName("Rohit","Kumar","S"));
    }
}