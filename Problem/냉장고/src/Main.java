import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] mindeg;
	static int[] maxdeg;
	static int N;
	static ArrayList<Ref> arr=new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		mindeg=new int[N];
		maxdeg=new int[N];	
		for(int i=0;i<N;i++) {
			mindeg[i]=sc.nextInt();
			maxdeg[i]=sc.nextInt();
			arr.add(new Ref(mindeg[i], maxdeg[i]));
		}
		
		Collections.sort(arr,new Comparator<Ref>() {
			@Override
			public int compare(Ref o1, Ref o2) {
				
				return o1.min-o2.min;
			}
		});
		ArrayList<Ref> list = new ArrayList<>();
		list.add(arr.get(0));
		out:for(int i=1;i<arr.size();i++) {
			Ref r1 = arr.get(i);
			
			for(int j=0;j<list.size();j++) {
				Ref r2 = list.get(j);
				if(r2.max>=r1.min) {
					r2.min= r2.min>=r1.min?r2.min:r1.min;
					r2.max= r2.max>=r1.max?r1.max:r2.max;
					continue out;
				}
			}
			list.add(r1);
		}
		System.out.println(list.size());
	}
	
	static class Ref{
		int min;
		int max;
		public Ref(int val, int cnt) {
			super();
			min = val;
			max = cnt;
		}
		@Override
		public String toString() {
			return "Ref [min=" + min + ", max=" + max + "]";
		}
	}
}