package SMTPSocket;

import java.io.PrintWriter;

/**
 * @author Petros Andreou
 */

public class ServerResponse {
	private String recipient;
	private String sender;
	private String hostname="";
	
	/**
     * The sendResponse method checks for client's command and the server responds back accordingly
     * @param otuput
     * @param response
     */
	public void sendResponse(PrintWriter output, String response) {
		String[] SeparatingTheMessageIntoParts = response.split(":"); //splitter for separating the commands from the variables
	    
        switch(SeparatingTheMessageIntoParts[0]){
           case "HELLO":
        	  //Split command line paramater at the @ character
        	  this.sender = SeparatingTheMessageIntoParts[1]; //the sender's email
              this.hostname = this.sender.substring(this.sender.indexOf("@") +1, this.sender.length()); //the hostname of the sender's email
              System.out.println("HELLO " + this.hostname); //print HELLO command and the hostname of the sender's email to the server's terminal
              output.println("250 Hello " + this.hostname + ", pleased to meet you"); //print HELLO command's response and the hostname of the sender's email to the client's terminal
              break;
              
           case "MAIL FROM":
              System.out.println("MAIL FROM:" + this.sender); //print MAIL FROM command and the sender's email to the server's terminal
              output.println("250 ok"); //print MAIL FROM command's response to the client's terminal
              break;
              
           case "RCPT TO":
               this.recipient = SeparatingTheMessageIntoParts[1]; //the recipient's email
               System.out.println("RCPT TO:" + this.recipient); //print RCPT TO command response and the recipient's email to the client's terminal
               output.println("250 ok"); //print RCPT TO command's response to the client's terminal
               break;
               
          case "DATA":
               System.out.println("DATA"); //print DATA command to the server's terminal
               output.println("354 End data with <CR><LF>. <CR><LF>"); //print DATA command's response to the client's terminal
               break;
        	  
          case "QUIT":
        	    System.out.println("QUIT"); //print QUIT command to the server's terminal
        	    output.println("221 gov.uk closing connection"); //print QUIT command's response to the client's terminal
        	  	break;

          default:
               break;
        }
	}

	/**
     * @return the recipient
     */
    public String getRecipient() {
        return this.recipient;
    }
}
