package Commands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;

public class DML {

    private Frame mainFrame;
    private Button button1, button2, button3;
    private Frame frame2, frame3, frame4;

    public DML() {
        prepareGUI();
        createButtonInterface();
    }
    
    private void prepareGUI() {
        mainFrame = new Frame("Main Frame");
        mainFrame.setSize(600, 600);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setBackground(new Color(0x009270));

        mainFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }
        });
    }

    Font f=new Font("Arial", Font.ITALIC, 15);
    Font f2=new Font("Arial", Font.BOLD, 15);

    private void createButtonInterface() {
        button1 = new Button("Add Data to employee Database");
        button1.setFont(f);
        button1.setBackground(new Color(0xDF5032));
        button1.setPreferredSize(new Dimension(250, 60));

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                frame2 = new Frame("Adding Data");
                frame2.setSize(600, 600);
                frame2.setBackground(new Color(0x009270));
                frame2.setLayout(new GridBagLayout());
                
                Label Name1=new Label("Name:");
                Name1.setFont(f);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Name1,gbc);
                TextField Name2=new TextField(15);
                Name2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Name2,gbc);

                Label Dept1=new Label("Depart:");
                Dept1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Dept1,gbc);
                TextField Dept2=new TextField(15);
                Dept2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Dept2,gbc);

                Label Sal1=new Label("Salary:");
                Sal1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Sal1,gbc);
                TextField Sal2=new TextField(15);
                Sal2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Sal2,gbc);

                Label Age1=new Label("Age:");
                Age1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Age1,gbc);
                TextField Age2=new TextField(15);
                Age2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 3;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Age2,gbc);

                Label Bonus1=new Label("Bonus:");
                Bonus1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 4;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Bonus1,gbc);
                TextField Bonus2=new TextField(15);
                Bonus2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 4;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Bonus2,gbc);

                Label Loc1=new Label("Place:");
                Loc1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Loc1,gbc);
                TextField Loc2=new TextField(15);
                Loc2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 5;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame2.add(Loc2,gbc);
                
                Button backButton = new Button("<- Home");
                backButton.setFont(f);
                backButton.setBackground(new Color(0xDF5032));
                backButton.setPreferredSize(new Dimension(110, 60));
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        mainFrame.setVisible(true);
                    }
                });
                gbc.gridy = 6;
                gbc.gridx=0;
                gbc.anchor = GridBagConstraints.PAGE_END;
                frame2.add(backButton,gbc);

                Button insertb = new Button("Insert ->");
                insertb.setFont(f);
                insertb.setBackground(new Color(0xDF5032));
                insertb.setPreferredSize(new Dimension(110, 60));
                insertb.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String Name5 = Name2.getText();
                        String Dept3 = Dept2.getText();
                        int Sal3 = Integer.parseInt(Sal2.getText());
                        int Age3 = Integer.parseInt(Age2.getText());
                        int Bonus3 = Integer.parseInt(Bonus2.getText());
                        String Loc3 = Loc2.getText();

                        try {
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jack","root","Omkarkaw@0608");
                            String QL1="INSERT INTO EMPLOYEE(Name,Department,Salary,Age,Bonus,Location) values (?,?,?,?,?,?)";
                            PreparedStatement State1 = con.prepareStatement(QL1);
                            State1.setString(1, Name5);
                            State1.setString(2, Dept3);
                            State1.setInt(3, Sal3);
                            State1.setInt(4, Age3);
                            State1.setInt(5, Bonus3);
                            State1.setString(6, Loc3);
                            State1.executeUpdate();
                            State1.close();
                            con.close();
                            System.out.println("Data successfully inserted in the table");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        frame2.setVisible(false);
                        mainFrame.setVisible(true);
                    }
                });
                gbc.gridy = 6;
                gbc.gridx=1;
                gbc.anchor = GridBagConstraints.PAGE_END;
                frame2.add(insertb,gbc);
                
                frame2.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent windowEvent){
                       frame2.setVisible(false);
                       mainFrame.setVisible(true);
                    }
                });
                
                frame2.setVisible(true);
            }
        });
        
        button2 = new Button("Delete data from Database");
        button2.setFont(f);
        button2.setBackground(new Color(0xDF5032));
        button2.setPreferredSize(new Dimension(250, 60));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                frame3 = new Frame("Deleting Data");
                frame3.setSize(600, 600);
                frame3.setBackground(new Color(0x009270));
                frame3.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                Label Dname1 = new Label("Enter the name to delete data:"); 
                Dname1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame3.add(Dname1, gbc);
                TextField Dname2=new TextField(15);
                Dname2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame3.add(Dname2, gbc);

                Button backButton = new Button("<- Home");
                backButton.setFont(f);
                backButton.setBackground(new Color(0xDF5032));
                backButton.setPreferredSize(new Dimension(110, 60));
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame3.setVisible(false);
                        mainFrame.setVisible(true);
                    }
                });
                gbc.gridx=0;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.PAGE_END;
                frame3.add(backButton, gbc);

                Button DelButton = new Button("Delete ->");
                DelButton.setFont(f);
                DelButton.setBackground(new Color(0xDF5032));
                DelButton.setPreferredSize(new Dimension(110, 60));
                DelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String Dname3 = Dname2.getText();

                        try {
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shweta","root","Shweta@21042003");
                            String QL2="DELETE FROM employee WHERE name=?";
                            PreparedStatement State2 = con.prepareStatement(QL2);
                            State2.setString(1, Dname3);
                            State2.executeUpdate();
                            State2.close();
                            con.close();
                            System.out.println("Data successfully deleted from the table");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        frame3.setVisible(false);
                        mainFrame.setVisible(true);
                    }
                });
                gbc.gridx=1;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.PAGE_END;
                frame3.add(DelButton, gbc);
                
                frame3.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent windowEvent){
                       frame3.setVisible(false);
                       mainFrame.setVisible(true);
                    }
                });
                
                frame3.setVisible(true);
            }
        });
        
        button3 = new Button("Update Employee Details");
        button3.setFont(f);
        button3.setBackground(new Color(0xDF5032));
        button3.setPreferredSize(new Dimension(250, 60));
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                frame4 = new Frame("Details");
                frame4.setSize(600, 600);
                frame4.setBackground(new Color(0x009270));
                frame4.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();

                Label Uname1 = new Label("Name of employee to update:");
                Uname1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(Uname1,gbc);
                TextField Uname2=new TextField(15);
                Uname2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(Uname2,gbc);
                
                Label UDept1=new Label("Depart:");
                UDept1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(UDept1,gbc);
                TextField UDept2=new TextField(15);
                UDept2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 3;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(UDept2,gbc);

                Label USal1=new Label("Sal:");
                USal1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 4;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(USal1,gbc);
                TextField USal2=new TextField(15);
                USal2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 4;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(USal2,gbc);

                Label UAge1=new Label("Age:");
                UAge1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(UAge1, gbc);
                TextField UAge2=new TextField(15);
                UAge2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 5;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(UAge2,gbc);

                Label UBonus1=new Label("Bonus:");
                UBonus1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 6;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(UBonus1,gbc);
                TextField UBonus2=new TextField(15);
                UBonus2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 6;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(UBonus2,gbc);

                Label ULoc1=new Label("Loca:");
                ULoc1.setFont(f);
                gbc.gridx = 0;
                gbc.gridy = 7;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(ULoc1,gbc);
                TextField ULoc2=new TextField(15);
                ULoc2.setFont(f);
                gbc.gridx = 1;
                gbc.gridy = 7;
                gbc.insets = new Insets(10, 0, 10, 0);
                frame4.add(ULoc2,gbc);

                Button backButton = new Button("<- Home");
                backButton.setFont(f);
                backButton.setBackground(new Color(0xDF5032));
                backButton.setPreferredSize(new Dimension(110, 60));
                backButton.addActionListener(new ActionListener() {                            
                    public void actionPerformed(ActionEvent e) {
                        
                        frame4.setVisible(false);
                        mainFrame.setVisible(true);

                    }
                });
                gbc.gridx=0;
                gbc.gridy = 8;
                gbc.anchor = GridBagConstraints.PAGE_END;
                frame4.add(backButton, gbc);

                Button UdButton = new Button("Update ->");
                UdButton.setFont(f);
                UdButton.setBackground(new Color(0xDF5032));
                UdButton.setPreferredSize(new Dimension(110, 60));
                UdButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String Uname5 = Uname2.getText();
                        String UDept3 = UDept2.getText();
                        int USal3 = Integer.parseInt(USal2.getText());
                        int UAge3 = Integer.parseInt(UAge2.getText());
                        int UBonus3 = Integer.parseInt(UBonus2.getText());
                        String ULoc3 = ULoc2.getText();

                        try {
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shweta","root","Shweta@21042003");
                            String QL3="UPDATE EMPLOYEE SET Department=?,Salary=?,Age=?,Bonus=?,Location=? WHERE Name=?";
                            PreparedStatement State3 = con.prepareStatement(QL3);
                            State3.setString(1, UDept3);
                            State3.setInt(2, USal3);
                            State3.setInt(3, UAge3);
                            State3.setInt(4, UBonus3);
                            State3.setString(5, ULoc3);
                            State3.setString(6, Uname5);
                            State3.executeUpdate();
                            State3.close();
                            con.close();
                            System.out.println("Data successfully inserted in the table");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }                        

                        frame4.setVisible(false);
                        mainFrame.setVisible(true);
                    }
                });
                gbc.gridx=1;
                gbc.gridy = 8;
                gbc.anchor = GridBagConstraints.PAGE_END;
                frame4.add(UdButton, gbc);

                
                frame4.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent windowEvent){
                       frame4.setVisible(false);
                       mainFrame.setVisible(true);
                    }
                });
                
                frame4.setVisible(true);
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        mainFrame.add(button1, gbc);
        
        gbc.gridy = 1;
        mainFrame.add(button2, gbc);
        
        gbc.gridy = 2;
        mainFrame.add(button3, gbc);
    }
    
    public void showGUI() {
        mainFrame.setVisible(true);
    }
    
    public static void main(String[] args) throws SQLException{
        DML guiExample = new DML();
        guiExample.showGUI();
    }

    // public static void main (String args[]) throws SQLException{
        
    //     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shweta","root","Shweta@21042003");

    //     Statement st=con.createStatement();

    //     String s="INSERT INTO EMPLOYEE VALUES('Lizzie Green','SALES',50000,28,12000,'Melbourne')";

    //     st.execute(s);

    //     con.close();

    //     System.out.println("Query executed");
    // }
    
}
