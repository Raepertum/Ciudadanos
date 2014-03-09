package com.virtualboardgames.ciudadanos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.UBJsonReader;

public class Renderizador implements Disposable{
	
	private Camara camara;
	private OrthographicCamera camaraparalagui;
	private SpriteBatch batch;
	private Logica logica;	
	private Torre torre;
	//private Tierra tierra;
	private Array <Tierra> tierras;
	//private Guideprueba guideprueba;
	private Contenedorhud contenedorhud;
	
public Renderizador(Logica logica){
	this.logica = logica;
	iniciarclase();
	
}

private void iniciarclase(){
	batch = new SpriteBatch();
	camara = new Camara(Constantes.ANCHODELVISOR, Constantes.ALTODELVISOR);
	camara.mandaralorigen();
	camara.update();
	
	camaraparalagui = new OrthographicCamera(Constantes.ANCHODELVISORGUI, Constantes.ALTODELVISORGUI);
	camaraparalagui.position.set(0,0,0);
	camaraparalagui.setToOrtho(true);
	camaraparalagui.update();
	
	
	//Las tierras
	tierras = new Array<Tierra>();
	for(int i=0;i<22;i++){
		for(int j=0;j<8;j++){
	Tierra tierra = new Tierra();
	tierra.posicionX+=i*1.0f-10;
	tierra.posicionY-=j*1.0f;
	tierras.add(tierra);
	}
	};
	
	//La torre	
	torre = new Torre();
	
	//El contenedor hud
	contenedorhud = new Contenedorhud();
	
	}

public void render(){
	
	actualizarMovimientoCamara();
	actualizarZoomCamara();
	renderizarObjetos();
	renderizarHud();
	

};

public void actualizarZoomCamara(){
	if(logica.zoomcamara==-1){
		camara.alejarzoom();
		logica.zoomcamara=0;
	}
	else if(logica.zoomcamara==1){
		camara.acercarzoom();
		logica.zoomcamara=0;
	}
};

public void resize(int width, int height){
	camara.viewportWidth= (Constantes.ALTODELVISOR/height)*width;
	camara.update();
	camaraparalagui.viewportHeight = Constantes.ANCHODELVISORGUI;
	camaraparalagui.viewportWidth = (Constantes.ALTODELVISORGUI/(float)height)*(float)width;
	camaraparalagui.position.set(camaraparalagui.viewportWidth/2, camaraparalagui.viewportHeight/2, 0);
	camaraparalagui.update();
};

@Override
public void dispose() {
	batch.dispose();
}

private void renderizarObjetos(){
	
	//Objetos
	batch.setProjectionMatrix(camara.combined);
	batch.begin();	
	for(Tierra tierra:this.tierras){
		tierra.render(batch);
	};
	torre.render(batch);
	batch.end();
}

private void actualizarMovimientoCamara(){
	if ((logica.pulsandoW==true)&&(logica.pulsandoS==false)){
		camara.moverCamaraYnegativo();
	}
	if ((logica.pulsandoS==true)&&(logica.pulsandoW==false)){
		camara.moverCamaraYpositivo();
	}
	if ((logica.pulsandoD==true)&&(logica.pulsandoA==false)){
		camara.moverCamaraXnegativo();
	}
	if ((logica.pulsandoA==true)&&(logica.pulsandoD==false)){
		camara.moverCamaraXpositivo();
	}
	else{
		camara.desacelerarCamara();
	}
}

private void renderizarHud(){

	//Gui
	batch.setProjectionMatrix(camaraparalagui.combined);
	batch.begin();
	contenedorhud.render(batch);
	batch.end();	

}


};