package CLASS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬2 {

	static int age;
	static String name;
	static PriorityQueue<Student> pq=new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N=Integer.parseInt(bf.readLine());
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(bf.readLine());
			age=Integer.parseInt(st.nextToken());
			name=st.nextToken();
			pq.add(new Student(i,age,name));
		}
		
		while(!pq.isEmpty()) {
			Student tmp=pq.poll();
			System.out.println(tmp.age+" "+tmp.name);
		}
	}
}

class Student implements Comparable<Student>{

	int num;
	int age;
	String name;
	
	public Student(int num, int age, String name) {
		super();
		this.num = num;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.age>o.age)
			return 1;
		
		else if(this.age==o.age) {
			if(this.num>o.num)
				return 1;
			else
				return -1;
		}
		else
			return -1;
	}
	
}
