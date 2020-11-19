package SWEA;

import java.awt.Point;
import java.util.Scanner;

public class SWEA_3349_최솟값이동 {

	static int tc, w, h, n, curx, cury;
	static Point pos[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int total = 0;
			w = sc.nextInt();
			h = sc.nextInt();
			n = sc.nextInt();

			pos = new Point[n];
			for (int i = 0; i < n; i++) {
				Point p=new Point(sc.nextInt(),sc.nextInt());
				pos[i]=p;
			}

			for (int i = 0; i < n - 1; i++) {
				curx = pos[i].x;
				cury = pos[i].y;

				int dx = pos[i + 1].x - curx;
				int dy = pos[i + 1].y - cury;

				if (dx * dy > 0) { // 대각 이동 가능
					if (Math.abs(dx) > Math.abs(dy)) {
						total = total + (Math.abs(dy) + (Math.abs(dx) - Math.abs(dy)));
					} else
						total = total + (Math.abs(dx) + (Math.abs(dy) - Math.abs(dx)));
				} else {// 불가능
					
					total=total + (Math.abs(dy) + Math.abs(dx));
				}
			}
			
			System.out.println("#"+t+" "+total);
		}
	}

}
