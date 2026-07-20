package defpackage;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yn0 implements OnBackAnimationCallback {
    public final /* synthetic */ v40 a;
    public final /* synthetic */ v40 b;
    public final /* synthetic */ k40 c;
    public final /* synthetic */ k40 d;

    public yn0(v40 v40Var, v40 v40Var2, k40 k40Var, k40 k40Var2) {
        this.a = v40Var;
        this.b = v40Var2;
        this.c = k40Var;
        this.d = k40Var2;
    }

    public final void onBackCancelled() {
        this.d.a();
    }

    public final void onBackInvoked() {
        this.c.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        backEvent.getClass();
        this.b.g(new kd(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        backEvent.getClass();
        this.a.g(new kd(backEvent));
    }
}
