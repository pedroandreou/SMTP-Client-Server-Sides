# 📧 SMTP Client-Server Implementation

<div align="center">
  <img src="https://github.com/user-attachments/assets/9681c084-614e-45a0-8211-ff259371a77a" alt="SMTP Implementation Diagram" width="800"/>
</div>

## 📰 Description
Simple Mail Transfer Protocol (SMTP) is an internet standard communication protocol for electronic mail transmission. It is used to send and receive emails between two parties. To achieve this, Transmission Control Protocol (TCP) is used which allows user to establish a TCP connection on local port 25 between SMTP client and server. This would allow the client to send a series of commands, the server to reply with the corresponding responses and then, store the email's data message in a txt file representing the recipient's email.

## 🛠 Initialization & Setup
```bash
# Clone the repository
git clone https://github.com/pedroandreou/SMTP-Client-Server-Sides.git
```

## 🚀 Building and Running
1. Open two CMD windows 
2. Create an empty folder named "directory" on your Desktop for storing msgs/commands (prevents IOException)
3. Run the Server in the first CMD window:
```bash
java -cp c:\Users\user\Desktop\SMTP-Client-Server-Sides\Runnable jar\SMTP.jar SMTPSocket.SMTPServer
```
> ⚠️ Server must be started first to listen for connections

4. Run the Client in the second CMD window:
```bash
java -cp c:\Users\user\Desktop\SMTP-Client-Server-Sides\Runnable jar\SMTP.jar SMTPSocket.SMTPClient
```

## 💡 Implementation Note
This SMTP implementation connects to a local server rather than a real domain email server.

## 👤 Author
<p align="left">
  <a href="https://www.linkedin.com/in/petrosandreou80/">
    <img src="https://img.shields.io/badge/Petros_LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"/>
  </a>
</p>
