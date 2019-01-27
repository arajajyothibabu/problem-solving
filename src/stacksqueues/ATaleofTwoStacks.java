package stacksqueues;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 */
public class ATaleofTwoStacks {

    static class MyQueue<T> {
        Stack<T> lifo, fifo;
        public MyQueue() {
            this.lifo = new Stack<>();
            this.fifo = new Stack<>();
        }

        void enqueue(T el){
            this.lifo.push(el);
        }

        T peek(){
            prepareFIFO();
            return fifo.peek();
        }

        void dequeue(){
            prepareFIFO();
            fifo.pop();
        }

        void prepareFIFO(){
            if(fifo.empty()){
                while(!lifo.empty()){
                    fifo.push(lifo.pop());
                }
            }
        }

        void insertAtBottom(T el){
            if(fifo.empty()){
                fifo.push(el);
            }else{
                 T stEl = fifo.pop();
                 insertAtBottom(el);
                 fifo.push(stEl);
            }
        }

        void reverse(){
            if(!lifo.empty()){
                T el = lifo.pop();
                reverse();
                insertAtBottom(el);
            }
        }

        void print(){
            System.out.println(lifo);
            System.out.println(fifo);
        }

    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
            queue.print();
        }
        scan.close();
    }

}
