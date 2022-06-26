## how to work in laravel

> first use the bellow command

*php artisan preset react*

> then

*npm install && npm run dev*

> now in the laravel folders you would have a `node_module`folder . also in the `resources` -> `js` -> `components`you will have an `Example`component . basically you create components like this and in this folder .

:pushpin:*an example component*

```react
import React, { Component } from 'react';

export default class Arash extends Component {
    helloWorld(name) {
        return ("hello" + " " + name);
    }
    goodbyeWorld(name) {
        return ("GoodBye " + name)
    }
    render() {
        return (
            <div class="container">
                <div>&nbsp;</div>
                <button type="button">
                    {this.helloWorld(this.props.name)}
                </button>
                <button>
                    {this.goodbyeWorld(this.props.family)}
                </button>
                <button type="button">
                    {this.props.backcountry}
                </button>
                <div>&nbsp;</div>
                <button type="button">
                    {this.props.goal}
                </button>
            </div>
        )
    }
}
```

> after that you will also have an `app.js`in the `resources` -> `js`folder



> create another file named `index.js` , this is where you render you components , or add properties with {} sign to them . like bellow :

:pushpin:*index.js*

```react
import React, { Component } from 'react';
import { render } from 'react-dom'
import Arash from "./Arash";

window.React = React;

render (<Arash total={50}
               powder={20}
               backcountry = {10}
               goal = {100}
/>, document.getElementById('react-container'));


```

**now your component is being rendered in here**



> now include you index file in the `app.js`that we have said about

```json
require('./bootstrap');
require('./components/index');
```



> in the last step add the file from `public` -> `js` -> `app.js` & `public` -> `css` -> `app.css` to your blade file .

:pushpin:**Important : Do remember to put the `js`file at the end of </body> tag**

> you also need to run `npm run watch`



> Do all the Bellow Work , not just pasting the code .

### Important

> first Copy the bellow code to `package.json` , then run a composer update , and after that run the bellow command too .

```json
"babel": {
        "presets": [
          "@babel/preset-env",
          "@babel/preset-react"
        ],
        "plugins": [
            "@babel/plugin-proposal-class-properties"
        ]
    }
```

> if it didn't work also install `npm install --save-dev @babel/plugin-proposal-class-properties`