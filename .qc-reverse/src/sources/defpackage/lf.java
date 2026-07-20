package defpackage;

import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lf implements as0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ sf c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ o01 e;

    public /* synthetic */ lf(sf sfVar, ArrayList arrayList, o01 o01Var, int i) {
        this.b = i;
        this.c = sfVar;
        this.d = arrayList;
        this.e = o01Var;
    }

    @Override // defpackage.as0
    public final void a(List list) {
        int i = this.b;
        o01 o01Var = this.e;
        ArrayList arrayList = this.d;
        sf sfVar = this.c;
        int i2 = 1;
        sfVar.getClass();
        switch (i) {
            case 0:
                if (list != null) {
                    arrayList.addAll(list);
                }
                c1 c1Var = new c1(2);
                c1Var.c = "subs";
                sfVar.c.f(c1Var.b(), new lf(sfVar, arrayList, o01Var, i2));
                break;
            default:
                ArrayList arrayList2 = new ArrayList();
                if (list != null) {
                    arrayList.addAll(list);
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    sfVar.a((Purchase) obj);
                }
                int size2 = arrayList.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList.get(i4);
                    i4++;
                    Purchase purchase = (Purchase) obj2;
                    if (purchase.b() == 1 || purchase.b() == 2) {
                        ArrayList arrayListA = purchase.a();
                        if (xy0.k(arrayListA, sf.d)) {
                            arrayList2.add((String) arrayListA.get(0));
                        } else if (xy0.k(arrayListA, sf.e) && purchase.c.optBoolean("autoRenewing")) {
                            arrayList2.add((String) arrayListA.get(0));
                        }
                    }
                }
                sf.h(new k2(o01Var, 6, arrayList2));
                break;
        }
    }
}
