package defpackage;

import android.graphics.drawable.Drawable;
import com.quickcursor.App;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d81 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final double f;
    public final double g;
    public boolean h;
    public final Drawable i;
    public final boolean j;

    public d81(TrackerDrawable trackerDrawable, float f, float f2, j71 j71Var) {
        this.a = f;
        this.b = f2;
        this.c = f2 - f;
        float f3 = trackerDrawable.q;
        this.e = f - f3;
        this.d = f2 - f3;
        double radians = Math.toRadians(((r0 / 2.0f) + f) % 360.0f);
        this.f = Math.cos(radians);
        this.g = Math.sin(radians);
        this.h = false;
        Drawable drawableD = (j71Var == null || j71Var.b() == n3.nothing) ? null : j71Var.d(App.c);
        this.i = drawableD;
        this.j = true;
        if (drawableD == null || drawableD.getLevel() != 2) {
            return;
        }
        this.j = false;
    }
}
