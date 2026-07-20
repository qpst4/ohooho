package defpackage;

import android.view.View;
import com.quickcursor.R;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class va implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ ya c;

    public /* synthetic */ va(ya yaVar, int i) {
        this.b = i;
        this.c = yaVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        ya yaVar = this.c;
        switch (i) {
            case 0:
                b61.b(new k2(yaVar, 2, view), 200L);
                break;
            case 1:
                yaVar.k0();
                break;
            case 2:
                if (yaVar.v0.getVisibility() != 8) {
                    yaVar.k0();
                } else {
                    yaVar.u0.setText(R.string.action_picker_close_search_button);
                    yaVar.v0.setVisibility(0);
                    yaVar.w0.requestFocus();
                    yaVar.w0.postDelayed(new c(7, yaVar), 100L);
                }
                break;
            case 3:
                yaVar.t0 = "";
                yaVar.h0(false, false);
                break;
            default:
                y2 y2Var = yaVar.r0;
                if (y2Var != null) {
                    Set set = (Set) y2Var.g;
                    if (set == null) {
                        set = Collections.EMPTY_SET;
                    }
                    yaVar.t0 = set;
                    yaVar.h0(false, false);
                } else {
                    yaVar.t0 = "";
                    yaVar.h0(false, false);
                }
                break;
        }
    }
}
