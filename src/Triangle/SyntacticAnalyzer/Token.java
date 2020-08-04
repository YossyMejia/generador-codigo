/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

 

 public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    AND                 = 4,        //MODIFICADO
    ARRAY		= 5,
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    ELSIF               = 9,        //MODIFICADO
    END			= 10,
    EXIT                = 11,       //MODIFICADO
    FUNC		= 12,
    IF			= 13,
    IN			= 14,
    LET			= 15,
    NEXT                = 16,       //MODIFICADO
    NIL                 = 17,       //MODIFICADO
    OF			= 18,
    PRIVATE             = 19,       //MODIFICADO
    PROC		= 20,
    REC                 = 21,       //MODIFICADO
    RECORD		= 22,
    REPEAT              = 23,       //MODIFICADO
    RETURN              = 24,       //MODIFICADO
    THEN		= 25,
    TO                  = 26,       //MODIFICADO
    TYPE		= 27,
    UNTIL               = 28,       //MODIFICADO
    VAR			= 29,
    WHILE		= 30,

    // punctuation...
    DOT			= 31,
    COLON		= 32,
    SEMICOLON	= 33,
    COMMA		= 34,
    BECOMES		= 35,
    IS			= 36,

    // brackets...
    LPAREN		= 37,
    RPAREN		= 38,
    LBRACKET	= 39,
    RBRACKET	= 40,
    LCURLY		= 41,
    RCURLY		= 42,

    // special tokens...
    EOT			= 43,
    ERROR		= 44;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "and",          //MODIFICADO
    "array",
    "const",
    "do",
    "else",
    "elsif",        //MODIFICADO
    "end",
    "exit",         //MODIFICADO
    "func",
    "if",
    "in",
    "let",
    "next",         //MODIFICADO
    "nil",          //MODIFICADO
    "of",
    "private",      //MODIFICADO
    "proc", 
    "rec",          //MODIFICADO
    "record",
    "repeat",       //MODIFICADO
    "return",       //MODIFICADO
    "then",
    "to",           //MODIFICADO
    "type",
    "until",        //MODIFICADO
    "var",  
    "while",    
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.AND,      //MODIFICADO
  				lastReservedWord  = Token.WHILE;

}
