package content;

import java.util.Random;

import javax.swing.border.BevelBorder;

import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GameJfram1 extends JFrame implements KeyListener,ActionListener{
    int data[][]=new int[4][4];
    int win[][]={{1,2,3,4}
                ,{5,6,7,8}
                ,{9,10,11,12}
                ,{13,14,15,0}};
    //记录0图片所在位置
    int x,y;
    //记录上次图片位置
    int re=-1;
    //记录图片地址
    String add="animal\\animal3\\";
    //记录步数
    JMenuItem replayItem =new JMenuItem("重新游戏");
    JMenuItem reLoginItem=new JMenuItem("重新登陆");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accourtItem = new JMenuItem("公众号");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    int count=0;

    public GameJfram1(){
        initJFrame();
        //初始化菜单
        initJFramebar();
        //打乱顺序
        breakOrder();
        //初始化图片
        initImage();
        //显示界面
        this.setVisible(true);
    }
    private void breakOrder(){
        //打乱顺序
        Random r=new Random();
        int[] temp={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        for (int i=0;i<temp.length;i++) {
            int k=r.nextInt(temp.length);
            int record=temp[i];
            temp[i]=temp[k];
            temp[k]=record;
        }
        for (int i=0 ; i<temp.length;i++) {
            if(temp[i]==0){
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=temp[i];
        }
    }
    private void initImage() {
         //先删除已经出现的图片以便于移动图片
        this.getContentPane().removeAll();
        if (victor()) {
            JLabel win=new JLabel(new ImageIcon("D:\\Java\\App\\Game\\image\\win.png"));
            win.setBounds(203,284,197,63);
            this.getContentPane().add(win);
        }
        JLabel stepJLabel=new JLabel("步数:"+count);
        stepJLabel.setBounds(50,30,100,20);
        this.getContentPane().add(stepJLabel);
        //先加载的图片在上方
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                //创建一个图片的对象
            // ImageIcon icon=new ImageIcon();
            //创建一个jLabel的对象（管理容器）
            int newNumber=data[i][j];
            JLabel jLabel=new JLabel(new ImageIcon("image\\"+add+""+newNumber+".jpg"));
            //指定图片位置（需要在初始化菜单时取消默认放置位置）
            jLabel.setBounds(105*j+83,105*i+135,105,105);
            jLabel.setBorder(new BevelBorder(0));
            //将容器放入界面中（默认放在中心）
            this.getContentPane().add(jLabel);
            }

        }
        //加载背景图片
        JLabel jLabel2=new JLabel(new ImageIcon("image\\background.png"));
        jLabel2.setBounds(40,40,508,560);
        this.getContentPane().add(jLabel2);
        //刷新界面
        this.getContentPane().repaint();
    }
    private boolean victor(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if (data[i][j]!=win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private void initJFrame(){
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("来拼图 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏关闭方式
        this.setDefaultCloseOperation(3);
        //取消默认放置位置
        this.setLayout(null);
        // JButton jbt1=new JButton();
        //给整个界面添加键盘监听
        this.addKeyListener(this);
    }
    private void initJFramebar(){
        //创建整个菜单对象
        JMenuBar jMenuBar=new JMenuBar();
        //两个选项的对象
        JMenu changeItem = new JMenu("切换图片");
        //只有JMenu中可以存放条目对象
        JMenu functionJMneu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");
        //条目对象
        changeItem.add(girl);
        changeItem.add(animal);
        changeItem.add(sport);

        functionJMneu.add(replayItem);
        functionJMneu.add(reLoginItem);
        functionJMneu.add(closeItem);
        functionJMneu.add(changeItem);
        aboutJMenu.add(accourtItem);

        jMenuBar.add(functionJMneu);
        jMenuBar.add(aboutJMenu);



        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accourtItem.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);

        this.setJMenuBar(jMenuBar);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if (victor()) {
            return;
        }
        if (code==65) {
            this.getContentPane().removeAll();
            JLabel jLabel=new JLabel(new ImageIcon("image\\"+add+"all.jpg"));
            //指定图片位置（需要在初始化菜单时取消默认放置位置）
            jLabel.setBounds(83,134,420,420);
            jLabel.setBorder(new BevelBorder(0));
            //将容器放入界面中（默认放在中心）
            this.getContentPane().add(jLabel);
            //加载背景图片
            JLabel jLabel2=new JLabel(new ImageIcon("image\\background.png"));
            jLabel2.setBounds(40,40,508,560);
            this.getContentPane().add(jLabel2);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victor()) {
            return;
        }
        //上；38 下；40 左；37 右；39
        int code=e.getKeyCode();
        // System.out.println(code);
        if (code==37) {
            if(y==0){
                return;
            }
            System.out.println("向左移动");
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            count++;
            initImage();
    
        }else if (code==38) {
            if (x==0) {
                return;
            }
            System.out.println("向上移动");
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            count++;
            initImage();

        }else if (code==39) {
            if (y==3) {
                return;
            }
            System.out.println("向右移动");
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            count++;
            initImage();
        }else if (code==40) {
            if (x==3) {
                return;
            }
            System.out.println("向下移动");
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            count++;
            initImage();
        }else if (code==65) {
            initImage();
        }else if (code==87) {
            data=win;
            initImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if (obj==replayItem) {
            System.out.println("重新游戏");
            count=0;
            breakOrder();
            initImage();
        }else if (obj==reLoginItem) {
            System.out.println("重新登陆");
            this.setVisible(false);
            new LoginJfram();
        }else if (obj==closeItem) {
            System.out.println("关闭游戏");
            //直接关闭虚拟机
            System.exit(0);
        }else if (obj==accourtItem) {
            System.out.println("打开公众号");
            JDialog jd=new JDialog();
            JLabel accourt= new JLabel(new ImageIcon("image\\about.png"));
            accourt.setBounds(0,0,258,258);
            jd.getContentPane().add(accourt);
            //设置弹窗大小
            jd.setSize(344,344);
            //弹窗置顶
            jd.setAlwaysOnTop(true);
            //弹窗居中
            jd.setLocationRelativeTo(null);
            //不关闭弹窗无法接下来操作
            jd.setModal(true);
            //弹窗显示
            jd.setVisible(true);
        }else if (obj==girl) {
            System.out.println("切换美女图片");
            int temp[]={1,2,3,4,5,6,7,8,9,10,11,12,13};
            Random r=new Random();
            int a=r.nextInt(temp.length);
            while (a==re) {
                a=r.nextInt(temp.length);
            }
            re=a;
            add="girl\\girl"+a+"\\";
            initImage();
        }else if (obj==animal) {
            System.out.println("切换动物图片");
            int temp[]={1,2,3,4,5,6,7,8};
            Random r=new Random();
            int a=r.nextInt(temp.length);
            while (a==re) {
                a=r.nextInt(temp.length);
            }
            re=a;
            add="animal\\animal"+a+"\\";
            initImage();
            
        }else if (obj==sport) {
            System.out.println("切换运动图片");
            int temp[]={1,2,3,4,5,6,7,8,9,10};
            Random r=new Random();
            int a=r.nextInt(temp.length);
            while (a==re) {
                a=r.nextInt(temp.length);
            }
            re=a;
            add="sport\\sport"+a+"\\";
            initImage();
        }
    }
}
