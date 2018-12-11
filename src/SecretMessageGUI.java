import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SecretMessageGUI extends JFrame {
	private JTextField txtKey;
	private JTextArea textIn;
	private JTextArea textOut;
	private JSlider slider;
	public String encode( String message, int keyVal){
		String output = "";
		char key = (char) keyVal;
        for ( int x = 0; x < message.length(); x++ ) {
            char input = message.charAt(x);
            if (input >= 'A' && input <= 'Z')
            {
                input += key;
                if (input > 'Z')
                    input -= 26;
                if (input < 'A')
                    input += 26;
            }
            else if (input >= 'a' && input <= 'z')
            {
                input += key;
                if (input > 'z')
                    input -= 26;
                if (input < 'a')
                    input += 26;
            }
            else if (input >= '0' && input <= '9')
            {
                input += (keyVal % 10);
                if (input > '9')
                    input -= 10;
                if (input < '0')
                    input += 10;
            }
            output += input;
        }
		return output;
	}
	public SecretMessageGUI() {
		getContentPane().setBackground(new Color(176, 196, 222));
		setTitle("Noah's Secret Message app");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textIn = new JTextArea();
		textIn.setWrapStyleWord(true);
		textIn.setLineWrap(true);
		textIn.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		textIn.setBounds(10, 11, 564, 128);
		getContentPane().add(textIn);
		
		textOut = new JTextArea();
		textOut.setWrapStyleWord(true);
		textOut.setLineWrap(true);
		textOut.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		textOut.setBounds(10, 196, 564, 154);
		getContentPane().add(textOut);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(250, 160, 46, 14);
		getContentPane().add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setText("12");
		txtKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtKey.setBounds(300, 157, 86, 20);
		getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		JButton btnEncodedecode = new JButton("Encode/Decode");
		btnEncodedecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String message = textIn.getText();
					int key = Integer.parseInt(txtKey.getText() );
					String output = encode(message, key);
					textOut.setText(output);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, 
							"Please enter a whole number for the encryption key" );
					txtKey.requestFocus();
					txtKey.selectAll();
				}
			}
		});
		btnEncodedecode.setBounds(419, 156, 134, 23);
		getContentPane().add(btnEncodedecode);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtKey.setText("" + slider.getValue());
				String message = textIn.getText();
				int key = Integer.parseInt(txtKey.getText() );
				String output = encode(message, key);
				textOut.setText(output);
			}
		});
		slider.setValue(12);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(13);
		slider.setMinimum(-26);
		slider.setMaximum(26);
		slider.setBackground(new Color(176, 196, 222));
		slider.setBounds(20, 150, 200, 45);
		getContentPane().add(slider);
	}

	public static void main(String[] args) {
		SecretMessageGUI theApp = new SecretMessageGUI();
		theApp.setSize(new java.awt.Dimension(600,400));
		theApp.setVisible(true);
	}
}
