package controller;

import java.util.Observable;

/**
 *
 * @author Nelson
 */
public class PokemonEvolutionHandler extends Observable{
    
    private Object atributeChanged;

    public void setChanged(Object atributeChanged){
        this.atributeChanged = atributeChanged;
        this.setChanged();
        this.notifyObservers(this.atributeChanged);
    }
    
    public Object getAtributeChanged() {
        return atributeChanged;
    }

    public void setAtributeChanged(Object atributeChanged) {
        this.atributeChanged = atributeChanged;
    }      
}
