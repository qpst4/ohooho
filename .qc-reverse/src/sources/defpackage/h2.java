package defpackage;

import android.content.DialogInterface;
import android.widget.Button;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h2 implements DialogInterface.OnShowListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ wt b;

    public /* synthetic */ h2(wt wtVar, int i) {
        this.a = i;
        this.b = wtVar;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        int i = this.a;
        wt wtVar = this.b;
        switch (i) {
            case 0:
                r2 r2Var = (r2) wtVar;
                Button buttonD = ((b7) r2Var.j0).d(-3);
                r2Var.H0 = buttonD;
                buttonD.setOnClickListener(new i2(r2Var, 2));
                break;
            case 1:
                c3 c3Var = (c3) wtVar;
                y30 y30VarL = c3Var.l();
                y30VarL.getClass();
                ld ldVar = new ld(y30VarL);
                ldVar.g(R.id.settings, c3Var.p0, null, 1);
                ldVar.e(false);
                if (c3Var.q0 != null) {
                    ((b7) c3Var.j0).d(-3).setOnClickListener(new a3(0, c3Var));
                }
                break;
            default:
                ya yaVar = (ya) wtVar;
                Button buttonD2 = ((b7) yaVar.j0).d(-3);
                yaVar.u0 = buttonD2;
                buttonD2.setOnClickListener(new va(yaVar, 2));
                if (yaVar.o0 == 2) {
                    ((b7) yaVar.j0).d(-1).setOnClickListener(new va(yaVar, 3));
                }
                if (yaVar.x0.booleanValue()) {
                    ((b7) yaVar.j0).d(-1).setOnClickListener(new va(yaVar, 4));
                }
                break;
        }
    }
}
