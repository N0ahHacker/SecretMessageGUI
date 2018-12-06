import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SecretMessageGUI extends JFrame {
	private JTextField txtKey;
	private JTextArea TextIn;
	private JTextArea TextOut;
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
		setTitle("Noah's Secret Message app");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		TextIn = new JTextArea();
		TextIn.setBounds(10, 11, 564, 128);
		getContentPane().add(TextIn);
		
		TextOut = new JTextArea();
		TextOut.setBounds(10, 196, 564, 154);
		getContentPane().add(TextOut);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(200, 160, 46, 14);
		getContentPane().add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(250, 157, 86, 20);
		getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		JButton btnEncodedecode = new JButton("Encode/Decode");
		btnEncodedecode.setBounds(360, 156, 120, 23);
		getContentPane().add(btnEncodedecode);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
