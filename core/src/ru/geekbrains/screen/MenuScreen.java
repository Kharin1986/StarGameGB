package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Vector2 touch;
    private Vector2 pos;
    private Vector2 tmpPos;
    private Vector2 v;
    private Texture img;
    private final int STEPS = 240;
    private int i;


    @Override
    public void show() {
        super.show();
        pos = new Vector2();

        tmpPos = new Vector2();
        img = new Texture("badlogic.jpg");
    }
    @Override
    public void render(float delta) {
        super.render(delta);
        // Случай с нажатием ЛКМ
        if (touch != null && v != null) { // Если touch и v существуют одновременно
            if (i <= 0) { // Если все шаги пройдены
                v.set(0,0);
                v = null;
                touch = null;// то мы удаляем вектор нажатия и вектор скорости
            } else {
                i--;
            } // Если шаги не пройдены -  вычитаем шаг
        } // поле этого меняем позицию картинки
        if (v != null) {
            pos.add(v);
        }
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch = new Vector2();
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println(touch.x+" "+touch.y);
        tmpPos.set(pos.x, pos.y);
        v = new Vector2();
        v.set((touch.x-tmpPos.x)/STEPS,(touch.y-tmpPos.y)/STEPS);// только в случае нажатия устанавливаем скорость
        i=STEPS;// устанавливаем обратный отсчет при нажатии
        return true;
    }
}
