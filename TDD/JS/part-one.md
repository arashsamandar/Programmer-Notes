> to run some tests in `JS` you gotta use things like
>
> `Jest Library` , commands like `npm run test` , and codes like :
>
> 1) test
> 2) expect
> 3) etc...

a simple test , here testing arashFunctions.js => someTestFunction() output :

```javascript
function someTestFunction() {
    let a = 10;
    let b = 20;
    return (a + b);
}

export default someTestFunction;
```

then in the `test` folder we create the test file like `something.test.js`

```javascript
import someTestFunction from "./arashFunctions";

test('to check how things go here',()=>{
    expect(someTestFunction()).toBe(30);
})
```

and then `npm run test`

-------------

## Testing React

> first install bellow packages
>
> ```bash
> npm install --save-dev jest jest-environment-jsdom @testing-library/jest-dom @testing-library/react
> ```

```javascript
/**
 * @jest-environment jsdom
 */

import React from "react";
import MySecondComponent from "./MySecondComponent";
import { screen,render } from "@testing-library/react";
import '@testing-library/jest-dom';

test('see how second component work arash',()=>{
    render(<MySecondComponent arashPropsHere="Hello Arash Samandar" />);
    expect(screen.getByText("Hello Arash Samandar")).toBeInTheDocument();
});
```

and `MySecondComponent` is :

```javascript
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

### Test Click Event

> first remember to install `@testing-library/user-even` 

```javascript
import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import Counter from './Counter';

describe('Counter', () => {
 test('renders a count of 0', () => {
    render(<Counter />);
    const countElement = screen.getByRole('heading');
    expect(countElement).toHaveTextContent('0');
 });

 test('renders a count of 1', () => {
    render(<Counter initialCount={1} />);
    const countElement = screen.getByRole('heading');
    expect(countElement).toHaveTextContent('1');
 });

// -------------------- Checking User Event Click Bellow --------------------

 test('renders a count of 1 after clicking the increment button', async () => {
    render(<Counter />);
    const incrementButton = screen.getByRole('button', { name: 'Increment' });
    await userEvent.click(incrementButton);
    const countElement = screen.getByRole('heading');
    expect(countElement).toHaveTextContent('1');
 });
});
```

