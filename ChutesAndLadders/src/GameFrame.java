import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
	
	public GameFrame(){
		setTitle("Chutes and Ladders");
		setSize(300, 200);
		setLocation(10, 100);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
				
			}
		});
	}
}
