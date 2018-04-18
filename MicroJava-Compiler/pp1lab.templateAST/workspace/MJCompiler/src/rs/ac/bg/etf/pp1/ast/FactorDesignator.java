// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private OptionalOptionalActParams OptionalOptionalActParams;

    public FactorDesignator (Designator Designator, OptionalOptionalActParams OptionalOptionalActParams) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.OptionalOptionalActParams=OptionalOptionalActParams;
        if(OptionalOptionalActParams!=null) OptionalOptionalActParams.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public OptionalOptionalActParams getOptionalOptionalActParams() {
        return OptionalOptionalActParams;
    }

    public void setOptionalOptionalActParams(OptionalOptionalActParams OptionalOptionalActParams) {
        this.OptionalOptionalActParams=OptionalOptionalActParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(OptionalOptionalActParams!=null) OptionalOptionalActParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(OptionalOptionalActParams!=null) OptionalOptionalActParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(OptionalOptionalActParams!=null) OptionalOptionalActParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalOptionalActParams!=null)
            buffer.append(OptionalOptionalActParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
