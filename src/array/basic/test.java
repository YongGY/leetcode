package array.basic;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);

        for(int i = 1; i < numRows; i++){
            List<Integer> list3 = new ArrayList<>();
            list3.add(1);
            for(int j = 1; j < i; j++){
                list3.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            list3.add(1);
            res.add(list3);
        }
        return res;

    }
    
    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }

}
