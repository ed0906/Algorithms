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
		nlp = new NaturalLanguageProcessor("Today is a good day");
	}

	@Test
	public void testNLP() throws IOException {
		List<Sentiment> scores = nlp.getScentenceSentiment();
		
		assertEquals(Sentiment.POSITIVE, scores.get(0));
	}
}
