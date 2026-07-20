package defpackage;

import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i20 implements Comparator {
    public final Rect b = new Rect();
    public final Rect c = new Rect();
    public final boolean d;
    public final ix e;

    public i20(ix ixVar, boolean z) {
        this.d = z;
        this.e = ixVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.e.getClass();
        Rect rect = this.b;
        ((n0) obj).f(rect);
        Rect rect2 = this.c;
        ((n0) obj2).f(rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        boolean z = this.d;
        if (i3 < i4) {
            return z ? 1 : -1;
        }
        if (i3 > i4) {
            return z ? -1 : 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            return z ? 1 : -1;
        }
        if (i7 > i8) {
            return z ? -1 : 1;
        }
        return 0;
    }
}
