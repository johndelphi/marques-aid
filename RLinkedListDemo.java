import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
   This class is used to demonstrate
   the operations in the LinkedList1 class.
*/

public class RLinkedListDemo extends JFrame
{    
    private RLinkedList ll;
    private JTextArea  listView;
    private JTextField cmdTextField;
    private JTextField resultTextField;
    
    /**
       Constructor.
    */
    
    public RLinkedListDemo()
    {       
       ll = new RLinkedList(); 
       listView = new JTextArea();
       cmdTextField = new JTextField();
       resultTextField = new JTextField();
       
       // Create a panel and label for result field
       JPanel resultPanel = new JPanel(new GridLayout(1,2));
       resultPanel.add(new JLabel("Command Result"));
       resultPanel.add(resultTextField);
       resultTextField.setEditable(false);
       add(resultPanel, BorderLayout.NORTH);
       
       // Put the textArea in the center of the frame
       add(listView);
       listView.setEditable(false);
       listView.setBackground(Color.WHITE);
       
       // Create a panel and label for the command text field
       JPanel cmdPanel = new JPanel(new GridLayout(1,2));
       cmdPanel.add(new JLabel("Command:"));
       cmdPanel.add(cmdTextField);
       add(cmdPanel, BorderLayout.SOUTH);  
       cmdTextField.addActionListener(new CmdTextListener());
       
       // Set up the frame
       setTitle("Recursive Linked List Demo");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pack();
       setVisible(true);       
    }
    
    /**
       private inner class that responds to commands typed 
       in by the user at the command entry text field.
    */
    private class CmdTextListener
            implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            String cmdText = cmdTextField.getText();
            Scanner sc = new Scanner(cmdText);
            String cmd = sc.next();
            if (cmd.equals("add"))
            {
                if (sc.hasNextInt())
                {
                    // add index element
                    int index = sc.nextInt();
                    String element = sc.next();
                    ll.add(index, element);                
                }
                else
                {  
                    // add element
                    String element = sc.next();
                    ll.add(element);                
                }
                listView.setText(ll.toString());
                pack();
                return;
            } 
            if (cmd.equals("remove"))
            {
                if (sc.hasNextInt())
                {
                    // remove index
                    int index = sc.nextInt();
                    String res = ll.remove(index);
                    resultTextField.setText(String.valueOf(res));              
                }
                else
                {
                    // remove element
                    String element = sc.next();
                    boolean res = ll.remove(element);
                    resultTextField.setText(String.valueOf(res));
                }
                listView.setText(ll.toString());
                pack();
                return;
            } 
            if (cmd.equals("isempty"))
            {
                resultTextField.setText(String.valueOf(ll.isEmpty()));
                return;
            }
            if (cmd.equals("size"))
            {
               resultTextField.setText(String.valueOf(ll.size()));
            }
        }
    }
	 
	 /** 
	    The main method instantiates the main window
		 and gets the program running.
    */
    public static void main(String [ ] args)
    {
        new RLinkedListDemo();
    }    
}