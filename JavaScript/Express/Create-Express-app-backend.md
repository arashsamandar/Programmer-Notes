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