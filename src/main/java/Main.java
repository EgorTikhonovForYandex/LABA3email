import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect( "https://it.wikireading.ru/4064").get();

        Pattern p = Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9_.+]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+ ");
        Matcher matcher = p.matcher(doc.text());
        Set<String> emails = new HashSet< >();
        while (matcher.find()) {
            emails.add(matcher.group());
        }


        System.out.println(emails);


    }

}
