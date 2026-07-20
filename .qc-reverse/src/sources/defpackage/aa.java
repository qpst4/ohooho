package defpackage;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class aa extends i1 {
    public final /* synthetic */ int p;
    public final /* synthetic */ int q;
    public final /* synthetic */ WeakReference r;
    public final /* synthetic */ fa s;

    public aa(fa faVar, int i, int i2, WeakReference weakReference) {
        super(19);
        this.s = faVar;
        this.p = i;
        this.q = i2;
        this.r = weakReference;
    }

    @Override // defpackage.i1
    public final void H(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.p) != -1) {
            typeface = ea.a(typeface, i, (this.q & 2) != 0);
        }
        fa faVar = this.s;
        if (faVar.m) {
            faVar.l = typeface;
            TextView textView = (TextView) this.r.get();
            if (textView != null) {
                boolean zIsAttachedToWindow = textView.isAttachedToWindow();
                int i2 = faVar.j;
                if (zIsAttachedToWindow) {
                    textView.post(new ba(textView, typeface, i2));
                } else {
                    textView.setTypeface(typeface, i2);
                }
            }
        }
    }

    @Override // defpackage.i1
    public final void G(int i) {
    }
}
