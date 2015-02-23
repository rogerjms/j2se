package com.test.image;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

public class ShowImage extends Frame {
	private static final long serialVersionUID = 1L;
	String filename;

	public ShowImage(String filename) {
		setSize(470, 350);
		setVisible(true);
		this.filename = filename;
	}

	public void paint(Graphics g) {
		// 取得图片对象
		Image image = getToolkit().getImage(filename);
		// ImageIcon icon = new ImageIcon(filename);
		// image = icon.getImage();
		// 画图
		g.drawImage(image, 0, 0, this);
	}

	public static void main(String args[]) {
		new ShowImage("D:/demo/test.jpg");
	}
}
