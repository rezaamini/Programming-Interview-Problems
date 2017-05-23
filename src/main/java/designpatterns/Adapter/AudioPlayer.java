
package designpatterns.Adapter;

/**
 *
 * @author rezaamini
 */
public class AudioPlayer implements MediaPlayer
{
    private MediaAdapter adapter;
    
    public void play(String mediaType, String fileName)
    {
        if(mediaType.equals("mp3"))
            System.out.println("Playing MP3 file (" + fileName + ") using AudioPlayer.");
        else if(mediaType.equals("mov") || mediaType.equals("mp4"))
        {
            adapter = new MediaAdapter(mediaType);
            adapter.play(mediaType, fileName);
        }
        else
        {
            System.out.println(mediaType + " files are not supported.");
        }
    }
}
