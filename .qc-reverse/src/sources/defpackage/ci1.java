package defpackage;

import android.os.Build;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ci1 {
    public bi1 a;

    public ci1(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new ai1(e0.l(i, interpolator, j));
        } else {
            this.a = new yh1(i, interpolator, j);
        }
    }
}
