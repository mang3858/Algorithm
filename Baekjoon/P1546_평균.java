/*
 수도코드:
 길이가 N인 배열 arr[] 선언
 for(N까지)
 	arr[i]에 점수 저장
 
 M, sum 값 초기화
 for(N까지)
 	최고점수 max에, 총점은 sum에 저장
 
sum*100/M/N 출력
 */
import java.util.*;
public class P1546_평균 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[]= new int[N];
		
		for(int i = 0; i < N; i++) 
			arr[i]= sc.nextInt();
		
		int sum = 0;
		int M = 0;
		for(int i = 0; i<N; i++) {
			if(arr[i] >= M)
				M =arr[i];
			sum+= arr[i];
		}
		
		System.out.println(sum*100.0/M/N);
			
	}

}
