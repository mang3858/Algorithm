/*
 D[N]: 0에서 N까지 길이에서 N을 포함하여 연속으로 수를 선택해서 구할 수 있는 최대값
 
 수도코드:
 정수 N배열 입력
 수열 A 배열 저장
 
 L배열 저장(왼쪽에서 오른쪽방향으로 최대연속합)
 최대값 초기화
 for(i->1~N){
 	L[i] = Math.max(A[i], L[N-1] + A[i]);
 	수열에서 1개 제거하지 않은 값을 최대값으로 일단 저장
 }
 
 R배열 저장(오른쪽에서 왼쪽방향으로 최대연속합)
 for(i->N-2~0){
 	R[i] = Math.max(A[i], R[N+1] + A[i]);
 }
 
 //수열에서 1개 제거한 후 최대연속합 구하기
 for(i->1~N){
 	Math.max(기존 최대값, L[i-1]+R[N+1])
 }
 
 최대값 출력
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P13398_연속합2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A[] = new int[N];
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		int L[] = new int[N];
		L[0] = A[0];
		int result = L[0];
		for(int i =1; i< N; i++) {
			L[i] = Math.max(A[i], L[i-1] + A[i]);
			result = Math.max(result, L[i]);
		}
		
		int R[] = new int[N];
		R[N-1] = A[N-1];
		for(int i = N-2; i >= 0; i--) {
			R[i] = Math.max(A[i], R[i+1] + A[i]);
		}
		
		for(int i = 1; i < N-1; i++) {
			result = Math.max(result, L[i-1] + R[i+1]);
		}
		
		System.out.println(result);
		bw.flush();
		bw.close();
		br.close();

	}

}
