/*
 수도코드:
 수의 개수 n값 입력
 배열 A 입력
 
 A배열 정렬
 
 for(k < n){
 	find(찾고자하는 값), i, j(투포인터)
 	
 	while(i <j){
 		if(A[i]+A[j] == find)
 			i,j가 k랑 다르면 break 걸고 나옴
 			i==k라면 i++
 			j==k라면 j--
 		else if(A[i]+A[j] > find)
 			j--
 		else
 			i++
 	}
 }
 
 좋은 수 개수 출력
 			
 */
import java.util.*;
import java.io.*;
public class P1253_좋은수구하기 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int good = 0;
		long A[] = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			A[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(A);
		
		for(int k = 0; k < n; k++) {
			long find = A[k];
			int i = 0;
			int j = n-1;
			
			while(i <j) {
				if((A[i]+A[j]) == find) {
					if(i != k && j !=k) {
						good++;
						break;
					}
					else if (i ==k)
						i++;
					else if (j ==k)
						j--;
				}
				else if (A[i]+A[j] > find)
					j--;
				else
					i++;
			}
		}
		
		System.out.println(good);
		br.close();
		

	}

}
