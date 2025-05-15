## Updating the `state` with `this.setState()`

> in this example we define `username` and `password` directly in `this.state` , like bellow
>
> *Notice that we could mention them in the `this.setstate({})` object with `[]` brackets...

```javascript
export default class Arash {
    constructor(props) {
        super(props);
        this.state = {
            data: {
            	'username':'',
            	'password':'',
            }
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(e) {
        const changeData = {...this.state.data};
        changeData[e.target.name] = e.target.value;
        this.setState({data:changeData})
    }
    handleSubmit(e) {
        console.log(this.state);
    }
    render() {
        return (
            <div>
            	<input type='text' name="username" onChange={()=>this.handleChange(e)}
            </div>
        )
    }
}
```

> but in `functional` Components we have :

> now notice that `state` objects are not merged, Meaning that you have to write them explicitely even and if you only want to update one of it's properties, the entire object properties must be written, like bellow :

```react
const [input, setInput] = useState({
  name: '',
  email: '',
});

setInput({
  name: 'John',
  // email is not included here, so it will be lost
});
// Notice Bellow code
setInput({
  ...input, // copy all existing state properties
  name: 'John', // update the name property
});
```



## How To Import CDN in React ?

> you can use another `.css` file and in it you include the `url` for that cdn
>
> ```css
> @import url('https://www.folancdn.com')
> ```
>
> and then import it in your `JSX` file , like always :
>
> ```jsx
> import './myCss.css';
> ```

## using `Void` functions

> when your function has a `return` , you should use `()` paranteses
>
> ```jsx
> getBtnClasses = () => {
> 	let value = 0;
>     	return value;
> }
> // now you call it with () , like bellow :
> <button onClick={this.getBtnClasses()}>Show Value</button>
> ```

## Refactoring The Code

> if you are working on a `*.jsx or *.js` file , and its poluted with code . you can extract some of them , and put them in another `.js` file , like defining several functions , them export the functions , and you can use them ,
>
> like bello :

```javascript
// a ".js" file is bellow
import {toast} from 'react-toastify';

function showToast(myString='text') {
    toast(myString);
}

function showLog(logString) {
    console.log(logString)
}

export default {
    showToast,
    showLog,
}
```

> and in the *for example* `index.js` we would have :

```javascript
import React,{Component} from 'react';
import arashFunctions from 'folan.js';


export default class Samandar extends Component {
    handleFolan = () => {
        arashFunctions.showToast('say hello baby');
        arashFunctions.showLog('lets show some logs baby');
    }
    render() {
        <div>
            <button onClick={this.handleFolan}>Click Me<button>
        <div>
    }
}
```

> if you don't use `export default` , and just use `export` , like bellow , then you have to import `functions` , one by one . like bellow :

```javascript
export {
	funcOne,
    funcTwo
}
```

```javascript
import {funcOne,funcTwo} from 'folan.js';

// and use it like bellow :

handleFolan = () => {
    funcOne();
    funcTwo();
}
```

## NOTE :

> if there is not any function , and its just raw code , then just import them . thats all

```javascript
console.log('folan meghdar');
let arash = "samandar";
toast.info(arash);
const valueA = [1,2,3,4];
// etc ...

// then just import them like bellow :
import './services/folan.js';
```

