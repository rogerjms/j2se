package zhihu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Spider {
	public static void main(String[] args) {
		// ���弴�����ʵ�����
		String url = "http://www.ZhiHu.com/explore/recommendations";//�ַ���
		// �������Ӳ���ȡҳ������
		String content = Spider.SendGet(url);//��Ϊ�Ǿ�̬��������ֱ�Ӽӵ�ʹ��
		// ��ȡ�༭�Ƽ�
		ArrayList<ZhiHu> myZhiHu = Spider.GetRecommendations(content);
		// ��ӡ���
		// System.out.println(myZhiHu);
		// д�뱾��
		for (ZhiHu ZhiHu : myZhiHu) {
			FileReaderWriter.writeIntoFile(ZhiHu.writeString(),
					"D:/֪��_�༭�Ƽ�.txt", true);
		}
	}
/**����һ���ĵ�ע�͵Ĳ��� */
	public static String SendGet(String url) {
		// ����һ���ַ��������洢��ҳ���ݣ��ȴ�ŵ�һ���ַ�������perl�в�Ҳ����ô������
		String result = "";
		
		// ����һ�������ַ�������
		BufferedReader in = null;
		try {
			// ��stringת��url����
			URL realUrl = new URL(url);
			// ��ʼ��һ�����ӵ��Ǹ�url������
			URLConnection connection = realUrl.openConnection();
			// ��ʼʵ�ʵ�����
			connection.connect();
			// ��ʼ�� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));//����api��
			// ������ʱ�洢ץȡ����ÿһ�е�����
			String line;
			while ((line = in.readLine()) != null) {
				// ����ץȡ����ÿһ�в�����洢��result����
				result += line;
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally���ر�������
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	// ��ȡ���еı༭�Ƽ���֪������,����arraylist�ͷ���
	public static ArrayList<ZhiHu> GetRecommendations(String content) {
		// Ԥ����һ��ArrayList���洢���
		ArrayList<ZhiHu> results = new ArrayList<ZhiHu>();
		// ����ƥ��url��Ҳ�������������
		Pattern pattern = Pattern
				.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");
		Matcher matcher = pattern.matcher(content);
		// �Ƿ����ƥ��ɹ��Ķ���
		Boolean isFind = matcher.find();
		while (isFind) {
			// ����һ��֪���������洢ץȡ������Ϣ
			ZhiHu ZhiHuTemp = new ZhiHu(matcher.group(1));
			// ��ӳɹ�ƥ��Ľ��
			results.add(ZhiHuTemp);
			// ����������һ��ƥ�����
			isFind = matcher.find();
		}
		return results;
	}

}
