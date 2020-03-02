package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import logic.CypherOps;


public class EncryptionAppDriver implements ActionListener {

	private JFrame frame;
	private JTextPane input;
	private JLabel outPut;
	private JButton encryptButton;
	private JButton decryptButton;
	private JButton clearButton;
	private String message;
	private String encryptedMessage;
	private String decryptedMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptionAppDriver window = new EncryptionAppDriver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EncryptionAppDriver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		input = new JTextPane();
		input.setSize(150,100);
		frame.add(input, BorderLayout.CENTER);
		
		outPut = new JLabel();
		outPut.setSize(10, 150);
		outPut.setText("Output");
		frame.add(outPut, BorderLayout.SOUTH);
		
		encryptButton = new JButton("Encrypt");
		encryptButton.addActionListener(this);
		frame.add(encryptButton, BorderLayout.WEST);
		
		decryptButton = new JButton("Decrypt");
		decryptButton.addActionListener(this);
		frame.add(decryptButton, BorderLayout.EAST);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		frame.add(clearButton, BorderLayout.NORTH);
		
	}
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("Encrypt")){
			outPut.setText(CypherOps.encryptMessage(input.getText()));
			message = input.getText();
			encryptedMessage = outPut.getText();
			input.setText("Original message: " + message);
		}
		else if (action.equals("Decrypt")) {
			outPut.setText(CypherOps.decryptMessage(encryptedMessage));
			decryptedMessage = outPut.getText();
			input.setText("Original message: " + message + "\nEncrypted message: " + encryptedMessage);
		}
		else if (action.equals("Clear")) {
			message = "";
			encryptedMessage = "";
			decryptedMessage = "";
			input.setText("");
			outPut.setText("Output");
		}
	}

}
