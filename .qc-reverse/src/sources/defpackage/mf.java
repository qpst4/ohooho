package defpackage;

import android.view.View;
import android.widget.Button;
import com.android.billingclient.api.Purchase;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mf implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ mf(ss ssVar, hd hdVar, ay0 ay0Var, yc ycVar) {
        this.b = 1;
        this.c = ssVar;
        this.d = hdVar;
        this.e = ycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 0;
        switch (this.b) {
            case 0:
                sf sfVar = (sf) this.c;
                String str = (String) this.d;
                Purchase purchase = (Purchase) this.e;
                si0.b("acknowledgePurchase after throttle: " + str);
                JSONObject jSONObject = purchase.c;
                String strOptString = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
                if (strOptString == null) {
                    zy.n("Purchase token must be set");
                    return;
                }
                c1 c1Var = new c1(i);
                c1Var.c = strOptString;
                sfVar.c.a(c1Var, new s1(3));
                return;
            case 1:
                ss ssVar = (ss) this.c;
                hd hdVar = (hd) this.d;
                String str2 = hdVar.a;
                yc ycVar = (yc) this.e;
                ssVar.getClass();
                Logger logger = ss.f;
                try {
                    c91 c91VarA = ssVar.c.a(str2);
                    if (c91VarA == null) {
                        String str3 = "Transport backend '" + str2 + "' is not registered";
                        logger.warning(str3);
                        new IllegalArgumentException(str3);
                    } else {
                        ssVar.e.q(new qs(ssVar, hdVar, ((xi) c91VarA).a(ycVar), i));
                    }
                    return;
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    return;
                }
            case 2:
                nr nrVar = (nr) this.c;
                yb0 yb0Var = (yb0) this.d;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.e;
                try {
                    o20 o20VarE = tk0.e(nrVar.a);
                    if (o20VarE == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    n20 n20Var = (n20) ((rx) o20VarE.b);
                    synchronized (n20Var.d) {
                        n20Var.f = threadPoolExecutor;
                        break;
                    }
                    ((rx) o20VarE.b).a(new tx(yb0Var, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    yb0Var.q(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 3:
                View view = (View) this.c;
                Button button = (Button) this.e;
                String str4 = (String) this.d;
                view.setEnabled(true);
                button.setText(str4);
                return;
            default:
                sf sfVar2 = (sf) this.c;
                wj wjVar = (wj) this.d;
                yq0 yq0Var = (yq0) this.e;
                if (sfVar2.c.c()) {
                    sfVar2.d(new ff(wjVar, 4, yq0Var));
                    return;
                }
                return;
        }
    }

    public /* synthetic */ mf(View view, Button button, String str) {
        this.b = 3;
        this.c = view;
        this.e = button;
        this.d = str;
    }

    public /* synthetic */ mf(Object obj, Object obj2, Object obj3, int i) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }
}
