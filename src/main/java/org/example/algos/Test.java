package org.example.algos;

public class Test {

    public static void main(String[] args) {
        int[][] tab = new int[][]{{1, 2, 3}, {4, 12, 13}};
        int i = 0;
        while(i < tab.length) {
            int j = 0;
            while (j < tab[0].length) {
                System.out.print(tab[i][j] + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
