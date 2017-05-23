
package designpatterns.Proxy;

/**
 *
 * @author rezaamini
 */
public class HighResolutionImage implements Image
{
    public HighResolutionImage(String fileName)
    {
        loadFileFromDisk(fileName);
    }
    
    public void loadFileFromDisk(String fileName)
    {
        System.out.println("Loading file " + fileName + " from disk ...");
    }
    
    public void display()
    {
        System.out.println("Displaying image ...");
    }
}
