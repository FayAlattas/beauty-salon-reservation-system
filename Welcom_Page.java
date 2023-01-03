package beauty.land.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcom_Page extends JFrame {

	private JPanel contentPane;
	private Color color;

	public Welcom_Page() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,228,220));
		setSize(300, 380);
		setTitle("Welcom Page");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.png"));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WE ARE SO GLAD TO SERVE YOU.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 20, 264, 25);
		contentPane.add(lblNewLabel_1);
		
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\welcom.png").getImage().getScaledInstance(260, 200, Image.SCALE_DEFAULT));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 66, 264, 200);
		lblNewLabel.setIcon(imageIcon);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataEntry_Page d = new DataEntry_Page();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 295, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("color");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 color =  JColorChooser.showDialog(null, "Select a color", Color.pink);
                 contentPane.setBackground(color);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(210, 295, 65, 30);
		contentPane.add(btnNewButton_1);
			  
	}
	
	
}
