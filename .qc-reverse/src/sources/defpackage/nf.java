package defpackage;

import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nf implements as0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ sf c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ pf e;

    public /* synthetic */ nf(sf sfVar, ArrayList arrayList, pf pfVar, int i) {
        this.b = i;
        this.c = sfVar;
        this.d = arrayList;
        this.e = pfVar;
    }

    @Override // defpackage.as0
    public final void a(List list) {
        int i = this.b;
        int i2 = 1;
        pf pfVar = this.e;
        ArrayList arrayList = this.d;
        sf sfVar = this.c;
        switch (i) {
            case 0:
                if (list != null) {
                    arrayList.addAll(list);
                }
                c1 c1Var = new c1(2);
                c1Var.c = "subs";
                sfVar.c.f(c1Var.b(), new nf(sfVar, arrayList, pfVar, i2));
                break;
            default:
                if (list != null) {
                    arrayList.addAll(list);
                }
                if (arrayList.size() != 0) {
                    int size = arrayList.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        sfVar.a((Purchase) obj);
                    }
                    int size2 = arrayList.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        Object obj2 = arrayList.get(i5);
                        i5++;
                        Purchase purchase = (Purchase) obj2;
                        if (purchase.b() == 1 && xy0.k(purchase.a(), sf.d)) {
                            sf.f(pfVar, yq0.lifetime);
                            break;
                        }
                    }
                    int size3 = arrayList.size();
                    int i6 = 0;
                    while (i6 < size3) {
                        Object obj3 = arrayList.get(i6);
                        i6++;
                        Purchase purchase2 = (Purchase) obj3;
                        if (purchase2.b() == 1 && xy0.k(purchase2.a(), sf.e)) {
                            sf.f(pfVar, yq0.subscription);
                            break;
                        }
                    }
                    int size4 = arrayList.size();
                    while (i3 < size4) {
                        Object obj4 = arrayList.get(i3);
                        i3++;
                        if (((Purchase) obj4).b() == 2) {
                            sf.f(pfVar, yq0.pending);
                            break;
                        }
                    }
                    sf.f(pfVar, yq0.no);
                } else {
                    sf.f(pfVar, yq0.no);
                }
                break;
        }
    }
}
