---------------------------------------------------------------------------------------------------------------------------
package mutltithreading;
public class unsafe extends Thread 
{
    
    int available=1;
       
    @Override
    public void run()
    {
        if(available>0)
        {
            System.out.println("get the ticket for "+Thread.currentThread().getName()+" at berth no "+ available);
            try{
             Thread.sleep(1000);
            }catch(Exception ex)
            {
                System.out.println(ex);
            }
            //decrement available 
            available--;
            
        }
        else
        {
            System.out.println("ticket not available");
        }
    }
    public static void main(String[] args) throws InterruptedException
    {
        unsafe obj= new unsafe();
        
        Thread t1= new Thread(obj,"first person");
        Thread t2= new Thread(obj,"second person");
        
        t1.start();
        t2.start();
    }
  
}

/*
run:
get the ticket for first person at berth no 1
get the ticket for second person at berth no 1
BUILD SUCCESSFUL (total time: 1 second)


what happened in above program is that same berth is booked for two different persons. 
steps:
 1)t1 starts and asks for booking
 2)since available>0, ticket is booked with berth no= 1(available)
 3)now t1 sleeps(without decrementing the value of available)..
 4)meanwhile, t2 starts and it also asks for booking a ticket
 5)ticket is available as t1 has not decremented the no of available tickets, so available is still 1.
 6)since available>0, ticket is booked with berth no =1(available)
 
 -> "so a problem occured, i.e. two persons got the same berth"
 Lets eradicate this problem using thread synchonization(i.e. puttting locks).
 */
 --------------------------------------------------------------------------------------------------------------------------
 What is Thread synchronization ?
 
 When a thread is already acting on an object, preventing any other thread from acting on the same object is called 'thread 
 synchronization' or 'thread safe'. The object on which threads are synchronized is called 'synchronized object'.
 Thread synchronization is recommended when multiple threads attempts to access an object.
 
 
 Java provides a way of creating threads and synchronizing their task by using synchronized blocks. Synchronized blocks in 
 Java are marked with the synchronized keyword. A synchronized block in Java is synchronized on some object. All synchronized
 blocks synchronized on the same object can only have one thread executing inside them at a time. All other threads 
 attempting to enter the synchronized block are blocked until the thread inside the synchronized block exits the block.
 --------------------------------------------------------------------------------------------------------------------------
 What is the difference between synchronized block and synchronized keyword?
 
 synchronized block is used to synchronize a block of statements whereas synchronized keyword is used to synchronize an 
 entire method.
 
 
-------------------------------------------using synchronized keyword(for run() method)------------------------------------
package mutltithreading;

public class unsafe extends Thread 
{
    
    int available=1;
       
    @Override
    synchronized public void run()
    {
        
        if(available>0)
        {
            System.out.println("get the ticket for "+Thread.currentThread().getName()+" at berth no "+ available);
            try{
             Thread.sleep(1000);
            }catch(Exception ex)
            {
                System.out.println(ex);
            }
            //decrement available 
            available--;
            
        }
        else
        {
            System.out.println("ticket not available");
        }
       
    }
    public static void main(String[] args) throws InterruptedException
    {
        unsafe obj= new unsafe();
        
        Thread t1= new Thread(obj,"first person");
        Thread t2= new Thread(obj,"second person");
        
        t1.start();
        t2.start();
    }
  
}

/*
run:
get the ticket for first person at berth no 1
ticket not available
BUILD SUCCESSFUL (total time: 1 second)
*/
  
-----------------------------------------------OR using synchonized block--------------------------------------------------

package mutltithreading;


public class unsafe extends Thread 
{
    
    int available=1;
       
    @Override
    public void run()
    {
      synchronized(this)   //sunchronize the current object
      {    
        if(available>0)
        {
            System.out.println("get the ticket for "+Thread.currentThread().getName()+" at berth no "+ available);
            try{
             Thread.sleep(1000);
            }catch(Exception ex)
            {
                System.out.println(ex);
            }
            //decrement available 
            available--;
            
        }
        else
        {
            System.out.println("ticket not available");
        }
      } 
    }
    public static void main(String[] args) throws InterruptedException
    {
        unsafe obj= new unsafe();
        
        Thread t1= new Thread(obj,"first person");
        Thread t2= new Thread(obj,"second person");
        
        t1.start();
        t2.start();
    }
  
}

/*
run:
get the ticket for first person at berth no 1
ticket not available
BUILD SUCCESSFUL (total time: 1 second)
*/
----------------------------------------------------------------------------------------------------------------------------
