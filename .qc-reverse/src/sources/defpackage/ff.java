package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.android.billingclient.api.Purchase;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ff implements ir0, as0, pf, bx0, t31 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ ff(Object obj, int i, Object obj2) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }

    @Override // defpackage.as0
    public void a(List list) {
        sf sfVar = (sf) this.c;
        final rf rfVar = (rf) this.d;
        final int i = 0;
        if (list == null || list.size() == 0) {
            sf.h(new Runnable() { // from class: jf
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    rf rfVar2 = rfVar;
                    switch (i2) {
                        case 0:
                            rfVar2.b(1);
                            break;
                        case 1:
                            rfVar2.b(1);
                            break;
                        default:
                            rfVar2.b(1);
                            break;
                    }
                }
            });
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sfVar.a((Purchase) it.next());
        }
        Iterator it2 = list.iterator();
        while (true) {
            final int i2 = 1;
            if (!it2.hasNext()) {
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    if (((Purchase) it3.next()).b() == 2) {
                        sf.h(new Runnable() { // from class: jf
                            @Override // java.lang.Runnable
                            public final void run() {
                                int i22 = i2;
                                rf rfVar2 = rfVar;
                                switch (i22) {
                                    case 0:
                                        rfVar2.b(1);
                                        break;
                                    case 1:
                                        rfVar2.b(1);
                                        break;
                                    default:
                                        rfVar2.b(1);
                                        break;
                                }
                            }
                        });
                        return;
                    }
                }
                sf.h(new Runnable() { // from class: jf
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i22 = i;
                        rf rfVar2 = rfVar;
                        switch (i22) {
                            case 0:
                                rfVar2.b(1);
                                break;
                            case 1:
                                rfVar2.b(1);
                                break;
                            default:
                                rfVar2.b(1);
                                break;
                        }
                    }
                });
                return;
            }
            Purchase purchase = (Purchase) it2.next();
            if (purchase.b() == 1 && xy0.k(purchase.a(), sf.e)) {
                sf.h(new kf(purchase.c.optBoolean("autoRenewing") ? 2 : 3, 0, rfVar));
                return;
            }
        }
    }

    @Override // defpackage.bx0
    public Object apply(Object obj) {
        dx0 dx0Var = (dx0) this.c;
        hd hdVar = (hd) this.d;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        zc zcVar = dx0Var.e;
        ArrayList arrayListI = dx0Var.i(sQLiteDatabase, hdVar, zcVar.b);
        for (tq0 tq0Var : tq0.values()) {
            if (tq0Var != hdVar.c) {
                int size = zcVar.b - arrayListI.size();
                if (size <= 0) {
                    break;
                }
                ra raVarA = hd.a();
                raVarA.R(hdVar.a);
                if (tq0Var == null) {
                    zy.r("Null priority");
                    return null;
                }
                raVarA.e = tq0Var;
                raVarA.d = hdVar.b;
                arrayListI.addAll(dx0Var.i(sQLiteDatabase, raVarA.m(), size));
            }
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayListI.size(); i++) {
            sb.append(((ed) arrayListI.get(i)).a);
            if (i < arrayListI.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j), hashSet);
                }
                hashSet.add(new cx0(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayListI.listIterator();
        while (listIterator.hasNext()) {
            ed edVar = (ed) listIterator.next();
            long j2 = edVar.a;
            if (map.containsKey(Long.valueOf(j2))) {
                a9 a9VarC = edVar.c.c();
                for (cx0 cx0Var : (Set) map.get(Long.valueOf(j2))) {
                    a9VarC.a(cx0Var.a, cx0Var.b);
                }
                listIterator.set(new ed(j2, edVar.b, a9VarC.c()));
            }
        }
        return arrayListI;
    }

    public void b(hr0 hr0Var) {
        sf sfVar = (sf) this.c;
        Boolean bool = (Boolean) this.d;
        if (hr0Var == null) {
            si0.b("BillingService.getProductDetails() - productDetails null");
            return;
        }
        i9 i9Var = new i9(5);
        i9Var.c = hr0Var;
        er0 er0VarA = hr0Var.a();
        ArrayList arrayList = hr0Var.i;
        if (er0VarA != null) {
            hr0Var.a().getClass();
            String str = hr0Var.a().b;
            if (str != null) {
                i9Var.d = str;
            }
        }
        if (sf.e.contains(hr0Var.c)) {
            String str2 = ((gr0) arrayList.get(0)).a;
            if (bool.booleanValue()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    gr0 gr0Var = (gr0) obj;
                    if (gr0Var.c.contains(dn.e)) {
                        str2 = gr0Var.a;
                    }
                }
            } else {
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    gr0 gr0Var2 = (gr0) obj2;
                    if (!gr0Var2.c.contains(dn.e)) {
                        str2 = gr0Var2.a;
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                zy.n("offerToken can not be empty");
                return;
            }
            i9Var.d = str2;
        }
        hr0 hr0Var2 = (hr0) i9Var.c;
        if (hr0Var2 == null) {
            zy.r("ProductDetails is required for constructing ProductDetailsParams.");
            return;
        }
        if (hr0Var2.i != null && ((String) i9Var.d) == null) {
            zy.r("offerToken is required for constructing ProductDetailsParams for subscriptions.");
            return;
        }
        ArrayList arrayList2 = new ArrayList(Collections.singletonList(new bf(i9Var)));
        boolean zIsEmpty = arrayList2.isEmpty();
        if (zIsEmpty) {
            zy.n("Details of the products must be provided.");
            return;
        }
        arrayList2.forEach(new ll1());
        cf cfVar = new cf();
        cfVar.a = (zIsEmpty || ((bf) arrayList2.get(0)).a.b.optString("packageName").isEmpty()) ? false : true;
        boolean z = (TextUtils.isEmpty(null) && TextUtils.isEmpty(null)) ? false : true;
        boolean zIsEmpty2 = TextUtils.isEmpty(null);
        if (z && !zIsEmpty2) {
            zy.n("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
            return;
        }
        cfVar.b = new ow0(8);
        cfVar.d = new ArrayList();
        cfVar.c = em1.k(arrayList2);
        si0.b("requestToBuy billingResult.getResponseCode() = " + sfVar.c.d(sfVar.a, cfVar).a);
    }

    @Override // defpackage.pf
    public void d(yq0 yq0Var) {
        wj wjVar = (wj) this.c;
        yq0 yq0Var2 = (yq0) this.d;
        if (yq0Var == yq0.lifetime || yq0Var == yq0.subscription) {
            fp1.b(yq0Var, wjVar, new lk0(3, wjVar));
            return;
        }
        yq0 yq0Var3 = yq0.no;
        if (yq0Var2 == yq0Var3 && yq0Var == yq0.pending) {
            fp1.a();
            wjVar.recreate();
        } else if (yq0Var2 == yq0.pending && yq0Var == yq0Var3) {
            yb0.y(R.string.deactivate_pro_version, 1);
            zq0.b.a();
            CursorAccessibilityService.k(true);
            wjVar.recreate();
        }
    }

    @Override // defpackage.ir0
    public void e(df dfVar, ArrayList arrayList) {
        int i = this.b;
        final String str = null;
        int i2 = 0;
        Object obj = this.d;
        Object obj2 = this.c;
        switch (i) {
            case 1:
                String str2 = (String) obj2;
                ff ffVar = (ff) obj;
                if (dfVar.a == 0) {
                    int size = arrayList.size();
                    while (i2 < size) {
                        Object obj3 = arrayList.get(i2);
                        i2++;
                        hr0 hr0Var = (hr0) obj3;
                        if (hr0Var.c.equals(str2)) {
                            ffVar.b(hr0Var);
                            break;
                        }
                    }
                }
                ffVar.b(null);
                break;
            default:
                final wh whVar = (wh) obj;
                ((sf) obj2).getClass();
                try {
                    if (dfVar.a == 0) {
                        int size2 = arrayList.size();
                        final boolean z = false;
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj4 = arrayList.get(i3);
                            i3++;
                            ArrayList arrayList2 = ((gr0) ((hr0) obj4).i.get(0)).b.b;
                            int size3 = arrayList2.size();
                            int i4 = 0;
                            while (i4 < size3) {
                                Object obj5 = arrayList2.get(i4);
                                i4++;
                                fr0 fr0Var = (fr0) obj5;
                                long j = fr0Var.b;
                                if (j == 0) {
                                    z = true;
                                }
                                if (j > 0) {
                                    str = fr0Var.a;
                                }
                            }
                        }
                        sf.h(new Runnable() { // from class: hf
                            @Override // java.lang.Runnable
                            public final void run() {
                                whVar.a(str, Boolean.valueOf(z));
                            }
                        });
                    }
                    break;
                } catch (Exception unused) {
                }
                sf.h(new c(11, whVar));
                break;
        }
    }

    @Override // defpackage.t31
    public Object f() {
        int i = this.b;
        Object obj = this.d;
        vd1 vd1Var = (vd1) this.c;
        switch (i) {
            case 6:
                Iterable iterable = (Iterable) obj;
                dx0 dx0Var = vd1Var.c;
                dx0Var.getClass();
                if (iterable.iterator().hasNext()) {
                    dx0Var.a().compileStatement("DELETE FROM events WHERE _id in ".concat(dx0.r(iterable))).execute();
                }
                break;
            default:
                Iterator it = ((HashMap) obj).entrySet().iterator();
                while (it.hasNext()) {
                    vd1Var.i.m(((Integer) r2.getValue()).intValue(), pi0.h, (String) ((Map.Entry) it.next()).getKey());
                }
                break;
        }
        return null;
    }
}
