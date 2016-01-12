import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Step3 {

	public static void main(String[] args) throws IOException {
		File file = new File("links.txt");
		if (file.isFile() && file.exists()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				String[] a = lineTxt.split("/");
				try {
					Document doc = Jsoup.connect(
							"http://www.ricedata.cn/gene/" + lineTxt).get();
					String p = "E:\\ricedata\\list";
					PrintStream ps = null;
					try {
						FileOutputStream fos = new FileOutputStream(p + "\\"
								+ a[1]);
						ps = new PrintStream(fos);
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (ps != null) {
						System.setOut(ps);
					}
					// System.out.println(doc.getElementsByClass("data-table").text());
					System.out.println(doc.getElementsByClass("data-table"));
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

	}

}
