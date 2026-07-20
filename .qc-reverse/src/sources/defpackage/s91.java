package defpackage;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s91 extends Drawable implements s60 {
    public f91 b;
    public u91 c;
    public int d;
    public int e;
    public int f;
    public int g;

    public void f() {
        this.b = null;
    }

    public abstract void g(f91 f91Var, u91 u91Var, int i, int i2);

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
