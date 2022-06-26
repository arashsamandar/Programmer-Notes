# Android MVC
## MVC Basics

> Model-View-Controller or MVC has Three parts
1. Model : is the data your program will use ( its devided into classes to make it a lot easier to program )
1. View : is what the user sees , its the user interface
1. Controller : this is the logic of the program .
### **Better Definition**
1. **Data**
1. **UI**
1. **Code**
- **IMPORTANT : meaning define your data first , then create the userface , and then , get down to the programming**

### Step 1 - Design The Classes
> Create the UML diagram for the application
> Each "thing" in your program becomes a class .
> Each class is given its own attributes ( variables ) and methods


### Step 2 - The User Interface
> now you know what data is neede you can designthe screens you will need.
> if you are converting from a paper-baed system , then your screen would ideally "look" like the forms the users know .
> there is a whole science behind this

### Step 3 - Coding
> Now you can knit the classes and the user interface together
> this is the programming part - and it comes last , not first !





# 
# 
# 
---

## MVC Pattern In Android

> There Are Two Types That I know Of


## Type One :


### Activity ( Observer )
- Act as the `Controller` and the `View`
- Direct the button click to be handled by the `Model`

### Model ( Observable )
- Contains the data ( simple array/list with 3 elements )
- After updating the values of the data, it will notify the Observer about the changes

> First create your `Models` in Model folder

> **NOTE :** The Model classes should extend the `Observable`

> **NOTE :** The Controller or in our case `Activity` should implement the `Observable` interface

AN Example Of Defining A Model
```java
public class MyModel extends Observable {
   private List<Integer> mList;
   mList.add(0);mList.add(0);mList.add(0);
   
   public MyModel() {
      mList = new ArrayList<Integer>(3);
   }
   
   public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException {
      return mList.get(the_index);
   }
   
   public void setValueAtIndex(final int the_index) throws IndexOutOfBoundsException {
      mList.set(the_index,mList.get(the_index) + 1);
      setChanged(); // An Observable Method
      notifyObservers(); // An Observable Method
   }
}
```

And The Activity
```java
package myapp.mvcpattern
public class MyMVCApp extends AppCompat implements Observer,OnClickListener {
   
   private MyModel mModel;
   private Button mButtonOne;
   private Button mButtonTwo;
   private Button mButtonThree;
   
   public void initializeButtons() {
      mButtonOne = findViewById(R.id.btnOne);
      mButtonTwo = findViewById(R.id.btnTwo);
      mButtonThree = findViewById(R.id.btnThree);
      mButtonOne.setOnClickListener(this);
      mButtonTwo.setOnClickListener(this);
      mButtonThree.setOnClickListener(this);
   }
   
   public void onCreate(Bundle savedInstantState) {
      super.onCreate(savedInstantState);
      setContentView(R.layout.main_activity);
      initializeButtons();
      mModel = new Model();
      mModel.addObserver(this);
   }
   
   public void onClick(View v) { // created because of OnClickListener Interface
      switch(v.getId()) {
         case R.id.btnOne:
            mModel.setValueAtIndex(0);
            break;
         case R.id.btnTwo:
            mModel.setValueAtIndex(1);
            break;
         case R.id.btnThree:
            mModel.setValueAtIndex(2);
            break;
      }
   }
   
   public void update(Observable arg0, Object arg1) { // created because of Observer Interface
      mButtonOne.setText("counte : " + mModel.getValueAtIndex(0));
      mButtonTwo.setText("counte : " + mModel.getValueAtIndex(1));
      mButtonThree.setText("counte : " + mModel.getValueAtIndex(2));
   }
}
```

---

## Type Two

> In this Type We Set A `Controller` , and this controller does all the work of getting the data from the models . models also can talk to each other .anyway Controller here is the provider of information for the View .

> you can use this `Controller Class` as a `Global` class. If any View(Activity) required values then view should call controller and then controller will call appropriate Model and provide value to view.










