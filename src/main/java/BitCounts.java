import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 n      binary count   sum
 1  -   001 	1   	1
 2  -   010 	1   	2
 3  -   011 	2   	4
 4  -   100 	1   	5
 5  -   101 	2   	7
 6  -   110 	2   	9
 7  -   111 	3  		12
 8  -  1000 	1  		13
 9  -  1001 	2  		15
 10 -  1010 	2  		17
 11 -  1011 	3  		20
 12-   1100 	2  		22
 13-   1101 	3  		25
 14-   1110 	3  		28
 15-   1111 	4  		32
 16 - 10000 	1  		33
 * 
 * @author aawasthi
 *
 */

public class BitCounts {

	public static long mod = 1000000007;
	
	public static void main(String[] args) {

		long number = 20;

		StringBuffer buffer = new StringBuffer();

		for(long i = 1; i <= number; i++) {
			String s = Long.toBinaryString(i);
			buffer.append(s);
		}
		System.out.println(buffer.toString());
		String binaryStr = buffer.reverse().toString();
		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(2L);
		for(int i = 2; i <= binaryStr.length(); i++) {
			long last = list.get(i - 1);
			list.add(mod(last * 2));
			//System.out.println(i + "_" + list);
		}
		long result = 0;
		int count = 0;
		while(count < binaryStr.length()) {
			int chr = binaryStr.charAt(count) - '0';
			result = mod(result + (chr * list.get(count)));
			//System.out.println(count + "_" + chr +"_" + result);
			count++;
		}

		System.out.println(result);


	}

	public static long mod(long num) {
		return num % mod;
	}


}
