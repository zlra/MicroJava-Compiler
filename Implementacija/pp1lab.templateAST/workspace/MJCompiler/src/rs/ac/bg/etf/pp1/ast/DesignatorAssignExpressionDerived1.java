// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class DesignatorAssignExpressionDerived1 extends DesignatorAssignExpression {

    public DesignatorAssignExpressionDerived1 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAssignExpressionDerived1(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAssignExpressionDerived1]");
        return buffer.toString();
    }
}
