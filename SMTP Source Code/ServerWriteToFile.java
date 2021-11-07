package SMTPSocket;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ServerWriteToFile {
	private ServerResponse serverResponse;
	
	/**
     * The ServerWriteToFile constructor initiate instance of object of the class ServerResponse to be able to use recipient variable later
     * param serverResponse
     * @throws Exception
     */
    public ServerWriteToFile(ServerResponse serverResponse) throws Exception{
    	this.serverResponse = serverResponse;
    }
    
	/**
     * The writeToFile method writes the DATA that is sent by the client to a .txt file with the name of the recipient's email
	 * @param listOfmessages 
     * @throws Exception
     */
    public void writeToFile(List<String> listOfmessages) throws Exception {
 
       	  try {
	    		String filename= "C:\\Users\\user\\Desktop\\directory\\" + serverResponse.getRecipient() + ".txt"; //the filename that the txt file will be saved to
	    		FileWriter fw = new FileWriter(filename,false); //the false will not append the email's data if the file already exists
	    	    
	    		    //start from i=4 to print the email's data as DATA command is third
		    		for(int i=4; i<listOfmessages.size(); i++){ 
		    			
		    			System.out.println(listOfmessages.get(i)); //print data message to the server's terminal
		    			fw.write(listOfmessages.get(i) + "\n"); //print data message to the text file
		    		}
	    		fw.close();
	    	}
	    	catch(IOException ioe) {
	    	    System.err.println("IOException: " + ioe.getMessage());
	    	}
    }
}
