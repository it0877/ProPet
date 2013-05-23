package com.vetapp.customer;

/*
 * CustomersGUI.java
 * A GUI class that displays the main customer list.
 * End user can search for, create or display a customer record.
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.vetapp.customer.CreateCustomerGUI.cancelButtonListener;
import com.vetapp.customer.CreateCustomerGUI.createButtonListener;

//*   DEN KATAFERA NA SYNDESW TIS KLASEIS CREATE CUSTOMER - COSTUMERS  AMA H PRWTH DEN EINAI YPOKLASSH THS DEYTERHS  *
public class CustomersGUI extends JFrame {
	
	//JButton labels strings declared as constants
	private static String NEW_BUTTON_LABEL = "New Customer";
	private static String BACK_BUTTON_LABEL = "Back";
	
	private JTextField searchTxt;
	private JButton newBtn;
	private JButton backBtn;
	private JTable customerTbl;
	
	private JPanel upperPnl;	//containing controPnl
	private JPanel tablePnl;	//containing customerTbl
	private JPanel lowerPnl;	//containing backBtn
	private JPanel controlPnl;	//containing searchTxt & newBtn
	
	private BorderLayout paneLayout;
	private BoxLayout upperLayout; 
	private BoxLayout lowerLayout;
	private BoxLayout tableLayout;
	private BoxLayout controlLayout;
	private ArrayList <Customer> customers = new  ArrayList <Customer> () ;     //Dhmiourgia listas pelatwn
	
	public CustomersGUI() {
		
		//Frame configuration
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(com.vetapp.main.VetApp.MAIN_WINDOW_TITLE);	//gets window title from constant in com.vetapp.main.VetApp
		
		upperPnl = new JPanel();	
	    lowerPnl = new JPanel();	
	    tablePnl = new JPanel();	
	    
	    //contentPane layout (BorderLayout)
	    paneLayout = new BorderLayout();
	    getContentPane().setLayout(paneLayout);
	    
	    getContentPane().add(upperPnl, BorderLayout.NORTH);
	    getContentPane().add(tablePnl, BorderLayout.CENTER);
	    getContentPane().add(lowerPnl, BorderLayout.SOUTH);

	    //upperPnl layout (vertical BoxLayout)
	    controlPnl = new JPanel();
	    upperLayout = new BoxLayout(upperPnl, BoxLayout.Y_AXIS);
	    upperPnl.setLayout(upperLayout);
	    
	    upperPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    upperPnl.add(controlPnl);
	    upperPnl.add(Box.createRigidArea(new Dimension(0, 10)));
    
	    //controlPnl layout (horizontal BoxLayout) 
	    searchTxt = new JTextField("Search...",10);
	    newBtn = new JButton(NEW_BUTTON_LABEL);
	    controlLayout = new BoxLayout(controlPnl, BoxLayout.X_AXIS);
	    controlPnl.setLayout(controlLayout);
	    
	    controlPnl.add(Box.createRigidArea(new Dimension(10, 0)));
	    controlPnl.add(searchTxt);
	    controlPnl.add(Box.createRigidArea(new Dimension(60, 0)));
	    controlPnl.add(newBtn);
	    controlPnl.add(Box.createRigidArea(new Dimension(10, 0)));
	    
	    //JTable configuration
	    String[] columnNames = {"Last Name","First Name","Next Visit"};		//column header labels
	    SimpleDateFormat dateFormat = new SimpleDateFormat(("dd/MM/yyyy"));	//set format of date for Next Visit
	    Date date;															//parse date from formatted String
	    try {
	    	date = dateFormat.parse("01/01/2014");
	    } catch (ParseException e) {
	    	date = null;
	    	e.printStackTrace();
		}
	    
	    Object [][] data = {												//fill with dummy data
	    		{"<lName01>", "<fName01>", (dateFormat.format(date))},
	    		{"<lName02>", "<fName02>", (dateFormat.format(date))},
	    		{"<lName03>", "<fName03>", (dateFormat.format(date))},
	    		{"<lName04>", "<fName04>", (dateFormat.format(date))},
	    };
	    customerTbl = new JTable(data, columnNames);
	    customerTbl.setAutoCreateRowSorter(true);									//enable row sorters						
	    DefaultRowSorter sorter = ((DefaultRowSorter)customerTbl.getRowSorter());	//default sort by Last Name
	    ArrayList list = new ArrayList();
	    list.add( new RowSorter.SortKey(0, SortOrder.ASCENDING) );
	    sorter.setSortKeys(list);
	    sorter.sort();
	    
	    customerTbl.getColumnModel().getColumn(0).setPreferredWidth(100);	//set Last Name column preferred width
	    customerTbl.getColumnModel().getColumn(1).setPreferredWidth(80);	//set First Name column preferred width
	    customerTbl.getColumnModel().getColumn(2).setPreferredWidth(80);	//set Last Visit column preferred width   
	    
	    //tablePnl layout (horizontal BoxLayout)
	    JScrollPane scrollPane = new JScrollPane(customerTbl);
	    customerTbl.setFillsViewportHeight(true);
	    scrollPane.setPreferredSize(new Dimension(270,250));
	    
	    tableLayout = new BoxLayout(tablePnl, BoxLayout.X_AXIS);
	    tablePnl.setLayout(tableLayout);
	    
	    tablePnl.add(Box.createRigidArea(new Dimension(30, 0)));
	    tablePnl.add(scrollPane);
	    tablePnl.add(Box.createRigidArea(new Dimension(30, 0)));

	    //lowerPnl layout (vertical BoxLayout)
	    backBtn = new JButton(BACK_BUTTON_LABEL);
	    lowerLayout = new BoxLayout(lowerPnl,BoxLayout.Y_AXIS);
	    lowerPnl.setLayout(lowerLayout);	    
	    
	    lowerPnl.add(Box.createRigidArea(new Dimension(0, 10)));
	    lowerPnl.add(backBtn);
	    lowerPnl.add(Box.createRigidArea(new Dimension(0, 10)));

	    backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);	//set "Back" JButton alignment to CENTER
	    
	    //Pack() & Enable visibility for JFrame & all containers
	    pack();
	    setVisible(true);
	    getContentPane().setVisible(true);
	    upperPnl.setVisible(true);
		tablePnl.setVisible(true);
		lowerPnl.setVisible(true);
		controlPnl.setVisible(true);
		
		
		// Syndesh buttons me ActionListener()
		newBtn.addActionListener(new createCustomerListener());
		backBtn.addActionListener(new backListener());
	}
	
  
	
	public void setCustomer(Customer aCustomer)
	{
		customers.add(aCustomer);
	}
	
	
	
	
	
	public class createCustomerListener  implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Customer temp ;
		    
			CreateCustomerGUI_Beta createCustomerFrame = new CreateCustomerGUI_Beta();
	
		    
			
			
	//	do{
		//	 temp  = createCustomerFrame.getaCustomer();  //epistrefei to pelath pou dhmiourghthke
			
			
			
		//	}while(createCustomerFrame.isVisible());
		  //  createCustomerFrame.dispose();    // Kleisimo tou frame  
		 //   customers.add(temp);
		}
			
		
		
	}
	
	
	public class backListener  implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Code Here //
		}
		
	}
	
	
	
	public class CreateCustomerGUI_Beta extends JFrame {         

		//Title and JButton label strings declared as constants
		private static final String CREATE_BUTTON_LABEL = "Create";
		private static final String CANCEL_BUTTON_LABEL = "Cancel";
		private static final String TITLE_LABEL = "Create New Customer";
		
		private JLabel titleLlb;
		private JLabel fNameLbl;
		private JLabel lNameLbl;
		private JLabel addrLbl;
		private JLabel hPhoneLbl;
		private JLabel mPhoneLbl;
		
		private JTextField fNameTxt;
		private JTextField lNameTxt;
		private JTextField addrTxt;
		private JTextField hPhoneTxt;
		private JTextField mPhoneTxt;
		
		private JPanel mainPnl;		//containing inputPnl & controlPnl
		private JPanel inputPnl;	//containing input JLabels & JTextFields		
		private JPanel controlPnl;	//containing control JButtons (createBtn & cancelBtn)
		private JButton createBtn;	
		private JButton cancelBtn;
		
		private BoxLayout paneLayout;		//contentPane layout
		private BoxLayout mainLayout; 		//mainPnl layout
		private BoxLayout controlLayout;	//controlPnl layout
		
		private Border loweredetched;	//border type of inputPnl
		
		private Customer aCustomer;
		private boolean flag = true;

		
		public CreateCustomerGUI_Beta() {
			
			//Frame configuration
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle(com.vetapp.main.VetApp.MAIN_WINDOW_TITLE);	//gets window title from constant in com.vetapp.main.VetApp
			
			//contentPane layout (horizontal BoxLayout)
		    mainPnl = new JPanel();
			paneLayout = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
		    getContentPane().setLayout(paneLayout);
		    
		    getContentPane().add(Box.createRigidArea(new Dimension(15, 0)));
		    getContentPane().add(mainPnl);
		    getContentPane().add(Box.createRigidArea(new Dimension(15, 0)));
		    
		    //mainPnl layout (vertical BoxLayout)
		    titleLlb = new JLabel(TITLE_LABEL);
		    inputPnl = new JPanel();
		    controlPnl = new JPanel();
		    mainLayout = new BoxLayout(mainPnl,BoxLayout.PAGE_AXIS);
		    mainPnl.setLayout(mainLayout);
		    
		    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
		    mainPnl.add(titleLlb);
		    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
		    mainPnl.add(inputPnl);
		    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
		    mainPnl.add(controlPnl);
		    mainPnl.add(Box.createRigidArea(new Dimension(0, 10)));
		    
		    titleLlb.setAlignmentX(Component.CENTER_ALIGNMENT);	//set title JLabel alignment to CENTER

		    //inputPnl layout (GroupLayout [2x5])
		    fNameLbl = new JLabel("First Name*:");
		    lNameLbl = new JLabel("Last Name*:");
		    addrLbl = new JLabel("Address:");
		    hPhoneLbl = new JLabel("Home Phone:");
		    mPhoneLbl = new JLabel("Mobile Phone:");
		    fNameTxt = new JTextField(10);
		    lNameTxt = new JTextField(10);
		    addrTxt = new JTextField(10);
		    hPhoneTxt = new JTextField(10);
		    mPhoneTxt = new JTextField(10);
		    GroupLayout inputLayout = new GroupLayout(inputPnl);
		    inputPnl.setLayout(inputLayout);
		    
		    inputLayout.setAutoCreateGaps(true);			//enable gaps between JLabels & JTextFields
		    inputLayout.setAutoCreateContainerGaps(true);	//enable margin-gaps
		    
		    inputLayout.setHorizontalGroup(
		    		inputLayout.createSequentialGroup()
		    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    				.addComponent(fNameLbl)
		    				.addComponent(lNameLbl)
		    				.addComponent(addrLbl)
		    				.addComponent(hPhoneLbl)
		    				.addComponent(mPhoneLbl))
		    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    				.addComponent(fNameTxt)
		    				.addComponent(lNameTxt)
		    				.addComponent(addrTxt)
		    				.addComponent(hPhoneTxt)
		    				.addComponent(mPhoneTxt))
		    );

		    inputLayout.setVerticalGroup(
		    		inputLayout.createSequentialGroup()
		    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
		    				.addComponent(fNameLbl)
		    				.addComponent(fNameTxt))
		    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
		    				.addComponent(lNameLbl)
		    				.addComponent(lNameTxt))
		    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
		    				.addComponent(addrLbl)
		    				.addComponent(addrTxt))
		    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
		    				.addComponent(hPhoneLbl)
		    				.addComponent(hPhoneTxt))
		    			.addGroup(inputLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
		    				.addComponent(mPhoneLbl)
		    				.addComponent(mPhoneTxt))
		    );
		    
		    loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);	
		    inputPnl.setBorder(loweredetched);		//set a visible "Lowered-Etched" border for inputPnl
		     
		    //controlPnl layout (horizontal BoxLayout)
		    createBtn = new JButton(CREATE_BUTTON_LABEL);
		    cancelBtn = new JButton(CANCEL_BUTTON_LABEL);
		    controlLayout = new BoxLayout(controlPnl, BoxLayout.X_AXIS);
		    controlPnl.setLayout(controlLayout);
		    
		    controlPnl.add(Box.createRigidArea(new Dimension(30,0)));
		    controlPnl.add(createBtn);
		    controlPnl.add(Box.createRigidArea(new Dimension(20,0)));
		    controlPnl.add(cancelBtn);
		    controlPnl.add(Box.createRigidArea(new Dimension(30,0)));
		    
		    //Enable visibility for JFrame & all containers
		    pack();
		    setVisible(true);
		    getContentPane().setVisible(true);
		    mainPnl.setVisible(true);
		    inputPnl.setVisible(true);
		    controlPnl.setVisible(true);
		    
		    createBtn.addActionListener(new createButtonListener());
		    cancelBtn.addActionListener(new cancelButtonListener());
		}
		
		public Customer getaCustomer ()
		{
			return aCustomer;         
			
		}
		
		public boolean getFlag()
		{
			return flag;
		}

		public class createButtonListener implements ActionListener {

			@Override    
			public void actionPerformed(ActionEvent arg0) {
				
				aCustomer = new Customer( fNameTxt.getText(),lNameTxt.getText(),addrTxt.getText(),hPhoneTxt.getText(),mPhoneTxt.getText());  //Dhmiourgia pelath
				flag = false;
				JOptionPane information = new JOptionPane();
				information.showMessageDialog(null,"Customer Added !");   // Emfanish mhnymatos epityxias
				CustomersGUI.this.setCustomer(aCustomer);     // Eisagwgh tou pelath sth lista pelatwn ths klasshs customersGUI
				CreateCustomerGUI_Beta.this.dispose();     // Kleisimo frame
				
			}
			
		}
		
		public class cancelButtonListener implements ActionListener {

			@Override    
			public void actionPerformed(ActionEvent arg0) {
				
				
				fNameTxt.setText(""); 
			    lNameTxt.setText("");  
			    addrTxt.setText("");                       // Epanafora twn textfield
			    hPhoneTxt.setText(""); 
			    mPhoneTxt.setText("");  
			      
				
			}
			
		}
		
	}
	
	
}
