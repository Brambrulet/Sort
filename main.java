package study.inno.sort;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Integer[] vArray = new Integer[]{13, 7, 9, 1, 5, 5, 67, 98, 45, 12, 56};

        System.out.println("Source array:");
        System.out.println(Arrays.toString(vArray));

        try {
            sort(vArray, new AssocSort(), "AssocSort result:");
            sort(vArray, new QuickSort(), "QuickSort result");
        } catch (Exception e) {
            System.out.println("Oh no ...");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private static void sort(Integer[] aArray, BaseSort aSort, String aComment) {
        Integer[] vTmp = aArray.clone();
        aSort.sort(vTmp);
        System.out.println(aComment);
        System.out.println(Arrays.toString(vTmp));
    }
}
