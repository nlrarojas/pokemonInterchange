package controller;

import java.util.Observable;

/**
 *
 * @author Nelson
 */
public class OriginPlayerHandler extends Observable{
    
    private Object atributeChanged;

    public OriginPlayerHandler() {
    }

    public Object getAtributeChanged() {
        return atributeChanged;
    }

    public void setAtributeChanged(Object atributeChanged) {
        this.atributeChanged = atributeChanged;
    }        
    
    public void setChanged(Object atributeChanged){
        this.atributeChanged = atributeChanged;
        this.setChanged();
        this.notifyObservers(this.atributeChanged);
    }
}
