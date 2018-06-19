
---------------------------------------------------------------------------------------------------------------------------
// A) Program without multitasking

package mutltithreading;

import java.io.IOException;

public class MyClass extends Thread 
{
    boolean stop=false;
    @Override
    public void run()
    {
        
        for(int i=0;i<5;i++){
        System.out.println("Inside run method "+Thread.currentThread().getId());
        }
       
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj= new MyClass();
        Thread t1= new Thread(obj);
        Thread t2= new Thread(obj);
        t1.start();
       
        System.out.println(Thread.currentThread().getState());
       
        t1.sleep(1000);
        t2.start();
    }
        
}

/*
OUTPUT
Inside run method 10
Inside run method 10
Inside run method 10
Inside run method 10
Inside run method 10
Inside run method 11
Inside run method 11
Inside run method 11
Inside run method 11
Inside run method 11
BUILD SUCCESSFUL (total time: 1 second)

*/

---------------------------------------------------------------------------------------------------------------------------
// B) Program with multitasking
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
            try {
                Thread.sleep(2000);
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
       // t1.sleep(2000);
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
BUILD SUCCESSFUL (total time: 10 seconds)
*/

