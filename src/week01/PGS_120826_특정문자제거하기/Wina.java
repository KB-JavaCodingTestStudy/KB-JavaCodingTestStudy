package week01.PGS_120826_특정문자제거하기;

public class Wina {

  public String solution(String my_string, String letter) {
    String answer = "";
    answer = my_string.replace(letter, "");
    return answer;
  }
}
