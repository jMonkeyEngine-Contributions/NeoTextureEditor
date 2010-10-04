/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.neotexture;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.openide.loaders.DataObject;

public final class OpenNeoTexture implements ActionListener {

    private final DataObject context;

    public OpenNeoTexture(DataObject context) {
        this.context = context;
    }

    public void actionPerformed(ActionEvent ev) {
        // TODO use context
        NeoTextureEditorTopComponent texEd= NeoTextureEditorTopComponent.getDefault();
        texEd.loadNeoGraph(context);
        texEd.open();
        texEd.requestActive();
    }
}
