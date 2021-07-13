package test;

import java.util.ListIterator;
import java.util.Vector;

public class program2 {

	static String sdata = "2\n" + "1,5,10\n" + "4,8,5,9,9\n" + "2,6,15\n" + "11,14,14,10,9,12";

	static Vector find_unsafe_cities(int safetyPercetage) {

		Vector<String> vdata = new Vector<>();
		
		Vector<String> result_data = new Vector<>();

		String[] splited = sdata.split("\n");
		for (int i = 1; i < splited.length; i++) {
			vdata.add(splited[i]);
		}
		System.out.println("vdata : " + vdata);
		
		ListIterator<String> lstItr = vdata.listIterator();

		while(lstItr.hasNext()) {
            
			String maxscore = lstItr.next();
            String[] maxd = maxscore.split(",");
            System.out.println(maxscore);

            String city = maxd[0];
            result_data.add(city);
            System.out.println("city : "+city);
            
            int noDriver = Integer.parseInt(maxd[1]);
            System.out.println("noDriver : "+noDriver);
            
            int maxScore = Integer.parseInt(maxd[maxd.length-1]);
			int percentagev = safetyPercetage * maxScore / 100;

			System.out.println("percentagev : "+percentagev);
			
			String driverScore = lstItr.next();
			System.out.println("driverScore"+driverScore);
			String[] strscore = driverScore.split(",");
			
			int iscorearr[] = new int[strscore.length];
			for (int j = 0; j < strscore.length; j++) {
				iscorearr[j] = Integer.parseInt(strscore[j]);
			}
			int size = iscorearr.length;
			int count =0;
			for(int k=0;k< size; k++)
			{			
				if(percentagev <= iscorearr[k])
				{
					count ++;
				}
			}
			int percent = count * 100 /noDriver;
			
			System.out.println("percent : "+percent); 
			
			result_data.add(Integer.toString(percent));
        }
		
		System.out.println(result_data);
		return result_data;

	}

	public static void main(String[] args) {
		find_unsafe_cities(80);

	}

}
