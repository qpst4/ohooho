package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c3 extends wt {
    public final b3 o0;
    public final d3 p0;
    public final Runnable q0;
    public boolean r0 = false;

    public c3(d3 d3Var, b3 b3Var, Runnable runnable) {
        this.o0 = b3Var;
        this.p0 = d3Var;
        this.q0 = runnable;
    }

    public static c3 k0(y30 y30Var, d3 d3Var, b3 b3Var, c cVar) {
        c3 c3Var = new c3(d3Var, b3Var, cVar);
        c3Var.j0(y30Var, "ActionPreferenceDialogFragment");
        return c3Var;
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        FrameLayout frameLayout = (FrameLayout) v().inflate(R.layout.frame_layout, (ViewGroup) null);
        jl1 jl1Var = new jl1(o());
        jl1Var.m(R.string.action_picker_extra_configs_dialog_title);
        ((x6) jl1Var.c).u = frameLayout;
        jl1Var.k(R.string.dialog_button_done, new z2(0, this));
        int i = 5;
        jl1Var.h(R.string.dialog_button_cancel, new g2(i));
        if (this.q0 != null) {
            jl1Var.i(R.string.dialog_button_test, new g2(i));
        }
        b7 b7VarC = jl1Var.c();
        b7VarC.setOnShowListener(new h2(this, 1));
        return b7VarC;
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.r0) {
            this.o0.b(this.p0.Z.b());
        }
        super.onDismiss(dialogInterface);
    }
}
