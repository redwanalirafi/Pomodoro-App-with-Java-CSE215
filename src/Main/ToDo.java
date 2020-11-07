package Main;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ToDo extends JFrame implements ActionListener{
	public static int count=0;
	JLabel wlc=new JLabel("");
	Container container = getContentPane();
	JLabel bgImage = new JLabel(new ImageIcon("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//homebg.png"));
	
	JTextArea list = new JTextArea();
	JTextField add = new JTextField();
	JButton addButton=new JButton("ADD");
	JButton back = new JButton("Back");
	JButton detelebut=new JButton("Delete");
	
	public static String user;
	
	public ToDo(String user)
	{
        this.user=user;
        this.setTitle("Productivity++ - ToDo");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setResizable(false);
        this.setLayout(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//logo.png"));
        
        String path = "C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//"+user+".txt";
        try {
        	FileReader reader = new FileReader( path );
            BufferedReader br = new BufferedReader(reader);
            list.read( br, null );
            br.close();
            list.requestFocus();
        }
        catch (Exception e) {
			// TODO: handle exception
        	System.out.println("FILE NOT FOUND");
		}
        
        
        
        
        Initialize();
        addActionEvent();
	}
	
	private void Initialize() {
		// TODO Auto-generated method stub
		wlc = new JLabel("Create ToDo List" );
		wlc.setBounds(170, 0, 350, 100);
		wlc.setForeground(Color.white);
		wlc.setFont(new Font("Dosis SemiBold",Font.BOLD,40));
		wlc.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(wlc);
		
		//JtextArea with scrollbar
		
		list.setBounds(45, 100, 600, 300);
		list.setEditable(false);
		list.setBackground(new Color(250, 192, 192));
		list.setFont(new Font("San Francisco", Font.BOLD, 14));
		list.setForeground(Color.BLACK);
		JScrollPane sp = new JScrollPane(list);
		sp.setBounds(45, 100, 600, 300);
		
		container.add(sp);
		
		add.setBounds(45, 450, 400, 35);
		container.add(add);
		
		addButton.setBounds(470,450, 80, 35);
		addButton.setBorderPainted(false);
		addButton.setBackground(new Color(159,89,155));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("San Francisco", Font.BOLD, 15));
		container.add(addButton);
		
		
		detelebut.setBounds(570,450, 90, 35);
		detelebut.setBorderPainted(false);
		detelebut.setBackground(new Color(250,74,74));
		detelebut.setForeground(Color.WHITE);
		detelebut.setFont(new Font("San Francisco", Font.BOLD, 15));
		container.add(detelebut);
		
		back.setBounds(297, 505, 78, 40);
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setForeground(new Color(159,89,155));
		back.setFont(new Font("San Francisco", Font.BOLD, 14));
        container.add(back);
        
        
		bgImage.setBounds(0, 0,700, 600);
		bgImage.setOpaque(true);
		container.add(bgImage);
		
	}

	private void addActionEvent() {
		// TODO Auto-generated method stub
		addButton.addActionListener(this);
		back.addActionListener(this);
		detelebut.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addButton) {
			String path = "C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//"+user+".txt";
			try {
				
				FileWriter myWriter = new FileWriter(path,true);
		    	myWriter.write("    "+add.getText()+"\n");
			    myWriter.close();
			    JOptionPane.showMessageDialog(null, "Successfully Added!","Confirmation", JOptionPane.WARNING_MESSAGE);
				
			}
			catch (IOException ep) {
				System.out.println("FILE NOT FOUND");
				// TODO: handle exception
			}
			this.setVisible(false);
			ToDo a = new ToDo(user);
			a.setVisible(true);
			
		}
		if(e.getSource()==back) {
			this.setVisible(false);
			HomePage homePage=new HomePage(user);
			homePage.setVisible(true);
		}
		if(e.getSource()==detelebut) {
			System.out.println(user);
			File file = new File("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//"+user+".txt"); 
			
	        if(file.delete()) 
	        { 
	            System.out.println("File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to delete the file"); 
	        } 
	        
	        this.setVisible(false);
			ToDo tdo = new ToDo(user);
			tdo.setVisible(true);
		}
	}

}
