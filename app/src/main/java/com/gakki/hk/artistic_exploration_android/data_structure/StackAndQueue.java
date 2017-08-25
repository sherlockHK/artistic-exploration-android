package com.gakki.hk.artistic_exploration_android.data_structure;

/**
 * Created by HK on 2017/8/25.
 * Email: kaihu1989@gmail.com.
 */

public class StackAndQueue {

    /**
     * 栈：只能在头部插入和删除的线性表
     * */
    public static class Stack{
        LinkedList.Node first; //栈顶元素
        int length;

        public Stack() {
            this.first = new LinkedList.Node(1, null);
            length = 1;
        }

        public void push(int data){
            LinkedList.Node newNode = new LinkedList.Node(data, this.first);
            first = newNode;

            length++;
        }

        public int pop() throws Exception {
            if (length == 0){
                throw new Exception("length is 0");
            }

            LinkedList.Node f = first;
            first = first.next;
            length--;
            return f.data;
        }
    }

    /**
     * 队列：只能在一端插入，另一端删除的线性表
     * */
    public static class Queue{
        LinkedList.Node front, rear;
        int length;

        public Queue() {
            front = rear = new LinkedList.Node(1, null);
            length = 1;
        }

        //从尾部入队列
        public void enqueue(int data){
            LinkedList.Node newNode = new LinkedList.Node(data, null);
            rear.next = newNode;
            rear = newNode;

            length++;
        }

        public int dequeue(){
            int data = front.data;
            LinkedList.Node next =front.next;
            front = next;

            length--;
            return data;
        }
    }

}
