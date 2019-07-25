package myimpl.stack;

public class ArrayStack {
    /**
     * 顺序栈
     */
    private String[] array;
    /**
     * 栈的容量
     */
    private int n;
    /**
     * 栈中的元素个数
     */
    private int count;

    public ArrayStack() {
        array = new String[10];
        this.n = array.length;
        this.count = 0;
    }

    /**
     * 入栈
     */
    public boolean push(String data) {
        if (count == n) {
            System.out.println("栈满了");
            return false;
        }
        array[count] = data;
        count++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String  pop() {
        if (count == 0) {
            System.out.println("栈中无数据");
            return null;
        }
        return array[--count];
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        for (int i = 0; i < stack.getCount(); i++) {
            System.out.println(stack.getArray()[i]);
        }
        String data = stack.pop();
        System.out.println(data);
    }
}
