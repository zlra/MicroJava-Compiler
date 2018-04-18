// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class DesignatorBodyArguments extends DesignatorStatementBodyOptional {

    private OptionalActParams OptionalActParams;

    public DesignatorBodyArguments (OptionalActParams OptionalActParams) {
        this.OptionalActParams=OptionalActParams;
        if(OptionalActParams!=null) OptionalActParams.setParent(this);
    }

    public OptionalActParams getOptionalActParams() {
        return OptionalActParams;
    }

    public void setOptionalActParams(OptionalActParams OptionalActParams) {
        this.OptionalActParams=OptionalActParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalActParams!=null) OptionalActParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalActParams!=null) OptionalActParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalActParams!=null) OptionalActParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorBodyArguments(\n");

        if(OptionalActParams!=null)
            buffer.append(OptionalActParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorBodyArguments]");
        return buffer.toString();
    }
}
