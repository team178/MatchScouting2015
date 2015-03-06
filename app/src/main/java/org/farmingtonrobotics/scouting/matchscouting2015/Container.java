package org.farmingtonrobotics.scouting.matchscouting2015;

/**
 * Created by Nandan on 2/28/2015.
 */
public class Container {
    private String name;
    private int height;
    private boolean wasUsed;
    public Container(String name){
        this.name=name;
    }
    public void setUsed(boolean used){
        this.wasUsed=used;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public boolean WasUsed() {
        return wasUsed;
    }
    public int getHeight() {
        return height;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return getHeight()+","+WasUsed();
    }
}
