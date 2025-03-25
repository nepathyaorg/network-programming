# **UNIT 1 **

## **How does Client-Server Architecture work?**

Client-server architecture is a way of structuring programs where a **client** (like a Java application) requests services from a **server** (another Java program or web service).

### **How it Works:**

1. The **client** sends a request (e.g., fetch data, save a file, send a message).
2. The **server** processes the request and sends back a response.
3. The client receives and displays or processes the response.

### **Example in Java:**

- **Client:** A Java program using `Socket` to connect to a server.
- **Server:** A Java application running a `ServerSocket` to listen for client connections.

## **Factors to Consider When Designing Software**

When designing software, we must think about:

1. **Purpose** – What problem does the program solve?
2. **Scalability** – Can it handle many users at the same time?
3. **Security** – How do we protect data from hackers?
4. **Performance** – Is it fast and efficient?
5. **Maintainability** – Is the code easy to update and debug?
6. **Technology Stack** – Are we using Java libraries that fit the project?
7. **User Experience** – Is it easy to use?
8. **Reliability** – Does it handle failures without crashing?
9. **Testing** – Have we tested all possible scenarios?

## **Why Do We Need Network Programming Tools and Platforms?**

Network programming allows Java applications to communicate over a network (e.g., the internet or a local network).

### **Why We Need It:**

- **File Sharing** – Sending or receiving files over a network.
- **Messaging** – Chat applications.
- **Remote Access** – Controlling a system from another location.
- **APIs** – Fetching data from web services.

### **Common Network Programming Tools in Java:**

1. **Sockets (`Socket`, `ServerSocket`)** – Allows communication between a client and a server.
2. **HTTP Client (`HttpURLConnection`)** – Used for making web requests.
3. **Java RMI (Remote Method Invocation)** – Runs methods on a remote machine.
4. **Multithreading (`Thread`)** – Handles multiple clients in a server.
5. **Java NIO (`Selector`, `Channel`)** – For high-performance networking.

## **What is the Role of Sockets in Java Network Programming?**

Sockets enable communication between two machines over a network. In Java, they help establish a connection between a **client** and a **server**.

### **Types of Sockets:**

1. **TCP Sockets (`Socket`, `ServerSocket`)** – Ensures reliable data transmission.
2. **UDP Sockets (`DatagramSocket`)** – Faster but does not guarantee delivery.

### **How Sockets Work:**

1. The server creates a `ServerSocket` and waits for client connections.
2. The client creates a `Socket` and connects to the server.
3. Data is sent and received through input and output streams.
4. Both sides close the connection after communication is done.
