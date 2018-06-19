package mutltithreading;

import java.io.IOException;

public class MyClass extends Thread 
{
    boolean stop=false;
    public void run()
    {
        
        System.out.println("Inside run method "+Thread.currentThread().getId());
        for(int i=0;0==0;i++)
        {
            System.out.println(i);
            if(stop) return;
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        MyClass obj= new MyClass();
        Thread t1= new Thread(obj);
 
        t1.start();
        System.in.read();  //it will wait for you to get a input from keyboard
        obj.stop=true;     //as soon as you will give an input, value will set to true and thread will stop
                                 //as condition in run() becomes true 
              
    }
        
}

/*
run:
Inside run method 10
0
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
BUILD SUCCESSFUL (total time: 1 second)

*/
