package com.test.java2d;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class DrawImage extends Frame {
	private static final long serialVersionUID = 1L;
	String filename;

	public DrawImage(String filename) {
		setSize(470, 350);
		setVisible(true);
		this.filename = filename;
	}

	public void paint(Graphics g) {
		// 取得Graphics2D对象
		Graphics2D g2 = (Graphics2D) g;
		float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.f, -1.0f, 0.0f, -1.0f,
				0.0f };

		// 加载图片
		Image img = Toolkit.getDefaultToolkit().getImage(filename);
		int w = img.getWidth(this);
		int h = img.getHeight(this);
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

		// 创建Graphics2D对象
		Graphics2D big = bi.createGraphics();
		big.drawImage(img, 0, 0, this);

		// 阴影处理
		BufferedImageOp biop = null;
		AffineTransform at = new AffineTransform();
		BufferedImage bimg = new BufferedImage(img.getWidth(this), img
				.getHeight(this), BufferedImage.TYPE_INT_RGB);
		Kernel kernel = new Kernel(3, 3, elements);
		ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		cop.filter(bi, bimg);
		biop = new AffineTransformOp(at,
				AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		// 显示图像
		g2.drawImage(bimg, biop, 0, 0);
	}

	public static void main(String args[]) {
		new DrawImage("D:/workspace3.4/javamedia/src/com/test/image/test.jpg");
	}
}
