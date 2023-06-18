> in JS , `&&` and `||` , or & and or have interesting effect

## &&

> if all conditions are true, *Returns The __Last One__*

```javascript
const myval = ((a < b) && (b > c) && 'C Is The Max');
console.log(myval); // returns 'C is the max'
```

## ||

> returns the first true one

```javascript
const myvaltwo = ((false) || 20 || 10 || 'arash');
console.log(myvaltwo); // returns 20
```

