> Remember that you must create a `Jest` config file in the root directory
>
> like bellow :
>
> ```json
> module.exports = {
>   roots: ['<rootDir>/test'],
>   testRegex: '.*\\.test\\.ts$',
>   moduleFileExtensions: ['ts', 'js'],
>   transform: {
>     '^.+\\.ts$': 'ts-jest'
>   },
>   coverageDirectory: '__coverage__',
>   collectCoverage: true
> };
> ```

### also Remember to Install

```bash
npm install --save-dev jest ts-jest @types/jest supertest @types/supertest
```

## Increase Speed :

> 1. skip typescript `type checking` for better speed . just use bellow in `jest` config :
>
> ```json
> // jest.config.ts
> const config: JestConfigWithTsJest = {
>     transform: {
>         '^.+\\.(t|j)s$': ['ts-jest', { isolatedModules: true }]
>     },
> }
> ```

2. **Use Faster Transformers**: Consider using faster transformers like `esbuild` or `swc` instead of `ts-jest` or `babel-jest`. These tools are written in Go and Rust and are designed to be faster at transpiling TypeScript code to JavaScript, which can speed up your tests.

3. **Install `esbuild-jest` and `esbuild`**: First, you need to install `esbuild-jest` and `esbuild` as development dependencies in your project

```bash
npm install --save-dev esbuild-jest esbuild
```

and then update the `jest.config.js`

```json
module.exports = {
  transform: {
    '^.+\\.tsx?$': 'esbuild-jest',
  },
};
```

