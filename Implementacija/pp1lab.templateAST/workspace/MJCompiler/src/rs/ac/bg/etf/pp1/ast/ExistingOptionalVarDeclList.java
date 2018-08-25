// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:54


package rs.ac.bg.etf.pp1.ast;

public class ExistingOptionalVarDeclList extends OptionalVarDeclList {

    private OptionalVarDeclList OptionalVarDeclList;
    private VarDeclaration VarDeclaration;

    public ExistingOptionalVarDeclList (OptionalVarDeclList OptionalVarDeclList, VarDeclaration VarDeclaration) {
        this.OptionalVarDeclList=OptionalVarDeclList;
        if(OptionalVarDeclList!=null) OptionalVarDeclList.setParent(this);
        this.VarDeclaration=VarDeclaration;
        if(VarDeclaration!=null) VarDeclaration.setParent(this);
    }

    public OptionalVarDeclList getOptionalVarDeclList() {
        return OptionalVarDeclList;
    }

    public void setOptionalVarDeclList(OptionalVarDeclList OptionalVarDeclList) {
        this.OptionalVarDeclList=OptionalVarDeclList;
    }

    public VarDeclaration getVarDeclaration() {
        return VarDeclaration;
    }

    public void setVarDeclaration(VarDeclaration VarDeclaration) {
        this.VarDeclaration=VarDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalVarDeclList!=null) OptionalVarDeclList.accept(visitor);
        if(VarDeclaration!=null) VarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalVarDeclList!=null) OptionalVarDeclList.traverseTopDown(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalVarDeclList!=null) OptionalVarDeclList.traverseBottomUp(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExistingOptionalVarDeclList(\n");

        if(OptionalVarDeclList!=null)
            buffer.append(OptionalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclaration!=null)
            buffer.append(VarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExistingOptionalVarDeclList]");
        return buffer.toString();
    }
}
