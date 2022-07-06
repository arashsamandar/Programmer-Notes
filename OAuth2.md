> first you must know that we have three part , one part is the user-side ( or when the user clicks on an icon , for example clicks on the `Login With Google` ) .
>
> Then our Application sends a requiest to the `Authorization Server` , and passes : `Client ID` , `Secret ID` and `Unique URL` ( which would be used to return the Authorization code back to us ).
>
> Then Once Again we send this *Authorization Code* to the *Authorization Server* , and we get an *Access Token*
>
> Then we will send this *Access Token* to the Authentication server and we get Access To the *Resource Server*
>
> And now we can Access the user data .
>
> Notice The Bellow Image :

![image-20220707013727576](D:\Programming Notes\OAuth2.assets\image-20220707013727576.png)

> in the first step , *Name Of The Application* , *Website* , *Callback URL* Must be sent , from **MyBucks App** , To the **Memorial Bank** Authorization Server .

![image-20220707013940513](D:\Programming Notes\OAuth2.assets\image-20220707013940513.png)

> After that *Authorization Server* send back The *Client ID* ( Which is Application Independet to Authorize Application ) , and a *Client Secret* Would be Passed To Our Server .
>
> This Client ID & Client Secret , Would be later used , to be sent to the Authentication server And get a *Access Token* Back .

![image-20220707014414970](D:\Programming Notes\OAuth2.assets\image-20220707014414970.png)

> There Are **4** Types Of Grant , But for the web , we use *Authorization Code Grant*

-------------------

> Another Good illustration has came bellow :arrow_double_down: , Watch The Steps Carefully , Happy Coding :happy:

![image-20220707015305940](D:\Programming Notes\OAuth2.assets\image-20220707015305940.png)