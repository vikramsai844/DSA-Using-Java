package DSA.Graph;

import java.util.*;
public class GraphBFS {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private boolean[][] adjMatrix;
    boolean[] visited;

    // empty graph with V vertices
    public GraphBFS(int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adjMatrix = new boolean[V][V];
        visited = new boolean[V];
    }

    // random graph with V vertices and E edges
    public GraphBFS(int V, int E) {
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

    public void BFS(){
        // BFS uses Queue data structure
        Queue<Integer> q = new LinkedList<Integer>();
//        clearVisited();
        q.add(0);            // Start the "to visit" at node 0


/* ===========================================
Loop as long as there are "active" node
=========================================== */
        while( !q.isEmpty() ) {
            int nextNode;
// Next node to visit
            int i;
            nextNode = q.remove();
            if ( ! visited[nextNode] ) {
                visited[nextNode] = true;    // Mark node as visited
                System.out.println("nextNode = " + nextNode );
                for ( i = 0; i < V; i++ )
// for ( i = V-1; i >=0 ; i-- )
                    if ( adjMatrix[nextNode][i] == true  && ! visited[i] )
                        q.add(i);
            }
        }
    }
    public static void main(String[] args) {    //test code
        int V = 5;
        int E = 7;
        GraphBFS G = new GraphBFS(V, E);
        System.out.println(G.toString());
        G.BFS();
    }
}
