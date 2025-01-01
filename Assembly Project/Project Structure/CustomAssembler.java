import java.util.ArrayList;
import java.util.HashMap;

abstract public class CustomAssembler {
    abstract public String[] assembleInstructions (String[] text);
    abstract String convertLine (String line);
    abstract void tryReplacing (HashMap<String,String> conversions,
                                        StringBuilder bitfield, String type);
    abstract String convertItem (String item, String type);
    abstract StringBuilder convert16BitToAsciiBin (int value);
    abstract String removeParenthesis (String line);
    abstract String[] cleanup (String[] instructions);
    abstract HashMap<String,Integer> getLineNumbers (String[] fileLines);
}
