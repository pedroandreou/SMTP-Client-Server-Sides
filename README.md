## 📰 Description
Simple Mail Transfer Protocol (SMTP) is an internet standard communication protocol for electronic mail transmission 1 . It is used to send and receive emails between two parties. To achieve this, Transmission Control Protocol (TCP) is used which allows user to establish a TCP connection on local port 25 between SMTP client and server. This would allow the client to send a series of commands, the server to reply with the corresponding responses and then, store the email’s data message in a txt file representing the recipient’s email

## 🛠 Initialization & Setup
#### Clone the repository  
    git clone https://github.com/pedroandreou/SMTP-Client-Server-Sides.git


## 🚀 Building and Running
1. Open two CMD windows 
2. Create an empty folder with the name "directory" on your Desktop where the msgs/commands will be saved into (to avoid IOException)
3. RUN in one of the two CMD windows:  
    **java -cp c:\Users\user\Desktop\SMTP-Client-Server-Sides\Runnable jar\SMTP.jar SMTPSocket.SMTPServer**
- The reason why the Server side needs to be ran first is because the server must be listening before a client can establish a connection
4. In the other CMD window - RUN the following:  
    **java -cp c:\Users\user\Desktop\SMTP-Client-Server-Sides\Runnable jar\SMTP.jar SMTPSocket.SMTPClient**

## :speech_balloon: Comment
My SMTP does not connect to a real domain email server but instead connects to my local server

## ⚠ Important
More info about my project can be found in my [portfolio](https://pedroandreou.github.io/#SMTP)

## Author  
👨🏼 Petros Andreou

Github: [@Petros](https://github.com/pedroandreou)  
LinkedIn: [@Petros](https://www.linkedin.com/in/petrosandreou80/)


