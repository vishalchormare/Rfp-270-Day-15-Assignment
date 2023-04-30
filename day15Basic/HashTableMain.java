package day15Basic;

public class HashTableMain {

	public static void main(String[] args) {
		String paraGraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		HashTable<String, Integer> hashTable = new HashTable(6);

		String[] wordsArray = paraGraph.split(" ");
		for (String word : wordsArray) {
			// int index = hashTable.getIndex(word);
			// System.out.println(word + " -> " + word.hashCode() + " -> " + index);
			Integer currentFrequency = hashTable.get(word);
			if (currentFrequency == null)
				currentFrequency = 1;
			else
				currentFrequency++;
			hashTable.addOrUpdate(word, currentFrequency);
		}
		System.out.println(hashTable);

		hashTable.searchAndMakeNull("avoidable", 1);

		System.out.println(hashTable);
	}

}
