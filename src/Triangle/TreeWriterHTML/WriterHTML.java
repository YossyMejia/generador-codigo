/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.TreeWriterHTML;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XPC
 */
public class WriterHTML {
    private String fileName;
    private FileWriter file;
    
    public WriterHTML(String fileName) {
        this.fileName = (fileName.substring(0, fileName.length()-4))+".html";
    }
    
    public void createFile(){
    try {
            file = new FileWriter(fileName);
            //HTML header
            file.write("<html>\n<head>\n<title>Codigo</title>\n</head>");
            file.write("<style>\np{font-size: 1em; font-family: \"Courier New\", monospaced;}\n");
            file.write(".literal{color : #004080;}\n");
            file.write(".comment{color: #009933;}\n");
            file.write(".reservedword {font-weight:bold;}\n");
            file.write("</style>\n<body><p>\n");
        } catch (IOException e) {
            System.err.println("Error while creating file for print the code");
            e.printStackTrace();
        }
    }
    
    public void writeReservedWord(String word){
        try {
            file.write("<span class='reservedword'>"+word+"</span>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeLiteralWord(String word){
        try {
            file.write("<span class='literal'>"+word+"</span>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeNormalWord(String word){
        try {
            file.write("<span>"+word+"</span>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeSpaceWord(char spaceChar){
        try {
            switch (spaceChar) {
                case '\n':
                {
                    file.write("<br></br>");
                }
                break;
                case '\t':
                {
                    file.write("<span>"+"&nbsp;&nbsp;"+"</span>");
                }
                break;
                default:
                    file.write("<span>"+"&nbsp;"+"</span>");
                
            }
         
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeComment(String comment){
        try {
            file.write("<span class='comment'>"+comment+"</span><br></br>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeFile(){
        try {
            file.write("\n</p></body>\n</html>");
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
