package beauty.land.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

public class Reservation_Page extends JFrame {

	private JPanel contentPane;
	private OutputStream outStream;
	private JComboBox comboBox_services ;
	private JDateChooser dateChooser;
	private JLabel lblAvl,lblRes;

	public Reservation_Page() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.png"));	
		contentPane = new JPanel();
		setSize(620, 330);
		contentPane.setBackground(new Color (255,228,220));
		setLocationRelativeTo(null);
		setTitle("Reservation Page");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseChooseThe = new JLabel("Please choose the date :");
		lblPleaseChooseThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseChooseThe.setBounds(10, 25, 157, 25);
		contentPane.add(lblPleaseChooseThe);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Please choose date");
				}else {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String strDate = sdf.format(dateChooser.getDate());
					System.out.println(strDate);
					int size = readDataFromFile(strDate).size();
					System.out.println("size = "+ size);
					int count = 14 - size;
					lblAvl.setText(""+count);
					lblRes.setText(""+size);
					removeItem(strDate);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBounds(319, 28, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblPleaseChooseWhat = new JLabel("Please choose what services you would like to have ?");
		lblPleaseChooseWhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseChooseWhat.setBounds(10, 100, 340, 25);
		contentPane.add(lblPleaseChooseWhat);
		
		 String Services[]= {"Haircuts","Blow Dry","Full Highlights","Curls",
	                "Basic Tint","Hair Treatment","Nails Acrylic Full Set ","Nail Polish Changing",
	                " Baisc Makeup","Makeup Glam","Body Wax", "Facial Wax","Manicure",
	                " Lashes "};
		comboBox_services = new JComboBox<Object>(Services);
		comboBox_services.setBounds(10, 165, 204, 25);
		contentPane.add(comboBox_services);
		
		JLabel lblAvailableService = new JLabel("Available Services = ");
		lblAvailableService.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvailableService.setBounds(10, 250, 132, 25);
		contentPane.add(lblAvailableService);
		
		JLabel lblReservedServices = new JLabel("Reserved Services = ");
		lblReservedServices.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReservedServices.setBounds(294, 250, 132, 25);
		contentPane.add(lblReservedServices);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dateChooser.getDate() != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String strDate = sdf.format(dateChooser.getDate());
					DataEntry_Page.userData.setDate(strDate);
					DataEntry_Page.userData.setService(comboBox_services.getSelectedItem().toString());
					CheckUser c = new CheckUser();
					c.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "please insert date");
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(244, 166, 89, 25);
		contentPane.add(btnNext);
		
		lblAvl = new JLabel("0");
		lblAvl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvl.setBounds(152, 256, 95, 14);
		contentPane.add(lblAvl);
		
		lblRes = new JLabel("0");
		lblRes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRes.setBounds(454, 256, 95, 14);
		contentPane.add(lblRes);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\logo.png").getImage().getScaledInstance(165, 90, Image.SCALE_DEFAULT));
		JLabel label_1 = new JLabel("");
		label_1.setBounds(430, 11, 165, 90);
		label_1.setIcon(imageIcon);
		contentPane.add(label_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(172, 28, 137, 20);
		contentPane.add(dateChooser);
		
	}
	
	public List<UserData> readDataFromFile(String date){
		 BufferedReader br = null;
		 List<UserData> result = new ArrayList<UserData>();
		    try {

		        br = new BufferedReader(new FileReader("beauty.txt"));

		        String line;
		        while ((line = br.readLine()) != null) {

		        	String[] s = line.split(",");	
		       
		        	result.add(new UserData(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8]));
		        }

		    } catch (IOException e) {
		    	System.err.println("Error Closing File. Termination.");
		    } 
		    
		    closeFile();
		    
		    return result.stream().filter(items -> items.getDate().equalsIgnoreCase(date) )
					.collect(Collectors.toList());
	}
	
	
	
	public void removeItem(String date) {
		List<UserData> list = readDataFromFile(date);
		for(int i = 0 ; i < list.size() ; i++) {
			comboBox_services.removeItem(list.get(i).getService());
			System.out.println(list.get(i).getService());
		}
		
	}
	
	public void closeFile() {
            try {
                    if(outStream != null) {
                        outStream.close();
                    }
            }catch(IOException ex) {
                    System.err.println("Error Closing File. Termination.");
            }
	}
	
	
}
