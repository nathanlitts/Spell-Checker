/**
 * @author Nathan Litts
 */

import java.util.Scanner;
import java.io.File;

/*
 * This class implements a spell checker application.
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker
{

    public static void main(String [] args)
    {

        File f = new File("dictionary");

        try
        {
            Scanner sk = new Scanner(f);

            StringSet x = new StringSet();

            // Read in the entire dictionary...
            while (sk.hasNext())
            {
                String word = sk.next();
                x.insert(word);
            }
            System.out.println("Dicitonary loaded...\n");
            System.out.print("Enter a word: ");


            sk = new Scanner(System.in);

            // Keep suggesting alternatives as long as the user makes an input.
            while (sk.hasNext())
            {
                String word = sk.next();
                word = word.toLowerCase();

                if (x.find(word))
                    System.out.println(word + " is correct.");
                else
                {
                    System.out.println("Suggesting alternatives ...");
                    String alternative;
                    boolean foundAlt = false;

                    for (int i = 0; i < word.length(); i++)
                    {
                        for (char j = 'a'; j <= 'z'; j++)
                        {
                            char[] myChars = word.toCharArray();
                            myChars[i] = j;
                            alternative = String.valueOf(myChars);
                            if (x.find(alternative))
                            {
                                foundAlt = true;
                                System.out.println(alternative);
                            }
                        }
                    }
                    if (!foundAlt)
                        System.out.println("No alternatives found.");
                }

                System.out.print("\nEnter a word: ");
            }

        } catch (Exception e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }
    }
}
