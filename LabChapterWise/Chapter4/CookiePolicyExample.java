import java.net.*;

public class CookiePolicyExample {
    public static void main(String[] args) throws Exception {
        CookiePolicy policy = new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                String host = uri.getHost();
                return !host.endsWith(".gov.np");
            }
        };

        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(policy);
        CookieHandler.setDefault(manager);

        URI govUri = new URI("http://mofaga.gov.np"); // blocked
        URI eduUri = new URI("http://nepathya.edu.np"); // allowed

        HttpCookie govCookie = new HttpCookie("session", "gov_cookie");
        HttpCookie eduCookie = new HttpCookie("session", "edu_cookie");

        boolean isGovAccepted = policy.shouldAccept(govUri, govCookie);
        boolean isEduAccepted = policy.shouldAccept(eduUri, eduCookie);

        System.out.println("mofaga.gov.np cookie accepted? " + isGovAccepted);
        System.out.println("nepathya.edu.np cookie accepted? " + isEduAccepted);
    }
}
