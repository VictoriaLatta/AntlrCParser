/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_gen;

/**
 *
 * @author Victoria
 */
public class MIPSLabel implements MIPSEntry {
    public final String baseName;
    public final int id;

    public MIPSLabel(final String baseName,
                     final int id) {
        this.baseName = baseName;
        this.id = id;
    }

    public String getName() {
        return baseName + id;
    }
    
    public String toString() {
        return getName() + ":";
    }

    public boolean equals(final Object other) {
        if (other instanceof MIPSLabel) {
            final MIPSLabel label = (MIPSLabel)other;
            return (baseName.equals(label.baseName) &&
                    id == label.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return baseName.hashCode() + id;
    }
}
