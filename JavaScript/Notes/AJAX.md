# AJAX
> **First You Have To Visit This Site :** https://www.w3schools.com/js/js_ajax_intro.asp

---

## AJAX REQUESTS

**we have `GET` & `POST` Requests . BUT !**

> always use `POST` requests when:

**1)** A cached file is not an option (update a file or database on the server).
**2)** Sending a large amount of data to the server (POST has no size limitations).
**3)** Sending user input (which can contain unknown characters), POST is more robust and secure than GET.

> An Example Of How we Create And Use Ajax In a Simple way

```markup
<button type="button" onclick="loadDoc()">use ajax</button>
```

```javascript
function loadDoc() {
   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
      if(this.readyState == 4 && this.status == 200) {
         // change the text in div with id of demo
         document.getElementById("demo").innerHTML = this.responseText;
         // Note: we use responseText and/or responseXml ,to get the result after calling open and send
      }
   };
   xhttp.open("GET","ajax_info.txt",true);
   xhttp.send();
}
// Meaning : you send a GET Request to "ajax_info.txt" File.
// and now you get that file , and you show whatever is in it with this.responseText
```

> **NOTE :** for `Ajax` in `Laravel` , and more complicated `Ajax` Requests with `JQuery` , watch the `Ajax` page at `Laravel` NoteBook



