// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatement extends Statement {

    private OptionalExpression OptionalExpression;

    public ReturnStatement (OptionalExpression OptionalExpression) {
        this.OptionalExpression=OptionalExpression;
        if(OptionalExpression!=null) OptionalExpression.setParent(this);
    }

    public OptionalExpression getOptionalExpression() {
        return OptionalExpression;
    }

    public void setOptionalExpression(OptionalExpression OptionalExpression) {
        this.OptionalExpression=OptionalExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalExpression!=null) OptionalExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalExpression!=null) OptionalExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalExpression!=null) OptionalExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStatement(\n");

        if(OptionalExpression!=null)
            buffer.append(OptionalExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatement]");
        return buffer.toString();
    }
}
