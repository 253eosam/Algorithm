import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{

                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"

//                "2016-09-15 01:00:04.002 2.0s",
//                "2016-09-15 01:00:07.000 2s"

        }));
    }

    public static int solution(String[] lines) {
        int answer = 0;
        ArrayList<double[]> list = new ArrayList<>();
        for (String str : lines) {
            double[] times = getParseDate(str);
            System.out.println(Arrays.toString(times));
            list.add(times);
        }

        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            double baseEnd = list.get(i)[1];
            double baseFinish = list.get(i)[1]+1;

            for (int j = 0; j < list.size(); j++) {
                double start = list.get(j)[0];
                double end = list.get(j)[1];
                if(baseFinish <= start) continue;
                if((baseEnd <= start && start < baseFinish)
                || (baseEnd <= end && end < baseFinish)
                || (start < baseEnd && baseEnd <= end)){
                    cnt++;
                }
            }
            if (answer < cnt) answer = cnt;
        }

        return answer;
    }

    public static double[] getParseDate(String date) {

        String[] strSplit = date.split(" ");
        double timer = Double.parseDouble(strSplit[2].split("s")[0]);
        double[] time = new double[2];
        time[0] = (stod(strSplit[1].substring(0, 2)) * 3600) + (stod(strSplit[1].substring(3, 5)) * 60) + stod(strSplit[1].substring(6)) - timer + 0.001;
        time[0] = Double.valueOf(String.format("%.3f", time[0]));
        time[1] = (stod(strSplit[1].substring(0, 2)) * 3600) + (stod(strSplit[1].substring(3, 5)) * 60) + stod(strSplit[1].substring(6));
        time[1] = Double.valueOf(String.format("%.3f", time[1]));
        if (time[0] < 0) time[0] = 0;
        if (time[1] < 0) time[1] = 0;
        return time;
    }

    public static double stod(String str) {
        return Double.parseDouble(str);
    }

}
