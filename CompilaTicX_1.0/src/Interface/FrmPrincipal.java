package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AnalisadorLexico.AnaLexica;
import Sintatica.Teste.AnaliseSint;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtArquivo;
	AnaLexica Lex = new AnaLexica();
	AnaliseSint Ana = new AnaliseSint();
	
	//
	JTextPane textPaneLex = new JTextPane();
	JTextPane textPaneCodFonte = new JTextPane();
	JTextPane textPaneAnaSintática = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLexer = new JButton("Analisar");
		btnLexer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String test = txtArquivo.getText();
				Lex.resultado ="";
				try {
					Lex.analisar(test);
					Ana.analisaSint(test);
					textPaneAnaSintática.setText(Ana.resposta); 
					textPaneLex.setText(Lex.resultado);
					textPaneCodFonte.setText(Lex.codFonte);
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		txtArquivo = new JTextField();
		txtArquivo.setColumns(10);
		
		JLabel lblCaminho = new JLabel("Caminho do Arquivo");
		
		JPanel panelLex = new JPanel();
		
		JPanel panelCodFonte = new JPanel();
		
		JLabel lblCodfonte = new JLabel("C\u00F3digo Fonte");
		
		JLabel lblAnalex = new JLabel("An\u00E1lise L\u00E9xica");
		
		JPanel panelSin = new JPanel();
		
		JLabel lblAnliseSinttica = new JLabel("An\u00E1lise Sint\u00E1tica");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblCaminho)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtArquivo, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelCodFonte, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLexer)
										.addComponent(lblCodfonte))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(lblAnliseSinttica))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(panelSin, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAnalex)
								.addComponent(panelLex, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtArquivo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCaminho))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLexer)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodfonte)
						.addComponent(lblAnalex)
						.addComponent(lblAnliseSinttica))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelCodFonte, 0, 0, Short.MAX_VALUE)
						.addComponent(panelSin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelLex, 0, 0, Short.MAX_VALUE))
					.addGap(19))
		);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panelSin = new GroupLayout(panelSin);
		gl_panelSin.setHorizontalGroup(
			gl_panelSin.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSin.createSequentialGroup()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelSin.setVerticalGroup(
			gl_panelSin.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
		);
		
		
		scrollPane_2.setViewportView(textPaneAnaSintática);
		panelSin.setLayout(gl_panelSin);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelCodFonte = new GroupLayout(panelCodFonte);
		gl_panelCodFonte.setHorizontalGroup(
			gl_panelCodFonte.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
		);
		gl_panelCodFonte.setVerticalGroup(
			gl_panelCodFonte.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
		);
		
		
		scrollPane_1.setViewportView(textPaneCodFonte);
		panelCodFonte.setLayout(gl_panelCodFonte);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelLex = new GroupLayout(panelLex);
		gl_panelLex.setHorizontalGroup(
			gl_panelLex.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLex.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelLex.setVerticalGroup(
			gl_panelLex.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
		);
		scrollPane.setViewportView(textPaneLex);
		panelLex.setLayout(gl_panelLex);
		contentPane.setLayout(gl_contentPane);
	}
}
