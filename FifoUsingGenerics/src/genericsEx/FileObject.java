package genericsEx;

public class FileObject<T> {
	T fo;
	@Override
	public String toString() {
		return "Value: "+fo;
	}
	public T getFo() {
		return fo;
	}
	public void setFo(T fo) {
		this.fo = fo;
	}
	public FileObject(T inp){
		fo = inp;
	}
	

}
