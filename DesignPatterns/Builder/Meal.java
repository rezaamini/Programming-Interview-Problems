
package Builder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rezaamini
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    public float getPrice()
    {
        float price = 0f;
        for(Item item: items)
            price += item.price();
        return price;
    }
    
    public void showItems()
    {
        for (Item item : items) {
         System.out.print("Item : " + item.name());
         System.out.print(", Packing : " + item.packing().pack());
         System.out.println(", Price : " + item.price());
      }	
    }
}
