package com.vetapp.history;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class BirthGUI extends JFrame {
	private JTable table;
	private JButton back_button ;
	public BirthGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAutoRequestFocus(false);
		
		JPanel  panel = new JPanel();
		panel.setLayout(new BorderLayout());
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{null, null},
				{null, null},                    //Data
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Date", "Complications/Comments"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(164);
		table.getColumnModel().getColumn(1).setPreferredWidth(161);
		table.setBounds(49, 85, 336, 201);
		JScrollPane scroller = new JScrollPane(table );   // Xwris JScrollPane den emfanizontai ta headers
		panel.add(scroller,BorderLayout.CENTER );
		JLabel label = new JLabel("                                                                   Births Given");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(label ,BorderLayout.NORTH);
		back_button = new JButton("Back");   
		//panel.add(back_button, BorderLayout.SOUTH);
		JPanel panel_1 =new JPanel();  // Voithitiko panel 
		panel_1.add(back_button);
		panel.add(panel_1 , BorderLayout.SOUTH);
	    this.setContentPane(panel );
	    
		this.setVisible(true);
		this.pack();
		
	}

	}

