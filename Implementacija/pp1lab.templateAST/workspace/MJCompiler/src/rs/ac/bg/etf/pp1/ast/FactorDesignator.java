// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private OptionalOptionalActPars OptionalOptionalActPars;

    public FactorDesignator (Designator Designator, OptionalOptionalActPars OptionalOptionalActPars) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.OptionalOptionalActPars=OptionalOptionalActPars;
        if(OptionalOptionalActPars!=null) OptionalOptionalActPars.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public OptionalOptionalActPars getOptionalOptionalActPars() {
        return OptionalOptionalActPars;
    }

    public void setOptionalOptionalActPars(OptionalOptionalActPars OptionalOptionalActPars) {
        this.OptionalOptionalActPars=OptionalOptionalActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(OptionalOptionalActPars!=null) OptionalOptionalActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(OptionalOptionalActPars!=null) OptionalOptionalActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(OptionalOptionalActPars!=null) OptionalOptionalActPars.traverseBottomUp(visitor);
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

        if(OptionalOptionalActPars!=null)
            buffer.append(OptionalOptionalActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}