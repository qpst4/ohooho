package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sf {
    public static final List d;
    public static final List e;
    public static final wa f;
    public final z7 a;
    public final qf b;
    public final af c;

    static {
        String str = dn.a;
        String str2 = dn.b;
        String str3 = dn.c;
        d = Arrays.asList(str, str2, str3);
        String str4 = dn.d;
        e = Collections.singletonList(str4);
        wa waVar = new wa();
        waVar.put(str, new r51(5000L, false));
        waVar.put(str2, new r51(5000L, false));
        waVar.put(str3, new r51(5000L, false));
        waVar.put(str4, new r51(5000L, false));
        f = waVar;
    }

    public sf(z7 z7Var, qf qfVar) {
        af ul1Var;
        this.a = z7Var;
        this.b = qfVar;
        ze zeVar = new ze(z7Var);
        zeVar.b = new ix(22);
        zeVar.c = this;
        if (((sf) zeVar.c) == null) {
            zy.n("Please provide a valid listener for purchases updates.");
            throw null;
        }
        if (((ix) zeVar.b) == null) {
            zy.n("Pending purchases for one-time products must be supported.");
            throw null;
        }
        ((ix) zeVar.b).getClass();
        sf sfVar = (sf) zeVar.c;
        ix ixVar = (ix) zeVar.b;
        if (sfVar != null) {
            sf sfVar2 = (sf) zeVar.c;
            ul1Var = zeVar.a() ? new ul1(ixVar, z7Var, sfVar2) : new af(ixVar, z7Var, sfVar2);
        } else {
            ul1Var = zeVar.a() ? new ul1(ixVar, z7Var) : new af(ixVar, z7Var);
        }
        this.c = ul1Var;
    }

    public static void f(pf pfVar, yq0 yq0Var) {
        h(new k2(pfVar, 5, yq0Var));
    }

    public static void h(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public final void a(Purchase purchase) {
        if (purchase.b() == 1 && !purchase.c.optBoolean("acknowledged", true)) {
            try {
                String str = (String) purchase.a().get(0);
                si0.b("acknowledgePurchase before throttle: " + str);
                ((r51) f.get(str)).a(new mf(this, str, purchase, 0));
            } catch (Exception e2) {
                si0.b("acknowledgePurchaseIfNotAlready error: " + e2.toString());
            }
        }
    }

    public final void b(yq0 yq0Var) {
        if (this.b != null) {
            h(new k2(this, 7, yq0Var));
        }
    }

    public final void c(of ofVar) {
        gs0 gs0Var = new gs0();
        pn0 pn0Var = new pn0(4, false);
        pn0Var.d = "inapp";
        pn0Var.c = dn.a;
        gs0Var.b(Collections.singletonList(pn0Var.f()));
        this.c.e(gs0Var.a(), new r1(this, ofVar));
    }

    public final void d(pf pfVar) {
        ArrayList arrayList = new ArrayList();
        c1 c1Var = new c1(2);
        c1Var.c = "inapp";
        this.c.f(c1Var.b(), new nf(this, arrayList, pfVar, 0));
    }

    public final void e(df dfVar, List list) {
        int i = dfVar.a;
        if (i != 0 || list == null) {
            if (i == 7) {
                d(new ef(this, 2));
                return;
            } else {
                b(yq0.no);
                return;
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Purchase purchase = (Purchase) it.next();
            a(purchase);
            if (purchase.b() == 1) {
                b(xy0.k(purchase.a(), e) ? yq0.subscription : yq0.lifetime);
            } else if (purchase.b() == 2) {
                b(yq0.pending);
            } else {
                b(yq0.no);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(String str, Boolean bool) {
        ff ffVar = new ff(this, 0, bool);
        pn0 pn0Var = new pn0(4, (boolean) (0 == true ? 1 : 0));
        pn0Var.c = str;
        pn0Var.d = d.contains(str) ? "inapp" : "subs";
        List listSingletonList = Collections.singletonList(pn0Var.f());
        gs0 gs0Var = new gs0();
        gs0Var.b(listSingletonList);
        this.c.e(gs0Var.a(), new ff(str, 1, ffVar));
    }

    public final void i(xg xgVar) {
        af afVar = this.c;
        if (afVar.c()) {
            xgVar.d();
        } else {
            afVar.g(new sp1(8, xgVar));
        }
    }
}
