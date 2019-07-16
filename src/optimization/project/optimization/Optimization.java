/*
 * Optimization.java
 *
 * Created on 10 июл. 2019 г., 14:26:54
 *
 * Copyright(c) AkioSarkiz Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of AkioSarkiz Company.
 *
 */

package optimization.project.optimization;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Akio Sarkiz
 * @version 1.0
 * @see IOptimization
 */
public class Optimization implements IOptimization{
    
    /* path to source file */
    public String pathSource;

    /* path to save optimization file*/
    public String pathResult;

    /* content file */
    public String content;

    /* line file */
    public String line;

    /* const */
    public final int ACCEPT_CHAR = 1;
    public final int IGNORE_CHAR = -1;
    public final int DONT_KNOW   = 0;

    /* index local and global 
     * local - index local str in content
     * 
     * Example #1:
     * contentFile = "test1\ntest2";
     * line = "test1";  --> then
     * local_i = 4;     --> then
     * global_i = 4;    --> finish
     * System.out.println(line.charAt(local_i));    --> 1
     * 
     * Example #2:
     * contentFile = "test1\ntest2";
     * line = "test2";  --> then
     * local_i = 4;     --> then
     * global_i = 8;    --> finish
     * System.out.println(line.charAt(local_i));    --> 2
     */
    public int local_i = 0;
    public int global_i = 0;
    
    /** Set variable a pathSource file {@link Optimization#pathSource}
     * @param pathSource - path to single file in project user
     */
    @Override
    public void setPathSource(String pathSource){
        this.pathSource = pathSource;
    }
    
    /**
     * Set variable a pathResult file {@link Optimization#pathResult}
     * @param pathResult - path for save of file
     */
    @Override
    public void setPathResult(String pathResult){
        this.pathResult = pathResult;
    }
    
    /**
     * add char to var content {@link Optimization#content}
     * @param c - char will add to content
     */
    @Override
    public void addContent(char c){
        if (this.content == null) {
            this.content = String.valueOf(c);
        }else{
            this.content += c;
        }
    }
    
    /**
     * Write content to file and save to dir
     * @see Optimization#content
     * @throws IOException 
     */
    @Override
    public void writeContent()throws IOException{
        try{
            Path path = Paths.get(this.pathResult);
            Files.createDirectories(path.getParent());
            if (this.content != null) {
                Files.write(path, this.content.getBytes());
            }else{ 
                File file = new File(this.pathResult);
                file.createNewFile();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    } 
}