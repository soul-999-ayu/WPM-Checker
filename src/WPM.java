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
import java.math.*;
import java.net.URL;
import java.time.LocalTime;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class WPM extends JFrame implements ActionListener{
	
	Random random = new Random();
	private static final long serialVersionUID = 1L;
	int select_para = random.nextInt(5);
	String para[] = {
			"Jim and Anne will be in charge of the spring field day to be held in early June. They will ask their friends' aid to get set up. There will be games for the boys and girls. The children will want to hike, ride their bikes, and swim. This yearly event will be held in the new Peach Grove Park. Ruth has work to do on the plans for food for the day. Last year Ruth spent most of her time helping the two cooks with many snacks. Hot dogs, fries, soft drinks, ice cream, and candy apples were big sellers. Apple pie and ice cream sold well too. I hope Ruth serves the same food this year. George Long will hire the band and singer for the day. A great jazz band will play. George's mom leads the group. The jazz band is sure to be one of the big hits. George is to have them play from one to four and also in the evening. The fine songs they will play are sure to please all of us. Nice gifts will be given to all of the winners in each of the events. Local news coverage will include television and newspapers. Joyce Scott will take care of the pictures for the school paper and yearbook.",
			"Bali is predominantly a Hindu country. Bali is known for its elaborate, traditional dancing. The dancing is inspired by its Hindi beliefs. Most of the dancing portrays tales of good versus evil. To watch the dancing is a breathtaking experience. Lombok has some impressive points of interest – the majestic Gunung Rinjani is an active volcano. It is the second highest peak in Indonesia. Art is a Balinese passion. Batik paintings and carved statues make popular souvenirs. Artists can be seen whittling and painting on the streets, particularly in Ubud. It is easy to appreciate each island as an attractive tourist destination. Majestic scenery; rich culture; white sands and warm, azure waters draw visitors like magnets every year. Snorkelling and diving around the nearby Gili Islands is magnificent. Marine fish, starfish, turtles and coral reef are present in abundance. Bali and Lombok are part of the Indonesian archipelago. Bali has some spectacular temples. The most significant is the Mother Temple, Besakih. The inhabitants of Lombok are mostly Muslim with a Hindu minority.",
			"Martin Luther King Jr. led many demonstrations against racism. He delivered his message in a non-violent manner. Some members of his movement later engaged in less peaceful protests. Luther King was detained several times. The longest jail sentence he received was four months. Martin Luther King’s famous 1963 speech, “I Have a Dream”, inspired many African-Americans to envisage a better future. Luther King was an American citizen. Nelson Mandela is a native South African. Their dreams were the same. Their battles were tumultuous. Nelson Mandela was arrested in 1962 for treason. He was incarcerated for twenty-seven years. Nelson Mandela and Martin Luther King Jr. both fought for racial equality. The intolerance of white people towards black co-inhabitants was the catalyst for years of activism. In 1994, Nelson Mandela became the first black president of South Africa. He was the first president elected by the people. Mandela and Luther King have been awarded the Nobel Peace Prize for their dedication to improving civil rights for black people.",
			"Several years ago, Channel 4, together with Jo Frost (perhaps better known as Supernanny) conducted an experiment. Forty children, aged six, were invited to a party and divided into two halves. One half was given typical sugary party foods. The other half ate sugar-free foods. The parents were unaware as to which group their child was in. No artificial colourings or flavourings commonly found in sweets were present. Artificial colourings and flavourings have already been linked to hyperactivity. Many parents believe that sugar consumption causes hyperactivity in their children. ‘Sugar highs’ are often blamed for rowdiness or excitability, but is sugar guilty of causing hyperactivity or is it simply a case of ‘normal’ childhood behaviour? As the children ran about and enjoyed the party, the parents were asked whether they believed their own child had been given sugar. The majority believed they had. As the children sat down to watch a magic show, many parents changed their minds. They could not accept that their child was capable of sitting still after consuming sugary foods.",
			"Many parents believe that sugar consumption causes hyperactivity in their children. Indeed, ‘sugar highs’ are often blamed for rowdiness or excitability – but is sugar the guilty party, or is it simply a case of ‘normal’ childhood behaviour? Several years ago, Channel 4, together with Jo Frost (perhaps better known as Supernanny) conducted an experiment to distinguish the truth. Forty children, aged six, were invited to a party and divided into two halves. One half was given typical sugary party foods; the other half ate sugar-free alternatives. Crucially, the parents of the children were unaware as to which group their child was in. (Incidentally, no artificial colourings or flavourings commonly found in sweets were present, since these have already been linked to hyperactivity.) Subsequently, as the children ran about and enjoyed the party, the parents were asked whether they believed their own child had been given sugar. The majority believed they had. Ironically, as the children then sat down to watch a magic show, most parents changed their minds."
	}, buttonNames[] = {"", "Homepage", "Restart"}, path;
	
	JPanel panel = new JPanel(null);
	JLabel label[] = new JLabel[5];
	JTextField field;
	Timer timer = new Timer();
	boolean start=false;
	int seconds = 60;
	double startTime;
	JButton button[] = new JButton[3];
	static INFO i = null;
	URL icon = getClass().getResource("icon.jpg");
	
	void result() {
		field.setEnabled(false);
        int wpm = (int) ((((double)field.getText().length() / 5) / ((LocalTime.now().toNanoOfDay() - startTime)/1000000000.0))* 60), mistakes = 0, nextChar = 1;
       	String[] given = para[select_para].split(" "), output = field.getText().split(" ");

	    for (int i = 0; i < output.length; i++) {
	      if (!output[i].equals(given[i+nextChar-1])) {
	    	  if(output[i].equals(given[i+nextChar])) {
	    		  mistakes++;
	    		  nextChar++;
	    	  }
	    	  else
	    		  mistakes++;
	      }
	    }   
	    double accuracy = new BigDecimal(100-(((double)mistakes/(double)output.length)*100)).setScale(2, RoundingMode.HALF_UP).doubleValue();  
	    label[2].setText("Your WPM is: "+wpm+" and your accuracy is: "+accuracy+"% (You did "+mistakes+" mistakes)");
	    
	    BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(path , true)); 
		   	writer.append("wpm-"+wpm+" acc-"+accuracy+" mistakes-"+mistakes+"\n");
		} catch (Exception e) {}
		finally {
			try {
				writer.close();
			} catch (Exception e) {}
		}
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		label[0].setText("The test is over, You did great!");
		label[0].add(button[1]);
		label[0].add(button[2]);
	}
	
	WPM(String font, String path){
		this.path=path;
		
		field = new JTextField();
		field.setFont(new Font(font, Font.PLAIN, 15));
		field.setBounds(20, 390, (int) 860, 40);
		field.setForeground(Color.BLACK);
		field.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	            if(!start) {
	            	startTime = LocalTime.now().toNanoOfDay();
	                timer = new Timer();
	                timer.schedule(new TimerTask() {
	                    @Override
	                    public void run() {
	                    	if(seconds==0) {
	                    		timer.cancel();
	                    		result();
	                    	}
	                    	label[1].setText("Time: "+seconds);
	                    	seconds--;
	                    }
	                }, 0, 1000);
		    		start=true;
	            }
	            if(e.getKeyCode()==KeyEvent.VK_ENTER) {
	            	timer.cancel();
	            	result();
	            }
	        }
	        public void keyTyped(KeyEvent e) {}
	        public void keyPressed(KeyEvent e) {}
	    });
		
		for(int i=0; i<5; i++) {
			label[i] = new JLabel("<html>"+para[select_para]+"</html>");
			label[i].setOpaque(true);
			label[i].setBackground(Color.LIGHT_GRAY);
			label[i].setForeground(Color.RED);
			label[i].setFont(new Font(font, Font.BOLD, 20));
			label[i].setVisible(true);
			
			if(i<3) {
				button[i] = new JButton(buttonNames[i]);
				button[i].setBackground(Color.black);
				button[i].setBorder(null);
				button[i].setFont(new Font(font, Font.PLAIN, 15));
				button[i].setFocusable(false);
				button[i].setVisible(true);
				button[i].addActionListener(this);
			}
		}
		
		panel.add(button[0]);
		button[0].setBounds(820, 2, 30, 30);
		ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("info-dark.png")).getScaledInstance(button[0].getWidth(), button[0].getHeight(), Image.SCALE_SMOOTH));
		button[0].setIcon(imageIcon);
		button[1].setBackground(Color.decode("#de7780"));
		button[2].setBackground(Color.decode("#de7780"));
		button[1].setBounds(320, 190, 100, 35);
		button[2].setBounds(440, 190, 100, 35);
		
		label[0].setBounds(20, 50, (int) 860, 320);
		label[0].setForeground(Color.black);
		label[2].setText("Result will be shown here.");
		label[2].setBounds(20, 440, (int) 860, 40);
		label[4].setText("Copyright © 2023 DeadSOUL-Studios");
		label[4].setBackground(getContentPane().getBackground());
		label[4].setBounds(270, 500, (int) 860, 40);
		label[4].setVisible(true);
		
		panel.setBackground(Color.black);
		panel.setBounds(20, 5, (int) 860, 35);
		this.add(panel);
		panel.add(label[1]);
		panel.add(label[3]);
		panel.add(label[4]);
		
		label[1].setText("Time: "+seconds);
		label[1].setBounds(0, 0, 100, 35);
		label[3].setText("WPM Checker");
		label[3].setFont(new Font(font, Font.BOLD, 25));
		label[3].setBackground(Color.black);
		label[3].setBounds(355, 0, 200, 35);
		
		//Main Frame
		this.setTitle("WPM Checker");
		this.setIconImage(new ImageIcon(icon).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.add(field);
		this.add(label[0]);
		this.add(label[2]);
		this.add(label[4]);
		if(path.equals("/home/"+System.getProperty("user.name")+"/.score.txt"))
			this.setSize(new Dimension(900, 580));
		else
			this.setSize(new Dimension(910, 580));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowFocusListener(new WindowAdapter() {
		    public void windowGainedFocus(WindowEvent e) {
		    	if(!field.getText().equals("") && field.isEnabled()) {
		    		timer = new Timer();
		    		timer.schedule(new TimerTask() {
		    	        @Override
		    	        public void run() {
		    	        	if(seconds==0) {
		    	        		timer.cancel();
		    	        		result();
		    	        	}
		    	        	label[1].setText("Time: "+seconds);
		    	        	seconds--;
		    	        }
		    	    }, 0, 1000);
		    		start=true;
		    	}
		    }
		    public void windowLostFocus(WindowEvent e) {
		    	timer.cancel();
		    	start=false;
		    }
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button[0]) {
			if(i==null)
				i = new INFO(this.getX()+330, this.getY()+150, path);
		}
		if(e.getSource()==button[1]) {
			this.dispose();
			new HOME(path);
		}
		if(e.getSource()==button[2]) {
			select_para = random.nextInt(5);
			field.setText("");
			field.setEnabled(true);
			label[0].remove(button[1]);
			label[0].remove(button[2]);
			label[0].setText("<html>"+para[select_para]+"</html>");
			seconds = 60;
			label[1].setText("Time: "+seconds);
			label[0].setHorizontalAlignment(10);
			label[2].setText("Result will be shown here.");
			start=false;
		}
	}
}