package exercise.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 1: Compute the sum, the minimum and the maximum element from a given list (givenList) using three
 *             different ways to iterate over a List:
 *             a) ListIterator (implement it in the iterateUsingListIterator() method)
 *             b) for loop (implement it in the iterateUsingForLoop() method)
 *             c) foreach loop (implement it in the iterateUsingForEachLoop() method)
 *
 *             In order to test your implementations you need to run the Exercise1Test from the test/java package
 *             (right-click on Exercise1Test class then click Run 'Exercise1Test' )
 */
public class Exercise1{

    // The list that contains some Integer values
    private List<Integer> givenList;

    public Exercise1(List<Integer> l) {
       this.givenList = l;
    }

    public List<Integer> iterateUsingListIterator(){

        int sum = 0 ;
        int min = 12313 ;
        int max = -12311 ;

        ListIterator<Integer> iter = givenList.listIterator();

        while(iter.hasNext()){
            int elem = iter.next();
            sum = sum + elem;
            if(elem < min){
                min = elem;
            }
            if(elem > max){
                max = elem;
            }

        }
        // This List is used only for testing so you don't have to modify it
        List<Integer> testValues = new ArrayList<Integer>();

        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    public List<Integer> iterateUsingForLoop(){

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int sum = 0;
        int min = 1233;
        int max = -1230;
        for(int i = 0; i < givenList.size();i++){

            if(i%2 ==0){
                sum = sum + givenList.get(i);

                if(givenList.get(i) < min){
                    min = givenList.get(i);
                }
                if(givenList.get(i) > max){
                    max = givenList.get(i);
                }
            }


        }

        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    public List<Integer> iterateUsingForEachLoop(){

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();

        int sum = 0;
        int min = 1233;
        int max = -1230;
        int count = 0;
        for(Integer elem : givenList){
            if(elem%2==1){
                sum = sum + elem;
                if(elem < min){
                    min = elem;
                }
                if(elem > max){
                    max = elem;
                }

            }
            count++;
        }

        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }
}
