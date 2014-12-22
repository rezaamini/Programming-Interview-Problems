
package Adapter;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args) {
      AudioPlayer audioPlayer = new AudioPlayer();

      audioPlayer.play("mp3", "file1.mp3");
      audioPlayer.play("mp4", "file2.mp4");
      audioPlayer.play("mov", "file3.mov");
      audioPlayer.play("avi", "file4.avi");
   }
}
