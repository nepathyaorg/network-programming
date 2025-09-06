### 1. How does client server architecture works?

Client-Server architecture is a model where clients (users) request services from a central server. The server processes the request, retrieves the necessary data, and sends it back to the client.

How it works:  
![Client-Server Architecture](https://onlinenotesnepal.com/storage/images/mnfGHJsSJvcEADzmlWtbpgw2jYXNrq9i3BbAO4QE.png)

- The client sends a request (e.g., accessing a website, fetching data).  
- The server processes the request and responds with the requested information.  
- Communication happens through network protocols like HTTP, FTP, or TCP/IP.

Example: A web browser (client) requests a webpage from a web server, and the server responds with the webpage content.

---

### 2. What are the factors to be considered when designing a software?

When designing software, several factors need to be considered:

1. Requirements Analysis – Understanding what the software needs to do.  
2. User Experience (UX) – Making it easy and efficient for users.  
3. Security – Protecting data from unauthorized access.  
4. Scalability – Ensuring it can handle more users in the future.  
5. Performance – Fast response time and efficient resource use.  
6. Maintainability – Easy to update and fix issues.  
7. Compatibility – Works across different devices and systems.

Example: While designing a mobile app, ensuring it works on both Android and iOS is a compatibility factor.

---
### 3: Why do we really need network programming tools and platforms? Explain some of them.


Network programming tools and platforms are essential for building modern applications that rely on communication over networks, such as the internet or local networks. These tools make it easier for developers to implement features like real-time messaging, file transfers, remote access, and API communication.

1. Enabling Communication
   Network tools help in exchanging data between computers, devices, and servers. For example, they power applications like Gmail, Skype, and Facebook Messenger.

2. Remote Access and Services
   Cloud computing, remote desktops, online education, and e-commerce rely on network programming for user access and data exchange over the internet.

3. Automation and Synchronization
   Network programming tools automate tasks such as remote backups, device synchronization, system updates, and server communication.

4. Data Transfer and Monitoring
   Applications use network tools to send, receive, and track data across the internet or private networks.

Examples of Network Programming Tools and Platforms

1. Sockets (TCP/UDP):
   - TCP (Transmission Control Protocol): Ensures reliable and ordered communication between devices.
   - UDP (User Datagram Protocol): Faster, connectionless communication, used in real-time apps like online gaming.

2. Postman:
   - A platform used for testing and developing APIs.
   - Helps simulate requests (GET, POST, PUT, DELETE) and view responses to debug client-server communication.

3. Wireshark:
   - A powerful tool for monitoring, analyzing, and debugging network traffic.
   - It captures packets and helps understand how data is flowing through the network.

4. Curl (Command Line Tool):
   - Used to make network requests (HTTP, FTP, etc.) from the command line.
   - Great for quickly testing endpoints or automating web requests.

5. Netcat (nc):
   - A command-line utility for reading and writing data across network connections using TCP or UDP.
   - Useful for debugging and exploring networks.

6. OpenSSL:
   - A robust tool for managing SSL/TLS encryption.
   - Often used for secure network communication, certificate management, and HTTPS testing.

Example:
A video streaming service like Netflix needs to send and receive large volumes of video data efficiently. It uses:
- TCP Sockets for reliable streaming,
- Wireshark during development for debugging performance issues,
- Postman for testing its backend APIs,
- and Curl for automated testing of endpoints.
