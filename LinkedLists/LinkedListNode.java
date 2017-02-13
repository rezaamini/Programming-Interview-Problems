package LinkedLists;

public class LinkedListNode<T>
    {
        T value;
        LinkedLists.LinkedListNode<T> next;

        public LinkedListNode(T value)
        {
            this.value = value;
        }

        public String toString()
        {
            StringBuilder out = new StringBuilder();
            LinkedLists.LinkedListNode<T> temp = this;
            while(temp != null)
            {
                out.append(temp.value).append(" ");
                temp = temp.next;
            }
            out.setLength(out.length() - 1);
            return out.toString();
        }
    }