package com.test.video;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;

public class VideoPlayer extends Frame implements ControllerListener {
	private static final long serialVersionUID = 1L;
	private int videoWidth = 0;
	private int videoHeight = 0;
	private int controlHeight = 30;
	private int insetWidth = 10;
	private int insetHeight = 30;

	private Player player;
	private Component visual;// �������
	private Component control = null;// �������

	public VideoPlayer() {
		super("��Ƶ������");
		setSize(500, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				if (player != null) {
					player.close();
				}
				System.exit(0);
			}
		});
	}

	public void play() {
		URL url = null;
		try {
			// ׼��һ��Ҫ���ŵ���Ƶ�ļ���URL
			url = new URL("file:/I:/���ϱ���/Ӱ��/MTV/K��֮��(��)MTV.mpg");

			// ͨ������Manager��createPlayer����������һ��Player�Ķ���
			// ���������ý�岥�ŵĺ��Ŀ��ƶ���
			player = Manager.createPlayer(url);
		} catch (NoPlayerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// ��player����ע����������ܸ�ż������¼�������ʱ��ִ����صĶ���
		player.addControllerListener(this);

		// ��player���������ص���Դ����
		player.realize();
	}

	// ����player������¼�
	public void controllerUpdate(ControllerEvent ce) {
		if (ce instanceof RealizeCompleteEvent) {
			// playerʵ������ɺ����player����ǰԤ����
			player.prefetch();
		} else if (ce instanceof PrefetchCompleteEvent) {
			if (visual != null)
				return;

			// ȡ��player�еĲ�����Ƶ����������õ���Ƶ���ڵĴ�С
			// Ȼ�����Ƶ���ڵ������ӵ�Frame�����У�
			if ((visual = player.getVisualComponent()) != null) {
				Dimension size = visual.getPreferredSize();
				videoWidth = size.width;
				videoHeight = size.height;
				add(visual);
			} else {
				videoWidth = 320;
			}

			// ȡ��player�е���Ƶ���ſ�������������Ѹ������ӵ�Frame������
			if ((control = player.getControlPanelComponent()) != null) {
				controlHeight = control.getPreferredSize().height;
				add(control, BorderLayout.SOUTH);
			}

			// �趨Frame���ڵĴ�С��ʹ��������Ƶ�ļ���Ĭ�ϴ�С
			setSize(videoWidth + insetWidth, videoHeight + controlHeight
					+ insetHeight);
			validate();

			// ������Ƶ���������ʼ����
			player.start();
		} else if (ce instanceof EndOfMediaEvent) {
			// ��������Ƶ��ɺ󣬰�ʱ��������ָ�����ʼ�����ٴ����¿�ʼ����
			player.setMediaTime(new Time(0));
			player.start();
		}
	}

	public static void main(String[] args) {
		VideoPlayer vp = new VideoPlayer();
		vp.play();
	}
}
