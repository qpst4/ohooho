package defpackage;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.quickcursor.App;
import com.quickcursor.android.drawables.globals.EdgeActionsDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sw {
    public final Rect a;
    public final RectF b;
    public final Rect c;
    public final i9 d;
    public final Point e;
    public final Drawable f;
    public final int g;
    public final Paint h;
    public final Paint i;
    public final Paint j;
    public float k;

    public sw(EdgeActionsDrawable edgeActionsDrawable, RectF rectF, Rect rect, i9 i9Var, Point point, lw lwVar) {
        float fHeight;
        this.b = rectF;
        this.c = rect;
        this.d = i9Var;
        this.e = point;
        this.f = lwVar.d(App.c);
        int iIntValue = lwVar.i() == null ? edgeActionsDrawable.b : lwVar.i().intValue();
        this.g = iIntValue;
        this.k = 0.0f;
        Paint paint = new Paint(1);
        this.i = paint;
        paint.setStrokeWidth(0.0f);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(iIntValue);
        Paint paint2 = new Paint(1);
        this.h = paint2;
        paint2.setStrokeWidth(0.0f);
        paint2.setStyle(style);
        paint2.setColor(iIntValue);
        Paint paint3 = new Paint(1);
        this.j = paint3;
        paint3.setStrokeWidth(0.0f);
        paint3.setStyle(style);
        paint3.setColor(iIntValue);
        RadialGradient radialGradient = new RadialGradient(rect.centerX(), rect.centerY(), Math.max(rect.width(), rect.height()) / 2.0f, iIntValue, 0, Shader.TileMode.CLAMP);
        float fWidth = 1.0f;
        if (rect.bottom == 0 || rect.top == ey0.b()) {
            fHeight = (rect.height() * 1.0f) / rect.width();
        } else {
            fWidth = (rect.width() * 1.0f) / rect.height();
            fHeight = 1.0f;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fWidth, fHeight);
        int i = rect.bottom;
        int i2 = rect.top;
        if (i == 0) {
            matrix.postTranslate(0.0f, ((i - i2) / 2.0f) * fHeight);
        } else if (i2 == ey0.b()) {
            matrix.postTranslate(0.0f, (((ey0.b() * (-1.0f)) * fHeight) + ey0.b()) - ((rect.bottom - rect.top) * fHeight));
        } else {
            if (rect.right == 0) {
                matrix.postTranslate((r12 - rect.left) * fWidth, 0.0f);
            } else {
                matrix.postTranslate((((ey0.c() * (-1.0f)) * fWidth) + ey0.c()) - ((rect.right - rect.left) * fWidth), 0.0f);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        this.a = new Rect(rect.left - rect.width(), rect.top - rect.height(), rect.width() + rect.right, rect.height() + rect.bottom);
    }
}
