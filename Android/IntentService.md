# IntentService

> An **Intent Service** is designed to run tasks on the background , and is well souted to longer running tasks . Unlike AsynkTask or AsynkTaskLoader , *An intent Service is completely detached from the user interface* , it runs in it's own Thread , and dosn't have access to the main thread . it isn't contained within the activity and it can't call the activities methods . but it can communicate to the apps visuals here using **BroadCast Messages** 
>
> and because its using BroadCast Messages it can send information to any component . not just a single activity .

> > start by creating a class that extends IntentService

```java
public class MyIntentService extends IntentService {

    public static final String TAG = "Arash";
    public static final String MyService_Message = "MyServiceMessage";
    public static final String MyService_Payload = "MyServicePayload";

    public MyIntentService() {
        super("MyIntentService");
    }

    protected void onHandleIntent(Intent intent) {
        String samandar = intent.getStringExtra("samandar");
        Log.d("Arash", "onHandleIntent: " + samandar);

        Intent messageIntent = new Intent(MyService_Message);
        messageIntent.putExtra(MyService_Payload,"Servie all done baby");
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getApplicationContext());
        manager.sendBroadcast(messageIntent);
    }
    
    public void onCreate() {
        super.onCreate();
        //....
    }
    
    public void onDestroy() {
        super.onDestroy();
        //....
    }


}
```

> now we have to register the service within the **Application Manifest** or androidmanifest.xml
>
> after </activity> but before </application> write

```xml
<service android:name=".service.MyService" android:exported="false" />
```

> **MainActivity** 

```java
public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra(MyIntentService.MyService_Payload);
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(broadcastReceiver,new IntentFilter(MyIntentService.MyService_Message));
    }

    public void helloFunction(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("samandar","samandarValue");
        startService(intent);
    }

}
```

