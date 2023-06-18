> if you need to iterate over the keys of an object, use the `for...in` loop. If you want to iterate over the values of an object and require a specific order of iteration, use the `for...of` loop.

```typescript
let arash = {name:'arash',family:'samandar'};
let value: keyof typeof arash;
// we have to use above line if we want the bell
for(value in arash) {
  console.log(arash[value]);
}
//---------------------------------------------
for(let [key,value] Object.entries(arash)) {
    console.log(key + value);
}
```

