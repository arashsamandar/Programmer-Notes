# Cropping Images
> you can crop images with libraries **because android default camera cropper won't pass the value back from crop**
> two libraries wich i strictly suggest are as follows :
1. `android-image-cropper`
1. `UCrop`
> we use **android-image-cropper ,** you can find more about it by typing the name i wrote in the browser.

### **steps :**
**first )** add the implementation to the gradle build ,  we are using version 7
```makefile
implementation 'com.theartofdev.edmodo:android-image-cropper:2.7.0'
```

**second )** add the activity to your manifest
```makefile
<activity android:name="com.theartofdev.edmodo.cropper.CropImageActivity"
            android:theme="@style/Base.Theme.AppCompat"/>
```

**Third )** now you can utilize it by just writing some simple code , **Notice :** you don't need to add two buttons for the user two choose between **camera** or **gallery** , the **cropper** would do it for you .


---


> To fire it , you need to write , **Notice :** there is nothing more , just this simple , it would launch the camera or gallery by user choice and it would then launch it's cropper .
```java
// if you are in a fragment
CropImage.activity().start(getContext(),RegisterFragment.this);
// if you want the selector to be Oval the oval is not supported yet , next year it would be supported probably
CropImage.activity().setAspectRatio(1,1).setCropShape(CropImageView.CropShape.OVAL).start(getContext(),RegisterFragment.this);
```

> then we get the result in the `OnActivityResult()`
```java
@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView imageView = view.findViewById(R.id.user_image);

        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {

                alertDialog.dismiss();
                Uri resultUri = result.getUri();

                try {
                    photo = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), resultUri);
                       Glide.with(getActivity()).asBitmap().load(resultUri).apply(RequestOptions.circleCropTransform()).into(imageView);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }
    }
```
