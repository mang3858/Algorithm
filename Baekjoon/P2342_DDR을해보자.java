/*
 DP[N][L][R] = 수열 N개의 인풋까지 수행했도 왼쪽 다리가 L, 오른쪽 다리가 R에 있을 때 힘의 최솟값
  
 수도 코드:
 dp 배열 선언
 mp(한 발을 이동할 때 드는 힘을 미리 저장, mp[1][2] -> 1에서 2로 이동할 때 드는 힘) 배열 선언 
 db 초기화
 
 while(모든 수열이 수행될 때까지){
 	for(i->0~4){
 		바로 직전 오른쪽 다리가 있을 수 있는 5가지 경우 누적 합 구하기
 		dp 배열에 오른쪽 다리 이동에 필요한 힘의 합산 값 중 최솟값 저장
 	}
 	
 	for(i->0~4){
 		바로 직전 왼쪽 다리가 있을 수 있는 5가지 경우 누적 합 구하기
 		dp 배열에 왼쪽 다리 이동에 필요한 힘의 합산 값 중 최솟값 저장
 	}
 }
 
 for(i->0~4){
 	for(j->0~4){
 		min = Math.min(min, dp[s][i][j]);
 	}
 }
 
 최솟값 출력
 	
 */

import java.util.Scanner;

public class P2342_DDR을해보자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int dp[][][] = new int[100001][5][5];
		int mp[][] = { 
				{0, 2, 2, 2, 2},
				{2, 1, 3, 4, 3},
				{2, 3, 1, 3, 4},
				{2, 4, 3, 1, 3},
				{2, 3, 4, 3, 1} };
		
		int n = 0, s = 1;
		for(int i = 0; i < 5; i++) 
			for(int j = 0; j < 5; j++) 
				for(int k = 0; k < 100001; k++)
					dp[k][i][j] = 100001 *4;
		dp[0][0][0] = 0;
		
		while(true) {
			n = sc.nextInt();
			if(n==0) 
				break;
			for(int  i = 0; i < 5; i++) {
				if (n == i)
					continue; //두 발이 같은 자리에 있을 수 없음
				for(int j = 0; j < 5; j++)
					dp[s][i][n] = Math.min(dp[s-1][i][j] + mp[j][n], dp[s][i][n]);
			}
			for(int  j = 0; j < 5; j++) {
				if (n == j)
					continue; //두 발이 같은 자리에 있을 수 없음
				for(int i = 0; i < 5; i++)
					dp[s][n][j] = Math.min(dp[s-1][i][j] + mp[i][n], dp[s][n][j]);
			}
			s++;
		}
		s--;
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				min = Math.min(min, dp[s][i][j]);
		System.out.println(min);
		
	}

}
