# AlertDialog
> to make an `AlertDialog` first you need to make an `AlertBuilder`
```java
AlertBuilder alertBuilder = new AlertBuilder(this);
LayoutInflater lf = getSystemService(LAYOUT_INFLATOR_SERVICE);
View view = lf.inflate(R.layout.your_alertbox_layout,null);
lf.setView(view);
lf.setTitle("samandar");
// now we can initialize the AlertDialog to be Shown
AlertDialog alertDialog = alertBuilder.create();
alertDialog.show();
```


---
## Implement A Listenere For Dialog Dismiss
> we may close a dialog by
```java
alertDialog.dismiss();
```

> to get the `dismiss()` event of an `AlertDialog` we need to
1. first create the `listener` in your main function `before` you create or call the `dialog`
```java
 final DialogInterface.OnDismissListener listener = new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                // do whatever you want here
            }
        };
showLoginDialog(listener);
```
1. then in the `AlertDialog` body declare a
```java
alertDialog.setOnDismissListener(listener); // and pass your listener
```
