package beauty.land.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckUser extends JFrame {

    private JPanel contentPane;
    private JButton btnSave,btnExit;
    private JLabel lblMessage;
    private JCheckBox checkBox_Fever,checkBox_dry_cough,checkBox_shortness,checkBox_loss,checkBox_fatigue,checkBox_none;
    public static int count = 0;
    private OutputStream outStream;

    public CheckUser() {
            setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icon.png"));
            contentPane = new JPanel();
            setSize(521, 290);
            contentPane.setBackground(new Color (255,228,220));
            setLocationRelativeTo(null);
            setTitle("Check User");
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblHaveYouExperienced = new JLabel("Have you experienced any these symptoms ?");
            lblHaveYouExperienced.setFont(new Font("Tahoma", Font.BOLD, 12));
            lblHaveYouExperienced.setBounds(10, 11, 295, 25);
            contentPane.add(lblHaveYouExperienced);

            checkBox_Fever = new JCheckBox("Fever");
            checkBox_Fever.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            if(checkBox_Fever.isSelected()) {
                                    count = count +1;
                                    checkBox_none.setSelected(false);
                            }else {
                                    count = count -1;
                            }
                    }
            });
            checkBox_Fever.setBackground(new Color (255,228,220));
            checkBox_Fever.setFont(new Font("Tahoma", Font.BOLD, 11));
            checkBox_Fever.setBounds(10, 55, 97, 23);
            contentPane.add(checkBox_Fever);

            checkBox_dry_cough = new JCheckBox("Dry Cough");
            checkBox_dry_cough.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            if(checkBox_dry_cough.isSelected()) {
                                    count = count +1;
                                    checkBox_none.setSelected(false);
                            }else {
                                    count = count -1;
                            }
                    }
            });
            checkBox_dry_cough.setBackground(new Color (255,228,220));
            checkBox_dry_cough.setFont(new Font("Tahoma", Font.BOLD, 11));
            checkBox_dry_cough.setBounds(10, 100, 97, 23);
            contentPane.add(checkBox_dry_cough);

            checkBox_shortness = new JCheckBox("Shortness of breath");
            checkBox_shortness.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            if(checkBox_shortness.isSelected()) {
                                    count = count +1;
                                    checkBox_none.setSelected(false);
                            }else {
                                    count = count - 1;
                            }
                    }
            });
            checkBox_shortness.setBackground(new Color (255,228,220));
            checkBox_shortness.setFont(new Font("Tahoma", Font.BOLD, 11));
            checkBox_shortness.setBounds(174, 55, 150, 23);
            contentPane.add(checkBox_shortness);

            checkBox_loss = new JCheckBox("Loss of smell");
            checkBox_loss.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            if(checkBox_loss.isSelected()) {
                                    count = count +1;
                                    checkBox_none.setSelected(false);
                            }else {
                                    count = count -1;
                            }
                    }
            });
            checkBox_loss.setBackground(new Color (255,228,220));
            checkBox_loss.setFont(new Font("Tahoma", Font.BOLD, 11));
            checkBox_loss.setBounds(174, 100, 131, 23);
            contentPane.add(checkBox_loss);

            checkBox_fatigue = new JCheckBox("Fatigue");
            checkBox_fatigue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        if(checkBox_fatigue.isSelected()) {
                                count = count +1;
                                checkBox_none.setSelected(false);
                        }else {
                                count = count - 1;
                        }
                    }
            });
            checkBox_fatigue.setFont(new Font("Tahoma", Font.BOLD, 11));
            checkBox_fatigue.setBackground(new Color (255,228,220));
            checkBox_fatigue.setBounds(10, 145, 97, 23);
            contentPane.add(checkBox_fatigue);

            checkBox_none = new JCheckBox("None of the above");
            checkBox_none.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            if(checkBox_none.isSelected()) {
                                    checkBox_Fever.setSelected(false);
                                    checkBox_shortness.setSelected(false);
                                    checkBox_dry_cough.setSelected(false);
                                    checkBox_loss.setSelected(false);
                                    checkBox_fatigue.setSelected(false);
                                    count = 0;
                            }
                    }
            });
            checkBox_none.setBackground(new Color (255,228,220));
            checkBox_none.setFont(new Font("Tahoma", Font.BOLD, 11));
            checkBox_none.setBounds(174, 145, 131, 23);
            contentPane.add(checkBox_none);

            lblMessage = new JLabel("Sorry we can't serve you, \r\nhope you will get better soon.");
            lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
            lblMessage.setForeground(Color.DARK_GRAY);
            lblMessage.setVisible(false);
            lblMessage.setBounds(10, 201, 325, 30);
            contentPane.add(lblMessage);

            ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\logo.png").getImage().getScaledInstance(165, 90, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(imageIcon);
            label.setBounds(330, 11, 165, 90);
            contentPane.add(label);

            btnSave = new JButton("Save");
            btnSave.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            if(count>=2) {
                                    lblMessage.setVisible(true);
                                    btnExit.setVisible(true);
                            }else {
                                    lblMessage.setVisible(false);
                                    btnExit.setVisible(false);
                                    addNewDataInFile();
                                    Reservation_Result_Page r = new Reservation_Result_Page();
                                    r.setVisible(true);
                                    dispose();
                            }
                    }
            });

            btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnSave.setBounds(420, 198, 70, 35);
            contentPane.add(btnSave);

            btnExit = new JButton("Exit");
            btnExit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            dispose();
                    }
            });
            btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnExit.setBounds(350, 198, 61, 35);
            btnExit.setVisible(false);
            contentPane.add(btnExit);
    }

    public void addNewDataInFile() {
            try {
                    outStream = new FileOutputStream("beauty.txt",true);
                    outStream.write((DataEntry_Page.userData.getFirstName()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getLastName()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getPhoneNumber()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getEmail()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getDataOfBirth()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getAddToMailList()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getNotes()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getDate()+",").getBytes());
                    outStream.write((DataEntry_Page.userData.getService()+"\n").getBytes());
            } catch (FileNotFoundException e) {
                    System.out.println("File Not Found");
            } catch (IOException e) {
                    System.out.println("Error Writing To File. Termination");
            }
            closeFile();
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
