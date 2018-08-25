// generated with ast extension for cup
// version 0.8
// 21/7/2018 1:53:54


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationElem extends VarDeclarationElement {

    private String variableName;
    private OptionalSquareBrackets OptionalSquareBrackets;

    public VarDeclarationElem (String variableName, OptionalSquareBrackets OptionalSquareBrackets) {
        this.variableName=variableName;
        this.OptionalSquareBrackets=OptionalSquareBrackets;
        if(OptionalSquareBrackets!=null) OptionalSquareBrackets.setParent(this);
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName=variableName;
    }

    public OptionalSquareBrackets getOptionalSquareBrackets() {
        return OptionalSquareBrackets;
    }

    public void setOptionalSquareBrackets(OptionalSquareBrackets OptionalSquareBrackets) {
        this.OptionalSquareBrackets=OptionalSquareBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalSquareBrackets!=null) OptionalSquareBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalSquareBrackets!=null) OptionalSquareBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalSquareBrackets!=null) OptionalSquareBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationElem(\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        if(OptionalSquareBrackets!=null)
            buffer.append(OptionalSquareBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationElem]");
        return buffer.toString();
    }
}
