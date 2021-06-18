import java.io.*;
import java.util.*;
import java.net.*;

public class Client {
 public static void main(String[] args)throws IOException {
  int port;
  Boolean judgeflag = true;
  Janken jk = new Janken();
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
 jk.Rule();
 Scanner scanner = new Scanner(System.in);
 while(judgeflag){
 System.out.print("your choice = ");
 int myhand = scanner.nextInt();
 System.out.println("Waiting for the other person to make a choice...");
 out.println(myhand);
 String shand = in.readLine();
 String judge = in.readLine();
 int otherhand = Integer.parseInt(shand);
 String handa = jk.Changename(myhand);
 String handb = jk.Changename(otherhand);
 System.out.println("My hand is [" + handa + "] : Other hand is [" + handb + "]");
 System.out.println(judge);
 System.out.println("----------------------------------------------------------");
 int rsltint = Integer.parseInt(in.readLine());
 if(rsltint != 0){
	judgeflag = false;
 }
 }
 
 out.println("END");
 } finally {
 System.out.println("closing...");
 socket.close();
 }
 }
}
