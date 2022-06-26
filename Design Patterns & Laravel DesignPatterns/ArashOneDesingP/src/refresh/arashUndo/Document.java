package refresh.arashUndo;

public class Document {
    private String content;

    public void makeBold() {
        content = "<br>" + content + "</br>";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
