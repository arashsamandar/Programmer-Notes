> in JS , `&&` and `||` , or & and or have interesting effect

## &&

> if all conditions are true, *Returns The __Last One__*

```javascript
const myval = ((a < b) && (b > c) && 'C Is The Max');
console.log(myval); // returns 'c is the max'
```

## ||

> returns one of the __true ones__ , based on *how bigger it is*

```javascript
const myvaltwo = ((false) || 20 || 10 || 'arash');
console.log(myvaltwo); // returns 20
```

