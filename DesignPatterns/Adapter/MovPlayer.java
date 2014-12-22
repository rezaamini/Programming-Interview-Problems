
package Adapter;

/**
 *
 * @author rezaamini
 */
public class MovPlayer implements AdvancedMediaPlayer
{
    public void playMOV(String fileName)
    {
        System.out.println("Playing MOV file (" + fileName + ") using MovPlayer.");
    }
    
    public void playMP4(String fileName)
    {
        // Do nothing
    }
}
