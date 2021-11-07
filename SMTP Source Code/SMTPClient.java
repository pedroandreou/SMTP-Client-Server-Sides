package SMTPSocket;
import java.net.*;
import java.io.*;

/**
 * This program demonstrates a SMTP client.
 * @author Petros Andreou
 */

public class SMTPClient {
		private Socket tcpSocket;
	    private InetAddress serverAddress;
	    private int serverPort;
	    private ClientCommands clientCommands;
	    
	    /**
	     * @param serverAddress
	     * @param serverPort
	     * @throws Exception
	     */
	    private SMTPClient(InetAddress serverAddress, int serverPort) throws Exception {     
	    	this.serverAddress = serverAddress;
	    	this.serverPort = serverPort;
	        //create a stream socket and connect it to the specified port number at the specified IP address to establish connection with the server
	    	this.tcpSocket = new Socket(this.serverAddress, this.serverPort);
	        this.clientCommands = new ClientCommands();
	    }
	    
	    /**
	     * The send method sends the user's input and the appropriate commands to the Server
	     * @throws Exception
	     */
	    private void send() throws Exception {
	    	
	    	 //create a new PrintWriter from an existing OutputStream (i.e., tcpSocket). 
	        //This convenience constructor creates the necessary intermediateOutputStreamWriter, which will convert characters into bytes using the default character encoding
	    	PrintWriter output = new PrintWriter(this.tcpSocket.getOutputStream(), true);
	    	
	    	listen(); //first response from the server --> 220 gov.uk <--
	    	
	    	//Call Hello Command from ClientCommand class
	    	clientCommands.helloCommand(output);
	    	listen(); //second response from the server for the HELLO command
		    
	    	
	     	//Call Mail From Command from ClientCommand class
	    	clientCommands.mailFromCommand(output);
	    	listen(); //third response from the server for the MAIL FROM command
	    	
	    	//Call Receipt to Command from ClientCommand class
	    	clientCommands.receiptToCommand(output);
	    	listen(); //fourth response from the server for the RCPT TO command
	    	 
	    	//Call Data Command from ClientCommand class
	    	clientCommands.dataCommand(output);
	    	listen(); //fifth response from the server for the DATA command
	    	
	    	//Call enterTheMessage method from ClientCommand class
	    	clientCommands.enterTheMessage(output);
	    	listen(); //sixth response from the server for the end of the email
	    	
	    	//Call Quit Command from ClientCommand class
	    	clientCommands.quitCommand(output);
	    	listen(); //seventh response from the server for the QUIT command, terminating the connection
	
	    	
	        output.flush(); //flush the writer 
   		    output.close(); //close the writer
	    }
	    
	    
	    /*
	     * The listen method receives and prints the server's responses
	     * @throws Exception
	     */
	    private void listen() throws Exception {
	    	String data = null;
	    	
	    	BufferedReader in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
	    	
	    	if((data = in.readLine()) != null) {
		    	System.out.println(data);
	    	}
	    }
	    
	    /**
	     * The start method calls the send method and closes the connection to the server
	     * @throws Exception 
	     */
	    private void start() throws Exception {
	    	send();
	    	this.tcpSocket.close(); //this is where the socket is closed in the start method, so bufferreader should be closing normally without any errors
	    }
	    
	  public static void main(String[] args) throws Exception {
		 // set the server address (IP) and port number
		 InetAddress serverIP = InetAddress.getByName("192.168.56.1"); //local IP address
		 int port = 25;
				
		 if (args.length > 0) {
				serverIP = InetAddress.getByName(args[0]);
				port = Integer.parseInt(args[1]);
		 }
			// call the constructor and pass the IP and port		
			SMTPClient client = new SMTPClient(serverIP, port);
			System.out.println("\r\nConnected to Server: " + client.tcpSocket.getInetAddress()+ "\n");
			
			client.start();
	  }
}

			
