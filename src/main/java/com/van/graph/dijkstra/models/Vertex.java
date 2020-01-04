package com.van.graph.dijkstra.models;

import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    private Character character;
    private Integer distance;

    public Vertex(Character id, Integer distance) {
        super();
        this.character = id;
        this.distance = distance;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
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
        return Objects.equals(character, vertex.character) &&
                Objects.equals(distance, vertex.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, distance);
    }

    @Override
    public String toString() {
        return "Vertex{" + "id=" + character + ", distance=" + distance + '}';
    }

    @Override
    public int compareTo(Vertex o) {
        if(this.distance < o.distance)
            return -1;
        else if(this.distance > o.distance)
            return 1;
        else
            return this.getCharacter().compareTo(o.getCharacter());
    }
}
