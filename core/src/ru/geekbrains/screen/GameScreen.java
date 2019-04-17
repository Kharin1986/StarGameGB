//package ru.geekbrains.screen;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.TextureAtlas;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import ru.geekbrains.base.BaseScreen;
//import ru.geekbrains.math.Rect;
//import ru.geekbrains.sprite.Background;
//import ru.geekbrains.sprite.SpaceShip;
//import ru.geekbrains.sprite.Star;
//
//public class GameScreen extends BaseScreen {
//
//    private SpaceShip spaceShip;
//    private TextureAtlas mainAtlas;
//
//    private Texture bg;
//    private Background background;
//    private TextureAtlas atlas;
//
//    private Star starList[];
//
//    public GameScreen() {
//    }
//
//    @Override
//    public void show() {
//        super.show();
//        mainAtlas = new TextureAtlas("textures/mainAtlas.tpack");
//        spaceShip=new SpaceShip(mainAtlas);
//        bg = new Texture("textures/bg.png");
//        background = new Background(new TextureRegion(bg));
//        atlas = new TextureAtlas("textures/menuAtlas.tpack");
//        starList = new Star[256];
//        for (int i = 0; i < starList.length; i++) {
//            starList[i] = new Star(atlas);
//        }
//    }
//
//    @Override
//    public void resize(Rect worldBounds) {
//        super.resize(worldBounds);
//        spaceShip.resize(worldBounds);
//        background.resize(worldBounds);
//        for (Star star : starList) {
//            star.resize(worldBounds);
//        }
//    }
//
//    @Override
//    public void render(float delta) {
//        super.render(delta);
//        update(delta);
//        draw();
//    }
//
//    private void update(float delta) {
//        for (Star star : starList) {
//            star.update(delta);
//        }
//    }
//
//    private void draw() {
//
//        batch.begin();
//        background.draw(batch);
//        spaceShip.draw(batch);
//        for (Star star : starList) {
//            star.draw(batch);
//        }
//        batch.end();
//    }
//
//    @Override
//    public void dispose() {
//        super.dispose();
//        mainAtlas.dispose();
//        bg.dispose();
//        atlas.dispose();
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }
//}