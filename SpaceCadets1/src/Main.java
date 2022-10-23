import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a departmental id:");
        String id = scanner.nextLine();

        String address = "https://www.ecs.soton.ac.uk/people/" + id;
        URL url = new URL(address);
        URLConnection conn = url.openConnection();
        InputStreamReader streamReader = new InputStreamReader(conn.getInputStream());
        BufferedReader bf = new BufferedReader(streamReader);

        String line = bf.readLine();
        while(line != null)
        {
            if(line.contains("<meta property=\"og:title\""))
            {
                String[] array = line.split("\"");
                System.out.println(array[3]);
                break;
            }
            line = bf.readLine();
        }
        bf.close();

    }
}