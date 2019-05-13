package code_gen;

import code_gen_syntax.Variable;
import code_gen_syntax.Type;

public class VariableEntry {
    public final Variable variable;
    public final Type type;
    public final int size;
    
    public VariableEntry(final Variable variable,
                         final Type type,
                         final int size) {
        this.variable = variable;
        this.type = type;
        this.size = size;
    }

    public String toString() {
        return ("VariableEntry(" +
                variable + ", " +
                type + ", " +
                size + ")");
    }

    public boolean equals(final Object other) {
        if (other instanceof VariableEntry) {
            final VariableEntry otherEntry = (VariableEntry)other;
            return (variable.equals(otherEntry.variable) &&
                    type.equals(otherEntry.type) &&
                    size == otherEntry.size);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (variable.hashCode() +
                type.hashCode() +
                size);
    }
} // VariableEntry
