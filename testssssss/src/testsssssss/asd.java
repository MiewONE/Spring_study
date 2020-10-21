package testsssssss;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class asd extends JFrame {
	JTextField[] tf = new JTextField[12];
	JPanel p1;
	JButton btn;
	JCheckBox cb;
	int[] data = new int[12];
	DrawingPanel drawingPanel = new DrawingPanel();

	asd() {
		setTitle("Graphic Test - Bar Graphics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		add(drawingPanel, BorderLayout.CENTER);

		newRoutine();
		setRoutine();
		addRoutine();

		setVisible(true);

	}

	void newRoutine() {
		for (int i = 0; i < 12; i++)
			tf[i] = new JTextField(3);
		btn = new JButton("Drew");
		p1 = new JPanel();
		cb = new JCheckBox("Show");
	}

	void setRoutine() {
		p1.setBackground(new Color(220, 220, 230));
	}

	void addRoutine() {
		for (int i = 0; i < 12; i++) {
			p1.add(tf[i]);
		}
		p1.add(btn);
		p1.add(cb);
		this.add(p1, BorderLayout.NORTH);

		btn.addActionListener(new DrawActionListener());
		cb.addItemListener(new ShowItemListener());
	}

	class DrawActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			for (int i = 0; i < 12; i++) {
				data[i] = Integer.parseInt(tf[i].getText());
				System.out.println(data[i]);
			}
			
			drawingPanel.setScores(data); //This Part!!
			drawingPanel.repaint();
		}
	}

	class ShowItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

		}
	}

	class DrawingPanel extends JPanel {
		int[] data;

		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.GRAY);

			for(int i=0;i<12;i++) {
			if (data[i] > 0)
				g.fillRect(100, 350 - data[i] * 2, 30, data[i] * 2);
			}
			
		}

		void setScores(int[] data) {
			for(int i=0;i<12;i++)
			this.data[i] = data[i];
			
		}

	}

	public static void main(String[] args) {
		new asd();
	}
}
