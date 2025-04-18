
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Youn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] dwarf = new int[9];
        int total = 0;
        for(int i=0;i<9;i++){
            dwarf[i] = Integer.parseInt(br.readLine());
            total += dwarf[i];
        }
        int goal = total-100;
        Arrays.sort(dwarf);
        for(int i=0;i<dwarf.length;i++){
            for(int j=i+1;j< dwarf.length;j++){
                if(dwarf[i]+dwarf[j]==goal){
                   for(int k=0;k<dwarf.length;k++){
                       if(k!=i && k!=j){
                           sb.append(dwarf[k]+"\n");
                       }
                   }
                    
                    System.out.println(sb);
                    return;
                }
            }
        }

    }
}
