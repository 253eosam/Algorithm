
public class Solution {

	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        outer:for(int i = 0 ; i < skill_trees.length ; i++) {
        	int loc = 0;
        	for(int j = 0 ; j < skill_trees[i].length() ; j++) {
        		int idx = skill.indexOf(skill_trees[i].charAt(j)); 
        		if(idx == loc) {
        			loc++;
        		}else if(idx > loc) {
        			continue outer;
        		}
        	}
        	answer++;
        }
        
        return answer;
    }

}
