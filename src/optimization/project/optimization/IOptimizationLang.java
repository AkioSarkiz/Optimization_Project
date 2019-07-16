package optimization.project.optimization;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Dmitriy
 */
public interface IOptimizationLang {
    public void run() throws IOException;
    public int testPrivateVar();
    public int testCharIfMinusOne();
    public int testCharIfPluseOne();
    public boolean testChar();
    public void getContntent() throws FileNotFoundException, IOException;
}
