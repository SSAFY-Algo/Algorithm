package sc_210420;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {

	static int tc, size;
	static Deque<Integer> dq;
	static String command, res[];
	static boolean flag,isRight;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		StringBuilder sb;
		tc = Integer.parseInt(bf.readLine());
		res = new String[tc];

		for (int i = 0; i < tc; i++) {
			// input
			dq = new ArrayDeque<>();
			sb = new StringBuilder();
			command = bf.readLine();
			flag = false;
			isRight=false;
			size = Integer.parseInt(bf.readLine());
			String arr = bf.readLine();
			
			int len = arr.length();
			arr = arr.substring(1, len - 1);
			if(size!=0) {
				st = new StringTokenizer(arr, ",");	
			}else {
				if(command.contains("D"))
                    res[i]="error";
                else
                	 res[i]="[]";
				continue;
			}
			for (int k = 0; k < size; k++) {
				dq.offerLast(Integer.parseInt(st.nextToken()));
			}

			for (int j = 0; j < command.length(); j++) {
				if (dq.size() == 0) {
					flag = true;
					sb.append("error");
					res[i] = sb.toString();
					break;
				}
				
				if (command.charAt(j) == 'R') {
					functionR();
				} else if (command.charAt(j) == 'D') {
					functionD();
				}
			}
			
			if (!flag) {
				sb.append("[");
				int size=dq.size();
				for(int p=0;p<size;p++) {
					if(isRight) {
						sb.append(dq.pollLast());
					}else {
						sb.append(dq.pollFirst());
					}
					if(!dq.isEmpty()) {
						sb.append(",");
					}
				}
				sb.append("]");
			}
			res[i] = sb.toString();
		}
		for (int j = 0; j < res.length; j++) {
			bw.write(res[j]);
			bw.write("\n");
		}
		bw.flush();
	}

	private static void functionR() {
		if(!isRight)
			isRight=true;
		else
			isRight=false;
	}

	private static void functionD() {
		if(!isRight)
			dq.pollFirst();
		else {
			dq.pollLast();
		}
	}

}
