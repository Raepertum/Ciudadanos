package com.virtualboardgames.ciudadanos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public class MenuAlmacen extends Group{
	
	TextureRegion texturabotondealmacen;
	Actor actordeprueba;
	int posicionx=0;
	int posiciony=0;

	public MenuAlmacen(){

	actordeprueba = new Actor();	
	texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacen;
	this.setBounds(750, 575, 25, 25);
	
	
	this.addActor(actordeprueba);
		
		
	}
	
	public void draw(SpriteBatch batch, float parentAlpha){
		 batch.draw(texturabotondealmacen,posicionx,posiciony);
		 Texturasysonidos.texturasysonidos.fuentes.Arial15.draw(batch,"Penes", 220, 280);
}
	
}
