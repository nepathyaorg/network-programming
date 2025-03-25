package Unit3;

import java.net.URI;

public class URIDemo {
    public static void main(String[] args) {
        // Example URIs
        URI absoluteHierarchicalURI = URI.create("https://example.com/path/to/resource?query=value#fragment");
        URI absoluteOpaqueURI = URI.create("mailto:user@example.com");
        URI relativeURI = URI.create("/path/to/resource");

        // Print URI Parts and Types
        printURIDetails(absoluteHierarchicalURI);
        printURIDetails(absoluteOpaqueURI);
        printURIDetails(relativeURI);
    }

    private static void printURIDetails(URI uri) {
        System.out.println("URI: " + uri);
        System.out.println(" - Scheme: " + uri.getScheme());
        System.out.println(" - Authority: " + uri.getAuthority());
        System.out.println(" - Path: " + uri.getPath());
        System.out.println(" - Query: " + uri.getQuery());
        System.out.println(" - Fragment: " + uri.getFragment());
        System.out.println(" - Is Absolute? " + uri.isAbsolute());
        System.out.println(" - Is Opaque? " + uri.isOpaque());
        System.out.println("---------------------------------");
    }
}
