package defpackage;

import android.graphics.drawable.Drawable;
import com.quickcursor.App;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v91 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public boolean f;
    public final h91 g;
    public final double h;
    public final double i;
    public final Drawable j;
    public final boolean k;

    public v91(int i, float f, float f2, h91 h91Var, boolean z, boolean z2) {
        float f3 = (i * f) + f2;
        this.a = f3;
        this.b = (f * h91Var.i()) + f3;
        double radians = Math.toRadians((((r4 - f3) / 2.0f) + f3) % 360.0f);
        this.h = Math.cos(radians);
        this.i = Math.sin(radians);
        if (z) {
            this.a = f2 - 90.0f;
        }
        if (z2) {
            this.b = 270.0f + f2;
        }
        float f4 = this.b;
        float f5 = this.a;
        this.c = f4 - f5;
        this.e = (f5 + 90.0f) - f2;
        this.d = (f4 + 90.0f) - f2;
        this.g = h91Var;
        this.f = false;
        Drawable drawableD = h91Var.b() == n3.nothing ? null : h91Var.d(App.c);
        this.j = drawableD;
        this.k = true;
        if (drawableD == null || drawableD.getLevel() != 2) {
            return;
        }
        this.k = false;
    }
}
