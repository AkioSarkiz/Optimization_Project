/*
 * Example.java
 *
 * Created on 10 июл. 2019 г., 20:36:42
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
public class Example extends Optimization implements IOptimizationLang{

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
            // code
        

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
        String l = super.line;          // line
        int i = super.local_i;          // local index
        int all_i = super.global_i;     // global index
        if (i == 0) return this.DONT_KNOW;
        char _c = l.charAt(i-1);        //char-1
        char c1 = l.charAt(i);          //char

        
        //-------------------------------------
        // User testing char of string
        //-------------------------------------
            // code
        
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
        String l = super.line;          // line
        int i = super.local_i;          // local index
        int all_i = super.global_i;     // global index
        if (line.length() > i) return this.DONT_KNOW;
        char c2 = l.charAt(i+1);        //char+1
        char c1 = l.charAt(i);          //char


        //-------------------------------------
        // User testing char in string
        //-------------------------------------
            //code
        
        return this.DONT_KNOW;
    }
    

    /**
     * it's main method test char and it will return boolean.
     * If it return true then char add to content if false char will ignoring
     * @return 
     */
    @Override
    public boolean testChar(){
        
        //------------------------------------
        // it's code standart. Don't touch
        //------------------------------------
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
            // code
        
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
}