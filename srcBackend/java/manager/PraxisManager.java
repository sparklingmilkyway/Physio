package java.manager;

import java.concept.Therapeut;

/**
 * Created by Vanessa on 19.03.17.
 */
public class PraxisManager {

    public void addTherapeut(Therapeut therapeut){
        this.therapeuts.add(therapeut);
    }

    public boolean removeTherapeut(Therapeut therapeut){
        if(this.therapeuts.contains(therapeut)){
            this.therapeuts.remove(therapeut);
            return true;
        }
        return false;
    }



}
