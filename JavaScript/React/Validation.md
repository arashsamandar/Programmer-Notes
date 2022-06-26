## How to handle Form Submition

> every form has an event calle `onSubmit`

```javascript
export default class LoginForm extends Component {
    handleSubmit = (e) => {
        e.preventDefault();
        // call the server & save the changes / then redirect the user to other page
    }
    render() {
        return(
           <div>
            <form onSubmit={}>
              <input id="username" type="text" class="form-control" />
              <input id="password" type="password" class="form-control" />
            </form>
           </div>
        );
    }
}
```

> ofcource we can use `document.getElementById('username').value` , but in `React`we should never do that . because we never work with the Real Document Object Model `DOM`directly . 

### Using Ref

```javascript
export default class LoginForm extends Component {
    username = React.createRef();

    componentDidMount() {
        this.username.current.focus();
        const value = this.username.current.value;
    }

    handleSubmit = (e) => {
        e.preventDefault();
        // call the server & save the changes / then redirect the user to other page
    }
    render() {
        return(
           <div>
            <form onSubmit={}>
              <input id="username" ref={this.username} type="text" class="form-control" />
              <input id="password" type="password" class="form-control" />
            </form>
           </div>
        );
    }
}
```

## How to get the value of the input text

> first we define an state with the names of the input texts . after that we give every input a name and a value = {this.state.account.name} , and we also give every one Of them an onChange . like bellow

```javascript
export default class LoginForm extends Component {

    state = {
        account:{username:'',password:''}
    };

    handleSubmit = e => {
        e.preventDefault();
        console.log("form submitted");
    };

    handleChange = e => {
        const {account} = {...this.state.account};
        account[e.currentTarget.name] = e.currentTarget.value;
        this.setState({account});
    }

    render() {
        return (
            <div>
                <h1 className="float-left ml-5">Login</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group col-5">
                        <input
                            id="username"
                            value={this.state.account.username}
                            onChange={this.handleChange}
                            type="text"
                            className="form-control mb-3"
                        />
                        <input
                            id="password"
                            value={this.state.account.password}
                            onChange={this.handleChange}
                            type="text"
                            className="form-control"
                        />
                    </div>
                    <button className="btn btn-primary col-4 ml-5 float-left">Login</button>
                </form>
            </div>
        );
    }
}
```

## Validation

> for implementing validation , first we add an `state`named for example `errors` ,  the first implementation is like bellow : ( which shows the errors in the console )

```javascript
export default class LoginForm extends Component {

    state = {
        account:{username:'',password:''},
        errors:{
            username:'Username is Required'
        }
    };

    validate = () => {

        const errors = {};
        const {account} = this.state;
        if(account.username.trim() === '')
            errors.username = 'Username is Required';
        if(account.password.trim() === '')
            errors.password = 'Password is Required';

        return Object.keys(errors).lenght === 0 ? null : errors;
    };

    handleSubmit = e => {
        e.preventDefault();

        const errors = this.validate();
        console.log(errors);
        this.setState({errors});
        if(errors) return;
    };

    handleChange = ({currentTarget:input}) => {
        const account = {...this.state.account};
        account[input.name] = input.value;
        this.setState({account});
    }

    render() {
        const {account,errors} = this.state;
        return (
            <div>
                <h1 className="float-left ml-5">Login</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group col-5">
                        <Input error={errors.username} name="username" value={account.username} onChange={this.handleChange} />
                        <Input name="password" value={account.password} onChange={this.handleChange} />
                    </div>
                    <button error={errors.password} className="btn btn-primary col-4 ml-5 float-left">Login</button>
                </form>
            </div>
        );
    }
}
```

:pushpin:**And this is the Input Component that we used**

```javascript
const Input = ({name,value,onChange,error}) => {
    return (
        <div className="form-control">
        <input
            id={name}
            name={name}
            value={value}
            onChange={onChange}
            type="text"
            className="form-control mb-3"
        />
        {error && <div className="alert alert-danger">{error}</div>}
        </div>
    );
};

export default Input;
```

> and about the expression {error && .....} we have learned before , if the first is through , the second would be returned and shown .

### :pushpin: An Important NOTE

> > A Very Important Rule : we use  `const folan = {...this.bahman.folan}` on cloning in other word  ,  when we want to use the `this.setState`

## Validation errors Text  Change

```javascript
// basically the same but we have implemented a validateProperty only .
export default class LoginForm extends Component {

    state = {
        account:{username:'',password:''},
        errors:{
        }
    };

    validate = () => {

        const errors = {};
        if(this.state.account.username.trim() === '')
            errors.username = 'Username is Required';
        if(this.state.account.password.trim() === '')
            errors.password = 'Password is Required';

        return Object.keys(errors).lenght === 0 ? null : errors;
    };

    handleSubmit = e => {
        e.preventDefault();

        const errors = this.validate();
        this.setState({errors:errors || {}});
        if(errors) return;
    };

    validateProperty = (input) => {
        if(input.name === 'username') {
            if(input.value.trim() === '') return 'Username is Required';
            // .....
        }
        if(input.name === 'password') {
            if(input.value.trim() === '') return 'Password is Required';
            // .....
        }
    }

    handleChange = (e) => {

        const errors = {...this.state.errors};
        const errorMessage = this.validateProperty(e.currentTarget);
        if(errorMessage) errors[e.currentTarget.name] = errorMessage;
        else delete errors[e.currentTarget.name];

        const account = {...this.state.account};
        account[e.currentTarget.name] = e.currentTarget.value;
        this.setState({account,errors});
    }

    render() {
        const {account,errors} = this.state;
        return (
            <div>
                <h1 className="float-left ml-5">Login</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group col-5">
                        <Input error={errors.username} name="username" value={account.username} onChange={this.handleChange} />
                        <Input error={errors.password} name="password" value={account.password} onChange={this.handleChange} />
                    </div>
                    <button error={errors.password} className="btn btn-primary col-4 ml-5 float-left">Login</button>
                </form>
            </div>
        );
    }
}
```

## Using Joi Library 

> you can do `Wonderfull`things with this library `for error checking behavior`, just take a look the address https://www.npmjs.com/package/joi

:pushpin:**Install It With : ** *npm install joi-browser*

> after than you create schema , if you want the messages to be customed , here is the code
>
> and the good part is basically it works even when writing the code , or submiting the form .

```javascript
schema = {
           username: Joi.string().required().error(errors => {
               errors.forEach(err => {
                   switch (err.type) {
                       case "any.empty":
                           err.message = "نام کاربری نمیتواند خالی باشد";
                           break;
                       default:
                           break;
                   }
               });
               return errors;
           }),
           password: Joi.string().required().error(errors => {
               errors.forEach(err => {
                   switch (err.type) {
                       case "any.empty":
                           err.message = "کلمه عبور نمیتواند خالی باشد";
                           break;
                       default:
                           break;
                   }
               });
               return errors;
           }),
       };
```

:pushpin:*THis is the link for customization https://stackoverflow.com/questions/48720942/node-js-joi-how-to-display-a-custom-error-messages/48725077*

> then use it like bellow 

```javascript
import Joi from 'joi-browser';
export default class LoginForm extends Component {

    state = {
        account:{username:'',password:''},
        errors:{
        }
    };

       schema = {
           username: Joi.string().required().error(errors => {
               errors.forEach(err => {
                   switch (err.type) {
                       case "any.empty":
                           err.message = "نام کاربری نمیتواند خالی باشد";
                           break;
                       default:
                           break;
                   }
               });
               return errors;
           }),
           password: Joi.string().required().error(errors => {
               errors.forEach(err => {
                   switch (err.type) {
                       case "any.empty":
                           err.message = "کلمه عبور نمیتواند خالی باشد";
                           break;
                       default:
                           break;
                   }
               });
               return errors;
           }),
       }

    validate = () => {

        const result = Joi.validate(this.state.account,this.schema,{abortEarly:false});
        if(!result.error) return null;

        console.log(result);

        const errors = {};
        for(let item of result.error.details)
            errors[item.path[0]] = item.message;
        return errors;

    };

    handleSubmit = e => {
        e.preventDefault();

        const errors = this.validate();
        this.setState({errors:errors || {}});
        if(errors) return;
    };

    validateProperty = ({name,value}) => {
        const obj = {[name]:value};
        const schema = {[name]:this.schema[name]}
        const {error} = Joi.validate(obj,schema);
        return error ? error.details[0].message : null;
    }

    handleChange = (e) => {

        const errors = {...this.state.errors};
        const errorMessage = this.validateProperty(e.currentTarget);
        if(errorMessage) errors[e.currentTarget.name] = errorMessage;
        else delete errors[e.currentTarget.name];

        const account = {...this.state.account};
        account[e.currentTarget.name] = e.currentTarget.value;
        this.setState({account,errors});
    }

    render() {
        const {account,errors} = this.state;
        return (
            <div>
                <h1 className="float-left ml-5">Login</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group col-5">
                        <Input error={errors.username} name="username" value={account.username} onChange={this.handleChange} />
                        <Input error={errors.password} name="password" value={account.password} onChange={this.handleChange} />
                    </div>
                    <button error={errors.password} className="btn btn-primary col-4 ml-5 float-left">Login</button>
                </form>
            </div>
        );
    }
}
```

## IMPORTANT `Using Inheritance`

> now in the example above , we can use inheritance and that would make our form Component reusable with just using `extend`for any class that is a form , now first off all , we replace every `account`with `data`, something the other classes except our implementation of form can have .

> so with renaming `account`to `data`, now there is nothing else especial for this form that we can not extend ,  so in our new Component we have `validate`, `validateProperty` , `handleSubmit` , `handleChange` ,functions , and we can extend this class for any form we would make in the future , just like bellow :

> now next time we wanna build a form , we don't have to write all that code from scrach . 
>
> all we have to do > is to innitialize the state . set the schema for that form . determine what should have when the form is submited . and the render ( the UI of our form ) .

```javascript
import React,{Component} from 'react';
import Joi from "joi-browser";
export default class Form extends Component {
    state = {

    }

    validate = () => {

        const result = Joi.validate(this.state.data,this.schema,{abortEarly:false});
        if(!result.error) return null;

        const errors = {};
        for(let item of result.error.details)
            errors[item.path[0]] = item.message;
        return errors;

    };

    validateProperty = ({name,value}) => {
        const obj = {[name]:value};
        const schema = {[name]:this.schema[name]}
        const {error} = Joi.validate(obj,schema);
        return error ? error.details[0].message : null;
    };

    handleSubmit = e => {
        e.preventDefault();

        const errors = this.validate();
        this.setState({errors:errors || {}});
        if(errors) return;

        this.doSubmit();
    };

    handleChange = (e) => {

        const errors = {...this.state.errors};
        const errorMessage = this.validateProperty(e.currentTarget);
        if(errorMessage) errors[e.currentTarget.name] = errorMessage;
        else delete errors[e.currentTarget.name];

        const data = {...this.state.data};
        data[e.currentTarget.name] = e.currentTarget.value;
        this.setState({data,errors});
    };
}
```

:pushpin:**And This Is `Our form` that we extend from the `Form`**

```javascript
import React,{Component} from 'react';
import Input from '../Backup/common/input';
import Form from '../Backup/common/form';
import Joi from 'joi-browser';

export default class LoginForm extends Form {

    state = {
        data:{username:'',password:''},
        errors:{
        }
    };

    schema = {
           username: Joi.string().required().error(errors => {
               errors.forEach(err => {
                   switch (err.type) {
                       case "any.empty":
                           err.message = "نام کاربری نمیتواند خالی باشد";
                           break;
                   }
               });
               return errors;
           }),
           password: Joi.string().required().error(errors => {
               errors.forEach(err => {
                   switch (err.type) {
                       case "any.empty":
                           err.message = "کلمه عبور نمیتواند خالی باشد";
                           break;
                   }
               });
               return errors;
           }),
       }

    doSubmit = () => {
        // call the server ....
        console.log("submitted");
    }

    render() {
        const {data,errors} = this.state;
        return (
            <div>
                <h1 className="float-left ml-5">Login</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group col-5">
                        <Input error={errors.username} name="username" value={data.username} onChange={this.handleChange} />
                        <Input error={errors.password} name="password" value={data.password} onChange={this.handleChange} />
                    </div>
                    <button disabled={this.validate()} error={errors.password} className="btn btn-primary col-4 ml-5 float-left">Login</button>
                </form>
            </div>
        );
    }
}
```

> as you know we have already factored the `Input filed`of our form . here it is in bello code block :

```javascript
import React,{Component} from 'react';

const Input = ({name,value,onChange,error}) => {
    return (
        <React.Fragment>
        <input
            id={name}
            name={name}
            value={value}
            onChange={onChange}
            type="text"
            className="form-control mb-1 mt-1"
        />
        {error && <div className="alert alert-danger m-0">{error}</div>}
        </React.Fragment>
    );
};

export default Input;
```

## Extracting Helper Rendering Methods

> in the example we have , there is a submit button . it has nothing special , so we can extract it , except the button name ( which is login ) , so the extraction is pretty simple , just like bellow :

:pushpin:**we cut it from InputForm.jsx and in the form.jsx wich we extend from we have**

```javascript
renderButton = (label) => {
        return (
        <button disabled={this.validate()}
                className="btn btn-primary col-4 ml-5 float-left">
            {label}
        </button>
        );
    }
```

:pushpin:**Also as you saw we do have Two Input Filed , lets see how we render them in the form.jsx which we extend from .**

```javascript
// we cut bellow code from formInput.jsx
<Input
error={errors.username}
name="username"
value={data.username}
onChange={this.handleChange} />
// and int the form.jsx we write
import Input from './common/input';
renderInput(name,type = 'text') {
    const {data,errors} = this.state;
    return (
        <Input
            type={type}
            error={errors[name]}
            name={name}
            value={data[name]}
            onChange={this.handleChange} />
    );
}
// so now instead of first line codes for the input in the formInput.jsx we write
{this.renderInput(name)} // type is optional as you see we gave it the default value of text .
```

:pushpin:**Our very Clean render() code in the formInput.jsx now loocks like bellow**

```javascript
<form onSubmit={this.handleSubmit}>
  <div className="form-group col-5">
     {this.renderInput("username")}
     {this.renderInput("password","password")}
     {this.renderButton("Login")}
  </div>
</form>
```

## Using rest ...rest Operator

> it is very much like what we had in Java , anything can be in place of the rest , an exapmle is what we have for name , lets take a loot :

```javascript
import React,{Component} from 'react';
const Input = ({type,name,label,value,error,onChange}) => {
    <label htmlFor={name}>{lable}</label>
    <input
       value={value}
       onChange={onChange}
       type={type}
       name={name}
       id={name}
       className="form-control"
    />
    {error && <div className="alert alert-danger">{error}</div>}
}
// this is just toooo much of arguments . we can use ...rest operator for the arguments that are not passed directly in the form.jsx which we extend for InputForm.jsx . so we use ...rest just like we used ...args in java
import React,{Component} from 'react';
const Input = ({name,lable,error,...rest}) => {
    <label htmlFor={name}>{lable}</label>
    <input
       {...rest}
       name={name}
       id={name}
       className="form-control"
    />
    {error && <div className="alert alert-danger">{error}</div>}
}

```

