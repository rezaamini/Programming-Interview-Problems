
package designpatterns.Principles.SingleResponsibility;

/**
 *
 * @author rezaamini
 */
public class Email implements IEmail
{

    @Override
    public void setSender(String sender) {
        System.out.println("I am coming from Email class, setSender() method.");
    }

    @Override
    public void setReceiver(String receiver) {
        System.out.println("I am coming from Email class, setReceiver() method.");
    }

    @Override
    public void setContent(IContent content) {
        System.out.println("I am coming from Email class, setContent() method.");
    }
    
}
