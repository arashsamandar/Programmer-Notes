

[TOC]

## What is React

> Everything in `React`is a `Component`
>
> react is a javascript library that is used to build `UI`(User Interfaces)
>
> react is expanded beyound the web with React native , a tool that lets us build native mobile applications using react .

![](E:\Programmer-Notes\JavaScript\React\assets\react.png)

> React is used by `Uber` , `netflix` & `tweeter` these days

:warning:**NOTE** : `do remember to run : `*npm run production* when you are done

:warning:**NOTE** : `also remmeber you have to use : `*npm run watch* **when you are working and writing react**

#### React makes Updating the DOM faster by using `DOM Diffing`

> meanig instead of reading and writing to and from the DOM manually , with DOM Diffing we use Javascript Objects , wich are faster , and it makes the minimal changes neccessary .
>
> lets say we want to add a radio button to its group . instead of creating it again , we only add the neccessary object .
>
> with react we never read through the dom , we only change it when neccessary .

![](E:\Programmer-Notes\JavaScript\React\assets\diffing.png)

## write a simple react code

```react
window.onload = function () {
    const title = React.createElement(
        'h1',
        {id:'title',className:'header'},
        "Hello world"
    )
    ReactDom.render(
        title,
        document.getElementById('react-container')
    )
};
// Using Const this can be written like bellow

const { createElement } = React;
const { render } = ReactDOM;


window.onload = function () {
    const title = createElement(
        'h1',
        {id:'title',className:'header'},
        "Hello world"
    )
    render(
        title,
        document.getElementById('react-container')
    )
};
```

## What is JSX

> jsx is javascript's xml , its a tag based syntax that we can use to create react element much like creating html . so intead of `createElement`above we use tags now .

## What is Webpack

> Webpack is a module bundler that helps us create static files . and helps us Automate proccesses that need to happen before our file goes into production .

> for example , we might have several references to several scripts and even css files . every one of this file is an http request . so what webpack does is it combine all of them into one bundle . and one file means one request

![](F:\Programming Notes\JavaScript\React\assets\webpack.png)

:pushpin:**pay attention in code if you put one wrong everything would be cleared**

## how to work in laravel

> first use the bellow command

*php artisan reset react*

> then

*npm install && npm run dev*

> now in the laravel folders you would have a `node_module`folder . also in the `resources` -> `js` -> `components`you will have an `Example`component . basically you create components like this and in this folder .

:pushpin:*an example component*

```react
import React, { Component } from 'react';

export default class Arash extends Component {
    helloWorld(name) {
        return ("hello" + " " + name);
    }
    goodbyeWorld(name) {
        return ("GoodBye " + name)
    }
    render() {
        return (
            <div class="container">
                <div>&nbsp;</div>
                <button type="button">
                    {this.helloWorld(this.props.name)}
                </button>
                <button>
                    {this.goodbyeWorld(this.props.family)}
                </button>
                <button type="button">
                    {this.props.backcountry}
                </button>
                <div>&nbsp;</div>
                <button type="button">
                    {this.props.goal}
                </button>
            </div>
        )
    }
}
```

> after that you will also have an `app.js`in the `resources` -> `js`folder



> create another file named `index.js` , this is where you render you components , or add properties with {} sign to them . like bellow :

:pushpin:*index.js*

```react
import React, { Component } from 'react';
import { render } from 'react-dom'
import Arash from "./Arash";

window.React = React;

render (<Arash total={50}
               powder={20}
               backcountry = {10}
               goal = {100}
/>, document.getElementById('react-container'));


```

**now your component is being rendered in here**



> now include you index file in the `app.js`that we have said about

```json
require('./bootstrap');
require('./components/index');
```



> in the last step add the file from `public` -> `js` -> `app.js` & `public` -> `css` -> `app.css` to your blade file .



> you also need to run `npm run watch`



> after that you must add bellow line to your `package.json`for the `state`to work

```json
"babel": {
        "presets": [
          "@babel/preset-env",
          "@babel/preset-react"
        ],
        "plugins": [
            "@babel/plugin-proposal-class-properties"
        ]
    }
```

> and then install => `npm install --save-dev @babel/plugin-proposal-class-properties`

*and then run an update for compose*

## adding functions to component

> you can add functions pretty easily by simply naming them . in above example of a component you can see one . just like bellow

```react
import {React} from 'react';
import {Component} from 'react';

export default class Arash extends Component {
    sayHello(name) {
        return ("Hello " + name);
    }
    render() {
        <div>
            {this.sayHello(this.props.name)}
        </div>
    }
}
// which props exists in our index.js file where we also render
// index.js
import React, { Component } from 'react';
import { render } from 'react-dom'

render(</Arash name="Arash">,document.getElementById('arash-container'));
```

## Adding React Icons

> first run

*npm install --save react-icons*

> then run

*npm install react-icons@^2 --save*

> after that you can use icons like bellow

```react
import FaBeer from 'react-icons/lib/fa/beer';
export default class Arash extends Components {
    myFunction(username,passowrd) {
        return ("you are" + username + " " + password)
    }
    render() {
        <div>
            <FaBeer/>
        </div>
    }
}
```

## :pushpin: Composint Components

> When we think of React User Interfaces `UI`in short , they are just collection of composed Components .

## Embeding Expressions ( Properties )

> we embed with `state = {}`

```javascript
import React , {Componet} from 'react'
class Counter extends Component {
    state = {}
    render() {
        return (
           <div>
               <h1>Hello world</h1>
               <button>Increment</button>
            </div>
        );
    }
}

export default Counter;
```



:pushpin:**NOTE :** *Where ever you have multiple use of an state like count in bellow , use the `const {count}`*

```javascript
export default class Arash extends Component {
    state = {
        count:0,
    };
    formatCount() {
        const {count} = this.state
        return count === 0 ? <h1>Zero</h1> : count;
    }
}
```

## Applying Styles

> we apply styles in {{}} 

:pushpin:**Like Bellow**

```java
import React , {Component} from 'react';

export default class Counter extends Component {
    state = {
        count:0
    };
    formatCount() {
        const { count } = this.state
        return (count === 0 ? 'Zero' : count);
    }
    render() {
        return (
          <div className="pt-5">
              <span style={{ fontSize:30 }}>
                  {this.formatCount()}
              </span>
              <button>Increment</button>
          </div>
        );
    }
}

```

## a note on javascript true and trucy

> when we have something like bellow

```javascript
true && false // result is false
true && "Hi" // result is Hi , "Hi" is considered trucy and would be returned as evaluation result .
```

## note on onClick function of a button in javascript

> you don't write them as bellow with ()

```javascript
<button onClick={this.somefunction()} // this is wrong
```

```javascript
<button onClick={this.somefunction} // this is write
```

## binding Event Handlers

> we can not access an state in a function normally in `jsx` because of using `use strict`in javascript . but we have access to this in the constructor method . and we can bind the function we want to this in that constructor , just like bellow

```javascript
handleIncrement() {
    console.log("Increment",this);
} // this code is wrong and would not function
```

> but we can use constructor to bind this to our method , like bellow :

```javascript
import React , {Component} from 'react';

export default class Counter extends Component {
    state = {
        count:0,
        tags:["tag1","tag2","tag3"]
    }

    constructor() {
        super();
        this.handleIncrement = handleIncrement.bind(this);
    }

    handleIncrement() {
        console.log("Increment Clicked",this);
    }

    renderTags() {
        if(this.state.tags.length === 0)
            return <p>There are now tags!</p>
        else
            return <ul>{this.state.tags.map(tag => <li key={tag}>{tag}</li>)}</ul>
    }

    getBadgeClasses() {
        let classes = "badge m-2 badge-"
        classes += (this.state.count === 0) ? "warning" : "primary"
        return classes;
    }

    formatCount() {
        const {count} = this.state;
        return count === 0 ? "Zero" : count;
    }

    render() {
        return (
          <div>
              <span style={{fontSize:15}} className={this.getBadgeClasses()}>{this.formatCount()}</span>
              <button onClick={this.handleIncrement}
                      className="btn btn-secondary btn-sm">
                  Increment
              </button>
          </div>
        );
    }


}

```

> another way is using arrow functions like bellow

```javascript
Increment = () => {
    console.log("increment Clicked",this);
}
```



## changing the state values

> we can not use

```javascript
Increment = () => {
    this.state.count++ // it would not work
}
```

> instead we use `setState()`like bellow

```javascript
Increment = () => {
    this.setState({count:this.state.count + 1});
}
```

> Use New way like bellow :

```react
handleIncrement = () => {
    this.setState(prevState => ({count:prevState.count + 1}));
}
```

## Passing Event Arguments

> so whereEver you need to pass an Arguments to Event Handlers ( like onClick ) .
>
> simply pass an arrow function here and the body of the function called event handler , then pass an arguments . like bellow .

```javascript
handleIncrement = product => {
        console.log(product)
        this.setState({count:this.state.count + 1});
    }

    render() {
        return (
          <div>
              <span style={{fontSize:15}} className={this.getBadgeClasses()}>{this.formatCount()}</span>
              <button onClick={() => this.handleIncrement(product)}
                      className="btn btn-secondary btn-sm">
                  Increment
              </button>
          </div>
        );
    }
```

## Using map on a Component state Array

```javascript
import React,{Component} from 'react'
render() {
    state = {
       counters:[
         {id:1,value:0}
         {id:2,value:0}
         {id:3,value:0}
         {id:4,value:0}
       ]
    }
    return (
       <div>
           {this.state.counters.map(
             counter => <Counter key={counter.id} value={counter.value} selected={true}
           )}
        </div>
    )
} // by reading bellow green note , so we can just use counter = {counter} instead of id and value . counter has all properties in it . and we do not need to add one property every time we need . counter already has everything in it .

render() {
        return (
            <div>
                {this.state.counters.map(counter => (
                    <Counter
                            key={counter.id}
                            onDelete={this.handleDelete}>
                            counter = {counter}
                    </Counter>
                ))}
            </div>
        )
    }
// and we also access them in Counter Component with
    this.props.counter.id
```

> > you see we have added `key`,`value`, and `selected`
> >
> > this values now are in `props`of `Counter`Component
> >
> > `key`attribute is used internally by react . that's why we have id too , dispite they are they same , so we can use id as a prop , because we can not use `key`,because it is used internally by react .



:pushpin:**so as we saw we connected them , first with using the map and assing every value of the array to a Counter Component**

:pushpin:**after that by setting value and selected we had two property (props) in the Counter Component which we access by `props` and changing like bellow**

```javascript
export default class Counter extends Component {
    state = {
        value:this.props.value
    }
}
```

> so you see that attributes we set using the `map` in the `<Counter `where passed to the Counter as `props`, and you should know that props are *read only*

> also if we put something between the `<Counter><h1>title</Counter`like this . we can also access it ( it is children ) . we can manipulate it in our Counter , the can only be manipulated if we put them in the state too . like the thing we did with value and we put it into the state and then we incremnet it with a function .

> Another thing is Childlern . when we pass something between the <Counter > tag , it is a children and is accesible in Counter Component . an example of this is when we are using dialog boxex .

```javascript
render() {
    return (
      <div>
       {this.state.counters.map(counter => (<Counter id={value.id} value={counter.value}>
        <h4>Title</h4>
        </Counter>
        ))}
      </div>
    )
}
```

> we can use `children` in Counter Component now by using `this.props.children`

## What is the Difference between Props & State

> props includes data that we give to a component ( as you saw in previous example )
>
> where az state is include data that is local to that component . meaning others Component can not access that state . it's completely internal to that Component .

## One Rule Of Thumb

:pushpin:**The Component that owns a piece of the state should be the one modifying it**

> like in our example for clearing the value number , we shall use `Counters`& not `Counter`, this is although we have written the `Delete`method in the `Counter`but we raise an event from Counter to be red by the Counters . like bellow picuter

![](E:\Programmer-Notes\JavaScript\React\assets\raiseevent.png)

> basically we need to add a new method to our Counters component , and pass a reference to this method via props to the counter component .

```java
handleDelete = (counterId) => {
    console.log("Event Handler Called",counterId);
}

<Counter key={counter.id} value={counter.value} onDelete={this.handleDelete}>
</Counter>

// now in the Counter Component we have
<button onClick={() => this.props.onDelete(this.props.id)} class="btn btn-danger btn-sm" />
```

![](E:\Programmer-Notes\JavaScript\React\assets\handledelete.png)

> so Counter raises the `props.onDelete` & Counters handles `handleDelete`

## another example of using map in counters

```javascript
export default class Counters extends Component {
    state = {
        counters:[
            {id:1,value:4},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0},
        ]
    };

    handleReset = () => {
        const counters = this.state.counters.map(c => {
           c.value = 0;
           return c;
        });
        this.setState({counters});
    };
} // well this is because as you know ( maps returns an array with the operation of that method on it . its not the case with forEach that returns nothing),
// here what i did is mutating the variable (e.value = 0), and return it to new counter
```

## Controlling a component

> as mentioned before , to controll a component value , we get it's value from another ( Parent ) Component . and we get the value by `props`not by the child component `state`, we also do functions with ( creating them in the Parent Component ) and then put that function like before we did . and we action that by onclick of the child component wich again points to a Parent method// with `props` , just like bellow

```javascript
// in the Parent Component
import React , {Component} from 'react';
export default class ParentComponent extends Component {
    state = {
        counters:[
            {id:1,value:4},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0},
        ]
    };

    handleDelete = (counterId) => {
        console.log("this is counter component number",counterId);
    }

    render() {
        return (
          <div>
             {this.state.counters.map(counter => (
                <ChildComponent key ={this.id} counter ={counter}
                                onDelete = {this.handleDelete}
                 </ChildComponent>
              ))}  
          </div>
        );
    }
}
// and in the ChildComponent we have
import React , {Component} from 'react';
export default class ChildComponent extends Component {
    render() {
        return (
           <div>
               <button onClick={() => this.props.onDelete(this.props.counter.id)}
            </div>
        )
    }
}
```

## Cloning in React

> cloaning in react is done using `...`like bellow

```javascript
handleIncrement = (counter) => {
    const counters = [...this.state.counters];
};
```

> how to add an item to the `cloned const` **?**

```javascript
import React, { Component } from "react";
import { getMovies } from "../services/fakeMovieService";
import { getGenres } from "../services/fakeGenreService";

export default class MainComponent extends Component {
    state = {
        movies:[],
        genres:[]
    }

    componentDidMount() {
        const genres = [{name:'All Genres'},...getGenres()]; // this is how we add an element to the clone
        this.setState({movies:getMovies(),genres}); // we wrote genre alone cause key and value are same
    }

    render() {
        return(
        
        )
    }
}
```





#### in order to follow the Rule of thumb that we mentions before we do value update in the Parent element . then pass it to the ChildElement ( to get the argument from it ) , like bellow :

:pushpin:

```javascript
state = {
        counters:[
            {id:1,value:4},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0},
        ]
    };

handleIncremenet = (counter) => {
    const counters = [...this.state.counters];
    const index = counters.indexOf(counter);
    counters[index].value++;
    this.setState({counters});
}

render() {
    return(
       <div>
          {this.state.counters.map(counter => (
              <Counter 
                     key={counter.id}
                     counter = {counter}
                     onIncrement={this.handleIncrement}
           ))}
        </div>
    )
}

// and now in the ChildComponent (Counter) we have

render() {
    return(
       <div>
           <button onClick={() => this.props.onIncremenet(this.props.counter)}
        </div>
    )
}
```

## Components In Syncc

> to do that first we change the structore of our application like bellow

![](F:\Programming Notes\JavaScript\React\assets\changeStructure.png)

:pushpin:**NOTE : ** *when you want to use multiple Component in your Project , you have to use React.Fragment , like Bellow :;*

```javascript
import React,{Component} from 'react';
import Counters from 'counters';
import NavBar from 'navbar';

export default class App extends Component {
    render() {
        return (
          <React.Fragment>
            <NavBar/>
            <main className="container">
              <Counters/>
            </main
          <React.Fragment>
        )
    }
}
```

#### Earlier before we could have manage to share the counters[] to from Counters ( which was the Parent ) , to the Counter (Which is the child) , but in bellow diagram how do we share it to the Navbar ?

![](E:\Programmer-Notes\JavaScript\React\assets\relationshipParenChild.png)

#### Well the solution is to shift the parent one Level Up ( meaning the parent should be App )

![](E:\Programmer-Notes\JavaScript\React\assets\rele.png)

> just like above

:pushpin:**And so we do it like bellow , we go two level down for Counter , like bellow**

> *this is `App.jsx`*

```java
import React,{Component} from 'react';
import NavBar from './navbar';
import Counters from "./Counters";

export default class App extends Component {

    state = {
        counters:[
            {id:1,value:4},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0}
        ]
    };

    handleIncrement = (counter) => {
        const counters = [...this.state.counters];
        const index = counters.indexOf(counter)
        counters[index] = {...counter};
        counters[index].value++;
        this.setState({counters});
    }

    handleReset = () => {
        const counters = this.state.counters.map(c => {
            c.value = 0;
            return c;
        });
        this.setState({counters});
    };

    handleDelete = (counterId) => {
        const counters = this.state.counters.filter(c => c.id !== counterId);
        this.setState({counters});
    };

    render() {
        return (
            <React.Fragment>
                <NavBar/>
                <main className="container">
                  <Counters onReset={this.handleReset}
                            onIncrement={this.handleIncrement}
                            onDelete={this.handleDelete}
                            counters={this.state.counters}
                  />
                </main>
            </React.Fragment>
        );
    }
}
```

> *this is `Counters.jsx`*

```java
import React,{Component} from 'react'
import Counter from './Counter'

export default class Counters extends Component {


    render() {
        return (
            <div>
                <button onClick={this.props.onReset} className="btn btn-primary btn-sm m-2">Reset</button>
                {this.props.counters.map(counter => (
                    <Counter
                            key={counter.id}
                            counter={counter}
                            onDelete={this.props.onDelete}
                            onIncrement={this.props.onIncrement}
                    >
                    </Counter>
                ))}
            </div>
        )
    }
}
```

> *This is `Counter.jsx`*

```javascript
import React , {Component} from 'react';

export default class Counter extends Component {

    getBadgeClasses() {
        let classes = "badge m-2 badge-"
        classes += (this.props.counter.value === 0) ? "warning" : "primary"
        return classes;
    }

    formatCount() {
        const {value} = this.props.counter;
        return value === 0 ? "Zero" : value;
    }

    render() {
        return (
          <div>
              <span style={{fontSize:15}} className={this.getBadgeClasses()}>{this.formatCount()}</span>
              <button onClick={() => this.props.onIncrement(this.props.counter)}
                      className="btn btn-secondary btn-sm">
                  Increment
              </button>
              <button onClick={() => this.props.onDelete(this.props.counter.id)} class="btn btn-danger btn-sm m-2">Delete</button>
          </div>
        );
    }


}
```



##### as you see first the function in `App.jsx`  are the functions that are in use in `Counter.jsx` , But first they are sent to the `Counters.jsx`and then `Counters.jsx`sends them to `Counter.jsx`and there in the `Counter.jsx`they are used . 

#### except the "one function" named `handleReset` which is used in Counters Component as `OnReset` that is used directly in `Counters`Component . and the "counters" variable which is also in use in `Counters`Component

## StateLess Functional Components

> so wach that bellow become

```javascript
import React,{Component} from 'react';

export default class NavBar extends Component {
    render() {
        return (
            <nav className="navbar navbar-light bg-light">
               <a class="navbar-brand" href="#">
                   Navbar
                   <span className="badge badge-pill badge-secondary">
                       {this.props.totalCounters}
                   </span>
               </a>
            </nav>
        );
    }
}
```

> This Stateless functional Component

```javascript
import React,{Component} from 'react';

const NavBar = (props) => {
    return (
        <nav className="navbar navbar-light bg-light">
            <a class="navbar-brand" href="#">
                Navbar
                <span className="badge badge-pill badge-secondary m-2">
                       {props.totalCounters}
                </span>
            </a>
        </nav>
    );
};

export default NavBar;
```

> :warning:**Pay Attention that we couldn't use `props` in the stateless function . Instead we defined the props as an argument in the start of the Stateless Function**

> :warning:**we can also just use the** `({totalCounter})` part we want , and we don't have to use `props` at all



#### and for the class to remove `props`we use :

```javascript
export default class Arash extends Component {
    render() {
        
        const = {onReset,counters,onDelete,onIncrement} = this.props // now we remove the props and this from the start of them .
        
        return(
          <div>
          </div>
        )
    }
}
```

## Component LifyCycle

![](E:\Programmer-Notes\JavaScript\React\assets\ComponentLifyCycle.png)

> to add the props to the constructor first you need to pass `props`to the constructor . like bellow

```javascript
constructor(props) {
    super(props);
    this.state = this.props.something;
}

componentDidMount() { // its the perfect place to do ajax calls .
    // Ajax call
    this.setState({movies});
}
render() { // when a component gets Renderd all Off it's Component would get Renderto
    console.log('App - Rendered');
}
```

:pushpin:**If you need lifycycle Hooks you only need to use normal classes ( you can not use stateless functions )**

## The Update LifyCycle

```javascript
export default class Arash extends Component {
    componentDidUpdate(prevProps,prevState) {
        console.log("prevProps",prevProps);
        console.log("prevState",prevState);
        if(prevProps.counter.value != this.props.counter.value) {
            // perhaps do an Ajax call .
        }
    }
    render() {
        
    }
}
```

## the Unmoiunt lifeCycle

> this is a good place to perhaps clear some listeners and other things

```javascript
componentWillUnmount() {
    
}
```

## NOTES

> using curly braces to signify that we’re leaving JSX and going back to Javascript

> if you want to check the state of a `props`when you change it in the Parent Component , **Always check it in the render() function of the child Element**

:pushpin:*Here is an example code : "Changing the State of `Like`"*

**In The Parent Component**

```javascript
import React,{Component} from 'react';
import Like from './common/like';

export default class MyCom extends Component {
    state = {
        liked:false,
    };

    likeClick = (liked) => {
        (liked === false) ? liked = true : liked = false;
        this.setState({liked});
    };

    render() {
        return (
            <Like liked={this.state.liked} onStateChange={() => this.likeClick(this.state.liked)} />
        );
    }
}
```

## NOTE

> **if you are using `maps`on an array , each element should have a key**

## NOTE

> **We Can Pass Arguments Two Sided . There Are Two Very Good Examples Bellow**

```javascript
export default Child extends Component {
    
    state = {
        like:false
    }
    
    render() {
        return (
            <button onClick={this.props.onIncrement(this.state.like)} // state sent to the parent
        );
    }
}
```

```javascript
import Child from './child';
export default Parent extends Component {
    
    handleIncrement = (like) => { // like comes from Child
        (like === false) ? like = true : like = false;
    }
    
    render() {
        return (
               <Child onIncrement={this.handleIncrement} />
        );
    }
}
```

> **now the vice versa of it**

```javascript
import Child from './child';
export default Parent extends Component {
    
    state = {
        like:false;
    }
    
    handleIncrement = (like) => { // likes come from Parent itself
        (like === false) ? like = true : like = false;
    }
    
    render() {
        return (
               <Child liked={this.state.like} onIncrement={() => this.handleIncrement(this.state.like)} />
        );
    }
}
```

```javascript
export default Child extends Component {
    render() {
        
        let classes = "";
        classes = (like === false) ? 'btn btn-danger' : 'btn btn-succes';
        
        return (
            <button class={classes}>Arash</button>
        );
    }
}
```

## NOTE

> you can set the state of an element of a state with `setState()`, and you can even assign another state to a state like bellow

```javascript
setState({currentPage:page}) // currentPage is a Member of State , while page is just a changing variable .
```

## NOTE

> **`whenever the state of a component is changed > that component and all of its children get rendered `**

*for example we change the state of a member of State in another Component , so all of its children and its render() function get called and rerendered*

> for example in an example of a pagination . `Pagination`is another Component itself . it sends the page number to the Parent ( to the page ) , gets handled there , and as mentioned in above code block setState({currentPage:page}) , so currentPage changes , and got send to the `Pagination` again . AND SO...
>
> and so this way we can keep track of wich page is current page , and wich button should be blue ( meaning we are on that page )

## NOTE

> **we can use the export for `functions`too . just like bellow . and then import it into our Component project**

```javascript
// a javascript file that we have created in another folder
export function paginate(items,pageNumber,pageSize) {
    
}
```

## Using javaScript "lodash" library

> when we want to convert a sequence of numbers to array , we can use loadash .
>
> suppose we 10 numbers . meaning from 1 to 10 : 1...10 , to convert it to an array where each is every of this numbers , we use loadash _.range() like bellow

```javascript
import _ from 'lodash';
pages = 10;
myPagesArray = _.range(1,pages);

// we also have methods like slice and take . which are very usefull to take 4 piece of array every time .
// just like bellow , which is used in pagination
import _ from 'lodash';
export function paginate(items,pageNumber,pageSize) {
    const startIndex = (pageNumber -1) * pageSize; // the whole number of items .
    return _(items).slice(startIndex).take(pageSize).value(); // by looking at the code you would understand
    // that it takes each time a 5 from the number starting from indexOf the item which previous pages took
    // and puts them in an array named "items"
}
```

:pushpin:**lodash Object are recognized by _() , so _(items) creates a loadash Object named "items"**

> and to use this function we simply write

```javascript
import {paginate} from './utils/paginate'; // paginate.js is the name of the file and is in the utils folder
```



> another method of `lodash` is `._orderBy`, which sorts the elements and creates a new array , just like bellow :

```javascript
import _ from 'lodash';
export default class Parent extends Component {
    state = {
        sortColumn:{genre:'title',order:'asc'}
    }
    render() {
        return (
           const sorted = _.orderBy(allMovies,[sortColumn.genre],[sortColumn.order]);
           // _.orderBy(theArraytoSort,sortByWhichOne,assending or decending);
        );
    }
}
```

> lodash can also be used to get the nested property of an object , by using `_.get(object,nested.property)`

> this says , return the object that has the property equal to `nested.property`

## Using prop-types

> we use prop-types to make sure we don't enter the wrong value for a component `props`

:pushpin:*npm install prop-types@15.6.2*

> and we import it to our program with

:pushpin:*import propTypes from 'prop-types'*

> now we use it like

```javascript
import propTypes from 'prop-types';
// after the class definition
Pagination.propTypes = {
    itemsCount:propTyeps.number.isRequired,
    pageSize:propTypes.number.isRequired,
    currentPage:propTypes.number.isRequired,
    onPageChange:propTypes.func.isRequired
}
```

## text properties

> look at the example bellow , and how we can change it to more flexible version

```javascript
export default class Parent extends Component {
    rendre() {
        return (
           <ListGroup 
               items={this.state.gendres}
               textProperty="name"
               valueProperty="_id"
               onItemSelect={this.handleGenreSelect}
        );
    }
}
```

```javascript
export default class Child extends Component {
    render() {
        const {textProperty,valueProperty,items} = this.props;
        return(
          <ul className="list-group">
              {this.props.items.map(item =>
                  <li key={item['valueProperty']} className="list-group-item">{item['textProperty']}</li>
              )}
          </ul>
        );
    }
}
```

#### Using `defaultProps`

> now lets make the above code more simple , so we no longer have to send the `textProperty`& `valueProperty`
>
> instead we define `ListGroup.defaultProps`at the end of it's class definition
>
> these are all because we can use another set of items which may or may not have `name`& `_id`

```javascript
export default class Parent extends Component {
    rendre() {
        return (
           <ListGroup 
               items={this.state.gendres}
               onItemSelect={this.handleGenreSelect}
        );
    }
}
```

```javascript
export default class Child extends Component {
    render() {
        const {textProperty,valueProperty,items} = this.props;
        return(
           <ul classNamee="list-group">
              {items.map(item => 
                  <li key={item['valueProperty']} className="list-group-item">{item['textProperty']}</li>
              )} 
           </ul
        );
    }
}

Child.defaultProps = {
    valueProperty:'_id',
    textProperty:'name'
}
```

## NOTE

> Pay attention that the names you choose for the `props`of a component should be in sync .
>
> So you don't have to Remember ?? what was the name of that Component Property that is for Items . & so on ......

:round_pushpin:**`this is wrong`**

```javascript
<MyComponent onItemSelect={this.handlepages}
             currentPage = {this.currentItem}
```

:pushpin:**This is Right**

```javascript
<MyComponent onItemSelect={this.handleItemSelect}
             selectedItem = {this.selectedItem}
```

> now as you see the name should have a similar type & meaning , pay attention always use the Similarity pattern for naming them .

## NOTE

>put the reusable codes ( Components ) in a Seperate Folder than the root ) 

## NOTE

> we clone an State so we can later use `this.setState()`and pass the cloned version to be copied to the original version .

## using array map inside One another

> it is a nice feature to use multiple `map`on arrays , inside One another , just like bellow :

```javascript
export default class TableBody extends Component {
    render() {
        const {data,columns} = this.props;
        return (
          <tbody>
            {data.map(item => 
             <tr>
               {columns.map(column => <td>{_.get(item,column.path)}</td>)}
             </tr>
             )}
          </tbody>
        );
    }
}
```

## a note on passing the component just like a props

*for example look at the bellow code wich is a legal `jsx` sentence*

```javascript
const x = <h1></h1>; // totaly legal React Element . and so we can have
const y = <Like></Like> // which is a Component .
/ and so we can pass it to an array or props
columns = [
        {path:'title',label:'Title'},
        {path:'genre.name',label:'Genre'},
        {path:'numberInStock',label:'Stock'},
        {path:'dailyRentalRate',label:'Rate'},
        {key:'like',content:movie => (<Like liked={movie.liked} onClick={() => this.props.onLike(movie)}/>)},
        {key:'delete',content:movie => (<button onClick={() => this.props.onDelete(movie)} className="btn btn-danger btn-sm">Delete</button>)},
    ]
```

:pushpin:**and we render it bellow with the renderCell function**

```javascript
import React,{Component} from 'react';
import _ from 'lodash';
export default class TableBody extends Component {

    renderCell = (item,column) => {
      if(column.content) return column.content(item)

      return _.get(item,column.path);
    };
    // NOTE : this component is called with these props
    // <TableBody columns={this.columns} data={movieChunk} />
    render() {
        const {data,columns} = this.props;
        return(
            <tbody>
            {data.map(item =>
                <tr>
                    {columns.map(column => <td>{this.renderCell(item,column)}</td>)}
                </tr>
            )}

            </tbody>
        );

    }
}
```

## Importing CSS

> for importing css to your javaScript file simply use `import ./App/style.css`