### Creating a simple express server that has several API Endpoints

> first go to your folder , run `npm init`
>
> then `npm install express`
>
> then create a `index.js` file with below codes

```javascript
const express = require('express');
const app = express();
app.use(express.jsone());

app.listen(3000,()=>console.log('Server Started On Port 3000'));
```

> now to get data from `mongoDB` we have :
>
> ```
> npm install mongoose
> // and
> npm install express
> ```
>
> and then :
>
> ```javascript
> const app = require('express')();
> const mongoose = require('mongoose');
> // or
> const express = require('express');
> const app = express();
> const router = express.Router();
> 
> // Create An Schema for Users
> const UserSchema = mongoose.Schema({
>     username:string,
>     password:string,
> });
> // then create the model in `models` folder :
> const user = mongoose.model('user',UserSchema);
> // and then we can have :
> 
> router.get('/user/:id',(req,res)=>{
>     let id = 0;
>     if(req.params.id) {
>        id = req.params.id; 
>     }
>     res.send(id);
> })
> ```

## Defining middleware in express.js

> In Express.js, middleware is a function that has access to the request object (req), the response object (res), and the next middleware function in the application’s request-response cycle, typically denoted by the variable `next`
>
> __Important__ : we send a response to user with `res.send()` , but pay good attention that once you use `res.send()` or `res.json()` or any `res` , then the process will get finished.
>
> __Important__ : you can not use `res.send` both in your middleware and in your `route handler` .
>
> __Important__ : instead use `req` to attach something to the request and then you could get it in the `next` middleware or route handler , like below :
> ```react
> // in middleware
> req.yourMessage = "this is my message to the next middleware or route handle"
> // and in the route handler you can check for it like so :
> if(req.yourMessage) {
>     res.send('auth successfull with message ' + req.yourMessage);
> }else {
>     res.send('auth failed');
> }
> ```
>
> 

## difference between route handler and middleware

> The main difference between a middleware function and a route handler is that a middleware function will usually call `next()` to pass control to the next middleware function in the stack, whereas a route handler typically does not call `next()` because it ends the request-response cycle by sending a response back to the client .

-------------

## What is a Session ID Cookie

#### Session

> Sessions are a way to store user-specific data across multiple requests. They allow you to maintain state and store user information, such as login status or user preferences.

#### Session ID Cookie

> When a user visits a website, a unique session ID is generated for that user. This session ID is stored in a cookie on the user's browser. The session ID is used to identify the user's session and retrieve the associated session data on the server.

## Make a simple cookie like session ID in express.js

```react
const app = express();
const session = require('express-session');
const express = requite('express');
const mongoStore = require('connect-mongo');

app.use(express.json());
app.use(session({
    secret:'some-key-here',
    resave:false,
    saveUninitialized:true,
    store:mongoose.create({mongoUrl:'mongodb://localhost/myDatabase'});
}));
// above create the `session store` , or i mean a collection in our `myDatabase` mongodb database so it could manage the session in it and save at least a `session ID` there
// also we have :
app.listen(3000,()=>console.log('server started arash'));

app.use(session({
    secret:'somevaluehere',
    resave:false,
    unInitialized:true,
    store:mongoStore
}));

app.use('/',myRouteFunctionOrMiddleWare);
app.get('/user/login',async(req,res)=>{
   req.session.username = "arash samandar" ;
});

app.get('/user/welcome',async(req,res)=>{
    if(req.session.username) {
        res.send('Welcome ' + req.session.user);
    }
});
```

### How to Check Using Windows 10 PowerShell

```
$userData = @{
    username = "john.doe"
    password = "password123"
}
Invoke-RestMethod -Method POST -Uri "http://localhost:3000/user" -Body ($userData | ConvertTo-Json) -ContentType "application/json"
```

OR

```
# Define the user data
$userData = @{
    username = "john.doe"
    password = "password123"
}

# Convert the user data to JSON
$jsonData = $userData | ConvertTo-Json

# Set the API endpoint URL
$apiEndpoint = "http://localhost:3000/register"

# Send a POST request to the API endpoint
$response = Invoke-RestMethod -Method POST -Uri $apiEndpoint -Body $jsonData -ContentType "application/json"

# Display the response
$response
```

OR

```
# Register a new user
$userData = @{
    username = "john.doe"
    password = "password123"
}
$jsonData = $userData | ConvertTo-Json
$registerUrl = "http://localhost:3000/register"
$response = Invoke-RestMethod -Method POST -Uri $registerUrl -Body $jsonData -ContentType "application/json"
$response

# Login with the registered user
$loginData = @{
    username = "john.doe"
    password = "password123"
}
$jsonData = $loginData | ConvertTo-Json
$loginUrl = "http://localhost:3000/login"
$response = Invoke-RestMethod -Method POST -Uri $loginUrl -Body $jsonData -ContentType "application/json"
$response

# Access the welcome route with the JWT token
$token = $response.token
$welcomeUrl = "http://localhost:3000/welcome"
$headers = @{ "Authorization" = "Bearer $token" }
$response = Invoke-RestMethod -Method GET -Uri $welcomeUrl -Headers $headers
$response
```

## create variable in `powershell`

#### how to create a `hashtable` in powershell and what it is

> hashtable in windows powershell is used to define `key-value` pairs easily , like in bellow command to check the `express api` we have :
>
> ```
> $headers = @{
>     "Content-Type" = "application/json"
>     "Authorization" = "Bearer your_token_here"
> }
> ```
>
> then sending them with :
>
> ```
> $token = "your_token_here"
> $headers = @{
>     "x-auth-token" = $token
> }
> 
> Invoke-RestMethod -Uri "https://example.com/api/endpoint" -Headers $headers -Method GET
> ```

## The `Config` module and it's porpuse :

> in the root of our project we can create a folder named `config` , this folder would have files like `default.json` , `development.json` and or `published` version.
> then install the `config` module with below command into your project :
>
> ```
> npm install config
> ```
>
> after than you can use like below and get the constants you have set into the json files , and it decides the value by whether we are in `development` or in `publish` or in the `default` case , all by below code :
> ```react
> const config = require('config');
> 
> if(config.get('arashValueAuthentication')) {
>     console.log('Authentication needed');
> }else{
>     console.log('Authentication Not Needed');
> }
> ```

{
"username":"arash.samandar",
  "email":"somevalue.folan@gmail.com",
  "password":"Samandar#10"
}



eyJhbGciOiJIUzI1NiIsInR5asdfcCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFyYXNoLnNhbWFuZGFyIiwicGFzc3dvcmQiOiIkMmEkMTAkUm1FT1ZhbVU2LjNhbFk0QXZ4Y3JHZU9UWmVyNW9mMkg3b0tMMUdZNHJBVkpoSXQxY01VUjIiLCJpYXQiOjE2OTI4OTM0Nzd9.vF1uHbrFfPC8w2_dDeGpjkrgYVsZXn-AhelGvjoHgW0



{
  "username":"arash.solomon",
  "email":"arash.some@gmaill.com",
  "password":"Samandar#111"
}

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFyYXNoLnNvbG9tb24iLCJwYXNzd29yZCI6IiQyYSQxMCRmUGhFRjlCaGhDSGRmVVk2bUJYL0UuWDR2V0tQbjhnbEFpdGNXcExtREZmd0l1NzlOdWl2VyIsImlhdCI6MTY5MjkwMjI4OX0.tFm8HsCwQSDAJIePu1FztPdd-Fkgq8-JihQ7eFtloDY
