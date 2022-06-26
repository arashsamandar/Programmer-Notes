# AJAX REQUESTS

Adding **AutoComplete** To An Input Text

**1)** To Do This We Have To use `jquery ui (autocomplete) method` : like bellow :
```javascript
$('#ostan').autocomplete({
   source:YourArrayDataSource
});
```

**The Complete Code For AutoComplete**
```javascript
function listenFor_ostan_KeyDown() {
        var ostan = $("#ostan");
        var provinces = [];
        ostan.on("keyup paste",function () {

            var value =$(this).val();
            var address = " {{ URL::to('AjaxRequest/processOstanAutoComplete') }} ";
            $.ajax({
                type:'POST',
                url:address,
                data:{"_token": "{{ csrf_token() }}",ostan:value},
                success:function (data) {
                    var i = 0;
                    while(data.length > i) {
                        console.log(data[i].name);
                        if(!provinces.includes(data[i].name))  {
                            provinces.push(data[i].name);
                        }
                        i++;
                    }
                    $( "#ostan" ).autocomplete({
                        source: provinces
                    });
                }

            })

        });
    }
    listenFor_ostan_KeyDown();

// NOTE :: to make it right to left :
<style>
        .ui-menu .ui-menu-item-wrapper {
            position: relative;
            padding: 3px 1em 3px .4em;
            text-align: right;
        }
</style>
```
