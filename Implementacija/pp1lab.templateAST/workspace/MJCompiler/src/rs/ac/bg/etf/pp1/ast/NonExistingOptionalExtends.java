// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:54


package rs.ac.bg.etf.pp1.ast;

public class NonExistingOptionalExtends extends OptionalExtends {

    public NonExistingOptionalExtends () {
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
        buffer.append("NonExistingOptionalExtends(\n");

        buffer.append(tab);
        buffer.append(") [NonExistingOptionalExtends]");
        return buffer.toString();
    }
}
