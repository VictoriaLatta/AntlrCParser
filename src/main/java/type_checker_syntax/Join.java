/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type_checker_syntax;

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