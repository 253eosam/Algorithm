import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	
	public Map<Long,Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        int size = room_number.length;
    	long[] answer = new long[size];
        
        for(int i = 0 ; i < size ; i++) {
        	long tmp = room_number[i];
        	answer[i] = findSet(tmp);
        }
        
        return answer;
    }
    
    public long findSet(long param) {
    	if(!map.containsKey(param)) {
    		map.put(param, param+1);
    		return param;
    	}
    	long tmp = findSet(map.get(param));
    	map.put(param, tmp);
    	return tmp;
    	
    	
//    	if(!map.containsKey(map.get(t))) return t;
//    	return map.put(map.get(t), findSet(map.get(t)));
    }
    
    public static void main(String[] args) {
    	System.out.println(
    			
    			Arrays.toString(new Solution().solution(10, new long[] {1, 1, 1, 1, 5, 5, 5, 5, 3 }))
//    			Arrays.toString(new Solution().solution(10, new long[] {1,3,4,1,3,1 }))
//    			Arrays.toString(new Solution().solution(10, new long[] {1,2,1,2,5,4 }))
    			
    			);
    }
}