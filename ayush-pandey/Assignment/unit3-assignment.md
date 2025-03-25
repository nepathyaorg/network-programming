
# URL and URI Concepts with Java Programs

## 1. What is a URL?

A **URL** (Uniform Resource Locator) is the address used to access resources on the web. It specifies the protocol used to communicate, the domain name or IP address of the server, the path to the resource, and sometimes additional parameters or query strings.

### Components of a URL:

1. **Protocol**: Defines the method used to access the resource (e.g., HTTP, HTTPS, FTP).
2. **Host**: The domain name or IP address of the server.
3. **Port**: The port number (optional, default is 80 for HTTP and 443 for HTTPS).
4. **Path**: The location of the resource on the server.
5. **Query**: Optional. It contains parameters for the server (e.g., search parameters).
6. **Fragment**: Optional. Refers to a specific part of the resource.

### Example of a URL:
```
https://www.example.com:443/path/to/resource?name=value#section
```

- `https`: Protocol
- `www.example.com`: Host
- `443`: Port
- `/path/to/resource`: Path
- `name=value`: Query
- `#section`: Fragment

### Diagrammatic Representation:

```
Protocol://Host:Port/Path?Query#Fragment
   |        |    |   |    |    |
   |        |    |   |    |    +--- Fragment (Optional)
   |        |    |   |    +-------- Query (Optional)
   |        |    |   +------------ Path
   |        |    +----------------- Port (Optional)
   |        +----------------------- Host (Domain Name/IP)
   +------------------------------- Protocol
```

---

## 2. URLs vs URIs

A **URL** (Uniform Resource Locator) is a type of **URI** (Uniform Resource Identifier). While all URLs are URIs, not all URIs are URLs.

- **URL**: Specifies the location of a resource along with the method used to access it (e.g., `http://www.example.com`).
  
- **URI**: A broader term that refers to any identifier that can be used to access a resource, which could be either a URL or a URN (Uniform Resource Name). A URN doesn't specify the location, just the name of the resource (e.g., `urn:isbn:0451450523`).

**Can all URLs be URIs? Yes, all URLs are URIs** because they are identifiers that specify both the location and method to access resources.

---

## 3. Java Programs

### To illustrate important methods of the URL class:

```java
import java.net.*;

public class URLExample {
    public static void main(String[] args) throws MalformedURLException {
        try {
            // URL object banako
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=value#section");

            // Protocol dekhaune
            System.out.println("Protocol: " + url.getProtocol());  // Output: https

            // Host dekhaune
            System.out.println("Host: " + url.getHost());  // Output: www.example.com

            // Port dekhaune
            System.out.println("Port: " + url.getPort());  // Output: 8080

            // Path dekhaune
            System.out.println("Path: " + url.getPath());  // Output: /path/to/resource

            // Query dekhaune
            System.out.println("Query: " + url.getQuery());  // Output: name=value

            // Fragment dekhaune
            System.out.println("Fragment: " + url.getRef());  // Output: section
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
    }
}
```

- URL ko object banaye, tyo URL bata protocol, host, port, path, query, ra fragment janne.

---

### To retrieve data from a URL:

```java
import java.io.*;
import java.net.*;

public class URLDataFetch {
    public static void main(String[] args) throws IOException {
        // URL object banaye
        URL url = new URL("https://www.example.com");

        // InputStream bata data read garne
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }
    }
}
```

- URL bata data read garne, stream open garera.

---

### To check equality of URLs:

```java
import java.net.*;

public class URLEquality {
    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("https://www.example.com");
        URL url2 = new URL("https://www.example.com");

        // equals() method ko use
        System.out.println("Are URLs equal? " + url1.equals(url2));  // Output: true

        // sameFile() method ko use
        System.out.println("Are URLs pointing to the same file? " + url1.sameFile(url2));  // Output: true
    }
}
```

- `equals()` le URL ko samanata herne, ra `sameFile()` le dui URL ekai file ma cha ki nai herne.

---

### To demo encoding and decoding of special characters using `URLEncoder`:

```java
import java.io.*;

public class URLEncoderExample {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Special characters encode garne
        String encoded = URLEncoder.encode("Hello World! @ # $", "UTF-8");
        System.out.println("Encoded: " + encoded);  // Output: Hello+World%21+%40+%23+%24

        // Decoding back to original
        String decoded = java.net.URLDecoder.decode(encoded, "UTF-8");
        System.out.println("Decoded: " + decoded);  // Output: Hello World! @ # $
    }
}
```

- Special characters haru encode garne ra decode garne `URLEncoder` ra `URLDecoder` ko use garera.

---

### To access a password-protected site using default authentication:

```java
import java.net.*;
import java.io.*;

public class PasswordProtectedSite {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com");
        
        // Default authentication garne
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);  // Output stream open garne
        connection.getOutputStream().write("username:password".getBytes());
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
```

- Password protected site ma login garne, default authentication use garera.

---

### To access a password-protected site asking the user for username and password:

```java
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class PasswordPromptSite {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        // User bata username ra password lina
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        URL url = new URL("https://www.example.com");
        URLConnection connection = url.openConnection();

        // Authentication ko header set garne
        String auth = username + ":" + password;
        String encodedAuth = new String(java.util.Base64.getEncoder().encode(auth.getBytes()));
        connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
```


