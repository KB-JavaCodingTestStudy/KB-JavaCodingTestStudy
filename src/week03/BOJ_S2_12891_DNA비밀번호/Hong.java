import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hong {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String AllDNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        int minA = Integer.parseInt(st.nextToken());
        int minC = Integer.parseInt(st.nextToken());
        int minG = Integer.parseInt(st.nextToken());
        int minT = Integer.parseInt(st.nextToken());

        int countA = 0, countC = 0, countG = 0, countT = 0;
        int result = 0;

        for (int i = 0; i < P; i++) {
            char c = AllDNA.charAt(i);
            if (c == 'A') countA++;
            else if (c == 'C') countC++;
            else if (c == 'G') countG++;
            else if (c == 'T') countT++;
        }

        if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) result++;

        for (int i = P; i < S; i++) {
            char out = AllDNA.charAt(i - P);
            char in = AllDNA.charAt(i);

            if (out == 'A') countA--;
            else if (out == 'C') countC--;
            else if (out == 'G') countG--;
            else if (out == 'T') countT--;

            if (in == 'A') countA++;
            else if (in == 'C') countC++;
            else if (in == 'G') countG++;
            else if (in == 'T') countT++;

            if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) result++;
        }

        System.out.println(result);
    }
}


/*
    코드가 반복 되는거 같아 줄여보자 해서 줄인 반복문.....
    for (int i = 0; i < S; i++) {
        char in = AllDNA.charAt(i);
        if (in == 'A') countA++;
        else if (in == 'C') countC++;
        else if (in == 'G') countG++;
        else if (in == 'T') countT++;

        if (i >= P) {
            char out = AllDNA.charAt(i - P);
            if (out == 'A') countA--;
            else if (out == 'C') countC--;
            else if (out == 'G') countG--;
            else if (out == 'T') countT--;
        }

        if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) result++;
 */

