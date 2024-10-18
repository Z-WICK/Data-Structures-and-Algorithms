package Basic.Linear.Stack.Link;

import Basic.Linear.Node.Node;

/**
 * @Author : wick
 * @Date : 2024/10/18 14:48
 */
public class LinkStack {
    // 定义栈顶指针
    private Node top;

    // 构造函数，初始化栈顶指针为null
    public LinkStack(){
        top =null;
    }

    // 清空栈，将栈顶指针置为null
    public void clear(){
        top = null;
    }

    // 判断栈是否为空，如果栈顶指针为null，则返回true，否则返回false
    public boolean isEmpty(){
        return top == null;
    }


    // 返回栈的长度，遍历栈顶指针，计数器加1，直到栈顶指针为null
    public int length(){
        Node p = top;
        int len = 0;
        while(p != null){
            p = p.next;
            ++len;
        }
        return len;
    }

    // 返回栈顶元素，如果栈为空，则返回null
    public Object peek(){
        if(isEmpty()){
            return null;
        }
        return top.data;
    }

    // 入栈，创建新节点，将新节点的next指针指向栈顶指针，将栈顶指针指向新节点
    public void push(Object obj){
        Node p = new Node(obj);
        p.next = top;
        top = p;
    }

    // 出栈，返回栈顶元素，将栈顶指针指向下一个节点
    public Object pop(){
        if(isEmpty()){
            return null;
        }
        Object data = top.data;
        top = top.next;
        return data;
    }

    // 遍历栈顶指针，输出栈中元素
    public void display(){
        Node p = top;
        while (p!=null){
            System.out.println(p.data+ " ");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 创建链栈对象
        LinkStack linkStack = new LinkStack();
        // 入栈
        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        // 输出栈中元素
        linkStack.display();
        // 出栈
        System.out.println(linkStack.pop());
        // 输出栈中元素
        linkStack.display();
    }

}