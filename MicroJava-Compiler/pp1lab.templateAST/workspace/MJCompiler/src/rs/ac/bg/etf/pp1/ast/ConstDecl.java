// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String I2;
    private ConstChoice ConstChoice;
    private ConstChoiceList ConstChoiceList;

    public ConstDecl (Type Type, String I2, ConstChoice ConstChoice, ConstChoiceList ConstChoiceList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.ConstChoice=ConstChoice;
        if(ConstChoice!=null) ConstChoice.setParent(this);
        this.ConstChoiceList=ConstChoiceList;
        if(ConstChoiceList!=null) ConstChoiceList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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

    public ConstChoiceList getConstChoiceList() {
        return ConstChoiceList;
    }

    public void setConstChoiceList(ConstChoiceList ConstChoiceList) {
        this.ConstChoiceList=ConstChoiceList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstChoice!=null) ConstChoice.accept(visitor);
        if(ConstChoiceList!=null) ConstChoiceList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstChoice!=null) ConstChoice.traverseTopDown(visitor);
        if(ConstChoiceList!=null) ConstChoiceList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstChoice!=null) ConstChoice.traverseBottomUp(visitor);
        if(ConstChoiceList!=null) ConstChoiceList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
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

        if(ConstChoiceList!=null)
            buffer.append(ConstChoiceList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
