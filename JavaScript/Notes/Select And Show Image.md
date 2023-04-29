# Select And Show Image
> first in your `Html` form you must have
```html
<form method="post" action="{{route('userRegister')}}" enctype="multipart/form-data">
   <input type="file" class="form-control" name="image" id="image">
   <img src="" id="userImageShow" class="imageView" />
</form>
```

> then in the `JavaScript` we have :
```javascript
$(function () {
            $('.imageView').css('display','none');
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    // Start of getting and showing the size of image in an alertBox
                    // size is in byte , here we convert it to MB
                    var alertSize = (input.files[0].size) / (1024*1024);
                    alert(alertSize);
                    // end of showing the size in alertBox
                    reader.onload = function (e) {
                        $('.imageView').attr('src', e.target.result);
                        $('.imageView').css('display','block');
                    }
                    reader.readAsDataURL(input.files[0]);
                }
            }
            $("#image").change(function(){
                readURL(this);
            });
        });
```
