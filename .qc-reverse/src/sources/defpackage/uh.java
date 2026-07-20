package defpackage;

import android.content.Intent;
import com.quickcursor.android.activities.BuyProActivity;
import com.quickcursor.android.activities.ThanksProActivity;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uh implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ BuyProActivity c;

    public /* synthetic */ uh(BuyProActivity buyProActivity, int i) {
        this.b = i;
        this.c = buyProActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        boolean z = false;
        BuyProActivity buyProActivity = this.c;
        switch (i) {
            case 0:
                buyProActivity.B = false;
                buyProActivity.startActivity(new Intent(buyProActivity, (Class<?>) ThanksProActivity.class));
                buyProActivity.finish();
                break;
            default:
                sf sfVar = buyProActivity.G;
                wh whVar = new wh(buyProActivity, 1);
                sfVar.getClass();
                gs0 gs0Var = new gs0();
                pn0 pn0Var = new pn0(4, z);
                pn0Var.d = "subs";
                pn0Var.c = dn.d;
                gs0Var.b(Collections.singletonList(pn0Var.f()));
                sfVar.c.e(gs0Var.a(), new ff(sfVar, 3, whVar));
                buyProActivity.G.c(new wh(buyProActivity, 2));
                break;
        }
    }
}
