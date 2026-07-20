package defpackage;

import android.window.OnBackInvokedDispatcher;
import androidx.activity.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hm implements dg0 {
    public final /* synthetic */ a b;
    public final /* synthetic */ pm c;

    public /* synthetic */ hm(a aVar, pm pmVar) {
        this.b = aVar;
        this.c = pmVar;
    }

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        if (yf0Var == yf0.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = im.a.a(this.c);
            onBackInvokedDispatcherA.getClass();
            a aVar = this.b;
            aVar.e = onBackInvokedDispatcherA;
            aVar.e(aVar.g);
        }
    }
}
