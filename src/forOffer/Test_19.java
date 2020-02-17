package forOffer;

import java.util.ArrayList;
import java.util.List;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

思路： 把矩阵看成一个正方形。 找到左上角和右下角的两个点。看成是一个正方形。然后转圈打印。

 */
public class Test_19 {
    public static void spiralOrderPrint(int[][] matrix) {
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        List<Integer> list=new ArrayList<>();
        while (x1 <= x2 && y1 <= y2) {
            printEdge(matrix, x1++, y1++, x2--, y2--,list);//从外到内逐层打印。
        }
        System.out.println(list);
    }

    public static void printEdge(int[][] m, int x1, int y1, int x2, int y2, List<Integer> list) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                System.out.print(m[x1][i] + " ");
                list.add(m[x1][i]);
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                System.out.print(m[i][y1] + " ");
                list.add(m[i][y1]);
            }
        } else {
            int x = x1;
            int y = y1;
            while (y != y2) {
                System.out.print(m[x1][y] + " ");
                list.add(m[x1][y]);
                y++;
            }
            while (x != x2) {
                System.out.print(m[x][y2] + " ");
                list.add(m[x][y2]);

                x++;
            }
            while (y != y1) {
                System.out.print(m[x2][y] + " ");
                list.add(m[x2][y]);

                y--;
            }
            while (x != x1) {
                System.out.print(m[x][y1] + " ");
                list.add(m[x][y1]);

                x--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }


}
