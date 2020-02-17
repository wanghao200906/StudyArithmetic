package DataStructure.DS_08_Heap.MaxHeap;


/**
 *  insert ， extractMax，replace 时间复杂度是 O(logn)
 *  heapify   时间复杂度是 O(n)
 * @param <Item>
 */
public class MaxHeap<Item extends Comparable<Item>> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity];
        count = 0;
        this.capacity = capacity;
    }

//heapify 将一个数组变成一个最大堆
    public MaxHeap(Item arr[]) {

        int n = arr.length;

        data = (Item[]) new Comparable[n];
        for (int i = 0; i < n; i++) {
            data[i] = arr[i];
        }

        count = n;

//     将一个随机数组变为最大堆。
//     从最后一个子节点的父节点开始。执行shiftDown。一直遍历执行知道节点为0
        for (int i = parent(count - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }


    public Item[] getItem() {
        return data;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item) {
        if (count >= capacity) {
            return;
        }
        data[count] = item;
        shiftUp(count);
        count++;
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
//    就是删除最大值。
    public Item extractMax() {
        if (count < 0) {
            return null;
        }
        Item ret = data[0];//返回堆的第一个值
        data[0] = null;//将第一个值清空
        swap(0, count - 1);//将最后一个元素放到堆的第一个位置
        count--;//count自减
        shiftDown(0);//让当前元素向下移动。形成最大堆

        return ret;
    }

    // 获取最大堆中的堆顶元素
    public Item getMax() {
        if (count <= 0) {
            return null;
        }
        return data[0];
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //取出最大元素，并插入一个元素
    public Item replace(Item item) {
        Item item1 = getMax();
        data[0] = item;
        shiftDown(0);
        return item1;
    }

    //********************
    //* 最大堆核心辅助函数
    //********************


    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
//    这个索引是从0开始的
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }


    private void shiftUp(int k) {

//        如果当前节点大于父节点。这当前节点和父节点交换位置。
        while (k > 0 && data[parent(k)].compareTo(data[k]) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }


    private void shiftDown(int k) {

        while (leftChild(k) < count) {
            //左节点
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            //如果左节点小于右节点，就让j++。此时j就是右节点的索引了
            if (j + 1 < size() && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            // data[j] 是 data[2*k+1]和data[2*k+2]中的最大值
            //如果k的值大于孩子的最大值，则退出循环，否则交换位置
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(4);
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
