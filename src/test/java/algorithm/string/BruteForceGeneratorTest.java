package algorithm.string;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import algorithm.string.BruteForceGenerator;

public class BruteForceGeneratorTest {

	private BruteForceGenerator generator;
	
	@Before
	public void setUp() {
		generator = new BruteForceGenerator(new HashSet<Character>(Arrays.asList('a','b')));
	}
	
	@Test
	public void testStringsGenerateCorrectly() {
		assertEquals("a", generator.next());
		assertEquals("b", generator.next());
		assertEquals("aa", generator.next());
		assertEquals("ab", generator.next());
		assertEquals("ba", generator.next());
		assertEquals("bb", generator.next());
		assertEquals("aaa", generator.next());
		assertEquals("aab", generator.next());
		assertEquals("aba", generator.next());
		assertEquals("abb", generator.next());
		assertEquals("baa", generator.next());
	}
}
