## implementing Rout

> **NOTE : react is a simple library and its job is to render UI , because of that for Routing we need to install**

:pushpin:*npm install react-router-dom*

> after that in the `index.js`first you import `BrowserRouter`then wrap your Component inside it , just like bellow example 

```java
import {BrowserRouter} from 'react-router-dom';

render(
    <BrowserRouter>
        <App />
    </BrowserRouter>,document.getElementById('MyReact'));
```

> now we need to tell React , What component should be rendered Base on a Given URL .
>
> for example in one our Components we have 

```java
import React, { Component } from "react";
import {Router} from 'react-router-dom';
import NavBar from "./components/navbar";
import Products from "./components/products";

class App extends Component {
    render() {
        return (
           <div>
            <NavBar />
            <div className="content">
               <Route path="/products" component={Products} /> // so it has path & component props .
            </div>
           </div>
        );
    }
}
```

## install it in laravel

> it is just a bit different , run `npm install react-router-dom --save` ,
>
> and basically we write our code in the `index.js`where we used to write the ReactDom.render(); for our main component .
>
> now we write the whole Routing in `index.js`

:pushpin:**NOTE That the Router Component Can Only Have One 1 Direct Child**

```java
import React, { Component } from "react";
import ReactDOM from 'react-dom';
import NavBar from "./components/navbar";
import {BrowserRouter as Router,Link,Route} from 'react-router-dom'
import Products from "./components/products";

export default class Index extends Component {
    render() {
        return (
            <Router>
                <div>
                    <Link to="/">Home</Link>
                    <Link to="/products">products</Link>
                    <Route path="/" exact component={NavBar} />
                    <Route path="/products" exact component={Products} />
                </div>
            </Router>
        );
    }
}

if(document.getElementById('MyReact')) {
    ReactDOM.render(<Index/>,document.getElementById('MyReact'));
}
```

> so basically these are all in `index.js` & one more thing you need to know is that

> **For every Component and Path we want to show , we need a `Link` & `Route`**

> if you don't want the home to be shown when you click `products`, ( Because the link is home/products) , you should use the `exact`keyword . you can also wrap them with <switch> , but first import it from `react-router-dom`

## NOTE

#### **:pushpin:NOTE : In Laravel If You want to Use `Route`, You Must Wrap it first With `Router`**

#### **:pushpin:NOTE : Otherwise It Would NOT Work**

## NOTE

> the link attribute has a method that only changes the url , and then the `Route`sees it , and functions by returning the adiquet Component , which we put on it .

> so essentially a `Route`is a wraper around the component . and it has its props (`history`,`match`,`location`)
>
> `history`is the history Object in the browser . and with that we can send the user to a different page .
>
> `location`which reperesent where the application is now .
>
> `match`contains information about how this url matched the path that we set in the Route .

:pushpin:**AN example of each one of them we would see later**

> we use `history` , for example to get back to the previous page , just like bellow code : when we push the button we get back to the page we where , now look at the example :

```javascript
class ProductDetails extends Component {
  handleSave = () => {
    this.props.history.push('/producsts');
  };

  render() {
    return (
      <div>
        <h1>Product Details - {this.props.match.params.id} </h1>
        <button onClick={this.handleSave}>Save</button>
      </div>
    );
  }
}
```

> we use `match`to get the ( for example props ) , the id of the Product , wich comes like `product/id` , in bellow example it is :

```javascript
class ProductDetails extends Component {
  handleSave = () => {
    this.props.history.push('/producsts'); // we also have .replace
  };

  render() {
    return (
      <div>
        <h1>Product Details - {this.props.match.params.id} </h1>
        <button onClick={this.handleSave}>Save</button>
      </div>
    );
  }
}
```

> we use `location` for `queryString`& get the queryString from it , the values of queryString , like bellow :

```javascript
const result = queryString.parse(location.search);
console.log(result); // example a url like http://localhost:8000/posts?sortBy=newest&approved=true
// result gives us an object in which there is (approved=true) & (sortBy=newest) , very nice :)
```

## pasing arguments to the Component in Route

> if you want to pass arguments to your component in the `Route`you gotta use `render`instead of `component`in the `Route`, just like bellow :

```java
<Route path="/products" render={(props) => <Products sortBy="newest" {...props} />}
```

## Use Routing With Laravel

> add bellow code to your `web.php`file

```javascript
Route::get('/{path?}', [
    'uses' => 'ReactController@useReact',
    'as' => 'react',
    'where' => ['path' => '.*']
]);
```

## passing ID s to a Component Route `product/id`

> you will have to use a `Route`with the `:id` above the Component you want to get Id , just like bellow :

:pushpin:**IMPORTANT**

```javascript
<li>
    <Route path="/products/:id" component={ProductDetails}/> // this is how to link it , with :id
    <Route path="/products" component={(props) => <Products sort="newest" {...props} />} />
<li>
```

#### and How to show this passed id ??

> **with** : {this.props.match.params.id}

### Removing page reload for every link you click in the for example `product/id`

> in the `Product`Component do not use <a> instead use <Link>

```javascript
import {Link} from 'react-router-dom';
export default class Product extends Component {
    render() {
    return (
      <div>
        <h1>Products</h1>
        <ul>
          {this.state.products.map(product => (
            <li key={product.id}>
              <Link to={`/products/${product.id}`}>{product.name}</Link>
            </li>
          ))}
        </ul>
      </div>
    );
}
```

> if you want to make a parameter , like id , or anything else optional , you should appen an Question mark to it , just like bellow :

```javascript
<Route path={"/posts/:year?/:month?"} component={Posts} />
```

## render the Query String passed to With a Query String Library

> use `npm install query-string `

```javascript
import React,{Component} from "react";
import queryString from 'query-string';

export default class Posts extends Component {
    render() {
        const {match,location} = this.props;
        const result = queryString.parse(location.search); // now easily see the queyr parts in console
        console.log(result);
        return(
            <div>
                <h1>Posts</h1>
                Year:{this.props.match.params.years} , Month:{this.props.match.params.month}
            </div>
        );
    }
}
```



## Redirect

> redirect is used like this

```javascript
<li>
     <Link to="/posts">Posts</Link>
     <Redirect from="/message" to="/posts" />
     <Route path={"/posts/:year?/:month?"} component={Posts} />
     <Route exact path="/posts" component={Posts} />
</li>
```

## how to get back to products from a product id page , by using the browser history

```javascript
class ProductDetails extends Component {
  handleSave = () => {
    this.props.history.push('/producsts');
  };

  render() {
    return (
      <div>
        <h1>Product Details - {this.props.match.params.id} </h1>
        <button onClick={this.handleSave}>Save</button>
      </div>
    );
  }
}
```

##### :pushpin:Another Example

```javascript
import React from 'react';
const MovieFrom = ({match,history}) => {
    return (
        <div>
            <h1>MovieForm {match.params.id}</h1>
            <button
                className="btn btn-primary"
                onClick={() => history.push('/movies')}>
                
                Save

            </button>
        </div>
);
};

export default MovieFrom;
```



### These are all browser parameters we talked about and we can see in React window of Devtools

 

## Another NOTE , Pay Attention To This Examples veryyyy Carefully

```java
import React,{Component} from 'react';
import {BrowserRouter as Router,Link} from "react-router-dom";
import Like from '../Backup/common/like';
import Table from '../Backup/common/table'

export default class MoviesTable extends Component {

    columns = [
       {path:'title',label:'Title',content:movie => <Link to={`/movies/${movie._id}`}>{movie.title}</Link> },
       {path:'genre.name',label:'Genre'},
       {path:'numberInStock',label:'Stock'},
       {path:'dailyRentalRate',label:'Rate'},
       {key:'like',content:movie => (<Like liked={movie.liked} onClick={() => this.props.onLike(movie)}/>)},
       {key:'delete',content:movie => (<button onClick={() => this.props.onDelete(movie)} className="btn btn-danger btn-sm">Delete</button>)},
    ];

    render() {
        const {onDelete,onLike,movieChunk,onSort,sortColumn} = this.props;
        return (
            <Table
                columns={this.columns}
                data={movieChunk}
                sortColumn={sortColumn}
                 onSort={onSort} />
        );
    }
}

```

#### :pushpin:Now it is passed to Bello Component

```java
import React,{Component} from 'react';
import TableHeader from "./tableHeader";
import TableBody from "./tableBody";
export default class Table extends Component {
    render() {
        const {columns,sortColumn,onSort,data} = this.props;
        return (
            <table className="table">
                <TableHeader columns={columns} sortColumn={sortColumn}
                             onSort={onSort} />

                <TableBody columns={columns} data={data} />
            </table>
        );
    }
}
```

### :pushpin:Now It IS Passed Bello

> and here `columns`and `data`(which is the movies list) , gets Rendred

```java
import React,{Component} from 'react';
import _ from 'lodash';
export default class TableBody extends Component {

    renderCell = (item,column) => {
      if(column.content) return column.content(item)

      return _.get(item,column.path);
    };

    createKey = (item,column) => {
        return item._id + (column.path || column.key);
    };

    render() {
        const {data,columns} = this.props;
        return(
            <tbody> // and bellow is where everything is getting rendered to the screen----->>>>
            {data.map(item =>
                <tr key={item._id}>
                    {columns.map(column =>
                        <td key={this.createKey(item,column)}>
                            {this.renderCell(item,column)}
                        </td>)}
                </tr>
            )}

            </tbody>
        );

    }
}
```

