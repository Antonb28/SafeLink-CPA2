package org.openjfx;

public class MyQueue {
    private int front = 0;
    private int back = 0;
    private int size = 1;
    private Object[] queue;

    public MyQueue(int size){
        this.queue = new Object[size];
    }

    public void push(Object item){
        if(back == size && front == 0){
            System.out.println("Queue Overflow!");
        }

        else if(back==size-1 && front>0){
            back = 0;
            queue[back] = item;
            back++;
            size--;
        }

        else {
            queue[back]= item;
            back++;
            size++;
        }
    }

    public boolean empty(){
        return front == back;
    }

    public void pop(){
        if(empty()){
            System.out.println("Queue Underflow");
        }

        else if(front == size && back >=0) {
            queue[front] = null;
            front = 0;
            size--;
        }

        else {
            queue[front] = null;
            front = 0;
            size--;
        }
    }

    public Object front(){
        return queue[front];
    }

    public Object back(){
        return queue[back-1];
    }

    public int size(){
        return  size;
    }

}
