## Initializing an empty `express.js` project with `typescirpt` and `nodemon`

1.

> 1. for `package.json` run : `npm init -y`
>
> 2.  `npm install express`
>
> 3.  if you want `typescript` just run : 
>
> 4. `npm install --save-dev typescript ts-node @types/node @types/express` ( @types/node for ts to detect node types and @types/express for express )
>
> 5. Generate `tsconfig` file with `npx tsc --init`
>
> 6. Create your Express server with TypeScript: Create a `src` directory and an `index.ts` file inside it
>
>    
>
> 7. ```typescript
>    // src/index.ts
>    import express from 'express';
>    
>    const app = express();
>    const port = 3000;
>    
>    app.get('/', (req, res) => {
>      res.send('Hello, TypeScript with Express!');
>    });
>    
>    app.listen(port, () => {
>      console.log(`Server is running on http://localhost:${port}`);
>    });
>    ```
>
> 8. use `ts-node `instead of `node` for running if you want
>
> 9. use `nodemon` or `ts-node-dev` for automatic reloading
>
> 10. all 8 and 9 tools can be configured in the `package.json` file , like in the `script` section you would have like : `nodemon --exec ts-node ./Path/ToEntryPoint`

2.

> 1) install `express generator` : like `npm install express-generator` i think the name is
> 2) go to the folder you want and : `express my-new-express`
> 3) got to `my-new-express` and : `npm install` to install all dependencies

> 1. installing `tsc` ( typescirpt compiler )
> 2. adding `typescript` config file with command : `npx tsc --init`
> 3. installing `ts-node`
> 4. installing `nodemon` with : `npm install nodemon`
> 5. chaning the `script` of `start` in the `package.json` file like :
> 6. `"start": "nodemon --exec ts-node ./bin/www"`

> 1. change files to `.ts` , like change `www` file and the ones you work with like `app.ts` and `index.ts`
> 2. change `app.ts` and rest of it's relative included files to code `ES6` ( i mean to `typescript` language )