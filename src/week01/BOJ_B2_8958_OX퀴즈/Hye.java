package week01.BOJ_B2_8958_OX퀴즈;

import java.util.Scanner;

public class Hye {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < num; i++){
            String ox = sc.nextLine();
            char[] chars = ox.toCharArray();
            int sum = 0;
            int count = 0;
            for(int j = 0; j < chars.length; j++){
                if(chars[j]=='O'){
                    count +=1;
                    sum+=count;

                }else{
                    count = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
