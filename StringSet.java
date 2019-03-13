/**
 * @author Nathan Litts
 *
 * This is a string set data structure, that is implemented as a Hash Table.
 * This data structure supports operations insert, find and print
 */
public class StringSet
{

    StringNode [] table;    // Hash table - collisions resolved through chaining.
    int numelements;	    // Number of elements actually stored in the structure.
    int size;				// Allocated memory (size of the hash table).

    /**
     * Constructur: initilaizes numelements, size and initial table size.
     */
    public StringSet()
    {
        numelements = 0;
        size = 100;
        table = new StringNode[size];
    }

    /*
     * inserts a new key into the set. Inserts it at the head of the linked list
     * given by its hash value. Increases the size of the table as it fills.
     */
    public void insert(String key)
    {

        if (numelements == size)
        {
            size *= 2;
            StringNode[] table2 = new StringNode[size];
            for (int i = 0; i < (size/2); i++)
            {
                for (StringNode curr = table[i]; curr != null; curr = curr.getNext())
                {
                    int h = hash(curr.getKey());
                    table2[h] = new StringNode(curr.getKey(), table2[h]);
                }
            }
            table = table2;
        }

        int h = hash(key);
        table[h] = new StringNode(key, table[h]);
        numelements++;
    }

    /*
     * finds if a String key is present in the table. Returns true if found, else false.
     */
    public boolean find(String key)
    {
        int i = hash(key);
        for (StringNode curr = table[i]; curr != null; curr = curr.getNext())
        {
            if (curr.getKey().equals(key))
                return true;
        }
        return false;
    }

    /*
     * Prints the contents of the table.
     */
    public void print()
    {
        for (int i = 0; i < size; i++)
            for (StringNode curr = table[i]; curr != null; curr = curr.getNext())
                System.out.println(curr.getKey() + "   " + i);
    }

    /*
     * The hash function that returns an index into the hash table for a string k.
     */
    private int hash(String k)
    {
        int x = 1279;
        int hash = 0;
        for (int i = 0; i < k.length(); i++)
            hash = ((hash * x) + (int) k.charAt(i)) % size;

        return hash;
    }

}
