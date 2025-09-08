/*
 D: 점화식 배열
 D[i][0]:길이 i에서 끝이 0으로 끝나는 이친수 개수
 D[i][1]:길이 i에서 끝이 1로 끝나는 이친수 개수
 
 자릿수 N 입력받고 D 배열 초기화
 
 D[1][1] = 1//1자리수에서 1로 끝나는 이친수는 1, 1가지
 D[1][0] = 0//1자리수에서 0으로 끝나는 이친구는 0, 0가지
 
 for(i-> 2~N){
 	D[i][0] = D[i-1][0] + D[i-1][1] 
 	//0은 이전 단계가 0, 1로 끝나는 모든 경우 붙일 수 있음
 	D[i][1] = D[i-1][0]
 	//1은 연속으로 올 수 없으니까 0으로 끝나는 경우만 붙일 수 있음
 	}
 
N번째에서 0으로 끝나는 개수 + N번째에서 1로 끝나는 개수 출력
 */
import java.util.Scanner;
public class P2193_이친수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long D[][] = new long[N+1][2];
		D[1][1] = 1;
		D[1][0] = 0;
		
		for(int i = 2; i <= N; i++) {
			D[i][0] = D[i-1][0]+ D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		
		System.out.println(D[N][0]+ D[N][1]);

	}

}
