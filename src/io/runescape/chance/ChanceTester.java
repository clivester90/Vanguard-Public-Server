package io.runescape.chance;
import java.util.Arrays;


/**
 * Chance tester.
 *
 * @author C.T For RuneRogue
 */

public class ChanceTester {

	public static void main(String[] args) {
		Chance<String> chance = new Chance<>(Arrays.asList(
                new WeightedChance<>(1, "Kiwi"),
                new WeightedChance<>(25, "Mango"),
                new WeightedChance<>(50, "Orange"),
                new WeightedChance<>(60, "Lemmon")
        ));
		
//		Chance<String> chance = new Chance<String>(Arrays.asList(
//				new WeightedChance<String>(1, "Lemmon"),
//				new WeightedChance<String>(2, "Mango"),
//				new WeightedChance<String>(4, "Kiwi"),
//				new WeightedChance<String>(9, "Orange")
//		));

		double iterations = 10_000_000;

		int lemmon = 0;
		int mango = 0;
		int kiwi = 0;
		int orange = 0;

		for (int i = 0; i < iterations; i++) {
			String fruit = chance.nextObject().get();

			switch (fruit) {
				case "Lemmon":
					lemmon++;
					break;
				case "Mango":
					mango++;
					break;
				case "Kiwi":
					kiwi++;
					break;
				case "Orange":
					orange++;
					break;
			}

//			System.out.println(fruit);
		}

		System.out.println("The lemmons are chosen " + (lemmon * 100 / iterations) + "% of the time.");
		System.out.println("The mangos are chosen " + (mango * 100 / iterations) + "% of the time.");
		System.out.println("The kiwis are chosen " + (kiwi * 100 / iterations) + "% of the time.");
		System.out.println("The oranges are chosen " + (orange * 100 / iterations) + "% of the time.");
	}
}