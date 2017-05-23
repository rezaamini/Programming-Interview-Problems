/*

   A circus is designing a tower routine consisting of people standing atop one 
   another's shoulders. For practical and aesthetic reasons, each person must be 
   both shorter and lighter than the person below him or her. Given the heights 
   and weights of each person in the circus, write a method to compute the largest 
   possible number of people in such a tower.
   
   EXAMPLE:
   Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
   Output: The longest tower is length 6 and includes from top to bottom: 
   (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)

 */
package sortingandsearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Reza Amini
 */
public class TowerOfPeople {
    
    // Returns longer sequence among two sequences
    public static ArrayList<Person> seqWithMaxLength(ArrayList<Person> first, 
            ArrayList<Person> second)
    {
        return (first.size() > second.size()) ? first : second;
    }
            
    // Finds next sequence of people
    public static ArrayList<Person> nextSeq(int start, ArrayList<Person> people)
    {
        ArrayList<Person> seq = new ArrayList();
        for (int i = start; i < people.size(); i++)
        {
            Person p = people.get(i);
            if (i == start || people.get(i - 1).isBefore(p))
                seq.add(p);
            else 
                break;
        }
        return seq;
    }
    
    // Find max sequence
    public static ArrayList<Person> findMaxSeq(ArrayList<Person> people)
    {
        Collections.sort(people, new PersonComparator());
        int start = 0;
        ArrayList<Person> longest = new ArrayList();
        while(start <= people.size() - longest.size())
        {
            ArrayList<Person> current = nextSeq(start, people);
            longest = seqWithMaxLength(longest, current);
            start++;
        }
        
        return longest;
    }
    
    public static void printTower(ArrayList<Person> list)
    {
        for(Person p: list)
            System.out.print("(" + p.getWeight() + ", " + p.getHeight() + ")");
        
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person(65, 100));
        list.add(new Person(70, 150));
        list.add(new Person(56, 90));
        list.add(new Person(75, 190));
        list.add(new Person(53, 200));
        list.add(new Person(75, 190));
        list.add(new Person(60, 95));
        list.add(new Person(68, 110));
        
        System.out.println("Original List: ");
        printTower(list);
        
        System.out.println("Max Tower: ");
        printTower(findMaxSeq(list));
    }
}

class Person 
{
    private int height;
    private int weight;
    
    public Person()
    {
        
    }
    public Person(int weight, int height)
    {
        this.height = height;
        this.weight = weight;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public int getWeight()
    {
        return this.weight;
    }
    
    public boolean isBefore(Person p)
    {
        return (this.getWeight() <= p.getWeight() && 
                this.getHeight() <= p.getHeight());
    }
}

class PersonComparator implements Comparator<Person>
{
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getWeight() == o2.getWeight() && 
            o1.getHeight() == o2.getHeight())
            return 0;
        else if (o1.isBefore(o2))
            return -1;
        else 
            return 1;
    }
}