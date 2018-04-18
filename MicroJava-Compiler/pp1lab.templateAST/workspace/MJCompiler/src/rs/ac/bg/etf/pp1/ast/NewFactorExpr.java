// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class NewFactorExpr extends Factor {

    private Type Type;
    private OptionalBracketExpr OptionalBracketExpr;

    public NewFactorExpr (Type Type, OptionalBracketExpr OptionalBracketExpr) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.OptionalBracketExpr=OptionalBracketExpr;
        if(OptionalBracketExpr!=null) OptionalBracketExpr.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public OptionalBracketExpr getOptionalBracketExpr() {
        return OptionalBracketExpr;
    }

    public void setOptionalBracketExpr(OptionalBracketExpr OptionalBracketExpr) {
        this.OptionalBracketExpr=OptionalBracketExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptionalBracketExpr!=null) OptionalBracketExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalBracketExpr!=null) OptionalBracketExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalBracketExpr!=null) OptionalBracketExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewFactorExpr(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalBracketExpr!=null)
            buffer.append(OptionalBracketExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewFactorExpr]");
        return buffer.toString();
    }
}