/*
 
 Implement a Paged Array, which is a set of arrays with a limited maximum size
 
*/

package arraysandstrings;

import java.util.ArrayList;

/*
 * 
 * @author Reza Amini
 */
public class PagedArray
{
    private ArrayList<ArrayList<Integer>> array;
    private final int maxPageSize;
    
    public PagedArray(int maxPageSize)
    {
        array = new ArrayList<ArrayList<Integer>>();
        this.maxPageSize = maxPageSize;
    }
    
    public int getSize()
    {
        return array.size();
    }
    
    public int getMaxPageSize()
    {
        return maxPageSize;
    }
    
    public void insert(int pageIndex, int elementIndex, int element) throws IndexOutOfBoundsException
    {
        if(pageIndex > getSize())
            throw new IndexOutOfBoundsException("Page index " + pageIndex + 
                    " is greater than array size " + getSize());
        if(elementIndex >= getMaxPageSize())
            throw new IndexOutOfBoundsException("Element index " + elementIndex + 
                    " is greater than page size " + getMaxPageSize());
        if(pageIndex == getSize() && elementIndex != 0)
            throw new IndexOutOfBoundsException("When page index is equal to array size (" + 
                    pageIndex + "), element index can only be zero."); 
        
        //if we are adding to a new page
        if (pageIndex == getSize()) {
            array.add(new ArrayList<Integer>());
        }
        
        if(pageIndex != 0 && pageIndex == getSize() && 
                array.get(pageIndex - 1).size() < getMaxPageSize()) 
            throw new IndexOutOfBoundsException("Previous page is not full yet.");
        if(elementIndex >= array.get(pageIndex).size() + 1) 
            throw new IndexOutOfBoundsException("Previous elements of this page are still empty.");
        
        // Base case
        if(array.get(pageIndex).size() < getMaxPageSize())
            array.get(pageIndex).add(elementIndex, element);
        else // Recursive 
        {
            // Keep the last element of this page to be sent to the next page 
            int carry = array.get(pageIndex).get(getMaxPageSize() - 1);
            shiftElementsRight(pageIndex, elementIndex);
            array.get(pageIndex).set(elementIndex, element);
            insert(pageIndex + 1, 0, carry);
        }
    }
    
    private void shiftElementsRight(int pageIndex, int from)
    {
        for(int i = getMaxPageSize() - 1; i > from; i--)
            array.get(pageIndex).set(i, array.get(pageIndex).get(i - 1));
    }
    
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        for(ArrayList list: array)
        {
            for(int i = 0; i < list.size(); i++)
                out.append(list.get(i)).append("  ");
            out.append("\n");
        }
        return out.toString();
    }
}


class PagedArrayTester
{
    public static void main(String[] args)
    {
        PagedArray array = new PagedArray(3);
        array.insert(0, 0, 1);
        array.insert(0, 1, 2);
        array.insert(0, 2, 3);
        array.insert(0, 1, 4);
        array.insert(0, 2, 5);
        array.insert(1, 0, 6);
        
        System.out.println(array);
    }
}
