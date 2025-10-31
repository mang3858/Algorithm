/*
 수도코드: 
 N 입력 받고 배열 A 입력 받기
 M 입력 받고 배열 M 입력 받기
 
Arrays.sort(A);
 
for i->0~M
    key = M[i]
    결과 = search(A, key)
    builder에 결과 추가 (1 또는 0)

print(builder)

static int search(int A[], int key){
	while(low <= high) {
			int mid = (low+high) / 2;
			
			if(A[mid] == key) return 1;
			if(A[mid] < key) low = mid + 1;
			else high = mid -1;
		}
		return 0;
}

 
 */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int A[] = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(search(A, key)).append('\n');
		}
		
		System.out.println(sb);
			
	}
	
	static int search(int[] A, int key) {
		int low = 0;
		int high = A.length-1;
		
		while(low <= high) {
			int mid = (low+high) / 2;
			
			if(A[mid] == key) return 1;
			if(A[mid] < key) low = mid + 1;
			else high = mid -1;
		}
		return 0;
	}

}
