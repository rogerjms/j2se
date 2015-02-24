import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
public class Jishiben extends JFrame
{
static JTextArea ta;
static JFrame app;
static JLabel jl;
static JLabel jl2;
//各菜单的监听均采用内部类实现， 子菜单的监听采用内部类的内部类
class xianjian implements ActionListener
//新建文件监听
{
   public void actionPerformed(ActionEvent e)
   {
    ta.setText("");//将ta 的Text设置为空字符串，实现新建
   }
}
class dakai implements ActionListener
//打开文件监听
{
   public void actionPerformed(ActionEvent e)
    {
     JFileChooser jf=new JFileChooser();
     javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("*.txt", "txt");
     jf.addChoosableFileFilter(filter);//文件过滤默认仅显示TXT文件，选择所有文件才全显示
     jf.showOpenDialog(Jishiben.this);//显示打开文件对话框
     String fileName=jf.getSelectedFile().getAbsolutePath().trim();//获取文件路径及文件名
     try{
      BufferedReader br=new BufferedReader(new FileReader(fileName));
      String S;
      for(S=br.readLine();S!=null;S=br.readLine())//按行读取文件
      ta.append(S+"\n");//写入ta，并执行换行
      br.close();
     }
     catch(IOException a)
     {
      System.out.println("Open file error!");
      a.printStackTrace();
     }
    
    }
}
//保存文件监听
class baocun implements ActionListener
//注：保存文件后，用Windows自带的记事本打开发现是只有一行，这是因为文件是此记事本创建的。如果用此记事本打开显示就正常了
{
   public void actionPerformed(ActionEvent e)
   {
    JFileChooser jf = new JFileChooser();
    javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("*.txt", "txt");
    jf.addChoosableFileFilter(filter);//文件过滤默认保存为TXT文件，选择所有文件时需加后缀   
    jf.showSaveDialog(Jishiben.this);//显示保存文件对话框
    String fileName=jf.getSelectedFile().getAbsolutePath().trim();//获取保存文件的路径及输入的文件名
    if(fileName!=null)
    try{
     BufferedWriter bw=new BufferedWriter(new FileWriter(fileName+".txt"));//自动加上.txt的后缀
     PrintWriter pw=new PrintWriter(bw);
     pw.println(ta.getText());//写入文件
     bw.close();
    }
    catch (IOException a)
    {
     System.out.println("Save file error!");
     a.printStackTrace();
    }

   }
}
//退出程序监听
class tuichu implements ActionListener
{ 
   public void actionPerformed(ActionEvent e)
   {
    System.exit(0);//退出程序
   }
}
//剪切的监听
class jianqie implements ActionListener 
{
   public void actionPerformed(ActionEvent e)
   {
    ta.cut();//剪切
   }
}
//复制的监听
class fuzhi implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   { 
    ta.copy();//复制 
   }
}
//粘贴的监听
class zhantie implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    ta.paste();//粘贴
   }
}
//全选的监听
class quanxuan implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    ta.selectAll();//选择全部
   }
}
//删除的监听
class shanchu implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    ta.replaceRange("",ta.getSelectionStart(),ta.getSelectionEnd());//用空字符串替换选择部分，实现删除功能
   }
}
//字体的监听
class ziti implements ActionListener
{
   JComboBox cb1;
   JComboBox cb2;
   JComboBox cb3;
   Font[] fa={new Font("宋体",java.awt.Font.BOLD, 16),new Font("楷体",java.awt.Font.ITALIC, 16),new Font("Arial",java.awt.Font.PLAIN, 16)};
   Font[] fb={new Font("宋体",java.awt.Font.BOLD, 16),new Font("宋体",java.awt.Font.ITALIC, 16),new Font("宋体",java.awt.Font.PLAIN, 16)};
   Font[] ft={new Font("宋体",java.awt.Font.PLAIN, 16),new Font("宋体",java.awt.Font.PLAIN, 25),new Font("宋体",java.awt.Font.PLAIN, 10)};
   class xuanziti implements ItemListener//内部类，用来监听字体
   {
    public void itemStateChanged(ItemEvent a)
    {
     if(cb1.getSelectedIndex()==1) //根据组合框选择的项，设置字体
     ta.setFont(fa[1]);
     else if(cb1.getSelectedIndex()==2)
     ta.setFont(fa[2]);
     else
     ta.setFont(fa[0]);; 
    }
   }
   class xuanzixing implements ItemListener//内部类，用来监听自行
   {
    public void itemStateChanged(ItemEvent a)
    {
     if(cb2.getSelectedIndex()==1)//根据组合框选择的项，设置字体
     ta.setFont(fb[1]);
     else if(cb2.getSelectedIndex()==2)
     ta.setFont(fb[2]);
     else
     ta.setFont(fb[0]);;
    }
   }
   class xuandaxiao implements ItemListener//内部类，用来监听字体大小
   {
    public void itemStateChanged(ItemEvent a)
    {
     if(cb3.getSelectedIndex()==1)//根据组合框选择的项，设置字体
     ta.setFont(ft[0]);
     else if(cb3.getSelectedIndex()==2)
     ta.setFont(ft[2]);
     else
     ta.setFont(ft[1]);
    }
   } 
   public void actionPerformed(ActionEvent e)
   {
   
   
    JDialog jd=new JDialog(app,"设置字体",false);//创建对话框
    Container c=jd.getContentPane();
    String [] ziti={"宋体 ","楷体 ","Arial "};
    String [] zixing={"粗体 ","斜体 ", "正常 "};
    String [] daxiao={"大    ","中    ","小    "};
    cb1=new JComboBox(ziti);//创建三个组合框
    cb2=new JComboBox(zixing);
    cb3=new JComboBox(daxiao);
    c.setLayout(new FlowLayout());
    c.add(cb1);//在对话框中添加三个组合框分别用来控制字体，自行，大小
    cb1.addItemListener(new xuanziti());//注册监听器
    c.add(cb2);
    cb2.addItemListener(new xuanzixing());
    c.add(cb3);
    cb3.addItemListener(new xuandaxiao());
    jd.setSize(300,100);
    jd.setVisible(true);

   }
}
//状态栏的监听
class zhuangtailan implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    jl2.setText("总共：Ln "+ta.getLineCount());//最下面的面板中显示总的行数
   }
}
//帮助的监听
class bangzhu implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    JDialog jd=new JDialog(app,"帮助主题",false);//创建对话框，以对话框显示信息
    Container C=jd.getContentPane();
    jd.add(new JLabel("使用方法基本同Windows记事本，正在努力完善中。。。"));
    jd.setSize(400,200);
    jd.setVisible(true);
   }
}
//关于记事本的监听
class guanyujishiben implements ActionListener
{
   JLabel jl=new JLabel("版权所有，初学者可以随意增加代码，改变其功能");
   int i=0;
   class xiayitiao implements ActionListener//按钮下一条的监听
   {
    public void actionPerformed(ActionEvent e)
    {
    
     String[] S={"此程序完全模仿Windows操作系统自带的记事本"};
     if(i<S.length)
     i++;    
     jl.setText((S[i]));//设置标签的内容

    }
   }
   class shangyitiao implements ActionListener//按钮上一条的监听
   {
    public void actionPerformed(ActionEvent e)
    {
    
     String[] S={"此程序完全模仿Windows操作系统自带的记事本"};
     if(i>0)
     i--;    
     jl.setText((S[i]));//设置标签的内容

    }
   }
   public void actionPerformed(ActionEvent e)
   {
    JDialog jd=new JDialog(app,"欢迎使用！",false);//建立对话框
    Container c=jd.getContentPane();
    JPanel jp=new JPanel();//创建面板，加入到对话框中，便于布局管理
    JButton jbs=new JButton("上一条");//创建两个按钮，下一条和上一条
    JButton jbx=new JButton("下一条");
    jbs.addActionListener(new xiayitiao());//按钮注册监听器
    jbx.addActionListener(new shangyitiao());
    jp.add(jbs);//将按钮添加到面板中
    jp.add(jbx);
    c.setLayout(new BorderLayout());
    c.add(jl,BorderLayout.CENTER);//对话框中添加标签，显示信息
    c.add(jp,BorderLayout.SOUTH);//将面板添加到对话框
    jd.setSize(400,200);
    jd.setVisible(true);
   }
} 
public Jishiben()
{
   super("记事本");
   //创建菜单栏，并加入各下拉式菜单及菜单项
   JMenuBar mBar=new JMenuBar();
   JMenu[] mA={new JMenu("文件(F)"),new JMenu("编辑(E)"),new JMenu("格式(O)"),new JMenu("查看(V)"),new JMenu("帮助(H)")};
   char[][] mC={{'F','E','O','V','H'},{'N','O','S','X'},{'U','T','C','P','L','A'},{'F'},{'S'},{'H','A'}};
   char[][] mD={{'N','O','S'},{'Z','X','C','V','A'}};
   JMenuItem[][] mI={{new JMenuItem("新建（N)"),new JMenuItem("打开(O)"),
        new JMenuItem("保存(S)"),new JMenuItem("退出(X)")},
       {new JMenuItem("剪切(T)"),new JMenuItem("复制(C)"),
        new JMenuItem("粘贴(P)"),new JMenuItem("全选(A)"),new JMenuItem("删除(L)")},
       {new JMenuItem("字体(F)")},{new JMenuItem("状态栏(S)")},
                                   {new JMenuItem("帮助(H)"),new JMenuItem("关于记事本(A)")}};
   setJMenuBar(mBar);
   int i,j;
   for(i=0;i<mA.length;i++)
   {
    mBar.add(mA[i]);//添加下拉式菜单
    mA[i].setMnemonic(mC[0][i]);
    for(j=0;j<mI[i].length;j++)
     {
      mA[i].add(mI[i][j]);//添加菜单项
      mI[i][j].setMnemonic(mC[i+1][j]);//设置助记符     
     }
   }
   //各个菜单项注册监听器
   mI[0][0].addActionListener(new xianjian());
   mI[0][1].addActionListener(new dakai());
   mI[0][2].addActionListener(new baocun());
   mI[0][3].addActionListener(new tuichu());
   mI[1][0].addActionListener(new jianqie());
   mI[1][1].addActionListener(new fuzhi());
   mI[1][2].addActionListener(new zhantie());
   mI[1][3].addActionListener(new quanxuan());
   mI[1][4].addActionListener(new shanchu());
   mI[2][0].addActionListener(new ziti());
   mI[3][0].addActionListener(new zhuangtailan());
   mI[4][0].addActionListener(new bangzhu());
   mI[4][1].addActionListener(new guanyujishiben());
}//构造函数Jishiben中添加了菜单栏及注册了菜单的监听器
public static void main(String args[])//程序入口，主函数
{
   app=new Jishiben();//新建带菜单栏的框架
   app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   app.setSize(800,600);
   Container c=app.getContentPane();//获得内容窗格
   c.setLayout(new BorderLayout());//设置布局管理为边界布局
   ta=new JTextArea();//新建文本区域
   JScrollPane sta=new JScrollPane(ta);
   jl2=new JLabel("总共：Ln 0",JLabel.RIGHT);//新建标签
   jl2.setSize(800,20);
         c.add(sta,BorderLayout.CENTER);//在BorderLayout.CENTER中添加文本区域作为主编辑区 
   c.add(jl2,BorderLayout.SOUTH);//在BorderLayout.SOUTH中添加标签用来查看状态
   app.setVisible(true);
}
}//类Jishiben结束
