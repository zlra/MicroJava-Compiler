// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class OptionalRelopExprEmpty extends OptionalRelopExpr {

    public OptionalRelopExprEmpty () {
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
        buffer.append("OptionalRelopExprEmpty(\n");

        buffer.append(tab);
        buffer.append(") [OptionalRelopExprEmpty]");
        return buffer.toString();
    }
}
