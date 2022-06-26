## Bingind `this`keyword to a function

> Solution One ) by default methods that we call in an `onClick`of a button do not have access to this , in there `implementation` , so we use `constructor`for that porpuse . and we use the `bind`method on that function to pass the `this` . there is an example bellow for `handleIncrement` :

```javascript
export default class MyComponent extends Component {
    state = {
        count:0,
    };

    constructor() {
        super();
        this.handleIncrement = this.handleIncrement.bind(this);// Here we bind it
    }

    handleIncrement() {
        console.log("Increment Clicked ",this.state.count); // So here we can use it
    }

    render() {
        return(
            <div>
                <span className={this.getBadgeClasses()}>{this.formatCount()}</span>
                <button onClick={this.handleIncrement}>Increment</button>
            </div>
        );
    }
```

> Solution Two ) use the Arrow Function .

## An Example Of Incrementng a Property Of State

> you can use expressions in `this.setState` like `this.setState({count:this.state.count + 1})`

```javascript
export default class Parent extends Component {
    state = {
        count:0,
    }

    IncrementCount = () => {
        this.setState({count:this.state.count + 1});
    }

    render() {
        return (
          <button onClick={this.IncrementCount}>Increment</button>
        );
    }
}
```

## How to Pass Arguments to the Funcions in React

> you can use two function , use one of them to pass arguments to another one . like bellow :

```javascript
export default class Parent extends Component {
    state = {
        count:0,
    }
     
    handleIncrement = (product) => {
        console.log(product); // which is (id:1)
    }
    
    doHandleIncrement = () => {
        this.handleIncrement({id:1})
    }

    render() {
        return (
          <button onClick={this.doHandleIncrement}>Increment</button>
        );
    }
}
```

> a better solutiion is to use an inline function **( Inline Arrow Function )**

```javascript
<button onClick={() => this.handleIncrement({id:1})}>Increment</button>
```

## You can Return a sentence if there is no element in the Movie array , like bellow

```javascript
export default class Parent extends Component {
    state = {
        
    }

    render() {
        
        // if bellow condition is true , the paragraph would be returned .
        
        if(this.state.movies.length === 0)
            return <p>there are no movies in the database</p>
        
        // OtherWise bellow would return and work .
        
        return (
            <p> Showing {this.state.movies.length} movies in the database </p>
           //......................
        )
    }
}
```

## Composint Components

> for example you can build a Simple `Counter`Component , and then build a `Counters`Component , and import the `Counter`Component in the top , then after that in the return , insert multiple of `Counter`component , very very easy

```javascript
import React,{Component} from 'react';
import {Counter} from './counter';

export default class Counters extends Component {
    state = {
        
    }
    render() {
        return (
          <Counter />
          <Counter />
          <Counter />
          <Counter />
        )
    }
}
```

> Better to use Even bellow

```javascript
import React,{Component} from 'react';
import Counter from './counter';
export default class Counters extends Component {
    state = {
        counters: [
            {id:1,value:4},
            {id:2,value:0},
            {id:3,value:0},
            {id:4,value:0}
        ]
    };
    render() {
        return (
            <div>
                {this.state.counters.map(counter => 
                 <Counter key={counter.id} selected={true} value={counter.value} />)}
            </div>
        );
    }
}
```

> after that move to your `Counter`component , and put the `state = {couter:this.props.value}`

## NOTE

> a child Component in its parent can have a childrend between its openning and closing tag , just like bellow

```javascript
<Counter value={counter.value} selected={true}>
    <h1>this is my child</h1>    
</Counter>
```

> now we can get it in the childrend ( Which is Counter ) just like bellow :

```javascript
{this.props.children}
```

## Rasing Events

> for example if we want to modify or delete a Counter , that is part of the State of Counters , we define the handleDelete in the Counters , and then we send it as a props to the Counter Component . and on its button we simply call `this.props.onDelete` .

**:pushpin: so in the counters component we have**

```javascript
handleDelete = () => {
    
}

<Counter onDelete={this.handleDelete} />
```

**:pushpin: and in the Counter Component we have**

```javascript
<button onClick={this.props.onDelete}>Delete</button>
```

> so to call an event from a `child` , we first define the function in the `parent` , then we send it as a `props` to the child , then in the `child button` , on the `onClick`event , we simply `call that props` , as easy as that

### NOTE :

> When a Component is `rendered`, all its Children would also get `rendred` recursively

### NOTE :

> we can check or request an ajax call in `componentDidUpdate` , with `prevProps`& `prevState` , like bellow

```javascript
componentDidUpdate(prevProps,prevState) {
    console.log('prevProps',prevProps);
    console.log('prevState',prevState);
    if(prevProps.counter.value !== this.props.counter.value ) {
        // Do an Ajax Call
    }
}
```

> so we can use `prevProps`& `prevState`and evaluate them with current state of the value of the Component .

## An Example Of Combining `Two 2 Map`on Arrays Together

```javascript
render(){
    state = {
        movies:getMovies();
    }
    columns = [
        {path:'title',label:"Title"},
        {path:'genre.name',label:'Genre'},
        {path:'numberInStock',label:'Stock'},
        {path:'dailyRentalRate',label:'Rate'},
        {key:'like',content:movie=>(<Like liked={movie.liked} onClick={() => this.props.onLike(movie)} />)},
        {key:'delete',content:movie => (<button onClick={() => this.props.onDelete(movie)>Delete</button>})},
    ]
    
    renderCell = (item,column) => {
        if(column.content) return column.content(item); // if it is Like or Delete Button with (content)
        else return _.get(item,column.path); // find column.path property of item ( using lodash library )
    }
    
    return (
       movies.map(movie => <tr>{
          columns.map(column => <td>{this.renderCell(item,column)}</td>)} /// using lodash library _.get()
       </tr>});
    );
}
```

## Returning Multiple Values From a Function , and Get them

```javascript
getPagedData = () => {
    const filtered = (selectedGenre && selectedGenre._id)
    ? allMovies.filter(m => m.genre._id === selectedGenre._id) : allMovies
    
    const sorted = _.orderBy(filtered,[sortColumn.path],[sortColumn.order]);
    
    const movies = paginate(sorted,currentPage,pageSize);
    
    return { totalCount:filtered.length , data:movies }; // returning an object with two data .
}

// now getting these two returned value just Like Bellow :) :

const {totalCount,data} =this.getPagedData();
```

## `Controlled Elements`

> one important subject to discuss is Controller Elements . just like Controlled Components .
>
> they don't have there own state , they get all the data using `props` .
>
> and they notify changes to the data by rasing events .
>
> Controlled Elements can not get values of `null`or `undefined`.