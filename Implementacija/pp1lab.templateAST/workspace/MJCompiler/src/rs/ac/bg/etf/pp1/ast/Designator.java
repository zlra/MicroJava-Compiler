// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesignatorAllList DesignatorAllList;

    public Designator (DesignatorAllList DesignatorAllList) {
        this.DesignatorAllList=DesignatorAllList;
        if(DesignatorAllList!=null) DesignatorAllList.setParent(this);
    }

    public DesignatorAllList getDesignatorAllList() {
        return DesignatorAllList;
    }

    public void setDesignatorAllList(DesignatorAllList DesignatorAllList) {
        this.DesignatorAllList=DesignatorAllList;
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
        if(DesignatorAllList!=null) DesignatorAllList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorAllList!=null) DesignatorAllList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorAllList!=null) DesignatorAllList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(DesignatorAllList!=null)
            buffer.append(DesignatorAllList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}