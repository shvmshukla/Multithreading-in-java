/*
What is a daemon Thread?
---------------------------------------------------------------------------------------------------------------------------
1) A daemon thread is a thread that executes continuously.Daemon threads are service providers for other threads or objects.
It generally provides background processing.

2) It is a low priority thread.

3)If you call the setDaemon() method after starting the thread, it would throw IllegalThreadStateException.

*/
public class DaemonThread extends Thread
{
    public void run()
    { 
        // Checking whether the thread is Daemon or not
        if(Thread.currentThread().isDaemon())
        { 
            System.out.println("This is Daemon thread"); 
        } 
         
        else
        { 
            System.out.println("This is User thread"); 
        } 
    } 
     
    public static void main(String[] args)
    { 
     
        DaemonThread t1 = new DaemonThread();
        DaemonThread t2 = new DaemonThread();
        DaemonThread t3 = new DaemonThread();
     
        // Setting user thread t1 to Daemon
        t1.setDaemon(true);
             
        // starting all the threads 
        t1.start(); 
        t2.start(); 
        t3.start();
         
        // Setting user thread t3 to Daemon
        t3.setDaemon(true);
         
    } 
}

/*
This is Daemon thread
This is User thread
This is Daemon thread
*/

