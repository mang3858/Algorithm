/*
 수도 코드:
 N 입력 받고
 배열 A도 입력 받고
 M 입력 받고
 
 Arrays.sort(A);
 
 for(i-> 0~M){
 	B[i] = sc.nextInt();
 	
 	first = firstBinary(A, B[i], 0, N-1)
 	last  = endBinary(A, B[i], 0, N-1)
 	
 	if first == -1:
        print 0
    else:
        print (last - first + 1)
 }


//처음 위치 찾기
startBinary(arr[], key, start, end){
	int mid = (start + end) / 2;
	
	if(start> end) return -1;
	
	if (arr[mid] == key)
		mid를 후보로 저장해 두고
		왼쪽 구간(start ~ mid-1)을 한 번 더 탐색해서
		더 왼쪽에 key가 있는지 확인
	
	if(arr[mid] < key)
		return startBinary(arr, key, mid+1, end);
	if(arr[mid] > key)
		return startBinary(arr, key, start, mid-1);
}
//마지막 위치 찾기
endBinary(arr[], key, start, end){
	int mid = (start + end) / 2;
	
	if(start> end) return 0;
	
	if (arr[mid] == key)
		mid를 후보로 저장해 두고
		오른쪽 구간(mid+1 ~ end)을 한 번 더 탐색해서
		더 오른쪽에 key가 있는지 확인
	
	if(arr[mid] < key)
		return endBinary(arr, key, mid+1, end);
	if(arr[mid] > key)
		return endBinary(arr, key, start, mid-1);
}
 */
import java.io.*;
import java.util.*;
public class P10816_숫자카드2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int B[] = new int[M];
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			
			int first = firstBinary(A, B[i], 0, N-1);
			int last  = lastBinary(A, B[i], 0, N-1);
				 	
			if (first == -1)
				sb.append(0).append(" ");
			else
				sb.append(last - first + 1).append(" ");
			
		}
		 System.out.println(sb.toString());
	}
	
	//처음 위치 찾기
	static int firstBinary(int[] arr, int key, int start, int end){
		if(start> end) return -1;
		
		int mid = (start + end) / 2;
					
		if (arr[mid] == key) {
			int leftIdx = firstBinary(arr, key, start, mid-1);
			if (leftIdx != -1)
				return leftIdx;
		}
		
		if(arr[mid] < key)
			return firstBinary(arr, key, mid+1, end);
		if(arr[mid] > key)
			return firstBinary(arr, key, start, mid-1);
		else
			return mid;
	}
	//마지막 위치 찾기
	static int lastBinary(int[] arr, int key, int start, int end){
		if(start> end) return -1;
		
		int mid = (start + end) / 2;
		
		if (arr[mid] == key) {
			int lastIdx = lastBinary(arr, key, mid+1, end);
			if (lastIdx != -1)
				return lastIdx;
		}
		
		if(arr[mid] < key)
			return lastBinary(arr, key, mid+1, end);
		if(arr[mid] > key)
			return lastBinary(arr, key, start, mid-1);
		else
			return mid;
	}
	

}

