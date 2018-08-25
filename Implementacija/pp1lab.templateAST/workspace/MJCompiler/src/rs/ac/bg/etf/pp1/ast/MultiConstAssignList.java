// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:54


package rs.ac.bg.etf.pp1.ast;

public class MultiConstAssignList extends ConstAssignList {

    private ConstAssignList ConstAssignList;
    private String constantName;
    private ConstElement ConstElement;

    public MultiConstAssignList (ConstAssignList ConstAssignList, String constantName, ConstElement ConstElement) {
        this.ConstAssignList=ConstAssignList;
        if(ConstAssignList!=null) ConstAssignList.setParent(this);
        this.constantName=constantName;
        this.ConstElement=ConstElement;
        if(ConstElement!=null) ConstElement.setParent(this);
    }

    public ConstAssignList getConstAssignList() {
        return ConstAssignList;
    }

    public void setConstAssignList(ConstAssignList ConstAssignList) {
        this.ConstAssignList=ConstAssignList;
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName=constantName;
    }

    public ConstElement getConstElement() {
        return ConstElement;
    }

    public void setConstElement(ConstElement ConstElement) {
        this.ConstElement=ConstElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstAssignList!=null) ConstAssignList.accept(visitor);
        if(ConstElement!=null) ConstElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstAssignList!=null) ConstAssignList.traverseTopDown(visitor);
        if(ConstElement!=null) ConstElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstAssignList!=null) ConstAssignList.traverseBottomUp(visitor);
        if(ConstElement!=null) ConstElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiConstAssignList(\n");

        if(ConstAssignList!=null)
            buffer.append(ConstAssignList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+constantName);
        buffer.append("\n");

        if(ConstElement!=null)
            buffer.append(ConstElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiConstAssignList]");
        return buffer.toString();
    }
}
