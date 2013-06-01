package com.vetapp.history;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//exo pros8esei kai forma gia na kineitai o xristis me tab kai oxi mono me click, gia na mpei xreiazetai import to 
//parakato package kai uncomment to line 130

//import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MedHistoryGUI extends JFrame {

	public MedHistoryGUI() {
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("65px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(200px;default):grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("77px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("25px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				ColumnSpec.decode("88px"),
				ColumnSpec.decode("46px"),},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblMedicalHistory = new JLabel("Medical History");
		getContentPane().add(lblMedicalHistory, "6, 2, 1, 2, center, default");

		JLabel VaccineLbl = new JLabel("   Vaccinated:");
		VaccineLbl.setVerticalAlignment(SwingConstants.TOP);
		getContentPane().add(VaccineLbl, "6, 7, fill, center");

		VaccinesTxtFld = new JTextField();
		VaccinesTxtFld.setEditable(false);
		VaccineLbl.setLabelFor(VaccinesTxtFld);
		getContentPane().add(VaccinesTxtFld, "6, 9, fill, fill");
		VaccinesTxtFld.setColumns(10);
		VaccinesTxtFld.setText(Grafts);

		JLabel AllergiesLbl = new JLabel("   Allergies:");
		AllergiesLbl.setLabelFor(AllergiesLbl);
		getContentPane().add(AllergiesLbl, "6, 11, left, center");

		AllergiesTxtFld = new JTextField();
		AllergiesTxtFld.setEditable(false);
		getContentPane().add(AllergiesTxtFld, "6, 13, fill, fill");
		AllergiesTxtFld.setColumns(10);
		AllergiesTxtFld.setText(Alergies);

		JLabel DiseasesLbl = new JLabel("   Diseases:");
		getContentPane().add(DiseasesLbl, "6, 15, left, center");

		DiseasesTxtFld = new JTextField();
		DiseasesTxtFld.setEditable(false);
		DiseasesLbl.setLabelFor(DiseasesTxtFld);
		getContentPane().add(DiseasesTxtFld, "6, 17, fill, fill");
		DiseasesTxtFld.setColumns(10);
		DiseasesTxtFld.setText(As8eneies);

		JLabel SurgeriesLbl = new JLabel("   Surgeries:");
		SurgeriesLbl.setLabelFor(SurgeriesLbl);
		getContentPane().add(SurgeriesLbl, "6, 19, left, center");

		SurgTxtFld = new JTextField();
		SurgTxtFld.setEditable(false);
		getContentPane().add(SurgTxtFld, "6, 21, fill, fill");
		SurgTxtFld.setColumns(10);
		SurgTxtFld.setText(Surgeries);


		JLabel MedTrLbl = new JLabel("   Medical Treatment:");
		getContentPane().add(MedTrLbl, "6, 23, left, center");

		MedTreatmentTxtFld = new JTextField();
		MedTreatmentTxtFld.setEditable(false);
		MedTrLbl.setLabelFor(MedTreatmentTxtFld);
		getContentPane().add(MedTreatmentTxtFld, "6, 25, fill, fill");
		MedTreatmentTxtFld.setColumns(10);
		MedTreatmentTxtFld.setText(MedicalTreatment);

		JLabel NeuteringLbl = new JLabel("   Neutering:");
		getContentPane().add(NeuteringLbl, "6, 27, left, top");

		ButtonGroup BtnGroup = new ButtonGroup();

		JLabel NeuValLbl = new JLabel("No");//metavliti apo db anti gia no
		getContentPane().add(NeuValLbl, "8, 27, center, default");

		JButton EditBtn = new JButton("Edit Medical History");
		EditBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditMedHistoryGUI();
				
			}
		});
		getContentPane().add(EditBtn, "6, 31");

		JButton CancelBtn = new JButton("Cancel");
		CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedHistoryGUI.super.dispose();
			}
		});
		getContentPane().add(CancelBtn, "8, 31, 2, 1");
		//getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{VaccinesTxtFld, 
		//AllergiesTxtFld, DiseasesTxtFld, SurgTxtFld, MedTreatmentTxtFld, NeutBtnNo, NeutBtnYes, btnSaveChanges, 
		//btnNewButton, VaccineLbl, MedTrLbl, AllergiesLbl, DiseasesLbl, SurgeriesLbl, NeuteringLbl}));

	}
	private String Grafts;
	private String Alergies;
	private String As8eneies;
	private String Surgeries;
	private String MedicalTreatment;
	//private BirthGUI births;
	private JTextField VaccinesTxtFld;
	private JTextField AllergiesTxtFld;
	private JTextField DiseasesTxtFld;
	private JTextField SurgTxtFld;
	private JTextField MedTreatmentTxtFld;
	private boolean Female;

	public String getGrafts() {
		return Grafts;
	}
	public void setGrafts(String grafts) {
		Grafts = grafts;
	}

	public String getAlergies() {
		return Alergies;
	}
	public void setAlergies(String alergies) {
		Alergies = alergies;
	}

	public String getAs8eneies() {
		return As8eneies;
	}
	public void setAs8eneies(String as8eneies) {
		As8eneies = as8eneies;
	}

	public String getSurgeries() {
		return Surgeries;
	}
	public void setSurgeries(String surgeries) {
		Surgeries = surgeries;
	}

	public String getMedicalTreatment() {
		return MedicalTreatment;
	}
	public void setMedicalTreatment(String medicalTreatment) {
		MedicalTreatment = medicalTreatment;
	}

	public void editMeHistory() {
		//to be written
	}

	public void CheckGender(){
		//if(metavliti apo pet){
		Female=true;
		//}
	}

	public boolean isFemale() {
		return Female;
	}



	//============================================================================================
	//--------------------------------- EditMedHistoryGUI CLASS ----------------------------------
	//============================================================================================

	public class EditMedHistoryGUI extends JFrame { 

		private String Grafts;
		private String Alergies;
		private String As8eneies;
		private String Surgeries;
		private String MedicalTreatment;
		private BirthGUI births;
		private JTextField VaccinesTxtFld;
		private JTextField AllergiesTxtFld;
		private JTextField DiseasesTxtFld;
		private JTextField SurgTxtFld;
		private final JRadioButton NeutBtnYes = new JRadioButton("Yes");
		private JTextField MedTreatmentTxtFld;

		public EditMedHistoryGUI() {
			getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.UNRELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.UNRELATED_GAP_COLSPEC,
					ColumnSpec.decode("65px"),
					FormFactory.UNRELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(200px;default):grow"),
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("77px"),
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("86px"),
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("25px"),
					FormFactory.UNRELATED_GAP_COLSPEC,
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("16px"),
					ColumnSpec.decode("88px"),
					ColumnSpec.decode("46px"),},
					new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					RowSpec.decode("20px"),
					FormFactory.LINE_GAP_ROWSPEC,
					RowSpec.decode("23px"),
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));

			JLabel lblMedicalHistory = new JLabel("Edit Medical History");
			getContentPane().add(lblMedicalHistory, "6, 2, 1, 2, center, default");

			JLabel VaccineLbl = new JLabel("   Vaccinated:");
			VaccineLbl.setVerticalAlignment(SwingConstants.TOP);
			getContentPane().add(VaccineLbl, "6, 7, fill, center");

			VaccinesTxtFld = new JTextField();
			VaccineLbl.setLabelFor(VaccinesTxtFld);
			getContentPane().add(VaccinesTxtFld, "6, 9, fill, fill");
			VaccinesTxtFld.setColumns(10);
			VaccinesTxtFld.setText(Grafts);

			JLabel AllergiesLbl = new JLabel("   Allergies:");
			AllergiesLbl.setLabelFor(AllergiesLbl);
			getContentPane().add(AllergiesLbl, "6, 11, left, center");

			AllergiesTxtFld = new JTextField();
			getContentPane().add(AllergiesTxtFld, "6, 13, fill, fill");
			AllergiesTxtFld.setColumns(10);
			AllergiesTxtFld.setText(Alergies);

			JLabel DiseasesLbl = new JLabel("   Diseases:");
			getContentPane().add(DiseasesLbl, "6, 15, left, center");

			DiseasesTxtFld = new JTextField();
			DiseasesLbl.setLabelFor(DiseasesTxtFld);
			getContentPane().add(DiseasesTxtFld, "6, 17, fill, fill");
			DiseasesTxtFld.setColumns(10);
			DiseasesTxtFld.setText(As8eneies);

			JLabel SurgeriesLbl = new JLabel("   Surgeries:");
			SurgeriesLbl.setLabelFor(SurgeriesLbl);
			getContentPane().add(SurgeriesLbl, "6, 19, left, center");

			SurgTxtFld = new JTextField();
			getContentPane().add(SurgTxtFld, "6, 21, fill, fill");
			SurgTxtFld.setColumns(10);
			SurgTxtFld.setText(Surgeries);


			JLabel MedTrLbl = new JLabel("   Medical Treatment:");
			getContentPane().add(MedTrLbl, "6, 23, left, center");

			MedTreatmentTxtFld = new JTextField();
			MedTrLbl.setLabelFor(MedTreatmentTxtFld);
			getContentPane().add(MedTreatmentTxtFld, "6, 25, fill, fill");
			MedTreatmentTxtFld.setColumns(10);
			MedTreatmentTxtFld.setText(MedicalTreatment);

			JLabel NeuteringLbl = new JLabel("   Neutering:");
			getContentPane().add(NeuteringLbl, "6, 27, left, default");

			ButtonGroup BtnGroup = new ButtonGroup();
			getContentPane().add(NeutBtnYes, "8, 27, center, top");
			BtnGroup.add(NeutBtnYes);

			JButton BirthsBtn = new JButton("Births");
			BirthsBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BirthGUI();
				}
			});
			if(Female ){
				BirthsBtn.setEnabled(true);
			} else {
				BirthsBtn.setEnabled(false);
			}
			getContentPane().add(BirthsBtn, "6, 29");

			JRadioButton NeutBtnNo = new JRadioButton("No");
			NeutBtnNo.setSelected(true);
			getContentPane().add(NeutBtnNo, "8, 29, center, top");
			BtnGroup.add(NeutBtnNo);

			JButton btnSaveChanges = new JButton("Save Changes");
			btnSaveChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Saves the changes in the DB
				}
			});
			getContentPane().add(btnSaveChanges, "6, 33");

			JButton btnNewButton = new JButton("Cancel");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditMedHistoryGUI.super.dispose();
				}
			});
			getContentPane().add(btnNewButton, "8, 33, 2, 1");
			//getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{VaccinesTxtFld, 
			//AllergiesTxtFld, DiseasesTxtFld, SurgTxtFld, MedTreatmentTxtFld, NeutBtnNo, NeutBtnYes, btnSaveChanges, 
			//btnNewButton, VaccineLbl, MedTrLbl, AllergiesLbl, DiseasesLbl, SurgeriesLbl, NeuteringLbl}));

		}

		//============================================================================================
		//------------------------------------- BirthGUI CLASS ---------------------------------------
		//============================================================================================

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
				JLabel label = new JLabel("                                                  Births Given");
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
	}
}



