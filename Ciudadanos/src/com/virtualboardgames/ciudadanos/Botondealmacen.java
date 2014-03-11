package com.virtualboardgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Botondealmacen extends Actor{

	private float posicionx = 750;
	private float posiciony = 575;
	private Stage stage;
	
	private TextureRegion texturabotondealmacen;
	
	public Botondealmacen(Stage stage){
		this.stage = stage;
		init();
	};
	private void init(){
		texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacen;
		this.setBounds(750, 575, 25, 25);
		
		this.addListener(new InputListener(){
			
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int actor){
				texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacenpulsado;
				abrirmenualmacen();
				return true;
			};
			
			public void enter(InputEvent event, float x, float y, int pointer, Actor actor){
				texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacensobre;
			};
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacen;
			}
		 	public void exit(InputEvent event, float x, float y, int pointer, Actor actor){
		 		texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacen; 
		 	};
		});
	};
	
	private void abrirmenualmacen() {
		MenuAlmacen menualmacen = new MenuAlmacen();
		menualmacen.setPosition(0, 0);
		menualmacen.setX(0);
		stage.addActor(menualmacen);
		
	};
	
	
	public void draw(SpriteBatch batch, float alpha){
        batch.draw(texturabotondealmacen,posicionx,posiciony);
}
};


