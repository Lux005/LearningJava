package sample;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.text.Text;

public class Msg implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time;
	private String name;
	private String content;
	private String style;

	public Msg(String _name,String _content,String _style){

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//date format
		String time_now  = df.format(new Date());//date object to string object
		time=time_now;
		name=_name;
		content=_content;
		style=_style;
	}

	//return the time and user name
	public Text getMsgInfo()
	{
		Text r=new Text(time+"\n"+name+":\n");
		return r; 
	}

	//return the message content
	public Text getMsgContent()
	{
		//copy the Text
		Text r=new Text("  "+content);
		//copy the style
		r.setStyle(style);
		return r;
	}
}
