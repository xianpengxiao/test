package content;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JDialog;
import java.util.*;

public class LoginJfram extends JFrame implements MouseListener{
    // static ArrayList<User> list= new ArrayList<>();
    // static {
    //     list.add(new User("zhangsan","123"));
    //     list.add(new User("lisi","1234"));
    // }
    // public LoginJfram(){
    //     this.setSize(488,430);
    //     //设置界面标题
    //     this.setTitle("登录");
    //     //设置界面置顶
    //     this.setAlwaysOnTop(true);
    //     //设置界面居中
    //     this.setLocationRelativeTo(null);
    //     //设置游戏关闭方式
    //     this.setDefaultCloseOperation(3);
    //     //关闭默认存放位置
    //     this.setLayout(null);
    //     initJFrame();
    //     this.setVisible(true);
    // }
    // //创建登陆界面
    // private void initJFrame(){
    //     //创建文本输入
    //     JLabel jl=new JLabel(new ImageIcon("D:\\Java\\App\\Game\\image\\login\\用户名.png"));
    //     JLabel jl2=new JLabel(new ImageIcon("image\\login\\密码.png"));
    //     JLabel jl3=new JLabel(new ImageIcon("image\\login\\验证码.png"));
    //     // jl.setText(new ImageIcon("D:\\Java\\App\\Game\\image\\login\\用户名.png"));
    //     jl.setBounds(116,135,47,17);
    //     // jl2.setText();
    //     jl2.setBounds(130,195,32,16);
    //     jl3.setBounds(115,256,50,30);
    //     JTextField jt=new JTextField();
    //     JTextField jt2=new JTextField();
    //     JTextField jt4=new JTextField();
    //     jt.setBounds(195,134,200,30);
    //     jt2.setBounds(195,195,200,30);
    //     jt4.setBounds(195,256,100,30);

    //     //创建按钮
    //     JButton jb=new JButton();
    //     // ImageIcon image=
    //     jb.setBounds(123,310,128,47);
    //     jb.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
    //     //去除按钮默认边框
    //     jb.setBorderPainted(false);
    //     //去除按钮默认背景
    //     jb.setContentAreaFilled(false);
    //     jb.addMouseListener(this);

    //     JButton register=new JButton();
    //     register.setBounds(256,310,128,47);
    //     register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
    //     //去除按钮默认边框
    //     register.setBorderPainted(false);
    //     //去除按钮默认背景
    //     register.setContentAreaFilled(false);
    //     register.addMouseListener(this);
    //     // String codeStr = CodeUtil.getCode();
    //     // JLabel rightCode = new JLabel();
    //     // //设置内容
    //     // rightCode.setText(codeStr);
    //     // //位置和宽高
    //     // rightCode.setBounds(300, 256, 50, 30);


    //     JLabel jl4= new JLabel(new ImageIcon("D:\\Java\\App\\Game\\image\\login\\background.png"));
    //     jl4.setBounds(0,0,470,390);

    //     this.getContentPane().add(jl);
    //     this.getContentPane().add(jl2);
    //     this.getContentPane().add(jt);
    //     this.getContentPane().add(jt2);

    //     this.getContentPane().add(jl3);
    //     this.getContentPane().add(jt4);
    //     this.getContentPane().add(jb);
    //     this.getContentPane().add(register);
    //     this.getContentPane().add(jl4);

    // }


     //创建一个集合存储正确的用户名和密码

     static String User[][]=new String[1][1];
     static ArrayList<String> list = new ArrayList<> ();
     static {
         list.add(new User("zhangsan","123"));
         list.add(new User("lisi","1234"));
     }
     public User(){
        String user;
        String code;
        public void User(){

        }
        public void User(String a,String b){
            this.user=a;
            this.code=b
        }
     }
     
     
     public LoginJfram() {
         //初始化界面
         initJFrame();
 
         //在这个界面中添加内容
         initView();
 
         //让当前界面显示出来
         this.setVisible(true);
     }
 
     public void initView() {
         //1. 添加用户名文字
         JLabel usernameText = new JLabel(new ImageIcon("puzzlegame\\image\\login\\用户名.png"));
         usernameText.setBounds(116, 135, 47, 17);
         this.getContentPane().add(usernameText);
 
         //2.添加用户名输入框
         JTextField username = new JTextField();
         username.setBounds(195, 134, 200, 30);
         this.getContentPane().add(username);
 
         //3.添加密码文字
         JLabel passwordText = new JLabel(new ImageIcon("puzzlegame\\image\\login\\密码.png"));
         passwordText.setBounds(130, 195, 32, 16);
         this.getContentPane().add(passwordText);
 
         //4.密码输入框
         JTextField password = new JTextField();
         password.setBounds(195, 195, 200, 30);
         this.getContentPane().add(password);
 
         //验证码提示
         JLabel codeText = new JLabel(new ImageIcon("puzzlegame\\image\\login\\验证码.png"));
         codeText.setBounds(133, 256, 50, 30);
         this.getContentPane().add(codeText);
 
         //验证码的输入框
         JTextField code = new JTextField();
         code.setBounds(195, 256, 100, 30);
         this.getContentPane().add(code);
 
         String codeStr = CodeUtil.getCode();
         JLabel rightCode = new JLabel();
         //设置内容
         rightCode.setText(codeStr);
         //位置和宽高
         rightCode.setBounds(300, 256, 50, 30);
         //添加到界面
         this.getContentPane().add(rightCode);
 
         //5.添加登录按钮
         JButton login = new JButton();
         login.setBounds(123, 310, 128, 47);
         login.setIcon(new ImageIcon("puzzlegame\\image\\login\\登录按钮.png"));
         //去除按钮的默认边框
         login.setBorderPainted(false);
         //去除按钮的默认背景
         login.setContentAreaFilled(false);
         this.getContentPane().add(login);
 
         //6.添加注册按钮
         JButton register = new JButton();
         register.setBounds(256, 310, 128, 47);
         register.setIcon(new ImageIcon("puzzlegame\\image\\login\\注册按钮.png"));
         //去除按钮的默认边框
         register.setBorderPainted(false);
         //去除按钮的默认背景
         register.setContentAreaFilled(false);
         this.getContentPane().add(register);
 
         //7.添加背景图片
         JLabel background = new JLabel(new ImageIcon("puzzlegame\\image\\login\\background.png"));
         background.setBounds(0, 0, 470, 390);
         this.getContentPane().add(background);
     }
 
 
     public void initJFrame() {
         this.setSize(488, 430);//设置宽高
         this.setTitle("拼图游戏 V1.0登录");//设置标题
         this.setDefaultCloseOperation(3);//设置关闭模式
         this.setLocationRelativeTo(null);//居中
         this.setAlwaysOnTop(true);//置顶
         this.setLayout(null);//取消内部默认布局
     }
 
     
     //要展示用户名或密码错误
     public void showJDialog(String content) {
         //创建一个弹框对象
         JDialog jDialog = new JDialog();
         //给弹框设置大小
         jDialog.setSize(200, 150);
         //让弹框置顶
         jDialog.setAlwaysOnTop(true);
         //让弹框居中
         jDialog.setLocationRelativeTo(null);
         //弹框不关闭永远无法操作下面的界面
         jDialog.setModal(true);
 
         //创建Jlabel对象管理文字并添加到弹框当中
         JLabel warning = new JLabel(content);
         warning.setBounds(0, 0, 200, 150);
         jDialog.getContentPane().add(warning);
 
         //让弹框展示出来
         jDialog.setVisible(true);
     }
 }
  @Override
  public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub
      
  }
  @Override
  public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
      
  }
  @Override
  public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub
      
  }
  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("hello");
  }
  @Override
  public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub
      
  }
}
