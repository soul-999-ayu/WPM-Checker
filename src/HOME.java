/*
* Copyright (c) 2022-2023 DeadSOUL-Studios (https://github.com/deadsoul-studios)
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public
* License as published by the Free Software Foundation; either
* version 2 of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* General Public License for more details.
*
* You should have received a copy of the GNU General Public
* License along with this program; if not, write to the
* Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
* Boston, MA 02110-1301 USA
*
* Authored by: Ayush "DeadSOUL" <ayushkumar274549@gmail.com>
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.swing.*;

public class HOME extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel main = new JPanel(null);
	JPanel start = new JPanel(null);
	JPanel score = new JPanel(null);
	JLabel label[] = new JLabel[10];
	JButton button[] = new JButton[6];
	String path;
	URL icon = getClass().getResource("icon.jpg");
	
	HOME(String path){
		this.path=path;
		String labelNames[] = {"WPM Checker", "<html>WPM stands for words per minute and is used to calculate your typing speed based on how fast or slow you type.</html>", "Choose an option:", "<html>Note that the code of this program is written by a newbie so the values might be approximate and not exact.</html>", "Copyright © 2023 DeadSOUL-Studios", "Choose font:", "Your Scores:", "", "", ""};
		String buttonNames[] = {"Start", "Record", "Ink Free", "Arial", "Start", "<----"};
		
		for(int i=0; i<10; i++) {
			label[i] = new JLabel(labelNames[i]);
			label[i].setOpaque(true);
			label[i].setForeground(Color.RED);
			label[i].setFont(new Font("Ink free", Font.BOLD, 20));
			label[i].setVisible(true);
			
			if(i<6) {
				button[i] = new JButton(buttonNames[i]);
				button[i].setBackground(Color.LIGHT_GRAY);
				button[i].setBorder(null);
				button[i].setFont(new Font("Ink free", Font.BOLD, 15));
				button[i].setFocusable(false);
				button[i].setVisible(true);
				button[i].addActionListener(this);
			}
		}
		
		//Main Panel's elements
		label[0].setFont(new Font("Ink free", Font.BOLD, 25));
		label[0].setBounds(120, 10, 150, 35);
		main.add(label[0]);
		
		label[1].setForeground(Color.black);
		label[1].setBounds(20, 45, 360, 100);
		main.add(label[1]);
		
		label[2].setForeground(Color.black);
		label[2].setBounds(20, 155, 180, 35);
		main.add(label[2]);
		
		button[0].setBounds(20, 200, 160, 35);
		button[1].setBounds(220, 200, 160, 35);
		
		main.add(button[0]);
		main.add(button[1]);
		
		label[3].setFont(new Font("Ink free", Font.BOLD, 15));
		label[3].setForeground(Color.black);
		label[3].setBounds(20, 245, 360, 80);
		main.add(label[3]);
		
		label[4].setFont(new Font("Ink free", Font.BOLD, 14));
		label[4].setBounds(72, 290, 360, 100);
		main.add(label[4]);
		
		main.setBackground(this.getContentPane().getBackground());
		main.setBounds(0, 0, 400, 400);
		this.add(main);
		
		//Start Panel's elements
		button[5].setBounds(5, 10, 80, 35);
		button[5].setContentAreaFilled(false);
		button[5].setBorderPainted(false);
		button[5].setOpaque(false);
		button[5].setFont(new Font("Ink free", Font.BOLD, 20));
		
		label[5].setForeground(Color.black);
		label[5].setBounds(20, 25, 150, 80);
		label[5].setOpaque(false);
		start.add(label[5]);
		
		button[2].setBounds(20, 90, 275, 220);
		ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("inkfree.png")).getScaledInstance(button[2].getWidth(), button[2].getHeight()-20, Image.SCALE_SMOOTH));
		button[2].setIcon(imageIcon);
		button[2].setHorizontalTextPosition(JButton.CENTER);
		button[2].setVerticalTextPosition(JButton.BOTTOM);
		button[2].setBackground(Color.GREEN);
		start.add(button[2]);
		
		button[3].setBounds(302, 90, 275, 220);
		ImageIcon imageIcon1 = new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("arial.png")).getScaledInstance(button[3].getWidth(), button[3].getHeight()-20, Image.SCALE_SMOOTH));
		button[3].setIcon(imageIcon1);
		button[3].setHorizontalTextPosition(JButton.CENTER);
		button[3].setVerticalTextPosition(JButton.BOTTOM);
		button[3].setBackground(Color.RED);
		start.add(button[3]);
		
		button[4].setBounds(20, 320, 560, 35);
		start.add(button[4]);
		
		start.setBackground(this.getContentPane().getBackground());
		start.setBounds(0, 0, 600, 400);
		
		//Score Panel's elements
		label[6].setBounds(20, 50, 360, 40);
		label[6].setBackground(Color.LIGHT_GRAY);
		label[6].setForeground(Color.BLACK);
		label[6].setHorizontalAlignment(SwingConstants.CENTER);
		score.add(label[6]);
		
		label[7].setForeground(Color.BLACK);
		label[7].setBounds(20, 120, 360, 60);
		score.add(label[7]);
		
		label[8].setForeground(Color.BLACK);
		label[8].setBounds(20, 200, 360, 60);
		score.add(label[8]);
		
		label[9].setForeground(Color.BLACK);
		label[9].setBounds(20, 280, 360, 60);
		score.add(label[9]);
		
		score.setBackground(this.getContentPane().getBackground());
		score.setBounds(0, 0, 400, 400);
		
		//Main Frame
		this.setTitle("WPM Checker");
		this.setIconImage(new ImageIcon(icon).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		if(path.equals("/home/"+System.getProperty("user.name")+"/.score.txt"))
			this.setSize(new Dimension(400, 400));
		else
			this.setSize(new Dimension(410, 400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button[0]) {
			this.remove(main);
			start.add(label[0]);
			label[0].setBounds(225, 10, 150, 35);
			if(path.equals("/home/"+System.getProperty("user.name")+"/.score.txt"))
				this.setSize(new Dimension(600, 400));
			else
				this.setSize(new Dimension(610, 400));
			start.add(button[5]);
			this.add(start);
		}
		if(e.getSource()==button[1]) {
			this.remove(main);
			score.add(label[0]);
			score.add(button[5]);
			int wpm[] = null, mistakes[] = null, index = 0, count=0;
			double accuracy[] = null;
			File f = new File(path);
			if(f.exists() && !f.isDirectory()) {
				BufferedReader reader = null; 
				try{
					reader = new BufferedReader(new FileReader(path));
					while ((reader.readLine()) != null)
						count++;
					reader.close();
				}
				catch(Exception e2) {}
				
				wpm = new int[count];
				accuracy = new double[count];
				mistakes = new int[count];
				
				try{
					reader = new BufferedReader(new FileReader(path));
					String line;
					while ((line = reader.readLine()) != null){
						wpm[index] = Integer.parseInt(line.substring(line.indexOf("wpm-")+4, line.indexOf(" ")));
						accuracy[index] = Double.parseDouble(line.substring(line.indexOf("acc-")+4, line.indexOf("mistakes")-1));
						mistakes[index] = Integer.parseInt(line.substring(line.indexOf("mistakes-")+9));
						index++;
				   	}
					reader.close();
					
					int highest = 0, highest2 = 0, highest3 = 0, index1 = 0, index2 = 0, index3 = 0;
					for(int i=0; i<count; i++) {
						if(highest<wpm[i]) {
							highest=wpm[i];
							index1 = i;
						}
					}
					for(int i=0; i<count; i++) {
						if(highest2<wpm[i] && wpm[i]<highest) {
							highest2=wpm[i];
							index2 = i;
						}
					}
					for(int i=0; i<count; i++) {
						if(highest3<wpm[i] && wpm[i]<highest2) {
							highest3=wpm[i];
							index3 = i;
						}
					}

					label[7].setText("<html>1. <span style=\"color: #ff0000\">"+wpm[index1]+"</span> WPM with <span style=\"color: #ff0000\">"+accuracy[index1]+"%</span> Accuracy and <span style=\"color: #ff0000\">"+mistakes[index1]+" mistakes.</span></html>");
					if(index1!=index2)
						label[8].setText("<html>2. <span style=\"color: #ff0000\">"+wpm[index2]+"</span> WPM with <span style=\"color: #ff0000\">"+accuracy[index2]+"%</span> Accuracy and <span style=\"color: #ff0000\">"+mistakes[index2]+" mistakes.</span></html>");
					if(index1!=index3 && index2!=index3)
						label[9].setText("<html>3. <span style=\"color: #ff0000\">"+wpm[index3]+"</span> WPM with <span style=\"color: #ff0000\">"+accuracy[index3]+"%</span> Accuracy and <span style=\"color: #ff0000\">"+mistakes[index3]+" mistakes.</span></html>");
				}
				catch(Exception e2) {}
			}
			else 
				label[7].setText("No one has checked their WPM yet.");

			this.add(score);
			super.paint(getGraphics());
		}
		if(e.getSource()==button[2]) {
			if(button[2].getBackground().equals(Color.RED)) {
				button[2].setBackground(Color.GREEN);
				button[3].setBackground(Color.RED);
			}
		}
		if(e.getSource()==button[3]) {
			if(button[3].getBackground().equals(Color.RED)) {
				button[3].setBackground(Color.GREEN);
				button[2].setBackground(Color.RED);
			}
		}
		if(e.getSource()==button[4]) {
			this.dispose();
			if(button[2].getBackground().equals(Color.GREEN))
				new WPM("Ink free", path);
			else
				new WPM("Arial", path);
		}
		if(e.getSource()==button[5]) {
			this.remove(start);
			this.remove(score);
			main.add(label[0]);
			label[0].setBounds(120, 10, 150, 35);
			if(path.equals("/home/"+System.getProperty("user.name")+"/.score.txt"))
				this.setSize(new Dimension(400, 400));
			else
				this.setSize(new Dimension(410, 400));
			this.add(main);
			super.update(getGraphics());
		}
	}
}