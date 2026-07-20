package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.datepicker.c;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uj0 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ c c;
    public final /* synthetic */ zj0 d;

    public /* synthetic */ uj0(zj0 zj0Var, c cVar, int i) {
        this.b = i;
        this.d = zj0Var;
        this.c = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        c cVar = this.c;
        zj0 zj0Var = this.d;
        switch (i) {
            case 0:
                int iO0 = ((LinearLayoutManager) zj0Var.f0.getLayoutManager()).O0() - 1;
                if (iO0 >= 0) {
                    Calendar calendarA = wd1.a(cVar.c.b.b);
                    calendarA.add(2, iO0);
                    zj0Var.h0(new yl0(calendarA));
                }
                break;
            default:
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) zj0Var.f0.getLayoutManager();
                View viewQ0 = linearLayoutManager.Q0(0, linearLayoutManager.v(), false, true);
                int iL = (viewQ0 == null ? -1 : zt0.L(viewQ0)) + 1;
                if (iL < zj0Var.f0.getAdapter().a()) {
                    Calendar calendarA2 = wd1.a(cVar.c.b.b);
                    calendarA2.add(2, iL);
                    zj0Var.h0(new yl0(calendarA2));
                }
                break;
        }
    }
}
