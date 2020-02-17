package 算法的总结;


import java.util.*;

// 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
// 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 动态规划
//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

//给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 输入n个整数，找出其中最小的k个数。
//    输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
// 统计一个数字：在排序数组中出现的次数。

public class Array {


    //    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    public int getElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }

    public int getElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = 0, maxCount = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > maxCount) {
                maxCount = count;
                maxNum = num;
            }
        }
        return maxNum;
    }

    // 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 动态规划
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int min[] = new int[row + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                min[i] = Math.min(min[i], min[i + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }

    //在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


    public static boolean find(int[][] array, int num) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }

        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
        while (col >= 0 && col <= cols - 1 && row >= 0 && row <= rows - 1) {
            int n = array[row][col];
            if (n == num) {
                return true;
            } else if (n > num) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
//    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。


    public static int minNumberInRotateArray(int[] array) {
        //定义左边界
        int left = 0;
        //定义右边界
        int right = array.length - 1;
        //当左小于右的时候，说明范围还未缩小完毕
        while (left < right) {
            //定义中间值
            int mid = (left + right) / 2;
            //如果大于的话，说明最小值在右面，更新左边界值
            if (array[mid] > array[right]) {
                left = mid + 1;
                //判断是否等于，等于的话很难判断，只能让right减一，继续遍历
            } else if (array[mid] == array[right]) {
                right = right - 1;
            } else
            //下面是小于的情况，更新右边界值
            {
                right = mid;
            }
        }
        //最后这个位置返回right，left都是可以的
        return array[right];
    }


//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

    public static void spiralOrderPrint(int[][] matrix) {
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (x1 <= x2 && y1 <= y2) {
            printEdge(matrix, x1++, y1++, x2--, y2--, list);//从外到内逐层打印。
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

    //    给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        //存放当前窗口中最大值
        ArrayList<Integer> res = new ArrayList<>();
        //队列的头部存放的是当前窗口最大值
        LinkedList<Integer> queue = new LinkedList<>();
        if(num == null || num.length <= 0 || size <= 0){
            return res;
        }

        for(int i=0;i<num.length;i++){
            //比如当前数据比队尾的数字大，说明当前这个数字最起码在从现在起到后面的过程中可能是最大值
            //而之前队尾的数字不可能最大了，所以要删除队尾元素。
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]){
                queue.pollLast();
            }
            queue.add(i);
            //队头的元素是否超过窗口的范围
            if(queue.peekFirst() == i-size){
                queue.pollFirst();
            }
            //在包含了三个元素之后才开始记录，其中最大值就在队列的头部
            if(i >= size - 1){
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }

    //    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    public int MoreThanHalfNum_Solution(int[] array) {
        //由于全是数字，大小为10就足够了
        int[] bucket = new int[10];
        //遍历原数组，时间复杂度为O(n)
        for (int i = 0; i < array.length; i++) {
            //将对应索引加1
            bucket[array[i]]++;
            //找到了就停止
            if (bucket[array[i]] > array.length / 2) {
                return array[i];
            }
        }
        //找不到
        return 0;
    }

// 输入n个整数，找出其中最小的k个数。

    public static ArrayList<Integer> action(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            list.add(queue.remove());
        }
        return list;
    }

    //    输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
    public int FindGreatestSumOfSubArray(int[] arr) {
        // 参数校验
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("DS_01_Array must contain an element");
        }

        // 记录最大的子数组和，开始时是最小的整数
        int max = Integer.MIN_VALUE;
        // 当前的和
        int curMax = 0;
        // 数组遍历
        for (int i : arr) {
            // 如果当前和小于等于0，就重新设置当前和
            if (curMax <= 0) {
                curMax = i;
            }
            // 如果当前和大于0，累加当前和
            else {
                curMax += i;
            }

            // 更新记录到的最在的子数组和
            if (max < curMax) {
                max = curMax;
            }
        }


        return max;
    }

// 统计一个数字：在排序数组中出现的次数。


    public static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if (data != null && data.length > 0) {
            int first = getFirstK(data, k, 0, data.length - 1);
            int last = getLastK(data, k, 0, data.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
    }

    /**
     * 找排序数组中k第一次出现的位置
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getFirstK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx > 0 && data[midIdx - 1] != k || midIdx == 0) {
                return midIdx;
            } else {
                end = midIdx - 1;
            }
        } else if (midData > k) {
            end = midIdx - 1;
        } else {
            start = midIdx + 1;
        }

        return getFirstK(data, k, start, end);
    }

    /**
     * 找排序数组中k最后一次出现的位置
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx + 1 < data.length && data[midIdx + 1] != k || midIdx == data.length - 1) {
                return midIdx;
            } else {
                start = midIdx + 1;
            }
        } else if (midData < k) {
            start = midIdx + 1;
        } else {
            end = midIdx - 1;
        }

        return getLastK(data, k, start, end);
    }
}
