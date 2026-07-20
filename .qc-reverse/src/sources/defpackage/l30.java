package defpackage;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l30 extends f01 implements fg1, gg0, rx0, b40 {
    public final z7 m;
    public final z7 n;
    public final Handler o;
    public final y30 p;
    public final /* synthetic */ z7 q;

    public l30(z7 z7Var) {
        this.q = z7Var;
        Handler handler = new Handler();
        this.p = new y30();
        this.m = z7Var;
        this.n = z7Var;
        this.o = handler;
    }

    @Override // defpackage.f01
    public final View F(int i) {
        return this.q.findViewById(i);
    }

    @Override // defpackage.f01
    public final boolean G() {
        Window window = this.q.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // defpackage.rx0
    public final e8 c() {
        return (e8) this.q.e.c;
    }

    @Override // defpackage.fg1
    public final eg1 m() {
        return this.q.m();
    }

    @Override // defpackage.gg0
    public final a p() {
        return this.q.v;
    }

    @Override // defpackage.b40
    public final void a() {
    }
}
