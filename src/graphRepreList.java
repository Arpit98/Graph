import java.util.LinkedList;
import java.util.Scanner;

public class graphRepreList {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        graph g = new graph(v);
        for(int i = 0; i < v-1; i++){
            g.addEdge(in.nextInt(),in.nextInt());
        }
        g.printGraph();
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
