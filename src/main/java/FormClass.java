

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormClass extends JFrame  {
    private JPanel panel;
    private JButton addKeyButton;
    public JTextArea WordArea;
    private JLabel stopWord;
    private JTextArea maxArea;
    private JLabel label1;
    private JTextArea AreaCoef2;
    private JLabel label2;

    //public static FormClass instance ;
    public static String key = null;
    public static String max = null;
    public static String coef = null;
    public static int maxI = 100;
    public double coef1,coef2;
    public static FormClass dialog;
    public FormClass() {


        setContentPane(panel);
        //setModal(true);
        getRootPane().setDefaultButton(addKeyButton);


        addKeyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                key = WordArea.getText();
                coef = AreaCoef2.getText();
                max = maxArea.getText();
                if (!coef.equals("")) {
                    coef1 = Double.parseDouble(max);
                    coef2 = Double.parseDouble(coef);
                    WordArea.setText(CountMoney.TwoCoefs(coef1, coef2, Integer.parseInt(key)));
                } else {
                    maxI = Integer.parseInt(max);
                    try {
                        Scanning scanning = new Scanning();
                        Thread scan = new Thread(scanning);
                        scan.start();
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }

                }
            }
        });
        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

    }


    public static void CteateForm() {
        dialog = new FormClass();

        dialog.pack();
        dialog.setTitle("Start");
        dialog.setLocation(500,300);
        dialog.setSize(700,300);
        dialog.setVisible(true);

    }
}
