package linkedlists;

public class LinkedListNode<T> {
    T value;
    LinkedListNode<T> next;

    public LinkedListNode(T value)
    {
        this.value = value;
    }

    public String toString()
    {
        StringBuilder out = new StringBuilder();
        LinkedListNode<T> temp = this;
        while(temp != null)
        {
            out.append(temp.value).append(" ");
            temp = temp.next;
        }
        out.setLength(out.length() - 1);
        return out.toString();
    }
}