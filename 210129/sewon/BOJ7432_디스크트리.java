import java.io.*;
import java.util.*;

public class BOJ7432_디스크트리 {

    private static class Node {
        private int level;
        private String path;
        private ArrayList<Node> child;

        public Node(int level) {    // root node
            this.level = level;
            this.child = new ArrayList<Node>();
        }
        public Node(int level, String path) {
            this.level = level;
            this.path = path;
            this.child = new ArrayList<Node>();
        }

        public Node getLastChildNode() {
            int cihldSize = child.size();
            return child.get(cihldSize-1);
        }
    }
    private static class Tree {
        Node root;

        public Tree() {     // 생성자 -> root node 생성
            this.root = new Node(-1);
        }

        // node 삽입 : leve = path의 index
        public void insertNewDirectory(ArrayList<String> paths, int level, Node curNode) {
            // 재귀 기저조건
            if(paths.size() <= level)   return;

            for (int i = 0; i < curNode.child.size(); i++) {
                Node child = curNode.child.get(i);
                // 기존의 폴더명과 동일한 경우
                if(child.path.equals(paths.get(level))) {
                    insertNewDirectory(paths, level+1, child);  // 다음 path로 이동
                    return;
                }
            }

            // 이전에 없던 노드
            curNode.child.add(new Node(level, paths.get(level)));   // tree에 집어넣고
            insertNewDirectory(paths, level+1, curNode.getLastChildNode()); // 다음 path로 이동
        }
        public void printTree(Node curNode, int level) {
            if(curNode.child.isEmpty()) {   // 자식노드가 없을 때
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < level; i++) {
                    sb.append(' '); // level만큼 공백 추가
                }
                System.out.println(sb.toString()+curNode.path);
                return;
            }

            // 자식노드가 있는 경우
            if(level != -1) {   // root 노드의 path는 출력할 필요 없음
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < level; i++) {
                    sb.append(' '); // level만큼 공백 추가
                }
                System.out.println(sb.toString()+curNode.path);
            }

            // 다음 레벨 print
            for (int i = 0; i < curNode.child.size(); i++) {
                printTree(curNode.child.get(i), level+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        Node root = new Node(-1);
        int N = Integer.parseInt(br.readLine());
        String[] path = new String[N];
        for (int i = 0; i < N; i++) {
            path[i] = br.readLine();

            // 1. 정렬을 위한 사전작업 : 치환
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < path[i].length(); j++) {
                if(path[i].charAt(j) == '\\') {     // 사전순 정렬을 위해 문자 치환
                    sb.append('/'); // 역슬래시보다 작은 아스키코드값을 가지는 문자로 치환
                    continue;
                }
                sb.append(path[i].charAt(j));
            }
            path[i] = sb.toString();
        }

        Arrays.sort(path);  // 2. 사전 순 정렬

        // 3. 트리에 삽입
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(path[i], "/");
            ArrayList<String> paths = new ArrayList<String>();
            while(st.hasMoreTokens()) {
                paths.add(st.nextToken());
            }
            tree.insertNewDirectory(paths, 0, root);
        }

        // 4. print tree
        tree.printTree(root, -1);
    }
}
