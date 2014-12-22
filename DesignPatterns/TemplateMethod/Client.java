
package TemplateMethod;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        Game game = new Football();
        game.play();
        
        game = new Tennis();
        game.play();
    }
}
