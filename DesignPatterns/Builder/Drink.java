
package Builder;

/**
 *
 * @author rezaamini
 */
public abstract class Drink implements Item
{
    @Override
    public Packing packing()
    {
        return new Bottle();
    }
}
