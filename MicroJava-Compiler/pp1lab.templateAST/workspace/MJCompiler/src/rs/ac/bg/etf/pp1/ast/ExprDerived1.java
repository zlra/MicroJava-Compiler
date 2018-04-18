// generated with ast extension for cup
// version 0.8
// 8/3/2018 23:48:46


package rs.ac.bg.etf.pp1.ast;

public class ExprDerived1 extends Expr {

    private OptionalMinus OptionalMinus;
    private Term Term;
    private AddOpTermList AddOpTermList;

    public ExprDerived1 (OptionalMinus OptionalMinus, Term Term, AddOpTermList AddOpTermList) {
        this.OptionalMinus=OptionalMinus;
        if(OptionalMinus!=null) OptionalMinus.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddOpTermList=AddOpTermList;
        if(AddOpTermList!=null) AddOpTermList.setParent(this);
    }

    public OptionalMinus getOptionalMinus() {
        return OptionalMinus;
    }

    public void setOptionalMinus(OptionalMinus OptionalMinus) {
        this.OptionalMinus=OptionalMinus;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public AddOpTermList getAddOpTermList() {
        return AddOpTermList;
    }

    public void setAddOpTermList(AddOpTermList AddOpTermList) {
        this.AddOpTermList=AddOpTermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalMinus!=null) OptionalMinus.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(AddOpTermList!=null) AddOpTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalMinus!=null) OptionalMinus.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddOpTermList!=null) AddOpTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalMinus!=null) OptionalMinus.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddOpTermList!=null) AddOpTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprDerived1(\n");

        if(OptionalMinus!=null)
            buffer.append(OptionalMinus.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddOpTermList!=null)
            buffer.append(AddOpTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprDerived1]");
        return buffer.toString();
    }
}
