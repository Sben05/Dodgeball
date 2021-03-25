//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.ArrayList;
//
//import javax.swing.JFrame;
//import javax.swing.Timer;
//
//public class MotionExample extends JFrame implements ActionListener
//
//{
//	
//	private ArrayList<Updatable> characters;
//	int i = 0;
//	public MotionExample()
//	{
//		characters = new ArrayList<Updatable>();
//		setLayout(null);
//		setBounds(100,100,800,600);
//		
//		SmileyButton button = new SmileyButton();
//		characters.add(button);
//		add(button);
//		
//		SadButton sad = new SadButton();
//		sad.setLocation(20,45);
//		add(sad);
//		characters.add(sad);
//		
//		this.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == e.VK_A)
//					((SadButton)(characters.get(1))).setDx(-1);
//				if(e.getKeyCode() == e.VK_D)
//					((SadButton)(characters.get(1))).setDx(1);
//				if(e.getKeyCode() == e.VK_S)
//					((SadButton)(characters.get(1))).setDy(1);
//				if(e.getKeyCode() == e.VK_W)
//					((SadButton)(characters.get(1))).setDy(-1);
//				
//				if(e.getKeyCode() == e.VK_LEFT)
//					((SmileyButton)(characters.get(0))).setDx(-1);
//				if(e.getKeyCode() == e.VK_RIGHT)
//					((SmileyButton)(characters.get(0))).setDx(1);
//				if(e.getKeyCode() == e.VK_DOWN)
//					((SmileyButton)(characters.get(0))).setDy(1);
//				if(e.getKeyCode() == e.VK_UP)
//					((SmileyButton)(characters.get(0))).setDy(-1);
//				
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				if(e.getKeyCode() == e.VK_A)
//					((SadButton)(characters.get(1))).setDx(0);
//				if(e.getKeyCode() == e.VK_D)
//					((SadButton)(characters.get(1))).setDx(0);
//				if(e.getKeyCode() == e.VK_S)
//					((SadButton)(characters.get(1))).setDy(0);
//				if(e.getKeyCode() == e.VK_W)
//					((SadButton)(characters.get(1))).setDy(0);
//				
//				if(e.getKeyCode() == e.VK_LEFT)
//					((SmileyButton)(characters.get(0))).setDx(0);
//				if(e.getKeyCode() == e.VK_RIGHT)
//					((SmileyButton)(characters.get(0))).setDx(0);
//				if(e.getKeyCode() == e.VK_DOWN)
//					((SmileyButton)(characters.get(0))).setDy(0);
//				if(e.getKeyCode() == e.VK_UP)
//					((SmileyButton)(characters.get(0))).setDy(0);
//				
//			}
//
//			@Override
//			public void keyTyped(KeyEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		
//		Timer t1 = new Timer(2,this);
//		t1.start();
//		
//		setVisible(true);
//		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//		
//	}
//	public static void main(String[] args) 
//	{
//		
//		new MotionExample();
//	}
//	
//	
//	public void actionPerformed(ActionEvent e)
//	{
//		for(Updatable character: characters)
//			character.update();
//		repaint();
//	}
//	
//	
//
//}
