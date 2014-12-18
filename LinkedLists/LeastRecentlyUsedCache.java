/*
 * A Least Recently Used (LRU) cache of size n is a temporary storage of size n 
 * that holds the top n most frequently accessed items. Implement such storage 
 * with a linked list.
 */
package LinkedLists;

/**
 *
 * @author rezaamini
 */
public class LeastRecentlyUsedCache<T>
{
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;
    private int currentSize = 0;
    
    public LeastRecentlyUsedCache(int n)
    {
        this.size = n;
    }
    
    public void insert(LinkedListNode<T> node)
    {
        if(node == null)
            return;
        
        // cache is empty
        if(head == null)
        {
            head = node;
            tail = node;
            currentSize++;
            return;
        }
        
        if(currentSize == size)
        {
            head = head.next;
            currentSize--;
        }
        
        tail.next = node;
        tail = node;
        tail.next = null;
        currentSize++;
    }
    
    public LinkedListNode<T> getNode(T value)
    {
        if(head == null)
            return null;
        
        // one element in cache & it is the right element
        if(head == tail && head.value.equals(value))
            return head;
        
        if(head.value.equals(value))
        {
            LinkedListNode<T> temp = head;
            if(head.next != null)
                head = head.next;
            tail.next = temp;
            tail = temp;
            tail.next = null;
            return head;
        }
        
        LinkedListNode<T> temp = head;
        while(temp.next != null)
        {
            if(temp.next.value.equals(value))
            {
                LinkedListNode<T> node = temp.next;
                if(temp.next.next != null)
                    temp.next = temp.next.next;
                tail.next = node;
                tail = node;
                tail.next = null;
                return head;
            }
            temp = temp.next;
        }
        return null;
    }
    
    public void print()
    {
        LinkedListNode<T> temp = head;
        while(temp != null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class LRU_Tester
{
    public static void main(String[] args)
    {
        LeastRecentlyUsedCache<Integer> lru = new LeastRecentlyUsedCache<>(5);
        lru.insert(new LinkedListNode(1));
        lru.getNode(1);
        lru.print();
        lru.insert(new LinkedListNode(2));
        lru.print();
        lru.getNode(1);
        lru.print();
        lru.getNode(1);
        lru.print();
        lru.insert(new LinkedListNode(3));
        lru.insert(new LinkedListNode(4));
        lru.insert(new LinkedListNode(5));
        lru.insert(new LinkedListNode(6));
        lru.insert(new LinkedListNode(7));
        lru.print();
        lru.getNode(4);
        lru.print();
        lru.getNode(3);
        lru.print();
        lru.getNode(3);
        lru.print();
    }
}
