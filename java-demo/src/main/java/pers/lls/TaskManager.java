package pers.lls;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TaskManager extends JFrame {

    private ArrayList<Task> taskList;

    public TaskManager() {
        super("任务管理器");
        taskList = new ArrayList<Task>();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建界面组件
        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("任务名称：");
        final JTextField nameField = new JTextField(20);
        JLabel startLabel = new JLabel("开始时间：");
        final JTextField startField = new JTextField(20);
        JButton addButton = new JButton("添加任务");
        final JTextArea taskArea = new JTextArea(10, 30);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String start = startField.getText();
                Task newTask = new Task(name, start);
                taskList.add(newTask);
                taskArea.append(newTask.toString() + "\n");
                nameField.setText("");
                startField.setText("");
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(startLabel);
        panel.add(startField);
        panel.add(addButton);

        JScrollPane scrollPane = new JScrollPane(taskArea);
        panel.add(scrollPane);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
    }

    class Task {
        private String name;
        private String startTime;
        private String endTime;

        public Task(String name, String startTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = "";
        }

        public String getName() {
            return name;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String toString() {
            if (endTime.isEmpty()) {
                return name + "（开始时间：" + startTime + "）";
            } else {
                return name + "（开始时间：" + startTime + "，完成时间：" + endTime + "）";
            }
        }
    }
}
