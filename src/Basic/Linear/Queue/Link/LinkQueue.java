package Basic.Linear.Queue.Link;

import Basic.Linear.Node.Node;

/**
 * @Author : wick
 * @Date : 2024/10/18 13:39
 */
public class LinkQueue {
    //定义队列头节点
    private Node front;
    //定义队列尾节点
    private Node rear;

    //构造函数，初始化队列头节点和尾节点为null
    public LinkQueue() {
        front = rear = null;
    }

    //清空队列，将队列头节点和尾节点置为null
    public void clear(){
        front = rear = null;
    }

    //判断队列是否为空，如果队列头节点为null，则队列为空
    public boolean isEmpty(){
        return front == null;
    }

    //计算队列长度，遍历队列，统计节点个数
    public int length(){
        Node p = front;
        int length = 0;

        while(p!=null){
            p = p.next;
            ++length;
        }
        return length;
    }

    //取队首元素，如果队列为空，则返回null
    public Object peek(){
        if(isEmpty()) {
            return null;
        }
        return front.data;
    }

    //删除队首元素，如果队列为空，则返回null
    public Object poll(){
        if(isEmpty()){
            return null;
        }
        Node p = front;
        front = front.next;
        if(p == rear) {
            rear = null;
        }
        return p.data;

    }

    //在队尾插入元素（入队），如果队列为空，则将队首和队尾节点都指向新节点；否则，将队尾节点的next指向新节点，并将队尾节点指向新节点
    public void insert(Object obj){
        Node p = new Node(obj);
        if(isEmpty()){
            front = rear = p;
        } else {
            rear.next = p;
            rear = p;
        }
    }
}



