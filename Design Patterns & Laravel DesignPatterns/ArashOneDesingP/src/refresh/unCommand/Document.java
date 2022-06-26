package refresh.unCommand;

public class Document {
    public String getContent() {
        return content;
    }

    public void makeBold() {
        content = ("<b>" + content + "</b>");
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;
}
