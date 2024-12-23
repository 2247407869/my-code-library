import java.awt.BorderLayout;
import java.awt.Color;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class TestColorChooser implements ChangeListener {
	private JFrame frame;
	private JLabel rLabel;
	private JLabel gLabel;
	private JLabel bLabel;
	private JSlider rSlider;
	private JSlider gSlider;
	private JSlider bSlider;
	private JTextField r10Field;
	private JTextField g10Field;
	private JTextField b10Field;
	private JTextField r16Field;
	private JTextField g16Field;
	private JTextField b16Field;
	private JTextArea area;
	
	public TestColorChooser() {
		frame=new JFrame("颜色选择器");
		rLabel=new JLabel("R:");
		gLabel=new JLabel("G:");
		bLabel=new JLabel("B:");
		//设置最大最小，默认值
		rSlider=new JSlider(0, 255, 127);
		gSlider=new JSlider(0, 255, 0);
		bSlider=new JSlider(0, 255, 0);
		r10Field=new JTextField(" "+127+" ");
		g10Field=new JTextField(" "+127+" ");
		b10Field=new JTextField(" "+127+" ");
		//Integer.toHexString  把10进制转换成16进制
		r16Field=new JTextField(" "+Integer.toHexString(127)+" ");
		g16Field=new JTextField(" "+Integer.toHexString(127)+" ");
		b16Field=new JTextField(" "+Integer.toHexString(127)+" ");
		area=new JTextArea(5,10);
	}
	
	private void init(){
		JPanel centerPanel=new JPanel();
		centerPanel.add(rLabel);
		centerPanel.add(rSlider);
		centerPanel.add(r10Field);
		centerPanel.add(r16Field);
		
		centerPanel.add(gLabel);
		centerPanel.add(gSlider);
		centerPanel.add(g10Field);
		centerPanel.add(g16Field);
		
		centerPanel.add(bLabel);
		centerPanel.add(bSlider);
		centerPanel.add(b10Field);
		centerPanel.add(b16Field);
		
		JPanel eastPanel=new JPanel();
		eastPanel.add(area);
		
		frame.add(centerPanel);
		frame.add(eastPanel,BorderLayout.EAST);
	}
	
	private void setStyle(){
		area.setBackground(new Color(127, 127, 127));
		r10Field.setEnabled(false);
		g10Field.setEnabled(false);
		b10Field.setEnabled(false);
		r16Field.setEnabled(false);
		g16Field.setEnabled(false);
		b16Field.setEnabled(false);
		area.setEditable(false);
	}
	//添加监听
	private void addEventHandler(){
		rSlider.addChangeListener(this);
		gSlider.addChangeListener(this);
		bSlider.addChangeListener(this);
	}
 
	@Override
	public void stateChanged(ChangeEvent e) {
		int r=rSlider.getValue();
		int g=gSlider.getValue();
		int b=bSlider.getValue();
		
		r10Field.setText(" "+r+" ");
		g10Field.setText(" "+g+" ");
		b10Field.setText(" "+b+" ");
		
		r16Field.setText(" "+Integer.toHexString(r)+" ");
		g16Field.setText(" "+Integer.toHexString(g)+" ");
		b16Field.setText(" "+Integer.toHexString(b)+" ");
		
		area.setBackground(new Color(r, g, b));
		
	}
	
	public void show(){
		init();
		setStyle();
		addEventHandler();
		frame.setSize(420, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new TestColorChooser().show();
		
//		String s="f";
//		int n=Integer.parseInt(s, 16);
//		System.out.println(n);
		
//		int n=14;
//		String s=Integer.toHexString(n);
//		System.out.println(s);
				
				
				
	}
	
	
}