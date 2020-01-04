package com.van.graph.models;

import java.util.Objects;

public class VertexOld {
    public String label;

    public VertexOld(String value) {
        this.label = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VertexOld vertexOld = (VertexOld) o;
        return Objects.equals(label, vertexOld.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
