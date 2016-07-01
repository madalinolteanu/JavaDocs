package exercise.exercise0;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(2);
        array.add(5);array.add(3);



        ListIterator<Integer> iter = array.listIterator();
        System.out.println("ITERARE CU Iterate");
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("ITERARE CU FOR");
        for(int i = 0; i < array.size();i++){
            System.out.println(array.get(i));
        }
        System.out.println("ITERARE CU FOREACH");

        for(Integer element : array){
            System.out.println(element);

        }
    }

    public static void main(String[] args) {

        Exercise0 ex = new Exercise0();
        ex.iterateThroughList();
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
    }
}
