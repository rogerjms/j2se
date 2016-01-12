import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Step1 {

	public static void main(String[] args) {
		// download 114 pages data,save to path (E:\\ricedata)
		try {
			for (int i = 1; i <= 114; i++) {
				Document doc = Jsoup.connect(
						"http://www.ricedata.cn/gene/gene.aspx?&p=" + i
								+ "&gn=&sy=&cl=true").get();
				String p = "E:\\ricedata";
				PrintStream ps = null;
				try {
					FileOutputStream fos = new FileOutputStream(p + "\\" + i
							+ ".html");
					ps = new PrintStream(fos);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (ps != null) {
					System.setOut(ps);
				}
				System.out.println(doc.getElementsByTag("table").get(1));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
