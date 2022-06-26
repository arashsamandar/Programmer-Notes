# Java Swing

## What is Swing In java ?

>**Swing** is a GUI widget toolkit for **Java**. It is part of Oracle's *Java* Foundation Classes (JFC) – an API for providing a graphical user interface (GUI) for **Java** programs. ... Unlike AWT components, **Swing** components are not implemented by platform-specific code.

## Write GUI In Eclipse

> Help -> Install New Software -> "http://download.eclipse.org/realses/luna" ( place your version in place of luna ) -> Click The "General Purpose Tool" -> "Swing Designer" ( all SWT Designers ) & Window Builder -> Then Install it .

> After Restarting The `Eclipse` , Go to File -> new Project -> Other... -> WindowBuilder -> SWT -> ApplicationWindow 

--------------------

## Write GUI In IntelliJ IDEA

> Write Click on Your `src`folder , -> New -> GUI Form

> After that name your frame (id) in its Field name , we are going to use it , you can put a button and create a Listener for it too , or anything you want

> after that in the sources we have to create a `main`method for the project to run

**In The main method we have**

```java
public class ChatFrom {
    private JPanel myFrom;
    public static void main(String[] args) {
        JFrame frame = new JFrame("ChatFrom");
        frame.setContentPane(new ChatFrom().myFrom);
        frame.setPreferredSize(new Dimension(600,300)); // i have added it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
```

> and we are good to go

------------

