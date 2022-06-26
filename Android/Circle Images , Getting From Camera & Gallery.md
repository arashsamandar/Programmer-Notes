# Circle Images , Getting From Camera & Gallery
> here we use Glide , but you can use three options to make an image look round in android
1. for using `Glide` you need to add `implementation 'com.github.bumptech.glide:glide:4.9.0'` in your gradle.build
1. by using `Glide` , it is the best option and also supports `Bitmap` images
- Optional : if you needed `Picasso` you need to add implementation '`com.squareup.picasso:picasso:2.5.0`'
- Optional : if you needed `CircleImageView` you need to add  '`de.hdodenhof:circleimageview:3.0.0`'
- Optional : by using `Picasso` , it does not support bitmaps , and uses Url
- Optional : by using `CircleImageView` wich is a view and can be used even in xml , but is not a good option


> here we use `Glide` to make our images that is captured from `Gallery` and `Camera` , look round . using bellow code :
1. From Camera
```java
Bitmap photo = (Bitmap) data.getExtras().get("data"); // this is how we read image from camera after firing startActivityForResult
Glide.with(getActivity()).asBitmap().load(photo).apply(RequestOptions.circleCropTransform()).into(imageView);
```

2.   From Gallery
```java
Uri selectedImage = data.getData(); // this is how we read image from gallery after firing startActivityForResult
Glide.with(getActivity()).load(selectedImage).apply(RequestOptions.circleCropTransform()).into(imageView);
```


---

# Getting Image From Camera & Gallery with A Button

## Setting Permissions :

> Note : to read images From `Camera` and/or `Gallery` we need to set `Permissions` in `AndroidManifest`
```markup
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
> Note : we also need to write a `checkSelfPermission` to see if program has the permission needed to read from camera or not , as camera is considered to be a dangerous `Permission` . and if not we need to use `requestPermission()` wich would show a `dialogBox` for the user to eather accept or deny it , here is the code :
```java
if(getActivity().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
         requestPermissions(new String[]{Manifest.permission.CAMERA},CHECK_PERMISSION); // this would show a dialogbox for user
}
```
> then we check if the `permission` is granted or not , we check that by `overridding` the function `onRequestPermissionsResult` , like bellow :
```java
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CHECK_PERMISSION) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // launch what you wanted
            }
        }
}
```

## Now Getting Image From Camera and/or Gallery :

> after that we put an `OnClick()` method for `ImageView` like bellow :
```java
public void imageViewClick() {
        ImageView imageView = view.findViewById(R.id.user_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View alertView = getLayoutInflater().inflate(R.layout.camera_or_gallery_alert_box,null);
                Button camera = alertView.findViewById(R.id.camerabtn);
                camera.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(View v) {
                        if(getActivity().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            requestPermissions(new String[]{Manifest.permission.CAMERA},CHECK_PERMISSION);
                        } else {
                            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(cameraIntent, CAMERA_REQUEST);

                        }
                    }
                });

                Button gallery = alertView.findViewById(R.id.gallerybtn);
                gallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        galleryIntent.setType("image/*");
                        startActivityForResult(galleryIntent, GALLERY_REQUEST);
                    }
                });

                builder.setTitle("انتخاب تصویر");
                builder.setView(alertView);
                alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
```

> and as you see `startActivityForResult` is launched , so we do whatever we want with the image in the `onActivityResult` function
```java
public void onActivityResult(int requestCode, int resultCode, Intent data) {

        ImageView imageView = view.findViewById(R.id.user_image);
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            alertDialog.dismiss();
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            Glide.with(getActivity()).asBitmap().load(photo).apply(RequestOptions.circleCropTransform()).into(imageView);
        }
        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            alertDialog.dismiss();
            Uri selectedImage = data.getData();
            Glide.with(getActivity()).load(selectedImage).apply(RequestOptions.circleCropTransform()).into(imageView);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
```
