package refresh.arashUndo;

public class MainMethod {
    public static void main(String[] args) {
        var history = new History();
        var document = new Document();
        var boldCommand = new BoldCommand(document,history);
        document.setContent("some text would be going here");
        boldCommand.execute();
        System.out.println(document.getContent());
        var undo = new UndoCommand(history);
        undo.execute();
        System.out.println(document.getContent());
    }
}
