// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:54


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private OptionalVarDeclList OptionalVarDeclList;
    private OptionalMethodDeclList OptionalMethodDeclList;

    public ClassDeclBody (OptionalVarDeclList OptionalVarDeclList, OptionalMethodDeclList OptionalMethodDeclList) {
        this.OptionalVarDeclList=OptionalVarDeclList;
        if(OptionalVarDeclList!=null) OptionalVarDeclList.setParent(this);
        this.OptionalMethodDeclList=OptionalMethodDeclList;
        if(OptionalMethodDeclList!=null) OptionalMethodDeclList.setParent(this);
    }

    public OptionalVarDeclList getOptionalVarDeclList() {
        return OptionalVarDeclList;
    }

    public void setOptionalVarDeclList(OptionalVarDeclList OptionalVarDeclList) {
        this.OptionalVarDeclList=OptionalVarDeclList;
    }

    public OptionalMethodDeclList getOptionalMethodDeclList() {
        return OptionalMethodDeclList;
    }

    public void setOptionalMethodDeclList(OptionalMethodDeclList OptionalMethodDeclList) {
        this.OptionalMethodDeclList=OptionalMethodDeclList;
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
        if(OptionalVarDeclList!=null) OptionalVarDeclList.accept(visitor);
        if(OptionalMethodDeclList!=null) OptionalMethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalVarDeclList!=null) OptionalVarDeclList.traverseTopDown(visitor);
        if(OptionalMethodDeclList!=null) OptionalMethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalVarDeclList!=null) OptionalVarDeclList.traverseBottomUp(visitor);
        if(OptionalMethodDeclList!=null) OptionalMethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclBody(\n");

        if(OptionalVarDeclList!=null)
            buffer.append(OptionalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMethodDeclList!=null)
            buffer.append(OptionalMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclBody]");
        return buffer.toString();
    }
}