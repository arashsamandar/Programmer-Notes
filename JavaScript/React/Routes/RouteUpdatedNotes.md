## Updated Notes

> first we wrap the main.jsx component in <BrowserRouter>

> after that use `<Routes>` Component in the content of the `mainRouteFile` that you just wraped with `<BrowserRouter>` , like bellow :

```react
<BrowserRouter>
    <MyNavComponent />
</BrowserRouter>
```

```react
myNavComponent.jsx
// we use Routes Instead of Switch in new versions
export default function MyNavComponent() {
    return (
        <Routes>
            <Route path="/arash" Component={Arash} />
            <Route path="/" exact Component={Home} />
        </Routes>
    )
}
```

> using `useNavigate()`

```react
const myNavigator = useNavigate();
const handleNavigation = () => {
    myNavigator("/navbar"); // it must have a <Route in myNavComponent.jsx
}
return (
    <input type="button" value="Go To Navbar" onClick={handleNavigation} />
)
```

-----------

> another one is `Link` , that we use ( and it is kind of a <a> tag ) , pay attention that if you have used it you must have a <Route> for it .

### Note

> in the routes.jsx file that we have defined to set different <Route> , we can define the parameters it could get with `:` , like below , and `?` for optional parameters :
>
> ```react
> <Routes>
>     <Route path="/product-details/:id/:name"
> </Routes>
> // and '?' if they are optional
> <Routes>
>     <Route path="/product-details/:id/:name?"
> </Routes>
> ```
>
> 

## useParams() for reading parameters

```react
const params = useParams();
const location = useLocation();
const navigate = useNavigate();
function Arash() {
    const handleSubmit = () => {
        navigate("/form-submited",{replace:true});
        // use of replace:true is that the user can't push the back button of browser
    }
    return(
        <div>{params.id}</div>
        <div>{location.pathname}</div>
        <button type="submit" value="submit" onClick={handleSubmit}
    )
}
```

-----------

## Using `Redirect`

```react
<Route path="/posts"
<Redirect from="/messages" to="/posts" />
    // or
<Route path="/" Component={Home} exact />
<Route path="/not-found" Component={NotFount} />
<Redirect to="/not-found" />
// above code would redirect to "/not-found" when the url is wrong :)
```

## Nested Routes

> the main file of the project isn't the only place to add <Route> , you could use <Route> in other component and achieve `nested routes` !
>
> like if the path maches , you would get that component but this time the parent component that you have used <Route> in , would also show ! :)

### Note Example of Nested Routes

```react
// in main-routes we have
function ArashRoutes() {
    return (
        <Routes>
            <Route path="/my-routes" element={<MyRoutes array={[1,2,3,4]} />} />
            <Route path="/my-routes/:id" element={<RouteDetails />} />
            <Route path="/test-navigate" element={<TestNavigate />} />
            <Route path="/nested" element={<NestedRoutes />}>
                <Route path="posts" element={<Posts />} />
            </Route>
            <Route path="/" element={<Home />} />
        </Routes>
    )
}
```

```react
// in the /Nested component that we want nested to be shown while the parent is also
// visible, we write :
export default function NestedRoutes() {
    return (
        <React.Fragment>
            <Navbar /><br/>
            <h3 className="ms-3">Admin Panel</h3><br/>
            <h4 className="ms-3">Welcome To The Parent Route</h4><br/>
            <Routes>
                <Route path="posts" element={<Posts />} />
            </Routes>
        </React.Fragment>
    )
}
```

----------

## Use Cases like useEffect()

> we have `useEffect` for handling the `mounted event` of the component , like below :
>
> ```react
> function ArashComponent() {
>     useEffect(()=>{
>         console.log('component is mounting now');
>     })
>     return(
>         <div>
>         	Home
>         </div>
>     )
> }
> // or useRef() like below to address an element directly
> const myUsername = useRef(null);
> // then in the `return` in our input we can have :
> <input type="text" ref={myUsername} />
> ```