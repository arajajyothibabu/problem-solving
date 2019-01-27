package graphs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/torque-and-development
 */
public class RoadsandLibraries {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nmC_libC_road = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmC_libC_road[0]);

        int m = Integer.parseInt(nmC_libC_road[1]);

        int c_lib = Integer.parseInt(nmC_libC_road[2]);

        int c_road = Integer.parseInt(nmC_libC_road[3]);

        int[][] cities = new int[m][2];

        for (int i = 0; i < m; i++) {
            String[] citiesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int citiesItem = Integer.parseInt(citiesRowItems[j]);
                cities[i][j] = citiesItem;
            }
        }

        long result = roadsAndLibraries(n, c_lib, c_road, cities);

        System.out.println(result);


        scanner.close();
    }

    static int DFS(int vertex, Graph graph, int[] visited){
        int nodes = 0;
        if(visited[vertex] == 0){
            nodes++;
            visited[vertex] = 1;
            LinkedList<Integer> adj = graph.getAdjacent(vertex);
            for(int v : adj){
                if(visited[v] == 0){
                    nodes += DFS(v, graph, visited);
                }
            }
        }
        return nodes;
    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_road >= c_lib){
            return n * (long) c_lib;
        }
        long cost = 0;
        Graph graph = new Graph(n);
        for(int[] pair : cities){
            graph.addEdge(pair[0] - 1, pair[1] - 1);
        }
        int[] visited = new int[n];
        int nodes;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                nodes = DFS(i, graph, visited);
                cost += (long) c_road * (nodes - 1);
                cost += (long) c_lib;
            }
        }
        return cost;
    }

}
