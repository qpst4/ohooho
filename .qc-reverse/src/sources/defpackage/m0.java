package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements z00 {
    public static m0 c;
    public final Object b;

    public m0() {
        this.b = new Object();
        new Handler(Looper.getMainLooper(), new h11(0, this));
    }

    public static m0 a(boolean z, int i, int i2, int i3, int i4) {
        return new m0(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z));
    }

    @Override // defpackage.wr0
    public Object get() {
        return this.b;
    }

    public /* synthetic */ m0(Object obj) {
        this.b = obj;
    }
}
