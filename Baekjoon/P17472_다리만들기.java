import java.util.*;

public class P17472_다리만들기 {
	static int N, M;//지도 세로, 가로 
	static int[][] map;//지도(0이 바다, 1이 땅)
	static boolean[][] visited;//섬 구분할 때 방문했는지 체크용
	static int islandNum = 2; //섬번호 2부터 시작
	static List<Edge> edgeList = new ArrayList<>();//다리후보목록
	static int[] parent;//대표 노드
	
	//상하좌우 방향 벡터
	static int[] dx = {-1,1,0,0}; //행 읻ㅇ
	static int[] dy = {0,0,-1,1};//열 이동 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new int[N][M];
		visited = new boolean[N][M];
		
		//지도 정보 입력 받고
		for(int i =0; i< N; i++) {
			for(int j = 0; j<M; j++)
				map[i][j] = sc.nextInt();
		}
		
		//bfs로 섬마다 고유 번호 부여
		for(int i = 0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] &&map[i][j] == 1)
					bfs(i, j, islandNum++);
			}
		}
		
		//각 섬에서 상하좌우로 다리 연결 가능한지 
		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] >= 2)//섬이면
					findBridge(i, j);
			}
		}
		
		//MST
		parent = new int[islandNum]; 
		for(int i = 2; i< islandNum; i++)
			parent[i] = i;
		
		Collections.sort(edgeList);//다리 가중치 기준 정렬
		
		int result = 0;
		int count = 0; //사용된 다리 개수
		
		for(Edge e : edgeList) {
			if(union(e.from, e.to)){//서로 다른 섬이면 연결 
				result += e.len;
				count++;
			}
		}
		
		//연결된 섬 수가 부족하면 -1
		if(count == islandNum -3)
			System.out.println(result);
		else
			System.out.println(-1);
	}
	
	//bfs로 섬 구분하고 번호 부여
	static void bfs(int x, int y, int num) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});//현재 좌표 {x, y}를 큐에 저장 
		visited[x][y] = true;
		map[x][y] = num; //고유 번호 부여
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();//큐에서 현재 좌표 꺼내서 4방향 하나씩 확인 
			for(int d = 0; d<4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				//다음 좌표 (nx, ny)가 범위 안에 있고 방문 안했고 현재 섬이면(1) 방문 표시하고 큐에 추가 
				if(inRange(nx, ny)&& !visited[nx][ny] && map[nx][ny] ==1 ) {
					visited[nx][ny] = true;
					map[nx][ny] = num;//같은 섬 번호 부여
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	//범위 체크
	static boolean inRange(int x, int y) {
		return x>=0 && y>= 0&& x<N && y< M;
	}
	
	//한 칸에서 상하좌우로 다리 뻗는
	static void findBridge(int x, int y) {
		int from = map[x][y];//시작 섬 번호
		for(int d = 0; d<4; d++) { 
			int nx = x;
			int ny = y;
			int len = 0;//다리 길이
			
			//직선으로 쭉
			while(true) {
				nx += dx[d];// 다음 칸으로 이동 (행)
				ny += dy[d];// 다음 칸으로 이동 (열)
				
				if(!inRange(nx, ny)) break; //범위밖이면 종료
				if(map[nx][ny] == from) break; //자기섬이면 종료?
				if(map[nx][ny] == 0) {//바다면 킵고잉
					len++;
				}else {
					//다른섬 만나면
					if(len >= 2) {
						edgeList.add(new Edge(from, map[nx][ny], len));
					}
					break;
				}
			}
			
			
		}
	}
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		parent[pa] = pb;
		
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, len;
		
		Edge(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
		
		@Override
        public int compareTo(Edge o) {
            return this.len - o.len; // 오름차순 정렬
        }
	
	}

}
