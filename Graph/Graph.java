package DSA.Graph;

import java.util.Random;
import java.util.Stack;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private boolean[][] adjMatrix;
    boolean[] visited;

    // empty graph with V vertices
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adjMatrix = new boolean[V][V];
        visited = new boolean[V];
    }

    // random graph with V vertices and E edges
    public Graph(int V, int E) {
        this(V);
        if (E > (long) V*(V-1)/2 + V) throw new IllegalArgumentException("Too many edges");
        if (E < 0)                    throw new IllegalArgumentException("Too few edges");
        Random random = new Random();

        // can be inefficient
        while (this.E != E) {
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            addEdge(u, v);
        }
        visited = new boolean[V];
    }
    // add undirected edge u-v
    public void addEdge(int u, int v) {
        if (!adjMatrix[u][v]) E++;
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;
    }

    // Refer this missing code from adjacenet matrix representation section

    public void DFS(){
        // Visit nodes using a Stack to store "to visit" nodes
        Stack<Integer> s = new Stack<Integer>();  // Create a stack
//      boolean[] visited= {false};  // Set all visited[i] = 0
        s.push(0);            // Start the "to visit" at node 0

        /* ===========================================
        Loop as long as there are "active" node
        =========================================== */
        while( !s.isEmpty() ){
            int nextNode;                // Next node to visit
            int i;

            nextNode = s.pop();

            if ( ! visited[nextNode] ){
                visited[nextNode] = true;    // Mark node as visited
                System.out.println("nextNode = " + nextNode );

                for ( i = 0; i < V; i++ )
//                    for ( i = V-1; i >= 0 ; i-- )
//                    {
                        if ( (adjMatrix[nextNode][i] == true) && !visited[i] )
                            s.push(i);
//                    }
            }
        }
    }
    public static void main(String[] args) {    //test code

        int V = 5;
        int E = 6;
        Graph G = new Graph(V, E);
        System.out.println(G.toString());
        G.DFS();
    }
}