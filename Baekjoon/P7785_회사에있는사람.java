/*
 수도코드:
 출입 기록 수 n값 입력
 
 name(이름), 출입상태(action) 입력
 
 if(action == enter)
 	set.add(name)
 else if(action == leave)
 	set.remove(name)
 	
 //HashSet은 직접 정렬은 불가능하기 때문에 ArrayList로 변환
 ArrayList<String> list = new ArrayList<>(set);
 
 //내림차순 정렬
 Collections.sort(list, Collections.reverseOrder());
 
 출력
 
 */

import java.io.*;
import java.util.*;
public class P7785_회사에있는사람 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String action = st.nextToken();
			
			if(action.equals("enter"))
				set.add(name);
			else if(action.equals("leave"))
				set.remove(name);
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for(String name: list)
			sb.append(name).append("\n");
		System.out.println(sb.toString());
		
		
	}

}
