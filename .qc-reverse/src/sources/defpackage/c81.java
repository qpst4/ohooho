package defpackage;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c81 extends TrackerDrawable {
    public final Path L = new Path();
    public final Paint M;
    public int N;
    public int O;
    public float P;
    public int Q;

    public c81() {
        Paint paint = new Paint(1);
        this.M = paint;
        paint.setColor(-16777216);
        paint.setStrokeWidth(0.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        o();
    }

    @Override // com.quickcursor.android.drawables.globals.trackers.TrackerDrawable
    public final void i(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(this.i, this.j, Math.max(0.01f, this.h * this.P), i1.e(this.N, Math.min(this.g * 1.25f, 1.0f) * (1.0f - this.f)), i1.e(this.O, (1.0f - this.f) * this.g), Shader.TileMode.MIRROR);
        Paint paint = this.M;
        paint.setShader(radialGradient);
        Path path = this.L;
        path.reset();
        float f = this.h;
        float f2 = (1.0f - (this.Q * 0.0045f)) * f;
        path.moveTo(this.i, this.j - f);
        int i = this.i;
        int i2 = this.j;
        path.cubicTo(i + f2, i2 - f, i + f, i2 - f2, i + f, i2);
        int i3 = this.i;
        int i4 = this.j;
        path.cubicTo(i3 + f, i4 + f2, i3 + f2, i4 + f, i3, i4 + f);
        int i5 = this.i;
        int i6 = this.j;
        path.cubicTo(i5 - f2, i6 + f, i5 - f, i6 + f2, i5 - f, i6);
        int i7 = this.i;
        int i8 = this.j;
        path.cubicTo(i7 - f, i8 - f2, i7 - f2, i8 - f, i7, i8 - f);
        path.close();
        canvas.drawPath(path, paint);
    }

    @Override // com.quickcursor.android.drawables.globals.trackers.TrackerDrawable
    public final void o() {
        super.o();
        this.N = oq0.c((SharedPreferences) pn0.t().d, oq0.E);
        this.O = oq0.c((SharedPreferences) pn0.t().d, oq0.F);
        this.Q = oq0.c((SharedPreferences) pn0.t().d, oq0.I);
        this.P = Math.max(0.01f, oq0.c((SharedPreferences) pn0.t().d, oq0.H) / 100.0f);
    }
}
