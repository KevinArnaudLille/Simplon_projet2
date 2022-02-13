import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
	private String personName;
	private boolean isOrderDone = false;
	private ArrayList<Meal> mealList = new ArrayList<Meal>();
	private int totalPrice = 0;
	private String mealTypeAnswer;

	private Map<String, Integer> predefinedMealList = new HashMap<String, Integer>();

	public Order() {
		this.predefinedMealList.put("Kebab", 5);
		this.predefinedMealList.put("Falafel", 6);
		this.predefinedMealList.put("Burger", 4);
		this.predefinedMealList.put("Charlyz", 100000);
	}

	private Scanner sc = new Scanner(System.in);

	public void launchOrder() {
		this.askForName();
		do {
			this.askMealType();
			this.askIsOrderDone();
		} while (!isOrderDone);
		this.printOrder();
	}

	public void askForName() {
		System.out.println("Votre nom siouplai?");
		this.personName = sc.next();
	}

	public void printPredefinedMeal() {
		System.out.println("---------------");
		System.out.println("Notre carte :");
		for (Map.Entry<String, Integer> entry : predefinedMealList.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue() + " euros");
		}
		System.out.println("---------------");
	}

	public void askMealType() {
		System.out.println("1 : Voir la carte");
		System.out.println("2 : Plat sur-mesure");
		System.out.println("3 : Fin de commande");
		mealTypeAnswer = sc.next();
		this.askForMeal();
	}

	public void askForMeal() {
		switch (mealTypeAnswer) {
		case "1":
			this.printPredefinedMeal();
			this.addPredefinedMeal();
			break;
		case "2":
			this.addFreeMeal();
			break;
		case "3":
			isOrderDone = !isOrderDone;
			break;
		default:
			System.out.println(mealTypeAnswer + " n'est pas une réponse non valable");
			this.askMealType();

		}
	}

	public void addPredefinedMeal() {
		String predefinedMealAsked = this.askForPredefinedMeal();
		boolean isAnswerCorrect = false;
		for (Map.Entry<String, Integer> entry : predefinedMealList.entrySet()) {
			if (predefinedMealAsked.equals(entry.getKey())) {
				Meal newMeal = new Meal();
				newMeal.setPredefinedName(entry.getKey());
				newMeal.setPredefinedPriceUnit(entry.getValue());
				newMeal.setQte();
				this.mealList.add(newMeal);
				isAnswerCorrect = !isAnswerCorrect;
			}
		}
		if (!isAnswerCorrect) {
			System.out.println(predefinedMealAsked + " n'est pas une commande valable");
		}

	}

	public String askForPredefinedMeal() {
		System.out.println("Quel plat de la carte voulez-vous? (écrire exactement le nom)");
		return sc.next();
	}

	public void addFreeMeal() {
		Meal newMeal = new Meal();
		newMeal.setName();
		newMeal.setPriceUnit();
		newMeal.setQte();

		this.mealList.add(newMeal);

	}

	public void askIsOrderDone() {
		if (!isOrderDone) {

			System.out.println("Avez-vous fini votre commande? Y/n");
			String isOrderDoneAnswer = sc.next();
			if (isOrderDoneAnswer.equals("Y")) {
				isOrderDone = !isOrderDone;
			}
		}
	}

	public void printOrder() {
		System.out.println("===== Commande de " + this.personName + " =====");
		int i = 1;
		for (Meal meal : mealList) {
			System.out.println("Plat n°" + i);
			i++;
			System.out.println(meal.getName());
			System.out.println("Prix : " + meal.getPriceUnit());
			System.out.println("Qte : " + meal.getQte());
			System.out.println("Sous-total : " + meal.getSum() + " euros");
			System.out.println("--------------------------");
			this.totalPrice += meal.getSum();
		}
		System.out.println("=====================");
		System.out.println("TOTAL : " + this.totalPrice + " euros");
	}
}
