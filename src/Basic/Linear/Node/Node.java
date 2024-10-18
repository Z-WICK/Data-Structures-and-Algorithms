package Basic.Linear.Node;

/**
 * @Author : wick
 * @Date : 2024/10/18 12:45
 */
public class Node {
    // 定义数据域
    public Object data;
    // 定义下一个节点的引用
    public Node next;

    // 无参构造方法，初始化数据域和下一个节点引用为null
    public Node(){
        this.data = null;
        this.next = null;
    }

    // 有参构造方法，初始化数据域
    public Node(Object data){
        this.data = data;
    }

    // 有参构造方法，初始化数据域和下一个节点引用
    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}

