import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
	public static void main(String[] args) {
		String[] board = {"ABCBA","DABAG","EBABH","FAJAI","AKLMA"};
		int result = new Solution().solution(board);
		System.out.println("result : " + result);
	}

}

class Solution {
	public static boolean[][] visited;
	public static char[][] arr;
	public static final int MAX_SIZE = 1_001;
	public static int N;
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        arr= new char[N][N];
        
        for(int i = 0 ; i < N ; i++)
        {
        	arr[i] = board[i].toCharArray();
        }
        
        
        for(int i = 0 ; i < N ; i++)
        {
        	for(int j = 0 ; j < N ; j++)
        	{
        		int val = BFS(new Pos(i,j,0,4));
        		if(answer < val)
        		{
        			answer = val;
        		}
        	}
        }
        
        if(answer == 0)
        	return answer;
        return answer * 2 + 1;
    }
    public static int[] dy = { -1, -1, 1, 1};
    public static int[] dx = { -1, 1, 1, -1};
    public static int BFS(Pos start)
    {
    	Queue<Pos> q = new LinkedList<>();
    	visited = new boolean[MAX_SIZE][MAX_SIZE];
    	visited[start.y][start.x] = true;
    	q.add(start);
    	int maxLen = -1;
    	int pass = 4;
    	int solv = 0;
    	Pos p = null;
    	while(!q.isEmpty())
    	{
    		p = q.poll();
    		if(maxLen < p.cnt)
    		{
    			if(start.y == 2 && start.x == 2)
    			{
    				System.out.println(p);
    				System.out.println("pass : " +pass);
    			}
    			maxLen = p.cnt;
    			pass = 1;
    			
    		}
    		else if(maxLen == p.cnt)
    		{
    			pass++;
    			if(pass == 4)
    				solv = p.cnt;
    		}
    		
    		if(p.dir == 4)
    		{
    			for(int i = 0; i < 4 ; i++)
        		{
        			int ty = dy[i] + p.y;
        			int tx = dx[i] + p.x;
        			if(0 <= ty && ty < N && 0 <= tx && tx < N
        					&& !visited[ty][tx] && arr[p.y][p.x] == arr[ty][tx])
        			{
        				q.add(new Pos(ty,tx,p.cnt+1,i));
        				visited[ty][tx] = true;
        			}
        		}
    		}
    		else
    		{
    			int ty = dy[p.dir] + p.y;
    			int tx = dx[p.dir] + p.x;
    			if(0 <= ty && ty < N && 0 <= tx && tx < N
    					&& !visited[ty][tx] && arr[p.y][p.x] == arr[ty][tx])
    			{
    				q.add(new Pos(ty,tx,p.cnt+1,p.dir));
    				visited[ty][tx] = true;
    			}
    		}
    		
    		
    	}
    	
    	
    	return solv;
    }
    public static class Pos
    {
    	int y,x,cnt;
    	int dir;
    	Pos(int y,int x,int cnt, int dir)
    	{
    		this.y=y;
    		this.x=x;
    		this.cnt=cnt;
    		this.dir = dir;
    	}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", cnt=" + cnt + ", dir=" + dir + "]";
		}
    }
}