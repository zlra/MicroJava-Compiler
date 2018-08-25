// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class MultiCondTermList extends CondTermOrList {

    private CondTerm CondTerm;
    private Or Or;
    private CondTermOrList CondTermOrList;

    public MultiCondTermList (CondTerm CondTerm, Or Or, CondTermOrList CondTermOrList) {
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
        this.Or=Or;
        if(Or!=null) Or.setParent(this);
        this.CondTermOrList=CondTermOrList;
        if(CondTermOrList!=null) CondTermOrList.setParent(this);
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public Or getOr() {
        return Or;
    }

    public void setOr(Or Or) {
        this.Or=Or;
    }

    public CondTermOrList getCondTermOrList() {
        return CondTermOrList;
    }

    public void setCondTermOrList(CondTermOrList CondTermOrList) {
        this.CondTermOrList=CondTermOrList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTerm!=null) CondTerm.accept(visitor);
        if(Or!=null) Or.accept(visitor);
        if(CondTermOrList!=null) CondTermOrList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
        if(Or!=null) Or.traverseTopDown(visitor);
        if(CondTermOrList!=null) CondTermOrList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        if(Or!=null) Or.traverseBottomUp(visitor);
        if(CondTermOrList!=null) CondTermOrList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiCondTermList(\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Or!=null)
            buffer.append(Or.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTermOrList!=null)
            buffer.append(CondTermOrList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiCondTermList]");
        return buffer.toString();
    }
}