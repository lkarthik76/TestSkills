package test;

import java.util.ListIterator;
import java.util.Vector;

/*
 * 
 *  Find the list of risky cities to drive
 *  Sample file
 *  2 - data for two cities
 *  1,5,10 - city 1, 5 drivers, max possible score in 10
 *  4,8,5,9,9 - driving scores for 5 drivers of city 1
 *  2,6,15  - city 2, 6 drivers, max possible score in 15
 *  11,14,14,10,9,12 - driving score for 6 drivers of city 2
 * 
 *  1) A risky city is where more than 60% of the drivers score below an input safety percentage of max score
 *  2) in given sample if input safety percentage is 81, for city 1,3 drivers have scored less than safety percentage score 
 *  of 8. 3 out of 5 drivers scored less than safty percentage.
 */

public class program2 {
/**
 * @author karthikeyan
 *
 */
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
