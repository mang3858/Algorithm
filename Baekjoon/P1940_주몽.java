/*
 수도코드:
 N, M값 입력
 배열 입력
 
 배열 정렬
 
 while(i<j){
 	if(A[i] + A[j] < M)
 		i++
 	if(A[i] + A[j] > M)
 		j--
 	if(A[i] + A[j] == M){
 		cnt++
 		i++
 		j--
 	}
 }
 
 cnt 출력
 	
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class P1940_주몽 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i= 0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		
		int cnt = 0;
		int i = 0;
		int j=N-1;
		while(i < j) {
			if(A[i] + A[j] < M)
				i++;
			else if(A[i] + A[j] > M)
		 		j--;
			else{
		 		cnt++;
		 		i++;
		 		j--;
		 	}
		}
		
		System.out.println(cnt);
		br.close();
	}

}
