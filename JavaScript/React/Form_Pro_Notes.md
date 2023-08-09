> if you ever had used `useState()` for example for an *input field text* , that has several qualifications like `accountError` in below code :

```react
const [accountErrors,setAccountErrors] = useState({
        username:{lenghtError:'',emailError:''},
        password:'',
    })
```

> then you must use `prevState.username` like below ( otherwise code will not work )

```react
const handleChange = (event) => {
        setAccount(  {[event.target.name]:event.target.value});
        console.log(account.username.length);
        handleValidation();
    }
    const handleValidation = () => {
        if(account.username.length + 1 < 5 && account.username !== "") {
            setAccountErrors(prevState => ({...prevState,username:{...prevState.username,lenghtError: 'number is less than 5'}}));
            console.log(accountErrors.username.lenghtError);
        } else {
            setAccountErrors(prevState => ({...prevState,username: {...prevState.username,lenghtError: ''}}));
        }
        if(!(/\S+@\S+\.\S+/.test(account.username)))
            setAccountErrors(prevState => ({...prevState,username:{...prevState.username,emailError: 'username is not a valid Email'}}));
        else
            setAccountErrors(prevState => ({...prevState,username:{...prevState.username,emailError: ''}}));
    }
```

> watch the below line :
>
> ```react
> ({...prevState,username:{...prevState.username,emailError: 'username is not a valid Email'}}));
> ```

## Important On Using Objects

> we can also use __adding property to an already defined object__ , like what we did bellow : if the conditions matches and there is for example (length) error , we do :
>
> ```react
> if(account.username.length < 5 ) {
>     accountErrors.username = "username can't be less than 5"
> } else {
>     delete accountErrors.username;
> }
> // and then we iterate over this object properties ( that we have added in case of validation errors )
> render() {
>     return (
>         {Object.values(accountErrors).map(item => {
>         	return <div>{item}</div>
>    		 })}
>     )
> }
> ```

### example of setting the state with `||` OR , and `&&` , like below :

```react
const accountErrors.username.lenghtError = 'something'
this.setState({errors:accountErrors || {}}) // watch it carefully !!
```

> says that if the `accoutnErrors` is empty or 0 , >> then give it an empty object like `{}`

## using inheritance in react.js

> in react.js if you have had a lot of methods , you may want to refactor that methods in a new file , for example a `form.jsx` file.
>
> then creating another form is easier , we just create `loginForm.jsx` and have it `extend` the `form.jsx` parent class so that the *loginForm.jsx* has all the methods available in `form.jsx`

## Using Inheritance in Functional Components

> to do so , copy all the states and useStates , in other word copy the code from top to the last function ( except the return part of the code ),
>
> then transfer it in another functional component , but with the difference that it shall `return an object that includes all the method names and useStates like 'Accounts' and 'AccountErrors'
>
> then in the top of the parent file , write everything that is needed in one object (seperated by comma ), and this list should include all the methods and ... that the child has
>
> Done
>
> `Thus Creating A Custom Hook` :

```react
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function useLoginForm() {
    const navigate = useNavigate();
    const [account, setAccount] = useState({
        username: "",
        password: "",
    });
    const [accountErrors] = useState({
        username: {},
        password: {},
    });

    const handleChange = (event) => {
        setAccount({ [event.target.name]: event.target.value });
        handleValidation();
    };

    const handleValidation = () => {
        if (account.username.length < 5 && account.username !== "") {
            accountErrors.username.lengthError = "username is less than 5";
        } else {
            delete accountErrors.username.lengthError;
        }
        if (
            account.username.length > 0 &&
            !/\S+@\S+\.\S+/.test(account.username)
        ) {
            accountErrors.username.validEmail = "username is not a valid Email";
        } else {
            delete accountErrors.username.validEmail;
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        navigate("/movies", { replace: true });
    };

    return {
        account,
        accountErrors,
        handleChange,
        handleSubmit,
        handleValidation,
    };
}

```

> now in our main file we have :

```react
import React, {useEffect, useRef, useState} from "react";
import {useNavigate} from "react-router-dom";
import useLoginForm from "./useLoginForm.jsx";
export default function Login() {
    const { account, accountErrors, handleChange, handleSubmit } = useLoginForm();
    return (
        <form className="col-md-4" style={{margin:'0 auto'}}>
            <h3 style={{margin:'20px 20px'}}>Login</h3>
            <input type="text" onChange={handleChange} onPaste={handleChange} onSelect={handleChange} className="form-control col-3" value={account.username} name="username" />
            {Object.values(accountErrors.username).map(item => {
                if(item !== '' || item.length > 2) {
                    return <div className="alert alert-danger">{item}</div>
                }
            } )}
            <input type="text" onChange={handleChange} className="form-control col-3" value={account.password} name="password" /><br/>
            <div className="text-center">
                <input type="submit" value="Submit" name="submit" onClick={handleSubmit} className="btn btn-outline-success"
                       style={{width:'200px'}}
                />
                <br/>
            </div>
        </form>
    )
}
```

### Resolving Input Field validation

> if you had problem with the length of the characters ( for example still showing the message of not enough characters , tho you did insert enough characters , use *onPaste*={handleChange} *onSelect*={handleChange}) too
