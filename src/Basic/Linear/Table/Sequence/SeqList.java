package Basic.Linear.Table.Sequence;

/**
 * @Author : wick
 * @Date : 2024/10/18 16:51
 */
public class SeqList {
    private Object[] listElem; // 存储顺序表元素的数组
    private int curLen; // 当前顺序表的长度

    // 构造函数，初始化顺序表，最大容量为 maxSize
    public SeqList(int maxSize) {
        curLen = 0; // 初始化长度为 0
        listElem = new Object[maxSize]; // 分配容量为 maxSize 的数组
    }

    // 清空顺序表，将长度置为 0
    public void clear() {
        curLen = 0;
    }

    // 判断顺序表是否为空
    public boolean isEmpty() {
        return curLen == 0; // 如果长度为 0，则为空
    }

    // 获取顺序表的长度
    public int length() {
        return curLen;
    }

    // 获取第 i 个元素的值
    public Object get(int i) {
        // 检查索引是否合法
        if (i < 0 || i > curLen - 1) {
            throw new RuntimeException("取值不合法");
        }
        return listElem[i]; // 返回指定位置的元素
    }

    // 查找元素 obj 在顺序表中的位置
    public int indexOf(Object obj) {
        int i = 0;
        // 遍历顺序表查找元素 obj
        while (i < curLen && !listElem[i].equals(obj)) {
            i++;
        }
        // 如果没有找到，抛出异常
        if (i >= curLen) {
            throw new RuntimeException("没有这个元素");
        }
        return i; // 返回元素位置
    }

    // 在顺序表中第 i 个位置插入元素
    public void insert(int i, Object obj) {
        // 检查顺序表是否已满
        if (curLen == listElem.length) {
            throw new RuntimeException("表满了");
        }
        // 检查插入位置是否合法
        if (i < 0 || i > curLen) {
            throw new RuntimeException("插入位置不合法");
        }
        // 从最后一个元素开始向后移动，腾出插入位置
        for (int j = curLen - 1; j >= i; j--) {
            listElem[j + 1] = listElem[j];
        }
        // 在第 i 个位置插入新元素
        listElem[i] = obj;
        curLen++; // 更新顺序表长度
    }

    // 删除顺序表中第 i 个位置的元素
    public void remove(int i) {
        // 检查删除位置是否合法
        if (i < 0 || i > curLen - 1) {
            throw new RuntimeException("删除位置不合法");
        }
        // 将第 i 个元素后的所有元素前移
        for (int j = i; j < curLen - 1; j++) {
            listElem[j] = listElem[j + 1];
        }
        curLen--; // 更新顺序表长度
    }

    public static void main(String[] args) {
        SeqList seqList = new SeqList(5); // 创建容量为 5 的顺序表
        seqList.insert(0, 1); // 在第 0 个位置插入 1
        seqList.insert(1, 2); // 在第 1 个位置插入 2
        seqList.insert(2, 3); // 在第 2 个位置插入 3
        seqList.insert(3, 4); // 在第 3 个位置插入 4
        seqList.insert(4, 5); // 在第 4 个位置插入 5
        seqList.remove(2); // 删除第 2 个位置的元素
        System.out.println(seqList.get(2)); // 输出当前第 2 个位置的元素 (应该是 4)
    }
}
