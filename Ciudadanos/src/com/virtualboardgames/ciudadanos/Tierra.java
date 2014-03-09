package com.virtualboardgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tierra extends Objetodejuego {

private TextureRegion tierrasinabonar;
		
		
		public Tierra(){
			init();
		};
		
		private void init(){
			posicionX = -1f;
			posicionY = -0.5f;
			dimensionX = 1;
			dimensionY = 1;
			tierrasinabonar = Texturasysonidos.texturasysonidos.tierra.tierrasinabonar;
			
		}
		
		@Override
		public void render(SpriteBatch batch) {
		
			//Habr� que cambiar esto m�s adelante, por ahora s�lo renderizar� una base
			TextureRegion textura = null;
			//Dibujamos una base
			textura = tierrasinabonar;
			batch.draw(textura.getTexture(),posicionX, posicionY-1.5f,origenX,origenY,dimensionX,dimensionY,
					escalaX, escalaY,rotacion,textura.getRegionX(),textura.getRegionY(),
					textura.getRegionWidth(),textura.getRegionHeight(),false,false);
			
		}

	}

