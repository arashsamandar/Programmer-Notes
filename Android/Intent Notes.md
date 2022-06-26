# Intent Notes

> an intent is a `message Object` in Android , wich we use to pass data between activities   and etc....

> check if an `Intent` has a desired value in it with :
```java
if(intent.hasExtra("theName")) {
   // do whatever...
}
```

> NOTE : to pass `Objects` through the web or using `Intent` we first need to `Implement` an `Interface` named `Parcelable` wich is the android implementation of `Serializable` in java , it lets us transfer objects through the web or with Intents




