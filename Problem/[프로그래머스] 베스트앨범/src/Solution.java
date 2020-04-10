import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(new Solution().solution(
						new String[] {"classic", "pop", "classic", "classic", "pop"},
						new int[] {500, 600, 150, 800, 2500}))
		);
	}
	class Data implements Comparable<Data>{
		String type;
		Integer play,idx;
		public Data(String type, Integer play, Integer idx) {
			super();
			this.type = type;
			this.play = play;
			this.idx = idx;
		}
		@Override
		public int compareTo(Data o) {
			if(this.play==o.play) return this.idx-o.idx;
			return o.play-this.play;
		}
		
	}
	public int[] solution(String[] genres, int[] plays) {
		
		HashMap<String,PriorityQueue<Data>> map = new HashMap<>();
		HashMap<String,Integer> map_cnt = new HashMap<>();
		for(int i = 0 ; i < genres.length ; i++) {
			String type = genres[i];
			PriorityQueue<Data> pq;
			Integer cnt = plays[i];
			if(map.containsKey(type)) {
				pq = map.get(type);
				cnt += map_cnt.get(type);
			}
			else pq = new PriorityQueue<Data>();
			pq.add(new Data(type,plays[i],i));
			map.put(type,pq);
			map_cnt.put(type, cnt);
		}
		TreeMap<Integer,String> sortedMap = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(String s : map_cnt.keySet()) {
			sortedMap.put(map_cnt.get(s), s);
		}
		
		ArrayList<Integer> answerList = new ArrayList<>();
		for(Iterator iter = sortedMap.values().iterator(); iter.hasNext();) {
			PriorityQueue<Data> pq = map.get(iter.next());
			int size = pq.size();
			for(int i = 0 ; i < size && i < 2 ; i++) {
				answerList.add(pq.poll().idx);
			}
		}
		int[] answer = new int[answerList.size()];
		for(int i = 0 ; i < answer.length ; i++) answer[i] = answerList.get(i);
		return answer;
	}

}