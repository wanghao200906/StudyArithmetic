package forOffer;

/**
 * 题目：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 思路：
 * 这个题就是获取数组中最小的元素
 * <p>
 * 本题的一个简单算法就是从左到右遍历，由于是递增的，直到找到一个小的数就可以停止了
 * 但是这种方法速度相对太慢，所以可以采用二分法的思想
 * 采用二分法的思想，定义一个left和right逐步缩小范围，最终确定最小的数
 *
 *
 * <p>
 */
public class Test_06 {
    public static void main(String[] args) {
        int[] pre = {3, 4, 0, 1, 2, 3};

        System.out.println(minNumberInRotateArray(pre));
    }



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
}
