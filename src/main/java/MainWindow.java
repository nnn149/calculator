/**
 * FileName: MainWindow
 * Author:   10418
 * Date:     2019-10-18 16:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */

import core.Calculator;
import core.event.NumberButtonActionListener;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2019-10-18
 * @since 1.0.0
 */
public class MainWindow {
    private Calculator calculator;

    private JPanel mainJpanel;
    private JLabel labResult;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnZF;
    private JButton btnPoint;
    private JButton btnAdd;
    private JButton btnSubtract;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JButton btnResult;
    private JButton btnCE;
    private JButton btnC;
    private JButton btnBack;
    private JLabel labLog;

    public MainWindow() {
        init();
    }

    /**
     * 初始化控件事件
     */
    private void init() {
        calculator = new Calculator();
        NumberButtonActionListener listener = new NumberButtonActionListener(labResult, labLog, calculator);
        btn0.addActionListener(listener);
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        btn5.addActionListener(listener);
        btn6.addActionListener(listener);
        btn7.addActionListener(listener);
        btn8.addActionListener(listener);
        btn9.addActionListener(listener);
        btnZF.addActionListener(listener);
        btnPoint.addActionListener(listener);
        btnBack.addActionListener(listener);
        btnC.addActionListener(listener);
        btnCE.addActionListener(listener);
        btnAdd.addActionListener(listener);
        btnSubtract.addActionListener(listener);
        btnMultiply.addActionListener(listener);
        btnDivide.addActionListener(listener);
        btnResult.addActionListener(listener);
        mainJpanel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {

            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                mainJpanel.requestFocus(true);
            }
        });
        mainJpanel.addKeyListener(listener);
        mainJpanel.setFocusable(true);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("计算器");
        frame.setContentPane(new MainWindow().mainJpanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
