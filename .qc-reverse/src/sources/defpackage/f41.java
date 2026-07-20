package defpackage;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f41 {
    public int a;
    public int b;
    public int c;
    public Object d;

    public f41() {
        if (ow0.j == null) {
            ow0.j = new ow0(28);
        }
    }

    public int a(int i) {
        if (i < this.c) {
            return ((ByteBuffer) this.d).getShort(this.b + i);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public void d(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.b) {
            c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.a);
            if (!((Class) this.d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateD = uf1.d(view);
            y yVar = accessibilityDelegateD != null ? accessibilityDelegateD instanceof x ? ((x) accessibilityDelegateD).a : new y(accessibilityDelegateD) : null;
            if (yVar == null) {
                yVar = new y();
            }
            uf1.n(view, yVar);
            view.setTag(this.a, obj);
            uf1.h(view, this.c);
        }
    }

    public abstract boolean e(Object obj, Object obj2);
}
