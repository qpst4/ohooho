package defpackage;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x71 extends TrackerDrawable {
    public final Bitmap L;
    public final boolean M;
    public final boolean N;
    public final Paint O = new Paint(3);
    public final RectF P = new RectF();
    public final Rect Q;
    public float R;

    public x71(Bitmap bitmap, boolean z, boolean z2) {
        this.L = bitmap;
        this.M = z2;
        this.N = z;
        this.Q = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        o();
    }

    @Override // com.quickcursor.android.drawables.globals.trackers.TrackerDrawable
    public final void i(Canvas canvas) {
        int i = (int) ((1.0f - this.f) * this.g * this.R * 255.0f);
        Paint paint = this.O;
        paint.setAlpha(i);
        int i2 = this.i;
        int i3 = this.h;
        float f = i2 - i3;
        int i4 = this.j;
        float f2 = i4 - i3;
        float f3 = i2 + i3;
        float f4 = i4 + i3;
        RectF rectF = this.P;
        rectF.set(f, f2, f3, f4);
        canvas.drawBitmap(this.L, this.Q, rectF, paint);
    }

    @Override // com.quickcursor.android.drawables.globals.trackers.TrackerDrawable
    public final void o() {
        super.o();
        boolean z = this.M;
        Paint paint = this.O;
        if (z) {
            paint.setColorFilter(new PorterDuffColorFilter(oq0.c((SharedPreferences) pn0.t().d, oq0.K), PorterDuff.Mode.SRC_IN));
        } else {
            paint.setColorFilter(null);
        }
        this.R = this.N ? oq0.c((SharedPreferences) pn0.t().d, oq0.G) / 100.0f : 1.0f;
    }
}
