import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BigBinaryNumber {

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
