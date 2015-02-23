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
			// 读入图片
			File _file = new File(file1);
			Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
			int width = src.getWidth(null); // 得到图宽
			int height = src.getHeight(null); // 得到图长

			// 图片放缩
			BufferedImage tag = new BufferedImage(width / 2, height / 2,
					BufferedImage.TYPE_INT_RGB);
			tag.getGraphics()
					.drawImage(src, 0, 0, width / 2, height / 2, null); // 绘制缩小后的图

			// 写入图片
			FileOutputStream out = new FileOutputStream(file2); // 输出到文件流
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag); // 近JPEG编码
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
