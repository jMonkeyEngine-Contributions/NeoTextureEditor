/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jme3.gde.neotexture;

import com.jme3.asset.AssetManager;
import com.jme3.gde.core.assets.AssetManagerConfigurator;
import com.jme3.texture.plugins.NeoTextureLoader;
import com.jme3.texture.plugins.NeoTextureLocator;

/**
 *
 * @author normenhansen
 */
@org.openide.util.lookup.ServiceProvider(service=AssetManagerConfigurator.class)
public class NeoTextureAssetManagerConfigurator implements AssetManagerConfigurator{

    public void prepareManager(AssetManager manager) {
        manager.registerLocator("/", NeoTextureLocator.class);
        manager.registerLoader(NeoTextureLoader.class,"tgr");
    }

}
