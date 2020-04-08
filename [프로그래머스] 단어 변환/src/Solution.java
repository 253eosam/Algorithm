import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		System.out.println(
			
			(new Solution().solution("hit","cog" ,new String[]{"hot","dot","dog","lot","log","cog"}))	
			
			
		);
	}
	public int answer;
    public int solution(String begin, String target, String[] words) {
    	answer = 987654321;
        boolean find = false;
        for(int i = 0 ; i < words.length ; i++)
        	if(words[i].equals(target)) {
        		find = true;
        		break;
        	}
        if(!find) return 0;
        bfs(begin,target,words);
        return answer;
    }
    public class Pos{
    	public String val;
    	public int cnt;

		public Pos(String val, int cnt) {
			super();
			this.val = val;
			this.cnt = cnt;
		}
    }
    public void bfs(String b, String t, String[] words) {
    	Queue<Pos> q = new LinkedList<>();
    	HashSet<String> visited = new HashSet<>();
    	visited.add(b);
    	q.add(new Pos(b,0));
    	while(!q.isEmpty()) {
    		Pos p = q.poll();
    		if(t.equals(p.val)) {
    			answer = p.cnt;
    			break;
    		}
    		
    		Integer[] list = possibleWordIdxList(p.val, words);
    		for(int i = 0 ; i < list.length ; i++) {
    			if(visited.contains(words[list[i]])) continue;
    			visited.add(words[list[i]]);
    			q.add(new Pos(words[list[i]],p.cnt+1));
    		}
    	}
    }
    public Integer[] possibleWordIdxList(String str, String[] words){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++)
            if(possibleWord(str,words[i])) list.add(i);
        return list.toArray(new Integer[list.size()]);
    }
    public boolean possibleWord(String s1 , String s2){
        int difCnt = 0;
        for(int i = 0 ; i < s1.length() ; i++)
            if(s1.charAt(i) != s2.charAt(i)) difCnt++;
        
        return difCnt == 1;
    }
}