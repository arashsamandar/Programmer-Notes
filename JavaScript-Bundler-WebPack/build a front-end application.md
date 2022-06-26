## How to use `webpack` to `build` a `front-end` application

https://www.youtube.com/watch?v=5IG4UmULyoA ( The Reference of this Document )

> first you need to install `node.js` , download it , or use chocholaty from powershell to install it . and then you have access to `npm` commands .

> first Open your editor or ide . here we use `Visual Studio Code` .
>
> open the file explorer . click on new file and type `src/index.js` .  again click on new file at the root again and write `public/index.html` .

> in the terminal type *npm init -y* , this would create a `package.json` that holds the `dependencies for you .

> now for example install a package like `lodash` by using `npm install lodash` , you will see a new folder is created with the name `node_modules` .

> now in your `index.js` file write bellow code . ( Don't foget to insert this file in your `index.html` file with <script src="...."></script></script>)

__in the index.js write bellow code__

```javascript
import {camelCase} from 'lodash';

console.log(camelCase("arash samandar"));
```

> if you run it now you would get `module` error . so do this :

```
npm install --save-dev webpack webpack-cli
```

> after that in the `package.json` write the following

```
Script {
	"build":"webpack"
},
```

> now in the terminal you can type

```javascript
npm run build // it would compile your index.js file
```

> this would create a `dist` folder that contains the compiled file `main.js` , which is the folder that `webpack` has created with the `npm run build` command .
>
> now instead of using `index.js` in the `index.html` file , you will intruduce the `dist/main.js` in the script `src` , and thats done .

## Create a Webpack Config File 

> see the discription in the video ( which it's link is provided at the top of this document )

## Note : for `css` and `sass` you need a `Loader` , this is crucial you learn it .

> for example you import your `sass` or `css` file in the `index.js` as the video explains . and if you don't have a `Loader` named `style-loader` and ... , you wouldn't be able to bundle these files

```
npm install --save-dev css-loader style-loader sass-loader
```

> then in `webpack.config.js` which is configuration for `webpack` , which i told you to see in the video . we add `module` , and tell it how to parse this css.sass.style files

```
webpack.config.js

},
module:{
	rules:[
	{
		test:/\.scss$/,  // meaning every file that has .scss (sass) extension
		use:[
			'syle-loader',
			'css-loader',
			'sass-loader'
		],
	},
  ],
 },
};
```

> now these style fiies are also included in our `dist/main.js`