import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Time implements Comparable<Time>
{
	int h,m,s;
	Time(int h, int m, int s)
	{
		this.h = h;
		this.m = m;
		this.s = s;
	}
	@Override
	public int compareTo(Time o) {
		if(h == o.h)
		{
			if(m == o.m)
			{
				return s - o.s;
			}
			else
				return m - o.m;
		}
		else
			return h - o.h;
	}
	
}
public class Solution {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			String tmp = br.readLine();
			String[] splitTmp = tmp.split(":");
			String h = splitTmp[0];
			String m = splitTmp[1];
			String s = splitTmp[2];
			Time now = new Time(Integer.parseInt(h),Integer.parseInt(m),Integer.parseInt(s));
			
			tmp = br.readLine();
			splitTmp = tmp.split(":");
			h = splitTmp[0];
			m = splitTmp[1];
			s = splitTmp[2];
			
			Time pri = new Time(Integer.parseInt(h),Integer.parseInt(m),Integer.parseInt(s));
			
			Time solv;
			if(pri.compareTo(now) > 0)
				solv = calculation(pri, now);
			else if(pri.compareTo(now) < 0)
			{
				solv = calculation(now, pri);
				solv = calculation(new Time(24,0,0),solv);
			}
			else
				solv = new Time(0,0,0);
			
			h = Integer.toString(solv.h);
			m = Integer.toString(solv.m);
			s = Integer.toString(solv.s);
			if(h.length() <= 1)
				h = "0"+h;
			if(m.length() <= 1)
				m = "0"+m;
			if(s.length() <= 1)
				s = "0"+s;
			bw.write("#"+tNum+" "+h+":"+m+":"+s+"\n");
		}//for tNum
		bw.flush();
		bw.close();
		
	}//main
	
	public static Time calculation(Time big, Time small)
	{
		Time solv = null;
		
		int hour, min, sec;
		hour = big.h - small.h;
		min = big.m - small.m;
		sec = big.s - small.s;
		
		if(sec < 0)
		{
			sec += 60;
			min--;
		}
		if(min < 0)
		{
			min += 60;
			hour--;
		}
		
		solv = new Time(hour,min,sec);
		
		return solv;
	}
	
}
