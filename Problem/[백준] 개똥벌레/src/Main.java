
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



class Main{
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int stoi(String s){ return Integer.parseInt(s); };

     public static void main(String[] args) throws IOException{
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = stoi(st.nextToken());
    	int h = stoi(st.nextToken());
    	int[] top = new int[h+1];
    	int[] bot = new int[h+1]; 
    	
    	for(int i = 0 ; i < n/2 ; i++) {
    		bot[stoi(br.readLine())]++;
    		top[stoi(br.readLine())]++;
    	}

    	int[] topSum = new int[h+1]; 
    	int[] botSum = new int[h+1]; 
    	for(int i = 1 ; i <= h ; i++) {
    		topSum[i] = topSum[i-1] + top[i];
    		botSum[i] = botSum[i-1] + bot[i];
    	}
    	int min = n; 
    	int cnt = 0; 
    	
    	for(int i = 1 ; i <= h ; i++) { 
    		int obs = 0; 
    		obs += botSum[h] - botSum[i-1];
    		obs += topSum[h] - topSum[h-i]; 
			
    		if(obs < min) { 
    			min = obs; 
    			cnt = 1; 
    		}else if(obs == min) { 
    			cnt++; 
    		}
    	}
    	bw.append(min + " " + cnt);
    	bw.close();
     }
}