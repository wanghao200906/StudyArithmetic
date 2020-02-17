package 其他算法.数组顺时针旋转90度;


// b[][] 中 b.length是行的数量。b[0].length 是列的数量
/*

思路： 把矩阵看成一个正方形。 找到左上角和右下角的两个点。看成是一个正方形。然后对他们进行旋转。



 */
public class Solution {
    public static void rotate(int[][] matrix) {
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        while (x1 < x2) {
            rotateEdge(matrix, x1++, y1++, x2--, y2--);
        }
    }

    public static void rotateEdge(int[][] m, int x1, int y1, int x2, int y2) {
        int times = y2 - y1;//比如一行有三个数，那么times就是2 。
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[x1][y1 + i];//旋转的第一个点。 然后剩下的就是找到其他点进行旋转。最后把temp赋值给第一行最后边的点。
            m[x1][y1 + i] = m[x2 - i][y1];//将第一个点变为第一列最后一行的点。
            m[x2 - i][y1] = m[x2][y2 - i];
            m[x2][y2 - i] = m[x1 + i][y2];
            m[x1 + i][y2] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }


}