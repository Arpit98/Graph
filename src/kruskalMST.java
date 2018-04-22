import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kruskalMST {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int v,e;

        v = in.nextInt();
        e = in.nextInt();

        Edges[] edges = new Edges[e];
        for(int i = 0; i < e; i++){
            edges[i] = new Edges();
            edges[i].src = in.nextInt();
            edges[i].dest = in.nextInt();
            edges[i].weight = in.nextInt();
        }
        kruskal(edges,v,e);
    }

    static void kruskal(Edges[] edges,int v,int e){

        int minimumCost = 0;
        int[] id = new int[v];
        for(int i = 0; i < v; i++){
            id[i] = i;
        }

        Arrays.sort(edges, new Comparator<Edges>() {
            @Override
            public int compare(Edges o1, Edges o2) {
                return o1.weight - o2.weight;
            }
        });

        for(int i = 0; i < e; i++){
            int x = edges[i].src;
            int y = edges[i].dest;

            if(root(x,id) != root(y,id)){
                minimumCost += edges[i].weight;
                union(x,y,id);
                System.out.println(x+"->"+y);
            }
        }

        System.out.println(minimumCost);
    }

    static void union(int x, int y ,int[] id){
        int p = root(x,id);
        int q = root(y,id);
        id[p] = id[q];
    }

    static int root(int x, int[] id){
        while(id[x] != x){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }

    static class Edges{
        int weight;
        int src;
        int dest;
    }
}
