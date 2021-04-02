import java.util.*;
public class BOJ_1181_단어정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String s = sc.nextLine();
			if(!list.contains(s))
				list.add(s);
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}
				else {
					return o1.compareTo(o2);
				}
			}
			
		});
		
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	
	}

}
