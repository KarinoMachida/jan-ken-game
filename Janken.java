public class Janken{

	public static void Rule(){
		System.out.println("----------------------------------------------------------");
		System.out.println("rock, paper, scissors game");
		System.out.println("Typing your hand type. rock = 0, paper = 1, scissors = 2");
	}
	
	public static int Judgeint(int a,int b){
	  int result = 0;
		if (a == 0) {
			if (b == 0) {
				result = 0;
			} else if (b == 1) {
				result = 1;
			} else if (b == 2){
				result = 2;
			}
		} else if (a == 1) {
			if (b == 0) {
				result = 2;
			} else if (b == 1) {
				result = 0;
			} else if (b == 2){
				result = 1;
			}
		} else if (a == 2){
			if (b == 0) {
				result = 1;
			} else if (b == 1) {
				result = 2;
			} else if (b == 2){
				result = 0;
			}
		} else result = 3;
	  return result;
	}

	public static String Judge(int n,int m){
		int rslt = Judgeint(n,m);
		String rsltstr = "";
		if(rslt == 0){
			rsltstr = "DRAW";
		}else if(rslt == 1){
			rsltstr = "Server WIN";
		}else if(rslt == 2){
			rsltstr = "Client WIN";
		}
		return rsltstr;
	}

	public static String Changename(int hand){
		String types;
		if(hand == 0){
			types = "Rock";
		}else if(hand == 1){
			types = "Paper";
		}else if(hand == 2){
			types = "Scissors";
		}else{
			types = "Not applicable";
		}
	  return types;
	}

	
}