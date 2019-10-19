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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        btn0.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn1.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn2.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn3.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn4.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn5.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn6.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn7.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn8.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btn9.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnZF.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnPoint.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnBack.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnC.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnCE.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnAdd.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnSubtract.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnMultiply.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnDivide.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));
        btnResult.addActionListener(new NumberButtonActionListener(labResult,labLog, calculator));

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("计算器");
        frame.setContentPane(new MainWindow().mainJpanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
