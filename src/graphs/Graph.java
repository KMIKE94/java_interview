package graphs;

import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    public static void main(String args[]) {
        Graph graph = new Graph();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.adjacencyList.add(n2);
        n1.adjacencyList.add(n3);
        n2.adjacencyList.add(n4);
        n3.adjacencyList.add(n5);

        System.out.println(dfs(n1,n5));
    }

    private void printGraph(Graph graph) {
        
    }

    private static boolean dfs(Node source, Node destination) {
        HashSet<Integer> visited = new HashSet<>();
        return recursiveDFS(source, destination, visited);
    }

    private static boolean recursiveDFS(Node s, Node d, HashSet<Integer> visited) {
        System.out.println("Visiting: " + s.id);
        if(visited.contains(s.id)) {
            return false;
        }

        visited.add(s.id);
        if(s == d) {
            return true;
        }

        for(Node child : s.adjacencyList){
            if(recursiveDFS(child, d, visited)) {
                return true;
            }
        }

        return false;
    }

    public static class Node {
        int id;
        LinkedList<Node> adjacencyList = new LinkedList<>();

        public Node(int id) {
            this.id = id;
        }

        private void addEdge(int source, int destination) {
            Node s = new Node(source);
            Node d = new Node(destination);
            s.adjacencyList.add(d);
        }
    }


}

