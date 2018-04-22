import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class primMST {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int v,e;
        LinkedList<vertex>[] adjListArray;

        v = in.nextInt();
        e = in.nextInt();
        adjListArray = new LinkedList[v];

        for(int i = 0; i < v; i++){
            adjListArray[i] = new LinkedList<>();
        }

        for(int i = 0; i < e; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int weight = in.nextInt();
            vertex v1 = new vertex(weight,b);
            vertex v2 = new vertex(weight,a);
            adjListArray[a].addFirst(v1);
            adjListArray[b].addFirst(v2);
        }

        prim(adjListArray,1);
    }

    private static void prim(LinkedList<vertex>[] adjListArray,int src){

        int minimumCost = 0;
        boolean[] check = new boolean[adjListArray.length];

        PriorityQueue<vertex> priorityQueue = new PriorityQueue<>(new Comparator<vertex>() {
            @Override
            public int compare(vertex o1, vertex o2) {
                return o1.weight - o2.weight;
            }
        });
        priorityQueue.add(new vertex(0,src));

        while (!priorityQueue.isEmpty()){
            vertex v = priorityQueue.remove();

            if(check[v.connectedTo]){
                continue;
            }
            check[v.connectedTo] = true;
            minimumCost += v.weight;

            for(vertex x : adjListArray[v.connectedTo]){
                if(!check[x.connectedTo]){
                    priorityQueue.add(x);
                }
            }

        }

        System.out.println(minimumCost);
    }

    static class vertex{
        int weight;
        int connectedTo;

        vertex(int weight, int connectedTo){
            this.weight = weight;
            this.connectedTo = connectedTo;
        }
    }
}
