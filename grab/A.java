package grab;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chopra
 * 21/03/18
 */
public class A {
    public int solution(String E, String L){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = format.parse(E);
            date2 = format.parse(L);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int secs = (int)(date2.getTime() - date1.getTime()) / 1000;
        int hours = secs / 3600;
        secs = secs % 3600;
        int mins = secs / 60;
        secs = secs % 60;

        if (mins>0){
            hours=hours+1;
        }
        int cost = 2;
        if (hours>=1){
            cost = cost + 3;
            hours = hours - 1;
        }

        cost = cost + 4* hours;

        return cost;


    }


    public static void main(String[] args){
        A a = new A();
        System.out.println(a.solution("10:00","13:21"));
        System.out.println(a.solution("09:42","11:42"));
    }
}
