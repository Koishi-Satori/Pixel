package top.kkoishi.stg.env;

import top.kkoishi.stg.object.Bullet;
import top.kkoishi.stg.object.RenderAccess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * @author KKoishi_
 */
public class Stage implements RenderAccess {

    public static final class EmptyStage extends Stage {

        final Graphics g = GraphicsManager.instance.get().create();

        private EmptyStage (BufferedImage bi) {
            super(bi);
        }

        public EmptyStage () {
            this(null);
            g.setColor(Color.WHITE);
        }

        @Override
        public void render () {
            g.fillRect(0, 0, StageManager.displayWidth, StageManager.displayHeight);
        }

        @Override
        public void partRender (int x, int y, int w, int h) {
            g.fillRect(x, y, w, h);
        }
    }

    protected final BufferedImage bi;

    protected Stage (BufferedImage bi) {
        this.bi = bi;
    }

    public Image getBackground () {
        return bi;
    }

    @Override
    public long uuid () {
        return 0;
    }

    @Override
    public String name () {
        return null;
    }

    @Override
    public void render () {
        GraphicsManager.instance.get().drawImage(bi, 0, 0, null);
    }

    public void draw (Graphics g) {
        g.drawImage(bi, 0, 0, null);
    }

    @Override
    public int renderType () {
        return RenderAccess.BACKGROUND;
    }

    @Override
    @Deprecated
    public void prepareRepaint () {
        throw new UnsupportedOperationException();
    }

    public void partRender (int x, int y, int w, int h) {
        final Graphics g = GraphicsManager.instance.get();
        g.drawImage(bi, x, y, w, h, null);
    }

    @Override
    public String toString () {
        return "Stage[@" + super.hashCode() + "]{" +
                "background=" + bi +
                '}';
    }
}
