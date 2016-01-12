import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//���˳�������������ȥ���࣬���ս������links.txt
public class Step2 {

	public static void main(String[] args) throws IOException {
		File input = new File("e:\\ricedata");
		File[] inputs = input.listFiles();
		for (int i = 0; i < inputs.length; i++) {
			File f = inputs[i];
			Document doc = Jsoup.parse(f, "utf-8");
			Elements links = doc.select("a[href^=list/]");
			for (Element link : links) {
				System.out.println(link.attr("href"));
			}
		}

	}

}
