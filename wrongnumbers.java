import java.util.Scanner;

public class wrongnumbers {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int numOfCases= in.nextInt();
		String[] result=new String[numOfCases];
		String a="";
		String s="";
		for(int i=0;i<numOfCases;i++) {
			a=in.next();
			s=in.next();
			result[i]=checkSum(a, s);
		}
		
		for(int i=0;i<numOfCases;i++) {
			
			System.out.println(result[i]);
			
		}
		
		
	}

	private static String checkSum(String aStr, String str) {
		// TODO Auto-generated method stub
		String b="";
		char[] a=aStr.toCharArray();
//		if(str.length()>aStr.length()) {
//			for(int i=0;i<(str.length()-aStr.length());i++)
//				aStr="0"+aStr;
//		}
//		
//		System.out.println("astr="+aStr);
		char[] s=str.toCharArray();
		int countS=s.length-1;
		int countA=a.length-1;
		int len=s.length;
		while(countS>=0 && countA>=0) {
			int aInt=Character.getNumericValue(a[countA]);
			int sInt=Character.getNumericValue(s[countS]);
			//System.out.println("aInt="+aInt+" sInt="+sInt+ " countA="+countA+" countS="+countS);
			if(sInt>=aInt) {
				b=String.valueOf(sInt-aInt)+b;
				countS--;
				countA--;
			}
			else {
				
				sInt=Integer.parseInt(String.valueOf(s[countS-1]+String.valueOf(s[countS])));
				//System.out.println("look at two digits: aInt="+aInt+" sInt="+sInt+" s[countS-1]="+s[countS-1]);
				if(sInt>18)
					return "-1";
				b=String.valueOf(sInt-aInt)+b;
				countS=countS-2;
				countA--;
			}
			//System.out.println("b="+b);
		}
		
		if(countA>countS)
			return "-1";
		else if(countA<countS) {
			while(countS>=0) {
				b=s[countS]+b;
				countS--;
			}
			return b;
		}
		else {
			int bb= Integer.parseInt(b);
			return String.valueOf(bb);
		}
	}

}
