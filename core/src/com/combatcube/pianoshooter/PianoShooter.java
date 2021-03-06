package com.combatcube.pianoshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.combatcube.pianoshooter.screens.FileSelectScreen;
import com.combatcube.pianoshooter.screens.GameScreen;
import com.combatcube.pianoshooter.screens.MainMenuScreen;

/**
 * Main game class.
 * Created by Andrew on 1/1/2016.
 */
public class PianoShooter extends Game implements InputProcessor {

    public SpriteBatch batch;
    public ShapeRenderer renderer;
    public BitmapFont font;
    public SoundEngine soundEngine;
    public Screen fileSelectScreen;
    private MainMenuScreen mainMenuScreen;
    public boolean inProgress = false;

    public PianoShooter(CsoundAdapter csoundAdapter) {
        this.soundEngine = new SoundEngine(csoundAdapter);
    }

    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
        this.batch = new SpriteBatch();
        this.renderer = new ShapeRenderer();
        this.font = new BitmapFont(Gdx.files.internal("geo72.fnt"));
        mainMenuScreen = new MainMenuScreen(this);
        fileSelectScreen = new FileSelectScreen(this);
        this.screen = mainMenuScreen;
    }

    @Override
    public void render() {
        super.render(); //important!
    }

    public void endGame() {
        Screen oldScreen = screen;
        setScreen(fileSelectScreen);
        oldScreen.dispose();
        inProgress = false;
    }

    @Override
    public boolean keyDown(int keycode) {
        Gdx.app.debug("MyTag", "key pressed: " + keycode);
        if(keycode == Input.Keys.BACK || keycode == Input.Keys.ESCAPE){
            if (inProgress) {
                endGame();
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
