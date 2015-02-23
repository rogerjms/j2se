package com.test.image;

import java.io.File;
import java.io.FileOutputStream;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ZoomImage {

	public void zoom(String file1, String file2) {
		try {
			// ����ͼƬ
			File _file = new File(file1);
			Image src = javax.imageio.ImageIO.read(_file); // ����Image����
			int width = src.getWidth(null); // �õ�ͼ��
			int height = src.getHeight(null); // �õ�ͼ��

			// ͼƬ����
			BufferedImage tag = new BufferedImage(width / 2, height / 2,
					BufferedImage.TYPE_INT_RGB);
			tag.getGraphics()
					.drawImage(src, 0, 0, width / 2, height / 2, null); // ������С���ͼ

			// д��ͼƬ
			FileOutputStream out = new FileOutputStream(file2); // ������ļ���
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag); // ��JPEG����
			out.close();
		} catch (Exception e) {
		}
	}

	public static void main(String args[]) {
		String file1 = "D:/workspace3.4/javamedia/src/com/test/image/test.jpg";
		String file2 = "D:/workspace3.4/javamedia/src/com/test/image/testzoom.jpg";
		new ZoomImage().zoom(file1, file2);
	}
}
