
public class palindrome {
	
	public static boolean palin = false;
	public static String resPrefix = "Untouched result";
	public static String resSubstring = "Untouched result";

	public static void main(String[] args) {
		String test1 = "skyfall";
		String test2 = "minimum";
		String test23 = "racecar";
		
		String test3 = "itsaracecar";
		String test4 = "itsacar";
		String break1 = "y";
		String break2 = "";
		
		String ans = "Untouched answer";
		ans = longestPalindromeSubstring(test2);
		print("Result: "+ans);
	}

	public static String longestPalindromeSubstring(String s){
		print("\nEnter longestPalindromePrefix");
		//String res = "Untouched result";
		boolean cont = false;
		int index = 0;
		char first = '\u0021';// !
		char test = '\u0024';// $
		
		int len = 0;
		len = s.length();
		//print("Len: "+len);
		
		if(len == 0){
			print("\nEmpty string");
			resSubstring = "";
			cont = false;
		}else if(len==1){
			print("Input is inherenetly a palindrome due to length.");
			resSubstring = s;
			cont = false;
		}else if(len>1){
			print("len= "+len);
			first = s.charAt(0);
			test = s.charAt(1);
			print("First: "+first);
			print("Test: "+test);
			cont = true;
		}
		
		if(cont){
			print("Continuing...");
			for(int i=1;i<len;i++){
				first = s.charAt(i);
				
				for(int j=1;j<len;j++){
					test = s.charAt(j);
					
					if( (first!=test)  ){
						print("Bad First,Test: "+first+":"+test);
						//Move to next test, j++;
					}else if((first==test)  ){
						print("Good First,Test: "+first+":"+test);
						
						index = i;
						print("Palin: "+palin+". Calling check2: "
								+s+" "+i+" "+j);
						check2(s, i, j);
						
					}
				}
				
				
				
				
				
				
			}//end for
		}
		
		return resSubstring;
	}//end longestPalindromeSubstring
	
	public static boolean check2(String st, int start, int end){
		print("\nEnter check1()");
		boolean comp = true;
		boolean problem = false;
		int origIndex = 0;
		int backIndex = 0;
		origIndex = end;
		backIndex = end;
		print("backIndex: "+backIndex);
		char front = '\u0024';
		front = st.charAt(0);
		char back = '\u0024';
		back = st.charAt(end);
		print("Front, back: "+front+":"+back);
		
		if((end%2)==0){
			end = end/2;
			print("Even end: "+end+"\n");
		}else if((end%2)==1){
			end = (end/2) + 1;
			print("Odd piv: "+end+"\n");
//left off here
		}else{
			print("Irregular pivot: " + end+"\n");
		}
		
		for(int i=0;i<=end;i++){
			front=st.charAt(i);
			if((front!=back) && comp){
				print("Front != back: "+front+":"+back);
				comp=false;
				problem = true;
				palin=false;
			}else if((front==back) && comp){
				print("Front==back: "+front+":"+back);
				if(end>(i+1)){
					backIndex=backIndex-1;
					back=st.charAt(backIndex);
					comp=true;
				}else if(end==i){
					print("pivot reached. piv==i: "+end+":"+i);
					comp=false;
					palin=true;
				}else if(end==(i+1)){
					print("\npivot reached. piv==i+1: "+end+":"+i);
					print("Pivot char: "+st.charAt(end));
					comp=false;
					palin=true;
				}else{
					print("?");
				}
			}else{
				if(problem){
					print("Something went wrong");
				}else if(palin && !problem){
					print("origIndex: "+origIndex);
					resPrefix = st.substring(0, origIndex+1);
					print("Finished! Palindrome :"
							+resPrefix);
					
				}else{
					print("Unsure");
				}
				
				//print("Front, back: "+front+" "+back);
				//print("Front: "+cha(front));
				
			}//end if
		}//end for
		print("Palindrome: "+palin+"\n");
		return palin;
	}//end check2
	
	public static void print(String s){
		System.out.println(s);
	}
	
	public static String cha(char c){
		return Character.toString(c);
	}

}

