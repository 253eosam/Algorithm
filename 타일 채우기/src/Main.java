import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] map;
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		n=Integer.parseInt(st.nextToken());
		map=new int[n][n];
		
		st=new StringTokenizer(br.readLine());
		int y=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		
		doFull(0,n,0,n,x,y);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				sb.append(map[i][j]+" ");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	static int ans;
	private static void doFull(int startX, int endX, int startY, int endY, int x, int y) {
		if(endX-startX<=1)return;
		
		
		int xmid=(startX+endX)/2;
		int ymid=(startY+endY)/2;
		
		int num=0;
		if(isIn(startX, xmid, startY, ymid, x, y)) num=1;		
		else if(isIn(xmid, endX, startY, ymid, x, y)) num=2;
		else if(isIn(startX, xmid, ymid, endY, x, y)) num=3;
		else if(isIn(xmid, endX, ymid, endY, x, y)) num=4;
		
		
		int[] ori=new int[4];
		int idx=0;
		for(int i=ymid-1; i<=ymid; i++) {
			for(int j=xmid-1; j<=xmid; j++) {
				ori[idx++]=map[i][j];
				map[i][j]=num;
			}
		}
		

		if(num==1)map[ymid-1][xmid-1]=ori[0];
		else if(num==2)map[ymid-1][xmid]=ori[1];
		else if(num==3)map[ymid][xmid-1]=ori[2];
		else if(num==4)map[ymid][xmid]=ori[3];
		
		
		
		if(num==1) {
			doFull(startX,xmid,startY,ymid,x,y);
			doFull(xmid, endX, startY, ymid, xmid, ymid-1);
			doFull(startX, xmid, ymid, endY, xmid-1, ymid);
			doFull(xmid, endX, ymid, endY, xmid, ymid);
		}else if(num==2) {
			doFull(startX,xmid,startY,ymid,xmid-1,ymid-1);
			doFull(xmid, endX, startY, ymid, x, y);
			doFull(startX, xmid, ymid, endY, xmid-1, ymid);
			doFull(xmid, endX, ymid, endY, xmid, ymid);
		}else if(num==3) {
			doFull(startX,xmid,startY,ymid,xmid-1,ymid-1);
			doFull(xmid, endX, startY, ymid, xmid, ymid-1);
			doFull(startX, xmid, ymid, endY, x, y);
			doFull(xmid, endX, ymid, endY, xmid, ymid);
		}else if(num==4) {
			doFull(startX,xmid,startY,ymid,xmid-1,ymid-1);
			doFull(xmid, endX, startY, ymid, xmid, ymid-1);
			doFull(startX, xmid, ymid, endY, xmid-1, ymid);
			doFull(xmid, endX, ymid, endY, x, y);
		}
		
	}
	private static boolean isIn(int xs, int xe, int ys, int ye, int x, int y) {
		return (x>=xs && x<xe && y>=ys && y<ye);
	}
	

}
