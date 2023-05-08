> bellow code show a `typical function` in typescript :

```typescript
function SomeNextJSFramework({params,}:{params:{id: string}}) {
    // return something
}
```

>This syntax defines the structure of the `params` object and its `id` property. It ensures that any object passed as the `params` argument must have a property called `id` that is of type `string`. If the `params` argument is missing or does not have the expected structure, TypeScript will raise a type error.