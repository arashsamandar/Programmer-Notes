## Composing Components

```javascript
import React,{Component} from "react";
import Counter from "./counter";
export default class Counters extends Component{
    state={
        counters:[
            {id:1,value:0},
            {id:2,value:0},
            {id:3,value:0},
            {id:3,value:0}
        ]
    }
    render() {
        return (
            <div>
                {this.state.counters.map(
                    counter => <Counter key={counter.id}/>
                )}
            </div>
        )
    }
}
```

> the above code is like

```javascript
import React,{Component} from "react";
import Counter from "./counter";
export default class Counters extends Component{
    state={}
    render() {
        return (
            <div>
                <Counter/>
            	<Counter/>
            	<Counter/>
            	<Counter/>
            </div>
        )
    }
}
```

## Props (Component Composite)

> when we use a `Component` in another `Component` , we can pass values that are called `Props`

> like bellow :arrow_double_down: , the __Counters__ Component has four __Counter__ in itself 

```javascript
import React,{Component} from "react";

class Counter extends Component {
    state = {
        count:this.props.value, // props is used here .
        tags:['tag1','tag2','tag3'],
    };
    renderTags() {
        if(this.state.tags.length === 0) return 'there are no tags defined';
        return <ul>{this.state.tags.map(tag => <li key={tag}>{tag}</li>)}</ul>
    }
    formatCount() {
        const {count} = this.state;
        return count === 0 ? 'Zero' : count;
    }
    getBtnClasses() {
        let classes = "btn btn-sm m-2 btn-";
        classes += (this.state.count === 0) ? "warning" : "secondary";
        return classes;
    }
    handleIncrement = () => {
        this.setState({count:this.state.count + 1});
    }
    render() {
        console.log('props',this.props.value); // here we pass props which includes all the 		attributes that we send to the component.
        return (
        <React.Fragment>
            <span className={this.getBtnClasses()}>{this.formatCount()}</span>
            <button onClick={this.handleIncrement} className="btn btn-primary">Increment</button>
            <br></br>
        </React.Fragment>
        )
    }
}
```

```javascript
import React,{Component} from "react";
import Counter from "./counter";

export default class Counters extends Component{
    state={
        counters:[
            {id:1,value:4},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0}
        ]
    }
    render() {
        return (
            <div> // as you see we call multiple (4) Counter Object and we pass values (props)
                {this.state.counters.map(
                    counter =>
                        <Counter
                            key={counter.id}
                            value={counter.value}
                            selected={true}/>
                    	)}
            </div>
        )
    }
}
```

### Children of props

> when we pass values in between the component , they would be passed and we name them `props.childeren` , like bellow :arrow_double_down:

```javascript
<Counter key={counter.id}>
    <h1>Title</h1> // now this is a prop.childeren
</Counter>
// access it in the other Component with
{this.props.childeren} // Note that it is not a function and is declared like this.props.childeren
```

### Difference beween props and state

> props include data that we give to a component whearas state includes data that is local or private to that component ( so other component can't reach it )

### Raising and handling `Event`

> NOTE : the component that owns a piece of the state should be the one modifying it .
>
> in the examples above , the Counters component has acccess to the counters array (which is in the state) , and according to the rule , this component should be the one modifying it .
>
> in bellow example we define the delete in counters , and then we pass a reference to it via props to the counter 

```javascript
export default class Counters extends Component{
    state={
        counters:[
            {id:1,value:0},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0}
        ]
    }
    handleDelete = () => {
        console.log('event handlere called');
    }
    render() {
        return (
            <div>
                {this.state.counters.map(
                    counter =>
                        <Counter
                            key={counter.id}
                            value={counter.value}
                            selected={true}
                            id={counter.id}
                            onDelete={this.handleDelete}> // look at this line that we passed
                        </Counter>
                    )}
            </div>
        )
    }
}
```

```javascript
class Counter extends Component {
    state = {
        value:this.props.value,
    };
    render() {
        return (
        <React.Fragment>
            <span className={this.getBtnClasses()}>{this.formatValue()}</span>
            <button onClick={this.handleIncrement} className="btn btn-primary">Increment</button>
            <button onClick={this.props.onDelete} className="btn btn-danger btn-sm m-2">Delete</button>
            <br></br>
        </React.Fragment>
        )
    }
}
```

### passing argument to it

```javascript
// in Counters class
handleDelete = (counterId) => {
        const counters = this.state.counters.filter(m => m.id !== counterId);
    	this.setState({counters});
}
    render() {
        return (
            <div>
                {this.state.counters.map(
                    counter =>
                        <Counter
                            key={counter.id}
                            value={counter.value}
                            selected={true}
                            id={counter.id}
                            onDelete={this.handleDelete}> 
                        </Counter>
                    )}
            </div>
        )
    }
```

```javascript
// in Counter class
render() {
        return (
        <React.Fragment>
            <span className={this.getBtnClasses()}>{this.formatValue()}</span>
            <button onClick={this.handleIncrement} className="btn btn-primary">Increment</button>
            <button onClick={() => this.props.onDelete(this.props.id)} className="btn btn-danger btn-sm m-2">Delete</button>
            <br></br>
        </React.Fragment>
        )
    }
```

### Single Source of Truth

> in the examples above , if we want to __include__ a button that on click makes all Counter value to zero 0 ) we would have problem .
>
> for that we remove the
>
> ```javascript
> state = {
>         value:this.props.value,
>     };
> ```
>
> so the controller wouldn't have values for itself __we call it a Controlled component__ , and it gets its value only by `props` , and raises events by calling the parent Component .

![image-20220624213615179](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220624213615179.png)

![image-20220624220813047](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220624220813047.png)

> so we take out the `Counter` __state__ , we remove it thus all the datas should be in the Counters and Counter like in the first image , only raises __Events__ , all data and manipulation of data is in the `Counters` Component .
>
> like bellow code :arrow_double_down:
>
> Look at bellow codes carefully :

```javascript
import React,{Component} from "react";
import Counter from "./counter";

export default class Counters extends Component{
    state={
        counters:[
            {id:1,value:0},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0}
        ]
    }
    handleDelete = (counterId) => {
        const counters = this.state.counters.filter(c => c.id !== counterId);
        this.setState({counters});
    }
    handleReset = () => {
        const counters = this.state.counters.map(c => {
            c.value = 0;
            return c;
        });
        this.setState({counters});
    }
    handleIncrement = (counter) => {
        const counters = [...this.state.counters];
        const index = counters.indexOf(counter);
        counters[index] = {...counter}; // because we shouldn't modify the state directly
        // so we clone it above .  
        counters[index].value++;
        this.setState({counters});
    }
    render() {
        return (
            <div>
                <button onClick={this.handleReset} className="btn btn-primary btn-sm m-2">Reset</button>
                {this.state.counters.map(
                    counter =>
                        <Counter
                            selected={true}
                            counter={counter}
                            onDelete={this.handleDelete}
                            onIncrement={this.handleIncrement}
                            key={counter.id}
                    />
                    )}
            </div>
        )
    }
}
```

```javascript
import React,{Component} from "react";

class Counter extends Component {
    formatValue() {
        const {value} = this.props.counter;
        return value === 0 ? 'Zero' : value;
    }
    getBtnClasses() {
        let classes = "btn btn-sm m-2 btn-";
        classes += (this.props.counter.value === 0) ? "warning" : "secondary";
        return classes;
    }
    render() {
        return (
        <React.Fragment>
            <span className={this.getBtnClasses()}>{this.formatValue()}</span>
            <button onClick={() => this.props.onIncrement(this.props.counter)} className="btn btn-primary">Increment</button>
            <button onClick={() => this.props.onDelete(this.props.counter.id)} className="btn btn-danger btn-sm m-2">Delete</button>
            <br></br>
        </React.Fragment>
        )
    }
}

export default Counter;
```

## Multiple Components In `Sync`

> earlear whe had bellow :

![image-20220625125416818](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220625125416818.png)

> so the Counters that has the states is the parent of Counter , and we pass data to it via `props`

> no we create another component named `Navbar` , so to get that in sync , we lift the state one stage up , like bellow :

![image-20220625125549159](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220625125549159.png)

> this is the navbar code :

```javascript
import React,{Component} from "react";

export default class Navbar extends Component{
    render() {
        return (
            <nav className="navbar navbar-light bg-light">
                <a className="navbar-brand" href="#">Navbar {this.props.totalCounters}</a>
            </nav>
        )
    }
}
```

> and in the `App` Component we have bellow :arrow_double_down:
>
> NOTE : Remember that we cut every function of the `Counters` Component , and we move them to the bellow class named `App` , which has both the __<Navbar />__ and __<Counters />__ as sibling along side eachother.
>
> NOTE : the Component bellow has all the state and functions ( but in bellow we cut them to fill less space)

```javascript
import './App.css';
import React,{Component} from "react";
import Navbar from "./components/navbar";
import Counters from "./components/counters";

export default class App extends Component{
    // here must be both the "state" and all functions.
    // we functions as "props" to the Counters Component .
    render() {
        return (
            <React.Fragment>
            <Navbar totalCounters = {this.state.counters.filter(c => c.value > 0).lenght}/>
            <main className="container">
                <Counters 
            		onReset={this.handleReset}
                    onIncrement={this.handleIncrement}
                    onDelete={this.handleDelete}
                    counters={this.state.counters}
            />
            </main>
            </React.Fragment>
        )
    }
}
```

> note that as we pass the `onDelete` and `onIncrement` to the counters component , from there we call them on the `onClick` method , but without any __Arguments__ , because the child class of the counters (meaning counter) , already passes the __Argumens__

> example of `Counters` Component is bellow :

```javascript
export default class Counters extends Component{
    render() {
        return (
            <div>
                <button onClick={this.props.onReset} className="btn btn-primary btn-sm m-2">Reset</button>
                <br></br>
                {this.props.counters.map(
                    counter =>
                        <Counter
                            counter={counter} // note that bellow we havn't pass the Argument 												 as the Counter class already passses them .
                            onDelete={this.props.onDelete}
                            onIncrement={this.props.onIncrement}
                            key={counter.id}
                    />
                    )}
            </div>
        )
    }
}
```

> here is the `Counter` Component bellow :

```javascript
class Counter extends Component {
    render() {
        return (
        <React.Fragment>
            <span className={this.getBtnClasses()}>{this.formatValue()}</span>
            <button onClick={() => this.props.onIncrement(this.props.counter)} className="btn btn-primary">Increment</button>
            <button onClick={() => this.props.onDelete(this.props.counter.id)} className="btn btn-danger btn-sm m-2">Delete</button>
            <br></br>
        </React.Fragment>
        )
    }
}

```

## StateLess Functional Components

> in the Components like `Navbar` which has a short code and doesn't have the `state` , we can use __Stateless Functional Components__ , like bellow code :

> Note that stateless functional components can't read `props` if we don't define them in the `arguments` of the stateless function , like bellow that we put `props` , and we don't need to use `this` keyword .

```javascript
const Navbar = (props) => {
    return (
        <nav className="navbar navbar-light bg-light">
            <a className="navbar-brand p-2" href="#">Navbar {props.totalCounters}</a>
        </nav>
    )
}
export default Navbar;
```

> or like bellow code : note that in above code , we don't have `this` anymore , and we define the props in the arguments of this stateless function .

```javascript
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
    </div>
  );
}

```

> another example of object destructuring is that we define the value in the stateless function arguments , so we don't need to write props.totalCounter , we simply write : bellow code :

```javascript
import React,{Component} from "react";

const Navbar = ({totalCounter}) => { // we removed the props in bellow code .
    return (
        <nav className="navbar navbar-light bg-light">
            <a className="navbar-brand p-2" href="#">Navbar {totalCounters}</a>
        </nav>
    )
}
export default Navbar;
```

> and in the `class` definitions we can use `object destructuring` again , like bellow :

```javascript
export default class Counters extends Component{
    render() {
        const {onReset,counters,onDelete,onIncrement} = this.props;
        return (
            <div>
                <button onClick={onReset} className="btn btn-primary btn-sm m-2">Reset</button>
                <br></br>
                {counters.map(
                    counter =>
                        <Counter
                            selected={true}
                            counter={counter}
                            onDelete={onDelete}
                            onIncrement={onIncrement}
                            key={counter.id}
                    />
                    )}
            </div>
        )
    }
}
```

## LIfecycle Hooks

> phases that the Component Goes Through :

![image-20220626134906565](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220626134906565.png)

> you see that `rener` is presetnt almost in all of the Cycles , render is called when the `state` changes , or when we define new `props`

```javascript
export default class App extends Component {
    state = {};
    constructor(props) { // note that we don't have access to the props , unless we define it in the constructor arguments and super() , like above and bellow :
        super(props);
        console.log('App - constructor');
    }
}
```

```javascript
constructor(props) {
        super(props);
        console.log('App - Constructor');
}
componentDidMount() {
    // is the best place to call Ajax
    // Ajax call
    console.log('App - Mounted');
}
render() {
    console.log('App - rendered')
    return (
    )
}
```

> > __Note : note that when a parent component gets rendered > all of its child would get rendered too .__

> > Note : whever the state of a component is changed , it would be rendered alongside all of its childeren

![image-20220626140702384](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220626140702384.png)

> also , `componentDidUpdate` happens > whenever the state changes or we get a new props , in above image we clicked the Increment and that called the render method , and all of its children would render .

> __componentDidUpdate__ is also a good place that we understand an state or props is changed , and we can call the `Ajax` call .

![image-20220626141244048](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220626141244048.png)

## An Odd Example !

> introducing `Like` Component , and how it works , bellow are its code .
>
> Like is the heart that you see in bellow image .
>
> and its action is to be full (blacked) or empty , answers to click .

![image-20220626191339560](D:\Programming Notes\JavaScript\React\Fast_Notes2.assets\image-20220626191339560.png)

```javascript
import React,{Component} from "react";

export default class Like extends Component{
    state={};
    render() {
        let classes = "fa fa-heart";
        if(!this.props.liked) classes += "-o";
        return (
            <React.Fragment>
                <i
                    style={{cursor:"pointer"}}
                    className={classes}
                    onClick={this.props.onClick}
                />
            </React.Fragment>
        )
    }
}
```

> and in the Movies Component we have :

```javascript
{this.state.movies.map(movie => (
                        <tr key={movie._id}>
                            <td>{movie.title}</td>
                            <td>{movie.genre.name}</td>
                            <td>{movie.numberInStock}</td>
                            <td>{movie.dailyRentalRate}</td>
                            <td>
                                <Like
                                    liked={movie.liked}
                                    onClick={() => this.handleLike(movie)}/></td>
                            <td>
                            <button
                                onClick={() => this.handleDelete(movie)}
                                className="btn btn-danger btn-sm">
                                Delete
                            </button>
                            </td>
                        </tr>
```

> as you can see , the movies array does not have any state or vnamed liked ! but any way we have this peace of code
>
> ```javascript
> <Like liked={movie.liked} onClick={() => this.handleLike(movie)}/>
> ```
>
> even though there is no __movie.liked__

> if you want to see what happens `onClick` , it's code is bellow :

```javascript
handleLike = (movie) => {
        const movies = [...this.state.movies];
        const index = movies.indexOf(movie);
        movies[index] = {...movies[index]};
        movies[index].liked = !movies[index].liked;
        this.setState({movies});
}
```

> but i wonder that we assigned true or false , to a property (liked) , that doesn't exist in the movie array .

> > here is what we have in a movie element , (movies has several of this element (movie))
> >
> > ```javascript
> > {
> >         _id: "5b21ca3eeb7f6fbccd471815",
> >         title: "Terminator",
> >         genre: { _id: "5b21ca3eeb7f6fbccd471818", name: "Action" },
> >         numberInStock: 6,
> >         dailyRentalRate: 2.5,
> >         publishDate: "2018-01-03T19:04:28.809Z",
> >     },
> > ```
> >
> > 
