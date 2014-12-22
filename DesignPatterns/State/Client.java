
package State;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        Context context = new Context();
        State stateA = new StateA();
        State stateB = new StateB();
        
        stateA.doSomething(context);
        System.out.println(context.getState());
        
        stateB.doSomething(context);
        System.out.println(context.getState());
    }
}
