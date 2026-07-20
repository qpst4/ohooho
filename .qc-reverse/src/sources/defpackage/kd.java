package defpackage;

import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kd {
    public final float a;
    public final float b;
    public final float c;
    public final int d;

    public kd(BackEvent backEvent) {
        u7 u7Var = u7.a;
        float fD = u7Var.d(backEvent);
        float fE = u7Var.e(backEvent);
        float fB = u7Var.b(backEvent);
        int iC = u7Var.c(backEvent);
        this.a = fD;
        this.b = fE;
        this.c = fB;
        this.d = iC;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.a + ", touchY=" + this.b + ", progress=" + this.c + ", swipeEdge=" + this.d + '}';
    }
}
