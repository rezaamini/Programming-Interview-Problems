
package designpatterns.Proxy;

/**
 *
 * @author rezaamini
 */
public class ImageProxy implements Image
{
    private String fileName;
    private HighResolutionImage ProxifiedImage;
    
    public ImageProxy(String fileName)
    {
        this.fileName = fileName;
    }

    public void display()
    {
        ProxifiedImage = new HighResolutionImage(fileName);
        ProxifiedImage.display();
    }
}
