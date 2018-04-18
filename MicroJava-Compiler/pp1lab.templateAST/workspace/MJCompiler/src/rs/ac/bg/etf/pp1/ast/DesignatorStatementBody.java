// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementBody extends DesignatorStatement {

    private Designator Designator;
    private DesignatorStatementBodyOptional DesignatorStatementBodyOptional;

    public DesignatorStatementBody (Designator Designator, DesignatorStatementBodyOptional DesignatorStatementBodyOptional) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesignatorStatementBodyOptional=DesignatorStatementBodyOptional;
        if(DesignatorStatementBodyOptional!=null) DesignatorStatementBodyOptional.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesignatorStatementBodyOptional getDesignatorStatementBodyOptional() {
        return DesignatorStatementBodyOptional;
    }

    public void setDesignatorStatementBodyOptional(DesignatorStatementBodyOptional DesignatorStatementBodyOptional) {
        this.DesignatorStatementBodyOptional=DesignatorStatementBodyOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesignatorStatementBodyOptional!=null) DesignatorStatementBodyOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesignatorStatementBodyOptional!=null) DesignatorStatementBodyOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesignatorStatementBodyOptional!=null) DesignatorStatementBodyOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementBody(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementBodyOptional!=null)
            buffer.append(DesignatorStatementBodyOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementBody]");
        return buffer.toString();
    }
}
