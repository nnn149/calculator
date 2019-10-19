/**
 * FileName: Calculator
 * Author:   10418
 * Date:     2019-10-18 22:30
 * Description: 计算核心类
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package core;

import core.bean.Operation;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈计算核心类〉
 *
 * @author 10418
 * @create 2019-10-18
 * @since 1.0.0
 */
public class Calculator {
    private Double firstNum;
    private Double secondNum;
    private Double value;
    private Operation operation = Operation.NONE;
    private String log = " ";
    private String numStr = "0";
    private boolean cover = false;

    public Calculator() {
    }

    /**
     * 向计算器输入一个数字
     *
     * @param num
     */
    public void inputNum(int num) {
        //是否覆盖输入
        if (cover) {
            numStr = "0";
            cover = false;
        }
        if (numStr.charAt(0) == '0' && !numStr.contains(".")) {
            numStr = "";
        }
        numStr = numStr + num;
        if (numStr.contains(".")) {
            return;
        }
        //当前是否是负数
        boolean isNegativeNum = false;
        if (numStr.contains("-")) {
            isNegativeNum = true;
            numStr = numStr.replace("-", "");
        }
        if (numStr.length() < 4) {
            if (isNegativeNum) {
                numStr = "-" + numStr;
            } else {
                return;
            }

        }
        //为长数字添加逗号
        StringBuilder sb = new StringBuilder(numStr);
        if (!numStr.substring(numStr.length() - 4, numStr.length() - 1).contains(",")) {
            sb.insert(numStr.length() - 1, ",");
        }
        if (isNegativeNum) {
            sb.insert(0, "-");
        }
        numStr = sb.toString();
    }

    //得到结果
    public void result() {
        log = " ";
        cover = true;
        if (operation != Operation.NONE) {
            Double amount = amount();
            numStr = String.valueOf(amount);
            firstNum = amount;
            operation = Operation.NONE;
            secondNum = null;
        }
    }

    public void add() {
        log = log + getNum() + "+";
        cover = true;
        if (operation != Operation.NONE) {
            Double amount = amount();
            numStr = String.valueOf(amount);
            firstNum = amount;
        }
        this.operation = Operation.ADD;
    }

    public void subtract() {
        log = log + getNum() + "-";
        cover = true;
        if (operation != Operation.NONE) {
            Double amount = amount();
            numStr = String.valueOf(amount);
            firstNum = amount;
        }
        this.operation = Operation.SUBTRACT;

    }


    public void multiply() {
        log = log + getNum() + "×";
        cover = true;
        if (operation != Operation.NONE) {
            Double amount = amount();
            numStr = String.valueOf(amount);
            firstNum = amount;
        }
        this.operation = Operation.MULTIPLY;

    }

    public void divide() {
        log = log + getNum() + "÷";
        cover = true;
        if (operation != Operation.NONE) {
            Double amount = amount();
            numStr = String.valueOf(amount);
            firstNum = amount;
        }
        this.operation = Operation.DIVIDE;

    }

    //计算值
    private Double amount() {
        if (operation == Operation.ADD) {
            return firstNum + secondNum;
        } else if (operation == operation.SUBTRACT) {
            return firstNum - secondNum;
        } else if (operation == Operation.MULTIPLY) {
            return firstNum * secondNum;
        } else if (operation == Operation.DIVIDE) {
            return firstNum / secondNum;
        }
        return null;
    }


    public void useCE() {
        if (this.operation == Operation.NONE) {
            this.firstNum = null;
        } else {
            this.secondNum = null;
        }
        numStr = "0";
    }

    public void useC() {
        this.operation = Operation.NONE;
        this.firstNum = null;
        this.secondNum = null;
        numStr = "0";
        log = " ";

    }

    public void useBack() {
        boolean isNegativeNum = false;
        if (numStr.contains("-")) {
            isNegativeNum = true;
            numStr = numStr.replace("-", "");
        }
        if (numStr.length() > 1) {
            numStr = numStr.substring(0, numStr.length() - 1);
            if (numStr.charAt(numStr.length() - 1) == ',') {
                numStr = numStr.substring(0, numStr.length() - 1);
            }
            if (isNegativeNum) {
                numStr = "-" + numStr;
            }
        } else if (numStr.length() == 1) {
            numStr = "0";
        }
    }
    //改变正负号
    public void changeSign() {
        if (numStr.charAt(0) != '0' || numStr.contains(".")) {
            if (numStr.contains("-")) {
                numStr = numStr.replace("-", "");
            } else {
                numStr = "-" + numStr;
            }
        }
    }
    //设置小数点
    public void setPoint() {
        if (!numStr.contains(".")) {
            numStr = numStr + ".";
        }
    }

    public void setNum() {
        if (this.operation == Operation.NONE) {
            this.firstNum = getNum();
        } else {
            this.secondNum = getNum();
        }
    }

    private double getNum() {
        String num = numStr;
        if (numStr.charAt(numStr.length() - 1) == '.') {
            num = numStr.replace(".", "");
        }
        num = num.replace(",", "");
        return Double.parseDouble(num);
    }

    public Double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(Double firstNum) {
        this.firstNum = firstNum;
    }

    public Double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(Double secondNum) {
        this.secondNum = secondNum;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getNumStr() {
        return numStr;
    }

    public void setNumStr(String numStr) {
        this.numStr = numStr;
    }
}
