package search;

public class SwapNodes {

    class Node {
        Node left, right;
        int data;
        public Node(int data) {
            this.data = data;
        }

        void inOrder(Node node){
            if(node != null){
                inOrder(node.left);
                System.out.print(node.data);
                inOrder(node.right);
            }
        }

    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        for(int[] children : indexes){

        }
        return null;
    }

}
