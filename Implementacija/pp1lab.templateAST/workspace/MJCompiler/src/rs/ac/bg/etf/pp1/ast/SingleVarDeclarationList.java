// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:54


package rs.ac.bg.etf.pp1.ast;

public class SingleVarDeclarationList extends VarDeclarationList {

    private VarDeclarationElement VarDeclarationElement;

    public SingleVarDeclarationList (VarDeclarationElement VarDeclarationElement) {
        this.VarDeclarationElement=VarDeclarationElement;
        if(VarDeclarationElement!=null) VarDeclarationElement.setParent(this);
    }

    public VarDeclarationElement getVarDeclarationElement() {
        return VarDeclarationElement;
    }

    public void setVarDeclarationElement(VarDeclarationElement VarDeclarationElement) {
        this.VarDeclarationElement=VarDeclarationElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclarationElement!=null) VarDeclarationElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationElement!=null) VarDeclarationElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationElement!=null) VarDeclarationElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleVarDeclarationList(\n");

        if(VarDeclarationElement!=null)
            buffer.append(VarDeclarationElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleVarDeclarationList]");
        return buffer.toString();
    }
}
