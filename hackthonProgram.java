/**
 * 
 */
package test;

/**
 * @author karthikeyan
 *
 */
public class hackthonProgram {

	/**
	 *  sum required is 5. k =3 so the integers that can be considered to reach the sum are [1,2,3]
	 *  
	 *  1. 1+1+1+1+1 = 5
	 *  2. 1+1+1+2 = 5
	 *  3. 1+2+2 = 5
	 *  4. 1+1+3 = 5
	 *  5. 2+3 = 5
	 *  
	 */
	public static int ways(int total,int k)
	{
		int value[][] = new int [total+1][k+1];
		
		int i,j;
		
		for(i =0 ;i <= total; i++) {
			for(j=0; j<= Math.min(i, k);j++) {
				if(j==0)
				{
					value[i][j]=1;
						
					System.out.println("add if:"+value[i][j]);
				}
				else
				{
					
					value[i][j] =value[i-1][j-1]+ value[i-1][j];
					
					System.out.println("add :" +value[i][j]);
				}
			}
		}
		
		
		return value[total][k];
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int total =5,k=3;
		System.out.println("Final" + ways(total-1,k-1));

	}

}
