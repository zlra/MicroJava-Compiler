// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class ConstChoiceListNotEmpty extends ConstChoiceList {

    private ConstChoiceList ConstChoiceList;
    private String I2;
    private ConstChoice ConstChoice;

    public ConstChoiceListNotEmpty (ConstChoiceList ConstChoiceList, String I2, ConstChoice ConstChoice) {
        this.ConstChoiceList=ConstChoiceList;
        if(ConstChoiceList!=null) ConstChoiceList.setParent(this);
        this.I2=I2;
        this.ConstChoice=ConstChoice;
        if(ConstChoice!=null) ConstChoice.setParent(this);
    }

    public ConstChoiceList getConstChoiceList() {
        return ConstChoiceList;
    }

    public void setConstChoiceList(ConstChoiceList ConstChoiceList) {
        this.ConstChoiceList=ConstChoiceList;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public ConstChoice getConstChoice() {
        return ConstChoice;
    }

    public void setConstChoice(ConstChoice ConstChoice) {
        this.ConstChoice=ConstChoice;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstChoiceList!=null) ConstChoiceList.accept(visitor);
        if(ConstChoice!=null) ConstChoice.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstChoiceList!=null) ConstChoiceList.traverseTopDown(visitor);
        if(ConstChoice!=null) ConstChoice.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstChoiceList!=null) ConstChoiceList.traverseBottomUp(visitor);
        if(ConstChoice!=null) ConstChoice.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstChoiceListNotEmpty(\n");

        if(ConstChoiceList!=null)
            buffer.append(ConstChoiceList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(ConstChoice!=null)
            buffer.append(ConstChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstChoiceListNotEmpty]");
        return buffer.toString();
    }
}
