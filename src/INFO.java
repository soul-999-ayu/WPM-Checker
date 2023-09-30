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
import java.net.*;
import javax.swing.*;

public class INFO extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	URL icon = getClass().getResource("info.png");
	JButton butt[] = new JButton[2];
	JLabel label[] = new JLabel[4];
	
	void close() {
		this.dispose();
		WPM.i =null;
	}

	INFO(int x, int y, String path){
		String buttNames[] = {"Back", "GitHub"}, lab[] = {"About us", "", "DeadSOUL-Studios", "<html>DeadSOUL Studios is a set-up by Ayush and it provides software that are solely developed by Ayush.</html>"};
		for(int i=0; i<4; i++) {
			if(i<2) {
				butt[i] = new JButton(buttNames[i]);
				butt[i].setBackground(new Color(123,100,255));
				butt[i].setFont(new Font("Ink free", Font.PLAIN, 15));
				butt[i].setFocusable(false);
				butt[i].setVisible(true);
				butt[i].addActionListener(this);
				this.add(butt[i]);
			}
			label[i] = new JLabel(lab[i]);
			label[i].setOpaque(true);
			label[i].setFont(new Font("Ink free", Font.BOLD, 16));
			label[i].setVisible(true);
			label[i].setBackground(Color.WHITE);
			label[i].setForeground(Color.BLACK);
			this.add(label[i]);
		}
		
		label[2].setFont(new Font("Ink free", Font.BOLD, 16));
		label[3].setFont(new Font("Ink free", Font.PLAIN, 14));
		label[0].setForeground(Color.RED);
		label[0].setFont(new Font("Ink free", Font.BOLD, 18));
		label[0].setBounds(95, 5, 200, 30);
		label[1].setBounds(20, 35, 60, 60);
		label[2].setBounds(90, 45, 200, 30);
		label[3].setBounds(20, 100, 210, 60);
		butt[0].setBounds(35, 175, 80, 30);
		butt[1].setBounds(135, 175, 80, 30);
		this.getContentPane().setBackground(Color.WHITE);
		
		ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("logo.png")).getScaledInstance(label[1].getWidth(), label[1].getHeight(), Image.SCALE_SMOOTH));
		label[1].setIcon(imageIcon);
		
		//Main Frame
		this.setTitle("Information");
		this.setIconImage(new ImageIcon(icon).getImage());
		this.setResizable(false);
		this.setLayout(null);
		if(path.equals("/home/"+System.getProperty("user.name")+"/.score.txt"))
			this.setSize(new Dimension(250,250));
		else
			this.setSize(new Dimension(260,255));
		this.setLocation(x, y);
		this.setVisible(true);
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		           close();
		    }
		};
		this.addWindowListener(exitListener);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==butt[0]) 
			close();
		if(e.getSource()==butt[1]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/deadsoul-studios"));
			} catch (Exception e1) {}
		}
	}
}