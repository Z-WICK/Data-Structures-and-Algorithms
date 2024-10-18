package Basic.Linear.Queue.Sequence;

import static jdk.nashorn.internal.objects.annotations.SpecializedFunction.LinkLogic.isEmpty;

/**
 * @Author : wick
 * @Date : 2024/10/18 14:00
 */
public class SeqQueue {
    //存放队列元素的数组
    private Object[] queueArray;

    private int front;
    private int rear;

    private int maxSize;
    private int count;

    public SeqQueue(){
        this.maxSize = 10;
        this.queueArray = new Object[maxSize];
        front = rear = count =0;
    }

    public SeqQueue(int maxSize){
        this.maxSize = maxSize;
        this.queueArray = new Object[maxSize];
        front = rear = count =0;
    }

    public void clear() {
        front = rear = count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == maxSize;
    }

    public int length(){
        return count;
    }

    public Object peek(){
        if(isEmpty()){
            return null;
        }
        return queueArray[front];
    }

    public Object poll(){
    if(isEmpty()){
        return null;
    }
    Object obj = queueArray[front];
    front = (front+1)%maxSize;
    count--;
    return obj;
    }

    public void insert(Object obj){
        if(isFull()){
            return;
        }
        queueArray[rear] = obj;
        rear = (rear+1)%maxSize;
        count++;
    }


    public static void main(String[] args){
        SeqQueue seqQueue = new SeqQueue(10);
        seqQueue.insert(1);
        seqQueue.insert(1);
        seqQueue.insert(1);
        seqQueue.insert(1);
        seqQueue.insert(1);
        seqQueue.insert(1);
        seqQueue.insert(1);
        seqQueue.insert(1);

        System.out.println(seqQueue.length());
        System.out.println(seqQueue.isFull());
        System.out.println(seqQueue.peek());
        System.out.println(seqQueue.poll());
        System.out.println(seqQueue.peek());
        System.out.println(seqQueue.length());
     
        
        
    }


}







