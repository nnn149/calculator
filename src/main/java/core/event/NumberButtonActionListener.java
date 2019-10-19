/**
 * FileName: NumberButtonActionListener
 * Author:   10418
 * Date:     2019-10-18 22:45
 * Description: 数字按钮鼠标事件
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package core.event;

import core.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈数字按钮鼠标事件〉
 *
 * @author 10418
 * @create 2019-10-18
 * @since 1.0.0
 */
public class NumberButtonActionListener implements ActionListener, KeyListener {
    private JLabel labResult;
    private JLabel labLog;
    private Calculator calculator;

    /**
     * 构造函数，这里接收到所需要的资源
     *
     * @param labResult  显示结果的lab
     * @param labLog     显示运算记录的lab
     * @param calculator 计算器核心类
     */
    public NumberButtonActionListener(JLabel labResult, JLabel labLog, Calculator calculator) {
        this.labResult = labResult;
        this.calculator = calculator;
        this.labLog = labLog;
    }

    /**
     * 按钮事件被触发
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        //CE按钮按下
        if (btn.getText().contains("CE")) {
            calculator.useCE();
        }
        //C按钮按下
        else if (btn.getText().contains("C")) {
            calculator.useC();
        }
        //退格按钮按下
        else if (btn.getText().contains("<")) {
            calculator.useBack();
        }
        //设置正负号
        else if (btn.getText().contains("+/-")) {
            calculator.changeSign();
        }
        //设置小数点
        else if (btn.getText().contains(".")) {
            calculator.setPoint();
        }
        //加
        else if (btn.getText().contains("+")) {
            calculator.add();
        }
        //减
        else if (btn.getText().contains("-")) {
            calculator.subtract();
        }
        //乘
        else if (btn.getText().contains("×")) {
            calculator.multiply();
        }
        //除
        else if (btn.getText().contains("÷")) {
            calculator.divide();
        }
        //等于
        else if (btn.getText().contains("=")) {
            calculator.result();
        }
        //设置数值
        else {
            calculator.inputNum(Integer.parseInt(btn.getText()));
        }
        //更新数据
        calculator.setNum();
        //显示到窗体上面
        labResult.setText(calculator.getNumStr());
        labLog.setText(calculator.getLog());
        btn.setFocusPainted(false);
    }

    /**
     * 键盘事件
     *
     * @param keyEvent
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyChar());
        //CE按钮按下
        if (keyEvent.getKeyChar() == KeyEvent.VK_DELETE) {
            calculator.useCE();
        }
        //退格按钮按下
        else if (keyEvent.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            calculator.useBack();
        }
        //设置小数点
        else if (keyEvent.getKeyChar() == '.') {
            calculator.setPoint();
        }
        //加
        else if (keyEvent.getKeyChar() == '+') {
            calculator.add();
        }
        //减
        else if (keyEvent.getKeyChar() == '-') {
            calculator.subtract();
        }
        //乘
        else if (keyEvent.getKeyChar() == '*') {
            calculator.multiply();
        }
        //除
        else if (keyEvent.getKeyChar() == '/') {
            calculator.divide();
        }
        //等于
        else if (keyEvent.getKeyChar() == KeyEvent.VK_ENTER) {
            calculator.result();
        }
        //设置数值
        else if (keyEvent.getKeyChar() >= 48 && keyEvent.getKeyChar() <= 57) {
            calculator.inputNum(keyEvent.getKeyChar() - 48);
        }
        //更新数据
        calculator.setNum();
        //显示到窗体上面
        labResult.setText(calculator.getNumStr());
        labLog.setText(calculator.getLog());
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
