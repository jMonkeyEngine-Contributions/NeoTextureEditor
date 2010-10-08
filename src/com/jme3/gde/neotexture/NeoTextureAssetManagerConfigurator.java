/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jme3.gde.neotexture;

import com.jme3.asset.AssetManager;
import com.jme3.gde.core.assets.AssetManagerConfigurator;

/**
 *
 * @author normenhansen
 */
@org.openide.util.lookup.ServiceProvider(service=AssetManagerConfigurator.class)
public class NeoTextureAssetManagerConfigurator implements AssetManagerConfigurator{

    public void prepareManager(AssetManager manager) {
        manager.registerLocator("/", "com.jme3.texture.plugins.NeoTextureLocator");
        manager.registerLoader("com.jme3.texture.plugins.NeoTextureLoader","tgr");
    }

}
