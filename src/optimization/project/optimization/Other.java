/*
 * Other.java
 *
 * Created on 10 июл. 2019 г., 14:50:04
 *
 * Copyright(c) AkioSarkiz Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of AkioSarkiz Company.
 *
 */

package optimization.project.optimization;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class created so that copy file: png, jpg, svg, txt etc
 * @author Akio Sarkiz
 * @version 1.0
 */
public class Other extends Optimization{ 
    
    
    /**
     * run class. REQUIRE PATH SOURCE AND PATH RESULT
     * @throws IOException
     */
    public void run() throws IOException{
        Path path = Paths.get(this.pathResult);
        Files.createDirectories(path.getParent());
        File source = new File(super.pathSource);
        File dest = new File(super.pathResult);
        this.copyFile(source, dest);
    }
    
    /**
     * Copy in dir to dir
     * @param source
     * @param dest
     * @throws IOException 
     */
    private void copyFile(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }finally{
            if (sourceChannel != null) sourceChannel.close();
            if (destChannel != null) destChannel.close();
        }
    }
}
