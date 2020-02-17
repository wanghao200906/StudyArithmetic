package forOffer;

/**
 * 题目：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 思路：
 * <p>
 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束。
 * <p>
 * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
 * <p>
 * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
 */
public class Test_01 {

    public static void main(String[] args) {
//        注意二维数组的写法。经常会忘记
        int[][] arr = {
                {2, 3, 6},
                {4, 5, 5},
        };
        System.out.println(find(arr, 4));

    }


    public static boolean find(int[][] array, int num) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }

//        System.out.println(array.length);
//        System.out.println(array[0].length);

        int rows = array.length;
        int cols = array[0].length;

        int row = 0;
        int col = cols - 1;

        while (row >= 0 && row < rows && col < cols && col >= 0) {
            if (array[row][col] == num) {
                System.out.println("row:"+row);
                System.out.println("col:"+col);
                return true;
            } else if (array[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
