package Basic.Linear.Stack.Sequence;

/**
 * @Author : wick
 * @Date : 2024/10/18 15:01
 */
public class SeqStack {
    // 定义栈的元素数组
    private Object[] stackElem;

    // 定义栈顶指针
    private int top;

    // 构造函数，初始化栈的大小
    public SeqStack(int maxSize) {
        top = 0;
        stackElem = new Object[maxSize];
    }

    // 清空栈
    public void clear(){
        top = 0;
    }

    // 判断栈是否为空
    public boolean isEmpty(){
        return  top == 0;
    }

    // 返回栈的长度
    public int length(){
        return top;
    }

    // 返回栈顶元素
    public Object peek(){
        if(isEmpty()){
            return null;
        }
        //由于数组下标从0开始，所以需要减1才能得到正确的元素位置
        return stackElem[top - 1];
    }

    // 入栈
    public void push(Object obj){
        if(top == stackElem.length){
            throw new RuntimeException("栈已满");
        }
        //数据放入栈顶top，然后top再+1
        stackElem[top++] = obj;
    }

    // 出栈
    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        //top-1指向栈顶，然后返回栈顶元素
        return stackElem[--top];
    }

    // 打印栈中的元素
    public void display(){
        if(isEmpty()){
            System.out.println("栈为空");
        }
        for(int i = top -1; i>=0 ; i--){
            System.out.println(stackElem[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建一个栈，大小为5
        SeqStack seqStack = new SeqStack(5);
        // 入栈
        seqStack.push(1);
        seqStack.push(2);
        seqStack.push(3);
        seqStack.push(4);
        seqStack.push(5);
        // 打印栈中的元素
        seqStack.display();
        // 出栈
        seqStack.pop();
        // 打印栈中的元素
        seqStack.display();
    }
}








