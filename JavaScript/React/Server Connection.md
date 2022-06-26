## sending data in Laravel

> for sending data from the controller you can use

```php
public function getTasks() {
    $allTasks = Tasks::all();
    return response()->json($allTasks);
}
```

> or you can do like bellow

```javascript
return Response::json(array(
    'item_image' => $item_image,
    'item_something' => $item_something,
    'item_more' => $item_more,
));
```

> > Now on the `React` side , we use `axios`

## getting data in React

> in react you can simply use the `post`method of the `axios`, example is bellow :

```javascript
import React,{Component} from 'react';
import {render} from "react-dom";
import axios from 'axios';

export default class Arash extends Component {
    state = {
        tasks:null,
    };

    componentDidMount() {
        axios.get('/gettasks').then(response => { // IN HERE ....
           console.log(response.data[0].id);
        });
    }

    render() {
        return (
          <h1>Hello Arash Component</h1>
        );
    }
}
```

## Posting data in React to Laravel

> we use the `post`method of the `axios`Library . just like bellow :

```javascript
axios.post(`https://jsonplaceholder.typicode.com/users`, { user })
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
```

> we have also

```javascript
axios.delete(`https://jsonplaceholder.typicode.com/users/${this.state.id}`)
      .then(res => {
        console.log(res);
        console.log(res.data
      })
```

## Reading Data In Laravel

> first of all , don't forget you need to change your `web.php Route` . to `Route::post()`

> after that here is what we have in Controller & in React Component 

```javascript
export default class Arash extends Component {
    componentDidMount() {
        let name = "samandar";
        axios.post('/gettasks',{name}).then(response => {
           console.log(response);
        });
    }
    render() {
        return (
          <h1>Hello Arash Component</h1>
        );
    }
}
```

```php
class TasksController extends Controller
{
    public function returnTasks(Request $request) {
        $name = $request->name;
//        $alltasks = Tasks::all();
        $yourname = "you said your name is : " . $name;
        return response()->json($yourname);
    }
}
```

## React Tutorial

> we know that the best place to get data from back-end is the `ComponentDidMount`method .

> a promis is an object that holds the result of an Asynchronous Operation . an Asynchronous Operation is an operation that is gonna get complete later .
>
> so this promise objects promises to hold the information untill the end . you will see the cons promise bellow 
>
> there is always going to be a delay , so this promise object promises to hold the result of an Asynchronous Operation .
>
> when we create a promise , initially it is in the pending state , and then it is in the succes , in case of succeed , or failur .

```javascript
componentDidMound() {
    const promis = axios.get('/getTasks');
    console.log(promise);
}
```

## getting the data from the promise

> well this promise has a method called `.then()` .

> but there is a more modern and better way , by using `await`and `async` in the function declaration

```javascript
async componentDidMount() {
    const response = await axios.get('/getTasks');
    console.log(response);
}
```

#### :pushpin:Now we do Above Example this way 

```javascript
// the Key of whole proccess is To USE async
export default class Arash extends Component {
    state = {
        value:null,
    }
    async componentDidMount() {
        let name = "samandar";
        const {data:posts} = await axios.post('/gettasks',{name});
        this.setState({value:posts});
    }
    render() {
        return (
          <h1>{this.state.value}</h1>
        );
    }
}
```

## Updating with Axios

> we have several methods for `axios`, for creating new data we use `post` , for updating data we use `put` . ( we do not want the whole data to be refreshed as we update one , so we use index to get the currently changed post) , look bellow example :

```javascript
handleUpdate = async (post) => {
    post.title = "UPDATED";
    await axios.put(TheURLVariable + '/' + post.id,post);
    
    const posts = [...this.state.posts];
    const index = posts.indexOf(post);
    posts[index] = {...post};
    this.setState({posts});
}
```

## Pessimistic VS Optimistic

> in our application there is a delay between the user pushes the delete button , or add button or update , and he/she gets the result of the operation ( and thats because we first implement the server request , and then we do the update of the screen )

> in `Optimistic`approach , we can first do the operation , then call the server . this way user has the delusion of a fast application .
>
> and then if something in the server side went wrong , we can catch the error and set the screen back to where it was before the Operation .

```javascript
handleDelete = async (post) => {
    const OriginalPosts = this.state.posts;
    
    const posts = this.state.posts.filter(p => p.id !== post.id );
    this.setState({posts});
    
    try {
        await axios.delete(TheUrlVariable + '/' + post.id);
    } catch(ex) {
        alert('Something failed while deleting the Post');
        this.setState({posts:originalPosts});
    }
}
```

