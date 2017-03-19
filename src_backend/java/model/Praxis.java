package java.model;

import java.util.ArrayList;
import java.util.List;

public class Praxis{

    private String name;
    private List<Therapeut> therapeutList;

    public Praxis(String name){
        this.name = name;
        therapeutList = new ArrayList<Therapeut>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addTherapeut(Therapeut therapeut){
        this.therapeutList.add(therapeut);
    }

    public boolean removeTherapeut(Therapeut therapeut){
        if(this.therapeutList.contains(therapeut)){
            this.therapeutList.remove(therapeut);
            return true;
        }
        return false;
    }
}