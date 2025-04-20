# **UNIT 3**

## 1. What is a URL?

A **Uniform Resource Locator (URL)** is an address used to identify a resource on the internet. It consists of several components such as the protocol, domain name, path, and sometimes query strings and fragments.

### URL Components:

- **Protocol**: Defines the method used to access the resource (e.g., `http`, `https`, `ftp`).
- **Domain Name**: Identifies the web server (e.g., `www.example.com`).
- **Port**: Specifies the port number on the server (optional).
- **Path**: Specifies the specific resource or file on the server (e.g., `/page.html`).
- **Query String**: Passes additional data to the resource (optional).
- **Fragment**: Identifies a specific section of the resource (optional).

### Example of a URL:

```
https://www.example.com:8080/path/to/resource?name=RohanTiwari&age=20#section2
```

#### Components Breakdown:

- **Protocol**: `https`
- **Domain**: `www.example.com`
- **Port**: `8080` (optional)
- **Path**: `/path/to/resource`
- **Query String**: `?name=RohanTiwari&age=30`
- **Fragment**: `#section2`

## 2. URLs vs URIs

- **URL (Uniform Resource Locator)**: Specifies the location of a resource on the internet and the protocol used to access it (e.g., `https://www.example.com`).

- **URI (Uniform Resource Identifier)**: A more general term that can identify a resource either by location (URL) or by name (URN). All URLs are URIs, but not all URIs are URLs.

### Examples:

- **URL**: `https://www.example.com/path/to/resource`
- **URI**: `urn:isbn:0451450523`

### Can all URLs be URIs?

Yes, **all URLs are URIs**, but not all URIs are URLs. URLs are a specific type of URI that includes the resource's location and the method for retrieving it.

---

## 3. JAVA Programs

### a) To Illustrate Important Methods of the `URL` Class

```java
import java.net.*;

public class URLMethodsExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=RohanTiwari");

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Authority: " + url.getAuthority());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
```

### b) To Retrieve Data from a URL (Different URL)

```java
import java.net.*;
import java.io.*;

public class RetrieveDataExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### c) To Check Equality of URLs (Use Case for `equals()` and `sameFile()`)

```java
import java.net.*;

public class URLComparisonExample {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("https://www.example.com/path");
            URL url2 = new URL("https://www.example.com/path");
            URL url3 = new URL("https://www.example.com/other");

            System.out.println("URL1 equals URL2: " + url1.equals(url2));
            System.out.println("URL1 equals URL3: " + url1.equals(url3));
            System.out.println("URL1 and URL2 same file: " + url1.sameFile(url2));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
```

### d) To Demo Encoding and Decoding of Special Characters Using `URLEncoder` Class

```java
import java.io.*;
import java.net.*;

public class URLEncoderExample {
    public static void main(String[] args) {
        try {
            String query = "name=Rohan Tiwari&age=20";
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            System.out.println("Encoded Query: " + encodedQuery);

            String decodedQuery = URLDecoder.decode(encodedQuery, "UTF-8");
            System.out.println("Decoded Query: " + decodedQuery);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
```

### e) To Access Password Protected Site Using Default Authentication

```java
import java.net.*;
import java.io.*;

public class DefaultAuthExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://username:password@www.example.com");
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### f) To Access Password Protected Site Asking User to Prompt for Username and Password

```java
import java.net.*;
import java.io.*;
import java.util.*;

public class PromptAuthExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        try {
            String auth = username + ":" + password;
            String encodedAuth = new String(Base64.getEncoder().encode(auth.getBytes()));

            URL url = new URL("https://www.example.com");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
