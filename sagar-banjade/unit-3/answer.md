# URL and URI Concepts with Java Programs

### 1. What is a URL?

A URL (Uniform Resource Locator) is the address used to access resources on the web. It specifies the protocol used to communicate, the domain name or IP address of the server, the path to the resource, and sometimes additional parameters or query strings.

#### Components of a URL:

1. **Protocol**: Defines the method used to access the resource (e.g., HTTP, HTTPS, FTP).
2. **Host**: The domain name or IP address of the server.
3. **Port**: The port number (optional, default is 80 for HTTP and 443 for HTTPS).
4. **Path**: The location of the resource on the server.
5. **Query**: Optional. It contains parameters for the server (e.g., search parameters).
6. **Fragment**: Optional. Refers to a specific part of the resource.

#### Example of a URL:

```text
https://www.example.com:443/path/to/resource?name=value#section
```

Protocol://Host:Port/Path?Query#Fragment
| | | | | |
| | | | | +--- Fragment (Optional)
| | | | +-------- Query (Optional)
| | | +------------ Path
| | +----------------- Port (Optional)
| +----------------------- Host (Domain Name/IP)
+------------------------------- Protocol

### 2. URLs vs URIs

A URL (Uniform Resource Locator) is a type of URI (Uniform Resource Identifier). While all URLs are URIs, not all URIs are URLs.

- **URL**: Specifies the location of a resource along with the method used to access it (e.g., `http://www.example.com`).
- **URI**: A broader term that refers to any identifier that can be used to access a resource, which could be either a URL or a URN (Uniform Resource Name). A URN doesn't specify the location, just the name of the resource (e.g., `urn:isbn:0451450523`).

#### Can all URLs be URIs?

Yes, all URLs are URIs because they are identifiers that specify both the location and method to access resources.

### 3. Java Programs

#### To illustrate important methods of the URL class:

```java
import java.net.*;

public class URLExample {
    public static void main(String[] args) throws MalformedURLException {
        try {
            // Create a URL object
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=value#section");

            // Display Protocol
            System.out.println("Protocol: " + url.getProtocol());  // Output: https

            // Display Host
            System.out.println("Host: " + url.getHost());  // Output: www.example.com

            // Display Port
            System.out.println("Port: " + url.getPort());  // Output: 8080

            // Display Path
            System.out.println("Path: " + url.getPath());  // Output: /path/to/resource

            // Display Query
            System.out.println("Query: " + url.getQuery());  // Output: name=value

            // Display Fragment
            System.out.println("Fragment: " + url.getRef());  // Output: section
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
    }
}
```

### 4. To Retrieve Data from a URL

To retrieve data from a URL in Java, you can use an `InputStream` to read the content of the resource. You can open a connection to the URL and use a `BufferedReader` to read the content line by line.

#### Example:

```java
import java.io.*;
import java.net.*;

public class URLDataFetch {
    public static void main(String[] args) throws IOException {
        // Create a URL object
        URL url = new URL("https://www.example.com");

        // Reading data from the InputStream
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }
    }
}
```

### 5. To Check Equality of URLs

In Java, you can compare two URLs using the `equals()` method to check if they represent the same resource. Additionally, you can use the `sameFile()` method to determine whether two URLs refer to the same file on the server.

#### Example:

```java
import java.net.*;

public class URLEquality {
    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("https://www.example.com");
        URL url2 = new URL("https://www.example.com");

        // Using equals() method
        System.out.println("Are URLs equal? " + url1.equals(url2));  // Output: true

        // Using sameFile() method
        System.out.println("Are URLs pointing to the same file? " + url1.sameFile(url2));  // Output: true
    }
}
```

### 6. To Demo Encoding and Decoding of Special Characters Using `URLEncoder`

In Java, special characters in URLs (like spaces, `&`, `?`, `=`, etc.) need to be encoded to ensure that they are transmitted properly in the URL. The `URLEncoder` class is used to encode the string, while the `URLDecoder` class is used to decode it back to its original form.

#### Example:

```java
import java.io.*;

public class URLEncoderExample {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Encoding special characters
        String encoded = URLEncoder.encode("Hello World! @ # $", "UTF-8");
        System.out.println("Encoded: " + encoded);  // Output: Hello+World%21+%40+%23+%24

        // Decoding back to original
        String decoded = java.net.URLDecoder.decode(encoded, "UTF-8");
        System.out.println("Decoded: " + decoded);  // Output: Hello World! @ # $
    }
}
```

### 7. To Access a Password-Protected Site Using Default Authentication

In Java, you can access a password-protected site by using default authentication. This involves opening a URL connection and sending the username and password in a straightforward way (though not the most secure). Here's an example using Java's `URLConnection` class.

#### Example:

```java
import java.net.*;
import java.io.*;

public class PasswordProtectedSite {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com");

        // Open a connection to the URL
        URLConnection connection = url.openConnection();

        // Set the output stream to true
        connection.setDoOutput(true);  // Open output stream

        // Send the username and password
        connection.getOutputStream().write("username:password".getBytes());

        // Read the response from the site
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
```
