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
>     return value;
> }
> // now you call it with () , like bellow :
> <button onClick={this.getBtnClasses()}>Show Value</button>
> ```