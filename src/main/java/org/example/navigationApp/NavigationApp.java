package org.example.navigationApp;

import Dron.Dron;

import java.util.LinkedList;
import java.util.ArrayList;
public class NavigationApp {

    ArrayList<ArrayList<Integer>> map;

    public NavigationApp(ArrayList<ArrayList<Integer>> map) {
        this.map = map;
    }

    public LinkedList<String> shortestPath(Dron.Position src, Dron.Position dest) {
        LinkedList<String> path = new LinkedList<String>();

        return path;
    }
}
