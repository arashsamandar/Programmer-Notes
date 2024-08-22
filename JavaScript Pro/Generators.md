## Using Generators In An `Async` Operation

```javascript
async function* fetchUsersData(users: number[]){
    const usr = {};
    for(const user of users){
        const userData = await fetch('https://jsonplaceholder.typicode.com/users/${user}');
        const userJsonObj = userData.json();
        yield userJsonObj;
    }
}

async function iterateThroughUsersAndPrint(){
    for await (const user of fetchUsersData([2,4,3])){
        console.log(user);
    }
}

iterateThroughUsersAndPrint();
```

