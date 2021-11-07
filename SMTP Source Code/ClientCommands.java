package SMTPSocket;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Petros Andreou
 */

public class ClientCommands {
	private String sender;
	private String recipient;
	private Scanner scanner = new Scanner(System.in);
	
	/**
     * The isValid method checks if the email address is valid
     * @param email
     */
    private boolean emailValidation(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false;  //return false if the email address is invalid
        return pat.matcher(email).matches(); 
    } 
	
    /**
     * The helloCommand method executes the HELLO command
     * @param output
     */
	public void helloCommand(PrintWriter output) {
		System.out.println("Enter your email Address");
	    this.sender = this.scanner.nextLine(); //get the sender's email address
	    //check if the sender's email address is valid
	    while (emailValidation(this.sender) == false){ 
	    	System.out.println("Give a valid email address of yours"); //print a message to the user to give a valid email address
	    	this.sender = this.scanner.nextLine(); //get the sender's email address
	    }
	 	output.println("HELLO:" + this.sender); 	//send through the writer and print HELLO command and sender's email to the server's terminal
    	System.out.println("HELLO " + this.sender); //print HELLO command and sender's email to the client's terminal
	}
	
	/**
     * The mailFromCommand method executes the MAIL FROM command
     * @param output
     */
	public void mailFromCommand(PrintWriter output) {
		System.out.println("Enter Recipient's email Address"); 
    	this.recipient = this.scanner.nextLine(); //get the recipient's email address
    	//check if the sender's email address is valid
    	while (emailValidation(this.recipient) == false) { 
	    	System.out.println("Give a valid email address of the recipient"); //print a message to the user to give a valid email address of the recipient
	    	this.recipient = this.scanner.nextLine(); //get the recipient's email address
	    }
    	System.out.println("MAIL FROM "+ this.sender); //print MAIL FROM command and sender's email to the client's terminal
    	output.println("MAIL FROM:"+ this.sender); //send through the writer print MAIL FROM command and recipient's email to the server's terminal
	}
	
	/**
     * The receiptToCommand method executes the RCPT TO command
     * @param output
     */
	public void receiptToCommand(PrintWriter output) {
		System.out.println("RCPT TO "+ this.recipient); //print RCPT TO command and recipient's email to the client's terminal
    	output.println("RCPT TO:"+ this.recipient); //send through the writer and print RCPT TO command and recipient's email to the server's terminal
	}
	
	/**
     * The dataCommand method prints executes the RCPT TO command
     * @param output
     */
	public void dataCommand(PrintWriter output) {
		System.out.println("DATA"); //print DATA command to the client's terminal
    	output.println("DATA:"); //send through the writer and print DATA command to the server's terminal
	}
	
	/**
     * The enterTheMessage method is for receiving the email's data message
     * @param output
     */
	public void enterTheMessage(PrintWriter output) {
		String input = null;
		System.out.println("Enter the message you would like to send. Enter \".\" when you are finished");
    	input = this.scanner.nextLine(); //get the first line of the message
    	
    	//if input is not only equal to a '.' character then go to the next line
    	while(!input.equals(".")){ 
    		output.println(input);
    	    input = this.scanner.nextLine();
    	}	
    	output.println("."); //send through the writer and print "." as the end of DATA text email
	}
	
	/**
     * The quitCommand method executes the QUIT command
     * @param output
     */
	public void quitCommand(PrintWriter output) {
		System.out.println("QUIT"); //print QUIT command to the client's terminal
    	output.println("QUIT:"); //send through the writer and print QUIT command to the server's terminal
	}
}
