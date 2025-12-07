package de.hsrm.mi.enia.mp3player.presentation.views;

import javafx.scene.Node;


public abstract class BaseController <T extends Node>{ //Node wegen ToolBar, sonst ginge nur geerbt von Pane

    protected T root;

    public abstract void initialize();

    public T getRoot(){
        return root;
    }
    
}
