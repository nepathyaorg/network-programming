# **UNIT 2**

## 1️⃣ To Illustrate Important Methods of the `URL` Class

The `URL` class in Java provides methods to work with URLs. It can be used to access and manipulate various components of a URL.

### 📝 **Java Program to Demonstrate Methods of `URL` Class**

````java
import java.net.*;

public class URLMethodsExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=JohnDoe#fragment");

            System.out.println("URL: " + url);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Ref: " + url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

---

## 2️⃣ To Retrieve Data from a URL

To retrieve data from a URL, we use the `openStream()` method of the `URL` class to fetch input from the web.

### 📝 **Java Program to Retrieve Data from a URL**

```java
import java.io.*;
import java.net.*;

public class URLDataRetrieval {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.org");
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


---

## 3️⃣ To Check Equality of URLs

The `equals()` and `sameFile()` methods in the `URL` class help check if two URLs are the same.

- **`equals()`**: Compares two URLs for equality. It checks if both URLs refer to the same resource.
- **`sameFile()`**: Checks if two URLs refer to the same file, independent of the protocol and host.

### 📝 **Java Program to Compare URLs Using `equals()` and `sameFile()`**

```java
import java.net.*;

public class URLEqualityExample {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("https://www.example.com/index.html");
            URL url2 = new URL("https://www.example.com/index.html");
            URL url3 = new URL("https://www.example.org/index.html");

            System.out.println("URL1 equals URL2: " + url1.equals(url2)); // true
            System.out.println("URL1 sameFile URL3: " + url1.sameFile(url3)); // false
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

---

## 4️⃣ To Demonstrate Encoding and Decoding of Special Characters Using `URLEncoder`

The `URLEncoder` class is used to encode data for use in a URL and decode it back. Special characters like spaces, `&`, `=`, etc., need to be encoded to ensure a proper URL format.

### 📝 **Java Program for Encoding and Decoding Using `URLEncoder`**

```java
import java.io.*;
import java.net.*;

public class URLSpecialCharacterEncoding {
    public static void main(String[] args) {
        try {
            String text = "Hello World! Special characters: & = ?";
            String encodedText = URLEncoder.encode(text, "UTF-8");
            String decodedText = URLDecoder.decode(encodedText, "UTF-8");

            System.out.println("Encoded Text: " + encodedText);
            System.out.println("Decoded Text: " + decodedText);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}


---

## 5️ To Access a Password-Protected Site Using Default Authentication

Java provides the ability to access password-protected resources using basic authentication by passing the credentials via the `Authenticator` class.

### 📝 **Java Program for Default Authentication**

```java
import java.net.*;
import java.io.*;

public class URLAuthenticationExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com/securepage");

            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("username", "password".toCharArray());
                }
            });

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



---

## 6️ To Access a Password-Protected Site by Prompting User for Username and Password

Here, we prompt the user for their credentials to access a password-protected site.

### 📝 **Java Program for Prompting User for Credentials**

```java
import java.net.*;
import java.io.*;
import java.util.*;

public class UserPromptAuthenticationExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com/securepage");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            char[] password = System.console().readPassword();

            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

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
````
