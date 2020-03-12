/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tuankqhe130156
 */
public class Permission {

    Action action;
    _Object obj;

    @Override
    public String toString() {
        return action + " - " + obj;
    }

    public Permission() {
        action = new Action();
        obj = new _Object();
    }

    public Permission(Action action, _Object obj) {
        this.action = action;
        this.obj = obj;
    }

    public Action getAction() {
        return action;
    }

    public _Object getObj() {
        return obj;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setObj(_Object obj) {
        this.obj = obj;
    }

}
