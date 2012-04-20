package com.smartbear.patterns.builder;

public class ExtraComplexImmutableObject implements ComplexImmutable{

    private final ComplexImmutableObject compositeBehavior;
    private final String aspect;

    ExtraComplexImmutableObject(ComplexImmutableObject compositeBehavior, String aspect) {
        this.compositeBehavior = compositeBehavior;
        this.aspect = aspect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraComplexImmutableObject that = (ExtraComplexImmutableObject) o;

        if (!aspect.equals(that.aspect)) return false;
        if (!compositeBehavior.equals(that.compositeBehavior)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compositeBehavior.hashCode();
        result = 31 * result + aspect.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExtraComplexImmutableObject{" +
                "compositeBehavior=" + compositeBehavior +
                ", aspect='" + aspect + '\'' +
                '}';
    }

    @Override
    public String performAction() {
        return "Hi from " + this.toString();
    }
}
