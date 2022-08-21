### what is a promise

> a `promise` is an object that holds the result of an `asynchronous operation`
>
> and __asynchronous Operation__ is an Operation that goes to complete in the future .
>
> when we send an HTTP Request there is going to be a `Delay` to when we get the result . it doesn't happen immediately .
>
> so we store the asynchronous operation in our promise object .
>
> so this promises , promise to holds the result of an asynchronous operation .

### await

> so we can `await` the promise , since we get the result ( result ) , 

```javascript
async componentDidMount() {
      const promise = axios.get('https://jsonplaceholder.typicode.com/posts');
      console.log(promise);
      const response = await promise;
  }
```

### We can write it like bellow :

```javascript
lass App extends Component {
  state = {
      posts:[],
  };

  async componentDidMount() { // bellow we renamed the data to posts with {data:posts}
      const {data:posts} = await axios.get('https://jsonplaceholder.typicode.com/posts');
      this.setState({posts});
  }
}
```

## NOTE :

> if you ever wanted to create a `Constant` , create it , above the class definition , like bellow :
>
> ```javascript
> import axios from 'axios';
> 
> const apiEndpoint = "https://jsonplaceholder.typicode.com/posts"
> class Test extends Component {
>     state = {};
>     render() {
>         return (
>         )
>     }
> }
> ```

### how to put `async` in an `arrow` function , like bellow :

```javascript
handleAdd = async () => {
    const obj = {title:'arash',body:'samandar'};
    const {data:post} = await axios.post(urlEndpoint, obj);
    console.log(post);
}
```

### add `post` that we just sent , to the array of posts, to be shown :

```javascript
state = {
    posts:getPosts(),
}
handleAdd = async () => {
    const obj = {title:'arash',body:'samandar'};
    const {data:post} = await axios.post(urlEndpoint, obj);
    console.log(post);
    
    const posts = [post,...this.state.posts];
    this.setState({posts});
}
```

### The Difference between `PUT` & `PATCH` :

> when we want to update only some properties of an object , we use __PATCH__ .
>
> when we like to change the entire object all together , we use __PUT__

```javascript
handleUpdate = async (post) => {
    post.title = 'arash samandar';
    const {data} = axios.patch(apiEndPiont + '/' + post.id, {title:post.title});
    console.log(data);
}
// and when we use `PUT` :
handleUpdate = async (post) => {
    post.title = "Updated";
    const {data} = axios.put(apiEndPoint + '/' + post.id, post);
    console.log(data);
}
```

### Rename while `Object Destructuring`

> __NOTE__ : you might want something special from `Response` or an `Object` , in this case you can use something like mentioned above , for example to get the __data__ property of the object , we say `{ data }` , or you can also rename it with `{data : post}` , which means > get the data from the response & also change the name to `post` , simple as that :smile:

### update the __view__ after you changed a post with `axios.put(url,object)` , is like bellow :

```javascript
handleUpdate = async (post) => {
    post.title = 'UPDATED';
    await axios.put(apiEndPoint + '/' + post.id, post);
    
    const posts = [...this.state.posts];
    const index = posts.indexOf(post);
    posts[index] = {...post};
    this.setState({posts});
}
```

## Optimistic Approuch

```javascript
handleDelete = async (post) => {
    const originalPosts = this.state.posts;
    
    const posts = this.state.posts.filter(p => p.id !== post.id);
    this.setState({posts});
    // now we try the real deleting of the post with `axios`
    try {
        await axios.delete(apiEndPoint + '/' + post.id);
    } catch (ex) {
        alert('something whent wrong while deleting a post!');
        this.setState({posts:originalPosts});
    }
}
```

## How to go to `catch` block in a try , catch statement :

> just use `throw new Error("")` for this porpuse , like bellow :
>
> ```javascript
> try {
>     await axios.post(apiEndPoint,object);
>     throw new Error('this is an error');
> } catch( exp ) {
>     console.log(exp);
> }
> ```
>

## Exception Handling

> every `exception` object , like above `catch( exp )` > has two properties :
>
> - exp.request
> - exp.response

> we don't get a `exp.response` , it the server is down or something out of ordinary has happened . the `exp.request` property also would be set , if we could send the `submit` submit our form .

## Like Bellow :

```javascript
try {
    // try something
} catch (exp) {
    if(exp.response && exp.response.status === 404 ) alert('post is not found');
    else { console.log('Logging the error : ',exp); alert('unexpected error occoured'); }
}
```

### Using `Axios Interceptors` :

```javascript
axios.interceptors.response.use("success function","error function"); // like bellow code :
//|----------------------------------------------------------------------------------------
import axios from 'axios';
import './bootstraCDN.css';
import React,{Component} from 'react';

axios.interceptors.response.use(null,error => {
   console.log("INTERCEPTOR CALLED");
   return Promise.reject(error); // we use it to pass to the Catch.
});
export default class App extends Component {
	state = {
        posts=[],
    }
    render() {
        return (
        	<div>
            	Hello Mom
            <div>
        )
    }
}
```

### Better Way Is Bellow `To Hanlde Unexpected OR Expected` Error :

> NOTE :musical_note: The Good Thing With Bellow Code is that *__You Write It Once , And Thats All__*

```javascript
import React,{Component} from 'react';

axios.interceptors.response.use(null,error => {
   const expectedError = if(error.response && error.response.status >= 400) &&
       												error.response.status < 500 )
                                                    
   		if(expectedError) return Promise.reject(error);
   		else {console.log("Logging the error : ",ex);	alert('unexpected error')};}
});
export default class App extends Component {
    state = {};
    render() {
        return (
        	<div>
            	Hello Mon
            <div>
        )
    }
}
```

> or you could just pass the `rejected promise` like :  `return Promise.reject(error)` , and catch it in your catch block and show it which ever you see suitable .

## Exporting The __Interceptor__ To Another Module :

> we export it to another module , so that our App would not be poluted , & also we can use it in another modules
>
> like bello :

```javascript
import axios from 'axios';

axios.interceptors.response.use(null,error => {
   const expectedError = if(error.response && error.response.status >= 400) &&
       												error.response.status < 500 )
                                                    
   		if(expectedError) return Promise.reject(error);
   		else {console.log("Logging the error : ",ex);	alert('unexpected error')};}
});

export default {
    get: axios.get,
    post: axios.post,
    put: axios.put,
    delete: axios.delete
}
```

> now just import this file at the top of your App module : :smile: *Like What I Do Bellow*

```javascript
import http from './services/folan.js';

// now instead of the axios.get and .... , we can write bellow :

await http.get('https://www.google.com');  // because we exported all of the axios actions

export default {
    get: axios.get,
    put: axios.put,
    post: axios.post,
    delete: axios.delete
}
```

## Extracting A __Config Module__ :

> you can add a new file with the __.json__ extension , and remove the *Long URL* you have in the above files to connect to jsoneplaceholder.com/posts , we can extract it from there , *and put it to our __config.json__ file* like bellow :

```json
{
    "apiEndPoint":"https://www.jsonplaceholder.typiconde.com/posts"
}
// note : we can have several other values added here , but for now we have the above .
```

> and then we import it to our module like so :

```javascript
import React,{Component} from 'react';
import config from './config.json';
export default class Arash extends Component {
    handleTest = async () => {
        const promise = await http.get(config.apiEndPoint); // here we use it like this line.
    }
    render() {
        return (
        	<div>Hello Mom<div>
        )
    }
}
```



