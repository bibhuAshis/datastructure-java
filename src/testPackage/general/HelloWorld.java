package testPackage.general;

/**
 * Created by bajmd on 15/12/16.
 */

public class HelloWorld {
	
	public static void getHeight()
    {
        //Write code here
		//String[] input1 = {"5#8","5#7","6#0","5#7"};
		//int input2 = 4;
        //int count=0;
        //String ascii = "5#8";
       // for(int i=0; i<input2; i++)
       // {
           // String ascii = input1[i];
           // int a = (int) ascii.charAt(0);
            //int b = (int) ascii.charAt(2);
            //if(a >= 4 && a <= 7 && b >= 0 && b <= 11)
            	//System.out.println("0");
            	//count = 0;
            //else 
            	//System.out.println("-1");
       // }
       // if(count == 0)
       // {
           // for(int j=0;j<input2;j++)
	       // {
	           // for(int k=j+1;k<input2;k++)
	           // {
	               //(input1[j].compareTo(input1[k])>0)
	                   // count++;
	           // }
	      //  }   
       // }
        //System.out.println(count);
    }

	public static void main(String[] args) {
		String ascii = "5#10";
		if(ascii.length() == 3){
			int a = (int) ascii.charAt(0);
	        int b = (int) ascii.charAt(2);
	        if(a >= 52 && a <= 55 && b >= 48 && b <= 57)
	        	System.out.println("0");
	        else
	        	System.out.println("-1");
		}
        else if (ascii.length() == 4){
        		int a = (int) ascii.charAt(0);
    	        int b = (int) ascii.charAt(2);
    	        int c = (int) ascii.charAt(3);
    	        if(a >= 52 && a <= 55 && b == 49 && (c == 48 || c == 49))
    	        	System.out.println("0");
    	        else
    	        	System.out.println("-1");
        	}
        else
        		System.out.println("-1");
        }
		// Hello World
		/*System.out.println("Hello World!");
		
		//Type Cast		
		byte x;
		int a=270;
		double b =128.128;
		System.out.println("int converted to byte");
		x=(byte) a;
		System.out.println("a and x "+ a +" "+x);
		System.out.println("double converted to int");
		a=(int) b;
		System.out.println("b and a "+ b +" "+a);
		System.out.println("\n double converted to byte");
		x= (byte) b;
		System.out.println("b and x "+b +" "+x);
		System.out.println("\n byte converted to double");
		b= x;
		System.out.println("b and x "+ b +" "+x);
		
		//Arrays
		int Array[] = new int[5];
		int i;
			for (i=0;i<5;i++){
				Array[i] = i;
				System.out.println("Array["+i+"] = "+Array[i]);
			}*/
		
		//Object Arrays
		/*Account objArray[] = new Account[2];
		objArray[0] = new Account();
		objArray[1] = new Account();
		 
		objArray[0].setData(4,5);
		objArray[1].setData(8,9);
		
		objArray[0].printData();
		objArray[1].printData();*/
	}
//}

/*class Account{
	int a,b;
	public void setData(int c, int d){
		a = c;
		b = d;
	}
	public void printData(){
		System.out.println("Value of a is " +a);
		System.out.println("Value of b is " +b);
	}
}*/