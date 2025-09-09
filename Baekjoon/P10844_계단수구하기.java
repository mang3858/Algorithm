/*
 계단 수
 = D[N][H]: 길이가 N인 계단에서 H 높이로 종료되는 계단 수를 만들 수 있는 경우의 수
 
 수도 코드
 N 입력 받고
 D[N][H] 정의 하고
 
 엣지값 초기화
 for(i -> 1~9)
 	D[1][i] = 1;
 	
 점화식 정의
 for(i->2~N){
 	D[i][0] = D[i-1][1]
 	D[i][9] = D[i-1][8]
 	for(j->1~8)
 		D[i][j] = (D[i-1][j-1]+D[i-1][j+1]) % 1000000000
 }
 
 sum 초기화
 for(i->0~9)
 	sum = (sum +D[N][i]) % 1000000000
 	
 sum 출력
 	
 */

import java.util.*;
public class P10844_계단수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long D[][] = new long[N+1][11];
		
		for(int i = 1; i <= 9; i++)
			D[1][i] = 1;
		
		for(int i = 2; i <=N; i++) {
			D[i][0] = D[i-1][1];
			D[i][9] = D[i-1][8];
			for(int j = 1; j <= 8; j++)
				D[i][j] = (D[i-1][j-1]+D[i-1][j+1]) % 1000000000;
		}
		
		long sum = 0;
		for(int i = 0; i <= 9; i++)
			sum = (sum +D[N][i]) % 1000000000;
		
		System.out.println(sum);

	}

}
