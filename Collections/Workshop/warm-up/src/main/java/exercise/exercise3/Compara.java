package exercise.exercise3;

import java.util.Comparator;
import java.util.List;

public class Compara implements Comparator<String> {

    public int compare(String o1, String o2) {
        if(o1.length() > o2.length())
            return 1;
        else if(o1.equals(o2))
            return 0;
        else return -1;
    }
}
