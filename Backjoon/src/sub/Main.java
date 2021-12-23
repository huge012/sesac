package sub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[42];
		int sum = 0;
		
		for (int i = 0; i < 10; i++)
			nums[Integer.parseInt(br.readLine())%42] = 1;
		
		for (int n : nums)
			sum += n;
		System.out.println(sum);
	}

}
