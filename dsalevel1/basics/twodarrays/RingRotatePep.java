package dsalevel1.basics.twodarrays;

import java.util.Scanner;

public class RingRotatePep {

	public static void main(String[] args) throws Exception {
        // write your code here
		Scanner in = new Scanner(System.in);		
		
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		int s = in.nextInt();
		int k = in.nextInt();
		
		//get 1d array
		int shell[] = getOneDArray(arr, s);
		
		//rorate 1d array
		rotateArray(shell, k);
		
		//fill 1d array
		fillArray(arr, shell, s);
		
		display(arr);
		
		in.close();
    }
	
	public static void fillArray(int arr[][], int shell[], int s) {
		
		int rmin = s-1;
		int rmax = arr.length - s;
		int cmin = s-1;
		int cmax = arr[0].length - s;
		
		int idx = 0;
		
		//left wall
		for (int i = rmin; i <= rmax; i++) {
			arr[i][cmin] = shell[idx];
			idx++;
		}
		cmin++;
		
		//bottom wall
		for (int j = cmin; j <= cmax; j++) {
			arr[rmax][j] = shell[idx];
			idx++;
		}
		rmax--;
		
		//right wall
		for (int i = rmax; i >= rmin; i--) {
			arr[i][cmax] = shell[idx];
			idx++;
		}
		cmax--;
		
		//top wall
		for (int j = cmax; j >= cmin; j--) {
			arr[rmin][j] = shell[idx];
			idx++;
		}
		rmin++;
		
	}
	
	public static void rotateArray(int shell[], int k) {
		
		int n = shell.length;
		k = k % n;
		if (k < 0) {
			k = k + n;
		}
		
		//rorate first half
		reverse(shell, 0, n-k-1);
		
		//rotate second half
		reverse(shell, n-k, n-1);
		
		//rotate full now
		reverse(shell, 0, n-1);
		
	}
	
	public static void reverse(int arr[], int i, int j) {
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	
	
	public static int[] getOneDArray(int[][] arr, int s) {
		
		int rmin = s-1;
		int rmax = arr.length - s;
		int cmin = s-1;
		int cmax = arr[0].length - s;
		
		int row_element = rmax - rmin + 1;
		int col_element = cmax - cmin + 1;
		
		int total = row_element * col_element;
		int internalTotal = (rmax - rmin - 1) * (cmax - cmin - 1);
		total = total - internalTotal;
		
		int ans[] = new int[total];
		int idx = 0;
		
		//left wall
		for (int i = rmin; i <= rmax; i++) {
			ans[idx] = arr[i][cmin];
			idx++;
		}
		cmin++;
		
		//bottom wall
		for (int j = cmin; j <= cmax; j++) {
			ans[idx] = arr[rmax][j];
			idx++;
		}
		rmax--;
		
		//right wall
		for (int i = rmax; i >= rmin; i--) {
			ans[idx] = arr[i][cmax];
			idx++;
		}
		cmax--;
		
		//top wall
		for (int j = cmax; j >= cmin; j--) {
			ans[idx] = arr[rmin][j];
			idx++;
		}
		rmin++;
		
		return ans;
		
	}
	
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
