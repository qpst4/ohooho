package defpackage;

import android.view.View;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i2 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ r2 c;

    public /* synthetic */ i2(r2 r2Var, int i) {
        this.b = i;
        this.c = r2Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        r2 r2Var = this.c;
        switch (i) {
            case 0:
                r2Var.l0();
                break;
            case 1:
                r2Var.m0();
                break;
            default:
                if (r2Var.C0 != 1) {
                    r2Var.l0();
                    r2Var.n0(r2Var.u0);
                    r2Var.C0 = 1;
                    r2Var.H0.setText(R.string.action_picker_search_button);
                    r2Var.G0.setVisibility(0);
                } else if (r2Var.D0.getVisibility() != 0) {
                    r2Var.l0();
                } else {
                    r2Var.m0();
                }
                break;
        }
    }
}
