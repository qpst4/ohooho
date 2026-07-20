package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.provider.Settings;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kh extends wt {
    public final Runnable o0;
    public LinearLayout p0;
    public EditText q0;
    public EditText r0;
    public int s0 = Integer.MAX_VALUE;
    public int t0 = Integer.MIN_VALUE;
    public final jh u0 = new jh(this, new Handler());

    public kh(Runnable runnable) {
        this.o0 = runnable;
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        LinearLayout linearLayout = (LinearLayout) v().inflate(R.layout.brightness_calibrate_dialog_fragment_layout, (ViewGroup) null);
        this.p0 = linearLayout;
        this.q0 = (EditText) linearLayout.findViewById(R.id.minInput);
        this.r0 = (EditText) this.p0.findViewById(R.id.maxInput);
        jl1 jl1Var = new jl1(o());
        jl1Var.m(R.string.brightness_calibrate_dialog_title);
        ((x6) jl1Var.c).u = this.p0;
        jl1Var.k(R.string.dialog_button_save, new z2(2, this));
        jl1Var.h(R.string.dialog_button_cancel, null);
        b7 b7VarC = jl1Var.c();
        t().getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), false, this.u0);
        EditText editText = this.q0;
        StringBuilder sb = new StringBuilder();
        int i = gh.I;
        int iC = oq0.c((SharedPreferences) pn0.t().d, oq0.V0);
        if (iC == -2) {
            iC = 1;
        }
        sb.append(iC);
        sb.append("");
        editText.setText(sb.toString());
        EditText editText2 = this.r0;
        StringBuilder sb2 = new StringBuilder();
        int iC2 = oq0.c((SharedPreferences) pn0.t().d, oq0.W0);
        if (iC2 == -2) {
            iC2 = gh.I;
        }
        sb2.append(iC2);
        sb2.append("");
        editText2.setText(sb2.toString());
        return b7VarC;
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        try {
            t().getContentResolver().unregisterContentObserver(this.u0);
        } catch (Exception unused) {
        }
        this.o0.run();
        super.onDismiss(dialogInterface);
    }
}
