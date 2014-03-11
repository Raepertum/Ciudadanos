package com.virtualboardgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Contenedorhud {
	
	Stage contenedordeactores;
	Botondeeventos botondeeventos;
	Botonsocial botonsocial;
	Botondealmacen botondealmacen;
	Botondecomercio botondecomercio;
	Botondeespionaje botondeespionaje;
	Botondeejercito botondeejercito;
	
	
	public Contenedorhud(){
		init();
	};
	private void init(){
		contenedordeactores = new Stage(800,600,true);
		
		botondeeventos = new Botondeeventos(contenedordeactores);
		botonsocial = new Botonsocial(contenedordeactores);
		botondealmacen = new Botondealmacen(contenedordeactores);		
		botondecomercio = new Botondecomercio(contenedordeactores);
		botondeespionaje = new Botondeespionaje(contenedordeactores);
		botondeejercito = new Botondeejercito(contenedordeactores);
		contenedordeactores.addActor(botondeeventos);
		contenedordeactores.addActor(botonsocial);
		contenedordeactores.addActor(botondealmacen);
		contenedordeactores.addActor(botondecomercio);
		contenedordeactores.addActor(botondeespionaje);
		contenedordeactores.addActor(botondeejercito);
	};
	
	public void render(SpriteBatch batch){
		contenedordeactores.act();
		contenedordeactores.draw();
	};
}
