## For React.js Component

> test files should be `test.jsx` and Not `test.js` ( if you want component render and screen for it )
>
> Install libraries :

├── jest
├──	@testing-library/user-event
├──	@testing-library/jest-dom
├── @testing-library/react
├── vitest

```react
	include :
		import { describe, it, expect, vi } from 'vitest';
		import '@testing-library/jest-dom';
		import { render, screen } from '@testing-library/react';
		import userEvent from '@testing-library/user-event';
		import AddBooksForm from "../src/components/test_components/AddBooksForm.jsx";
```

> Example :

```react
import '@testing-library/jest-dom';
import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import AddBooksForm from "../src/components/test_components/AddBooksForm.jsx";

describe('doing test for my ReactJS Component', () => {
    test('sample test', async () => {

        const alertMock = vi.spyOn(window, 'alert').mockImplementation(() => {});

        render(<AddBooksForm />);

        const input1 = screen.getByLabelText(/name/i);
        const input2 = screen.getByLabelText(/email/i);
        const input3 = screen.getByLabelText(/password/i); // Get the first password input
        const input4 = screen.getByPlaceholderText("confirm password");
        const submitButton = screen.getByRole('button', { name: /submit/i });

        await userEvent.type(input1, 'arashSalamander');
        await userEvent.type(input2, 'arash.internet@gmail.com');
        await userEvent.type(input3, '123456');
        await userEvent.type(input4, '123456');
        await userEvent.click(submitButton);

        await expect(alertMock).toHaveBeenCalledTimes(1);
        expect(alertMock).toHaveBeenCalledWith('hello arash solomon');
    });
});
```

## Section Two ( 2 )

> first install the libraries needed for react ( remember to install only for development)
>
> ```
> npm install --save-dev @testing-library/react
> ```
>
> then install jest : Jest is a JavaScript testing framework developed by Facebook. It's used to create, run, and structure tests
>
> ```
> npm install --save-dev jest
> ```
>
> then if you write ES6 ( which you do most of the times ) , you need babel too with :
>
> ```
> npm install --save-dev @babel/core @babel/preset-env
> ```
>
> Then, create a `.babelrc` file in the root of your project and add the following:
>
> ```json
> {
> 	"presets": ["@babel/preset-env", "@babel/preset-react"]
> }
> ```

> also in the `package.json` write the __script for test__ like below :
>
> ```json
> "scripts": {
>     "test": "jest"
>  }
> ```

> then write a file with `.test.js` in your test folder ( create it if it is not there ) , write file like `arashFunction.test.js` , and include below code ( the easiest ) , ( also remember to add the functions you want ( i mean import them ))
>
> ```javascript
> // my own arash.js file with below functions 
> 
> function showArashString() {
>     return "Arash";
> }
> 
> function showArashNumber() {
>     return 35;
> }
> 
> export default {
>     showArashString,
>     showArashNumber,
> }
> ```
>
> ```javascript
> // arash.test.js
> 
> import arash from './arashExports';
> 
> test('show string and number',()=>{
>     expect(arash.showArashNumber()).toBe(35);
> });
> ```
>
> and then run __npm test__ and done :)

--------

### For a more complicated like testing a component we shall also have :

> below we want to test a component : we want to see whether the `arashPropsHere` value ( like a string that it could be ), is in the output of the component or not , supporse `arashPropsHere` is `Hello Arash Samandar` , now test like below :

> the actual component below :

```javascript
// the component itself
import React from "react";

const MySecondComponent = ({arashPropsHere}) => {
    return (
        <div>
            {arashPropsHere}
        </div>
    )
}

export default MySecondComponent;
```

> and the test file like below :
>
> ```javascript
> /**
>  * @jest-environment jsdom
>  */
> 
> import React from "react";
> import MySecondComponent from "./MySecondComponent";
> import { screen,render } from "@testing-library/react";
> import '@testing-library/jest-dom';
> 
> test('see how second component work arash',()=>{
>     render(<MySecondComponent arashPropsHere="Hello Arash Samandar" />);
>     expect(screen.getByText("Hello Arash Samandar")).toBeInTheDocument();
> });
> ```

> prerequisits :
>
> install
>
> ```
> npm install @testing-library/jest-dom
> ```
>
> and then including it like below :
>
> ```javascript
> import '@testing-library/jest-dom'
> ```
>
> ```
> npm install --save-dev @testing-library/react
> ```
>
> and then include `render` & `screen` from it like below :
>
> ```javascript
> import { screen,render } from "@testing-library/react";
> ```
>
> then also import `render` & `screen`
>
> 
>
> 