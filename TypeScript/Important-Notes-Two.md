## Casts & Predicates

```typescript
// when `is` is used . it means trust me the type that would be returned is ( here `IUser` )
const myUser: IUser = await mongoose.connection.collection('users').findOne({name:'arash'}) as IUser;
```

> when defining a variable without type ( that would typically get the type `any` ). and but > then you want to use it as a string ( or run a method on it that is string . like `endWith('myname')`) . use ( myVarible as string ) or <string>

```typescript
const myName = 'arash samandar' // would have type any ( as you didn't define the type explicitly )
const lastName = (<string>myName).endsWith('samandar');
const lastName = (myName as string).endsWith('samandar');
```

## using Predicate

> here to show that the if the functions returns value ( it would definitely be of type `someType`)

```typescript
interface IUser extends mongodb.Document {
    name: string,
    family: string,
    age: number
}

function checkIsIUser(user: any): user is IUser {
return obj && (typeof user.name); 
    // surely user ( which here can be passed as any object ) should
    // should have the property 'name' . and we check here if it does then we say well it is of type     //our IUser 
}
```

