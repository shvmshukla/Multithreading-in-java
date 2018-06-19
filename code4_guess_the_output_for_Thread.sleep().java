----------------------------------------------------------------------------------------------------------------------------
package mutltithreading;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass extends Thread 
{
    boolean stop=false;
    String str;
    MyClass(String str)
    {
       this.str=str;
    }
    
    @Override
    public void run()
    {
        
        for(int i=0;i<5;i++)
        {   
         System.out.println(str+i);
            try {     
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);  
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj1= new MyClass("cut the ticket");
        MyClass obj2= new MyClass("show the seat");
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        
        t2.start();
       
    }
        
}

/*
run:
cut the ticket0
show the seat0
cut the ticket1
show the seat1
cut the ticket2
show the seat2
cut the ticket3
show the seat3
cut the ticket4
show the seat4
BUILD SUCCESSFUL (total time: 5 seconds)
*/
----------------------------------------------------------------------------------------------------------------------------

package mutltithreading;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shivam
 */
public class MyClass extends Thread 
{
    boolean stop=false;
    String str;
    MyClass(String str)
    {
       this.str=str;
    }
    
    @Override
    public void run()
    {
        
        for(int i=0;i<5;i++)
        {   
         System.out.println(str+i);
           
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj1= new MyClass("cut the ticket");
        MyClass obj2= new MyClass("show the seat");
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        t2.start();
       
    }
        
}

/*
run:
cut the ticket0
show the seat0
cut the ticket1
show the seat1
show the seat2
show the seat3
show the seat4
cut the ticket2
cut the ticket3
cut the ticket4
BUILD SUCCESSFUL (total time: 0 seconds)

*/
NOTE: random outputs everytime but order of cutticket will be  cut ticket0>cut ticket1>cut ticket2>cut ticket3>
similarly,order of cutticket will be  show seat0>seat1>seat2>seat3>
*/
---------------------------------------------------------------------------------------------------------------------------


package mutltithreading;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass extends Thread 
{
    boolean stop=false;
    String str;
    MyClass(String str)
    {
       this.str=str;
    }
    
    @Override
    public void run()
    {
        
        for(int i=0;i<5;i++)
        {   
         System.out.println(str+i);
           
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj1= new MyClass("cut the ticket");
        MyClass obj2= new MyClass("show the seat");
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        Thread.sleep(1000);
        t2.start();
       
    }
        
}

/*
run:
cut the ticket0
cut the ticket1
cut the ticket2
cut the ticket3
cut the ticket4
---------main will sleep for 1 sec (tabhi to t1 ko poora  execute hone ka mauka mil gya aur t2 abhi start bhi nhi hua tha)
show the seat0
show the seat1
show the seat2
show the seat3
show the seat4
BUILD SUCCESSFUL (total time: 1 second)

*/
---------------------------------------------------------------------------------------------------------------------------

//main kam soya aur threads jyada then

package mutltithreading;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shivam
 */
public class MyClass extends Thread 
{
    boolean stop=false;
    String str;
    MyClass(String str)
    {
       this.str=str;
    }
    
    @Override
    public void run()
    {
        
        for(int i=0;i<5;i++)
        {   
         System.out.println(str+i);
        try{
         Thread.sleep(2000);} catch(Exception ex)
         {
             System.out.println(ex);
         }
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj1= new MyClass("cut the ticket");
        MyClass obj2= new MyClass("show the seat");
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        Thread.sleep(1000);
        t2.start();
       
    }
        
}
/*
run:
cut the ticket0
show the seat0
cut the ticket1
show the seat1
cut the ticket2
show the seat2
cut the ticket3
show the seat3
cut the ticket4
show the seat4
BUILD SUCCESSFUL (total time: 11 seconds)
*/
---------------------------------------------------------------------------------------------------------------------------
//main jyada soya aur threads kam then jo pehle start hua h thread wo main k uthne se pehle execution finish kar dega

package mutltithreading;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shivam
 */
public class MyClass extends Thread 
{
    boolean stop=false;
    String str;
    MyClass(String str)
    {
       this.str=str;
    }
    
    @Override
    public void run()
    {
        
        for(int i=0;i<5;i++)
        {   
         System.out.println(str+i);
        try{
         Thread.sleep(1000);} catch(Exception ex)
         {
             System.out.println(ex);
         }
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj1= new MyClass("cut the ticket");
        MyClass obj2= new MyClass("show the seat");
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        Thread.sleep(5000);
        t2.start();
       
    }
        
}

/*
run:
cut the ticket0
cut the ticket1
cut the ticket2
cut the ticket3
cut the ticket4
show the seat0
show the seat1
show the seat2
show the seat3
show the seat4
BUILD SUCCESSFUL (total time: 10 seconds)

*/

----------------------------------------------------------------------------------------------------------------------------

/*
just upar wale case me marhin bhot jyada tha main k sone wale time me aur threds k sone k time me esliye jo thread pehle 
start hua tha wo poora execute ho sakta tha.. but what if ye margin kam hota toh... see here 
here i have taken main thread sleeping time 2000 milisec and thread sleeping time as 1000 milisec
*/
package mutltithreading;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass extends Thread 
{
    boolean stop=false;
    String str;
    MyClass(String str)
    {
       this.str=str;
    }
    
    @Override
    public void run()
    {
        
        for(int i=0;i<5;i++)
        {   
         System.out.println(str+i);
        try{
         Thread.sleep(1000);} catch(Exception ex)
         {
             System.out.println(ex);
         }
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj1= new MyClass("cut the ticket");
        MyClass obj2= new MyClass("show the seat");
        Thread t1= new Thread(obj1);
        Thread t2= new Thread(obj2);
        t1.start();
        Thread.sleep(2000);
        t2.start();
       
    }
        
}
/*
run:
cut the ticket0
cut the ticket1
show the seat0
cut the ticket2
show the seat1
cut the ticket3
show the seat2
cut the ticket4
show the seat3
show the seat4
BUILD SUCCESSFUL (total time: 7 seconds)

*/
//NOTE- timing match krke output do ...logical question
----------------------------------------------------------------------------------------------------------------------------
