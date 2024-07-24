import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.Collections;

public class Rolodex extends JFrame
{
    public Rolodex (String title)
    {
        super(title);
        JTextField text = new JTextField();
        JTextField fin = new JTextField (" ");
        ArrayList<People> names = new ArrayList<People>();
        ArrayList<String> displayText = new ArrayList<String>();


        JFrame frame = new JFrame("Rolodex");

        for (int x = 0; x <= 3; x++)
        {
            int y = 25;
            JTextField display = new JTextField();
            display.setBounds(300, y + 40*(x), 135, 23);
            display.setBorder(new LineBorder(Color.black, 2));
            display.setEditable(false);
            frame.add(display);

            if (x == 0)
            {
                display.setText("First Name: ");
            }
            else if (x == 1)
            {
                display.setText("Last Name: ");
            }
            else if (x == 2)
            {
                display.setText("Phone Number: ");
            }
            else if (x == 3)
            {
                display.setText("Address: ");
            }
            display.setVisible(true);
        }

        frame.setSize(650, 500);
        frame.setLayout(null);

        JTextField firstName = new JTextField (" ");
        firstName.setBounds(480, 25, 135, 23);
        firstName.setBorder(new LineBorder(Color.black, 1));
        firstName.setEditable(true);
        frame.add(firstName);

        JTextField lastName = new JTextField (" ");
        lastName.setBounds(480, 65, 135, 23);
        lastName.setBorder(new LineBorder(Color.black, 1));
        lastName.setEditable(true);
        frame.add(lastName);

        JTextField phoneNumber = new JTextField (" ");
        phoneNumber.setBounds(480, 105, 135, 23);
        phoneNumber.setBorder(new LineBorder(Color.black, 1));
        phoneNumber.setEditable(true);
        frame.add(phoneNumber);

        JTextField address = new JTextField (" ");
        address.setBounds(480, 145, 135, 23);
        address.setBorder(new LineBorder(Color.black, 1));
        address.setEditable(true);
        frame.add(address);

        JButton button = new JButton("Save");
        button.setBounds(310, 190, 130, 23);
        frame.add(button);
        button.setVisible(true);

        JList people = new JList();
        people.setBounds(10, 10, 250, 440);
        frame.add(people);
        people.setVisible(true);

        button.addActionListener(e->
        {
            //ADD CODE
            // add items to list
            if (firstName.getText().equals("") || firstName.getText().equals(" ") || lastName.getText().equals("") || lastName.getText().equals(" "))
            {
                JOptionPane.showMessageDialog(frame, "Your contact must have a first and last name");
            }
            else
            {
                People p = new People(firstName.getText(), lastName.getText(), phoneNumber.getText(), address.getText());
                names.add(p);
                displayText.add(p.display());
                Collections.sort(displayText);
                people.setListData(displayText.toArray());
                firstName.setText("");
                lastName.setText("");
                address.setText("");
                phoneNumber.setText("");
            }
        });

        JButton b = new JButton("Save Changes");
        b.setBounds(310, 220, 130, 23);
        frame.add(b);
        b.setVisible(true);

        JButton c = new JButton("Delete Contact");
        c.setBounds(480, 220, 130, 23);
        frame.add(c);
        c.setVisible(true);

        people.addListSelectionListener(e->
                {
                    People person = names.get(0);
                    for (int x = 0; x < displayText.size(); x++)
                    {
                        if (((String)people.getSelectedValue()).equals(names.get(x).display()))
                        {
                            person = names.get(x);
                        }
                    }
                    firstName.setText(person.getFName());
                    lastName.setText(person.getLName());
                    phoneNumber.setText(person.getNumber());
                    address.setText(person.getAddress());
                    // add save changes and delete contact button
                }
        );

        b.addActionListener(i->
        {
            //ADD CODE
            // add items to list
            if (firstName.getText().equals("") || firstName.getText().equals(" ") || lastName.getText().equals("") || lastName.getText().equals(" "))
            {
                JOptionPane.showMessageDialog(frame, "Your contact must have a first and last name");
            }
            else
            {
                People person = names.get(0);
                int index = 0;
                for (int x = 0; x < displayText.size(); x++)
                {
                    if (((String)people.getSelectedValue()).equals(names.get(x).display()))
                    {
                        person = names.get(x);
                        index = x;
                    }
                }
                displayText.remove(person.display());
                names.remove(person);
                People p = new People(firstName.getText(), lastName.getText(), phoneNumber.getText(), address.getText());
                names.add(p);
                displayText.add(p.display());
                Collections.sort(displayText);
                people.setListData(displayText.toArray());
                firstName.setText("");
                lastName.setText("");
                address.setText("");
                phoneNumber.setText("");
                /*person.setFName(firstName.getText());
                person.setLName(lastName.getText());
                person.setNumber(phoneNumber.getText());
                person.setAddress(address.getText());
                names.set(index, names.get(index));
                displayText.set(index, names.get(index).display());
                Collections.sort(displayText);
                people.setListData(displayText.toArray());*/
            }
        });

        c.addActionListener(i->
        {
            //ADD CODE
            // add items to list
            if (firstName.getText().equals("") || firstName.getText().equals(" ") || lastName.getText().equals("") || lastName.getText().equals(" "))
            {
                JOptionPane.showMessageDialog(frame, "Your contact must have a first and last name");
            }
            else
            {
                People person = names.get(0);
                for (int x = 0; x < displayText.size(); x++)
                {
                    if (((String)people.getSelectedValue()).equals(names.get(x).display()))
                    {
                        person = names.get(x);
                    }
                }
                displayText.remove(person.display());
                Collections.sort(displayText);
                people.setListData(displayText.toArray());
                firstName.setText("");
                lastName.setText("");
                address.setText("");
                phoneNumber.setText("");
                people.clearSelection();
            }
        });

        button = new JButton("New");
        button.setBounds(480, 190, 130, 23);
        frame.add(button);
        button.setVisible(true);

        button.addActionListener(i->
        {
            firstName.setText("");
            lastName.setText("");
            address.setText("");
            phoneNumber.setText("");
            people.clearSelection();
        });

        frame.setVisible(true);
    }
}
