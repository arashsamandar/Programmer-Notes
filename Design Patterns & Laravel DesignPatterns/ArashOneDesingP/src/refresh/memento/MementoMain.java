package refresh.memento;


public class MementoMain {
    public static void main(String[] args) {
        // here goes the use of it
        Editor editor = new Editor();
        History history = new History();
        editor.setContent("a");
        history.push(editor.createState());
        editor.setContent("b");
        history.push(editor.createState());

        System.out.println(editor.getContent());
        editor.restoreState(history.pop());
        System.out.println(editor.getContent());
        editor.restoreState(history.pop());
        System.out.println(editor.getContent());
    }
}
