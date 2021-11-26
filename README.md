## Tasks:

- Implement both client and server sides of Simple Mail Transfer Protocol using OOP design 
- Establish a connection between a client who sends commands and a server which responses accordingly using the TCP protocol

## Comments:

- My SMTP does not connect to a real domain email server but instead connects to my local server

## How to run the jar file:

1. Open two CMD windows 
2. Create an empty folder with the name "directory" on your Desktop where the msgs/commands will be saved into (to avoid IOException)
3. RUN in the one of the two CMD windows: **java -cp c:\Users\user\Desktop\ah\SMTP.jar SMTPSocket.SMTPServer**
- The reason why we the Server side nees to be ran first is because the server must be listening before a client can establish a connection
4. RUN in the other CMD window: **java -cp c:\Users\user\Desktop\ah\SMTP.jar SMTPSocket.SMTPClient**
