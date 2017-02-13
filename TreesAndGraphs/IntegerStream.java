package TreesAndGraphs;

import java.util.Random;

class IntegerStream
{
    private Random r;
    private int counter = 9;
    
    public IntegerStream()
    {
        r = new Random();
    }
    
    public int read()
    {
        counter--;
        return r.nextInt(50);
    }
    
    public boolean isEmpty()
    {
        return counter < 0;
    }
}