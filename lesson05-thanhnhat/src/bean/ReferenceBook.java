package bean;

public class ReferenceBook extends Book{
private double tax;

public ReferenceBook(String id, double price, String publisher, double tax) {
	super(id, price, publisher);
	this.tax = tax;
}
public ReferenceBook() {
}

public double getTax() {
	return tax;
}

public void setTax(double tax) {
	this.tax = tax;
}
@Override
	public String toString() {
		
		return super.toString() + ","+ tax;
	}

}
