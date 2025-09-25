/*
D[i][j] :i~j 구간의 행렬을 합치는 데 드는 최솟값

수도코드:
N(행렬개수) 입력
Matrix M[N+1] 선언(행렬 저장 클래스 배열)
D 배열 초기화
행렬 데이터 저장
excute(1, N) 출력 //Dp 함수 호출 및 정답 프린트

int excute(s, e){
	result에 최대값으로 초기화

	if(이미 계산한 구간이면) Dp[i][j]값 바로 리턴
	if(1개 행렬이면) 연산 횟수 0 리턴
	if(2개 행렬이면) 2개 행렬 연간값 리턴(N×M×K)
	if(3개이상 행렬이면) {
		for(i-> s~e)
			excute(s, i) + excute(i+1, e) + 앞뒤 구간의 행렬을 합치기 위한 연산 값
	}
	
	정답 D[s][e] 리턴
}

class Matrix{ //행렬 정보 저장)
	x(행의 개수)
	y(열의 개수)
}
 */
import java.util.Scanner;
public class P11049_행렬곱셈순서 {
	static int N;
	static Matrix[] M;
	static int[][] D;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = new Matrix[N+1];
		D = new int[N+1][N+1];
		
		for(int i = 0; i < D.length; i++)
			for(int j = 0; j < D.length; j++)
				D[i][j] = -1;
		for(int i = 1; i <=N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			M[i] = new Matrix(x,y);
		}
		System.out.println(excute(1,N));
	}
	
	static int excute(int s, int e) {
		int result = Integer.MAX_VALUE;

		if(s == e) return 0;
		if(D[s][e] != -1) return D[s][e];
		if (s+1 == e) return M[s].x * M[s].y * M[e].y;
		for (int i = s; i < e; i++) {
			int merge = M[s].x * M[i].y * M[e].y;
			result = Math.min(result, excute(s, i) + excute(i + 1, e) + merge);
		}
		
		return D[s][e] = result;
	}
	
	static class Matrix{
		private int x;
		private int y;
		Matrix(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
