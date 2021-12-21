## Tasks:

- Implement both client and server sides of Simple Mail Transfer Protocol using OOP design 
- Establish a connection between a client who sends commands and a server which responses accordingly using the TCP protocol

## Comments:

- My SMTP does not connect to a real domain email server but instead connects to my local server

## How to run the jar file:

1. Clone the repository in your desktop by executing: **git clone https://github.com/pedroandreou/SMTP-Client-Server-Sides.git**  
2. Open two CMD windows 
3. Create an empty folder with the name "directory" on your Desktop where the msgs/commands will be saved into (to avoid IOException)
4. RUN in one of the two CMD windows: **java -cp c:\Users\user\Desktop\SMTP-Client-Server-Sides\Runnable jar\SMTP.jar SMTPSocket.SMTPServer**
- The reason why the Server side needs to be ran first is because the server must be listening before a client can establish a connection
5. In the other CMD window - RUN the following: **java -cp c:\Users\user\Desktop\SMTP-Client-Server-Sides\Runnable jar\SMTP.jar SMTPSocket.SMTPClient**
