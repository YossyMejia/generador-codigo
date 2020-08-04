package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class doUntilCommand extends Command {

  public doUntilCommand (Command cAST, Expression eAST, SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitdoUntilCommand(this, o);
  }

  public Expression E;
  public Command C;
}
