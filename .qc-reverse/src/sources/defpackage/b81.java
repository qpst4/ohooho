package defpackage;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b81 extends TrackerDrawable {
    public final Paint L;
    public int M;
    public int N;
    public float O;
    public float P;

    public b81() {
        Paint paint = new Paint(1);
        this.L = paint;
        paint.setColor(-16777216);
        paint.setStrokeWidth(0.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        o();
    }

    @Override // com.quickcursor.android.drawables.globals.trackers.TrackerDrawable
    public final void i(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(this.i, this.j, Math.max(0.01f, this.h * this.O), i1.e(this.M, Math.min(this.g * 1.25f, 1.0f) * (1.0f - this.f)), i1.e(this.N, (1.0f - this.f) * this.g), Shader.TileMode.MIRROR);
        Paint paint = this.L;
        paint.setShader(radialGradient);
        float f = this.h;
        float f2 = f * this.P;
        int i = this.i;
        int i2 = this.j;
        canvas.drawRoundRect(i - f, i2 - f, i + f, i2 + f, f2, f2, paint);
    }

    @Override // com.quickcursor.android.drawables.globals.trackers.TrackerDrawable
    public final void o() {
        super.o();
        this.M = oq0.c((SharedPreferences) pn0.t().d, oq0.E);
        this.N = oq0.c((SharedPreferences) pn0.t().d, oq0.F);
        this.P = oq0.c((SharedPreferences) pn0.t().d, oq0.J) / 100.0f;
        this.O = Math.max(0.01f, oq0.c((SharedPreferences) pn0.t().d, oq0.H) / 100.0f);
    }
}
