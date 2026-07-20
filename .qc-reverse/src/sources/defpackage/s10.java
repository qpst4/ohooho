package defpackage;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.quickcursor.App;
import com.quickcursor.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s10 implements SeekBar.OnSeekBarChangeListener, d11, iw0, sh {
    public j30 b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final View.OnClickListener g;
    public final bk h;
    public final xa1 i;
    public TextView j;

    public s10(q0 q0Var) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_LAYOUT_RES", R.layout.first_use_slide);
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_THEME_RES", 0);
        d40 d40Var = new d40();
        d40Var.c0(bundle);
        this.b = d40Var;
        this.c = R.color.colorPrimaryDark;
        this.d = R.color.colorPrimaryDark;
        this.e = true;
        this.f = R.string.slide_first_use_button;
        this.g = q0Var;
        this.h = new bk(250L);
        this.i = new xa1(true);
    }

    @Override // defpackage.d11
    public final int a() {
        return this.c;
    }

    @Override // defpackage.d11
    public final j30 b() {
        return this.b;
    }

    @Override // defpackage.sh
    public final int c() {
        return this.f;
    }

    @Override // defpackage.d11
    public final int d() {
        return this.d;
    }

    @Override // defpackage.d11
    public final boolean e() {
        return this.b instanceof f11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s10.class != obj.getClass()) {
            return false;
        }
        s10 s10Var = (s10) obj;
        if (this.c != s10Var.c || this.d != s10Var.d || this.e != s10Var.e || this.f != s10Var.f) {
            return false;
        }
        j30 j30Var = this.b;
        j30 j30Var2 = s10Var.b;
        if (j30Var != null) {
            if (j30Var != j30Var2) {
                return false;
            }
        } else if (j30Var2 != null) {
            return false;
        }
        View.OnClickListener onClickListener = s10Var.g;
        View.OnClickListener onClickListener2 = this.g;
        return onClickListener2 != null ? onClickListener2.equals(onClickListener) : onClickListener == null;
    }

    @Override // defpackage.sh
    public final CharSequence f() {
        return null;
    }

    @Override // defpackage.iw0
    public final void g(j30 j30Var) {
        this.b = j30Var;
    }

    @Override // defpackage.d11
    public final boolean h() {
        if (this.b instanceof f11) {
            return true;
        }
        return this.e;
    }

    public final int hashCode() {
        j30 j30Var = this.b;
        int iHashCode = (((((((((j30Var != null ? j30Var.hashCode() : 0) * 31) + this.c) * 31) + this.d) * 961) + (this.e ? 1 : 0)) * 961) + this.f) * 31;
        View.OnClickListener onClickListener = this.g;
        return iHashCode + (onClickListener != null ? onClickListener.hashCode() : 0);
    }

    @Override // defpackage.sh
    public final View.OnClickListener i() {
        return this.g;
    }

    public final void j() {
        xa1 xa1Var = this.i;
        try {
            k();
            ey0.e(App.c);
            List listK = xv0.d.a().k();
            xa1Var.e();
            Iterator it = listK.iterator();
            int i = -1;
            while (it.hasNext()) {
                xa1Var.c(Integer.valueOf(i), (f91) it.next());
                i--;
            }
            if (xv0.d.a().q()) {
                l();
            }
        } catch (Exception unused) {
        }
    }

    public final void k() {
        View view = this.b.H;
        if (view == null) {
            new b61(new r10(this, 0), 50L).c();
            return;
        }
        int i = 9;
        view.findViewById(R.id.button1).setOnClickListener(new a3(i, this));
        view.findViewById(R.id.button2).setOnClickListener(new a3(i, this));
        view.findViewById(R.id.button3).setOnClickListener(new a3(i, this));
    }

    public final void l() {
        View view = this.b.H;
        if (view == null) {
            new b61(new r10(this, 1), 50L).c();
            return;
        }
        int iMin = dn.D1;
        try {
            db dbVarH = ((f91) xv0.d.a().k().get(0)).h();
            iMin = Math.min(dbVarH.f(), dbVarH.c());
        } catch (Exception unused) {
        }
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.triggerSizeSeekBar);
        this.j = (TextView) view.findViewById(R.id.triggerSizeValue);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setProgress(iMin);
        seekBar.setMax(dn.r1);
        this.j.setText(seekBar.getProgress() + "");
        onProgressChanged(seekBar, iMin, false);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(i + "");
        }
        z01 z01VarB = ey0.d() ? z01.b() : z01.a();
        xv0 xv0Var = xv0.d;
        uv0 uv0VarA = xv0Var.a();
        z01VarB.a = i;
        (ey0.b == 1 ? if0.p : if0.o).u0(uv0VarA, z01VarB, true, true);
        xv0Var.c();
        Iterator it = xv0Var.a().k().iterator();
        int i2 = -1;
        while (it.hasNext()) {
            this.i.c(Integer.valueOf(i2), (f91) it.next());
            i2--;
        }
        this.h.a(new s4(15));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
