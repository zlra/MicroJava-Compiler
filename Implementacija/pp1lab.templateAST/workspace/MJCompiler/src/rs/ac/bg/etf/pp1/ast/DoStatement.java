// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class DoStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Do Do;
    private Statement Statement;
    private WhileCond WhileCond;

    public DoStatement (Do Do, Statement Statement, WhileCond WhileCond) {
        this.Do=Do;
        if(Do!=null) Do.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.WhileCond=WhileCond;
        if(WhileCond!=null) WhileCond.setParent(this);
    }

    public Do getDo() {
        return Do;
    }

    public void setDo(Do Do) {
        this.Do=Do;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public WhileCond getWhileCond() {
        return WhileCond;
    }

    public void setWhileCond(WhileCond WhileCond) {
        this.WhileCond=WhileCond;
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
        if(Do!=null) Do.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(WhileCond!=null) WhileCond.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Do!=null) Do.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(WhileCond!=null) WhileCond.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Do!=null) Do.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(WhileCond!=null) WhileCond.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoStatement(\n");

        if(Do!=null)
            buffer.append(Do.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhileCond!=null)
            buffer.append(WhileCond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoStatement]");
        return buffer.toString();
    }
}
