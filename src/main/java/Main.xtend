

import com.scoochshot.User.User

class Main {
	
	/**
	 * Simple test to see if Xtend is working properly
	 */
	def static void main(String[] args) {
		var testStrings = newArrayList("First" , "Second")
		
		testStrings.forEach[println("Test string is: " + it)]
		
		var User aUser = new User()
		aUser.phoneNumber = "123"
		
		aUser.phrase = "Megan dislikes Bobby"	
		println("Megan's phrase is: "+aUser.phrase)
		
		aUser.phrase = "Megan loves Bobby"
		println("Megan's phrase is: "+aUser.phrase)
	}
}