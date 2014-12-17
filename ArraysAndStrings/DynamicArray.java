
package ArraysAndStrings;

import java.util.Arrays;

/**
 * Implement a dynamic size array.
 * 
 * @author Reza Amini
 */
public class DynamicArray
{
    private final int SMALLEST_SIZE = 8;
    private int size;
    private int index;
    int[] array;
    
    public DynamicArray()
    {
        this.size = SMALLEST_SIZE;
        array = new int[size];
        index = 0;
    }
    
    // Double the array size if number of elements is more than current size
    public void add(int element)
    {
        if(index == -1)
            index++;
        array[index] = element;
        index++;
        if(index == size)
        {
            int newSize = size * 2;
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, index);
            size = newSize;
            array = newArray;
        }
    }
       
    // Shrink the size if the number of elements is equal to half of current size
    public int remove(int i)
    {
        if(i >= index)
            throw new IndexOutOfBoundsException();
        
        int out = array[i];
        for(int j = i; j < index - 1; j++)
            array[j] = array[j + 1];
        
        index--;
        
        if(size > SMALLEST_SIZE && index == size / 2)
        {
            int newSize = size / 2;
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, index);
            size = newSize;
            array = newArray;
        }
        
        return out;
    }
    
    public int get(int i)
    {
        if(i >= index)
            throw new IndexOutOfBoundsException("Index " + i + " is larger than size " + index);
        
        return array[i];
    }
    
    public int size()
    {
        return index;
    }
    
    public String toString()
    {
        if(index <= 0)
            return " ";
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < index - 1; i++)
            str.append(get(i) + " ");
        
        str.append(get(index - 1));
        return str.toString();
    }
}


class Tester
{
    public static void main(String[] args)
    {
        DynamicArray array = new DynamicArray();
        System.out.println(array.size() + ": " + array);
        
        for(int i = 0; i < 26; i++)
        {
            array.add(i);
            System.out.println(array.size() + ": " + array);
        }
        
        for(int i = 25; i >= 0; i--)
        {
            array.remove(i);
            System.out.println(array.size() + ": " + array);
        }
        
        for(int i = 0; i < 26; i++)
        {
            array.add(i);
            System.out.println(array.size() + ": " + array);
        }
        
        for(int i = 25; i >= 0; i--)
        {
            array.remove(i);
            System.out.println(array.size() + ": " + array);
        }
    }
}
