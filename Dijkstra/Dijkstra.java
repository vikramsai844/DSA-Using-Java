package DSA.Dijkstra;

public class Dijkstra {
    private static int infinite = 9999999;
    int[][]  LinkCost;
    int      V;
    boolean[] Reached;

    // Construct a graph of N nodes
    Dijkstra(int[][] adjMatrix){
        int i, j;
        V = adjMatrix.length;

        LinkCost = new int[V][V];
        Reached  = new boolean[V];
        for ( i=0; i < V; i++){
            for ( j=0; j < V; j++){
                LinkCost[i][j] = adjMatrix[i][j];
                if ( LinkCost[i][j] == 0 )
                    LinkCost[i][j] = infinite;
            }
        }

        for ( i=0; i < V; i++){
            for ( j=0; j < V; j++)
                if ( LinkCost[i][j] < infinite )
                    System.out.print( " " + LinkCost[i][j] + " " );
                else
                    System.out.print(" * " );

            System.out.println();
        }
    }

    public void Dijkstra(int s /* src */){
        int i, j, m, n, k;
        int[] D = new int[V];                       // Current distance
        int[] predNode = new int[V];
        predNode[s] = s;

        for ( i = 0; i < V; i++ )
            Reached[i] = false;
            Reached[s] = true;           // ReachSet = {s}

        for ( i = 0; i < V; i++ ){
            D[i] = LinkCost[s][i];
            if ( LinkCost[s][i] < infinite )
                predNode[i] = s;
        }

        printReachSet( Reached, D );

        for ( k = 0; k < V-1; k++ ){
            // Find the first unreached node m
            for ( m = 0; m < V; m++ )
                if ( ! Reached[m] )
                    break;

            // Find: m in {N - ReachSet} that has smallest value for D(S,m)
            for ( n = m+1; n < V; n++ ){
                if ( Reached[n] == false && D[n] < D[m] )
                    m = n;
            }

            // Add m to ReachSet
            Reached[m] = true;

            // Find possible "short cut" through m
            for ( n = 0; n < V; n++ ){
                if ( Reached[n] == false ){
                    if ( D[m] + LinkCost[m][n] < D[n] ){
                        D[n] = D[m] + LinkCost[m][n];
                        predNode[n] = m;          // Record the shortest path link
                    }
                }
            }
            printReachSet( Reached, D );
        }

        printShortPaths( predNode );
    }

    void printShortPaths( int[] a ){
        for ( int i = 0; i < V; i++ )
            System.out.println( (char)('A'+a[i]) + " --> " +  (char)('A'+i) );
    }

    void printReachSet(boolean[] Reached, int[] D){
        System.out.print("ReachSet = ");
        for (int i = 0; i < Reached.length; i++ )
            if ( Reached[i] )
                System.out.print( (char) ('A'+i) + " ");
        System.out.println();

        for (int i = 0; i < Reached.length; i++ ){
            if ( Reached[i] )
                continue;

            if ( D[i] < infinite )
                System.out.print( "D[" + (char) ('A'+i) + "] = " + D[i] + " ");
            else
                System.out.print( "D[" + (char) ('A'+i) + "] = * ");
        }
        System.out.println();
    }

    public static void main(String[] args) {    //test code
        int[][] conn = {
                {  0,  5, 19,  0,  0 },  // 0
                {  5,  0,  3, 11,  0 },  // 1
                { 19,  3,  0,  2,  0 },  // 2
                {  0, 21,  2,  0,  3 },  // 3
                {  0,  0,  19,  3,  0 }   // 4
        };

        Dijkstra G = new Dijkstra(conn);
        G.Dijkstra(1);
    }
}