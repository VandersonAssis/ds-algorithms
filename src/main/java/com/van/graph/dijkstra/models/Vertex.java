package com.van.graph.dijkstra.models;

import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    private Character id;
    private Integer distance;

    public Vertex(Character id, Integer distance) {
        super();
        this.id = id;
        this.distance = distance;
    }

    public Character getId() {
        return id;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id) &&
                Objects.equals(distance, vertex.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance);
    }

    @Override
    public String toString() {
        return "Vertex{" + "character=" + id + ", distance=" + distance + '}';
    }

    @Override
    public int compareTo(Vertex o) {
        if(this.distance < o.distance)
            return -1;
        else if(this.distance > o.distance)
            return 1;
        else
            return this.getId().compareTo(o.getId());
    }
}
