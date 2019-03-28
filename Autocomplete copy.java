package A03AutoComplete;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdIn;

public class Autocomplete {

    /////////////////////////////////////////////////////////////
    // fields
    private Term[] terms;

    /////////////////////////////////////////////////////////////
    // public methods

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        checkForNull(terms, "Array of terms is null");
        this.terms = terms.clone();

        Arrays.sort(this.terms);
        // TODO remove next 2 lines
        //System.out.println("ordered Terms:");
        //printArray(this.terms);
    }

    // Return all terms that start with the given prefix, in descending order of
    // weight.
    public Term[] allMatches(String prefix) {
        checkForNull(prefix, "prefix is null");
        // create a temporary Term to hold the prefix so it can be compared to
        // other Terms
        Term p = new Term(prefix, 0);
        // find the first and last index of terms that start w/ the prefx
        int first = BinarySearchDeluxe.firstIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));
        // create an array of those terms w/ the prefix
        Term[] range = Arrays.copyOfRange(terms, first, last + 1);
        // sort range by weight
        Arrays.sort(range, Term.byReverseWeightOrder());
        // TODO remove next 3 lines
        //System.out.println("Binary search results: " + first + " " + last);
        //System.out.println("Ordered terms:");
        //printArray(range);
        return range;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        // starts off the same way as allMatches(), stops after first and last is found
        checkForNull(prefix, "prefix is null");
        // create a temporary Term to hold the prefix so it can be compared to
        // other Terms
        Term p = new Term(prefix, 0);
        // find the first and last index of terms that start w/ the prefx
        int first = BinarySearchDeluxe.firstIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));

        return last - first + 1;
    }

    /////////////////////////////////////////////////////////////
    // private methods

    private void checkForNull(Object o, String errorMsg) {
        if (o == null)
            throw new NullPointerException(errorMsg);
    }

    /////////////////////////////////////////////////////////////
    // main method for testing

    /*public static void main(String[] args) {

        // main method vars
        String input;
        List<Term> list = new LinkedList<>();
        Term[] array;
        Autocomplete a;

        // create list of terms from user
        System.out.println("Enter terms(String then double): (type DONE when done)");
        while (true) {
            input = StdIn.readString();
            if (input.equalsIgnoreCase("done"))
                break;
            list.add(new Term(input, StdIn.readDouble()));
        }

        // convert list into an array
        array = new Term[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        // get prefix
        System.out.print("prefix: ");
        String prefix = StdIn.readString();
        a = new Autocomplete(array);
        a.allMatches(prefix);

    }

    public static void printArray(Term[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + "\t" + a[i]);
        }
    }*/

}
