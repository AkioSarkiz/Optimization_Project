package optimization.project.optimization;

import java.awt.Color;
import java.io.IOException;

/**
  * @author Dmitriy
 */
public interface IOptimization {
   
    /**
     * Set path source to project
     * @param pathSource 
     */
    public void setPathSource(String pathSource);
    
    /**
     * Set path to save result
     * @param pathResult 
     */
    public void setPathResult(String pathResult);
    
    /**
     * add Content. Method writeContent need it
     * @param c 
     */
    public void addContent(char c);
    
    /**
     * Save file
     * @throws IOException 
     */
    public void writeContent() throws IOException;
}
