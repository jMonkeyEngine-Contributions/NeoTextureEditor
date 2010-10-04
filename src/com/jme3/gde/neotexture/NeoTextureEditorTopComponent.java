/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.neotexture;

import com.jme3.gde.core.assets.AssetDataObject;
import com.mystictri.neotextureedit.TextureEditor;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.cookies.SaveCookie;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.jme3.gde.neotexture//NeoTextureEditor//EN",
autostore = false)
public final class NeoTextureEditorTopComponent extends TopComponent {

    private static NeoTextureEditorTopComponent instance;
    /** path to the icon used by the component and its open action */
    static final String ICON_PATH = "com/jme3/gde/neotexture/NeoTextureEdit.png";
    private static final String PREFERRED_ID = "NeoTextureEditorTopComponent";
    DataObject object;
    TextureEditor textureEditor;
//    NeoTexturePropertiesTopComponent propertiesComponent;

    public NeoTextureEditorTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(NeoTextureEditorTopComponent.class, "CTL_NeoTextureEditorTopComponent"));
        setToolTipText(NbBundle.getMessage(NeoTextureEditorTopComponent.class, "HINT_NeoTextureEditorTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        textureEditor = new TextureEditor(new String[]{"--disableGL"});
        textureEditor.initialize();
        selectionPanel.add(textureEditor.getPatternSelectorPanel());
        graphPanel.add(textureEditor.getTextureGraphEditorPanel());
        NeoTexturePropertiesTopComponent.getDefault().addNeoPanel(textureEditor.getTextureGraphEditorPanel().getParameterEditorPanel());
//        textureEditor.getTextureGraphEditorPanel().addPropertyChangeListener(this);
    }

    public void loadNeoGraph(DataObject object){
        if (object == null) {
            textureEditor.setCurrentFileName(null);
            return;
        }
        this.object = object;
        String fileName=object.getPrimaryFile().getPath();
        textureEditor.setCurrentFileName(fileName);
        textureEditor.getTextureGraphEditorPanel().load(fileName, true);
        setActivatedNodes(new Node[]{object.getNodeDelegate()});
        if (object instanceof AssetDataObject) {
            ((AssetDataObject) object).setSaveCookie(new SaveCookieImpl());
        }
//        object.setModified(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphPanel = new javax.swing.JPanel();
        selectionPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        graphPanel.setRequestFocusEnabled(false);
        graphPanel.setLayout(new javax.swing.BoxLayout(graphPanel, javax.swing.BoxLayout.LINE_AXIS));

        selectionPanel.setLayout(new javax.swing.BoxLayout(selectionPanel, javax.swing.BoxLayout.LINE_AXIS));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(NeoTextureEditorTopComponent.class, "NeoTextureEditorTopComponent.jButton2.text")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jToolBar1.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(selectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addComponent(selectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        textureEditor.actionPerformed(new ActionEvent(this, 0, "file_save"));
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel selectionPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized NeoTextureEditorTopComponent getDefault() {
        if (instance == null) {
            instance = new NeoTextureEditorTopComponent();
        }
        return instance;
    }

//    public void propertyChange(PropertyChangeEvent evt) {
//        object.setModified(true);
//    }

    /**
     * Obtain the NeoTextureEditorTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized NeoTextureEditorTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(NeoTextureEditorTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof NeoTextureEditorTopComponent) {
            return (NeoTextureEditorTopComponent) win;
        }
        Logger.getLogger(NeoTextureEditorTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    public void componentOpened() {
        NeoTexturePropertiesTopComponent.getDefault().open();
        NeoTexturePropertiesTopComponent.getDefault().requestActive();
    }

    @Override
    public void componentClosed() {
        NeoTexturePropertiesTopComponent.getDefault().close();
        if (object != null) {
            object.setModified(false);
        }
        TextureEditor.INSTANCE = null;
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    public class SaveCookieImpl implements SaveCookie {

        public void save() throws IOException {
            textureEditor.actionPerformed(new ActionEvent(this, 0, "file_save"));
//            object.setModified(false);
        }
    }
}
