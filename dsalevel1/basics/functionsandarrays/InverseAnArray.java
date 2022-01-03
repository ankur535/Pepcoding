package dsalevel1.basics.functionsandarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InverseAnArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int inv[] = inverse(a);
		display(inv);
		
		br.close();
		
	}
	
	public static int[] inverse(int a[]) {
		
		int n = a.length;
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			int var = a[i];
			b[var] = i;
		}
		return b;
	}
	
	public static void display(int inv[]) {
		StringBuilder sb = new StringBuilder();
		for(int val : inv) {
			sb.append(val + "\n");
		}
		System.out.println(sb);
		
	}

}
