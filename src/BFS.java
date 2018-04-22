import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int v,e,s;

        v = in.nextInt();
        e = in.nextInt();
        s = in.nextInt();

        graph g = new graph(v);
        for(int i = 0; i < e; i++){
            g.addEdge(in.nextInt(),in.nextInt());
        }

        BFS(g,s);
    }

    static void BFS(graph g, int s){

        boolean[] visited = new boolean[g.v];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            int node = queue.remove();
            System.out.print(node+" ");
            for(int neighbour : g.adjListArray[node]){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    static class graph{
        int v;
        LinkedList<Integer> adjListArray[];

        graph(int v){
            this.v = v;
            adjListArray = new LinkedList[v];
            for(int i = 0; i < v; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dest){
            adjListArray[src].addFirst(dest);
            //comment below line if graph is directed.
            adjListArray[dest].addFirst(src);
        }

        void printGraph(){
            for(int i = 0; i < v; i++){
                System.out.print("Head");
                for(int x : adjListArray[i]){
                    System.out.print("->"+x);
                }
                System.out.println();
            }
        }
    }
}
