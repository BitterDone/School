
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

