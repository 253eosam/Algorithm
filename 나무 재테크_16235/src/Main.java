import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static int N,M,K;
	public static int[][] A;
	public static int[][] arr;
	public static ArrayList<Integer>[][] trees;
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Integer> dieList = new ArrayList<>();
	public static void main(String[] args) throws IOException 
	{
		init();
		
		for(int i = 1 ; i <= K ; i++)
		{
//			test();
			spring();
			fall();
			winter();
		}
//		test();
		print();
	}
	public static void test()
	{
		System.out.println("test:::::::::::::::::::::::");
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				System.out.print(trees[i][j].size() + " ");
			}
			System.out.println();
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::");
		
	}
	public static void print()
	{
		int cnt = 0;
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				cnt += trees[i][j].size();
			}
		}
		
		System.out.println(cnt);
	}
	public static void spring()
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(trees[i][j].size() == 0) continue;
				list.clear(); dieList.clear();
				Collections.sort(trees[i][j]);
				for(int tree : trees[i][j])
				{
					if(arr[i][j] >= tree)
					{
						arr[i][j] -= tree;
						list.add(tree+1);
					}
					else	// 죽은 나무가 양분이 된다.
					{
						dieList.add(tree);
					}
				}
				trees[i][j] = new ArrayList<>(list);
				for(int die : dieList)
				{
					arr[i][j] += die/2;
				}
			}
		}
	}
	public static final int di[]= {-1,-1,-1,0,0,1,1,1};
    public static final int dj[]= {-1,0,1,-1,1,-1,0,1};
    public static void fall()
    {
    	//가을에는 나무가 번식한다.
    	//번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
    	//어떤 칸 (r, c)와 인접한 칸은 
    	//(r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
    	//상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
    	int ti,tj;
        for(int i=0;i<N;i++)
        {
        	for(int j=0;j<N;j++)
        	{
        		if(trees[i][j].size() == 0) continue;
        		for(int age: trees[i][j])
        		{
        			if(age%5!=0) continue;
        			for(int k=0;k<8;k++) {
        				ti=i+di[k];
        				tj=j+dj[k];
        				if(0<=ti && ti<N&& 0<=tj && tj<N) {
        					trees[ti][tj].add(1);
        				}
        			}
        			
        		}
        	}
        }
    }
    public static void winter()
    {
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			arr[i][j]+=A[i][j];
    		}
    	}
    }
	public static void init() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		arr = new int[N][N];
		trees = new ArrayList[N][N];
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				arr[i][j] = 5;
		
		
		for(int i = 0 ; i < N ; i ++)
		{
			for(int j = 0 ; j < N ;j++)
			{
				trees[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < M ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			trees[x][y].add(age);
		}
	}

}
