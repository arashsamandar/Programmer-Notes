##  React Routes

> after installing the `routes` project with `create-react-app routes` .
>
> you have to install on more thing , and that is `npm i react-router-dom`

> here is how we implement `Route` , see bellow code :

```javascript
import {Route} from 'react-router-dom' // the one you installed above
```

> every Route has two parts , like bellow : `path` and `element`

```
<Route path="/products" component={Products} />
```

> NOTE : that the `Route` Elements must be inside a <Routes></Routes> Element .
>
> Otherwise , they won't work .

> see bellow code that is Correct way of writing them : 

```javascript
import {Routes} from "react-router"; // pay attention to import this and also Route .
import {Route} from 'react-router-dom';

class App extends Component {
    render() {
        return (
            <React.Fragment>
                <Routes>
                    <Route path="/home"  element={<Home />}/>
                    <Route path="/products" element={<Products />}/>
                    <Route path="/dashboard" element={<Dashboard />}/>
                    <Route path="/posts" element={<Posts />}/>
                <Routes>
            <React.Fragment>
        )
    }
}
export default App;
```

> pay attention that you can use `a` with `href` , but never seround a Route with `a` , this would not work , but easier , you can write you `<a href="/home">go home<a> in a free space

```javascript
import Dashboard from './components/Dashboard';
import Products from './components/Products';
import Posts from './components/Posts';
import Home from './components/home';
import {Route} from 'react-router-dom';
import React,{Component} from "react";
import {Routes} from "react-router";
class App extends Component {
    render() {
        return (
            <React.Fragment>
                <a href="/home">Home</a><br></br>
                <a href="/posts">Posts</a><br></br>
                <a href="/products">Products</a><br></br>
                <a href="/dashboard">Dashboard</a><br></br>
                <Routes>
                    <Route path="/home"  element={<Home />}/>
                    <Route path="/products" element={<Products />}/>
                    <Route path="/dashboard" element={<Dashboard />}/>
                    <Route path="/posts" element={<Posts />}/>
                </Routes>
            </React.Fragment>
        )
    }
}
export default App;
```

### How to Write a `SPA` : or Single Page Application like google ? bellow we explain

> every time we click on a `Route` Component , the page __refreshes__ , and this is not a good thing because it asks for several files .
>
> to solve that , we use `Link` and `to` , like bellow :
>
> ```
> <Link to="/posts">Post</Link> // use it , so we don't have to use `a` tag .
> ```
>
> 

```javascript
import Dashboard from './components/Dashboard';
import Products from './components/Products';
import Posts from './components/Posts';
import Home from './components/home';
import {Route, Navigate,Link, BrowserRouter} from 'react-router-dom';
import React,{Component} from "react";
import ProductDetails from "./components/productDetails";
import {Routes} from "react-router";

class App extends Component {
    render() {
        return (
            <BrowserRouter>
            <div>
                <Link to="/">Home</Link><br></br>
                <Link to="/posts">Posts</Link><br></br>
                <Link to="/products">Products</Link><br></br>
                <Link to="/dashboard">Dashboard</Link><br></br>

                    <Routes>
                    <Route path="/products/:id" element={<ProductDetails />}/>
                    <Route path="/" exact element={<Home />}/>
                    <Route path="/products"  element={<Products />}/>
                    <Route path="/dashboard" element={<Dashboard />}/>
                    <Route path="/posts" element={<Posts />}/>
        IMPORTANT : <Route path="/redirect" element={ <Navigate to="/not-found" /> } />
                    <Routes>
            <div>
			<BrowserRouter>
        )
    }
}
export default App;
```

> so , if you want the pages to not reload and refresh , simply use `Link` as oppose to `a` .

## Route Props

> every Route Props has three props > `history` , `location` `match`, `Pathname`
>
> in the `match` , we have : `params` `path` `url`

## sending child element to the `Router` , __Importante__

> so , to pass some child to the `Link` you just simply need , to define a `query` `Object` , like bellow :
>
> ```javascript
> <Link path="/post" query:{{name:'arash',family:'samandar'}}>Home</Link>
> ```
>
> NOTE :star: __:__ notice that you can't pass `props` to the `Router` , but if you really need to send some props or child
>
> use : `useNavigate()` instead of `Router` , and also you can use `Link` , which is very good .

```javascript
const navigate = useNavigate();
navigate('/toPath', {state: customData})
```

> *or simply use the Link*
>
> `<Link query={{name:'samandar',family:'aghashahi'}) to="/home">Home</Link>`

#### NOTE :star:

> Note that to `Route` a `path` , if you want it to have `id` you write `/products/:id` , so remember that , like what we just said , you have to use `:` a colon , another one is bellow :

```
<Route path="/posts/:year/:month" element={Posts} />
```

> you can also make this `Parameters` , `Optional` , By Using a `?` , like bellow :

```
<Route path="/posts/:year?/:mo"
```

### How To Address Dynamically 

> if we have :
>
> ```
> <Route path="/products/:id" element={() => <ProductDetails pagetitle="info page" />}/>
> ```
>
> in our roots , then for the clickable we would have :
>
> ```
> <Link to={`/products/${product.id}`} element={<ProductDetails}>{product.name}</Link>
> ```

> like bellow in our `Products` Component :arrow_double_down:

```javascript
{this.state.products.map(product => (<li key={product.id}><Link to={`/products/${product.id}`} element={<ProductDetails/>}>{product.name}</Link><ProductDetails /></li>))}
```

> so for that , ones we set the path in the <Route path="/products/:id" ,
>
> and for the link we say <Link to={`/products/${product.id}`} element={<ProductDetails />i</Link>

#### briefly , everywhere that you have a variable value in your address , you must use ` backtick and dollar sign like 

```javascript
{this.state.products.map(product => (<li key={product.id}><Link to={`/products/${product.id}`} element={<ProductDetails/>}>{product.name}</Link><ProductDetails /></li>))}
```

> and in the address of `Route` for that dynamic `id` , dynamic path , you would use `:` , like bellow :
>
> <Link to="/products/:id" , and if it is mandatory you will also use `?` , like `<Link to="/products/:id?"`

#### How to Show the id of above <Link to={`/products/${product.id}`}

> you can use the `Hooks` , like bellow code :

```javascript
import React,{Component} from "react";
import {useParams} from 'react-router-dom'; //remember how to Import it from 'react-router-dom'

const ProductDetails = () => {
    const params = useParams(); // useParams() is a Hook
    return <h3>Product Number - > {params.id}</h3>;
}
export default ProductDetails;
```

### Installing Query-String to be able to read queryStrings

> install it with
>
> ```
> npm i query-string
> ```

> now getting `QueryString` with bellow code :
>
> ```javascript
> import React from "react";
> import queryString from 'query-string';
> import useSearchParams from 'react-router-dom'; // another hook named : useSearchParams
> 
> const Posts = ({match,location}) => {
>     const [searchParams, setSearchParams] = useSearchParams();
>     console.log(searchParams.get("__firebase_request_key"));
>     return (
>         <div>
>             <h1>Posts</h1>
>         </div>
>     )
> }
> export default Posts;
> ```
>
> 

### this is a way to get `parameters` that we send to a `URL`

```javascript
const ProductDetails = () => {
    const params = useParams(); // with useParams() , and then {params.id}
    return <h3>Product Number - > {params.id}</h3>;
}
export default ProductDetails;
```

> using this __useParams()__ we get bellow parameters :
>
> ```javascript
> <Route path="/products/:id" element={<ProductDetails />}/> //meaning /product/:id we get id
> ```

### getting the `SearchQuery` , by using `location.search` , like bellow :

```javascript
import React,{Component} from "react";
import queryString from 'query-string';
import { useLocation } from 'react-router-dom';

const Posts = () => {
        const location = useLocation(); // here is important
        console.log(location.search); // and here . but there is something wrong , because it
    	console.log(queryString.parse(location.search))	// shows like '?name=arash'
        return (
            <div>
                <h2>Hello Posts</h2>
            </div>
        )

}
export default Posts;
```

> > NOTE :star: : see and use bellow code , `location` , `search` , `location.search` , and `queryString.parse(location.search)`

```javascript
import React,{Component} from "react";
import queryString from 'query-string'; // Important
import { useLocation } from 'react-router-dom';

const Posts = () => {
        const location = useLocation(); // Important
        console.log(location.search); // Important
        console.log(queryString.parse(location.search)); // Important
        return (
            <div>
                <h2>Hello Posts</h2>
            </div>
        )

}
export default Posts;
```

```javascript
// so we have
import {useLocation} = 'react-router-dom';
import {useParams} = 'react-router-dom';
const location = useLocation();
console.log(location.search);
console.log(queryString.parse(location.search));
// and bellow :
import React,{Component} from "react";
import {useParams} from 'react-router-dom'; //remember how to Import it from 'react-router-dom'

const ProductDetails = () => {
    const params = useParams(); // useParams() is a Hook
    return <h3>Product Number - > {params.id}</h3>;
}
export default ProductDetails;
```

### Using `Navigate` as `Redirect` To `NotFound`

> we use `Navigate` in the newer version of `React.js` , as you can see bellow .
>
> NOTE : `Navigate` really , Redirects the Address , look bellow code ,
>
> ```
> <Route path="/redirect" element={<Navigate to="/note-found" />}
> ```
>
> *In this code if you type `localhost:3000/redirect` , you would go to to="/not-found"*

```javascript
import {Route,Switch, Navigate, Link, Routes} from 'react-router-dom'; // here it is
import React,{Component} from "react";
import NotFound from "./components/notFound";

class App extends Component {
    render() {
        return (
            <div>
                <Link to="/posts">Posts</Link><br></br>
                    <Routes>
                    <Route path="/posts" element={<Posts />}/>
                    <Route path="/note-found" element={<NotFound />} />
                    <Route path="/redirect" element={<Navigate to="/note-found" />} // its here
                    </Routes>
            </div>
        )
    }
}
export default App;
```

> so we easily puth the `Navigate` , in our `Route` Element . and our `Navigate` Component , has its own destination ==> `to="/not-found"` , which overrides the `Route` `path` , path="/redirect" , 
>
> NOTE : __In Other Words , It really redirects the path="/redirect" and goes to -> to="/not-found"__

## React Version

```javascript
handleClick = () => {
        console.log(React.version);
};
// our React Version is 18.2.0

//-------------------------All OF Them---------------
"react": "^18.2.0",
    "react-dom": "^18.2.0",
    "react-router-dom": "^6.3.0",
```

#### `useHistory()` doesn't work , use `useNavigate()` instead

> as said : *__useHistory()__* doesn't work , use *__useNavigate()__ instead*.
>
> like bellow code :

```javascript
// in the utils.jsx we have
import {useNavigate} from 'react-router-dom';

export default function GetNav() {
    const navigate = useNavigate();

    const handleClick = () => {
        // 👇️ navigate programmatically
        navigate('/about');
    };

    return (
        <div>
            <button onClick={handleClick}>Navigate to About</button>
        </div>
    );
}
```

> and we used it in bellow code :arrow_double_down:

```javascript
import GetNav from "../utils";


class Products extends Component {
    handleClick = () => {
        <GetNav />
    };
    render() {
        return (
            <GetNav />
        )
    }
}
export default Products;
```

## _____________________________________________________________________________________________________________________________________________________________

### navigate `useNavigate`

```javascript
import {useNavigate} from 'react-router-dom';

export default function GetNav(props) {
    const navigate = useNavigate();

    const handleClick = () => {
        // 👇️ navigate programmatically
        navigate(props.address);
    };

    return (
        <div>
            <button onClick={this.handleClick}>{props.address}</button>
        </div>
    );
}
```

### params `useParams`

```javascript
import {useParams} from 'react-router-dom';
import bootstrap from 'bootstrap';
import GetNav from "../utils";

const ProductDetails = () => {
    const params = useParams(); // useFull when you have /user/:id like /user/2
    return (
        <React.Fragment>
        <h3>Product Number - > {params.id} <GetNav /></h3> // params.id used here
        </React.Fragment>
        )
}
export default ProductDetails;
```

### location `useLocation`

```javascript
import React,{Component} from "react";
import queryString from 'query-string';
import {useLocation, useParams} from 'react-router-dom';

const Posts = () => {
        const location = useLocation();
        console.log(location.search); // www.google.com?name=arash >> so it console.log arash
        console.log(queryString.parse(location.search));
        return (
            <div>
                <h2>Hello Posts</h2>
            </div>
        )

}
export default Posts;
```

### IMPORTANT :star: how to use `useNavigate()` instead of `useHistory()`

> *It is very easy to achieve this , just take a look at bellow code :*

```javascript
import { useNavigate } from 'react-router-dom'

function Test() {
  const navigate = useNavigate();
  navigate('/');                    // Equivalent to "history.push('/');"
  navigate('/', { replace: true }); // Equivalent to "history.replace('/');"
  navigate(-1);                     // Equivalent to "history.goBack();"
}

Test();
```

## HighLight the currently selected Route

> you could use `<NavLink className="nav-item nav-link" to="/customers"`

> Note :star: that `NavLink` is another class of the `react-route-element`

> we have also : bellow :arrow_double_down:

```javascript
import {NavLink , BrowserRouter} from 'react-router-dom';
```

> the version is : `4.3.1` , lnstall it like bellow :

```
npm i react-router-dom@4.3.1
```

```javascript
// in the index.js , we have :
import React from "react";
import ReactDom form 'react-dom';
import { BrowserRouter } from 'react-router-dom';

ReactDom.render(
	<BrowserRouter>
    	<App />
    <BrowserRouter>,
    document.getElementById("root")
);
```

> create `Redirect` path , with bellow code : using `<Navigate to="/not-found"/>`
>
> NOTE : Meaning , With Bellow Code : if you go to the `/redirect` path , you would go to `/not-found` route !!
>
> so > using `Route` Component , and `Navigate` Component , `Route` has `path` , and `Navigate` has `to`

```javascript
<Route path="/redirect" element={ <Navigate to="/not-found" /> } />
```

