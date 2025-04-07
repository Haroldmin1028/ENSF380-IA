package edu.ucalgary.oop;

public class Cot extends Supply{
    private int room;
    private String gridLocation;

    public Cot(int room, String gridLocation) {
        super("cot", room + " " + gridLocation);
        this.room = room;
        this.gridLocation = gridLocation;
    }

    public int getRoom() {return room;}
    public void setRoom(int room) {this.room = room;}
    public String getGridLocation() {return gridLocation;}
    public void setGridLocation(String gridLocation) {this.gridLocation = gridLocation;}
}
