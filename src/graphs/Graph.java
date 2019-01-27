package graphs;

import java.util.LinkedList;

public class Graph {

    private int vertices;

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
