package algorithm.nlp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NaturalLanguageProcessorRunner {

	private static NaturalLanguageProcessor nlp;
	
	public static void main(String[] args) throws IOException {
		nlp = new NaturalLanguageProcessor();
		
		Scanner keyboard = new Scanner(System.in);
		
		String line = "";
		while(!line.equalsIgnoreCase("x")) {
			System.out.println("\nPlease type some text for sentiment analysis:");
			line = keyboard.nextLine();
			List<Sentiment> sentiment = nlp.getScentenceSentiment(line);
			for(int i=0; i< sentiment.size(); i++) {
				System.out.println("Sentence " + i + ": " + sentiment.get(i).toString());
			}
		}
		
		keyboard.close();
	}
}
