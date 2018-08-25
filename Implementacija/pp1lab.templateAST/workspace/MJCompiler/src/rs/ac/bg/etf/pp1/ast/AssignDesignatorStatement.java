// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class AssignDesignatorStatement extends DesignatorStatement {

    private DesignatorAssignExpression DesignatorAssignExpression;

    public AssignDesignatorStatement (DesignatorAssignExpression DesignatorAssignExpression) {
        this.DesignatorAssignExpression=DesignatorAssignExpression;
        if(DesignatorAssignExpression!=null) DesignatorAssignExpression.setParent(this);
    }

    public DesignatorAssignExpression getDesignatorAssignExpression() {
        return DesignatorAssignExpression;
    }

    public void setDesignatorAssignExpression(DesignatorAssignExpression DesignatorAssignExpression) {
        this.DesignatorAssignExpression=DesignatorAssignExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorAssignExpression!=null) DesignatorAssignExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorAssignExpression!=null) DesignatorAssignExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorAssignExpression!=null) DesignatorAssignExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignDesignatorStatement(\n");

        if(DesignatorAssignExpression!=null)
            buffer.append(DesignatorAssignExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignDesignatorStatement]");
        return buffer.toString();
    }
}
