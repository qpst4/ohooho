package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.quickcursor.android.drawables.globals.progressbar.ProgressBarDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o80 extends ProgressBarDrawable implements s60 {
    public static final /* synthetic */ int u = 0;
    public static final /* synthetic */ int v = 0;
    public final /* synthetic */ int s;
    public float t;

    public /* synthetic */ o80(int i) {
        this.s = i;
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        int i = this.s;
        int i2 = ProgressBarDrawable.o;
        int i3 = this.l;
        float f = ProgressBarDrawable.p;
        int i4 = this.k;
        int i5 = this.j;
        Paint paint = this.c;
        Paint paint2 = this.b;
        switch (i) {
            case 0:
                float f2 = this.g;
                if (f2 != 0.0f) {
                    paint.setColor(i1.e(i5, f2));
                    paint2.setColor(i1.e(i4, this.g));
                    RectF rectF = this.e;
                    float f3 = ProgressBarDrawable.m;
                    canvas.drawRoundRect(rectF, f3, f3, paint);
                    canvas.drawRoundRect(this.e, f3, f3, paint2);
                    float f4 = (this.h * this.t) + this.e.left + f;
                    int iE = i1.e(i3, this.g);
                    Paint paint3 = this.d;
                    paint3.setColor(iE);
                    RectF rectF2 = this.e;
                    canvas.drawRoundRect(rectF2.left, rectF2.top, f4, rectF2.bottom, f3, f3, paint3);
                    if (this.i != null) {
                        int iHeight = (int) ((this.e.height() - i2) / 2.0f);
                        int i6 = ((int) f4) - ((int) ((f - i2) / 2.0f));
                        this.i.setAlpha((int) (this.g * 255.0f));
                        RectF rectF3 = this.e;
                        this.i.setBounds(i6 - i2, ((int) rectF3.top) + iHeight, i6, ((int) rectF3.bottom) - iHeight);
                        this.i.draw(canvas);
                    }
                    break;
                }
                break;
            default:
                float f5 = this.g;
                if (f5 != 0.0f) {
                    paint.setColor(i1.e(i5, f5));
                    paint2.setColor(i1.e(i4, this.g));
                    RectF rectF4 = this.e;
                    float f6 = ProgressBarDrawable.m;
                    canvas.drawRoundRect(rectF4, f6, f6, paint);
                    canvas.drawRoundRect(this.e, f6, f6, paint2);
                    float f7 = (this.e.bottom - f) - (this.h * this.t);
                    int iE2 = i1.e(i3, this.g);
                    Paint paint4 = this.d;
                    paint4.setColor(iE2);
                    RectF rectF5 = this.e;
                    canvas.drawRoundRect(rectF5.left, f7, rectF5.right, rectF5.bottom, f6, f6, paint4);
                    if (this.i != null) {
                        int iWidth = (int) ((this.e.width() - i2) / 2.0f);
                        int i7 = ((int) f7) + ((int) ((f - i2) / 2.0f));
                        this.i.setAlpha((int) (this.g * 255.0f));
                        Drawable drawable = this.i;
                        RectF rectF6 = this.e;
                        drawable.setBounds(((int) rectF6.left) + iWidth, i7, (int) (rectF6.right - iWidth), i2 + i7);
                        this.i.draw(canvas);
                    }
                    break;
                }
                break;
        }
    }

    @Override // com.quickcursor.android.drawables.globals.progressbar.ProgressBarDrawable
    public void g(Drawable drawable, float f) {
        switch (this.s) {
            case 0:
                float fB = (int) (ey0.b() * 0.1f);
                RectF rectF = new RectF((int) (ey0.c() * 0.125f), fB, ey0.c() - r1, ProgressBarDrawable.n + fB);
                this.e = rectF;
                this.t = rectF.width() - ProgressBarDrawable.p;
                super.g(drawable, f);
                break;
            default:
                super.g(drawable, f);
                break;
        }
    }
}
