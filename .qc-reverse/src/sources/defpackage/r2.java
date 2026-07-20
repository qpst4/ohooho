package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class r2 extends wt implements m3 {
    public boolean A0;
    public boolean B0;
    public int C0;
    public LinearLayoutCompat D0;
    public LinearLayoutCompat E0;
    public AppCompatEditText F0;
    public View G0;
    public Button H0;
    public i I0;
    public qs J0;
    public final d30 K0;
    public View o0;
    public TabLayout p0;
    public RecyclerView q0;
    public y2 r0;
    public LinearLayoutManager s0;
    public final q2 t0;
    public final ArrayList u0;
    public final ArrayList v0;
    public final ArrayList w0;
    public int x0;
    public int y0;
    public int z0;

    public r2(q2 q2Var, List list, List list2, List list3) {
        this.z0 = 0;
        this.A0 = false;
        this.B0 = false;
        this.I0 = null;
        this.K0 = (d30) Y(new j2(this), new f4(2));
        this.t0 = q2Var;
        this.v0 = k0(list2, Integer.valueOf(R.string.action_category_recommended));
        this.w0 = k0(zq0.b.c() ? new ArrayList() : list3, Integer.valueOf(R.string.action_category_free));
        this.u0 = k0(list, null);
    }

    public static ArrayList k0(List list, Integer num) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n3 n3Var = (n3) it.next();
            if (n3Var != null) {
                arrayList.add(new p2(n3Var, num));
            }
        }
        return arrayList;
    }

    public static r2 o0(y30 y30Var, List list, List list2, List list3, q2 q2Var) {
        r2 r2Var = new r2(q2Var, list, list2, list3);
        r2Var.j0(y30Var, "ActionPickerDialogFragment");
        return r2Var;
    }

    @Override // defpackage.j30
    public final void R() {
        this.F = true;
        y2 y2Var = this.r0;
        if (y2Var != null) {
            y2Var.d();
        }
    }

    @Override // defpackage.wt, defpackage.j30
    public final void T() {
        super.T();
        if (this.u0 == null) {
            h0(true, false);
        }
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        ArrayList arrayList = this.u0;
        if (arrayList == null) {
            jl1 jl1Var = new jl1(o());
            ((x6) jl1Var.c).g = "Fix crash on action picker rotation";
            jl1Var.l("Ok", new g2(i));
            return jl1Var.c();
        }
        View viewInflate = v().inflate(R.layout.action_picker_dialog_fragment_layout, (ViewGroup) null);
        this.o0 = viewInflate;
        this.p0 = (TabLayout) viewInflate.findViewById(R.id.tab_layout);
        this.q0 = (RecyclerView) this.o0.findViewById(R.id.recycler);
        this.D0 = (LinearLayoutCompat) this.o0.findViewById(R.id.tab_container);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.o0.findViewById(R.id.search_container);
        this.E0 = linearLayoutCompat;
        this.F0 = (AppCompatEditText) linearLayoutCompat.findViewById(R.id.search_input);
        this.G0 = this.D0.findViewById(R.id.search_button);
        this.H0 = null;
        this.C0 = 1;
        ArrayList arrayList2 = this.w0;
        boolean zIsEmpty = arrayList2.isEmpty();
        ArrayList arrayList3 = this.v0;
        if (!zIsEmpty) {
            this.C0 = 3;
        } else if (!arrayList3.isEmpty()) {
            this.C0 = 2;
        }
        jl1 jl1Var2 = new jl1(o());
        ((x6) jl1Var2.c).u = this.o0;
        jl1Var2.h(R.string.dialog_button_cancel, null);
        int i = 5;
        if (this.C0 != 1) {
            jl1Var2.i(R.string.action_picker_more_actions_button, new g2(i));
        } else {
            jl1Var2.i(R.string.action_picker_search_button, new g2(i));
        }
        b7 b7VarC = jl1Var2.c();
        b7VarC.requestWindowFeature(1);
        b7VarC.setOnShowListener(new h2(this, i));
        b7VarC.getWindow().setSoftInputMode(16);
        this.E0.findViewById(R.id.search_close).setOnClickListener(new i2(this, 0));
        this.G0.setOnClickListener(new i2(this, 1));
        this.F0.addTextChangedListener(new o2(this, i));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        this.s0 = linearLayoutManager;
        this.q0.setLayoutManager(linearLayoutManager);
        this.q0.h(new n2(i, this));
        this.p0.a(new m2(this, new l2(u(), 0)));
        int iR = l11.r(this.C0);
        if (iR == 1) {
            arrayList = arrayList3;
        } else if (iR == 2) {
            arrayList = arrayList2;
        }
        n0(arrayList);
        this.G0.setVisibility(this.C0 != 1 ? 8 : 0);
        return b7VarC;
    }

    public final void l0() {
        this.H0.setText(R.string.action_picker_search_button);
        this.D0.setVisibility(0);
        this.E0.setVisibility(8);
        this.F0.setText("");
        ((InputMethodManager) o().getSystemService("input_method")).hideSoftInputFromWindow(this.F0.getWindowToken(), 0);
    }

    public final void m0() {
        this.H0.setText(R.string.action_picker_close_search_button);
        this.D0.setVisibility(8);
        this.E0.setVisibility(0);
        this.F0.requestFocus();
        this.F0.postDelayed(new c(3, this), 100L);
    }

    @Override // defpackage.m3
    public final void n(Intent intent, e4 e4Var) {
        this.J0 = (qs) e4Var;
        this.K0.a(intent);
    }

    public final void n0(ArrayList arrayList) {
        y2 y2Var = new y2(t(), arrayList, this.w0, new j2(this));
        this.r0 = y2Var;
        this.q0.setAdapter(y2Var);
        this.p0.l();
        List<p2> list = this.r0.d;
        ArrayList arrayList2 = new ArrayList();
        for (p2 p2Var : list) {
            if (!arrayList2.contains(Integer.valueOf(p2Var.b))) {
                arrayList2.add(Integer.valueOf(p2Var.b));
            }
        }
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            Integer num = (Integer) obj;
            TabLayout tabLayout = this.p0;
            b41 b41VarJ = tabLayout.j();
            b41VarJ.a(num.intValue());
            b41VarJ.a = num;
            tabLayout.b(b41VarJ);
        }
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        q2 q2Var = this.t0;
        if (q2Var == null) {
            return;
        }
        if (this.I0 != null) {
            ArrayList arrayList = this.w0;
            if (!arrayList.isEmpty() && arrayList.stream().noneMatch(new f2(0, this))) {
                this.I0 = null;
            }
        }
        q2Var.i(this.I0);
        super.onDismiss(dialogInterface);
    }

    @Override // defpackage.m3
    public final void q(i iVar) {
        this.I0 = iVar;
        h0(false, false);
    }

    public r2() {
        this.z0 = 0;
        this.A0 = false;
        this.B0 = false;
        this.I0 = null;
        this.K0 = (d30) Y(new j2(this), new f4(2));
        this.t0 = null;
        this.v0 = null;
        this.w0 = null;
        this.u0 = null;
    }
}
