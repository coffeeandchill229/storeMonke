




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import javax.swing.JPanel;

/**
 *
 * @author llong
 */
public class DanhMuc {
    JPanel _JPanelLeft;
    String _String;
    JPanel _JPanelRight;
    
    public DanhMuc() {
    }

    public DanhMuc(JPanel _JPanelLeft, String _String, JPanel _JPanelRight) {
        this._JPanelLeft = _JPanelLeft;
        this._String = _String;
        this._JPanelRight = _JPanelRight;
    }

    public JPanel getJPanelLeft() {
        return _JPanelLeft;
    }

    public void setJPanelLeft(JPanel _JPanelLeft) {
        this._JPanelLeft = _JPanelLeft;
    }

    public String getString() {
        return _String;
    }

    public void setString(String _String) {
        this._String = _String;
    }

    public JPanel getJPanelRight() {
        return _JPanelRight;
    }

    public void setJPanelRight(JPanel _JPanelRight) {
        this._JPanelRight = _JPanelRight;
    }

    
    
}
