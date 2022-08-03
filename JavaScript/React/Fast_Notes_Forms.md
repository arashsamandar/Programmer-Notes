## React Forms

> You should never use `document` in react , like bellow is wrong :
>
> ```javascript
> document.getElementById('folan').value // this way of getting the value of input forms is wrogn .
> ```
>

> for getting the inputs of ( for example a textbox ) , __we shall convert that input field or input text__ to a `controlled input` , controlled input fileds are like controlled Components , they don't have there value , they get there value from the `props` , and they `raise` events .

> like bellow code :arrow_double_down:

```javascript
// if you don't get it , read the next chunk of code .
state = {
    account:{
        username:'',
        password:'',
    }
}
handleChange = ({currentTarget:input}) => {
        const account = {...this.state.account};
        account[input.name] = input.value;
        this.setState({account});
    }
    render() {
        const {account} = this.state;
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-control">
                    <label htmlFor="username">Username</label>
                    <input autoFocus name="username" onChange={this.handleChange} value={account.username} id="username" type="text" className="form-control" />
                </div>
                <div className="form-control">
                    <label htmlFor="password">Password</label>
                    <input onChange={this.handleChange} name="password" value={account.password} id="password" type="text" className="form-control" />
                </div>
                <button className="btn btn-primary m-3">Login</button>
            </form>
        )
```

```javascript
/*
so first we controll them with
name="username" and the value={this.state.account.username} onchange={this.handleChange}
and for the password the same thing .
and in the method onChange we have onChange={this.handleChange}
in th handleChange we have
 */

handleChange = e => {
    const account = {...this.state.account};
    account[e.currentTarget.name] = e.currentTarget.value;
    this.setState({account}); 
    // so it would change the this.state.account.username & this.state.account.password
    // as simple as that .
}
```

## Destructring of Input

> now we can put the `input` and change it to a `reusable` Component named `Input` , like bellow code :

```javascript
class LoginForm extends Component{
    state = {
        account : {username:'',password:''},
    }

    handleSubmit = (e) => {
        e.preventDefault();
    }
    handleChange = ({currentTarget:input}) => {
        const account = {...this.state.account};
        account[input.name] = input.value;
        this.setState({account});
    }
    render() {
        const {account} = this.state;
        return (
            <form onSubmit={this.handleSubmit}>
                <Input label="Username" name="username" value={account.username} onChange={this.handleChange} />
                <Input label="Password" name="password" value={account.password} onChange={this.handleChange} />
                <button className="btn btn-primary m-3">Login</button>
            </form>
        )
    }
}
export default LoginForm;
```

> Goes To bellow :arrow_double_down:

```javascript
const Input = ({name,label,value,onChange}) => {
    return (
        <div className="form-control">
            <label htmlFor={name}>{label}</label>
            <input
                name={name}
                id={name}
                value={value}
                onChange={onChange}
                type="text"
                className="form-control" />
        </div>
    )
}
export default Input;
```

## Showing Error

> in the above `Input` Component , we are gonna pass a new `prop` with the name `error`
>
> and we show it like bellow 

```javascript
// right after the above className="form-control" we would have :
import React,{Component} from "react";

const Input = ({name,label,value,onChange}) => {
    return (
        <div className="form-control">
            <label htmlFor={name}>{label}</label>
            <input
                name={name}
                id={name}
                value={value}
                onChange={onChange}
                type="text"
                className="form-control" />
            {error && <div className="alert alert-danger">{error}<div>}
        </div>
    )
}
export default Input;
// and in the Form we have :
<form onSubmit={this.handleSubmit} className="container">
                <Input
                    label="Username"
                    name="username"
                    value={account.username}
                    onChange={this.handleChange}
                    error={this.state.errors.username} // this line for username
                />
                <Input
                    label="Password"
                    name="password"
                    value={account.password}
                    onChange={this.handleChange}
                    error={this.state.errors.password} // this line for password
                />
                <button className="btn btn-primary m-3">Login</button>
            </form>
```

> there is a problem with this implementation , and that is : when both username and password have no error , in the code bellow :
>
> ```javascript
> this.setState({errors}) // it would be null and we get error .
> ```
>
> NOTE : so we write it like bellow , so that it would be `an empty object` or `errors`
>
> ```javascript
> this.setState({errors:errors || {}}) // see this code very carefully . so it would be errors , or an empty object . if first is true it would return errors and if errors is null it would return {} , an empty Object .
> ```

## Deleting a property

> we delete a `property of an object` with `delete` , like bellow code :

```javascript
validateProperty = (input) => {
        if(input.name === 'username') {
            if(input.value.trim() === '') return 'Username is required';
        }
        if(input.name === 'password') {
            if(input.value.trim() === '') return 'Password is required';
        }

    }
    handleChange = ({currentTarget:input}) => {
        const errors = {...this.state.errors};
        const errorMessage = this.validateProperty(input);
        if(errorMessage) errors[input.name] = errorMessage
        else delete errors[input.name]; //here we delete a property of an Object, here (errors)

        const account = {...this.state.account};
        account[input.name] = input.value;
        this.setState({account,errors});
    }
```

## Important : Joi-browser

```javascript
npm i joi-browser // install it as an npm , so you can use it in your project like bellow :

import Joi from 'joi-browser';

// then in the LoginForm Component we would have :
schema : {
    username: Joi.string().required;
    password: Joi.string().required;
}
validate = () => {
        const result = Joi.validate(this.state.account,this.schema,{abortEarly:false});
        console.log(result);
    // bellow has nothing to do with the above code.
        const errors = {};
        if(this.state.account.username.trim() === '') {
            this.state.errors.username = 'Username is required';
        }
        if(this.state.account.password.trim() === '') {
            errors.password = 'Password is required';
        }
        return Object.keys(errors).length === 0 ? null : errors; // this line is not related
    															 // to the Joi .
    	// but it is important , take a look .
    }
// and it is going to be used in bellow code , ( to show error when typing ( empty ))
handleChange = ({currentTarget:input}) => {
        const errors = {...this.state.errors};
        const errorMessage = this.validateProperty(input);
        if(errorMessage) errors[input.name] = errorMessage
        else delete errors[input.name];

        const account = {...this.state.account};
        account[input.name] = input.value;
        this.setState({account,errors}); // and here the errors is going to be set and shown on change
    }
```

## Joi : React Loop with For

> implementation is like bellow , to iterate over an array .

```javascript
for(let item of items) {
    item.folan = item.bahman;
}
```

> now we iterate over the `Object` that `Joi` Creates , like bellow :

```javascript
validte = () => {
    const result = Joi.validate(this.state.account,this.schema,{abortEearly:false});
    if(!result.error) return null;
    const errors = {};
    for(let item of result.error.details)
        errors[item.path[0]] = item.messsage;
    return errors;
}
// and this validate is used in the 'handleSubmit' method , like bellow :
handleSubmit = (e) => {
        e.preventDefault();
        const errors = this.validate();
        this.setState({errors:errors || {}}); // here the state of errors is set
        if(errors) return;
        console.log('submitted');
}
// and is passed to the input text like bellow :
<form onSubmit={this.handleSubmit} className="container">
                <Input
                    label="Username"
                    name="username"
                    value={account.username}
                    onChange={this.handleChange}
                    error={this.state.errors.username}
                />
                <Input
                    label="Password"
                    name="password"
                    value={account.password}
                    onChange={this.handleChange}
                    error={this.state.errors.password}
                />
                <button className="btn btn-primary m-3">Login</button>
            </form>
// and in the Input Component we have
<div className="form-control">
            <label htmlFor={name}>{label}</label>
            <input
                name={name}
                id={name}
                value={value}
                onChange={onChange}
                type="text"
                className="form-control" />
            {error && <div className="alert alert-danger">{error}</div>} // here we show it
        </div>
```

## The Whole error with Joi

```javascript
import React,{Component} from "react";
import bootstrap from 'bootstrap/dist/css/bootstrap.css';
import Input from "./input";
import Joi from 'joi-browser';

class LoginForm extends Component{
    state = {
        errors:{},
        account : {username:'',password:''},
    }
    schema = {
        username: Joi.string().required().label('Username'),
        password: Joi.string().required().label('Password'),
    };
    handleSubmit = (e) => {
        e.preventDefault();
        const errors = this.validate();
        this.setState({errors:errors || {}});
        if(errors) return;
        console.log('submitted');
    }
    validate = () => {
        const option = {abortEarly:false};
        const result = Joi.validate(this.state.account,this.schema,option);
        if(!result.error) return null;
        const errors = {};
        for(let item of result.error.details)
            errors[item.path[0]] = item.message;
        return errors;
    }

    validateProperty = ({name,value}) => {
        const obj = {[name]:value}; // pay attention that value can be a string , as it is in
        // all objects , but name can't , look ; const object = {name:'arash'} key value 
        const schema = {[name]:this.schema[name]}
        const {error} = Joi.validate(obj,schema); // it must be an objecct , if not the next
        // line of code would deliver an error,so above error must be able to have properties
        return error ? error.details[0].message : null;
    }

    handleChange = ({currentTarget:input}) => {
        const errors = {...this.state.errors};
        const errorMessage = this.validateProperty(input);
        if(errorMessage) errors[input.name] = errorMessage
        else delete errors[input.name];

        const account = {...this.state.account};
        account[input.name] = input.value;
        this.setState({account,errors});
    }
    render() {
        const {account} = this.state;
        return (
            <form onSubmit={this.handleSubmit} className="container">
                <Input
                    label="Username"
                    name="username"
                    value={account.username}
                    onChange={this.handleChange}
                    error={this.state.errors.username}
                />
                <Input
                    label="Password"
                    name="password"
                    value={account.password}
                    onChange={this.handleChange}
                    error={this.state.errors.password}
                />
    // how to disable the button using this.validate() , it eather returns a value with error
    // which in this case would be true and disables the button ,
    // or it would return null , which is false and the button would not be disabled .
                <button disabled={this.validate()} className="btn btn-primary m-3">Login</button>
            </form>
        )
    }
}
export default LoginForm;
```

## using dynamic names for Objects

> in these lessons we used a lot of dynamic addressing of Object Properties . like bellow :

```javascript
validate = ({currentTarget:input}) => {
    const obj = {[input.name]:input.value}
}
```

## Refactoring Our Component

> in this lesson , `we cut all method` except the `handleChange` , and we put them in another Component named `Form` , then in our `InputForm` we simply `inherit` it with :
>
> ```javascript
> class InputForm extends Form {
>     // and the rest . see the examples bellow :
> }
> ```

```javascript
// this is the Form class
import React,{Component} from "react";
import Joi from "joi-browser";

class Form extends Component{
    state = {
        data:{},
        errors:{}
    };
    validate = () => {
        const option = { abortEarly: false };
        const result = Joi.validate(this.state.data, this.schema, option);
        if (!result.error) return null;
        const errors = {};
        for (let item of result.error.details) errors[item.path[0]] = item.message;
        return errors;
    };

    validateProperty = ({ name, value }) => {
        const obj = { [name]: value };
        const schema = { [name]: this.schema[name] };
        const {error} = Joi.validate(obj, schema);
        return error ? error.details[0].message : null;
    };
    handleSubmit = (e) => {
        e.preventDefault();
        const errors = this.validate();
        this.setState({ errors: errors || {} });
        if (errors) return;
        this.doSubmit();
    };
    handleChange = ({ currentTarget: input }) => {
        const errors = { ...this.state.errors };
        const errorMessage = this.validateProperty(input);
        if (errorMessage) errors[input.name] = errorMessage;
        else delete errors[input.name];

        const account = { ...this.state.data };
        account[input.name] = input.value;
        this.setState({ account, errors });
    };
}
export default Form;
```

> and this is the `InputForm` class bellow :

```javascript
import React,{Component} from "react";
import bootstrap from 'bootstrap/dist/css/bootstrap.css';
import Input from "./input";
import Joi from 'joi-browser';
import Form from "../common/form";

class LoginForm extends Form {
  state = {
    errors: {},
    data: { username: "", password: "" },
  };
  schema = {
    username: Joi.string().required().label("Username"),
    password: Joi.string().required().label("Password"),
  };

  doSubmit = () => {
    // Call Server
    console.log('Submitted')
  }
  handleChange = ({ currentTarget: input }) => {
    const errors = { ...this.state.errors };
    const errorMessage = this.validateProperty(input);
    if (errorMessage) errors[input.name] = errorMessage;
    else delete errors[input.name];

    const data = { ...this.state.data };
    data[input.name] = input.value;
    this.setState({ data: data, errors });
  };
  render() {
    const { data } = this.state;
    return (
      <form onSubmit={this.handleSubmit} className="container">
        <Input
          label="Username"
          name="username"
          value={data.username}
          onChange={this.handleChange}
          error={this.state.errors.username}
        />
        <Input
          label="Password"
          name="password"
          value={data.password}
          onChange={this.handleChange}
          error={this.state.errors.password}
        />
        <button disabled={this.validate()} className="btn btn-primary m-3">
          Login
        </button>
      </form>
    );
  }
}
export default LoginForm;
```

### A NOTE From Controlled Elements :

> you already know what a `controlled element` is , it gets its data via `props` and it raises event to the parent .

:star: __IMPORTANT__

> Controlled Components can't have `this` , or `null` or `undefined`
