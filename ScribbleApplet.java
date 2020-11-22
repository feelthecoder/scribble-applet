package assignment;
import java.awt.*;
import java.applet.*;

public class ScribbleApplet extends Applet {
private int last_x,last_y;
private Color current_color=Color.black;
private Button clear_button;
private Choice color_choice;

public void init() {
	this.setBackground(Color.white);
	clear_button= new Button("Clear");
	clear_button.setForeground(Color.black);
	clear_button.setBackground(Color.lightGray);
	this.add(clear_button);
	
	color_choice=new Choice();
	color_choice.addItem("black");
	color_choice.addItem("red");
	color_choice.addItem("yellow");
	color_choice.addItem("green");
	color_choice.setForeground(Color.black);
	color_choice.setBackground(Color.lightGray);
	this.add(new Label("Color : "));
	this.add(color_choice);
}
public boolean mouseDown(Event e,int x, int y) {
	last_x=x;
	last_y=y;
	return true;
}
public boolean mouseDrag(Event e,int x, int y) {
	Graphics g=this.getGraphics();
	g.setColor(current_color);
	g.drawLine(last_x,last_y,x,y);
	last_x=x;
	last_y=y;
	return true;
	}

public boolean action(Event e,Object arg) {
	if(e.target==clear_button) {
		Graphics g=this.getGraphics();
		Rectangle r=this.bounds();
		g.setColor(this.getBackground());
		g.fillRect(r.x, r.y, r.width, r.height);
		return true;
		}
	else if(e.target==color_choice) {
		if(arg.equals("black"))
			current_color=Color.black;
		else if(arg.equals("red"))
			current_color=Color.red;
		else if(arg.equals("yellow"))
			current_color=Color.yellow;
		else if(arg.equals("green"))
			current_color=Color.green;
		return true;
	}
	else return super.action(e, arg);
	}
}

