package dsalevel1.basics.functionsandarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseAnArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		reverse(a);
		display(a);
	}
	
	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void reverse(int a[]) {
		
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
		
		
		/* Or You can do this as well
		
		int k = a.length - 1;
		for (int i = 0; i < (a.length/2); i++) {
			int val = a[i];
			a[i] = a[k];
			a[k] = val;
			k--;
		}
		*/
		
		/* Or You can do this as well
	
		for (int i = 0, k = a.length - 1; i < j; i++, k--) {
			int val = a[i];
			a[i] = a[k];
			a[k] = val;
		}
		  
		 
		
		/* Or You can do this as well
		
		int i = 0;
		int k = a.length - 1;
		while(i <= k) {
			int val = a[i];
			a[i] = a[k];
			a[k] = val;
			i++;
			k--;
		}
		  
		 */
	}
	
	public static void display(int a[]) {
		StringBuilder sb = new StringBuilder(); 
		for (int val : a) {
			sb.append(val + " ");
		}
		System.out.println(sb);
	}

}
