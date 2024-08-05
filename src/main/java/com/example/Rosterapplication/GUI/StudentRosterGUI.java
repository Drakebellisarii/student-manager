package com.example.Rosterapplication.GUI;

import com.example.Rosterapplication.model.Student;
import com.example.Rosterapplication.service.Roster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRosterGUI extends JFrame {
    private Roster roster;
    private JTextField idField, nameField, ageField, gradYearField, majorField;
    private JTextArea outputArea;
    private JPanel rosterPanel;
    private JButton toggleButton;
    private boolean isRosterVisible = true;

    public StudentRosterGUI(Roster roster) {
        this.roster = roster;
        createView();
        setTitle("Student Roster Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500); // Increased size to accommodate new button
        setLocationRelativeTo(null);
        setVisible(true);
        updateStudentRoster(); // Initial call to display the roster
    }

    private void createView() {
        JPanel panel = new JPanel(new GridLayout(9, 2)); // Updated layout to include toggle button
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        panel.add(ageLabel);
        panel.add(ageField);

        JLabel gradYearLabel = new JLabel("Grad Year:");
        gradYearField = new JTextField();
        panel.add(gradYearLabel);
        panel.add(gradYearField);

        JLabel majorLabel = new JLabel("Major:");
        majorField = new JTextField();
        panel.add(majorLabel);
        panel.add(majorField);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        JButton deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(new DeleteButtonListener());
        panel.add(deleteButton);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.addActionListener(new ClearButtonListener());
        panel.add(clearButton);

        toggleButton = new JButton("Hide Roster");
        toggleButton.addActionListener(new ToggleButtonListener());
        panel.add(toggleButton);

        // Panel to contain the outputArea
        rosterPanel = new JPanel(new BorderLayout());
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        rosterPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        getContentPane().add(rosterPanel, BorderLayout.SOUTH);
    }

    private void updateStudentRoster() {
        try {
            java.util.List<Student> students = roster.getAllStudents();
            StringBuilder sb = new StringBuilder("Your Student Roster:\n");
            for (Student student : students) {
                sb.append(student.toString()).append("\n");
            }
            outputArea.setText(sb.toString());
        } catch (Exception ex) {
            outputArea.setText("Error retrieving students: " + ex.getMessage());
        }
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                long id = Long.parseLong(idField.getText()); // Changed to long for consistency
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                int gradYear = Integer.parseInt(gradYearField.getText());
                String major = majorField.getText();

                Student student = new Student(age, name, id, gradYear, major);
                roster.addStudent(student);
                roster.save(student);
                outputArea.setText("Student added successfully.");
                updateStudentRoster(); // Refresh the student list
            } catch (Exception ex) {
                outputArea.setText("Error adding student: " + ex.getMessage());
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                long id = Long.parseLong(idField.getText()); // Changed to long for consistency
                roster.deleteStudent(id);
                outputArea.setText("Student deleted successfully.");
                updateStudentRoster(); // Refresh the student list
            } catch (Exception ex) {
                outputArea.setText("Error deleting student: " + ex.getMessage());
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            gradYearField.setText("");
            majorField.setText("");
        }
    }

    private class ToggleButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            isRosterVisible = !isRosterVisible;
            rosterPanel.setVisible(isRosterVisible);
            toggleButton.setText(isRosterVisible ? "Hide Roster" : "Show Roster");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRosterGUI(new Roster()));
    }
}
