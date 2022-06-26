# Multithreading 1

> Multithreading is a process when we can have multiple things going on at the same time , when you setup multithreading you are implementing what java calls `Concurrency` , Concurrent Operations that can execute Simultinously . when you run code within a single class ( say within a main class ) , the process is Linear , only one thing can be executed at a time .  but in order to create multiple Threads , you can eather create your new class that extends the class `Thread` , or you can implement `Runnable` Interface .

### Extending The Thread Class

First Create a Class Which `extends` the `Thread`*

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        int iterations = 5;
        try {
            for (int i = 0; i < iterations; i++) {
                System.out.println("From Secondary Thread");
                sleep(2000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
```

*Then in your Main Class we Have :*

```java
public class Main {
    public static void main(String[] args) {
        int iteration = 3;
        MyThread thread = new MyThread();
        thread.start(); // basically calls the run() method of the your class

        try {
            for (int i = 0; i < iteration; i++) {
                System.out.println("From Main Process");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
```

----

----

### Implementing The Runnable Interface

> EveryThing is the same , except you implement the `Runnable` interface , and just like above paste the code in the `run()` method.

*There Are Two Differences*

1. > you don't have access to `sleep()`method , you should use `Thread.sleep()`

2. > you can't just instantiate the class and call `start()`on it , you have to call it like bellow :

```java
MyRunnable runnable = new MyRunnable();
new Thread(runnable).start(); // and thats how you run it
```

----

----

### Interrupting A Thread

> you can not stop a thread , you Interrupt it with `thread.interrupt()`. lets see an example

```java
public class Main {
    public static void main(String[] args) {
        int iteration = 3;
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(2500); // after 2500 bellow the interupt is called
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt(); // now the thread is interrupted ( stoped )
        System.out.println("Called Interrupt");
        try {
            for (int i = 0; i < iteration; i++) { // and the main goes on even with that call
                System.out.println("From Main Process");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
```

----

----

### Synchronizing Threads

> there are many sorts of applications where multiple threads might need to share a resource , and you need to synchronize these threads , so only One thread at a time has access to that resource .

> in this app we prevented these Thread objects from using the shared resource simultinously we designed the application so that only One can go through `sychronized code block` at a time and others have to wait . 
> and this way , we prevent problems from creeping into the application that otherwise may happen when accessing an object that can't be shared

*The Target Class That We Pass To These Threads Is*

```java
public class TargetClass {
    public void call(int threadId) {
        System.out.println("Calling thread from : " + String.valueOf(threadId));
    }
}
```



*And Here is The Example Thread Class*

```java
public class MyThread extends Thread {
    private int threadId;
    private TargetClass target;

    public MyThread(int threadId,TargetClass target) {
        this.threadId = threadId;
        this.target = target;
    }

    public void run() {
        synchronized (target) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target.call(threadId);
        }
    }
}
```

*And Now in the Main Class We Have*

```java
public class Main {
    public static void main(String[] args) {
        TargetClass target = new TargetClass();
        // all classes have the same object of TargetClass
        MyThread t1 = new MyThread(1,target);
        MyThread t2 = new MyThread(2,target);
        MyThread t3 = new MyThread(3,target);

        t1.start();
        t2.start();
        t3.start();
    }
}
```

--------

# Multithreading 2

## Introduction To Threads In Java

> Threads allow multiple actions to be performed at the same time inside a single process .

> when you have a machine with multiple cores , you can run multiple tasks at the same time . 

![](F:\Programming Notes\Java\Java Advanced Training\assets\Multithreading.png)

> Like a process, a thread is an independent path of execution , that runs in isolation. Each thread has its own stack and its own local variables .
>
> so when a method is running on a thread, the local variables in the method are only available within that thread.

- **Why Not Use Different Processes instead of threads ?**

> the answer is that threads are more closely connected to eachOther than seperate proccesses . when you open an email app on your computer , and then open a browser window , those things are seperate proccesses and have nothing to do with each other .
>
> **But threads inside the same process are more closely connected , they share memory with other threads , all of the threads have the same access to global variables . which this can sometimes lead to issue and mean that care should be taken**

![](F:\Programming Notes\Java\Java Advanced Training\assets\processthreads.png)

-------

## The Thread Class in Java

- > `Thread.activeCount()` , you can use to get the number of threads that are running .

- > `Threas.isAlive()` , if you want to see your threas is running or not .

- > `Threas.setName()` , the application would automatically give my thread a name . we can change the name , and this way keep track of it .

:pushpin:*An Example so you see thread are running Parallelly*

```java
public class ThreadExample extends Thread {
    @override
    public void run() {
        int i = 1;
        while(i<100) {
            System.out.println(i + this.getName());
            i++;
        }
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        ThreadExample example = new ThreadExample();
        example.setName("__My First Thread");
        example.start();
        ThreadExample example1 = new ThreadExample();
        example1.setName("__Second Thread");
        example1.start();
    }
} // the output is Interesting , both threads would show outputs at the same time
```

--------

## Using Runnable Interface

> Runnable is an Example of `Functional InterFace`which we have learned before . so we can use lambda for it .

> The benefit of `Runnable interface` instead of `Extending the Thread` class , is that if we extend the Thread class in java we can't extend any other class , but with Interface we can  ( without using lambdas )

```java
public class RunnableExample implements Runnable {
    @override
    public void run() {
        int i = 0;
        while(i<= 100) {
            System.out.println(i + " " + Thread.currentThread.getName());
            i++;
        }
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new ExampleRunnable());
        // this is not very efficent to create another class which implements Runnable
        Thread threadTwo = new Thread(new Runnable(){
           @override
            public void run() {
                // do whatever you want here
            }
        });
        threadTwo.start();
    }
}
```

> Using lambdas

```java
public class Main {
    public static void main(String[] args) {
        Thread threadTwo = new Thread(() -> {
           int i = 0;
           while(i < 100) {
               System.out.println(i + Thread.currentThread.getName());
               i++;
           }
        });
        threadTwo.start();
    }
}
```

------

## Synchronized Methods In Java

> When using multi-threaded applications, problems can sometimes occur when more than one thread is inside the same method. simulation of this situation is bellow :

> in bellow example we have to use `Synchronized` for the `withDraw`method , otherwise both thread would get the first line `amount` at the same time . and both would enter `if true`. and the user would withDraw more that his/her amount in the bank

```java
public class BankAccount {
    private int balance = 0;
    public void topUp(int amout) {
        this.balance += amout;
    }
    public void debit(int amount) {
        this.balance -= amount;
    }
    int getBalance() {
        return this.balance;
    }
}
```

*and in the `ATM` Class we have*

```java
public class ATM {
    static void withDraw(BankAccount account,int amount) {
        int balance = account.getBalance();
        System.out.println(balance-amount);
        if((amount-balance) > 0) {
            account.debit(amount);
            System.out.println("$" + amount + "successfully Withdrawn");
        } else {
            System.out.println("Transaction denied");
        }
        System.out.println("Current Balance Is : " + account.getBalance());
    }
}
```

*And in the `User`Class we have*

```java
public class Users {
    static final BankAccount account = new BankAccount(50);
    public static void main(String[] args) {

        account.topUp(100);

        Thread t1 = new Thread(() -> {
            ATM.withDraw(account,100);
        });
        Thread t2 = new Thread(() -> {
            ATM.withDraw(account,100);
        });
        t1.start();
        t2.start();
    }
}
```



