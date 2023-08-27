package cop2805;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;

public class GUICalculateBox {
	
	private static void constructGUI( ) {
	   
		JFrame.setDefaultLookAndFeelDecorated(true);
	    MyFrame frame = new MyFrame(); 
	}
	
	public static void main(String[] args) {    
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});         
	}    
}  

class MyFrame extends JFrame {
	public JTextField firstNumber;
	public JTextField secondNumber;
	public JLabel result;
	

	public MyFrame() {
		super();
		init();
	}

	private void init() {
		
		firstNumber = new JTextField();
		secondNumber = new JTextField();
   
	    this.setSize(350,350);    
	    this.setVisible(true); 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("Simple Calculator");
		this.setLayout(new GridLayout(5, 2));
	    this.pack();
	    this.add(new JLabel("First Number:"));
	    this.add(firstNumber);
	    this.add(new JLabel("Second Number:"));
	    this.add(secondNumber);
	    this.add(new JLabel());
		
		String calculations[]={"Add","Subtract","Multiply","Divide"};        
	    final JComboBox selection=new JComboBox(calculations); 
	    
		JButton calcButton=new JButton("Calculate");
		final JLabel result = new JLabel();
		
		this.add(selection);
		this.add(new JLabel());
	    this.add(calcButton);
	    this.add(result);
	    
	    int frameWidth = 450;
		int frameHeight = 200;
		Dimension screenSize =
			Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int) screenSize.getWidth() - frameWidth, 0,
		frameWidth, frameHeight);
		
	    calcButton.addActionListener(new ActionListener() 
	    	{  
	        	public void actionPerformed(ActionEvent e) 
	        	{  
	        		Object i = selection.getItemAt(selection.getSelectedIndex());
	        		String first = firstNumber.getText();
	        		String second = secondNumber.getText();
	        		
	        		
	        		double firstNum = Double.parseDouble(first);
	        		double secondNum = Double.parseDouble(second);
	        		double answer= 0.0;
	        		
	        		if (i == "Add") {
        				answer = firstNum + secondNum;
        			} else if (i == "Subtract") {
        				answer = firstNum - secondNum;
        			} else if (i == "Multiply") {
        				answer = firstNum * secondNum;
        			} else {
        				answer = (firstNum / secondNum) + (firstNum % secondNum);
        			}
	        		
	        		String answerNum = String.valueOf(answer);
	        		
	        		//String data = first + " + " + second + " = " + answerNum;
	        		String data = "Answer = " + answerNum;
	        		
	        		result.setText(data);

	        	}
	    	});
	}
}