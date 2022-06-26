# Fragments
> there are two ways to create Fragments

- Declare the fragment inside the activity's layout file
- Programmatically add the fragment to a ViewGroup
- programatically create the fragments , pass arguments to it , and lunch it


> Declare the fragment inside the activity's layout file
```makefile
// you sould need to also add android:layout="@layout/yourFragmentLayout" 
<fragment
    android:name="your.package.ButtonsFragment"
    android:layout_width="match_parent"
    android:layout_height="80dp"
    android:layout_margin="10dp"
    android:id="@+id/fg1"
    />
```


> or Programmatically add the fragment to a ViewGroup
```makefile
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="80dp"
    android:layout_margin="10dp"
    android:id="@+id/fg1" />
```
> and in you `Activity` class wich you have include the `FrameLayout` in its `xml` file you will write :
```java
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
ft.replace(R.id.fg1, new ButtonsFragment());
ft.commit();
```
> and in the Fragment `Java` class you would have
```java
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment, null);
        return view;
    }
```

---

## Communicate with Activity

> To communicate with activity we need to define an interface in the Fragment.
> Then in the activity we implement that interface .
> The example of implementation has came bellow :
```java
public class MyFragment extends Fragment {
   
   CallBacks callback;
   
   public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.remove_tab) {
            detailCallBacks.changeTabItem(true); // here you call it
        }
        return super.onOptionsItemSelected(item);
    }
   
   public interface CallBacks {
      public void deleteFragment(String something);
   }
   
   @override
   public void onAttache(Context context) {
      super.onAttach(context);
      callback = (CallBacks)context;
   }
   
}
```

> as you see we have called the function of this interface in `onOptionsItemSelected` the only thing that remains is to `implement` this interface in the `activity` .


---

## programatically create numerous Fragments and lunch them

> first you need to define two `ArrayList` one of type `Fragment` and one of type `String` , meaning one for **page itself** and one for **page title**
```java
List<Fragment> userPageFragments = new ArrayList<>();
List<String> userPageFragmentsTitle = new ArrayList<>();
```

> you will also need a `FragmentPagerAdapter` in your class , like bellow :
```java
public class PageAdapter extends FragmentPagerAdapter {

        private PageAdapter(FragmentManager manager) {
            super(manager);
        }

        public void AddFragment(Fragment fragment, String title) {
            userPageFragments.add(fragment);
            userPageFragmentsTitle.add(title);
            PagerAdapter adapter = new PageAdapter(getSupportFragmentManager());
            adapter.notifyDataSetChanged();
            viewPager.setAdapter(adapter);
        }


        public CharSequence getPageTitle(int position) {
            return userPageFragmentsTitle.get(position);
        }

        public Fragment getItem(int position) {
            return userPageFragments.get(position);
        }


        public int getCount() {
            return userPageFragments.size();
        }

    }
```

> then you can add **fragments** to it , like bellow , **Attention : what i have created bellow is for a TabLayout with dynamic tabs**
```java
public void initializeTabLayout() {
        tabLayout = findViewById(R.id.user_tabLayout);
        viewPager = findViewById(R.id.user_viewPager);
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new HomePage(), "خانه");
        adapter.AddFragment(new Contacts(),"مخاطبان");
        adapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.contacts);
    }
```

> if you want to pass arguments to a **Fragment** and launch this fragments from your **Activity** with its arguments attached
```java
HomePage homePage = new HomePage();
Bundle bundle = new Bundle();
bundle.getParcelable("userPassed");
homePage.setArguments(bundle);
// then you should fire the fragment
getSupportFragmentManager().beginTransaction().add(new SignIn(),"sign_in").commit();
```

> and get this arguments in the fragment with
```java
Bundle bundle = getArguments();
```