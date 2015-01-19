package algorithm.nlp;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.google.common.collect.Lists;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class NaturalLanguageProcessor {

	private StanfordCoreNLP pipeline;

	public NaturalLanguageProcessor() {
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, parse, sentiment");
		pipeline = new StanfordCoreNLP(props);
	}

	public List<Sentiment> getScentenceSentiment(String input) throws IOException {
		Annotation annotation = new Annotation(input);
		pipeline.annotate(annotation);
		List<Sentiment> scores = Lists.newArrayList();
		for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
			Tree annotatedTree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
			int score = RNNCoreAnnotations.getPredictedClass(annotatedTree);
			scores.add(Sentiment.fromInt(score));
		}
		
		return scores;
	}
}
