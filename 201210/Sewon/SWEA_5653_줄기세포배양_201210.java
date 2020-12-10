import java.io.*;
import java.util.*;

public class Solution {

	public static class Cell {
		int pos, X, activeTime;
		boolean dead;
		public Cell() {}
		public Cell(int pos, int x, int activeTime) {
			this.pos = pos;
			X = x;
			this.activeTime = activeTime;
			this.dead = false;
		}
	}
	
	static final int NUM = 750;
	static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };
	public static void main(String[] args) throws Exception {				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			Cell[] grid = new Cell[NUM*NUM];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					int X = Integer.parseInt(st.nextToken());
					if(X > 0) {
						int pos = (i+350)*NUM + (j+350);
						grid[pos] = new Cell(pos, X, 1);
					}
				}
			}
			
			ArrayList<Cell> cellList = new ArrayList<Cell>();
			ArrayList<Cell> note = new ArrayList<Cell>();
			for (int time = 1; time<=K; time++) {
				updateGrid(note, grid);

				cellList.clear();
				getCellList(grid, cellList);
				
				note.clear();
				writeNote(cellList, note, grid);
				
				sort(note);
			}
			
			System.out.println("#"+TC+" "+ countCell(grid));
		}
	}

	private static void getCellList(Cell[] grid, ArrayList<Cell> cellList) {
		for (int i = 0; i < grid.length; i++) {
			if(grid[i] != null && !grid[i].dead) {
				cellList.add(grid[i]);
			}
		}
	}
	
	private static void writeNote(ArrayList<Cell> cellList, ArrayList<Cell> note, Cell[] grid) {
		for (int i = 0; i < cellList.size(); i++) {
			Cell now = cellList.get(i);

			if (now.activeTime == now.X) {
				int x = now.pos / NUM;
				int y = now.pos % NUM;
				for (int k = 0; k < 4; k++) {
					int nx = x + dir[k][0];
					int ny = y + dir[k][1];
					int npos = nx * NUM + ny;

					if (grid[npos] == null)	note.add(new Cell(npos, now.X, 0));
				}
			}
			
			if(now.activeTime == now.X*2) {
				grid[now.pos].dead = true;
			}
			
			grid[now.pos].activeTime++;
		}
	}

	private static void sort(ArrayList<Cell> note) {
		Collections.sort(note, new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				if(o1.pos == o2.pos) {
					return o1.X - o2.X;
				}
				return o1.pos - o2.pos;
			}
	    });
	}

	private static void updateGrid(ArrayList<Cell> note, Cell[] grid) {
		if(note.size() == 0)	return;
		
		for (int i = 0; i < note.size()-1; i++) {
			if(note.get(i).pos != note.get(i+1).pos) {
				grid[note.get(i).pos] = note.get(i);
			}
		}
		Cell last = note.get(note.size()-1);
		grid[last.pos] = last;
	}
	
	private static int countCell(Cell[] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			if(grid[i] != null && !grid[i].dead)	count++;
		}
		return count;
	}
}
