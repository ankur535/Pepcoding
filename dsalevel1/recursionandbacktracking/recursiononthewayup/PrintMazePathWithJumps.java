package dsalevel1.recursionandbacktracking.recursiononthewayup;

import java.util.Scanner;

public class PrintMazePathWithJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		printMazePaths(0, 0, n - 1, m - 1, "");
	}

	// sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
    	if (sr == dr && sc == dc) {
    		System.out.println(psf);
    		return;
    	}
    	
    	//horizontal movement
    	for (int h_steps = 1; sc + h_steps <= dc; h_steps++) {
    		printMazePaths(sr, sc + h_steps, dr, dc, psf + "h" + h_steps);    		
    	}
    	
    	//vertical movement
    	for (int v_steps = 1; sr + v_steps <= dr; v_steps++) {
    		printMazePaths(sr + v_steps, sc, dr, dc, psf + "v" + v_steps);    		
    	}
    	
    	//diagonal movement
    	for (int d_steps = 1; sc + d_steps <= dc && sr + d_steps <= dr; d_steps++) {
    		printMazePaths(sr + d_steps, sc + d_steps, dr, dc, psf + "d" + d_steps);    		
    	}
    }

}
