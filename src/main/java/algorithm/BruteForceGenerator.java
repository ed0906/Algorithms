package algorithm;

import java.util.Set;

public class BruteForceGenerator {

	private Character[] chars;
	private int[] index;
	
	public BruteForceGenerator(Set<Character> chars){
		this.chars = chars.toArray(new Character[0]);
		index = new int[]{-1};
	}

	public String next() {
		incrementIndexArray();
		
		StringBuilder builder = new StringBuilder(index.length);
		for(int i : index){
			builder.append(chars[i]);
		}
		
		return builder.toString();
	}
	
	private void incrementIndexArray() {
		int position = index.length-1;
		
		boolean recurr;
		do{
			recurr = false;
			if(index[position]+1 == chars.length){
				index[position] = 0;
				position--;
				if(position == -1){
					index = new int[index.length+1];
					position = index.length-1;
				}else{
					recurr = true;
				}
			}else{
				index[position]++;
			}
		}while(recurr);
	}
}
