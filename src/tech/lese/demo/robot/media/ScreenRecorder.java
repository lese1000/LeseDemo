package tech.lese.demo.robot.media;

//记录屏幕、类似录像

import java.awt.*;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;
import java.io.*;

public class ScreenRecorder extends Thread {

	private Dimension screenSize;
	private Rectangle rectangle;
	private Robot robot;
	private long i = 0;
	private JPEGImageEncoder encoder;

	public ScreenRecorder() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		rectangle = new Rectangle(screenSize);// 可以指定捕获屏幕区域
		try {
			robot = new Robot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		FileOutputStream fos = null;
		while (true) {
			try {
				BufferedImage image = robot.createScreenCapture(rectangle);// 捕获制定屏幕矩形区域
				fos = new FileOutputStream("C:\\records\\" + i + ".jpg");
				JPEGCodec.createJPEGEncoder(fos).encode(image);// 图像编码成JPEG
				fos.close();
				i = i + 1;
				Thread.sleep(40);// 每秒25帧
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				try {
					if (fos != null)
						fos.close();
				} catch (Exception e1) {
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new ScreenRecorder().start();
	}
}
