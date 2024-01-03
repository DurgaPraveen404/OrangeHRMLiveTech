package loops;

import java.util.Scanner;

public class Outputformatting
{

    public static void main(String[] args) {
    	
    	
    	Scanner sc =new Scanner(System.in);
    	String s=sc.next();
    	String rev="";
    	
    	for(int i=0;i<(s.length());i++) {
    		char ch=s.charAt(i);
    		rev=ch+rev;
    		
    	}
    	
    	System.out.println(rev);
    	
    	for(int i=0;i<(s.length());i++) {
    		char ch=s.charAt(i);
    		System.out.print(ch);
    		System.out.print(i);
    		System.out.print(" ");
    		
    	}
    	//System.out.println(s);
    	
    	
    	
    	
    	
    	
    	/*
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
               
                System.out.print(" "+ s1+ x);
            }
            System.out.println("================================");
            */

    }
}
