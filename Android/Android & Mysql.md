# Android & Mysql
---
> To Connect to server `Mysql` and `Php` in an Android Program there are several steps we need to follow
### 
### Configuring `AndroidManifest` file

1. in the `AndroidManifest` write the `permission` to be able to connect to internet through android app
```markup
<uses-permission android:name="android.permission.INTERNET" />
```

2. in the `AndroidManifest` set ClearText to true in the manifest , and also write a config file to be used in the manifest file.
```markup
<application
    android:networkSecurityConfig="@xml/network_security_config"
    android:usesCleartextTraffic="true"
```
> and when we create a `resource` file for SecurityConfig , in that file we write  :
```markup
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <base-config cleartextTrafficPermitted="true">
        <trust-anchors>
            <certificates src="system" />
        </trust-anchors>
    </base-config>
</network-security-config>
```
> also remember the settings `Http Proxy` dosn't use any custom proxy , when `AVD` is launching

---

## Writing Code For HttpUrlConnection

> we can use `3` approach .
- using `AsynkTask<String,String,String>` wich is a `background thread`
- using `AsynkTaskLoader`
- using `IntentService` , this option is better , as it won't stop if user changes the device direction , wich makes `onResume` fire again

### Using `IntentService` :
> as you now `intent` is a message object in android , with `IntentService` we can run a `background thread` easily .
1. first we need to create a `class` wich `extends` the `IntentService`
1. then in the `MainActivity` we call that IntentService class .
1. we also need to write a `BroadCastReciever` , eather in its own `class` or in the MainActivity wich is luanching it
1. and in the `IntentService` class , we handle the request in its `onHandleIntent` method . we also define its `constructor`
> here is the code in the `launcher activity`
```java
public class MainActivity extends AppCompatActivity {
    ArashBroadCastReciever broadCastReciever = new ArashBroadCastReciever();
    
    public void onCreate() {
            LocalBroadcastManager.getInstance(getActivity())
            .registerReceiver(broadCastReciever, new IntentFilter("Intent_Filter_Name"));
    }
}

public void onButtonClick() {
            Intent intent = new Intent(getActivity(), LoginService.class);
            intent.putExtra("any_information_youWant", usernameAndPassword);
            startService(intent);
}
```

> we get results in our `BroadCastReciever` , and thats why we registered it in the MainActivity Above
> Now we define our custom `BroadCastReciever` class , pay attention you can use `Handler` if you want to access something in the `MainActivity`
```java
public class MyBroadCastReciever extends BroadcastReceiver {

    public void onReceive(final Context context, final Intent intent) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if (intent.hasExtra("error")) {
                    String errorMessage = intent.getStringExtra("error");
                    Toast.makeText(context.getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                } else {
                    Intent intentOne = new Intent(context, UserMainPage.class);
                    intentOne.putExtra("object",intent.getParcelableExtra("object"));
                    intentOne.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentOne);
                }
            }
        });
    }
}
```



> and now in the `IntentService class`
```java
public class LoginService extends IntentService {
     
     public LoginService() { super("LoginService"); }
     
     protected void onHandleIntent(Intent intent) {
         String info = intent.getExtra("any_information_youPassed");
        // do whatever you want , like making a connection with HttpUrlConnection
        // wich i would explain later in this chapter
        // then
        Intent resultIntent = new Intent("Intent_Filter_Name");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(resultIntent);
     }
     
}
```


---
# Using HttpUrlConnection
```java
// for example in the onHandleIntent function above , we can write :
public static String registerUser(String name,String family,String email,String username,String password,String image,String url) {
        try {
            URL connectionUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)connectionUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            OutputStream outputStream = conn.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_data =

                    URLEncoder.encode("username","UTF-8") + "=" +
                    URLEncoder.encode(username,"UTF-8") + "&" +
                    URLEncoder.encode("password","UTF-8") + "=" +
                    URLEncoder.encode(password,"UTF-8")
                    + "&" +
                    URLEncoder.encode("name","UTF-8") + "=" +
                    URLEncoder.encode(name,"UTF-8")
                    + "&" +
                    URLEncoder.encode("family","UTF-8") + "=" +
                    URLEncoder.encode(family,"UTF-8")
                    + "&" +
                    URLEncoder.encode("email","UTF-8") + "=" +
                    URLEncoder.encode(email,"UTF-8")
                    + "&" +
                    URLEncoder.encode("image","UTF-8") + "=" +
                    URLEncoder.encode(image,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();bufferedWriter.close();outputStream.close();
            InputStream inputStream = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            String line;String result = "";
            while((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();inputStream.close();conn.disconnect();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Seems like it didn't finished its job";
}
```

---

## Using `Json_encode` to pass data From `Php`
> in `above` example we only send some data , but when we want to get it , we send it with `Json Array` and we get it as `JSONObject` in android
> bellow is `php code` for sending just one user :

### Look How We echo data with `Jsone_encode($data)`
```php
<?php
require 'conn.php';
header('Content-type: application-json');
if(isset($_POST["username"]) && isset($_POST["password"])) {
    $user_name = $_POST["username"];
    $user_pass = $_POST["password"];
    $base64Image = null;
    $user_id = null;
    $name="";$family="";$email="";$image="";

        $queryOne = "SELECT * FROM android_users WHERE username='$user_name'";

        $conn->set_charset("utf8");
        if($conn->query($queryOne)) {
            $result = $conn->query($queryOne);
            if($result->num_rows > 0) {
                $row = $result->fetch_assoc();
                $hashed_password = $row['password'];
                if(password_verify($user_pass,$hashed_password)) {
                    $name = $row['name'];
                    $family = $row['family'];
                    $email = $row['email'];
                    $user_id = $row['id'];
                    $queryTwo = "SELECT user_image FROM android_users_images WHERE user_id = '$user_id'";
                    if($imagequeryresult = $conn->query($queryTwo)) {
                        $resultTwo = $imagequeryresult->fetch_assoc();
                        $image = $resultTwo['user_image'];
                        $JsonArrayImage = ['name' => $name,'family' => $family,'email' => $email,'image' => $image];
                        echo json_encode($JsonArrayImage);
                    } else {
                        $JsonArray = ['name' => $name,'family' => $family,'email' => $email];
                        echo json_encode($JsonArray);
                    }

                } else {$JsonArray = ['name' => 'password mismatch'];echo json_encode($JsonArray);}
            } else {$JsonArray = ['name' => 'username mismatch'];echo json_encode($JsonArray);}
        } else {  $JsonArray = ['name' => 'query failed'];echo json_encode($JsonArray);}

} else {
    $JsonArray = ['name' => 'No Input'];echo json_encode($JsonArray);
}
```

> send `select * from users` , wich contains a lot of data , in `Php` we have :
```php
<?php require 'conn.php';

$conn->set_charset("utf8");

$query = "SELECT android_users.username,android_users.password,android_users.name,android_users.family,android_users.email,android_users_images.user_image
 FROM android_users
 INNER JOIN android_users_images ON android_users.id = android_users_images.id";
 $queryTwo = "SELECT * FROM android_users";
if($result = $conn->query($query)) {
    while($post = $result->fetch_assoc()) {
        $posts[] = $post;
    }
    header('Content-type: application-json');
    echo json_encode(array('posts' => $posts));
}
```

> and we get this bunch of users in android with :
`Look that we remove "{" character`
```php
while((line = bufferedReader.readLine()) != null) {
                result += line;
            }
bufferedReader.close();inputStream.close();conn.disconnect();
result = result.substring(result.indexOf("{"));

// and converting this String of result to json object , and if data is an array of datas fetched from database : like Select * from users
JSONObject jsonObject = new JSONObject(result);
JSONArray jsonArray = jsonObject.getJSONArray("posts");
// and to populate an Object Model wich has a constructor to get JSONObject as its parameter and fill its properties
// to populate that we have :
List<UserObject> userObjectList = new ArrayList<>();
for(int i=0;i<jsonArray.lenght();i++) {
   UserObject userObject = new UserObject(jsonArray.getJSONObject(i));
   userObjectList.add(userObject);
}
```

> getting data for a single object is the same , except we don't need to use `JSONArray`
```php
while((line = bufferedReader.readLine()) != null) {
                result += line;
            }
bufferedReader.close();inputStream.close();conn.disconnect();
result = result.substring(result.indexOf("{"));
// converting to json
JSONObject jsonObject = new JSONObject(result);
```




















### 