> one of the things is the use of `data-id` tag , we can use it to access our `tr` in a table , just like bellow

```javascript
<input type="button" data-id="{{$product->id}}" value="folan value" />
    
// and we can get it later with
    
var trId = $(this).data('id');
```

