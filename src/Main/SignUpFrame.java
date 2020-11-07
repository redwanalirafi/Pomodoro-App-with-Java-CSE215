package Main;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;






public class SignUpFrame extends JFrame implements ActionListener{

	
	String path = "C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//UserInfo.txt";
	
	Container sContainer = getContentPane();
	
	JLabel bgImage = new JLabel(new ImageIcon("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//signupbg.jpg"));
	
	JTextField fnTextField = new JTextField();
	JTextField lnTextField = new JTextField();
	JTextField idTextField = new JTextField();
	
	JLabel reg = new JLabel("Register");
	
	JPasswordField passwordField = new JPasswordField();
	
	JButton regButton = new JButton("Create Account");
    JButton loginButton = new JButton("Back");
    
    public SignUpFrame()
	{
		this.setTitle("Productivity++ - Sign Up");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//logo.png"));
	
		Initialize();
        addActionEvent();
	}
	
    public void Initialize()
	{
		sContainer.setLayout(null);
		
		reg.setBounds(225, 0, 280, 100);
		reg.setForeground(new Color(159,89,155));
		reg.setFont(new Font("Arial Black",Font.BOLD,40));
		reg.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(reg);

		
		fnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fnTextField.setBounds(398, 182, 270, 28);
        fnTextField.setToolTipText("First name");
        fnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(fnTextField);
        
        lnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lnTextField.setBounds(398, 242, 270, 28);
        lnTextField.setToolTipText("Last name");
        lnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(lnTextField);
        
        idTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        idTextField.setBounds(398, 302, 270, 28);
        idTextField.setToolTipText("Email address");
        idTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(idTextField);
        
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passwordField.setBounds(398, 362, 270, 28);
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(passwordField);
        
        
        regButton.setBounds(397, 425, 200, 37);
        regButton.setBorderPainted(false);
        regButton.setBackground(new Color(159,89,155));
        regButton.setForeground(Color.WHITE);
        regButton.setFont(new Font("San Francisco", Font.BOLD, 15));
        sContainer.add(regButton);
        
        loginButton.setBounds(397, 490, 78, 40);
        loginButton.setBorderPainted(false);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(159,89,155));
        loginButton.setFont(new Font("San Francisco", Font.BOLD, 14));
        sContainer.add(loginButton);
        
        bgImage.setBounds(0, 0, 800, 585);
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setOpaque(true);
		sContainer.add(bgImage);
        
	}
	
	private void addActionEvent() {
		// TODO Auto-generated method stub
		loginButton.addActionListener(this);
        regButton.addActionListener(this);
	}



	public boolean check(String email)
	{
		String line;
		try {
			FileReader fr = new FileReader(path);
	        BufferedReader br = new BufferedReader(fr);
	        
	        while ((line = br.readLine()) != null)
	        {
	        	if(email.split("@")[0].equalsIgnoreCase(line.split(" ")[2].split("@")[0]))
	        	{
	        		return true;
	        	}
	        }
		}
		catch (Exception ep) {
			System.out.println("ERROR 404! File-Not-Found");
            //ep.printStackTrace();
        }
		return false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean done=false;
		if (e.getSource() == loginButton) 
		{
			this.setVisible(false);
			LoginFrame l = new LoginFrame();
			l.setVisible(true);
		}
		if (e.getSource() == regButton) 
		{
			try
			{
			      if(!check(idTextField.getText()))
			      {
			    	  done=true;
			    	  FileWriter myWriter = new FileWriter(path,true);
			    	  myWriter.write(fnTextField.getText()+" "+lnTextField.getText()+" "+idTextField.getText()+" "+passwordField.getText()+"\n");
				      myWriter.close();
				      JOptionPane.showMessageDialog(null, "Successfully Registered! Please Login to continue...","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null, "Username already in use!","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			 }
			catch (IOException ep) {
			      System.out.println("ERROR 404! File-Not-Found");
			      ep.printStackTrace();
			}
			
			
			if(done==true) {
		
				path = "C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//workh.txt";
				try {
					String email=idTextField.getText();
					System.out.println(email);
					FileWriter Writer = new FileWriter(path,true);
			    	Writer.write(email.split("@")[0]+ " " + 0 + "\n");
				    Writer.close();
				}
				catch (IOException epp) {
					// TODO: handle exception
				}
				
			}
			
			
		}
		
	}
	
}
