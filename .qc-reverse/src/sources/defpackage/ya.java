package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ya extends wt {
    public final d30 A0;
    public final int o0;
    public final xa p0;
    public View q0;
    public y2 r0;
    public RecyclerView s0;
    public Object t0;
    public Button u0;
    public LinearLayoutCompat v0;
    public AppCompatEditText w0;
    public final Boolean x0;
    public final Boolean y0;
    public final Set z0;

    public ya(xa xaVar, int i, Boolean bool, Boolean bool2, Set set) {
        this.t0 = null;
        this.A0 = (d30) Y(new r1(3, this), new f4(2));
        this.o0 = i;
        this.p0 = xaVar;
        this.x0 = bool;
        this.y0 = bool2;
        this.z0 = set == null ? new HashSet() : set;
    }

    @Override // defpackage.wt, defpackage.j30
    public final void T() {
        super.T();
        if (this.o0 == 0) {
            h0(true, false);
        }
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        int i;
        int i2 = 1;
        int i3 = this.o0;
        if (i3 == 0) {
            jl1 jl1Var = new jl1(o());
            ((x6) jl1Var.c).g = "Fix crash on action picker rotation";
            jl1Var.l("Ok", new g2(i2));
            return jl1Var.c();
        }
        View viewInflate = v().inflate(R.layout.app_picker_dialog_fragment_layout, (ViewGroup) null);
        this.q0 = viewInflate;
        this.s0 = (RecyclerView) viewInflate.findViewById(R.id.recycler);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.q0.findViewById(R.id.search_container);
        this.v0 = linearLayoutCompat;
        this.w0 = (AppCompatEditText) linearLayoutCompat.findViewById(R.id.search_input);
        jl1 jl1Var2 = new jl1(o());
        int iR = l11.r(i3);
        int i4 = 2;
        if (iR == 0) {
            i = R.string.dialog_app_picker_title;
        } else if (iR == 1) {
            i = R.string.dialog_icon_pack_app_picker_title;
        } else {
            if (iR != 2) {
                throw new IncompatibleClassChangeError();
            }
            i = R.string.dialog_shortcut_picker_title;
        }
        jl1Var2.m(i);
        ((x6) jl1Var2.c).u = this.q0;
        jl1Var2.h(R.string.dialog_button_cancel, null);
        jl1Var2.i(R.string.action_picker_search_button, null);
        if (i3 == 2) {
            jl1Var2.k(R.string.dialog_button_default, null);
        }
        if (this.x0.booleanValue()) {
            jl1Var2.k(R.string.dialog_button_done, null);
        }
        b7 b7VarC = jl1Var2.c();
        b7VarC.setOnShowListener(new h2(this, i4));
        this.v0.findViewById(R.id.search_close).setOnClickListener(new va(this, i2));
        this.w0.addTextChangedListener(new o2(this, i2));
        b7VarC.requestWindowFeature(1);
        Executors.newSingleThreadExecutor().execute(new k2(this, 3, new Handler(Looper.getMainLooper())));
        return b7VarC;
    }

    public final void k0() {
        this.u0.setText(R.string.action_picker_search_button);
        this.v0.setVisibility(8);
        this.w0.setText("");
        ((InputMethodManager) o().getSystemService("input_method")).hideSoftInputFromWindow(this.w0.getWindowToken(), 0);
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        xa xaVar = this.p0;
        if (xaVar == null) {
            return;
        }
        xaVar.onResult(this.t0);
        super.onDismiss(dialogInterface);
    }

    public ya() {
        this.t0 = null;
        this.A0 = (d30) Y(new r1(3, this), new f4(2));
        this.o0 = 0;
        this.p0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = null;
    }
}
