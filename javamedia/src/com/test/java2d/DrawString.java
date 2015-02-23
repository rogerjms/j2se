package com.test.java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

public class DrawString extends Frame {
	private static final long serialVersionUID = 1L;

	public DrawString() {
		setSize(470, 350);
		setVisible(true);
	}

	public void paint(Graphics g) {
		// 取得Graphics2D对象
		Graphics2D g2 = (Graphics2D) g;
		
		// 显示文字
		FontRenderContext frc = g2.getFontRenderContext();
		TextLayout tl = new TextLayout("测试文字", new Font("Modern", Font.BOLD
				+ Font.ITALIC, 20), frc);
		
		// 线形
		Shape sha = tl
				.getOutline(AffineTransform.getTranslateInstance(50, 180));
		g2.setColor(Color.blue);// 颜色
		g2.setStroke(new BasicStroke(2.0f));// 粗细
		g2.draw(sha);
		g2.setColor(Color.white);
		g2.fill(sha);
	}

	public static void main(String args[]) {
		new DrawString();
	}
}
