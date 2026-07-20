package defpackage;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xt implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final Object c;
    public final /* synthetic */ Object d;

    public xt(b71 b71Var) {
        this.b = 2;
        this.d = b71Var;
        Context context = b71Var.a.getContext();
        CharSequence charSequence = b71Var.h;
        u1 u1Var = new u1();
        u1Var.e = 4096;
        u1Var.g = 4096;
        u1Var.l = null;
        u1Var.m = null;
        u1Var.n = false;
        u1Var.o = false;
        u1Var.p = 16;
        u1Var.i = context;
        u1Var.a = charSequence;
        this.c = u1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        Object obj = this.c;
        Object obj2 = this.d;
        switch (i) {
            case 0:
                ((i9) obj).E(ta0.c);
                ((b7) obj2).dismiss();
                break;
            case 1:
                ((i9) obj).E(ta0.b);
                ((b7) obj2).dismiss();
                break;
            default:
                b71 b71Var = (b71) obj2;
                Window.Callback callback = b71Var.k;
                if (callback != null && b71Var.l) {
                    callback.onMenuItemSelected(0, (u1) obj);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ xt(i9 i9Var, b7 b7Var, int i) {
        this.b = i;
        this.c = i9Var;
        this.d = b7Var;
    }
}
