package com.testalgorithms.helpers;

public class Vertex implements Comparable<Vertex> {
    private Character id;
    private Integer distance;

    public Vertex(Character id, Integer distance) {
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
    public int compareTo(Vertex o) {
        if(this.distance < o.distance)
            return -1;
        else if(this.distance > o.distance)
            return 1;
        else
            return this.getId().compareTo(o.getId());
    }
}
