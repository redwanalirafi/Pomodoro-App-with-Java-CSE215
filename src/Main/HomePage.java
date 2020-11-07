package Main;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener{
	Container container = getContentPane();
	JLabel bgImage = new JLabel(new ImageIcon("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//homebg.png"));
	
	JTextField userTextField = new JTextField();
	
	JLabel wlc=new JLabel("");
	
	Icon act = new ImageIcon("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//act.png");
	JButton actbut = new JButton(act);
	
	Icon todo = new ImageIcon("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//todo.png");
	JButton todobut = new JButton(todo);
	
	Icon pomo = new ImageIcon("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//pomo.png");
	JButton pomobut = new JButton(pomo);
	
	
	public static String user;
	
	public HomePage(String user)
	{
        this.user = user;
        this.setTitle("Productivity++ - HomePage");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setResizable(false);
        this.setLayout(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C://Users//Rafi//eclipse-workspace//Productivity++//src//Main//logo.png"));
        
        Initialize();
        addActionEvent();
	}
	
	
	
	private void Initialize() {
		// TODO Auto-generated method stub
		wlc = new JLabel("Welcome "+user,SwingConstants.CENTER);
		
		wlc.setBounds(180, 0, 350, 100);
		wlc.setForeground(Color.white);
		wlc.setFont(new Font("Dosis SemiBold",Font.BOLD,40));
		wlc.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(wlc);
		
		actbut.setBounds(200, 150, 300, 50);
		//actbut.setBorderPainted(false);
		container.add(actbut);
		
		todobut.setBounds(200, 240, 300, 50);
		container.add(todobut);
		
		pomobut.setBounds(200, 330, 300, 50);
		container.add(pomobut);
		
		bgImage.setBounds(0, 0,700, 600);
		bgImage.setOpaque(true);
		container.add(bgImage);
	}

	private void addActionEvent() {
		actbut.addActionListener(this);
		todobut.addActionListener(this);
		pomobut.addActionListener(this);
	}


	@Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == actbut) {
			this.setVisible(false);
			Activity a = new Activity(user);
			a.setVisible(true);
		}
		if(e.getSource() == todobut) {
			this.setVisible(false);
			ToDo t = new ToDo(user);
			t.setVisible(true);
			
		}
		if(e.getSource() == pomobut) {
			this.setVisible(false);
			PomoTimer tm = new PomoTimer(user);
			tm.setVisible(true);
			
		}
	}
}
