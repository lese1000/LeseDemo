package tech.lese.demo.robot;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AutoRoll extends JFrame {

	public static void main(String[] args) {
		AutoRoll frame = new AutoRoll();
		frame.setVisible(true);
	}

	private static final long serialVersionUID = 260649076714941022L;
	private JLabel label;
	private JTextField velocity;//速度输入框
	private JButton button;
	private JLabel lbls;
	private Roll roll = null;// 自动滚动线程

	public AutoRoll() {
		setAlwaysOnTop(true);//始终显示在屏幕顶端
		setTitle("自动滚动阅读");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 94);

		this.label = new JLabel("滚动速度");
		getContentPane().add(this.label, BorderLayout.WEST);

		this.velocity = new JTextField();
		this.velocity.setText("2");
		getContentPane().add(this.velocity, BorderLayout.CENTER);
		this.velocity.setColumns(10);

		this.button = new JButton("开始/停止");
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (roll == null) {
					try {
						roll = new Roll(Integer.parseInt(velocity.getText()));
					} catch (AWTException exception) {
						exception.printStackTrace();
						JOptionPane.showMessageDialog(AutoRoll.this,
								"启动自动滚动失败!");
						return;
					} catch (NumberFormatException exception) {
						exception.printStackTrace();
						JOptionPane.showMessageDialog(AutoRoll.this, "输入有误!");
						return;
					}
					roll.startRoll();
				} else {
					roll.stopRoll();
					roll = null;
				}
			}
		});
		getContentPane().add(this.button, BorderLayout.EAST);

		this.lbls = new JLabel("点击开始按钮后,点击可以滚动区域,2s后开始滚动");
		getContentPane().add(this.lbls, BorderLayout.SOUTH);
	}

}

/**
 * 自动滚动线程
 */
class Roll extends Thread {

	private int v;//速度
	private Robot robot;
	private boolean run;//是否需要继续滚动,false表示停止滚动

	public Roll(int v) throws AWTException {
		this.v = v;
		robot = new Robot();
	}

	@Override
	public void run() {
		super.run();
		do {
			robot.delay(2000);
			robot.mouseWheel(v);
		} while (this.run);
	}

	public void startRoll() {
		this.run = true;
		this.start();
	}

	public void stopRoll() {
		this.run = false;
	}

}
