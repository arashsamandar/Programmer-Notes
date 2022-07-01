### Creating First Component

```javascript
class Counter extends Component {
    state = {}
	render() {
        return (
            <div>
            <h1>Hello World Arash</h1>
            <button className="btn btn-danger">Example</button>
            </div>
            )
    }
}
export default Counter;
```

> now for our `Component` to work , we need to go to `index.js` and write the following

```javascript
import {Counter} from '../src/counter';
// wich the "root" is an id of a div element
// in the "public" folder > in the index.html
cost root = ReactDom.createRoot(document.getElementById('root'));
root.render(
	<React.StrictMode>
    	<Counter />
    </React.StrictMode>
)
```

### How to change the Style of an element with `style` object

> we can use bellow code :arrow_double_down:

```javascript
import React,{Component} from "react";

class Counter extends Component {
    state = {
        count:0,
    };
    styles = { // here we go , Note : remember the styles are camelcase
      fontSize:10,
      fontWeight:bold,
    };
    render() {
        return (
        <React.Fragment>
            <span style={this.styles} className="btn btn-secondary btn-sm m-2">{this.formatCount()}</span>
            <button className="btn btn-primary">Increment</button>
        </React.Fragment>
        )
    }

    formatCount() {
        const {count} = this.state;
        return count === 0 ? 'Zero' : count;
    }
}

export default Counter;
```

> or without the styles , __we can write styles `inline`__ , like bellow and with __`{{}}`__ double braces

```javascript
import React,{Component} from "react";

class Counter extends Component {
    state = {
        count:0,
    };
    render() {
        return (
        <React.Fragment> // bellow
            <span className="btn btn-secondary btn-sm m-2">{this.formatCount()}</span>
            <button style={{backgroundColor:''}} className="btn btn-primary">Increment</button>
        </React.Fragment>
        )
    }

    formatCount() {
        const {count} = this.state;
        return count === 0 ? 'Zero' : count;
    }
}

export default Counter;
```

### Javascript Rule with `&&`

> in react , the value of `true && 'hi'` would be `hi` , like bellow :arrow_double_down:

```javascript
import React,{Component} from "react";

class Counter extends Component {
    state = {
        count:0,
        tags:[],
    };
    renderTags() {
        if(this.state.tags.length === 0) return <p>There are no Tags</p>
        return <ul>{this.state.tags.map(tag => <li key={tag}>{tag}</li>)}</ul>
    }
    render() {
        return (
        <React.Fragment>
            <ul>
                {this.state.tags.length === 0 && 'please create a new tag'} // returns the text
                {this.renderTags()}
            </ul>
        </React.Fragment>
        )
    }
}

export default Counter;
```

> or the result of bellow code :arrow_double_down:

```javasc
true && 'Hi' && 1  // would return the 1
```

## handling Events

```javascript
import React,{Component} from "react";

class Counter extends Component {
    state = {
        count:0,
        tags:['tag1','tag2','tag3'],
    };
    constructor() {
        super();
        this.handleIncrement = this.handleIncrement.bind(this);
    }
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
    handleIncrement() {
        console.log('increment clicked',this); // we have used the bind(this) method in the constructor as you can see .
    }
    render() {
        return (
        <React.Fragment>
            <span className={this.getBtnClasses()}>{this.formatCount()}</span>
// as you can see we call this.handleIncrement , without the prantecis .
            <button onClick={this.handleIncrement} className="btn btn-primary">Increment</button>
            {this.renderTags()}
        </React.Fragment>
        )
    }
}

export default Counter;
```

### :musical_note: NOTE :

> there is another solution to refer to `this` , and that is to use `Arrow Functions` , arrow functions doesn't rebind this . so we can refer to just `this` , very easily .

### Updating the `state` using `setState()` 

```javascript
handleIncrement = () => {
    this.state.count++ // this line won't work , and we have to use this.setState()
    this.setState({count:this.state.count + 1});
}
```

### Passing Event Arguments

```javascript
handleIncrement = (product) => {
    console.log(product);
    this.setState({count:this.state.count + 1});
}
// and in the render method when we call this function
// you should remember that we call an instance of the function , like : this.handleIncrement
<button onClick={this.handleIncrement}>Example</button>
// so we write it like bellow ( when we want to pass an Argument )
<button onClick={() => this.handleIncrement(product)}
```

### Deleting an Element (movie)

> use `filter()` to remove a movie like bellow :

```javascript
handleDelete = (movie) => {
    const movies = this.state.movies.filter(m => m._id != movie._id);
    this.setState({movies:movies}) // or this.setState({movies})
}
```

```javascript
import React,{Component} from "react";
import {deleteMovie, getMovies} from "../services/fakeMovieService";


export class Movies extends Component {
    state = {
        movies:getMovies(),
    };
    handleDelete = (movie) => {
        const movies = this.state.movies.filter(m => m._id != movie._id);
        this.setState({movies})
    }
    render() {
        return (
            <React.Fragment>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Genre</th>
                            <th>Stock</th>
                            <th>Rate</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    {this.state.movies.map(movie => (
                        <tr key={movie._id}>
                            <td>{movie.title}</td>
                            <td>{movie.genre.name}</td>
                            <td>{movie.numberInStock}</td>
                            <td>{movie.dailyRentalRate}</td>
                            <td>
                            <button
                                onClick={() => this.handleDelete(movie)}
                                className="btn btn-danger btn-sm">
                                Delete
                            </button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </React.Fragment>
        )
    }
}
```

