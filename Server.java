import java.io.*;
import java.util.*;
import java.net.*;

public class Server { 
 public static void main(String[] args)throws IOException {
  int port;
  Janken jk = new Janken();
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
  System.out.println("Connection accepted: " + socket);
  BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream()));
  PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter( socket.getOutputStream())), true);
  jk.Rule();
  Scanner scanner = new Scanner(System.in);
  while (true){
  System.out.println("Waiting for the other person to make a choice...");
  String str = in.readLine();
  if(str.equals("END")) break;
  int otherhand = Integer.parseInt(str);
  System.out.print("your choice = ");
  int myhand = scanner.nextInt();
  String handa = jk.Changename(myhand);
  String handb = jk.Changename(otherhand);
  String judge = jk.Judge(myhand,otherhand);
  System.out.println("My hand is [" + handa + "] : Other hand is [" + handb + "]");
  System.out.println(judge);
  System.out.println("----------------------------------------------------------");
  out.println(myhand);
  out.println(judge);
  out.println(jk.Judgeint(myhand,otherhand));
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
