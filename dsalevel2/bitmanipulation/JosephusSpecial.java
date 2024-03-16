package dsalevel2.bitmanipulation;

import java.util.*;

public class JosephusSpecial {

	public static int solution(int n) {
		// write your code here
		
		//check notes for logic
		//n = (1 << x) + L; == 2*L + 1
		//L = n - (1 << x) or n - 2^x
		
		int ans = 0;
		
		while ((1 << ans) <= n) {
			ans++;
		}
		ans--;
		
		int L = n - (1 << ans);
		
		//for n = 2^x + L, ans is 2*L + 1
		return 2*L + 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		System.out.println(solution(n));
	}
}