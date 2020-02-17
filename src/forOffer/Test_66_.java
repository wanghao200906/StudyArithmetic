package forOffer;

/**
 * 题目：
 * 地上有个m行n列的方格。
 * 一个机器人从坐标(0,0)的格子开始移动，它每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 举例分析
 * <p>
 * 例如，当k为18时，机器人能够进入方格(35,37)，因为3+5+3+7=18.但它不能进入方格(35,38)，
 * 因为3+5+3+8=19.请问该机器人能够达到多少格子？
 * <p>
 * 思路：
 * 这个方格也可以看出一个m*n的矩阵。同样在这个矩阵中，除边界上的格子之外其他格子都有四个相邻的格子。
 * <p>
 * 机器人从坐标(0,0)开始移动。当它准备进入坐标为(i,j)的格子时，通过检查坐标的数位和来判断机器人是否能够进入。
 * 如果机器人能够进入坐标为(i,j)的格子，我们接着再判断它能否进入四个相邻的格子(i,j-1)、(i-1,j),(i,j+1)和(i+1,j)。
 */

public class Test_66_ {

    public int movingCount(int threshold, int rows, int cols)
    {
        //根据m行n列的方格，构造一个数组来标识是否已经判断过，已经判断过的话置为true，否则置为false
        //这里初始化默认是false
        boolean[][] flag = new boolean[rows][cols];
        //下面开始走，边走边判断周围是否符合
        //judge(初始横坐标i，初始横坐标j，行数，列数，k值，标识是否走过)
        return judge(0,0,rows,cols,threshold,flag);
    }

    private int judge(int i,int j,int rows,int cols,int threshold,boolean[][] flag){
        //越界、flsg=true说明已经走过，就不要再走了、行坐标和列坐标的数位之和大于k也跳过
        if(i<0 || j<0 || i>=rows || j>=cols || flag[i][j]==true || getK(i)+getK(j)>threshold)
            return 0;
        //机器人从[0,0]出发，必定是满足的，先置为true,所以要先加个1
        flag[i][j] = true;
        //基于回溯的思想，就是到达一个格子后，不断地判断他的周围四个格子是否满足要求，递归判断下去，必定走遍所有格子
        return judge(i-1,j,rows,cols,threshold,flag)+
                judge(i,j-1,rows,cols,threshold,flag)+
                judge(i+1,j,rows,cols,threshold,flag)+
                judge(i,j+1,rows,cols,threshold,flag)+1;
    }
    //计算数字每一位之和
    private int getK(int num){
        int sum = 0;
        do{
            sum += num%10;
        }while((num=num/10) > 0);
        return sum;
    }
}

