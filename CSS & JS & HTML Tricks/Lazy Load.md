## Showing an image like `Youtube.com` Does , Before Images Load

> to do that you use a very low size image like bellow `loqQuality-Placeholder.png` image , and put it before your main `Image`.
>
> second ) apply the `.carousel-item img.loaded` classes to the main images like below.
>
> third ) use a classname `placeholder` for the low quality images that you want to be shown first. so we can target them in the `Js Script` .
>
> forth ) write the `Script` like below :
>
> ```html
> <style>
> 	.carousel-item img.loaded {
>     	opacity: 0;
>     	transition: opacity 1s;
> 	}
> </style>
> <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
>     <ol class="carousel-indicators">
>         <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
>         <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
>         <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
>     </ol>
>     <div class="carousel-inner">
>         <div class="carousel-item active">
>             <img class="w-100 placeholder" src="{{asset('images/loqQuality-Placeholder.png')}}" alt="First slide Low Image">
>             <img class="d-block w-100 loaded" src="{{asset('images/ntwo.jpg')}}" alt="First slide">
>         </div>
>         <div class="carousel-item">
>             <img class="w-100 placeholder" src="{{asset('images/loqQuality-Placeholder.png')}}" alt="First slide Low Image">
>             <img class="d-block w-100 loaded" src="{{asset('images/none.jpg')}}" alt="Second slide">
>         </div>
>         <div class="carousel-item">
>             <img class="w-100 placeholder" src="{{asset('images/loqQuality-Placeholder.png')}}" alt="First slide Low Image">
>             <img class="d-block w-100 loaded" src="{{asset('images/nthree.jpg')}}" alt="Third slide">
>         </div>
>     </div>
>     <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
>         <span class="carousel-control-prev-icon" aria-hidden="true"></span>
>         <span class="sr-only">Previous</span>
>     </a>
>     <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
>         <span class="carousel-control-next-icon" aria-hidden="true"></span>
>         <span class="sr-only">Next</span>
>     </a>
> </div>
> <script>
>     window.onload = function() {
>         var images = document.querySelectorAll(".carousel-item img.loaded");
>         images.forEach(function(img) {
>             img.previousElementSibling.style.opacity = 0; // Hide the placeholder
>             img.style.opacity = 1; // Show the main image
>         });
> 
>         var placeholders = document.querySelectorAll('.placeholder');
>         placeholders.forEach(function(placeholder) {
>             placeholder.style.display = 'none'; // Hide the placeholder
>         });
>     };
> 
> </script>
> ```



