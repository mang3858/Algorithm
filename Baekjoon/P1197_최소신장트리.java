import java.util.PriorityQueue;
import java.util.Scanner;

public class P1197_최소신장트리 {
    static int[] parent;//대표 노드 저장 배열
    static PriorityQueue<pEdge> queue;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();//노드 수
        int M = sc.nextInt();//에지 수
        queue = new PriorityQueue<>();//자동 정렬 위함
        parent = new int[N+1];

        //부모 노드 데이터 초기화
        for(int i = 0; i< N; i++) {
            parent[i]=i;
        }

        //에지 리스트에 정보 저장
        for(int i=0; i<M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new pEdge(s, e, v));
        }

        int useEdge = 0;
        int result = 0;
        //크루스칼 알고리즘
        while (useEdge < N -1) {
            pEdge now = queue.poll();//에지 뽑아서 now에 넣고
            if(find(now.s) != find(now.e)) {//싸이클 안생기면
                union(now.s, now.e);//노드 연결
                result = result + now.v;
                useEdge++;
            }
        }
        System.out.println(result);

    }
    //union 연산
    public static void union(int a, int b) {
        //a와 b의 대표 노드 찾고 대표 노드끼리 연결하기
        a = find(a);
        b = find(b);
        if (a!= b) {
            parent[b] = a;
        }
    }

    //find 연산
    public static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

}

class pEdge implements Comparable<pEdge>{
    int s;
    int e;
    int v;

    pEdge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(pEdge o) {
        //가중치 기준으로 오름차순 정렬해야 하므로 compareTo로 재정의
        return this.v - o.v;
    }

}