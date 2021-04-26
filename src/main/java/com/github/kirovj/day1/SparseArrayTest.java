package com.github.kirovj.day1;

public class SparseArrayTest {

    static int[][] toSparseArr() {
        int[][] arr = new int[11][11];
        arr[3][5] = 3;
        arr[6][4] = 13;
        arr[9][9] = 5;

        int valueNum = 0;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    valueNum += 1;
                }
            }
        }

        int[][] sparseArr = new int[valueNum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = valueNum;
        int line = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int v = arr[i][j];
                if (v != 0) {
                    sparseArr[line][0] = i;
                    sparseArr[line][1] = j;
                    sparseArr[line][2] = v;
                    line++;
                }
            }
        }

        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\n", ints[0], ints[1], ints[2]);
        }
        return sparseArr;
    }

    static void toCommonArr(int[][] sparseArr) {
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] arr = new int[row][col];
        for (int i = 1; i < sparseArr.length; i++) {
            int x = sparseArr[i][0];
            int y = sparseArr[i][1];
            int v = sparseArr[i][2];
            arr[x][y] = v;
        }
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d\t", ints[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sparseArr = toSparseArr();
        toCommonArr(sparseArr);
    }
}
