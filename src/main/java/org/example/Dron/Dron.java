package org.example.Dron;

import java.util.ArrayList;

public class Dron {
    public static class Position {
        public int ew, ns;

        public Position(int ew, int ns) {
            this.ew = ew;
            this.ns = ns;
        }

        public int getVposition() {
            return ns;
        }
        public int getHposition() {
            return ew;
        }

        void setPosition(int ew, int ns) {
            this.ew = ew;
            this.ns = ns;
        }
    }

    // Dron store its position and where it has been
    Position position;
    Position boundary;
    Position destination;

    ArrayList<Position> visited;

    public Dron() {
        position = new Position(0, 0);
        visited = new ArrayList<Position>();

        boundary = new Position(5, 5);

    }

    public void setBoundary(int ew, int ns) {
        boundary.ew = ew;
        boundary.ns = ns;

    }

    public void setDestination(int ew, int ns) {
        destination.ew = ew;
        destination.ns = ns;
    }

    public boolean validMove(Position newPosition) {
        if (newPosition.getHposition() > boundary.ew || newPosition.getHposition() < 0) {
            return false;
        }
        if (newPosition.getVposition() > boundary.ns || newPosition.getVposition() < 0) {
            return false;
        }
        return true;

    }

    public void forward() throws IndexOutOfBoundsException{
        position.ns -= 1;
        if(!validMove(position)) {
            position.ns += 1;
            System.err.println("It is invalid moving");
            throw new IndexOutOfBoundsException();
        }
        System.out.println(position.ns);
        visited.add(this.position);
    }

    public void backward() throws IndexOutOfBoundsException{
        position.ns += 1;
        if(!validMove(position)) {
            position.ns -= 1;
            System.err.println("It is invalid moving");
            throw new IndexOutOfBoundsException();
        }
        visited.add(this.position);

    }

    public void left() throws IndexOutOfBoundsException{
        position.ew -= 1;
        if(!validMove(position)) {
            position.ew -= 1;
            System.err.println("It is invalid moving");
            throw new IndexOutOfBoundsException();
        }
        visited.add(this.position);

    }

    public void right() throws IndexOutOfBoundsException{
        position.ew += 1;
        if(!validMove(position)) {
            position.ew += 1;
            System.err.println("It is invalid moving");
            throw new IndexOutOfBoundsException();
        }
        visited.add(this.position);

    }

    public Position current(){

        return position;

    }


    public int totalDistance(){

        return visited.size();

    }

    public boolean repeated(){

        return false;

    }



}
