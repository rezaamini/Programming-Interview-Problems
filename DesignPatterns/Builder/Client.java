
package Builder;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        MealBuilder mealBuilder = new MealBuilder();
        
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getPrice());
        
        System.out.println("----");
        
        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getPrice());
    }
}
