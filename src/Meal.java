import java.util.Scanner;

public class Meal {
	private String name;
	private int qte;
	private int priceUnit;
	private Scanner sc = new Scanner(System.in);

	public int getSum() {
		return qte * priceUnit;
	}

	public String getName() {
		return name;
	}

	public void setName() {
		System.out.println("Quel est votre plat?");
		this.name = sc.next();
	}

	public void setPredefinedName(String predefinedName) {
		this.name = predefinedName; 
	}
	
	public int getQte() {
		return qte;
	}

	public void setQte() {
		System.out.println("Quelle quantité?");
		this.qte = Integer.parseInt(sc.next());
	}

	public int getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit() {
		System.out.println("Quelle est le prix unitaire?");
		this.priceUnit = Integer.parseInt(sc.next());
	}

	public void setPredefinedPriceUnit(int predefinedPriceUnit) {
		this.priceUnit = predefinedPriceUnit;
	}
	
}
