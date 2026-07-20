package defpackage;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class li extends fp1 {
    public final Typeface f;
    public final sp1 g;
    public boolean h;

    public li(sp1 sp1Var, Typeface typeface) {
        this.f = typeface;
        this.g = sp1Var;
    }

    @Override // defpackage.fp1
    public final void v(int i) {
        if (this.h) {
            return;
        }
        gl glVar = (gl) this.g.c;
        if (glVar.j(this.f)) {
            glVar.h(false);
        }
    }

    @Override // defpackage.fp1
    public final void w(Typeface typeface, boolean z) {
        if (this.h) {
            return;
        }
        gl glVar = (gl) this.g.c;
        if (glVar.j(typeface)) {
            glVar.h(false);
        }
    }
}
