import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class replica_framee {
	public replica_framee() {
		JFrame frame = new JFrame("My Frame");
		JLabel label = new JLabel("Table of the Year");
		frame.add(label,BorderLayout.PAGE_START);
		frame.setSize(400,300);
		String[][] data = { {"2002","Saturday","Something"},
				{"2001","Saturday","Nothing"},
				{"2003","Sunday","Nothing"},
				{"2004","Sunday","Nothing"},
				{"2005","Saturday","Something"},
				{"2006","Sunday","Nothing"},
				{"2007","Saturday","Something"} };
		String[] columns = {"Year","Day","Happened"};
		JTable table = new JTable(data,columns);
        JScrollPane jscrollpane = new JScrollPane(table);
        frame.getContentPane().add(jscrollpane,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton colorChanger = new JButton("Color Changer");
        frame.getContentPane().add(colorChanger,BorderLayout.PAGE_END);
        colorChanger.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(Color.GREEN);;
				
			}});
        frame.setVisible(true);
} 
}
public class replica_frame {

	public static void main(String[] args) {
		new replica_framee();
	}
}

