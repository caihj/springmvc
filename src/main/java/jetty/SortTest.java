package jetty;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chj on 2016/4/6.
 */
public class SortTest {

    public static void main(String [] args)
    {

        List<Integer> a= Arrays.asList(1,2,3,4,5);

        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        System.out.println(a);

    }


}
