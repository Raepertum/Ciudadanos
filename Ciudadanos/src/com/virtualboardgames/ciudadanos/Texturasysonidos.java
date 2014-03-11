package com.virtualboardgames.ciudadanos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

public class Texturasysonidos implements Disposable, AssetErrorListener{

	//Para gestionar los archivos y recoger errores y excepciones
	private AssetManager assetmanager;
	public static final Texturasysonidos texturasysonidos = new Texturasysonidos();
	
	//Para que sólo se pueda instanciar una vez
	private Texturasysonidos(){};
	
	//Para poder crear skins para los widgets
	TextureAtlas atlasdetodaslastexturas;
	
	//Las fuentes
	public Fuentes fuentes;	
	//La Torre
	public TorreGrafica torre;
	//La tierra (Y el campo más adelante)
	public TierraGrafica tierra;
	//Los botones del juego
	public BotonesGrafica botones;
	
	
	
	public void init(AssetManager assetmanager){
		this.assetmanager = assetmanager;
		assetmanager.setErrorListener(this);
		assetmanager.load(Constantes.TEXTURE_ATLAS, TextureAtlas.class);
		assetmanager.finishLoading();
	
	
	atlasdetodaslastexturas = assetmanager.get(Constantes.TEXTURE_ATLAS);
	for (Texture t : atlasdetodaslastexturas.getTextures())
		t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
	//Cada vez que creemos un nuevo objeto, hay que registrar aquí los gráficos
	
	fuentes = new Fuentes();
	torre = new TorreGrafica(atlasdetodaslastexturas);
	tierra = new TierraGrafica(atlasdetodaslastexturas);
	botones = new BotonesGrafica(atlasdetodaslastexturas);
	}
	
	@Override
	public void error(AssetDescriptor arg0, Throwable arg1) {
		System.out.println("No se ha podido cargar la textura");
	}

	@Override
	public void dispose() {
		assetmanager.dispose();
		fuentes.ComicBlanca.dispose();
		fuentes.ComicNegra.dispose();
		
	}
	
	public class Fuentes{
		public final BitmapFont ComicNegra;
		public final BitmapFont ComicBlanca;
		public final BitmapFont Arial15;
		
		public Fuentes(){
			ComicNegra=new BitmapFont(Gdx.files.internal("Fuentes/ComicBlack.fnt"),false);
			ComicBlanca=new BitmapFont(Gdx.files.internal("Fuentes/ComicWhite.fnt"),false);
			Arial15 = new BitmapFont(Gdx.files.internal("Fuentes/arial-15.fnt"),false);
			
			//Escala
			ComicNegra.setScale(1f);
			ComicBlanca.setScale(1f);
			//Filtro
			ComicBlanca.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			ComicNegra.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
	}
	
	
	public class TorreGrafica{
		public final AtlasRegion base;
		public final AtlasRegion medio;
		public final AtlasRegion copa;
		
		public TorreGrafica(TextureAtlas atlas){
			base = atlas.findRegion("Base");
			copa = atlas.findRegion("Copa");
			medio = atlas.findRegion("Medio");
		}
	}
	public class TierraGrafica{
		public final AtlasRegion tierrasinabonar;
		public final AtlasRegion tierraflorecida;
		public final AtlasRegion tierraseca;
		public final AtlasRegion tierraconcharcos;
		public final AtlasRegion tierranevada;
		
		public TierraGrafica(TextureAtlas atlas){
			tierrasinabonar = atlas.findRegion("tierra");
			tierraflorecida = atlas.findRegion("tierraflorecida");
			tierraseca = atlas.findRegion("tierraseca");
			tierraconcharcos = atlas.findRegion("tierraconcharcos");
			tierranevada = atlas.findRegion("tierranevada");
		}
	}
	public class BotonesGrafica{
		public final AtlasRegion botoncomercio;
		public final AtlasRegion botoncomerciosobre;
		public final AtlasRegion botoncomerciopulsado;
		public final AtlasRegion botonespionaje;
		public final AtlasRegion botonespionajesobre;
		public final AtlasRegion botonespionajepulsado;
	    public final AtlasRegion botoneventos;
		public final AtlasRegion botoneventossobre;
		public final AtlasRegion botoneventospulsado;
		public final AtlasRegion botonsocial;
		public final AtlasRegion botonsocialsobre;
		public final AtlasRegion botonsocialpulsado;
		public final AtlasRegion botonalmacen;
		public final AtlasRegion botonalmacensobre;
		public final AtlasRegion botonalmacenpulsado;
		public final AtlasRegion botonejercito;
		public final AtlasRegion botonejercitosobre;
		public final AtlasRegion botonejercitopulsado;
		
		public BotonesGrafica(TextureAtlas atlas){
			botoncomercio = atlas.findRegion("BotonComercio");
			botoncomerciosobre = atlas.findRegion("BotonComercioSobre");
			botoncomerciopulsado = atlas.findRegion("BotonComercioPulsado");
			botonespionaje = atlas.findRegion("BotonEspionaje");
			botonespionajesobre = atlas.findRegion("BotonEspionajeSobre");
			botonespionajepulsado = atlas.findRegion("BotonEspionajePulsado");
			botoneventos = atlas.findRegion("BotonEventos");
			botoneventossobre = atlas.findRegion("BotonEventosSobre");
			botoneventospulsado = atlas.findRegion("BotonEventosPulsado");
			botonsocial = atlas.findRegion("BotonSocial");
			botonsocialsobre = atlas.findRegion("BotonSocialSobre");
			botonsocialpulsado = atlas.findRegion("BotonSocialPulsado");
			botonalmacen = atlas.findRegion("BotonAlmacen");
			botonalmacensobre = atlas.findRegion("BotonAlmacenSobre");
			botonalmacenpulsado = atlas.findRegion("BotonAlmacenPulsado");
			botonejercito = atlas.findRegion("BotonEjercito");
			botonejercitosobre = atlas.findRegion("BotonEjercitoSobre");
			botonejercitopulsado = atlas.findRegion("BotonEjercitoPulsado");			
		};
		
	}
	

}
