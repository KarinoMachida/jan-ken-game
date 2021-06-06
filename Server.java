import java.io.*;
import java.util.*;
import java.net.*;
public class Server {

 public static String Judge(int a,int b){
    if (a == 0) {
		if (b == 0) {
			return "DRAW";
		} else if (b == 1) {
			return "Server WIN";
		} else if (b == 2){
			return "Client WIN";
		}
	} else if (a == 1) {
		if (b == 0) {
			return "Client WIN";
		} else if (b == 1) {
			return "DRAW";
		} else if (b == 2){
			return "Server WIN";
		}
	} else if (a == 2){
		if (b == 0) {
			return "Server WIN";
		} else if (b == 1) {
			return "Client WIN";
		} else if (b == 2){
			return "DRAW";
		}
	} else {return "NO CONTEST";
	}
 }

 public static void main(String[] args)throws IOException {
  int port;
  if (args.length != 1){
	port = 8080;
  }else{
	port = Integer.parseInt(args[0]);
  }
  ServerSocket s = new ServerSocket(port);
  System.out.println("Started: " + s);
  try {
 System.out.println("waiting for ");
 Socket socket = s.accept();
 try {
 System.out.println(
 "Connection accepted: " + socket);
 BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream()));
 PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter( socket.getOutputStream())), true);
 System.out.println("----------------------------------------------------------");
 System.out.println("rock, paper, scissors game");
 System.out.println("play 5 times ");
 System.out.println("Typing your hand type. rock = 0, paper = 1, scissors = 2");
 System.out.println("----------------------------------------------------------");
 Scanner scanner = new Scanner(System.in);
 while (true){
 System.out.println("Waiting for the other person to make a choice...");
 String str = in.readLine();
 if(str.equals("END")) break;
 int otherhand = Integer.parseInt(str);
 System.out.print("your choice = ");
 int myhand = scanner.nextInt();
 String judge = Judge(myhand,otherhand);
 System.out.println("My hand is " + myhand + " : other hand is " + otherhand);
 System.out.println(judge);
 System.out.println("----------------------------------------------------------");
 out.println(myhand);
 out.println(judge);
 }
 } finally {
 System.out.println("closing...");
 socket.close();
 }
 } finally {
 s.close();
 }
 }
}
