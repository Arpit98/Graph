import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijkstra {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LinkedList<vertex>[] adjListArray;
        int v,e;

        v = in.nextInt() + 1;
        e = in.nextInt();
        adjListArray = new LinkedList[v];

        for(int i = 0; i < v; i++){
            adjListArray[i] = new LinkedList<>();
        }

        for(int i = 0; i < e; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            adjListArray[a].addFirst(new vertex(w,b));
            adjListArray[b].addFirst(new vertex(w,a));
        }

        dijkstraUtil(adjListArray,1);
    }

    private static void dijkstraUtil(LinkedList<vertex>[] adjListArray,int src){
        int size = adjListArray.length;

        distVertex[] dv = new distVertex[size];
        for(int i = 0; i < size; i++){
            dv[i] = new distVertex(Integer.MAX_VALUE,i);
        }
        dv[src].distFromSource = 0;


        PriorityQueue<distVertex> priorityQueue = new PriorityQueue<>(new Comparator<distVertex>() {
            @Override
            public int compare(distVertex o1, distVertex o2) {
                return o1.distFromSource - o2.distFromSource;
            }
        });

        priorityQueue.add(dv[src]);

        while (!priorityQueue.isEmpty()){
            distVertex node = priorityQueue.remove();
            for(vertex x : adjListArray[node.v]){
                if((node.distFromSource + x.weight) < dv[x.connectedTo].distFromSource){
                    dv[x.connectedTo].distFromSource = (node.distFromSource + x.weight);
                }
            }
        }

    }

    static class vertex{
        int weight;
        int connectedTo;
        vertex(int weight, int connectedTo){
            this.weight = weight;
            this.connectedTo = connectedTo;
        }
    }

    static class distVertex{
        int distFromSource;
        int v;
        distVertex(int distFromSource, int v){
            this.distFromSource = distFromSource;
            this.v = v;
        }
    }
}
