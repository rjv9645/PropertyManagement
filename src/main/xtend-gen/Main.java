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
  }
}
