package beauty.land.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DataEntry_Page extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName,txtLastName,txtPhoneNumber,txtEmail,txtYear,txtMonth,txtDay;
	private JRadioButton radio_yes,radio_no;
	private  ButtonGroup bgroup;
	private Color color;
	public static UserData userData = new UserData();
	private JTextArea textArea;

	public DataEntry_Page() {
	
		contentPane = new JPanel();
		setSize(500, 520);
		setTitle("Data Entry Page");
		contentPane.setBackground(new Color (255,228,220));
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.png"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\logo.png").getImage().getScaledInstance(165, 90, Image.SCALE_DEFAULT));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(310, 10, 165, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseFillThe = new JLabel("Please fill the information");
		lblPleaseFillThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseFillThe.setBounds(10, 36, 178, 25);
		contentPane.add(lblPleaseFillThe);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setBounds(10, 120, 75, 25);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFirstName.setBounds(95, 123, 116, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(10, 170, 75, 25);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLastName.setColumns(10);
		txtLastName.setBounds(95, 173, 116, 20);
		contentPane.add(txtLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNumber.setBounds(221, 120, 96, 25);
		contentPane.add(lblPhoneNumber);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(327, 123, 148, 20);
		contentPane.add(txtPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(221, 170, 96, 25);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(327, 173, 148, 20);
		contentPane.add(txtEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth (for gift every year) :");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setBounds(10, 220, 205, 25);
		contentPane.add(lblDateOfBirth);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtYear.setColumns(10);
		txtYear.setBounds(300, 223, 47, 20);
		contentPane.add(txtYear);
		
		txtMonth = new JTextField();
		txtMonth.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMonth.setColumns(10);
		txtMonth.setBounds(260, 223, 29, 20);
		contentPane.add(txtMonth);
		
		txtDay = new JTextField();
		txtDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDay.setColumns(10);
		txtDay.setBounds(221, 223, 29, 20);
		contentPane.add(txtDay);
		
		JLabel lblAddMeTo = new JLabel("Add me to your mail list ?");
		lblAddMeTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddMeTo.setBounds(10, 270, 170, 25);
		contentPane.add(lblAddMeTo);
		
		textArea = new JTextArea();
		textArea.setBounds(173, 327, 302, 96);
		contentPane.add(textArea);
		
		JLabel lblLeaveUsImportant = new JLabel("Leave us important note :-");
		lblLeaveUsImportant.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeaveUsImportant.setBounds(10, 320, 170, 25);
		contentPane.add(lblLeaveUsImportant);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtPhoneNumber.getText().equals("") || txtEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "please fill required fields");
				}else {
					if(!validatePhoneNumber()) {
						JOptionPane.showMessageDialog(null, "Wrong Phone Number");
					}else if(!validateEmailAddress()) {
						JOptionPane.showMessageDialog(null, "Wrong Email Address");
					}else {
						userData.setFirstName(txtFirstName.getText());
						userData.setLastName(txtLastName.getText());
						userData.setEmail(txtEmail.getText());
						userData.setPhoneNumber(txtPhoneNumber.getText());
						userData.setDataOfBirth(txtDay.getText()+"/"+txtMonth.getText()+"/"+txtYear.getText());
						if(radio_yes.isSelected()) {
							userData.setAddToMailList("yes");
						}else {
							userData.setAddToMailList("no");
						}
						userData.setNotes(textArea.getText());
						Reservation_Page r = new Reservation_Page();
						r.setVisible(true);
						dispose();
					}

				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNext.setBounds(10, 440, 100, 30);
		contentPane.add(btnNext);
		
		JButton button = new JButton("color");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                color =  JColorChooser.showDialog(null, "Select a color", Color.pink);
                contentPane.setBackground(color);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(410, 440, 65, 30);
		contentPane.add(button);
		
		radio_yes = new JRadioButton("Yes, please");
		radio_yes.setBackground(new Color (255,228,220));
		radio_yes.setFont(new Font("Tahoma", Font.BOLD, 11));
		radio_yes.setBounds(196, 272, 97, 23);
		contentPane.add(radio_yes);
		
		radio_no = new JRadioButton("No, thank you");
		radio_no.setFont(new Font("Tahoma", Font.BOLD, 11));
		radio_no.setBackground(new Color (255,228,220));
		radio_no.setBounds(314, 272, 109, 23);
		contentPane.add(radio_no);
		
		bgroup = new ButtonGroup(); 
		bgroup.add(radio_yes);
		bgroup.add(radio_no);
	}
	
	public boolean validatePhoneNumber() {
		String x_phoneNumber = txtPhoneNumber.getText().trim();
		int length = x_phoneNumber.length();	
		String phone = x_phoneNumber.substring(0, 2);
		if(phone.equals("05") && length == 10) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateEmailAddress() {
		String x_email = txtEmail.getText().trim();
		if (x_email.contains("@") && x_email.contains(".com"))
		{
		   return true;
		}
		return false;
	}
}
