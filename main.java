package study.inno.sort;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        int vArray[] = new int[]{13, 7, 9, 1, 5, 5, 67, 98, 45, 12, 56};

        BaseSort vSort = new AssocSort();

        vSort.sort(vArray);

        System.out.println(Arrays.toString(vArray));

    }
}
