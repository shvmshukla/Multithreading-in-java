/*
#The concept behind using thread priority is that "The thread with higher priority number will be given more time hence it 
will finish execution earlier as compared to the thread having less priority"

#Priority varies from [1 to 10]. By default prioeity of a thread is 5 which is depicted by Thread.NORM_PRIORITY=5
Also,  Thread.MIN_PRIORITY=1
       Thread.MAX_PRIORITY=10
*/
package mutltithreading;
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
        int count=0;
        for(int i=0;i<5;i++)
        {   
            count++;      //counts number upto 5
         }
        
        System.out.println("completed thread"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
    }
    
    public static void main(String[] args) throws InterruptedException 
    {
        
        MyClass obj1= new MyClass("cut the ticket");
        MyClass obj2= new MyClass("show the seat");
        Thread t1= new Thread(obj1,"one");
        Thread t2= new Thread(obj2,"two");
        //set the priority to threads
        t1.setPriority(2);
        t2.setPriority(10);  
        
        t1.start();
        t2.start();
               
    }
        
}

/*
run:
completed threadtwo  10
completed threadone  2
BUILD SUCCESSFUL (total time: 0 seconds)
*/

