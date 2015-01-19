package algorithm.nlp;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NaturalLanguageProcessorTest {

	private NaturalLanguageProcessor nlp;

	@Before
	public void setUp() {
		nlp = new NaturalLanguageProcessor();
	}

	@Test
	public void testNLP() throws IOException {
		List<Sentiment> scores = nlp.getScentenceSentiment("Today is a good day!");
		
		assertEquals(Sentiment.POSITIVE, scores.get(0));
	}
}
