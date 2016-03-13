package test;



public class Button {



	private Position pos;

	private Size size;


	public Position getPos() {

		return pos;

	}

	public void setPos(Position pos) {

		this.pos = pos;

	}

	public Size getSize() {

		return size;

	}

	public void setSize(Size size) {

		this.size = size;

	}


	public void disp()

	{

		System.out.println("The button has size ( " + size.getWidth() + ", " + size.getHeight() + 

				"), at position (" + pos.getX() + ", " + pos.getY() + ")." );

	}

}