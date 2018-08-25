// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class MultiExpressionlist extends ExpressionList {

    private ExpressionList ExpressionList;
    private AddOp AddOp;
    private Term Term;

    public MultiExpressionlist (ExpressionList ExpressionList, AddOp AddOp, Term Term) {
        this.ExpressionList=ExpressionList;
        if(ExpressionList!=null) ExpressionList.setParent(this);
        this.AddOp=AddOp;
        if(AddOp!=null) AddOp.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public ExpressionList getExpressionList() {
        return ExpressionList;
    }

    public void setExpressionList(ExpressionList ExpressionList) {
        this.ExpressionList=ExpressionList;
    }

    public AddOp getAddOp() {
        return AddOp;
    }

    public void setAddOp(AddOp AddOp) {
        this.AddOp=AddOp;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExpressionList!=null) ExpressionList.accept(visitor);
        if(AddOp!=null) AddOp.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExpressionList!=null) ExpressionList.traverseTopDown(visitor);
        if(AddOp!=null) AddOp.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExpressionList!=null) ExpressionList.traverseBottomUp(visitor);
        if(AddOp!=null) AddOp.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiExpressionlist(\n");

        if(ExpressionList!=null)
            buffer.append(ExpressionList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddOp!=null)
            buffer.append(AddOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiExpressionlist]");
        return buffer.toString();
    }
}
