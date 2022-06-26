# Navigation Drawer
> there are several steps for creating the `Navigation Drawer`
1. add `implementation 'com.android.support:design:28.0.0'` in your build.gradle(Module: app)
1. Not Neccesary : but remove the `ActionBar` from your `styles.xml`
> write bellow `style` and use it as your them for you desired `activity` or for all of your `application`
```markdown
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="ArashStyle" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
        <item name="android:direction">right_to_left</item>
        <item name="android:layoutDirection">rtl</item>
        <item name="android:textDirection">rtl</item>
        <item name="android:statusBarColor">@android:color/transparent</item> <-- this item is only for v21 version -->
    </style>
</resources>
```
> `Note :` to create the `styles.xml(v21)` file , create the `resource` file and in the left options , choose `version` and add it , then enter the value 21 . and then you can use `MaterialDesign` or in this case `statusBarColor` in your theme .

2.   create a `Layout` resource for your `Drawer header` layout , like bellow :
```markdown
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="200dp" android:background="#266CD5" android:id="@+id/drawer_header">

    <ImageView
        android:id="@+id/drawer_user_image"
        android:layout_width="160dp"
        android:layout_height="160dp"
        android:layout_centerHorizontal="true"
        />

    <TextView
        android:id="@+id/drawer_user_name_and_family"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:layout_below="@+id/drawer_user_image"
        android:textStyle="bold|italic"
        />

    <TextView
        android:id="@+id/drawer_user_email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/drawer_user_name_and_family"
        android:gravity="center"
        android:textStyle="bold|italic"
        />

</RelativeLayout>
```

> 2.   now the options you need to do in your `Activity` layout `resource` file
1. first your `Activity` Layout `resource` container should be a `android.support.v4.widget.DrawerLayout` not `Relative layout` or anything else
1. you have to include `NavigationDrawer` in your layout .
1. the `layout` is like bellow
```mariadb
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:fitsSystemWindows="true"
    android:id="@+id/drawer_layout" <!-- we will use this id to initialize Drawer in our Activity class -->
    tools:context=".MainActivity">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent" android:orientation="vertical" android:id="@+id/LinearLayout">
        
        
        
        <android.support.v7.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:id="@+id/toolbar"
            android:background="@color/tab_signin"
            android:theme="@style/Theme.AppCompat.DayNight.DarkActionBar"
            app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
            android:elevation="4dp"
            />
            
            <!-- in case you have a tablayout , add these TabLayout & ViewPager Too, this are not necessary -->
            
            <android.support.design.widget.TabLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/tab_layout"
            android:background="@color/main_signin"
            app:tabSelectedTextColor="#FFF"
            app:tabTextColor="#0A1102"
            />

        <android.support.v4.view.ViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            />

        <FrameLayout  <!-- is not needed , works when you want to replace it with Fragments -->
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/frame_layout_container"
            />
            
          <!-- end of tablayout and viewPager and FrameLayou -->

    </LinearLayout>


    <android.support.design.widget.NavigationView
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start" <!-- Remember if you don't include it layout would fill the whole page -->
        android:id="@+id/navigation_view" <!-- we will use this id to initialize NavigationView in our Activity class -->
        app:headerLayout="@layout/drawer_layout"
        app:menu="@menu/main_menu" <!-- create the menu file for it in bellow chapter -->
        />

</android.support.v4.widget.DrawerLayout>
```

> as you see we need a `menu` for the `NavigationView` , **headerLayout** section .
> go to resource , right click -> add resource -> and choose menu and name your file , and in the file we have :
```markdown
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <group android:checkableBehavior="single">
        <item android:title="@string/editsetting" android:id="@+id/edit" android:icon="@drawable/edit" />
        <item android:title="@string/removeacount" android:id="@+id/remove" android:icon="@drawable/trash" />
        <item android:title="@string/contacts" android:id="@+id/contacts" android:icon="@drawable/contacts" />
        <item android:title="گالری" android:id="@+id/gallery" android:icon="@drawable/gallery" />
    </group>

    <item android:title="@string/program">
        <menu>
            <item android:title="@string/aboutus" android:id="@+id/about_us" android:icon="@drawable/info" />
        </menu>
    </item>

</menu>
```

> 3. after creating Layout files now its time to `initialize` our `Drawer` & `NavigationView` in our **Activity class**
```java
public class UserFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

   DrawerLayout drawerLayout;
   NavigationView navigationView;
   android.support.v7.widget.Toolbar toolbar;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_user_page);
      initializeToolbar();
      initializeNavigationView();
      initializeDrawer();
   }
  
   public void initializeToolbar() {
     toolbar = findViewByID(R.id.toolbar_in_drawer);
     setSupportActionBar(toolbar);
     setTitle("something");
     toolbar.setBackgroundColor(); // optional
     toolbar.setTitleTextColor(getResources().getColor(R.color.toolbar_title_color)); // optional
   }
   
   public void initializeNavigationDrawer() {
      navigationView = findViewById(R.id.navigation_view);
      navigationView.setItemIconTintList(null);
      navigationView.setNavigationItemSelectedListener(this); // you need to implement its interface in the class definition
   }
   
   public void initializeDrawer() {
        drawerLayout = findViewById(R.id.drawer_as_root_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
           case R.id.search:yourfunction();break;
           case R.id.aboutUs:yourfunctionTwo();break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
          drawerLayout.closeDrawer(GravityCompat.START);
       } else {
          super.onBackPressed();
       }
    }
  
}
```

  















