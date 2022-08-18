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
> 

















