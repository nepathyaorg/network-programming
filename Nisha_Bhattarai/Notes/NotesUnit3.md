* What is URL? Give an example of a URL that shows each components of URL. Diagrammatic representation is more preferred.
  A Uniform Resource Locator (URL) is an address used to access resources on the internet. It specifies the location of a resource and how to retrieve it.
  Components of a URL (with Example)
  https://www.example.com:8080/path/to/resource?query=value#section
  Component	         Example                     Description
  Scheme (Protocol)	 https://	                 Defines how to access the resource (HTTP, HTTPS, FTP, etc.).
  Host (Domain)	     www.example.com	         The website’s domain name or IP address.
  Port             	:8080	                     Specifies the port number (default for HTTP: 80, HTTPS: 443).
  Path	             /path/to/resource	         Specifies the resource's location on the server.
  Query Parameters	?query=value	             Provides additional information to the server.
  Fragment       	#section	                 Points to a specific section within the resource.

* URLs vs URIs with examples for each. Can all URLs be URIs? Why?
  A Uniform Resource Identifier (URI) is a more general concept that identifies a resource, whereas a URL is a type of URI that locates a resource.
  
 | Feature              | URL                                               |URI                                         |

| **Definition**       | A URL is a locator that provides the address of a resource on the internet. | A URI is a more general identifier that may be a URL or a URN. |
| **Purpose**         | Specifies how to access a resource (with a scheme like `http`, `ftp`, etc.). | Can be a URL (locator) or URN (name) without specifying access details. |
| **Contains Protocol?** | Yes (`http://`, `ftp://`, etc.).                     | Not always required.                        |
| **Example**         | `https://www.example.com/index.html`                  | `mailto:user@example.com` (Not a URL, but a URI identifying an email). |


 Yes, all URLs are URIs because a URL is a specific type of URI that includes a way to locate a resource.

 Examples of URL & URI
 | Feature              | URL                                                |URI                                       |

| **Definition**       | A URL is a locator that provides the address of a resource on the internet. | A URI is a more general identifier that may be a URL or a URN. |
| **Purpose**         | Specifies how to access a resource (with a scheme like `http`, `ftp`, etc.). | Can be a URL (locator) or URN (name) without specifying access details. |
| **Contains Protocol?** | Yes (`http://`, `ftp://`, etc.).                     | Not always required.                        |
| **Example**         | `https://www.example.com/index.html`                  | `mailto:user@example.com` (Not a URL, but a URI identifying an email). |

   