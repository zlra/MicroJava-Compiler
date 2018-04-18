// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class ActParamsList extends ActParams {

    private ActParams ActParams;
    private Expr Expr;

    public ActParamsList (ActParams ActParams, Expr Expr) {
        this.ActParams=ActParams;
        if(ActParams!=null) ActParams.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ActParams getActParams() {
        return ActParams;
    }

    public void setActParams(ActParams ActParams) {
        this.ActParams=ActParams;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParams!=null) ActParams.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParams!=null) ActParams.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParams!=null) ActParams.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParamsList(\n");

        if(ActParams!=null)
            buffer.append(ActParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParamsList]");
        return buffer.toString();
    }
}
