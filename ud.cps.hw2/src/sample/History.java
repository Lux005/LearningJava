package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class History {
	private static Stack<Msg> msgStack;//memory space shared for each History object;
	private static TextFlow tf1,tf2;//tf1 pointer to the first window's TextFlow
									//tf2 pointer to the second window's TextFlow
	private int userid;	//user id is different for each window.
	History(TextFlow tf)
	{
		if(msgStack==null)//create the stack object just once. 
			msgStack=new Stack<Msg>();
		if(tf1==null)//if tf1 is null/this is the first window's object.
		{			
			tf1=tf;//set tf1 pointer to the first window's TextFlow
			userid=1;
		}
		else//else it's the second window's object
		{
			tf2=tf;//set tf2 pointer to the second window's TextFlow
			userid=2;
		}

	}
	public void push(Text message)//store a new message into the history
	{
		Msg t= new Msg(userid,message);
		msgStack.push(t);
	}
	public void updateTextFlow()//update each TextFlow in both windows.
	{
		if(!msgStack.empty())
		{
			//add new message into the first window's TextFlow
			tf1.getChildren().addAll(msgStack.peek().getMsgInfo(),
						msgStack.peek().getMsgContent());
			//add new message into the second window's TextFlow
			tf2.getChildren().addAll(msgStack.peek().getMsgInfo(),
					msgStack.peek().getMsgContent());
		}
	}
	public int getUserid() {
		return userid;
	}
}

class Msg
{
	private String time;
	private int id;
	private Text content;
	
	Msg(int _id,Text _content){
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//date format
		String time_now  = df.format(new Date());//date object to string object
		time=time_now;
		id=_id;
		content=_content;
	}
	
	//return the time and user name
	Text getMsgInfo()
	{
		String name;
		if(id==1)
			name="Jack";
		else
			name="Rose";
		Text r=new Text(time+"\n"+name+":\n");
		return r; 
	}
	
	//return the message content
	Text getMsgContent()
	{
		//copy the Text
		Text r=new Text("  "+content.getText()+"\n");
		//copy the style
		r.setStyle(content.getStyle());
		return r;
	}
}


