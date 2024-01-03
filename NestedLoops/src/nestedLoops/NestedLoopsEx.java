package nestedLoops;
import java.util.*;

public class NestedLoopsEx {

	public static void main(String[] args) {
		
		
		for(int i=1;i<=3;i++) {
			
			for(int j=1;j<=2;j++) {
				
				System.out.println("Praveen");
				
				
			}
		}
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		
		
  
		
		
		
		
		
		for(int i=1;i<=3;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
  
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
  
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=n-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		int row=10;
		for(int i=1;i<=row;i++) {
			for(int j=row-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("* ");
			}
			System.out.println();
			
		}
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		int rows=6;
		int num=1;
		for(int i=1;i<=rows;i++) {
			for(int k=1;k<=i;k++) {
				System.out.print(num+" ");
				num++;
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		for(int i=1;i<=6;i++) {
			for(int j=i;j<=6;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		for(int i=1;i<=6;i++) {
			for (int j=i;j<=6;j++) {
				System.out.print("PA ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		for(int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				//System.out.print("PA ");
				if(i==j||i+j==10-1) {
					System.out.print("X");
				}
				else {
					System.out.print(" ");
				}
						
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		for(int i=1;i<10;i++) {
			for (int j=1;j<10;j++) {
				//System.out.print("PA ");
				if(i==1||j==1||j==9||i==5) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
						
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		
		
		
		
		
	}

}
