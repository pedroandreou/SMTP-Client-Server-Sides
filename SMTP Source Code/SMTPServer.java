/**
 * 
 */
package SMTPSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * This program demonstrates a SMTP client.
 * @author Petros Andreou
 */

public class SMTPServer {
    private ServerSocket server;
    private Socket client;
    private List<String> listOfmessages = new ArrayList<String>();
    private String response="";
    private boolean OneTimeServerDomain = false;
    private ServerResponse serverResponse;
    private ServerWriteToFile serverWriteToFile;
    
    /**
     * The TCPServer constructor initiate the socket
     * @param ipAddress
     * @param port
     * @throws Exception
     */
    private SMTPServer(String ipAddress, int port) throws Exception {
    	
    	if(ipAddress != null && !ipAddress.isEmpty())
    		this.server = new ServerSocket(port, 1, InetAddress.getByName(ipAddress));
    	else
    		this.server = new ServerSocket(0, 1, InetAddress.getLocalHost());
 
    	this.serverResponse = new ServerResponse();
    	this.serverWriteToFile = new ServerWriteToFile(serverResponse);
    }
    
    /**
     * The send method sends the appropriate responses to the client
     * @throws Exception
     */
    private void send() throws Exception {    	
    	    PrintWriter output = new PrintWriter(this.client.getOutputStream(), true); //for sending responses to the client
		    
    	    //it runs only once for the first response of the server
		    if(this.OneTimeServerDomain == false) { 
		    	output.println("220 gov.uk"); //print the first response of the server to the client's terminal
		    	this.OneTimeServerDomain = true; 
		    }
		    
		    //if "." is received, then it is the end of the message
		    if(this.response.equals(".")) { 
		    	output.println("250 ok Message accepted for delivery");
		    }
		    
		    //Call the ServerResposne class for check and give resposne to the client
		    this.serverResponse.sendResponse(output, this.response);
		    
		   output.flush(); //flush the writer 
    }
    
    /**
     * The listen method listen to incoming client's commands
     * @throws Exception
     */
    private void listen() throws Exception {
    	//receive client's commands through a buffer
    	BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    	
    	String data = null;
   
    	while ((data = in.readLine()) != null) {
    		
    		this.response = data; //is used in the send method  of this class to send it ServerResponse class to make the checks and give responses to client
    		send(); //call send method so the received client's command can be passed through "response" variable above
    		
    		//End of email's data from client
    		if(data.equals(".")){ 
    			serverWriteToFile.writeToFile(this.listOfmessages); //call writeToFile method so it can output the email's data to a txt file
    		}
    		
    		this.listOfmessages.add(data); //store all the data that the client sends to the arrayList
    		
    		
    		this.client.sendUrgentData(1);
    		
        }
    	in.close(); //close the buffer
    }
    
    /**
     * The start method accepts the client's request for connection, calls send and listen methods and terminates the connection
     * @throws Exception 
     */
    private void start() throws Exception {
    	this.client = this.server.accept(); //accept client's request to establish connection
    	String clientAddress = this.client.getInetAddress().getHostAddress();
    	System.out.println("\r\nNew client connection from " + clientAddress);
    	send(); //it is called for sending the very first response to the server --> 220 gov.uk <--
    	listen();
    	server.close();
    	System.out.println("Connection terminated\n");
    }
    
    /**
     * @return the IP address of the server to which the socket is connected
    */
    private InetAddress getSocketAddress() {
        return this.server.getInetAddress();
    }
    
    /**
     * @return the local port number of the server to which the socket is connected, or returns -1 if the socket is not bounded
    */
    private int getPort() {
        return this.server.getLocalPort();
    }
      
    public static void main(String[] args) throws Exception {
    	//set the server address (IP) and port number
    	String serverIP = "192.168.56.1"; // local IP address
    	int port = 25;
    	
		if (args.length > 0) {
			serverIP = args[0];
			port = Integer.parseInt(args[1]);
		}
		//call the constructor and pass the IP and port
		SMTPServer server = new SMTPServer(serverIP, port);
		System.out.println("\r\nRunning Server: " + "Host=" + server.getSocketAddress().getHostAddress() + " Port=" + server.getPort());
		server.start();
    }
}

