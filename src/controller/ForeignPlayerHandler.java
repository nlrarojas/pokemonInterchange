package controller;

import java.util.Observable;

/**
 *
 * @author Nelson
 */
public class ForeignPlayerHandler extends Observable{
    
    private Object atributeChanged;

    public ForeignPlayerHandler() {
        
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
