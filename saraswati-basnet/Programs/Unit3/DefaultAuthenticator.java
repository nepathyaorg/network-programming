import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class DefaultAuthenticator {

    public static void main(String[] args) {
        //5. To access password protected site using default authentication

        //Setting the default authenticator

        Authenticator.setDefault(new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                //Provide the default username and password
                return new PasswordAuthentication("myuser","mypassword" .toCharArray());
            }
        });

        try {
            URL url = new URL("https://httpbin.org/basic-auth/myuser/mypassword");
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while((line = reader.readLine())!=null){
                    System.out.println(line);


                }
                reader.close();
            }else{
                System.out.println("Authentication failed with response code: " + responseCode);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
