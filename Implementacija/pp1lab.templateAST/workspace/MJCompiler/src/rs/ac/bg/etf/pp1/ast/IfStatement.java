// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class IfStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private IfThenPart IfThenPart;
    private OptionalElse OptionalElse;

    public IfStatement (IfThenPart IfThenPart, OptionalElse OptionalElse) {
        this.IfThenPart=IfThenPart;
        if(IfThenPart!=null) IfThenPart.setParent(this);
        this.OptionalElse=OptionalElse;
        if(OptionalElse!=null) OptionalElse.setParent(this);
    }

    public IfThenPart getIfThenPart() {
        return IfThenPart;
    }

    public void setIfThenPart(IfThenPart IfThenPart) {
        this.IfThenPart=IfThenPart;
    }

    public OptionalElse getOptionalElse() {
        return OptionalElse;
    }

    public void setOptionalElse(OptionalElse OptionalElse) {
        this.OptionalElse=OptionalElse;
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
        if(IfThenPart!=null) IfThenPart.accept(visitor);
        if(OptionalElse!=null) OptionalElse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfThenPart!=null) IfThenPart.traverseTopDown(visitor);
        if(OptionalElse!=null) OptionalElse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfThenPart!=null) IfThenPart.traverseBottomUp(visitor);
        if(OptionalElse!=null) OptionalElse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStatement(\n");

        if(IfThenPart!=null)
            buffer.append(IfThenPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalElse!=null)
            buffer.append(OptionalElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStatement]");
        return buffer.toString();
    }
}
