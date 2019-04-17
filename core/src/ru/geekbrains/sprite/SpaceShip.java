package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class SpaceShip extends Sprite {
    public SpaceShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship0"));
        setHeightProportion(0.15f); //унаследовано от Sprite
    }
    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + 0.02f);
    }
}
