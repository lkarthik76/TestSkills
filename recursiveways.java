/**
 * 
 */
package test;

/**
 * @author karthikeyan
 *
 */
public class recursiveways {

	static int count=0;
	/**
	 * 
	 */
	public static void recursive(int total,int k, String prefix)
	{
		if(total ==0) {
			System.out.println(prefix);
			count++;
			return;
		}
		for(int i = Math.min(k, total); i>=1; i--) {
			recursive(total-i,i,prefix + " "+i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		recursive(5,3,"");
		System.out.println(count);
	}

}
