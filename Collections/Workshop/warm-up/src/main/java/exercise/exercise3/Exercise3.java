package exercise.exercise3;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 04/20/2015.
 *
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 *             the earlier presentation) with the List<String> that is given to this class by
 *             its constructor.
 *
 *             Check out the elements that the list mentioned above contains and then, add them
 *             to your three Sets. After this check out the elements of your Sets. What do you
 *             remark? What could be the reason?
 *
 *             Finally, add to the one of the three Sets some elements
 *             that already exist in the Set (e.g add("that") and add("collection"))
 *
 *             To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 {

    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;

    public Exercise3(List<String> l) {
        listToAdd = l;
    }

    public void addElementsToSets(){

        System.out.println("The elements that will be added to the Sets: ");
        for(String elem : listToAdd){
            System.out.print(elem +" ");
        }

        Set <String> set1 = new HashSet<String>();
        Set <String> set2 = new LinkedHashSet<String>();
        Set <String> set3 = new TreeSet<String>();

        for(String elem : listToAdd){
            set1.add(elem);
        }
        for(String elem : listToAdd){
            set2.add(elem);
        }
        for(String elem : listToAdd){
            set3.add(elem);
        }

        System.out.println("\nThe elements contained in the first Set: ");


        for(String elem : set1){
            System.out.print(elem +" ");
        }
        System.out.println();

        System.out.println("WOOW SUNT LA INTAMPLARE !!\n");
        System.out.println("\nThe elements contained in the second Set: \n");
        for(String elem : set2){
            System.out.print(elem +" ");
        }
        System.out.println();

        System.out.println("WOOW NU SUNT IN ORDINE ALFABETICA !!\n");
        System.out.println("\nThe elements contained in the third Set: \n");
        for(String elem : set3){
            System.out.print(elem +" ");
        }
        System.out.println();


        System.out.println("\nThe elements contained in the TreeSet after inserting two duplicates: ");

        set1.add("that");
        set1.add("collection");

        for(String elem : set1){
            System.out.print(elem +" ");
        }
        System.out.println();
        System.out.println(" WOW NU LE ADAUGAA !!");

        Set<String> set4 = new TreeSet<String>(new Compara());
        for(String elem : listToAdd){
            set4.add(elem);
        }
        System.out.println("COMARA: " + set4);

    }

}
