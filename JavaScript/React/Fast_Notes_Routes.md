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
                </Routes>
            </React.Fragment>
        )
    }
}
export default App;
```

> pay attention that you can use `a` with `href` , but never sround a Route with `a` , this would not work , but easier , you can write you `<a href="/home">go home<a> in a free space

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
import {Route,Switch} from 'react-router-dom';
import React,{Component} from "react";
import {Routes} from "react-router";
import {Link} from "react-router-dom";

class App extends Component {
    render() {
        return (
            <React.Fragment>
                <Link to="/">Home</Link><br></br>
                <Link to="/posts">Posts</Link><br></br>
                <Link to="/products">Products</Link><br></br>
                <Link to="/dashboard">Dashboard</Link><br></br>

                    <Routes>
                    <Route path="/"  element={<Home />}/>
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
