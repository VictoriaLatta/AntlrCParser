package code_gen;

import code_gen_syntax.Variable;
import code_gen_syntax.Type;

import java.util.Iterator;
import java.util.LinkedList;

public class VariableTable {
    private LinkedList<VariableEntry> variables;

    public VariableTable() {
        variables = new LinkedList<VariableEntry>();
    }

    public void pushVariable(final Variable variable,
                             final Type type,
                             final int size) {
        variables.push(new VariableEntry(variable, type, size));
    }

    public VariableTableResetPoint makeResetPoint() {
        return new VariableTableResetPoint(variables.size());
    }

    public int sizeAllocatedSinceResetPoint(final VariableTableResetPoint resetPoint) {
        int size = variables.size();
        final int targetSize = resetPoint.resetTo;
        assert(targetSize <= size);
        assert(targetSize >= 0);
        int totalSize = 0;
        final Iterator<VariableEntry> it = variables.iterator();

        while (size > targetSize) {
            final boolean hasNext = it.hasNext();
            assert(hasNext);
            totalSize += it.next().size;
            size--;
        }

        return totalSize;
    }
    
    // returns the amount of space freed on the stack
    public int resetTo(final VariableTableResetPoint resetPoint) {
        int size = variables.size();
        final int targetSize = resetPoint.resetTo;
        assert(targetSize <= size);
        int sizeFreed = 0;

        while (size != targetSize) {
            final VariableEntry entry = variables.pop();
            sizeFreed += entry.size;
            size--;
        }

        return sizeFreed;
    }

    // gets starting position in memory
    public int variableOffset(final Variable variable) {
        int offset = 0;
        for (final VariableEntry entry : variables) {
            if (entry.variable.equals(variable)) {
                return offset;
            } else {
                offset += entry.size;
            }
        }

        assert(false);
        return offset;
    }

    public int variableSize(final Variable variable) {
        for (final VariableEntry entry : variables) {
            if (entry.variable.equals(variable)) {
                return entry.size;
            }
        }
        assert(false);
        return 0;
    }

    public int totalSizeOfAllVariables() {
        int result = 0;

        for (final VariableEntry entry : variables) {
            result += entry.size;
        }
        return result;
    }
    
    public boolean isEmpty() {
        return variables.isEmpty();
    }

    public void clear() {
        variables.clear();
    }
} // VariableTable
