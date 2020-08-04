
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RecsDeclaration extends Declaration {

  public RecsDeclaration (ProcsDeclaration dAST, SourcePosition thePosition) {
    super (thePosition);
    D = dAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitRecsDeclaration(this, o);
  }

  public ProcsDeclaration D;
}