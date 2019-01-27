package graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-the-nearest-clone
 */
public class FindTheNearestClone {

    static class Node {
        int d;
        int startedFrom;
        int weight;

        public Node(int d) {
            this.d = d;
        }

        public int getStartedFrom() {
            return startedFrom;
        }

        public void setStartedFrom(int startedFrom) {
            this.startedFrom = startedFrom;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    static class Graph {

        int vertices;

        private LinkedList<Integer> adjacencyList[];

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new LinkedList[vertices];
            for(int i = 0; i < vertices; i++){
                this.adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int start, int end){
            this.adjacencyList[start].add(end);
            this.adjacencyList[end].add(start);
        }

        LinkedList<Integer> getAdjacent(int vertex){
            return adjacencyList[vertex];
        }

        void print(){
            for(int i = 0; i < this.vertices; i++){
                System.out.print(i + " : ");
                System.out.println(this.adjacencyList[i]);
            }
        }

    }

    static int searchForColor(int node, Graph graph, int color, ArrayList<Integer> visited, long[] ids){
        //System.out.println("Came to Search " + node);
        //System.out.println(visited);
        int min = graph.vertices, tempMin;
        if(!visited.contains(node)){
            visited.add(node);
            LinkedList<Integer> adj = graph.getAdjacent(node);
            for(int vertex : adj){
                //System.out.println("Adjacent check " + vertex);
                if(ids[vertex] == color && !visited.contains(vertex)){
                    return 1;
                }
                tempMin = 1 + searchForColor(vertex, graph, color, new ArrayList<>(visited), ids);
                //System.out.println("min: " + tempMin);
                if(min > tempMin){
                    min = tempMin;
                }
            }
        }
        return min;
    }

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        int minDist = graphNodes, tempMin;
        Graph graph = new Graph(graphNodes);
        for(int i = 0; i < graphFrom.length; i++){
            graph.addEdge(graphFrom[i] - 1, graphTo[i] - 1);
        }
        //graph.print();
        for(int i = 0; i < graphNodes; i++){
            if(ids[i] == val){
                //System.out.println("Searching start for " + i);
                ArrayList<Integer> visited = new ArrayList<>();
                tempMin = searchForColor(i, graph, val, visited, ids);
                if(tempMin == 1) return tempMin;
                if(minDist > tempMin){
                    minDist = tempMin;
                }
            }
        }
        return minDist == graphNodes ? -1 : minDist;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        System.out.println(ans);

        scanner.close();
    }

}
