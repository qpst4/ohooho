package defpackage;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a51 {
    public float c;
    public float d;
    public final WeakReference f;
    public x41 g;
    public final TextPaint a = new TextPaint(1);
    public final ek b = new ek(1, this);
    public boolean e = true;

    public a51(z41 z41Var) {
        this.f = new WeakReference(null);
        this.f = new WeakReference(z41Var);
    }

    public final void a(String str) {
        TextPaint textPaint = this.a;
        this.c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.e = false;
    }

    public final void b(x41 x41Var, Context context) {
        if (this.g != x41Var) {
            this.g = x41Var;
            WeakReference weakReference = this.f;
            if (x41Var != null) {
                TextPaint textPaint = this.a;
                ek ekVar = this.b;
                x41Var.f(context, textPaint, ekVar);
                z41 z41Var = (z41) weakReference.get();
                if (z41Var != null) {
                    textPaint.drawableState = z41Var.getState();
                }
                x41Var.e(context, textPaint, ekVar);
                this.e = true;
            }
            z41 z41Var2 = (z41) weakReference.get();
            if (z41Var2 != null) {
                z41Var2.a();
                z41Var2.onStateChange(z41Var2.getState());
            }
        }
    }
}
