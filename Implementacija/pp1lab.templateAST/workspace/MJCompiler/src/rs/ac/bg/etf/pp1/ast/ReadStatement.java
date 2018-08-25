// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class ReadStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ReadSt ReadSt;
    private Designator Designator;

    public ReadStatement (ReadSt ReadSt, Designator Designator) {
        this.ReadSt=ReadSt;
        if(ReadSt!=null) ReadSt.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public ReadSt getReadSt() {
        return ReadSt;
    }

    public void setReadSt(ReadSt ReadSt) {
        this.ReadSt=ReadSt;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
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
        if(ReadSt!=null) ReadSt.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReadSt!=null) ReadSt.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReadSt!=null) ReadSt.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReadStatement(\n");

        if(ReadSt!=null)
            buffer.append(ReadSt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReadStatement]");
        return buffer.toString();
    }
}
