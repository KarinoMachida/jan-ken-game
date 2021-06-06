import java.io.*;
import java.util.*;
import java.net.*;
public class Client {
 public static void main(String[] args)throws IOException {
  int port;
  if (args.length != 1){
	port = 8080;
  }else{
	port = Integer.parseInt(args[0]);
  }
  InetAddress addr = InetAddress.getByName("localhost");
  System.out.println("addr = " + addr);
  Socket socket = new Socket(addr, port);
  try {
 System.out.println("socket = " + socket);
 BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream()));
 PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter( socket.getOutputStream())), true);
 System.out.println("----------------------------------------------------------");
 System.out.println("rock, paper, scissors game");
 System.out.println("play games 5 times ");
 System.out.println("Typing your hand type. rock = 0, paper = 1, scissors = 2");
 System.out.println("----------------------------------------------------------");
 Scanner scanner = new Scanner(System.in);
 for(int i = 0; i < 5; i++) {
 System.out.print("your choice = ");
 int myhand = scanner.nextInt();
 System.out.println("Waiting for the other person to make a choice...");
 out.println(myhand);
 String shand = in.readLine();
 String judge = in.readLine();
 int otherhand = Integer.parseInt(shand);
 System.out.println("My hand is " + myhand + " : other hand is " + otherhand);
 System.out.println(judge);
 System.out.println("----------------------------------------------------------");
 }
 out.println("END");
 } finally {
 System.out.println("closing...");
 socket.close();
 }
 }
}
