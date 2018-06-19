----------------------------------------------------------------------------------------------------------------------------
//Objective: You can not start the same thread again and again. It will give you IllegalThreadStateException

package mutltithreading;

/**
 *
 * @author shivam
 */
public class MyClass extends Thread 
{
    public void run()
    {
        System.out.println("Inside run method");
    }
    
    public static void main(String[] args) throws InterruptedException 
    {
        MyClass obj= new MyClass();
        Thread t= new Thread(obj);
        t.start(); 
        t.sleep(2000);
    System.out.println("Thread state is "+Thread.currentThread().getState()+" so  thread 't' can not be /"
                + "started again Hence exception will occur when we try to do that in next statement");
        t.start();
    }
        
}

/*
OUTPUT:
Inside run method
Thread state is RUNNABLE so  thread 't' can not be /started again Hence exception will occur when we try to do that in next statement
Exception in thread "main" java.lang.IllegalThreadStateException
	at java.lang.Thread.start(Thread.java:708)
	at mutltithreading.MyClass.main(MyClass.java:27)
/home/shivam/.cache/netbeans/8.2/executor-snippets/run.xml:53: Java returned: 1
BUILD FAILED (total time: 2 seconds)
*/

/*
A thread will throw the exception when calling start if the thread's state (as retrieved by Thread.currentThread().getState() 
is anything other than NEW i.e.your thread is in one of the other states, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING or 
TERMINATED. You can check the trhread state by printing Thread.currentThread().getState().
*/
----------------------------------------------------------------------------------------------------------------------------
/*
we can start two different threads which is shown as follows
*/
package mutltithreading;

/**
 *
 * @author shivam
 */
public class MyClass extends Thread 
{
    public void run()
    {
        System.out.println("Inside run method "+Thread.currentThread().getId());
    }
    
    public static void main(String[] args) throws InterruptedException 
    {
        MyClass obj= new MyClass();
        Thread t1= new Thread(obj);
        Thread t2= new Thread(obj);
        t1.start(); 
        t2.sleep(2000);
        t2.start();
    }
        
}
/*
run:
Inside run method 10
Inside run method 11
BUILD SUCCESSFUL (total time: 2 seconds)
*/
---------------------------------------------------------------------------------------------------------------------------
