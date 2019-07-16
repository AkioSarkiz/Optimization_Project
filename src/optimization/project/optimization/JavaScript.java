/*
 * JavaScript.java
 *
 * Created on 10 июл. 2019 г., 14:20:42
 *
 * Copyright(c) AkioSarkiz Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of AkioSarkiz Company.
 *
 */

package optimization.project.optimization;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Akio Sarkiz
 * @version 1.0
 * @see Optimization - standart methods and variable class: write, setPaths, addContent etc
 * @see IOptimizationLang - interface for concrete language filter class
 */
public class JavaScript extends Optimization implements IOptimizationLang{
    
    private boolean openComment = false;
    private char    typeComment;
    private boolean openString = false;
    private char    typeString;
    private final boolean TEST_METHODS = false;

    
    /**
     * Run class. NOTICE! set var pathSource and pathResult, please
     * @throws IOException
     */
    @Override
    public void run() throws IOException{
        this.getContntent();
        super.writeContent();
    }

    
    /**
     * Сlass variable testing.
     * If return 1|this.ACCEPT_CHAR - add char to content
     * If return 0|this.DONT_KNOW - don't know
     * If return -1|this.IGNORE_CHAR - not add char to content
     * @return 
     */
    @Override
    public int testPrivateVar(){

        //-------------------------------------
        // User testing char of string
        //-------------------------------------
        if (this.openString) return this.ACCEPT_CHAR;
        if (this.openComment) return this.IGNORE_CHAR;

        return this.DONT_KNOW;
    }

    
    /**
     * if have char i-1
     * If return 1|this.ACCEPT_CHAR - add char to content
     * If return 0|this.DONT_KNOW - don't know
     * If return -1|this.IGNORE_CHAR - not add char to content
     * @return 
     */
    @Override
    public int testCharIfMinusOne(){

        //------------------------------------
        // it's code standart. Don't touch
        //------------------------------------
        this.testMethodCharIfMinusOne(super.local_i, super.line);
        String l = super.line;          // line
        int i = super.local_i;          // local index
        int all_i = super.global_i;     // global index
        if (i == 0) return this.DONT_KNOW;
        char _c = l.charAt(i-1);        //char-1
        char c1 = l.charAt(i);          //char
        
        
        //-------------------------------------
        // User testing char of string
        //-------------------------------------
        //
        // OPEN string 
        if (!this.openString && !this.openComment) {
            if ((c1 == '\'' || c1 == '"') && _c != '\\') {
                this.openString = true;
                this.typeString = c1;
                return this.ACCEPT_CHAR;
            }
        }
        //
        // CLOSE string
        if (!this.openComment && this.openString) {
            if (c1 == this.typeString && _c != '\\') {
                this.openString = false;
                return this.ACCEPT_CHAR;
            }
        }
        //
        // CLOSE multi-comment
        if (!this.openString && this.openComment) {
            if (this.typeComment == '*' && c1 == '/' && _c == '*') {
                this.openComment = false;
                return this.IGNORE_CHAR;
            }
        }
        //
        // if coment one line, CLOSE COMMENT
        if (this.openComment && this.typeComment == '#' && c1 == '\n') {
            this.openComment = false;
            return this.IGNORE_CHAR;
        }

  
        return this.DONT_KNOW;
    }
    

    /**
     * if have char i+1
     * If return 1|this.ACCEPT_CHAR - add char to content
     * If return 0|this.DONT_KNOW - don't know
     * If return -1|this.IGNORE_CHAR - not add char to content
     * @return 
     */
    @Override
    public int testCharIfPluseOne(){
        
        //------------------------------------
        // it's code standart. Don't touch
        //------------------------------------
        this.testMethodCharIfPluseOne(super.local_i, super.line);
        String l = super.line;          // line
        int i = super.local_i;          // local index
        int all_i = super.global_i;     // global index
        if (l.length()-1 == i) return this.DONT_KNOW;
        char c2 = l.charAt(i+1);        //char+1
        char c1 = l.charAt(i);          //char

        
        //-------------------------------------
        // User testing char in string
        //-------------------------------------
        //
        // OPEN comment
        if (!this.openString && !this.openComment) {         
            /**
             * one line cooment
             */
            if (c1 == '/' && c2 == '/') {
                this.openComment = true;
                this.typeComment = '#';
                return this.IGNORE_CHAR;
            }
            if (c1 == '#') {
                this.openComment = true;
                this.typeComment = '#';
                return this.IGNORE_CHAR;
            }

            /**
             * multi-line comment
             */
            if (c1 == '/' && c2 == '*') {
                this.openComment = true;
                this.typeComment = '*';
                return this.IGNORE_CHAR;
            }
        }
        
        return this.DONT_KNOW;
    }
    

    /**
     * it's main method test char and it will return boolean.If it return true then char add to content if false char will ignoring
     * @return 
     */
    @Override
    public boolean testChar(){
        
        //System.out.println("[testChar] c1 = " + super.line.charAt(super.local_i));
        
        
        //------------------------------------
        // it's code standart. Don't touch
        //------------------------------------
        this.testMethodChar(super.local_i, super.line);
        String l = super.line;          // line
        int i = super.local_i;          // local index
        int all_i = super.global_i;     // global index
        char c1 = l.charAt(i);          // char
        int res1 = this.testCharIfPluseOne();   // result 1
        int res2 = this.testCharIfMinusOne();   // result 2
        int res3 = this.testPrivateVar();       // result 3
        if (res1 == -1 || res2 == -1 || res3 == -1) return false;  
        if (res1 ==  1 || res2 ==  1 || res3 ==  1) return true;

        
        //-------------------------------------
        // User testing char in string
        //-------------------------------------
        //
        // SPACE and PARAGRAPH
        if (c1 == ' ' || c1 == '\n') {
        
            // Exceptions
            //
            // if before paragraph or space have a reserved word
            String[] strArr = {
                "const",
                "function",
                "return",
                "class",
                "implements",
                "expands",
                "static",
                "private",
                "public",
            };
            
            for (String str : strArr) { 
                if (super.content.length()>=str.length() && super.content.substring(super.content.length() - str.length(), super.content.length()).equals(str)) {
                    return true;
                }
            }
    
            return false;
        }
        
        return true;
    }
    
    
    /**
     * Create content for file
     * @throws java.io.FileNotFoundException
     * @throws IOException 
     */
    @Override
    public void getContntent() throws FileNotFoundException, IOException{
        //------------------------------------
        // it's method standart. Don't touch
        //------------------------------------
        try (FileReader reader = new FileReader(this.pathSource)) {
            Scanner scan = new Scanner(reader);

            while(scan.hasNextLine()){
                
                super.line = scan.nextLine() + '\n'; 
                for (int i = 0; i < super.line.length(); i++) {   
                    
                    super.local_i = i;
                    super.global_i++;
                    if (this.testChar()){
                        if (super.line.charAt(i) == '\n'){
                            super.addContent(' ');
                        }else{
                            super.addContent(super.line.charAt(i));
                        } 
                    }   
                }
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void testMethodChar(int i, String l){
        if (this.TEST_METHODS) {
            System.out.println("[Method: testChar] c = " + l.charAt(i));
        }
    }
    
    private void testMethodCharIfPluseOne(int i, String l){
        if (this.TEST_METHODS && l.length()-1 != i) {
            System.out.println("[Method: PlusOne] c1 = " + l.charAt(i) + "\tc2 = " + l.charAt(i+1));
        }
    }
    
    private void testMethodCharIfMinusOne(int i, String l){
        if (this.TEST_METHODS && i>0) {
            System.out.println("[Method: MinusOne] c1 = " + l.charAt(i) + "\t_c = " + l.charAt(i-1));
        }
    }
}