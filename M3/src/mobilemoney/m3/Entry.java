package mobilemoney.m3;

public class Entry {

	//private variables
	int _id;
	String _Item;
	double _Price;
	String _PayMethod;
	String _TransDate;
	String _monthYear;
	String _note;
	
	//Empty constructor
	public Entry(){
		
	}
	//constructor
	public Entry(int _id, String Item, double _Price, String _PayMethod, String _TransDate, String _monthYear, String _note){
		this._id = _id;
		this._Item = _Item;
		this._PayMethod = _PayMethod;
		this._Price = _Price;
		this._monthYear = _monthYear;
		this._TransDate = _TransDate;
		this._note = _note;
	}
	//constructor
	public Entry(String Item, double _Price, String _PayMethod, String _TransDate, String _monthYear, String _note){
		this._Item = Item;
		this._PayMethod = _PayMethod;
		this._Price = _Price;
		this._monthYear = _monthYear;
		this._TransDate = _TransDate;
		this._note = _note;
	}
	//getting ID
	public int getID(){
		return this._id;
	}
	//setting ID
	public void setID(int id){
		this._id = id;
	}
	//getting Item
	public String getItem(){
		return this._Item;
	}
	//setting Item
	public void  setItem(String Item){
		this._Item= Item;
	}
	//getting _PayMethod
		public String getPayMethod(){
			return this._PayMethod;
		}
		//setting paymethod
		public void  setPayMethod(String PayMethod){
			this._PayMethod= PayMethod;
		}
		//getting Price
				public double getPrice(){
					return this._Price;
				}
				//setting Price
				public void  setPrice(double Price){
					this._Price= Price;
				}
				//getting monthYear
				public String getmonthYear(){
					return this._monthYear;
				}
				//setting monthYear
				public void  setmonthYear(String monthYear){
					this._monthYear= monthYear;
				}
				//getting TransDate
				public String getTransDate(){
					return this._TransDate;
				}
				//setting TransDate
				public void  setTransDate(String TransDate){
					this._TransDate= TransDate;
				}
				//getting note
				public String getnote(){
					return this._note;
				}
				//setting note
				public void  setnote(String note){
					this._note= note;
				}
	
	
	
	
	
	
	
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
