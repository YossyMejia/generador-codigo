/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author XPC
 */
public class ForCommand extends Command {
    
    public ForCommand (Declaration dAST, Expression eAST, Command cAST,
                    SourcePosition thePosition) {
    super (thePosition);
    D = dAST;
    E = eAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForCommand(this, o);
  }
  
  public Declaration D;
  public Expression E;
  public Command C;
}
