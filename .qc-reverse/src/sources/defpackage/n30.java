package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n30 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ a b;
    public final /* synthetic */ o30 c;

    public n30(o30 o30Var, a aVar) {
        this.c = o30Var;
        this.b = aVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        a aVar = this.b;
        j30 j30Var = aVar.c;
        aVar.k();
        xs.f((ViewGroup) j30Var.H.getParent(), this.c.b.G()).e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
