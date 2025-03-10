1. What is URL? Give an example of a URL that shows each components of URL. Diagrammatic representation is more preferred.

	A Uniform Resource Locator (URL) is the address of a resource on the internet. It specifies how to access the resource and its location.

	Components of a URL
	A URL is structured into multiple parts:
 Example:
	https://username:password@www.example.com:8080/path/to/resource?query=value#fragment
	.Breaking Down the Components:
	i.Scheme (Protocol) → https://
	Defines the communication protocol (e.g., http, https, ftp).
	ii.User Info (Optional) → username:password@
	Credentials for authentication.
	iii.Host (Domain or IP Address) → www.example.com
	Identifies the server.
	iv.Port (Optional) → :8080
	Specifies the port number for the service (default: 80 for HTTP, 443 for HTTPS).
	v.Path → /path/to/resource
	Indicates the location of the resource on the server.
	vi.Query String (Optional) → ?query=value
	Contains key-value pairs for additional parameters.
	vii.Fragment (Optional) → #fragment
	Refers to a specific section within a webpage.

	Diagrammatic Representation of URL
	Here’s a visual breakdown of a URL:

┌───────────┬─────────────────────────────┬──────┬───────────────────────┬────────────────────┬──────────────┬──────────────┐
│  Protocol │         User Info           │ Host │         Port          │        Path        │    Query     │   Fragment   │
├───────────┼─────────────────────────────┼──────┼───────────────────────┼────────────────────┼──────────────┼──────────────┤
│  https:// │  username:password@         │ www.example.com │ :8080 │ /path/to/resource │ ?query=value    │ #fragment │
└───────────┴─────────────────────────────┴──────┴───────────────────────┴────────────────────┴────────────
2. URLs vs URIs with examples for each. Can all URLs be URIs? Why?

	A **Uniform Resource Identifier (URI)** is a generic term that refers to a string of characters identifying a resource, while a **Uniform Resource Locator (URL)** is a specific type of URI that not only identifies a resource but also provides a means to locate it using a protocol. Essentially, all URLs are URIs, but not all URIs are URLs. A **URI** can be a **URL** (which includes location and access method) or a **URN** (Uniform Resource Name), which serves as a unique identifier without specifying a retrieval method.

For example, a **URI** can be `mailto:example@example.com`, which identifies an email address but does not specify how to retrieve it via HTTP or FTP. A **URL**, on the other hand, would be `https://www.example.com/page`, which not only identifies the resource but also tells how to access it using the HTTPS protocol.

Since a URL is a subset of a URI, every URL is inherently a URI, but not all URIs are URLs because some URIs (like URNs) do not provide a method to access the resource.
3. Write a JAVA program for each of the following: 
    - To illustrate important methods of URL class.
    - To retrieve data from a URL. Use different URL than used in the program that I demoed in the class.
    - To check equality of URLs. Describe use case for `equals()` and `sameFile()` methods.
    - To demo encoding and decoding of special characters using `URLEncoder` class.
    - To access password protected site using default authentication.
    - To access password protected site asking user to promt for username and password.

	Program:
import java.io.*;
import java.net.*;
import java.util.*;

public class URLExamples {
    public static void main(String[] args) {
        illustrateURLMethods();
        retrieveDataFromURL("https://www.example.org");
        checkURLEquality();
        encodeDecodeURL();
        accessPasswordProtectedSite();
        promptForCredentials();
    }

    // 1. Illustrate important methods of URL class
    public static void illustrateURLMethods() {
        try {
            URL url = new URL("https://www.example.com:8080/docs/resource.html?name=test#section1");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Ref: " + url.getRef());
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        }
    }

    // 2. Retrieve data from a URL
    public static void retrieveDataFromURL(String urlString) {
        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
    }

    // 3. Check equality of URLs
    public static void checkURLEquality() {
        try {
            URL url1 = new URL("https://www.example.com/docs");
            URL url2 = new URL("https://www.example.com/docs");
            URL url3 = new URL("https://www.example.com/docs/index.html");
            
            System.out.println("URL1 equals URL2: " + url1.equals(url2));
            System.out.println("URL1 same file as URL3: " + url1.sameFile(url3));
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        }
    }

    // 4. Encode and decode URL special characters
    public static void encodeDecodeURL() {
        try {
            String original = "Hello World! @#&$";
            String encoded = URLEncoder.encode(original, "UTF-8");
            String decoded = URLDecoder.decode(encoded, "UTF-8");
            
            System.out.println("Original: " + original);
            System.out.println("Encoded: " + encoded);
            System.out.println("Decoded: " + decoded);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding error: " + e.getMessage());
        }
    }

    // 5. Access a password-protected site using default authentication
    public static void accessPasswordProtectedSite() {
        try {
            URL url = new URL("https://example.com/protected");
            String auth = "username:password";
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error accessing protected site: " + e.getMessage());
        }
    }

    // 6. Prompt user for credentials to access a password-protected site
    public static void promptForCredentials() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        scanner.close();

        try {
            URL url = new URL("https://example.com/protected");
            String auth = username + ":" + password;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error accessing protected site: " + e.getMessage());
        }
    }
}



