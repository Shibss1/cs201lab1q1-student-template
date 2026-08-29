import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static Integer findMax(Integer[] input) {
        Integer biggest = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > biggest) {
                biggest = input[i];
            }
        }

        return biggest;
    }

    public static Integer[] findDuplicates(Integer[] input) {
        Set<Integer> seen = new HashSet<>();
        ArrayList<Integer> dupes = new ArrayList<>();

        for (int num : input) {
            if (!seen.add(num)) {
                dupes.add(num);
            }
        }

        return dupes.toArray(new Integer[dupes.size()]);
    }

    public static Integer[] findUnique(Integer[] input) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : input) {
            if (count.get(num) == null) {
                count.put(num, 1);
            } 
            else {
                count.put(num, count.get(num) + 1);
            }
        }

        List<Integer> unique = new ArrayList<>();
        for (int key : count.keySet()) {
            int num = count.get(key);
            if (num == 1) {
                unique.add(key);
            }
        }

        return unique.toArray(new Integer[unique.size()]);
    }
}