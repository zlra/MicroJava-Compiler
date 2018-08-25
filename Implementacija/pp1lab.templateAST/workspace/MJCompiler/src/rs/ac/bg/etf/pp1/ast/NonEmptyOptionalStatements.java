// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:55


package rs.ac.bg.etf.pp1.ast;

public class NonEmptyOptionalStatements extends OptionalStatements {

    private OptionalStatements OptionalStatements;
    private Statement Statement;

    public NonEmptyOptionalStatements (OptionalStatements OptionalStatements, Statement Statement) {
        this.OptionalStatements=OptionalStatements;
        if(OptionalStatements!=null) OptionalStatements.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public OptionalStatements getOptionalStatements() {
        return OptionalStatements;
    }

    public void setOptionalStatements(OptionalStatements OptionalStatements) {
        this.OptionalStatements=OptionalStatements;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalStatements!=null) OptionalStatements.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalStatements!=null) OptionalStatements.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalStatements!=null) OptionalStatements.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NonEmptyOptionalStatements(\n");

        if(OptionalStatements!=null)
            buffer.append(OptionalStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonEmptyOptionalStatements]");
        return buffer.toString();
    }
}
