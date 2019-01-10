
package wypo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class App {
	
	public Logger logger;
	public List<User> userList = new ArrayList<>();
	public User mainUser;
	public Facade facade;
	
	private static final String USERPANEL = "USERPANEL";
	private static final String EMPLOYEEPANEL = "EMPLOYEEPANEL";
	private static final String LOGINPANEL = "LOGINPANEL";
	private static final String RENTMOVIEPANEL = "RENTMOVIEPANEL";
	

	private JFrame frmVideorental;
	private CardLayout cards;
	
	private JPanel panelLogging;
	private JTextField passwordField;
	private JTextField textFieldLogin;
	
	
	
	
	private JPanel panelMainScreenEmployee;
	private JLabel labelLoggedAS;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JComboBox<String> comboBox;
	private JButton btnRentToCustomer;
	
	
	private JPanel panelMainScreenCustomer;
	private JTable table;
	private JPanel panelRentMovie;
	private JLabel lblEnterUserLogin;
	private JTextField textField;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmVideorental.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public App() {
		
		userList.add(new User("Karol","M",21,"admin","admin",Clearance.SUPERUSER));
		userList.add(new User("Kamil","B",21,"user","user",Clearance.NORMALUSER));
		
		logger = new Logger(userList);
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVideorental = new JFrame();
		frmVideorental.setTitle("Video_Rental");
		frmVideorental.setBounds(100, 100, 800, 600);
		frmVideorental.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVideorental.getContentPane().setLayout(new CardLayout(0, 0));
		cards = (CardLayout)frmVideorental.getContentPane().getLayout();
		
		
		loginPanel();
		
		employeePanel();
		
		userPanel();
		
		menuBar();
		
		rentMoviePanel();
		

	}
	
	public void loginPanel()
	{
		panelLogging = new JPanel();
		panelLogging.setBackground(new Color(153, 102, 255));
		frmVideorental.getContentPane().add(panelLogging, LOGINPANEL);
		panelLogging.setLayout(null);
		
		passwordField = new JTextField();
		passwordField.setBounds(223, 274, 279, 32);
		panelLogging.add(passwordField);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(223, 208, 279, 32);
		panelLogging.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel labelPassword = new JLabel("Enter Password:");
		labelPassword.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		labelPassword.setBounds(223, 253, 150, 19);
		panelLogging.add(labelPassword);
		
		JLabel labelLogin = new JLabel("Enter Login:");
		labelLogin.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		labelLogin.setBounds(223, 183, 130, 19);
		panelLogging.add(labelLogin);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mainUser = logger.login(textFieldLogin.getText(), passwordField.getText());
				System.out.println("we got here");
				if(mainUser != null)
				{
					facade = new Facade(userList);
					facade.setMainUser(mainUser);
					if(mainUser.getClearance() == Clearance.SUPERUSER)
					{
						updatePanelEmployee();
						cards.show(frmVideorental.getContentPane(), EMPLOYEEPANEL);
						
					}
					if(mainUser.getClearance() == Clearance.NORMALUSER)
					{
						cards.show(frmVideorental.getContentPane(), USERPANEL);
					}
				
				}
				else
				{
					JOptionPane.showMessageDialog(frmVideorental, "Wrong Login or Password","Catastrofal Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnter.setBounds(223, 337, 97, 25);
		panelLogging.add(btnEnter);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnExit.setBounds(405, 338, 97, 25);
		panelLogging.add(btnExit);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("Welcome Sign");
		lblNewLabel.setBounds(306, 98, 89, 16);
		panelLogging.add(lblNewLabel);


	}
	
	public void employeePanel()
	{
		panelMainScreenEmployee = new JPanel();
		frmVideorental.getContentPane().add(panelMainScreenEmployee, EMPLOYEEPANEL);
		panelMainScreenEmployee.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(0, 0, 128, 528);
		panelMainScreenEmployee.add(tree);
		
		labelLoggedAS = new JLabel("You are logged AS:");
		labelLoggedAS.setBounds(201, 13, 305, 16);
		panelMainScreenEmployee.add(labelLoggedAS);
		
		JList<String> list = new JList<>( model );
		

		list.setBounds(635, 77, 135, 371);
		panelMainScreenEmployee.add(list);
		
		JLabel lblTitleList = new JLabel("Title List:");
		lblTitleList.setBounds(201, 59, 56, 16);
		panelMainScreenEmployee.add(lblTitleList);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(166, 88, 292, 52);
		panelMainScreenEmployee.add(comboBox);
		
		btnRentToCustomer = new JButton("Rent Movie to A customer");
		btnRentToCustomer.setBounds(171, 267, 193, 25);
		panelMainScreenEmployee.add(btnRentToCustomer);
		btnRentToCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cards.show(frmVideorental.getContentPane(), RENTMOVIEPANEL);
				
			}
		} );
		//comboBox.addItem(item);
	}
	
	public void rentMoviePanel()
	{
		panelRentMovie = new JPanel();
		frmVideorental.getContentPane().add(panelRentMovie, RENTMOVIEPANEL);
		panelRentMovie.setLayout(null);
		
		lblEnterUserLogin = new JLabel("enter user Login:");
		lblEnterUserLogin.setBounds(82, 61, 136, 16);
		panelRentMovie.add(lblEnterUserLogin);
		
		textField = new JTextField();
		textField.setBounds(191, 58, 116, 22);
		panelRentMovie.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(387, 58, 136, 22);
		panelRentMovie.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(547, 58, 136, 22);
		panelRentMovie.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(176, 286, 97, 25);
		panelRentMovie.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setBounds(462, 286, 97, 25);
		panelRentMovie.add(btnNewButton_1);
	}
	
	public void userPanel()
	{
		
		panelMainScreenCustomer = new JPanel();
		frmVideorental.getContentPane().add(panelMainScreenCustomer, USERPANEL);
		panelMainScreenCustomer.setLayout(null);
		
		table = new JTable();
		table.setBounds(391, 129, -129, -124);
		table.setBackground(Color.LIGHT_GRAY);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMainScreenCustomer.add(table);
		
		JList<String> list = new JList<>();
		list.setBounds(207, 155, 133, 21);
		panelMainScreenCustomer.add(list);
		

		

	
	}
	
	public void menuBar()
	{
		
	}
	
	public void updatePanelEmployee()
	{
		labelLoggedAS.setText(labelLoggedAS.getText()+" "+mainUser.getName()+" "+mainUser.getSurname());
		ArrayList<Title> titleList = (ArrayList<Title>)facade.getTitleList();

		for (Title title : titleList)
		{
		  model.addElement(title.getName());
		  comboBox.addItem(title.getName()+" "+title.getProducer()+" "+title.getDirector());
		  
		}
	}
}
