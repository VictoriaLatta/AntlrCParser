package code_gen_syntax;

// just to help with string conversion
public class Join {
    public static <A> String join(final String delimiter,
                                  final A[] items) {
        if (items.length == 0) {
            return "";
        }
        String retval = "";
        for (int x = 0; x < items.length - 1; x++) {
            retval += items[x].toString() + delimiter;
        }
        retval += items[items.length - 1].toString();
        return retval;
    }
}
