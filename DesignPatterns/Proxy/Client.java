
package Proxy;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        // Using proxy
        Image img1 = new ImageProxy("Image1.jpg");
        Image img2 = new ImageProxy("Image2.jpg");
        Image img3 = new ImageProxy("Image3.jpg");
        // We only display one of them
        img1.display();
        
        System.out.println("-----");
        
        // Not using proxy
        Image img4 = new HighResolutionImage("Image4.jpg");
        Image img5 = new HighResolutionImage("Image5.jpg");
        Image img6 = new HighResolutionImage("Image6.jpg");
        // We only display one of them
        img4.display();
        
    }
}
