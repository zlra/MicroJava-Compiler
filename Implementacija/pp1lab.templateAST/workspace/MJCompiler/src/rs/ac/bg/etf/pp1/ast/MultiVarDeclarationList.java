// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:54


package rs.ac.bg.etf.pp1.ast;

public class MultiVarDeclarationList extends VarDeclarationList {

    private VarDeclarationList VarDeclarationList;
    private VarDeclarationElement VarDeclarationElement;

    public MultiVarDeclarationList (VarDeclarationList VarDeclarationList, VarDeclarationElement VarDeclarationElement) {
        this.VarDeclarationList=VarDeclarationList;
        if(VarDeclarationList!=null) VarDeclarationList.setParent(this);
        this.VarDeclarationElement=VarDeclarationElement;
        if(VarDeclarationElement!=null) VarDeclarationElement.setParent(this);
    }

    public VarDeclarationList getVarDeclarationList() {
        return VarDeclarationList;
    }

    public void setVarDeclarationList(VarDeclarationList VarDeclarationList) {
        this.VarDeclarationList=VarDeclarationList;
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
        if(VarDeclarationList!=null) VarDeclarationList.accept(visitor);
        if(VarDeclarationElement!=null) VarDeclarationElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseTopDown(visitor);
        if(VarDeclarationElement!=null) VarDeclarationElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationList!=null) VarDeclarationList.traverseBottomUp(visitor);
        if(VarDeclarationElement!=null) VarDeclarationElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiVarDeclarationList(\n");

        if(VarDeclarationList!=null)
            buffer.append(VarDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationElement!=null)
            buffer.append(VarDeclarationElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiVarDeclarationList]");
        return buffer.toString();
    }
}
