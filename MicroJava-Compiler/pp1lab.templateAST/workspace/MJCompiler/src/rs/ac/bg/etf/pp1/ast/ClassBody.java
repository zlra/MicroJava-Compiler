// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class ClassBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassVarDeclarations ClassVarDeclarations;
    private OptionalMethodDeclarations OptionalMethodDeclarations;

    public ClassBody (ClassVarDeclarations ClassVarDeclarations, OptionalMethodDeclarations OptionalMethodDeclarations) {
        this.ClassVarDeclarations=ClassVarDeclarations;
        if(ClassVarDeclarations!=null) ClassVarDeclarations.setParent(this);
        this.OptionalMethodDeclarations=OptionalMethodDeclarations;
        if(OptionalMethodDeclarations!=null) OptionalMethodDeclarations.setParent(this);
    }

    public ClassVarDeclarations getClassVarDeclarations() {
        return ClassVarDeclarations;
    }

    public void setClassVarDeclarations(ClassVarDeclarations ClassVarDeclarations) {
        this.ClassVarDeclarations=ClassVarDeclarations;
    }

    public OptionalMethodDeclarations getOptionalMethodDeclarations() {
        return OptionalMethodDeclarations;
    }

    public void setOptionalMethodDeclarations(OptionalMethodDeclarations OptionalMethodDeclarations) {
        this.OptionalMethodDeclarations=OptionalMethodDeclarations;
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
        if(ClassVarDeclarations!=null) ClassVarDeclarations.accept(visitor);
        if(OptionalMethodDeclarations!=null) OptionalMethodDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassVarDeclarations!=null) ClassVarDeclarations.traverseTopDown(visitor);
        if(OptionalMethodDeclarations!=null) OptionalMethodDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassVarDeclarations!=null) ClassVarDeclarations.traverseBottomUp(visitor);
        if(OptionalMethodDeclarations!=null) OptionalMethodDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBody(\n");

        if(ClassVarDeclarations!=null)
            buffer.append(ClassVarDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMethodDeclarations!=null)
            buffer.append(OptionalMethodDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBody]");
        return buffer.toString();
    }
}
