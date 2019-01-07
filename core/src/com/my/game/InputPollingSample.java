package com.my.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InputPollingSample implements ApplicationListener {

	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		camera = new OrthographicCamera();
		viewport = new FitViewport(1080, 720, camera);
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		draw();

		batch.end();
	}

	private void draw() {
		// mouse/touch X/Y
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.input.getY();
		// buttons
		boolean leftPressed = Gdx.input.isButtonPressed(com.badlogic.gdx.Input.Buttons.LEFT);
		boolean rightPressed = Gdx.input.isButtonPressed(com.badlogic.gdx.Input.Buttons.RIGHT);

		font.draw(batch, "Mouse/Touch : x = " + mouseX + ", y = " + mouseY,
				20f,
				720 - 20f);

		font.draw(batch, leftPressed ? "Left button pressed" : "Left button not pressed",
				20f,
				720 - 50f);

		font.draw(batch, rightPressed ? "Right button pressed" : "Right button not pressed",
				20f,
				720 - 80f);

		// keys
		boolean wPressed = Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.W);
		boolean sPressed = Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.S);

		font.draw(batch, wPressed ? "W button pressed" : "W button not pressed",
				20f,
				720 - 110f);

		font.draw(batch, sPressed ? "S button pressed" : "S button not pressed",
				20f,
				720 - 140f);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
