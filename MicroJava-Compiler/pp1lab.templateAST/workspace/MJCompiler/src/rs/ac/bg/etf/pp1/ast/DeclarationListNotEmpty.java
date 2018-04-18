// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class DeclarationListNotEmpty extends DeclarationList {

    private DeclarationList DeclarationList;
    private DeclarationListElement DeclarationListElement;

    public DeclarationListNotEmpty (DeclarationList DeclarationList, DeclarationListElement DeclarationListElement) {
        this.DeclarationList=DeclarationList;
        if(DeclarationList!=null) DeclarationList.setParent(this);
        this.DeclarationListElement=DeclarationListElement;
        if(DeclarationListElement!=null) DeclarationListElement.setParent(this);
    }

    public DeclarationList getDeclarationList() {
        return DeclarationList;
    }

    public void setDeclarationList(DeclarationList DeclarationList) {
        this.DeclarationList=DeclarationList;
    }

    public DeclarationListElement getDeclarationListElement() {
        return DeclarationListElement;
    }

    public void setDeclarationListElement(DeclarationListElement DeclarationListElement) {
        this.DeclarationListElement=DeclarationListElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclarationList!=null) DeclarationList.accept(visitor);
        if(DeclarationListElement!=null) DeclarationListElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclarationList!=null) DeclarationList.traverseTopDown(visitor);
        if(DeclarationListElement!=null) DeclarationListElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclarationList!=null) DeclarationList.traverseBottomUp(visitor);
        if(DeclarationListElement!=null) DeclarationListElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationListNotEmpty(\n");

        if(DeclarationList!=null)
            buffer.append(DeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclarationListElement!=null)
            buffer.append(DeclarationListElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationListNotEmpty]");
        return buffer.toString();
    }
}
