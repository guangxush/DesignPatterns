package factory.example;

import javax.swing.*;
import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ShowDepositSlip extends JPanel{
    DepositSlip depositSlip;
    Seal seal;
    boolean boo;
    JLabel label;
    Image image;
    JFrame frame;
    ShowDepositSlip(){
        setLayout(null);
        setSize(200,200);
        label=new JLabel();
        add(label);
        frame=new JFrame();
        frame.add(this);
    }
    public void showDepositSlip(Bank bank,String number,String name,int money){
        depositSlip=bank.createDepositSlip(number,name,money);
        seal=bank.createSeal();
        image=seal.getImage();
        label.setIcon(new ImageIcon(image));
        boo=true;
        frame.setSize(200,280);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void setLocation(int a,int b){
        frame.setLocation(a,b);
    }
    @Override
    public void paintComponent(Graphics g){
        if(boo){
            g.drawString(depositSlip.getBankName()+"存款凭证",10,20);
            g.drawString("帐号:"+depositSlip.getClientNumber(),20,50);
            g.drawString("姓名:"+depositSlip.getClientName(),20,80);
            g.drawString("金额:"+depositSlip.getAmountOfMoney(),20,110);
            label.setBounds(60,110,image.getWidth(this),image.getHeight(this));
        }
    }
}