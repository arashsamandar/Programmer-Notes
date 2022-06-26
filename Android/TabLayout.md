# TabLayout
> to create a `TabLayout` we have do Follow several steps

- you have to implement `implementation 'com.android.support:design:28.0.0'` first
1. then write `TabLayout` in the `xml` file of your activity wich you wish to use tablayout in it
1. if you want to have static `TabItems` , also write one , two , or several `tabItems` in that `xml` file of yours too
1. then you must create `FragmentPagerAdapter` . there are examples like `testing` project and others , or can learn from youtube
1. then if you want to create `dynamic tabitems` , you will need to create a `List<Fragment>` for `Fragments` and `List<String>` for `TabItem` titles .
1. the `java` code is like bellow :
> notice this one is dynamic , so we don't have any `TabItem` defined in our `XML` file .
```markup
<LinearLayout
        android:id="@+id/linearContainer"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <android.support.v7.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:id="@+id/myToolbar"
            tools:targetApi="lollipop"
            android:elevation="5dp"
             />


        <android.support.design.widget.TabLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/myTabLayout" />

        <android.support.v4.view.ViewPager
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/myViewPager"
            />

    </LinearLayout>
```
> and the java code is like :
```java
public class MainActivity extends AppCompatActivity {
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tabLayout = findViewById(R.id.myTabLayout);
        this.viewPager = findViewById(R.id.myViewPager);
        MyViewPagerAdapter Adapter = new MyViewPagerAdapter((getSupportFragmentManager()));
        Adapter.AddFragmentPage(new LoginFragment(),"Login");
        Adapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
```

> and this is the `FragmentPagerAdapter` that you need to define for your `TabLayout`
```java
public class MyViewPagerAdapter extends FragmentPagerAdapter {

        private MyViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        private void AddFragmentPage(Fragment frag,String title) {
            fragments.add(frag);
            fragmentsTitle.add(title);
            MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
            myViewPagerAdapter.notifyDataSetChanged();
            viewPager.setAdapter(myViewPagerAdapter);
        }

        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        public CharSequence getPageTitle(int position) {
            return fragmentsTitle.get(position);
        }

        public int getCount() {
            return fragments.size();
        }
    }
```

> and thats it , so : we create `TabLayout` and `ViewPager` in our `xml` file .
> we initialize the in `MainActivivty` or any activity wich they are in .

> **NOTE :** Look how we change the color of three elements
```java
toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.tab_signin));
tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.main_signin));
if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status_signin));
}
```


> we can use it in `addOnTabSelectedListener`in `onTabSelected` , so we can have different color for **StatusBar** , **ToolBar** , and **Tabs** rows .
```java
tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() > 2) {
                    tabposition_number = tab.getPosition();
                }

                if(tab.getPosition() == 0) {
                    toolbar.setTitle("ورود");
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.tab_signin));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.main_signin));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status_signin));
                    }
                }

                if(tab.getPosition() == 1) {
                    toolbar.setTitle("ارتباطات");
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.tab_contacts));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.main_contacts));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status_contacts));
                    }
                } else if(tab.getPosition() == 2) {
                    toolbar.setTitle("ثبت");
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.tab_register));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.main_register));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status_register));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.tab_signin));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.main_signin));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status_signin));
                    }
                }
            }
```

> To have different Menu for Different Tabs you need to add `setHasOptionsMenu(true);` in the `onCreate()` function of the Fragment . the rest you know ...
```java
public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setHasOptionsMenu(true);
}
```

---

### How to Delete A TabItem Dynamically
> For this purpose we need to communicate between the Tab ( tab fragment ) , and the activity that this tab exists on . we already know how to connect fragment to activity in the `Fragment` section . now the implementation of that `deleteFragment` is as bellow :

### `Attention` : **Some values and variables does not need to be , this 
                    demonstration belongs to a dynamic complex application**

In the Tab ( Fragment ) we want to delete we have :
```java
public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.remove_tab) {
            detailCallBacks.changeTabItem(true);
        }
        return super.onOptionsItemSelected(item);
    }
```

And Implementation Of it in the MainActivity is
```java
public void changeTabItem(boolean mustdelete) {
        ContactsFragment contactsFragment = new ContactsFragment();
        if(tabposition_number > 2 && mustdelete) {
            contactsFragment.setTextView(tabposition_number,mustdelete);
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            tab.select();
        }
    }
```

In MainActivity We Can Get The TabItem Number By :
```java
tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() > 2) {
                    tabposition_number = tab.getPosition();
                }
```

Now in the other Fragment `onResume` function we have :
```java
public void onResume() {
        super.onResume();
        if(came_fromTabItem > 2 && do_delete) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      callBacks.delete_previous_tab(came_fromTabItem);
                      do_delete = false;
                  }
    }, 1);

        }
    }
    
```

AGAIN WE HAVE A CALL TO `MainActivity` in above `callBacks.delete_previous_tab(came_fromTabItem)`
```java
// again in the main activity we implement this method from above callBacks interface
public void delete_previous_tab(int tabposition_number) {
        remove_tab_details(tabposition_number);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        myViewPagerAdapter.notifyDataSetChanged();
    }
    
    public void remove_tab_details(int tab_to_delete) {
        tabLayout.removeTabAt(tab_to_delete);
        MyViewPagerAdapter Adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        Adapter.removeTabPage(tab_to_delete);
        Adapter.notifyDataSetChanged();
        tabs_number--;
    }
```








