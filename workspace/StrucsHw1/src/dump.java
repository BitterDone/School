public class dump {
	
	public void prefix(){
/*	
	
public class palindrome {
	
	public static boolean palin = false;
	public static String res = "Untouched result";

	public static void main(String[] args) {
		String test1 = "skyfall";
		String test2 = "minimum";
		String test23 = "racecar";
		String test3 = "itsaracecar";
		String test4 = "itsacar";
		String break1 = "y";
		String break2 = "";
		
		String ans = "Untouched answer";
		ans = longestPalindromePrefix(test23);
		print(ans);
	}
	
	public static String longestPalindromePrefix(String s){
		print("\nEnter longestPalindromePrefix");
		//String res = "Untouched result";
		boolean cont = false;
		int index = 0;
		char first = '\u0021';// !
		first = s.charAt(0);
		print("First: "+first);

		char test = '\u0024';// $
		test = s.charAt(0);
		print("Test: "+test);
		
		int len = 0;
		len = s.length();
		//print("Len: "+len);
		
		if(len == 0){
			print("\nEmpty string");
			res = "";
			cont = false;
		}else if(len==1){
			print("len=1");
			res = s;
			cont = false;
		}else if(len>1){
			print("len= "+len);
			test = s.charAt(1);
			cont = true;
		}
		
		if(cont){
			print("Continuing...");
			for(int i=1;i<len;i++){
				test = s.charAt(i);
				if( (first!=test) && (!palin) ){
					print("Bad: "+cha(test));
				}else if((first==test)  && (!palin) ){
					index = i;
					print("First,Test: "+first+":"+test);
					print("Palin: "+palin+". Calling check: "
							+s+" "+index);
					check(s, index);
					//print("Good: "+cha(test));
					//print("Pivot: "+pivot);
				}
				
			}//end for
		}
		
		return res;
	}//end longestPalindromePrefix
	
	public static boolean check(String st, int piv){
		print("\nEnter check()");
		boolean comp = true;
		boolean problem = false;
		int origIndex = 0;
		int backIndex = 0;
		origIndex = piv;
		backIndex = piv;
		print("backIndex: "+backIndex);
		char front = '\u0024';
		front = st.charAt(0);
		char back = '\u0024';
		back = st.charAt(piv);
		print("Front, back: "+front+":"+back);
		
		if((piv%2)==0){
			piv = piv/2;
			print("Even piv: "+piv+"\n");
		}else if((piv%2)==1){
			piv = (piv/2) + 1;
			print("Odd piv: "+piv+"\n");
//left off here
		}else{
			print("Irregular pivot: " + piv+"\n");
		}
		
		for(int i=0;i<=piv;i++){
			front=st.charAt(i);
			if((front!=back) && comp){
				print("Front != back: "+front+":"+back);
				comp=false;
				problem = true;
				palin=false;
			}else if((front==back) && comp){
				print("Front==back: "+front+":"+back);
				if(piv>(i+1)){
					backIndex=backIndex-1;
					back=st.charAt(backIndex);
					comp=true;
				}else if(piv==i){
					print("pivot reached. piv==i: "+piv+":"+i);
					comp=false;
					palin=true;
				}else if(piv==(i+1)){
					print("\npivot reached. piv==i+1: "+piv+":"+i);
					print("Pivot char: "+st.charAt(piv));
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
					res = st.substring(0, origIndex+1);
					print("Finished! Palindrome :"
							+res);
					
				}else{
					print("Unsure");
				}
				
				//print("Front, back: "+front+" "+back);
				//print("Front: "+cha(front));
				
			}//end if
		}//end for
		print("Palindrome: "+palin+"\n");
		return palin;
	}
	
	public static void print(String s){
		System.out.println(s);
	}
	
	public static String cha(char c){
		return Character.toString(c);
	}

}

	*/
		
	}

	public void sub(){
		/*
	
public class palindrome {
	
	public static boolean palin = false;
	public static boolean done = false;
	public static String resPrefix = "Untouched result";
	public static String resSubstring = "^";
	public static int currPalinLen = 0;

	public static void main(String[] args) {
		String test1 = "skyfall";
		String test2 = "minimum";
		String test23 = "racecar";
		
		String test3 = "itsaracecar";
		String test4 = "itsacar";
		String break1 = "y";
		String break2 = "";
		
		String ans = "Untouched answer";
		ans = longestPalindromeSubstring(test4);
		print("Result: "+ans);
	}

	public static String longestPalindromeSubstring(String s){
		print("\nEnter longestPalindromePrefix");
		boolean cont = false;
		int index = 0;
		char first = '\u0021';// !
		char test = '\u0024';// $
		
		int endIndex = 0;
		int len = 0;
		len = s.length();
		endIndex = s.length()-1; 
		
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
			test = s.charAt(endIndex);
			print("First: "+first);
			print("Test: "+test);
			cont = true;
		}
		
		if(cont){
			print("Continuing. Test string: "+s);
			print("end: "+s.charAt(endIndex));
			for(int i=0;i<len;i++){
				first = s.charAt(i);
				
				for(int j=endIndex;j>=0;j--){
					test = s.charAt(j);
					if( (first!=test)  ){
						print("Bad First,Test: "+first+":"+test);
						//Move to next test, j--;
					}else if((first==test)  && (!done)){
						print("Good First,Test: "+first+":"+test);
						//String ss = s.substring(i, j);
						index = i;
						if(i<=j){
							print("Palin: "+palin+". Calling check2: "
									+s+" "+i+" "+j);
							String cheque = check2(s, i, j);
						
						//Update the answer variable if a longer substring is found
						if( (palin) && (cheque.length() > resSubstring.length()) ){
							resSubstring = cheque;
							print("Updated result with "+cheque+"\n");
						}
						}
					}else{
						print("dafuq");
					}
				}
				
			
			//Move to next element from front -> back, i++;
				
			}//end for
		}
		if(resSubstring.length()==1){
			resSubstring = Character.toString(s.charAt(0));
		}
		return resSubstring;
	}//end longestPalindromeSubstring
	
	public static String check2(String st, int start, int end){
		String localResSub = "&";
		print("\nEnter check2()");
		boolean comp = true;
		boolean problem = false;
		int origIndex = 0;
		int backIndex = 0; 
		origIndex = end;
		backIndex = end;
		print("backIndex: "+backIndex);
		char front = '\u0024';
		front = st.charAt(start);
		char back = '\u0024';
		back = st.charAt(end);
		print("Front, back: "+front+":"+back);
		
		if(end<start){
			problem=true;
		}
		
		if(!done && !problem){//pointless if already done
			if(end>start){
				print("end>start");
				if((end%2)==0){
					end = end/2;
					print("Even end: "+end+"\n");
				}else if((end%2)==1){
					end = (end/2) + 1;
					print("Odd piv: "+end+"\n");
				}else{
					print("Irregular pivot: " + end+"\n");
					comp=false;
					problem=true;
					//Appropriate?
					done=true;
				}
			}else if(end==start){
				print("end=start");
				
			}else{
				print("idk");
			}
			
			for(int i=start;i<=end;i++){
				front=st.charAt(i);
				if((front!=back) && comp && !done){
					print("Front != back: "+front+"!="+back+" i:"+i+" end:"+end);
					comp=false;
					problem = true;
					palin=false;
				}else if((front==back) && comp && !done){
					print("Front==back: "+front+":"+back);
					if(end>(i+1)){
						backIndex=backIndex-1;
						back=st.charAt(backIndex);
						comp=true;
					}else if(end==i){
						print("pivot reached. piv==i: "+end+":"+i);
						if(start!=(origIndex+1)){
							localResSub = st.substring(start, origIndex+1);
						}else{
							localResSub = Character.toString(st.charAt(start));
						}
						print("Finished! Palindrome :"
								+localResSub);
						comp=false;
						palin=true;
					}else if(end==(i+1)){
						print("\npivot reached. piv==i+1: "+end+": "+i);
						print("Pivot char: "+st.charAt(end));
						if(start!=(origIndex+1)){
							localResSub = st.substring(start, origIndex+1);
						}else{
							localResSub = Character.toString(st.charAt(start));
						}
						print("Finished! Palindrome :"
								+localResSub);
						comp=false;
						palin=true;
					}else{
						print("\n?\n");
					}
				}else{
					print("");
					if(problem){
						print("Something went wrong");
					}else if(palin && !problem){
						print("origIndex: "+origIndex);
						if(start!=(origIndex+1)){
							localResSub = st.substring(start, origIndex+1);
						}else{
							localResSub = Character.toString(st.charAt(start));
						}
						print("Finished! Palindrome :"
								+localResSub);
						
					}else{
						print("\nUnsure\n");
					}
					
				}//end if
			}//end for
		}//end if(!done)
		print("Palindrome ("+palin+"): "+localResSub+"\n");
		return localResSub;
	}//end check2
	
	public static void print(String s){
		System.out.println(s);
	}
	
	public static String cha(char c){
		return Character.toString(c);
	}

}

 
		 
		 */
	}
	
	public void chips(){
		
	}
}