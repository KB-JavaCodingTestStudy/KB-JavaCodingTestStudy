package week03.BOJ_S3_20920_영단어암기는어려워;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Wina {
	/* ================================================================
	 *
	 * Problem  : 영단어 암기는 어려워
	 * Author   : 최승아
	 * Date     : 2025-04-22
	 *
	 * ================================================================
	 * 📌 문제 분석 요약
	 * 조건에 맞는 단어들을 단어장에 기입한다
	 * 단어장에 있는 단어들을 우선순위에 맞게 정리하여 효율적인 단어장을 완성한다.
	 *
	 * # 입력
	 * N: 영어 지문에 나오는 단어의 개수
	 * M: 단어장에 기입할 단어 길이의 기준
	 * N개의 단어: 단어 입력
	 *
	 * # 출력
	 * 효율적인 단어장 출력
	 *
	 * 💻 알고리즘 설계
	 * 1. M 이상인 단어만 ArrayList에 저장한다.
	 * 2. 단어 배열에 해당 단어가 나온 횟수와 길이를 저장한다.
	 * 3. 낮은 우선 순위부터 정렬한다.
	 *
	 *
	 * ⏰ 시간복잡도
	 * O(N)
	 * ================================================================
	 */
	
	
	public static void main(String[] args) throws IOException {
		// 초기 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
//		입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Word> words = new ArrayList<>();
		Map<String, Word> wordMap = new HashMap<>();
		
		for (int n = 0; n < N; n++) {
			String word = br.readLine();
			if (word.length() >= M) {
//				이미 저장돼있는 데이터일 때
				if (wordMap.containsKey(word)) {
					wordMap.get(word).increaseCnt();
				}
//				새로운 데이터일 때
				else {
					Word newWord = new Word(word);
					words.add(newWord);
					wordMap.put(word, newWord);
				}
			}
		}

//		알파벳 단어 순 정렬
		words.sort(Comparator.comparing(Word::getName));
//		단어의 길이 정렬
		words.sort(Comparator.comparing(Word::getLen).reversed());
//		단어 나온 횟수 정렬
		words.sort(Comparator.comparing(Word::getCnt).reversed());

//		출력
		for (Word w : words) {
			bw.write(w.getName() + "\n");
		}
		
		//	종료 설정
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static class Word {
		
		private final String name;
		private final int len;
		private int cnt;
		
		public Word(String name) {
			this.name = name;
			this.cnt = 1;
			this.len = name.length();
		}
		
		public void increaseCnt() {
			this.cnt++;
		}
		
		public String getName() {
			return name;
		}
		
		public int getCnt() {
			return cnt;
		}
		
		public int getLen() {
			return len;
		}
	}
}
