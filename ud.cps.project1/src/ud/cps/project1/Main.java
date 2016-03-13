package ud.cps.project1;

public class Main {
	public static void main(String[] args)
	{
		double[][] a={
				{1.1,1.2,1.3,1.4},
				{2.1,2.2,2.3,2.4},
				{3.1,3.2,3.3,3.4},
		};
		int c=9;
		mat ma=new mat();
		mat mb=new mat();
		ma.setData(a);
		ma.setCols(c);
		mb.setData(a);
		mb.setCols(c);
		c=10;
		a[0][0]=100.1;
		ma.getData()[0][0]+=100;
		System.out.println(ma.getData()[0][0]+"  "+ma.getCols());
		System.out.println(mb.getData()[0][0]+"  "+mb.getCols());	
	}
}
class mat
{
	private int cols,rows;
	private double[][] data;
	
	
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public double[][] getData() {
		return data;
	}
	public void setData(double[][] data) {
		this.data = data;
	}
	
}
