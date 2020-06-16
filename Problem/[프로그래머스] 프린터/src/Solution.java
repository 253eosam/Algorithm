import java.util.*;

class Solution {
	public static void main(String[] args) {
		
	}
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Integer[] maximums = new Integer[priorities.length];
        LinkedList<Priority> link = new LinkedList<Solution.Priority>();
        for(int i = 0 ; i < priorities.length ; i++) {
        	link.add(new Priority(i, priorities[i]));
        	maximums[i] = priorities[i];
        }
        Arrays.sort(maximums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
        
        int maxIdx = 0;
        while(true) {
        	Priority p = link.pollFirst();
        	System.out.println(p);
        	if(location == p.v) break;
        	if(p.p == maximums[maxIdx]) {
        		maxIdx++;
        		continue;
        	}else link.add(p);
        	
        }
        
        
        return answer = maxIdx+1;
    }
    public static class Priority {
    	int v,p;
		public Priority(int v, int p) {
			super();
			this.v = v;
			this.p = p;
		}
		@Override
		public String toString() {
			return "Priority [v=" + v + ", p=" + p + "]";
		}
    }
}