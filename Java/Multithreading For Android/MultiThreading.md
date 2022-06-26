# MultiThreading
> Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such program is called a thread. 

### `So, threads are light-weight processes within a process.`

### Threads can be created by using two mechanisms
1. Extending the Thread class
2. Implementing the Runnable Interface

### Thread creation by extending the Thread class
> We create a class that extends the **java.lang.Thread** class. This class overrides the ****run()**** method available in the Thread class. A thread begins its life inside run() method. We create an object of our new class and call **start()** method to start the execution of a thread. **Start()** invokes the **run()** method on the Thread object.
```java
class MultithreadingDemo extends Thread 
{ 
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                  Thread.currentThread().getId() + 
                  " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
} 
  
// Main Class 
public class Multithread 
{ 
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            MultithreadingDemo object = new MultithreadingDemo(); 
            object.start(); 
        } 
    } 
} 
```


---

> The Second Way You Already know how , by using `Handler` ( **Which Manages The Thread Que** ) . and calling `post` on it , creating a new `Runnable` , like bellow :
```java
public void deleteFragment() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TabLayout.Tab tab = tabLayout.getTabAt(1);
                tab.select();
                tabLayout.removeTabAt(0);
            }
        },10);
    }
```

In Java : For More Information On This Subject , The Implementation By Using Runnable has come bellow :
```java
class MultithreadingDemo implements Runnable 
{ 
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                                Thread.currentThread().getId() + 
                                " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
} 
  
// Main Class 
class Multithread 
{ 
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            Thread object = new Thread(new MultithreadingDemo()); 
            object.start(); 
        } 
    } 
} 
```

---

## Java.lang.Thread class in Java

> Thread a line of execution within a program. Each program can have multiple associated threads. Each thread has a priority which is used by thread scheduler to determine which thread must run first. Java provides a thread class that has various method calls inorder to manage the behaviour of threads.

### Methods:
> How do you determine if a thread is running?

By Using `Thread.isAlive()` , which returns true or false

you can also use `GetState()` , which returns the state the thread . **warning :**This method is designed for use in monitoring of the system state, not for synchronization control. and the state are an enum **[NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED] ,** more information on this topic at : [This site](https://stackoverflow.com/questions/1323408/get-a-list-of-all-threads-currently-running-in-java)

Important : [Exploring Android Thread Priority](https://medium.com/mindorks/exploring-android-thread-priority-5d0542eebbd1)

Handler Thread
```java
// so --> there is an other way to create a thread other than creating a class wich extends the Thread , and then override its run method , then create instance of it in mainactivity and then call start on it .
// the other way we know too , it is by using the Runnable and override its run method .
// however another way exists ( by creating a HandlerThread ) , then create a Thread in it , just like :
    HandlerThread handlerThread = new HandlerThread("my-process",Thread.NORM_PRIORITY);
    handlerThread.start();
    Handler handler = new Handler(handlerThread.getLooper());
    handler.post(new Runnable() {
       @Override
       public void run() {
           Thread currentThread = Thread.currentThread();
           String showThreadProcess = String.valueOf(currentThread.getName()) + "With Priority Of : " + String.valueOf(Process.getThreadPriority(Process.myTid()));
           Log.i("thisis",showThreadProcess);
           Toast.makeText(getApplicationContext(),showThreadProcess,Toast.LENGTH_LONG).show();
   }
});
```

Another Example
```java
Thread thread = new Thread(new Runnable(){
    public void run() {
       // override in here
    }
});
//if you dont set there priority . threads have a habit to extend there parent thread priority . but background thread are different
thread.setPriority(from 0 to 10); // its a nice thread
thread.start();
```

### Intent Service
> Intent service use handler thread to run the background tasks
> as we don't have access to HandlerThread in IntentService , we can set its priority using Process , in it's onhandle Method .


## An Example Of Thread Interfierence In Android
> you should do remember that you can not access or manipulate the UI **aka** UI thread components , from another thread . since they are not thread safe
> Thus : what is the solution ?
> The Solution Is to use The so called Handler

Very Very Important : [Watch this video](https://www.youtube.com/watch?v=QfQE1ayCzf8) if you want to know what is `Handler` and what is `looper` and what is `messageque`

> what is handler and message quea ?
> by default if a thread starts , it would do its work , then it finishes , and the program would be basically over
> but how is it that android UI dosn't close ?
> the answer is messageQueo
> the thread has a so called messageque and a looper wich loops through this messagequeo , and keeps the thread alive this way
> this messageque contains packages of work to be done .
> so everything we do , for example changing the state of a swich from off to on , or clicking a button , gets put into this message queo . and then execute it sequentially . the looper loops through this message que and this way the thread is keeped alive , and dosn't just finish when its work is done .
> and One responsibility of this Handler class is getting work into this message queo , and by default its associated with the thread where it was instantiated .
> so for example if we create the Handler in our MainActivity . this gets executed on the main thread , so this handler will only work with the messageque of the main thread . it means for us that we can use it to get our work to the main thread .

> we could also create a messageque and the looper for the thread we have created . this way we can keep it alive and feed it later with more work . but if we only need it more , we don't need to do that in this example .

Example : Everything is right ( But this code Crashes ) . take a look and say why ?
```java
public class MainActivity extends AppCompat {

   Button stopbtn = findViewById(R.id.mystartbtn);

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main_activity);
   }
   
   public void buttonClick(View v) {
      MyThread thread = new MyThread();
      thread.start();
   }
   
   public class MyThread extends Thread {
      public void run() {
         for(int i=0;i<10;i++) {
                Log.d(TAG, "stopThread: " + String.valueOf(i));
                stopbtn.setText(String.valueOf(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
      }
   }
}
```
The Answer is Because we didn't use the Handler , and we Tried to access the UI thread Component From another Thread

Fixed Example
```java
//this code is in the MainActivity

private Handler mainhandler = new Handler()

public void stopThread(View v) {
        ArashThread arashThread = new ArashThread();
        arashThread.start();
    }

    public void startThread(View v) {

    }

    public class ArashThread extends Thread {

        public void run() {
            for(int i=0;i<10;i++) {
                Log.d(TAG, "stopThread: " + String.valueOf(i));
                final int j = i;
                mainhandler.post(new Runnable() {
                    public void run() {
                        stopbtn.setText(String.valueOf(j));
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
```

Another way
```java
public class ArashThread extends Thread {

        public void run() {
            for(int i=0;i<10;i++) {
                Handler handler = new Handler(Looper.getMainLooper()); // we call Looper.getMainLooper to tie the Handler to the mainactivity , if we don't do this it won't work , ( because we have created this Handler not in the MainActivity as in the previous example but in our thread . so it won't work if we don't call the Looper.getMainLooper()
                final int j = i;
                mainhandler.post(new Runnable() {
                    public void run() {
                        stopbtn.setText(String.valueOf(j));
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
```

The Convinient Way , is to use the button itself ( post the button itself )
```java
public void run() {
            for(int i=0;i<10;i++) {
                final int j = i;
                stopbtn.post(new Runnable() {
                   public void run() {
                   
                   }
                {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
```

Using Easy Anonymous inner class , instead of defining the Thread class
```java
//in the button click function
pubic void stopButtonClick(View view) {
   new Thread(new Runnable(){
      public void run() {
         // do your work in here
      }
   }).start();
}
```

> using `volatile` boolean variable to stop the thread in its middle action
> basically `volatile` is a keyword that means all thread would use the most updated version of the variable , and not a cached version

```java
private volatile boolean stopThread; // Remember that default value for boolean is false
// then in the run() method of your Thread
for(int i=0;i<10;i++) {
   if(stopThread)
      return;
}
```


---

### How to Make a Thread Alive like UI is
> for this porpuse we need `Looper.prepare()` in our `Thread` class , and **before** we create the `Handler` , because handler only workd on the Threads that have the `Looper` and message queo , **Remember** : Looper and messageque are tied together , so you don't need to create a `messageque` too , by creating `Looper` with the command `Looper.prepare()` , you also create the messageque and then you can create your `thread` and it would be alive as long as you want it to be .
```java
public class MyLooperThread extends Thread {
   public Handler handler();
   public void run() {
      Looper.prepare();
      handler = new Handler();
      Looper.loop();
   }
}
```

Now you can even `add work` to this `thread` in your `MainActivity` , **Opposite of what we did in above examples**
```java
// we are in MainActivity
private MyLooperThread looperThread = new MyLooperThread();
public void addTaskButton(View view) {
   looperThread.handler.post(new Runnable() {
      public void run() {
         for(int i=0;i<5;i++) {
            log.d(tag,"your message" + i);
            SystemClock.sleep(1000);
         }
      }
   });
}
```

its best to `create and instantiate` a `looper` in your `thread` in , this way you can **terminate** a thread whenever you want , just like :
```java
public class MyLooperThread extends Thread {
   public Handler handler();
   public Looper looper;
   public void run() {
      Looper.prepare();
      looper = Looper.myLooper(); // returns the Looper of the current thread
      handler = new Handler();
      Looper.loop();
   }
}
// now you can stop this threadLooper in your main activity with
looperthread.looper.quite();
// also you don't anymore need to 
```

Another example to `post something` to `our thread` from `MainActivity` `Thread`
```java
public void tastA(View view) {
   // Rememeber : we have created our looper by : Looper looper = Looper.myLooper(); in our thread , here we have :
   Handler threadhandler = new Handler(ourThread.looper);
   threadHandler.post(new Runnable(){
      public void run() {
         for(int i=0;i<5;i++) {
            log.d(TAG,"Log something");
            SystemClock.sleep(1000);
         }
      }
   });
}
```

> this `Runnable` actually introduces a Potential memory leak , an anonymous inner class is basically the same of none static inner class , and this none static inner classes has the refrence to the outer class , so our Runnable in above example have a refrence to our activity ( we called it so , the button is in the activity and so on ) . and this is why we can access activity classes  here and activity methods in this `Runnable` `run()` method . this is called an implicit refrence because we don't need an activity variable for it . and as long as we have a refrence to the activity in here , the activity can not be `Garbage Collected`. and think about when the activity is Destroyed , but our thread is still running . problems like when device rotates .
> **The system can only clean up an object . when there is no refrence to it anywhere anymore . but this Runnable do have an implicite refernce to the this activity . thats why we have memory leak . because we have used them in activity**

> One way to solve this problem is to make this `Runnable` `static` in our class . but remember you can't acces the activity variables anywhere anymore , to do that you need a `weak reference` .

### Importanat : this examples our just for academic pupoces , do not use any of this in your real application . instead use `HandlerThread` calss , which is very more convenient .

## Why is it called the MessageQuoe and not Runnable Queo ?
> the answer is because this post , sends a message under the hood . and the difference and resone for using runnable is that runnable runs some code in the `run()` function too .

## Create and use a Message
instead of posting the runnable we can also send the Message directly , first we should create a `Handler` class and override its `handleMessage` function
```java
public class MyHandler extends Handler {

    public void handleMessage(Message msg) {
        if(msg.what == 1) {
            Log.d("mymessage", "handleMessage: " + 1);
        }
        if(msg.what == 2) {
            Log.d("mymessage", "handleMessage: " + 2);
        }
    }
}
```

```java
// in the MainActivity
Message msg = Message.obtain();
msg.what = 1; // set some information , what type of message we want to execute
looperThread.handler.sendMessage(msg); // calling sendMessage instead of post
```

> one thing to note is that the application knows what it should do with `Runnable` , it shall run it , but with the `Message` , we should tell it what to do , and we do it by creating a `Handler` class .


---

## HandlerThread
> **NOTE :** One benefit of `handlerThread` is that it already has the `Looper` . so we can assign a handler to it just by calling `Handler handler = new Handler(handlerThraed.getLooper());`

> `handlerThread` would do what we did in previous examples very more easily . **also** try to not include `handlerThread` in the activity , because of the strange acting that activity has , like destroying on rotate and etc... . instead try to create `HandlerThread` in a `Service` because it dosn't destroy on rotation and etc...

> **NOTE :** avoid using the `handlerThread.post()` in the activity ( as we already said it caueces memory leak because it has reference to the activity , instead an `static` `class` like bellow :

> **NOTE :** `HandlerThread` only executes works sequentially . so in bellow example although there is only 2 seconds gap till the first one post , that causes the second one to run , and the first one should wait untill the second one ( ExampleRunnable2 ) is finished its job

```java
public class MainActivity extends AppCompat {
	private static final String TAG = "MainActivity";
    private HandlerThread handlerThread = new HandlerThread("HandlerThread");
    private Handler threadHandler;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        handlerThread.start();
        threadHandler = new Handler(handlerThread.getLooper());
    }
	
	public void doWork(View view) {
		threadHandler.postDelayed(new ExampleRunnable1(),2000);
		threadHandler.post(new ExampleRunnable2);
	}
	
	static class ExampleRunnable1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable 1 : " + i);
                SystemClock.sleep(1000);
            }
        }
    }
	
	static class ExampleRunnable2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable 2 : " + i);
                SystemClock.sleep(1000);
            }
        }
    }
	
	
}
```

> Runnable ( posts ) always add to the end of the que , you can add a work to be at the start of the que by using : **see bellow function**
```java
threadHandler.post(new ExampleRunnable1());
threadHandler.post(new ExampleRunnable1());
threadHandler.postAtFrontOfQueue(new ExampleRunnable2());
// the result is examplerunnable2 would be executed second , why ? .
// because the code first sees the first line
```

> in the first examples we learned that not only we can post Runnables to the ThreadHandler , but also Messages , for this example so we create a new class that `extends` the `HandlerThread`.
```java
// One thing about priority , the higher the number the lower is the priority
public class ExampleHandlerThread extends HandlerThread {

    private static final String TAG = "ExampleHandlerThread";
    private Handler handler;

    public ExampleHandlerThread() { // we deleted the argumets .
        super("ExampleHandlerThread", Process.THREAD_PRIORITY_BACKGROUND);
        // we don't want to initialize the handler in here because it executes on the mainactivity
        // we don't want the handler to be tied to the activity
        // we want the handler to be associated with its background thread not the mainactivity thread
        // for this purpose we overwrite the onLooperPrepared()
        // thats because we know the handler needs Looper . and must be after Looper.prepare()
    }

    protected void onLooperPrepared() {
        handler = new Handler();
    }

    public Handler getHandler() {
        return handler;
    }
}

// in the mainActivy ( above this exampole example ) . instantiate this class instead of HandlerThread 
// and you also won't need to define that handler in main activity , becaue we have it
// in the button function of the main activity we hve :
public void doWork(View view) {
        handlerThread.getHandler().post(new ExampleRunnable1());
        handlerThread.getHandler().post(new ExampleRunnable1());
        handlerThread.getHandler().postAtFrontOfQueue(new ExampleRunnable2());
    }
```

> and as you know we can also create and send `Message` instead of those `RunnableExamples` 
```java
public void doWork(View view) {
   Message msg = Message.obtain();
   msg.what = 1;
   msg.arg1 = 23;
   msg.obj = "can be even a string";
   msg.setData(// requires a bundle);
   
   handlerThread.getHandler().sendMessage(msg);
}
```

as `handlerThread` class now dosn't know what to do with it , we should expand its handler a bit , just like bellow :
```java
protected void onLooperPrepared() {
   handler = new Handler() {
      public void handleMessage(Message msg) {
         switch(msg.what) {
         
         }
      }
   }
}
```


---

## How to Remove Messages And Runnables From the `HandlerThread`
> we know we can stop or quite a `Thread` with `handlerThread.getLooper().quit();` know we learn how to remove messages and runnables when the Thread or more precisely in here `HandlerThread` is still running
```java
public void removeMessages(View view) {
   handlerThread.getHandler().removeCallbacksAndMessages(null) // by putting null all runnables and messages would be deleted , gives a filling that Thread has stoped
}
```

> Removing Runnables and Messages Selectively
```java
// we need to be specific so don't use new RunnableName() in the post method , define it like :
public ExampleRunnable1 runnable1 = new ExampleRunnable1();
public void doWork(View view) {
   handlerThread.getHandler().post(runnable1);
}
public void removeMessages(View view) {
   handlerThread.getHandler().removeCallbacks(runnable1);
}

// but for Removing a Message you just need to pass its what field like :
handlerThread.getHandler().removeMessage(//pass the what number);
// there ara other methods for removing runnables and messsages which take a token . you can use them too
// but to use them remember to giving them a token when posting them .so we have the token when we want to remove them
```

> **IMPORTANT NOTE : do remember to put a handlerThread.quite(); in the onDestroy() function of your Activity**
```java
public void onDestroy() {
   super.onDestroy();
   handlerThread.quit();
}
```



























