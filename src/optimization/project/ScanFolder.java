/*
 * FolderUser.java
 *
 * Created on 10 июл. 2019 г., 1:05:18
 *
 * Copyright(c) AkioSarkiz Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of AkioSarkiz Company.
 *
 */
package optimization.project;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import optimization.project.optimization.*;

/**
 * Scan and oprimization files in select user a directory
 * and create new files to pathResult wicth user selected 
 * @author Dmitriy
 * @version 1.0
 */
public class ScanFolder {

    private javax.swing.JProgressBar progress_bar;
    private String pathSource;
    private String pathResult;
    private int max_files = -1;
    private javax.swing.JLabel jl_cnsl;
    private HashMap<String, String> absolutePathToFiles;
    
    /**
     * Welcome!
     * @throws IOException 
     */
    private void optimizationFiles() throws IOException{
        
        this.setValueProgressBar(70);
        
        for (Map.Entry entry : this.absolutePathToFiles.entrySet()) {
            
            String type = this.getFileExtension(new File(entry.getKey().toString()));
            String pathResult = this.pathResult + entry.getValue().toString();
            String pathSource = entry.getKey().toString();
            
            // print filePath to console
            this.cnslPrint(pathSource, Color.LIGHT_GRAY);
            
            switch (type){
                case "html":
                    HTML html = new HTML();
                    html.setPathSource(pathSource);
                    html.setPathResult(pathResult);
                    html.run();
                    break;
                case "php":
                    PHP php = new PHP();
                    php.setPathSource(pathSource);
                    php.setPathResult(pathResult);
                    php.run();
                    break;
                case "js":
                    JavaScript js = new JavaScript();
                    js.setPathSource(pathSource);
                    js.setPathResult(pathResult);
                    js.run();
                    break;
                case "json":
                    JSON json = new JSON();
                    json.setPathSource(pathSource);
                    json.setPathResult(pathResult);
                    json.run();
                    break;
                case "css":
                    CSS css = new CSS();
                    css.setPathSource(pathSource);
                    css.setPathResult(pathResult);
                    css.run();
                    break;
                default:
                    Other other = new Other();
                    other.setPathSource(pathSource);
                    other.setPathResult(pathResult);
                    other.run();
            }
        }
        
        this.setValueProgressBar(100);
    }
    
    /**
     * Set source path {@link ScanFolder#pathSource}
     * @param path string
     */
    public void setPathSource(String path) {
        this.pathSource = path;
    }
    
    /**
     * Link to console app {@link ScanFolder#jl_cnsl}
     * @param console
     */
    public void setCnsl(javax.swing.JLabel console){
        this.jl_cnsl = console;
    }
    
    /**
     * Print to console text {@link ScanFolder#jl_cnsl}
     * @param txt 
     */
    private void cnslPrint(String str, Color color){
        this.jl_cnsl.setText(str);
        this.jl_cnsl.setForeground(color);
        for (int i = 0; i < 10; i++) {
            this.jl_cnsl.updateUI();
        }
    }

    /**
     * Set param progress bar {@link ScanFolder#progress_bar}
     * @param bar javax.swing.JProgressBar
     */
    public void setProgressbar(javax.swing.JProgressBar bar) {
        this.progress_bar = bar;
    }

    /**
     * Set max size files scan
     * @param index - max files
     */
    public void setMaxFiles(int index) {
        if (this.max_files == -1) {
            this.max_files = index;
        }
    }
    
    public void setPathResult(String path){
        this.pathResult = path;
    }
    
    /**
     * Set status progress bar
     * @param index 
     */
    private void setValueProgressBar(int index) {
        if (this.progress_bar != null) {
            this.progress_bar.setValue(index);
        }
    }
    
    /**
     * Add param to paths files
     * @param pathToFile
     * @param CreateToLocate 
     */
    private void addPathToMap(String pathToFile, String CreateToLocate) {
        if (this.absolutePathToFiles.size() < this.max_files) {
            this.absolutePathToFiles.put(pathToFile, CreateToLocate);
        }
    }

    /**
     * Run app
     * @throws java.io.IOException
     */
    public void run() throws IOException {
        this.absolutePathToFiles = new HashMap<>();
        this.setValueProgressBar(10);
        this.scan_folder(this.pathSource, "");
        this.optimizationFiles();
    }

    private void scan_folder(String path, String pref) {

        this.setValueProgressBar(30);
        File baseDirectory = new File(path);

        if (baseDirectory.isDirectory()) {
            for (File file : baseDirectory.listFiles()) {
                if (file.isFile()) {
                    this.addPathToMap(file.getAbsolutePath(), pref + '/' + file.getName());
                } else {
                    this.scan_folder(file.getAbsoluteFile().toString(), pref + '/' + file.getName());
                }
            }
        }
    }

    private String getFileExtension(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        int i = name.lastIndexOf('.');
        String ext = i > 0 ? name.substring(i + 1) : "";
        return ext;
    }

    public void print_map() {
        this.absolutePathToFiles.entrySet().forEach((entry) -> {
            System.out.println(
                    "Key: " + entry.getKey() + "\t Value: "
                            + entry.getValue() + "\n"
            );
        });
    }
}