package defpackage;

import android.view.WindowInsetsAnimation;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ai1 extends bi1 {
    public final WindowInsetsAnimation e;

    public ai1(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.e = windowInsetsAnimation;
    }

    @Override // defpackage.bi1
    public final long a() {
        return this.e.getDurationMillis();
    }

    @Override // defpackage.bi1
    public final float b() {
        return this.e.getInterpolatedFraction();
    }

    @Override // defpackage.bi1
    public final int c() {
        return this.e.getTypeMask();
    }

    @Override // defpackage.bi1
    public final void d(float f) {
        this.e.setFraction(f);
    }
}
