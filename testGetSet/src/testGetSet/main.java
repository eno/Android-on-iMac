package testGetSet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class main 
{
	/**
	 * 
	 */
	public static void main() {
		
		FileWriter fw = mew FileWriter("thi.java");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter outfile = new PrintWriter(fw);
	}
	int i;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		main other = (main) obj;
		if (i != other.i)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "main [i=" + i + ", getI()=" + getI() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public main(int o){
		i = o;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
