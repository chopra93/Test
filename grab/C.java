package grab;

/**
 * @author chopra
 * 21/03/18
 */
public class C {
    public int[] solution(int[] T) {

        int n = T.length;

        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=0;
            }
        }

        int source=0;
        for (int i=0;i<n;i++){
            if (i==T[i]){
                source=i;
            }
            graph[i][T[i]]=1;
            graph[T[i]][i]=1;
        }
        return dijkstra(graph,source,n);
    }

    int minDistance(int dist[], Boolean sptSet[], int V)
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }


    int[] dijkstra(int graph[][], int src,int V)
    {
        int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, sptSet,V);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        int[] res = new int[V-1];
        for (int i=0;i<V-1;i++){
            res[i]=0;
        }

        for (int i=0;i<V;i++){
            if (dist[i]!=0){
                res[dist[i]-1]++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        C c = new C();
        int[] a = new int[10];
        a[0]=9;
        a[3]=9;
        a[6]=8;
        a[9]=1;

        a[1]=1;
        a[4]=0;
        a[7]=9;

        a[2]=4;
        a[5]=4;
        a[8]=0;

        int[] val = c.solution(a);

        for (int i=0;i<val.length;i++){
            System.out.println(val[i]);
        }

        // 50 %
    }
}
