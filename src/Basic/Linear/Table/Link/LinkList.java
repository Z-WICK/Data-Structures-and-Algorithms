package Basic.Linear.Table.Link;

import Basic.Linear.Node.Node;

/**
 * @Author : wick
 * @Date : 2024/10/18 15:30
 */
public class LinkList {
    public Node head; // 链表的头节点

    // 无参构造函数，初始化头节点
    public LinkList() {
        head = new Node();
    }

    // 将链表清空
    public void clear() {
        head.data = null;
        head.next = null;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 求链表的长度
    public int length() {
        Node p = head.next; // 从首节点开始
        int len = 0; // 记录长度
        // 遍历链表直到末尾
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }

    // 获取链表中第 i 个节点的值
    public Object get(int i) {
        Node p = head.next; // 从首节点开始
        int j = 0; // 记录当前节点的位置
        // 查找第 i 个节点
        while (p != null && j < i) {
            p = p.next;
            j++;
        }
        // 如果没有找到或超过范围，抛出异常
        if (j > i || p == null) {
            throw new RuntimeException("查找失败");
        }
        return p.data; // 返回第 i 个节点的数据
    }

    // 查找元素 obj 在链表中的位置
    public int indexOf(Object obj) {
        Node p = head.next; // 从首节点开始
        int j = 0; // 记录节点索引
        // 遍历链表查找 obj
        while (p != null && !p.data.equals(obj)) {
            p = p.next;
            j++;
        }
        // 如果没找到，返回 -1
        if (p == null) {
            return -1;
        }
        return j; // 返回 obj 的索引
    }

    // 在第 i 个节点之前插入元素
    public void insert(int i, Object obj) {
        Node p = head; // 从头节点开始
        int j = -1; // 记录位置
        // 查找插入位置的前一个节点
        while (p != null && j < i - 1) {
            p = p.next;
            j++;
        }
        // 如果位置不对或节点不存在，抛出异常
        if (j > i - 1 && p == null) {
            throw new RuntimeException("插入失败");
        }
        Node s = new Node(obj); // 创建新节点
        s.next = p.next; // 将新节点的 next 指向当前节点的 next
        p.next = s; // 将当前节点的 next 指向新节点
    }

    // 在链表头部插入元素
    public void startAdd(Object obj) {
        insert(0, obj);
    }

    // 在链表尾部插入元素
    public void endAdd(Object obj) {
        insert(length(), obj);
    }

    // 默认在尾部添加元素
    public void add(Object obj) {
        insert(length(), obj);
    }

    // 删除第 i 个节点
    public Object remove(int i) {
        Node p = head; // 从头节点开始
        int j = -1; // 记录位置
        // 查找要删除节点的前一个节点
        while (p != null && j < i - 1) {
            p = p.next;
            j++;
        }
        // 如果位置不对或节点不存在，抛出异常
        if (p == null && j > i - 1) {
            throw new RuntimeException("删除失败");
        }
        Node q = p.next; // 要删除的节点
        p.next = p.next.next; // 删除节点 q
        return q.data; // 返回被删除节点的数据
    }

    // 删除链表中的重复元素
    public void removeRepeatElem() {
        Node p = head.next; // 从首节点开始
        // 遍历链表
        while (p != null) {
            int index = indexOf(p.data); // 记录当前节点的位置
            Node q = p.next; // 下一个节点
            // 遍历剩余节点，查找重复元素
            while (q != null) {
                if (p.data.equals(q.data)) {
                    remove(index + 1); // 删除重复元素
                } else {
                    index++; // 更新索引
                }
                q = q.next; // 移动到下一个节点
            }
            p = p.next; // 移动到下一个节点
        }
    }

    // 显示链表中的所有元素
    public void display() {
        Node node = head.next; // 从首节点开始
        // 遍历链表
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
        System.out.println(); // 换行
    }

    public static void main(String[] args) {
        LinkList list = new LinkList(); // 创建链表
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.display(); // 显示链表元素
        list.removeRepeatElem(); // 删除重复元素
        list.display(); // 再次显示链表元素
    }
}
