// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class ClassVarDeclarationsNotEmpty extends ClassVarDeclarations {

    private ClassVarDeclarations ClassVarDeclarations;
    private VarDecl VarDecl;

    public ClassVarDeclarationsNotEmpty (ClassVarDeclarations ClassVarDeclarations, VarDecl VarDecl) {
        this.ClassVarDeclarations=ClassVarDeclarations;
        if(ClassVarDeclarations!=null) ClassVarDeclarations.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public ClassVarDeclarations getClassVarDeclarations() {
        return ClassVarDeclarations;
    }

    public void setClassVarDeclarations(ClassVarDeclarations ClassVarDeclarations) {
        this.ClassVarDeclarations=ClassVarDeclarations;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassVarDeclarations!=null) ClassVarDeclarations.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassVarDeclarations!=null) ClassVarDeclarations.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassVarDeclarations!=null) ClassVarDeclarations.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassVarDeclarationsNotEmpty(\n");

        if(ClassVarDeclarations!=null)
            buffer.append(ClassVarDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassVarDeclarationsNotEmpty]");
        return buffer.toString();
    }
}
