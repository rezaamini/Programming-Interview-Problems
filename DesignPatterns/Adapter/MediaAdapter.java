
package Adapter;

/**
 *
 * @author rezaamini
 */
public class MediaAdapter implements MediaPlayer
{
    private AdvancedMediaPlayer advancedMusicPlayer;
    
    public MediaAdapter(String mediaType)
    {
        if(mediaType.equals("mov"))
            advancedMusicPlayer = new MovPlayer();
        else if (mediaType.equals("mp4"))
            advancedMusicPlayer = new Mp4Player();
    }
    
    public void play(String mediaType, String fileName)
    {
        if(mediaType.equals("mov"))
            advancedMusicPlayer.playMOV(fileName);
        else if (mediaType.equals("mp4"))
            advancedMusicPlayer.playMP4(fileName);
    }
}
