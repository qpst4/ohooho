package defpackage;

import android.animation.ObjectAnimator;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.quickcursor.R;
import com.quickcursor.android.drawables.globals.cursors.CursorBitmapDrawable;
import com.quickcursor.android.drawables.globals.cursors.CursorDesignQuickCursorDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yq extends Drawable implements s60 {
    public int b;
    public int c;
    public Pair d;

    public static boolean i(ObjectAnimator objectAnimator) {
        return objectAnimator != null && objectAnimator.isStarted();
    }

    public static yq j(int i) {
        switch (l11.r(i)) {
            case 0:
                return new CursorDesignQuickCursorDrawable();
            case 1:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow1), 0.032f, 0.025f);
            case 2:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow2), 0.0992f, 0.04f);
            case 3:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow3), 0.03f, 0.03f);
            case 4:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow4), 0.0977f, 0.035f);
            case 5:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow5), 0.046f, 0.03f);
            case 6:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow6), 0.02f, 0.01f);
            case 7:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow7), 0.43f, 0.43f);
            case 8:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow8), 0.5f, 0.01f);
            case 9:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow9), 0.02f, 0.01f);
            case 10:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow10), 0.01f, 0.0f);
            case 11:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow11), 0.5f, 0.0f);
            case 12:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow12), 0.149f, 0.09f);
            case 13:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow13), 0.288f, 0.292f);
            case 14:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow14), 0.589f, 0.181f);
            case 15:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow15), 0.02f, 0.0214f);
            case 16:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow16), 0.01f, 0.01f);
            case 17:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow17), 0.0279f, 0.0279f);
            case 18:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow18), 0.244f, 0.243f);
            case 19:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_arrow19), 0.5f, 0.0f);
            case 20:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_hand1), 0.385f, 0.04f);
            case 21:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_hand2), 0.265f, 0.05f);
            case 22:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_hand3), 0.4444f, 0.0222f);
            case 23:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_hand4), 0.371f, 0.0229f);
            case 24:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_hand5), 0.259f, 0.0179f);
            case 25:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_hand6), 0.4223f, 0.0233f);
            case 26:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair1), 0.5f, 0.5f);
            case 27:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair2), 0.5f, 0.5f);
            case 28:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair3), 0.5f, 0.5f);
            case 29:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair4), 0.5f, 0.5f);
            case 30:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair5), 0.5f, 0.5f);
            case 31:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair6), 0.5f, 0.5f);
            case 32:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair7), 0.5f, 0.5f);
            case 33:
                return new CursorBitmapDrawable(lc1.v(R.drawable.cursor_design_crosshair8), 0.5f, 0.5f);
            case 34:
                return new CursorBitmapDrawable(pn0.t().p(), ((Float) pn0.t().r().first).floatValue(), ((Float) pn0.t().r().second).floatValue());
            default:
                return new CursorDesignQuickCursorDrawable();
        }
    }

    public abstract void f();

    public abstract int g();

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public abstract void h();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
