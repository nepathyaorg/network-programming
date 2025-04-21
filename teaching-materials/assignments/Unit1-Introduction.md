1. How does client server architecture works?
	Client-server architecture is a network design model where two entities, the client and the server, interact with each other to provide services or resources. Here's how it works:

	 Roles of Client and Server
	- Client: A client is a device or software that requests services or resources. For example, a web browser on a computer, a mobile app, or a user interface for interacting with a database can be a client.
	- Server: A server is a system or software that provides services or resources to the client. It processes client requests and responds with the requested data.
	[Diagram CLient Server Architecture](https://darvishdarab.github.io/cs421_f20/assets/images/client-server-1-d85a93ea16590c10bed340dd78294d0d.png)
2. What are the factors to be considered when designing a software?
	When designing software, several critical factors must be considered to ensure efficiency, scalability, and maintainability. Here are the key factors:

	i. Functional Requirements
	Clearly define what the software should do.
	Identify user needs and expected system behaviors.
	ii. Non-Functional Requirements
	- Performance: Ensure the system meets speed, response time, and efficiency expectations.
	- Scalability: Design the software to handle increasing loads without performance issues.
	- Security: Implement authentication, authorization, encryption, and data protection.
	- Usability: The system should be user-friendly with an intuitive interface.
	- Reliability: The software should function without failures and handle errors gracefully.
	- Maintainability: The code should be modular, well-documented, and easy to update.	
	iii. Architecture and Design Patterns
	Choose a suitable architecture (e.g., monolithic, microservices, client-server).
	Apply best design patterns like MVC, MVVM, or layered architecture.
	iv. Technology Stack
	Select appropriate programming languages, frameworks, and databases based on project needs.
	Consider compatibility with existing systems and future scalability.
	v. Development Methodology
	Choose between Agile, Waterfall, DevOps, or other models based on project scope and team structure.
	vi. Testing and Quality Assurance
	Implement unit, integration, and system testing.
	Ensure security testing to prevent vulnerabilities.
	vii. Deployment and Infrastructure
	Consider cloud vs. on-premises deployment.
	Plan for CI/CD pipelines for smooth updates.
	viii. Legal and Compliance Requirements
	Ensure compliance with GDPR, HIPAA, ISO, or industry regulations.
	ix. Cost and Time Constraints
	Balance between budget, time-to-market, and feature set.
	x. User Experience (UX) and Accessibility
	Ensure accessibility for users with disabilities.
	Optimize navigation, responsiveness, and interactive elements.
3. Why do we really need network programming tools and platform? Explain some of them.
	Network programming tools and platforms are essential for developing, testing, and managing network-based applications and services. These tools help developers interact with networks, send and receive data, debug issues, and ensure efficient communication between devices.

	.Reasons for Using Network Programming Tools & Platforms
	- Efficient Communication – Allows applications to exchange data over networks (e.g., HTTP, TCP/IP, UDP).
	- Debugging and Troubleshooting – Helps developers identify and fix connectivity, security, or performance issues.
	- Security Testing – Identifies vulnerabilities in networked applications (e.g., penetration testing, firewall testing).
	- Performance Monitoring – Measures network traffic, bandwidth, and latency to optimize applications.
	- Scalability and Load Testing – Simulates real-world traffic to check how applications handle high loads.
	- Cross-Platform Compatibility – Ensures seamless communication between different devices and operating systems.
	Some Important Network Programming Tools & Platforms
	i.Wireshark
	A powerful packet analyzer used for network troubleshooting, security analysis, and protocol development.
	Captures and inspects real-time network traffic.
	ii.cURL
	A command-line tool for making network requests (HTTP, FTP, SMTP, etc.).
	Useful for API testing, web scraping, and debugging network connectivity.
	iii.Postman
	Used for testing and developing APIs.
	Allows sending HTTP requests, inspecting responses, and automating tests.
	iv.Nslookup & Dig
	Tools for querying DNS servers to troubleshoot domain name resolution issues.
	Helps diagnose network connectivity problems.
	v.Nmap (Network Mapper)
	Used for network discovery, security auditing, and vulnerability assessment.
	Scans open ports and detects active hosts on a network.