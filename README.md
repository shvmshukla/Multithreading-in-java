# Multithreading-in-java

Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such program is called a thread. So, threads are light-weight processes within a process.

Threads can be created by using two mechanisms :
1. Extending the Thread class
2. Implementing the Runnable Interface

Thread creation by extending the Thread class

We create a class that extends the java.lang.Thread class. This class overrides the run() method available in the Thread class. A thread begins its life inside run() method. We create an object of our new class and call start() method to start the execution of a thread. Start() invokes the run() method on the Thread object.

# Some points about Thread.sleep

1. it is always the current thread that is put to sleep
2. the thread might not sleep for the required time (or even at all); the sleep duration will be subject to some 
system-specific granularity, typically 1ms;
3. while sleeping, the thread still owns synchronization locks it has acquired;
4. the sleep can be interrupted (sometimes useful for implementing a cancellation function);
