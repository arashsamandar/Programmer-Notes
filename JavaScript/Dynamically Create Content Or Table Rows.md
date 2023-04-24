# Dynamically Create Content Or Table Rows

> In This Example We Are Going To Create Table Rows With Input Types Text In It , All Dynamically , With Jquery

**create you table for example like :**
```html
<div class="container" dir="rtl">
        <div class="card">
            <div class="card-header" dir="rtl" style="text-align: right">سوابق شغلی<input type="button" value="اضافه کردن" name="adding" id="addJob" class="btn btn-info"/></div>
            <div class="card-body">
                <table class="table table-bordered table-hover table-light" style="text-align: center;cursor: pointer" dir="rtl" id="jobTable">
                    <input type="hidden" name="jobs" value="jobs0" />
                    <thead class="thead-light">
                    <td scope="col">عملیات</td>
                    <th scope="col">نام سازمان/شرکت</th>
                    <th scope="col">سمت</th>
                    <th scope="col">مدت سابقه</th>
                    <th scope="col">علت پایان همکاری</th>
                    </thead>
                    <tbody>
                    <tr></tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
```

> **NOTE : The Single Stone For Our Rows To Be Operational Is That We Have To Assign Them `data-id**`

> **NOTE : We Must Use Jquery `Delegate` Method , to Access `data-id` , And Add Or Remove Rows By `data-id**`

**Now in the Jquery Part We Have**
```javascript
var education_row_counter = 0; // create some kind of counter because we want to assign a number to data-id so it would be recognizable
function add_new_education() {

    var actions = '<td>' +
        '<a href="#" id="remove" data-id="' + education_row_counter + '"><i id="removeIcon" class="fas fa-minus removestyle"></i></a>' + '&nbsp&nbsp' +
        '<a href="#" id="check" data-id="' + education_row_counter + '"><i id="checkIcon" class="fas fa-check approvestyle"></i></a>' +
        '</td>';

    var row = '<tr data-id="' + education_row_counter + '" >' + actions +
        '<td><input type="text" class="form-control" placeholder="رشته ی تحصیلی" name="reshte" id="reshte" required></td>' +
        '<td><input type="text" class="form-control" placeholder="مقطع تحصیلی" name="gerayesh" id="gerayesh" required></td>' +
        '<td><input type="text" class="form-control" placeholder="گرایش" name="maghta" id="maghta" required></td>' +
        '<td><input type="text" class="form-control" placeholder="معدل" name="moadel" id="moadel" required>' +
        '</tr>';

    $("#eduTable").append(row);

    education_row_counter++;
}

// Now Use This Function
$("#addButton").on('click',function () {
    add_new_education();
});
```

**Another Example Which Follows Above , is How To Get This Rows , We Get Them Like bellow : **

```javascript
// when the check button is clicked , we have :
$('body').delegate('#eduTable #check','click',function(){
   var data_id = $(this).data('id');
   var row = $("tr[data-id=" + data-id + "]");
   var inputTexts = row.find("input[type=text]");
});
```

**And For Removing One Of This Dynamically Created Rows , We Have :**
```javascript
body.delegate('#eduTable #remove','click',function () {
    var data_id = $(this).data('id');
    $("tr[data-id=" + data_id + "]").remove();
});
```
