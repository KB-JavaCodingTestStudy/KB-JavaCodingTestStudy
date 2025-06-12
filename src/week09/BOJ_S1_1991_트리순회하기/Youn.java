package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1991 {
    static Map<String, List<String>> map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String val = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            map.putIfAbsent(val, new ArrayList<>());

            List<String> values = map.get(val);
            if (!left.equals("."))
                values.add(left);
            else
                values.add(null);
            if (!right.equals("."))
                values.add(right);
            else
                values.add(null);
        }
        preorder("A");
        sb.append("\n");
        inorder("A");
        sb.append("\n");
        postorder("A");
        System.out.println(sb);

    }

    public static void inorder(String cur){
        if(cur == null){
            return;
        }
        inorder(map.get(cur).get(0));
        sb.append(cur);
        inorder(map.get(cur).get(1));
    }

    public static void preorder(String cur){
        if(cur == null){
            return;
        }
        sb.append(cur);
        preorder(map.get(cur).get(0));
        preorder(map.get(cur).get(1));
    }

    public static void postorder(String cur){
        if(cur == null){
            return;
        }
        postorder(map.get(cur).get(0));
        postorder(map.get(cur).get(1));
        sb.append(cur);
    }
}
