import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

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

        dfsIterative(g,v,s);
        System.out.println();
        boolean[] isVisited = new boolean[v];
        dfsRecursive(g,s,isVisited);
    }

    static void dfsIterative(graph g,int vertices,int src){

        boolean[] isVisited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        isVisited[src] = true;

        while (!stack.empty()){
            int vertex = stack.pop();
            System.out.print(vertex+" ");
            for(int neighbour : g.adjListArray[vertex]){
                if(!isVisited[neighbour]){
                    stack.push(neighbour);
                    isVisited[neighbour] = true;
                }
            }
        }
    }

    static void dfsRecursive(graph g,int src,boolean[] isVisited){
        isVisited[src] = true;
        System.out.print(src+" ");
        for(int neighbour : g.adjListArray[src]){
            if(!isVisited[neighbour]){
                dfsRecursive(g,neighbour,isVisited);
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
