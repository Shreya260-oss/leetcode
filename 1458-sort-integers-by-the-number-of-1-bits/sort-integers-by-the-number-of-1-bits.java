import java.util.*;

class Solution {

    public int[] sortByBits(int[] arr) {

        Integer[] temp = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {

                int bitsA = Integer.bitCount(a);
                int bitsB = Integer.bitCount(b);

                if (bitsA != bitsB) {
                    return bitsA - bitsB;
                }

                return a - b;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}