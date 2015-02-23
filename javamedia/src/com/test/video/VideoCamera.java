package com.test.video;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.media.Buffer;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class VideoCamera extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private MediaLocator mediaLocator = null;
	private Player player = null;
	private ImagePanel imagePanel = null;
	private Button ok, cancel;

	public VideoCamera() {
		// 主窗口
		super("视频捕捉");
		setSize(300, 500);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				player.close();
				System.exit(0);
			}
		});

		// 按钮面板
		Panel panel = new Panel();
		ok = new Button("拍 照");
		cancel = new Button("重拍");
		ok.addActionListener(this);
		cancel.addActionListener(this);
		panel.add(ok);
		panel.add(cancel);
		add(panel, "Center");

		// 图片面板
		imagePanel = new ImagePanel();
		add(imagePanel, "South");

		// 视频面板
		CaptureDeviceManager
				.getDevice("vfw:Microsoft WDM Image Capture (Win32):0");
		mediaLocator = new MediaLocator("vfw://0");
		try {
			player = Manager.createRealizedPlayer(mediaLocator);
			player.start();
			Component comp;
			if ((comp = player.getVisualComponent()) != null)
				comp.setBounds(0, 0, 240, 180);
			add(comp, "North");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			FrameGrabbingControl fgc = (FrameGrabbingControl) player
					.getControl("javax.media.control.FrameGrabbingControl");
			Buffer buffer = fgc.grabFrame();
			BufferToImage bufferToImage = new BufferToImage(
					(VideoFormat) buffer.getFormat());
			Image image = bufferToImage.createImage(buffer);
			imagePanel.setImage(image);
			imagePanel.saveImage(image, "D:/app/"+System.currentTimeMillis()+".jpg");
		} else if (e.getSource() == cancel) {
			imagePanel.setImage(null);
		}
	}

	

	// 图片面板
	class ImagePanel extends Panel {
		private static final long serialVersionUID = 1L;
		public Image myimg = null;

		public ImagePanel() {
			setLayout(null);
			setSize(240, 180);
		}

		public void setImage(Image img) {
			this.myimg = img;
			repaint();
		}

		public void paint(Graphics g) {
			if (myimg != null) {
				g.drawImage(myimg, 0, 0, this);
			}
		}
		
		// 保存图片
		public void saveImage(Image image, String path) {
			// 图片缓存
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bi = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(image, null, null);
			// 写入文件
			try {
				// 打开文件
				FileOutputStream fos = new FileOutputStream(path);
				// JPG编码
				JPEGImageEncoder je = JPEGCodec.createJPEGEncoder(fos);
				JPEGEncodeParam jp = je.getDefaultJPEGEncodeParam(bi);
				jp.setQuality(1f, false);
				je.setJPEGEncodeParam(jp);
				je.encode(bi);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new VideoCamera();
	}
}
