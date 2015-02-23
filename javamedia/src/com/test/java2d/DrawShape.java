package com.test.java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class DrawShape extends Frame {
	private static final long serialVersionUID = 1L;

	public DrawShape() {
		setSize(470, 350);
		setVisible(true);
	}

	public void paint(Graphics g) {
		// 取得Graphics2D对象
		Graphics2D g2 = (Graphics2D) g;
		
		// 设置渐进色
		GradientPaint gp = new GradientPaint(180, 190, Color.yellow, 220, 210,
				Color.red, true);
		g2.setPaint(gp);
		g2.setStroke(new BasicStroke(2.0f)); // 设定粗细

		// 创建直线
		Line2D.Float line = new Line2D.Float(20, 300, 200, 300);
		g2.draw(line);

		// 创建曲线
		CubicCurve2D.Float cubic = new CubicCurve2D.Float(70, 100, 120, 50,
				170, 270, 220, 100);
		g2.draw(cubic);
		
		// 创建椭圆
		Ellipse2D.Float shape = new Ellipse2D.Float(200, 200, 60, 60);
		g2.fill(shape);
	}

	public static void main(String args[]) {
		new DrawShape();
	}
}
