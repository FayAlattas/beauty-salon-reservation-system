package beauty.land.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Reservation_Result_Page extends JFrame {

	private JPanel contentPane;

	public Reservation_Result_Page() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.png"));
		contentPane = new JPanel();
		setSize(425, 290);
		contentPane.setBackground(new Color (255,228,220));
		setLocationRelativeTo(null);
		setTitle("Reservation Result");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\logo.png").getImage().getScaledInstance(165, 90, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(imageIcon);

		label.setBounds(263, 11, 136, 90);
		contentPane.add(label);
		
		JLabel lblThankYouFor = new JLabel("Thank you for choosing beauty land ");
		lblThankYouFor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThankYouFor.setBounds(10, 11, 243, 25);
		contentPane.add(lblThankYouFor);
		
		JLabel lblReservationSuccessfuly = new JLabel("Reservation successfully");
		lblReservationSuccessfuly.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReservationSuccessfuly.setBounds(15, 55, 165, 25);
		contentPane.add(lblReservationSuccessfuly);
		
		JLabel lblHaveAgreatDat = new JLabel("have a great day");
		lblHaveAgreatDat.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaveAgreatDat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHaveAgreatDat.setBounds(263, 112, 136, 25);
		contentPane.add(lblHaveAgreatDat);
		
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img\\qr-code.png").getImage().getScaledInstance(185, 150, Image.SCALE_DEFAULT));
		JLabel label_1 = new JLabel(imageIcon2);
		label_1.setBounds(10, 90, 185, 150);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(270, 210, 125, 30);
		contentPane.add(btnNewButton);
	}

}
