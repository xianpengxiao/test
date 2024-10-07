package content;

import javax.swing.JFrame;

public class RegisterJframe extends JFrame{
    public RegisterJframe(){
        this.setSize(488,500);
        //设置界面标题
        this.setTitle("注册用户");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏关闭方式
        this.setDefaultCloseOperation(3);

        this.setVisible(true);
    }
}
