package arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

public class Main {

    public static SinglyLinkedListNode distinct(SinglyLinkedListNode head) {
        // Write your code here
        HashSet<Integer> nodeSet = new HashSet<Integer>();
        SinglyLinkedListNode temp = head, previous = null;
        while (temp != null){
            if(!nodeSet.contains(temp.data)){
                nodeSet.add(temp.data);
                if(previous != null){
                    previous.next = temp;
                    previous = previous.next;
                }else{
                    previous = temp;
                }
            }else{
                previous.next = temp.next;
            }
            temp = temp.next;
        }
        return head;

    }

    static Boolean isValidBST(Integer[] preOrderTreeNodes){
        Stack<Integer> stack = new Stack<Integer>();
        Integer root = -1;
        for(int i = 0; i < preOrderTreeNodes.length; i++){
            if(preOrderTreeNodes[i] < root){
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < preOrderTreeNodes[i]){
                root = stack.peek();
                stack.pop();
            }
            stack.push(preOrderTreeNodes[i]);
        }
        return true;
    }

    static void readInput(){
        Scanner in = new Scanner(System.in);
        Integer testCases = in.nextInt();
        for(Integer i = 0; i < testCases; i++){
            Integer numberOfNodes = in.nextInt();
            Integer[] preOrderTreeNodes = new Integer[numberOfNodes];
            for(Integer j = 0; j < numberOfNodes; j++){
                preOrderTreeNodes[j] = in.nextInt();
            }
            if(isValidBST(preOrderTreeNodes)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("Problems on Arrays");
    }

}
