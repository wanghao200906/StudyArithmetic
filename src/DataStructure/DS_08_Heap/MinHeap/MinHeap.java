package DataStructure.DS_08_Heap.MinHeap;

// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MinHeap<Item extends Comparable<Item>> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity];
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最小堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MinHeap(Item arr[]) {

        int n = arr.length;

        data = (Item[]) new Comparable[n];
        capacity = n;

        for (int i = 0; i < n; i++)
            data[i] = arr[i];
        count = n;

        for (int i = (count-1) / 2; i >= 0; i--)
            shiftDown(i);
    }

    public Item[] getItem() {
        return data;
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最小堆中插入一个新的元素 item
    public void insert(Item item) {
        if (count >= capacity) {
            return;
        }

        data[count] = item;
        shiftUp(count);
        count++;
    }

    // 从最小堆中取出堆顶元素, 即堆中所存储的最小数据
    public Item extractMin() {
        if (count < 0) {
            return null;
        }
        Item ret = data[0];

        swap(0, count);
        count--;
        shiftDown(0);

        return ret;
    }


    // 获取最小堆中的堆顶元素
    public Item getMin() {
        assert (count > 0);
        return data[1];
    }


    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //********************
    //* 最小堆核心辅助函数
    //********************
    private void shiftUp(int k) {

        while (k > 0 && data[(k - 1) / 2].compareTo(data[k]) > 0) {
            swap(k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private void shiftDown(int k) {

        while ((2 * k + 1) <= count) {
            int j = 2 * k + 1; // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0)
                j++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最小值

            if (data[k].compareTo(data[j]) <= 0) break;
            swap(k, j);
            k = j;
        }
    }


    // 测试 MinHeap
    public static void main(String[] args) {


        MinHeap<Integer> maxHeap = new MinHeap<Integer>(4);
        Integer[] item = {2, 3, 4, 1, 9};
        for (int i = 0; i < item.length; i++)
            maxHeap.insert(item[i]);


//        System.out.println("--" + maxHeap.extractMax());

//
//
//        Integer[] item = {2, 3, 4, 1};
//        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(4);
//
        Comparable[] item1 = maxHeap.getItem();

        for (int i = 0; i < item1.length; i++)
            System.out.println(item1[i]);

    }
}