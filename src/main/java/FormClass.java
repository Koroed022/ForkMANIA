

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormClass extends JFrame  {
    private JPanel panel;
    private JButton forecastButton;
    private JTextArea commandArea1;
    private JTextArea commandArea2;
    private JTextArea resulArea;
    private JLabel label1;
    private JLabel label2;
    public static String com1 = null,com2 = null;
    public static FormClass dialog;

    public FormClass() {
        try {
            super.setContentPane(panel);
            //setModal(true);
            super.getRootPane().setDefaultButton(forecastButton);


            forecastButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    com1 = commandArea1.getText();
                    com2 = commandArea2.getText();
                    if (com1.equals("") || com2.equals(""))
                        resulArea.setText("Введите две команды");
                    //resulArea.setText("Победит команда: " + "");//вставить победителя из стратегий
                }
            });
            setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        }catch (IllegalComponentStateException illegalComponentStateException){
            System.out.println(illegalComponentStateException.toString());}
    }


    public static void CteateForm() {
        dialog = new FormClass();

        dialog.pack();
        dialog.setTitle("Forecast Bot");
        dialog.setLocation(500,300);
        dialog.setSize(500,300);
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);

    }
}
