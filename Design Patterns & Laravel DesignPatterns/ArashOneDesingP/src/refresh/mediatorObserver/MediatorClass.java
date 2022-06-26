package refresh.mediatorObserver;

public class MediatorClass {
    private ElementOne elementOne = new ElementOne();
    private ElementTwo elementTwo = new ElementTwo();

    public MediatorClass() {
        elementOne.addEventHandler(this::caseElementOneChanged);
        elementTwo.addEventHandler(this::caseElementTwoChanged);
    }
    public void caseElementTwoChanged() {
        var content = elementTwo.getContent();
        elementOne.setContent(content);
    }
    public void caseElementOneChanged() {
        var content = elementOne.getContent();
        elementTwo.setContent(content);
    }
    public void simulateMediatorCaseEmOneChanged() {
        elementOne.setContent("this is it");
        System.out.println(elementTwo.getContent());
    }
}
