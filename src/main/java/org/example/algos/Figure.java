package org.example.algos;

public class Figure {

    public static void losange(int base, int spaces)
    {
        int mid = base / 2 + 1;
        for (int i = 1; i <= base; i++)
        {
            int nbSpaces = Math.abs(mid - i);
            int nbChars = base - 2 * nbSpaces;
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = 0; j < nbSpaces; j++) System.out.print(" ");
            for (int j = 0; j < nbChars; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void carre(int cote) {
        for (int i = 0; i < cote; i++) {
            for (int j = 0; j < cote; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void cross(int base) {
        assert base % 2 == 1 : "Base shall be odd";
        int mid = base / 2;
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < base; j++) {
                if (i == mid || j == mid || i == j || i + j == base - 1)
                    System.out.print("*\t");
                else
                    System.out.print(" \t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //cross(9);
        losange(7, 0);
    }

}
