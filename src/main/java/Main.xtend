
class Main {
	
	/**
	 * Simple test to see if Xtend is working properly
	 */
	def static void main(String[] args) {
		var testStrings = newArrayList("First" , "Second")
		
		testStrings.forEach[println("Test string is: " + it)]
	}
}