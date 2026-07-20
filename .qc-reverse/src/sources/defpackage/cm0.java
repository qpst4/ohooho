package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cm0 {
    public long a;
    public TimeInterpolator c = null;
    public int d = 0;
    public int e = 1;
    public long b = 150;

    public cm0(long j) {
        this.a = j;
    }

    public final void a(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay(this.a);
        objectAnimator.setDuration(this.b);
        objectAnimator.setInterpolator(b());
        objectAnimator.setRepeatCount(this.d);
        objectAnimator.setRepeatMode(this.e);
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : s7.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cm0)) {
            return false;
        }
        cm0 cm0Var = (cm0) obj;
        if (this.a == cm0Var.a && this.b == cm0Var.b && this.d == cm0Var.d && this.e == cm0Var.e) {
            return b().getClass().equals(cm0Var.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        long j2 = this.b;
        return ((((b().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "\n" + cm0.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.a + " duration: " + this.b + " interpolator: " + b().getClass() + " repeatCount: " + this.d + " repeatMode: " + this.e + "}\n";
    }
}
