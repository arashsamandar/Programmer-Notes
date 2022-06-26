## What is `Java.awt`

>**Java AWT** (Abstract Window Toolkit) is *an API to develop GUI or window-based applications* in java.
>
>Java AWT components are platform-dependent i.e. components are displayed according to the view of operating system. AWT is heavyweight i.e. its components are using the resources of OS.
>
>The java.awt [package](https://www.javatpoint.com/package) provides [classes](https://www.javatpoint.com/object-and-class-in-java) for AWT api such as [TextField](https://www.javatpoint.com/java-awt-textfield), [Label](https://www.javatpoint.com/java-awt-label), [TextArea](https://www.javatpoint.com/java-awt-textarea), RadioButton, [CheckBox](https://www.javatpoint.com/java-awt-checkbox), [Choice](https://www.javatpoint.com/java-awt-choice), [List](https://www.javatpoint.com/java-awt-list) etc.

![image-20210205234240788](D:\Programming Notes\Java_Game\Elements.assets\image-20210205234240788.png)

## what is javax.swing in java

>**Java Swing tutorial** is a part of Java Foundation Classes (JFC) that is *used to create window-based applications*. It is built on the top of AWT (Abstract Windowing Toolkit) API and entirely written in java.
>
>Unlike AWT, Java Swing provides platform-independent and lightweight components.
>
>The javax.swing package provides classes for java swing API such as JButton, JTextField, JTextArea, JRadioButton, JCheckbox, JMenu, JColorChooser etc.

## Difference Between AWT & Swing

![image-20210205234538084](D:\Programming Notes\Java_Game\Elements.assets\image-20210205234538084.png)

## Hierarchy of Java Swing Classes

![image-20210205234624249](D:\Programming Notes\Java_Game\Elements.assets\image-20210205234624249.png)

## Creating a Simple Window with Canvas

```java
package com.arash;

import javax.swing.*;
import java.awt.*;

public class CanvasExample extends JFrame {

    public CanvasExample() {
        JFrame frame = new JFrame("Canvas Example");
        frame.add(new ArashCanvas());
        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CanvasExample();
    }

}

class ArashCanvas extends Canvas {
    public ArashCanvas() {
        setBackground(Color.WHITE);
        setSize(400,400);
    }

    public void paint(Graphics g) {

    }
}
```

##  `Synchronized` Keyword

The `synchronized` keyword is all about different threads reading and writing to the same variables, objects and resources. it prevents multiple threads to access a same block of code at the same time

## GameLoop

> to create a game we actually need a gameLoop , so the game would be updating itself in a loop .
>
> every game needs this

## What Does `Thread.join()` do ?

>lang. **Thread** class provides the **join**() method which allows one **thread** to wait until another **thread** completes its execution. If t is a **Thread** object whose **thread** is currently executing, then t. **join**() will make sure that t is terminated before the next instruction is executed by the program

-------------------------

# The Book

>Because the Swing library is not thread-safe, *you should always create and show a
>JFrame on the Swing event thread*. However, the program’s `main() method is not
>invoked on the event thread`, so it is necessary to use the `SwingUtilities` class to launch
>the game window. By using the `SwingUtilities` class, the GUI components are created
>on the same thread. __It is important to follow Java’s guidelines for threading when
>using Swing components for rendering, because ignoring them can lead to undefined
>behavior, which is very difficult to debug__.
>Tip
>I know a programmer who once tested whether you really need the SwingUtilities class to launch the
>game window by commenting out the SwingUtilities code for an application deployed throughout a
>site. Every few days, someone would report that the application crashed on startup. Not that I would ever
>do something like that, but it did seem to make a difference. :-)
>
>```java
>final HelloWorldApp app = new HelloWorldApp();
>SwingUtilities.invokeLater( new Runnable() {
>	public void run() {
>		app.createAndShowGUI();
>	}
>});
>```

# Input

>all the keyboard events arrive on a different thread and need to be made available
>to the game loop.

#### Most games follow some kind of structured loop:

```java
while(true) {
    processInput();
    updateObjects();
    // other stuff...
    renderScene();
}
```

>To simplify input processing, the keyboard events are saved and made available to the game loop.

>Every key on the keyboard `is mapped to a key code` located in the `KeyEvent class`. Here are some example values:

```java
KeyEvent.VK_E—The __E key__
KeyEvent.VK_SPACE—The __spacebar__
KeyEvent.VK_UP—The __up arrow key__
```
