
package designpatterns.Adapter;

/**
 *
 * @author rezaamini
 */
public class Mp4Player implements AdvancedMediaPlayer
{
    public void playMOV(String fileName)
    {
        // Do nothing
    }
    
    public void playMP4(String fileName)
    {
        System.out.println("Playing MP4 file (" + fileName + ") using Mp4Player.");
    }
}
