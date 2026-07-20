package defpackage;

import com.android.billingclient.api.Purchase;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ef implements as0, pf {
    public final /* synthetic */ int b;
    public final /* synthetic */ sf c;

    public /* synthetic */ ef(sf sfVar, int i) {
        this.b = i;
        this.c = sfVar;
    }

    @Override // defpackage.as0
    public void a(List list) {
        int i = this.b;
        sf sfVar = this.c;
        switch (i) {
            case 0:
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Purchase purchase = (Purchase) it.next();
                        if (xy0.k(purchase.a(), sf.e) && purchase.b() == 1) {
                            sfVar.a(purchase);
                        }
                    }
                    break;
                }
                break;
            default:
                if (list != null) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        Purchase purchase2 = (Purchase) it2.next();
                        if (xy0.k(purchase2.a(), sf.d) && purchase2.b() == 1) {
                            sfVar.a(purchase2);
                        }
                    }
                    break;
                }
                break;
        }
    }

    @Override // defpackage.pf
    public void d(yq0 yq0Var) {
        this.c.b(yq0Var);
    }
}
