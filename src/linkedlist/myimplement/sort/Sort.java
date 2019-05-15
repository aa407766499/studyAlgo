package linkedlist.myimplement.sort;

/**
 * Created by Huzi on 2019/5/13.
 */
public class Sort {

    /**
     * bubbleSort
     * 思想：左边是未排序区间，右边是已排序区间，每次冒泡取未排序区间的最大值放在已排序区间的开头
     * 实现：不是完全顺着字面意思写
     * @param a 需要排序的数组
     * @param n 数组长度
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 控制冒泡操作的次数
        for (int i = 0; i < n; i++) {
            //未交换标志
            boolean flag = false;
            //冒泡操作
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            //未发生交换
            if (!flag) {
                break;
            }
        }
    }

    /**
     * insertSort
     *
     * @param a
     * @param n
     */
    public void insertSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 未排序区间,从第二个元素开始,取未排序区间的第一个元素
        for (int i = 1; i < n; i++) {
            int value = a[i];
            //已排序区间，从后往前遍历，找插入位置
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //找到插入位置，插入数据
            a[j + 1] = value;
        }
    }

    /**
     * optionSort
     * 思想：右边是未排序区间，左边是已排序区间，每次取未排序区间的最小值放在已排序区间的末尾
     * 实现：不是完全顺着字面意思写
     * @param a
     * @param n
     */
    public void optionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        //控制选择操作的次数
        for (int i = 0; i < n; i++) {
            //选择操作
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {5, 7, 3, 4, 9};
        sort.bubbleSort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
