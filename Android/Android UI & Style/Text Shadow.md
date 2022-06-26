# Text Shadow

---

> first define colors in your `colors.xml`
```markup
<resources>
    <color name="light_font">#FBFBFB</color>
    <color name="grey_font">#ff9e9e9e</color>
    <color name="text_shadow">#7F000000</color>
    <color name="text_shadow_white">#FFFFFF</color>
</resources>
```

> then in the `TextView` definition , for Example of Floating text on Light with Dark shadow
```makefile
<TextView android:id="@+id/txt_example1"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:textSize="14sp"
          android:textStyle="bold"
          android:textColor="@color/light_font"
          android:shadowColor="@color/text_shadow"
          android:shadowDx="1"
          android:shadowDy="1"
          android:shadowRadius="2" />
```

![Image](D:\Programming Notes/medley/resources/rJW9A0j2N_Bkk8ek334.png)



> Example of Etched text on Light with Dark shadow
```makefile
<TextView android:id="@+id/txt_example2"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:textSize="14sp"
          android:textStyle="bold"
          android:textColor="@color/light_font"
          android:shadowColor="@color/text_shadow"
          android:shadowDx="-1"
          android:shadowDy="-1"
          android:shadowRadius="1" />
```

![Image](D:\Programming Notes/medley/resources/rJW9A0j2N_BJgiKgJ33N.png)



> Example of Crisp text on Light with Dark shadow
```makefile
<TextView android:id="@+id/txt_example3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="14sp"
                android:textStyle="bold"
                android:textColor="@color/grey_font"
                android:shadowColor="@color/text_shadow_white"
                android:shadowDx="-2"
                android:shadowDy="-2"
                android:shadowRadius="1" />
```

![Image](D:\Programming Notes/medley/resources/rJW9A0j2N_ByF0xJ2n4.png)




