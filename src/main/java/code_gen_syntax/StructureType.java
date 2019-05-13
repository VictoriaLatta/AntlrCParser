package code_gen_syntax;

public class StructureType implements Type {
    public final StructureName name;

    public StructureType(final StructureName name) {
        this.name = name;
    }

    public int hashCode() { return name.hashCode(); }
    public boolean equals(final Object other) {
        return (other instanceof StructureType &&
                ((StructureType)other).name.equals(name));
    }
    public String toString() { return name.toString(); }
}
