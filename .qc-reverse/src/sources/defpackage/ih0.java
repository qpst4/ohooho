package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ih0 extends wt {
    public final /* synthetic */ int o0;
    public final String p0;
    public Serializable q0;
    public final Object r0;
    public Object s0;
    public Object t0;

    public ih0(String str, Integer num, eh ehVar) {
        this.o0 = 1;
        this.p0 = str;
        this.q0 = num;
        this.r0 = 1;
        this.s0 = 5;
        this.t0 = ehVar;
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        int i = this.o0;
        int i2 = 10;
        String str = this.p0;
        switch (i) {
            case 0:
                this.s0 = (RecyclerView) v().inflate(R.layout.list_picker_dialog_fragment_layout, (ViewGroup) null);
                jl1 jl1Var = new jl1(o());
                x6 x6Var = (x6) jl1Var.c;
                x6Var.e = str;
                x6Var.u = (RecyclerView) this.s0;
                jl1Var.h(R.string.dialog_button_cancel, null);
                b7 b7VarC = jl1Var.c();
                ((RecyclerView) this.s0).setLayoutManager(new LinearLayoutManager(1));
                ((RecyclerView) this.s0).setAdapter(new lh0((ArrayList) this.q0, new a3(i2, this)));
                return b7VarC;
            default:
                RelativeLayout relativeLayout = (RelativeLayout) v().inflate(R.layout.number_picker_dialog_fragment_layout, (ViewGroup) null);
                NumberPicker numberPicker = (NumberPicker) relativeLayout.findViewById(R.id.number_picker);
                numberPicker.setMinValue(((Integer) this.r0).intValue());
                numberPicker.setMaxValue(((Integer) this.s0).intValue());
                numberPicker.setValue(((Integer) this.q0).intValue());
                numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: fn0
                    @Override // android.widget.NumberPicker.OnValueChangeListener
                    public final void onValueChange(NumberPicker numberPicker2, int i3, int i4) {
                        this.a.q0 = Integer.valueOf(i4);
                    }
                });
                jl1 jl1Var2 = new jl1(o());
                x6 x6Var2 = (x6) jl1Var2.c;
                x6Var2.e = str;
                x6Var2.u = relativeLayout;
                jl1Var2.h(R.string.dialog_button_cancel, new z2(i2, this));
                jl1Var2.k(R.string.dialog_button_save, null);
                return jl1Var2.c();
        }
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.o0) {
            case 0:
                ((hh0) this.r0).a((jh0) this.t0);
                super.onDismiss(dialogInterface);
                break;
            default:
                eh ehVar = (eh) this.t0;
                Integer num = (Integer) this.q0;
                m3 m3Var = ehVar.c;
                n3 n3Var = ehVar.d;
                l3 l3Var = hm0.k;
                if (num != null) {
                    wi0 wi0Var = new wi0();
                    wi0Var.put("multiTouch", num);
                    m3Var.q(new i(n3Var, wi0Var));
                }
                super.onDismiss(dialogInterface);
                break;
        }
    }

    public ih0(String str, ArrayList arrayList, hh0 hh0Var) {
        this.o0 = 0;
        this.t0 = null;
        this.p0 = str;
        this.q0 = arrayList;
        this.r0 = hh0Var;
    }
}
