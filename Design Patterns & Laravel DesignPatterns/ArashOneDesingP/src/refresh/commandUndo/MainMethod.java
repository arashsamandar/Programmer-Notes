package refresh.commandUndo;

public class MainMethod {
    public static void main(String[] args) {
        // now here goes our operation
        // first lets build our document
        var document = new Document();
        var history = new History();
        var boldCommand = new MakeBoldCommand(document,history);
        document.setContent("Arash Samandar");
        boldCommand.execute();
        System.out.println(document.getContent());
        var undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println(document.getContent());
    }
}
