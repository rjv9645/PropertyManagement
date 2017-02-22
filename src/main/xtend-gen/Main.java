import com.scoochshot.User.User;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Main {
  /**
   * Simple test to see if Xtend is working properly
   */
  public static void main(final String[] args) {
    ArrayList<String> testStrings = CollectionLiterals.<String>newArrayList("First", "Second");
    final Consumer<String> _function = (String it) -> {
      InputOutput.<String>println(("Test string is: " + it));
    };
    testStrings.forEach(_function);
    User aUser = new User();
    aUser.setPhoneNumber("123");
    aUser.setPhrase("Megan dislikes Bobby");
    String _phrase = aUser.getPhrase();
    String _plus = ("Megan\'s phrase is: " + _phrase);
    InputOutput.<String>println(_plus);
    aUser.setPhrase("Megan loves Bobby");
    String _phrase_1 = aUser.getPhrase();
    String _plus_1 = ("Megan\'s phrase is: " + _phrase_1);
    InputOutput.<String>println(_plus_1);
  }
}
