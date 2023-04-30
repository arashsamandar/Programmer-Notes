### Destructuring Assignments ( with Objects )

>Destructuring assignment is a way to extract values from arrays or objects and assign them to variables in a more concise syntax . It can be used to assign default values as well as to rename variables . In this case, the code is extracting the `id` property from the `query` object and assigning it to a new variable named `id`. This can be useful when working with APIs or other data sources that return complex objects and you only need to use a few of their properties .

> The reason that `id` is in braces is that it is being extracted from an object. The braces define an object literal, which is a way of sending key/value pairs of data . In this case, the `query` object likely has multiple properties, and the curly braces are used to only extract the `id` property.

```javascript
const { id } = query;
```

### Destructuring Assignments ( with Arrays )

> In the code `const [title, content] = response.data.values[0];`, the square brackets are used to perform array destructuring in JavaScript [[1\]](https://www.cms.gov/Outreach-and-Education/MLN/WBT/MLN6447308-ICD-10-CM/icd10cm/lesson01/23-coding-conventions/index.html). The `response.data.values[0]` is an array containing two elements, and the code is extracting those elements and storing them in the variables `title` and `content` respectively

```javascript
const [title, content] = response.data.values[0];
```

### an example of `Destructuring Assignment` in `TypeScript`

```typescript
interface Human {
    names: string;
    family: string;
    age: number;
}

let arash: Human = {names: 'Arash', family: 'Stark', age: 45};

let { names } = arash;
console.log(names);
```

