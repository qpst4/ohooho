package defpackage;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.billingclient.api.ProxyBillingActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class af {
    public final Object a;
    public volatile int b;
    public final String c;
    public final Handler d;
    public volatile o90 e;
    public final Context f;
    public final pn0 g;
    public volatile sk1 h;
    public volatile bl1 i;
    public boolean j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final ix u;
    public final boolean v;
    public ExecutorService w;
    public volatile ao1 x;
    public final Long y;

    public af(ix ixVar, z7 z7Var) {
        this.a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.k = 0;
        long jNextLong = new Random().nextLong();
        this.y = Long.valueOf(jNextLong);
        this.c = k();
        this.f = z7Var.getApplicationContext();
        dr1 dr1VarS = er1.s();
        String strK = k();
        dr1VarS.c();
        er1.r((er1) dr1VarS.c, strK);
        String packageName = this.f.getPackageName();
        dr1VarS.c();
        er1.q((er1) dr1VarS.c, packageName);
        dr1VarS.c();
        er1.p((er1) dr1VarS.c, jNextLong);
        this.g = new pn0(this.f, (er1) dr1VarS.b());
        pn1.g("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.e = new o90(this.f, null, this.g);
        this.u = ixVar;
        this.f.getPackageName();
    }

    public static Future h(Callable callable, long j, Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new vn1(futureSubmit, 15, runnable), (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            pn1.h("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static String k() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "7.1.1";
        }
    }

    public void a(final c1 c1Var, final s1 s1Var) {
        if (!c()) {
            df dfVar = zl1.k;
            w(2, 3, dfVar);
            s1.o(dfVar);
            return;
        }
        if (TextUtils.isEmpty(c1Var.c)) {
            pn1.g("BillingClient", "Please provide a valid purchase token.");
            df dfVar2 = zl1.h;
            w(26, 3, dfVar2);
            s1.o(dfVar2);
            return;
        }
        if (!this.m) {
            df dfVar3 = zl1.b;
            w(27, 3, dfVar3);
            s1.o(dfVar3);
        } else if (h(new Callable(s1Var, c1Var) { // from class: es1
            public final /* synthetic */ c1 b;

            {
                this.b = c1Var;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                sk1 sk1Var;
                af afVar = this.a;
                c1 c1Var2 = this.b;
                try {
                    synchronized (afVar.a) {
                        sk1Var = afVar.h;
                    }
                    if (sk1Var == null) {
                        afVar.t(zl1.k, 119, null);
                        return null;
                    }
                    String packageName = afVar.f.getPackageName();
                    String str = c1Var2.c;
                    String str2 = afVar.c;
                    long jLongValue = afVar.y.longValue();
                    Bundle bundle = new Bundle();
                    pn1.b(bundle, str2, jLongValue);
                    Bundle bundleD = ((pk1) sk1Var).d(packageName, str, bundle);
                    s1.o(zl1.a(pn1.e("BillingClient", bundleD), pn1.a("BillingClient", bundleD)));
                    return null;
                } catch (DeadObjectException e) {
                    afVar.t(zl1.k, 28, e);
                    return null;
                } catch (Exception e2) {
                    afVar.t(zl1.i, 28, e2);
                    return null;
                }
            }
        }, 30000L, new nc(this, s1Var), u(), l()) == null) {
            df dfVarI = i();
            w(25, 3, dfVarI);
            s1.o(dfVarI);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r5 = this;
            r0 = 12
            wq1 r0 = defpackage.vl1.d(r0)     // Catch: java.lang.Throwable -> La
            r5.n(r0)     // Catch: java.lang.Throwable -> La
            goto L12
        La:
            r0 = move-exception
            java.lang.String r1 = "BillingClient"
            java.lang.String r2 = "Unable to log."
            defpackage.pn1.h(r1, r2, r0)
        L12:
            java.lang.Object r0 = r5.a
            monitor-enter(r0)
            o90 r1 = r5.e     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L36
            o90 r1 = r5.e     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r2 = r1.f     // Catch: java.lang.Throwable -> L2e
            ur1 r2 = (defpackage.ur1) r2     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r3 = r1.c     // Catch: java.lang.Throwable -> L2e
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Throwable -> L2e
            r2.b(r3)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r1 = r1.g     // Catch: java.lang.Throwable -> L2e
            ur1 r1 = (defpackage.ur1) r1     // Catch: java.lang.Throwable -> L2e
            r1.b(r3)     // Catch: java.lang.Throwable -> L2e
            goto L36
        L2e:
            r1 = move-exception
            java.lang.String r2 = "BillingClient"
            java.lang.String r3 = "There was an exception while shutting down broadcast manager while ending connection!"
            defpackage.pn1.h(r2, r3, r1)     // Catch: java.lang.Throwable -> L5f
        L36:
            java.lang.String r1 = "BillingClient"
            java.lang.String r2 = "Unbinding from service."
            defpackage.pn1.f(r1, r2)     // Catch: java.lang.Throwable -> L41
            r5.p()     // Catch: java.lang.Throwable -> L41
            goto L49
        L41:
            r1 = move-exception
            java.lang.String r2 = "BillingClient"
            java.lang.String r3 = "There was an exception while unbinding from the service while ending connection!"
            defpackage.pn1.h(r2, r3, r1)     // Catch: java.lang.Throwable -> L5f
        L49:
            r1 = 3
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L63
            java.util.concurrent.ExecutorService r2 = r5.w     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L57
            r2.shutdownNow()     // Catch: java.lang.Throwable -> L59
            r2 = 0
            r5.w = r2     // Catch: java.lang.Throwable -> L59
            r5.x = r2     // Catch: java.lang.Throwable -> L59
        L57:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L63
            goto L5b
        L59:
            r2 = move-exception
            goto L61
        L5b:
            r5.o(r1)     // Catch: java.lang.Throwable -> L5f
            goto L6c
        L5f:
            r5 = move-exception
            goto L73
        L61:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L59
            throw r2     // Catch: java.lang.Throwable -> L63
        L63:
            r2 = move-exception
            java.lang.String r3 = "BillingClient"
            java.lang.String r4 = "There was an exception while shutting down the executor service while ending connection!"
            defpackage.pn1.h(r3, r4, r2)     // Catch: java.lang.Throwable -> L6e
            goto L5b
        L6c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5f
            return
        L6e:
            r2 = move-exception
            r5.o(r1)     // Catch: java.lang.Throwable -> L5f
            throw r2     // Catch: java.lang.Throwable -> L5f
        L73:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5f
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.af.b():void");
    }

    public final boolean c() {
        boolean z;
        synchronized (this.a) {
            try {
                z = false;
                if (this.b == 2 && this.h != null && this.i != null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public df d(z7 z7Var, final cf cfVar) {
        String str;
        String str2;
        String str3;
        String str4;
        df dfVarA;
        String str5;
        Future futureH;
        int iD;
        String string;
        int i;
        String str6;
        boolean z;
        String str7;
        String str8;
        bf bfVar;
        String str9;
        String str10;
        boolean z2;
        String str11;
        int i2;
        final int i3;
        final af afVar = this;
        final int i4 = 2;
        if (afVar.e == null || ((sf) afVar.e.d) == null) {
            df dfVar = zl1.s;
            afVar.w(12, 2, dfVar);
            return dfVar;
        }
        if (!afVar.c()) {
            df dfVar2 = zl1.k;
            afVar.w(2, 2, dfVar2);
            afVar.y(dfVar2);
            return dfVar2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cfVar.d);
        em1 em1Var = cfVar.c;
        Iterator it = arrayList.iterator();
        if ((it.hasNext() ? it.next() : null) != null) {
            s1.d();
            return null;
        }
        bm1 bm1Var = (bm1) em1Var.iterator();
        bf bfVar2 = (bf) (bm1Var.hasNext() ? bm1Var.next() : null);
        hr0 hr0Var = bfVar2.a;
        String str12 = hr0Var.c;
        String str13 = hr0Var.d;
        if (str13.equals("subs") && !afVar.j) {
            pn1.g("BillingClient", "Current client doesn't support subscriptions.");
            df dfVar3 = zl1.m;
            afVar.w(9, 2, dfVar3);
            afVar.y(dfVar3);
            return dfVar3;
        }
        cfVar.b.getClass();
        if ((cfVar.c.stream().anyMatch(new Predicate() { // from class: nk1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                switch (i4) {
                    case 0:
                        int i5 = pn1.a;
                        break;
                    case 1:
                        int i6 = pn1.a;
                        break;
                    default:
                        break;
                }
                return false;
            }
        }) || cfVar.a) && !afVar.l) {
            pn1.g("BillingClient", "Current client doesn't support extra params for buy intent.");
            df dfVar4 = zl1.g;
            afVar.w(18, 2, dfVar4);
            afVar.y(dfVar4);
            return dfVar4;
        }
        if (arrayList.size() > 1 && !afVar.p) {
            pn1.g("BillingClient", "Current client doesn't support multi-item purchases.");
            df dfVar5 = zl1.o;
            afVar.w(19, 2, dfVar5);
            afVar.y(dfVar5);
            return dfVar5;
        }
        if (!em1Var.isEmpty() && !afVar.q) {
            pn1.g("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            df dfVar6 = zl1.q;
            afVar.w(20, 2, dfVar6);
            afVar.y(dfVar6);
            return dfVar6;
        }
        if (cfVar.c.isEmpty()) {
            dfVarA = zl1.j;
            str4 = "proxyPackageVersion";
            str = str13;
            str3 = "BUY_INTENT";
            str2 = str12;
        } else {
            bf bfVar3 = (bf) cfVar.c.get(0);
            int i5 = 1;
            while (true) {
                str = str13;
                if (i5 < cfVar.c.size()) {
                    bf bfVar4 = (bf) cfVar.c.get(i5);
                    int i6 = i5;
                    str2 = str12;
                    if (!bfVar4.a.d.equals(bfVar3.a.d) && !bfVar4.a.d.equals("play_pass_subs")) {
                        dfVarA = zl1.a("All products should have same ProductType.", 5);
                        str4 = "proxyPackageVersion";
                        str3 = "BUY_INTENT";
                        break;
                    }
                    i5 = i6 + 1;
                    str13 = str;
                    str12 = str2;
                } else {
                    str2 = str12;
                    hr0 hr0Var2 = bfVar3.a;
                    String strOptString = hr0Var2.b.optString("packageName");
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    em1 em1Var2 = cfVar.c;
                    str3 = "BUY_INTENT";
                    int size = em1Var2.size();
                    str4 = "proxyPackageVersion";
                    int i7 = 0;
                    while (true) {
                        if (i7 < size) {
                            int i8 = i7;
                            hr0 hr0Var3 = ((bf) em1Var2.get(i7)).a;
                            int i9 = size;
                            hr0Var3.d.equals("subs");
                            boolean zContains = hashSet.contains(hr0Var3.c);
                            String str14 = hr0Var3.c;
                            if (!zContains) {
                                hashSet.add(str14);
                                if (!hr0Var2.d.equals("play_pass_subs") && !hr0Var3.d.equals("play_pass_subs") && !strOptString.equals(hr0Var3.b.optString("packageName"))) {
                                    dfVarA = zl1.a("All products must have the same package name.", 5);
                                    break;
                                }
                                i7 = i8 + 1;
                                size = i9;
                            } else {
                                dfVarA = zl1.a("ProductId can not be duplicated. Invalid product id: " + str14 + ".", 5);
                                break;
                            }
                        } else {
                            Iterator it2 = hashSet2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    String str15 = (String) it2.next();
                                    if (hashSet.contains(str15)) {
                                        dfVarA = zl1.a("OldProductId must not be one of the products to be purchased. Invalid old product id: " + str15 + ".", 5);
                                        break;
                                    }
                                } else {
                                    er0 er0VarA = hr0Var2.a();
                                    dfVarA = (er0VarA == null || er0VarA.d == null) ? zl1.j : zl1.a("Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.", 5);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (dfVarA != zl1.j) {
            afVar.w(120, 2, dfVarA);
            afVar.y(dfVarA);
            return dfVarA;
        }
        if (afVar.l) {
            boolean z3 = afVar.m;
            afVar.u.getClass();
            afVar.u.getClass();
            boolean z4 = afVar.v;
            String str16 = afVar.c;
            long jLongValue = afVar.y.longValue();
            final String packageName = afVar.f.getPackageName();
            final Bundle bundle = new Bundle();
            pn1.b(bundle, str16, jLongValue);
            cfVar.b.getClass();
            if (TextUtils.isEmpty(null)) {
                str6 = null;
            } else {
                str6 = null;
                bundle.putString("accountId", null);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("obfuscatedProfileId", str6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(str6)));
            }
            cfVar.b.getClass();
            if (!TextUtils.isEmpty(str6)) {
                cfVar.b.getClass();
                bundle.putString("oldSkuPurchaseToken", str6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("oldSkuPurchaseId", str6);
            }
            cfVar.b.getClass();
            if (!TextUtils.isEmpty(str6)) {
                cfVar.b.getClass();
                bundle.putString("originalExternalTransactionId", str6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("paymentsPurchaseParams", str6);
            }
            if (z3) {
                z = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z = true;
            }
            if (z4) {
                bundle.putBoolean("enableAlternativeBilling", z);
            }
            final int i10 = 0;
            if (cfVar.c.stream().anyMatch(new Predicate() { // from class: nk1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    switch (i10) {
                        case 0:
                            int i52 = pn1.a;
                            break;
                        case 1:
                            int i62 = pn1.a;
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            })) {
                mo1 mo1VarO = no1.o();
                final int i11 = 1;
                Iterable iterable = (Iterable) cfVar.c.stream().filter(new Predicate() { // from class: nk1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        switch (i11) {
                            case 0:
                                int i52 = pn1.a;
                                break;
                            case 1:
                                int i62 = pn1.a;
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                }).map(new Function() { // from class: ql1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i12 = pn1.a;
                        String str17 = ((bf) obj).a.c;
                        ko1 ko1VarO = lo1.o();
                        oo1 oo1VarO = po1.o();
                        String str18 = "subs:" + packageName + ":" + str17;
                        oo1VarO.c();
                        po1.p((po1) oo1VarO.c, str18);
                        ko1VarO.c();
                        lo1.p((lo1) ko1VarO.c, (po1) oo1VarO.b());
                        po1.o();
                        throw null;
                    }
                }).collect(kl1.a);
                mo1VarO.c();
                no1.p((no1) mo1VarO.c, iterable);
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((no1) mo1VarO.b()).b());
            }
            if (arrayList.isEmpty()) {
                ArrayList<String> arrayList2 = new ArrayList<>(em1Var.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>(em1Var.size() - 1);
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<Integer> arrayList7 = new ArrayList<>();
                str7 = "packageName";
                str8 = "BillingClient";
                int i12 = 0;
                while (i12 < em1Var.size()) {
                    bf bfVar5 = (bf) em1Var.get(i12);
                    bf bfVar6 = bfVar2;
                    hr0 hr0Var4 = bfVar5.a;
                    if (!hr0Var4.g.isEmpty()) {
                        arrayList4.add(hr0Var4.g);
                    }
                    arrayList5.add(bfVar5.b);
                    String str17 = hr0Var4.h;
                    ArrayList arrayList8 = hr0Var4.j;
                    if (arrayList8 == null || arrayList8.isEmpty()) {
                        str9 = str17;
                    } else {
                        ArrayList arrayList9 = hr0Var4.j;
                        int size2 = arrayList9.size();
                        str9 = str17;
                        int i13 = 0;
                        while (i13 < size2) {
                            Object obj = arrayList9.get(i13);
                            int i14 = i13 + 1;
                            er0 er0Var = (er0) obj;
                            ArrayList arrayList10 = arrayList9;
                            if (!TextUtils.isEmpty(er0Var.c)) {
                                str10 = er0Var.c;
                                break;
                            }
                            arrayList9 = arrayList10;
                            i13 = i14;
                        }
                    }
                    str10 = str9;
                    if (!TextUtils.isEmpty(str10)) {
                        arrayList6.add(str10);
                    }
                    if (i12 > 0) {
                        arrayList2.add(((bf) em1Var.get(i12)).a.c);
                        arrayList3.add(((bf) em1Var.get(i12)).a.d);
                    }
                    i12++;
                    bfVar2 = bfVar6;
                }
                bfVar = bfVar2;
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList5);
                bundle.putIntegerArrayList("AUTO_PAY_BALANCE_THRESHOLD_LIST", arrayList7);
                if (!arrayList4.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
                }
                if (!arrayList2.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList2);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                }
            } else {
                ArrayList<String> arrayList11 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Iterator it3 = arrayList.iterator();
                if (it3.hasNext()) {
                    throw l11.h(it3);
                }
                if (!arrayList11.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList11);
                }
                if (arrayList.size() > 1) {
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayList.size() - 1);
                    ArrayList<String> arrayList13 = new ArrayList<>(arrayList.size() - 1);
                    if (1 < arrayList.size()) {
                        arrayList.get(1).getClass();
                        s1.d();
                        return null;
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList12);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList13);
                }
                bfVar = bfVar2;
                str7 = "packageName";
                str8 = "BillingClient";
            }
            afVar = this;
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !afVar.n) {
                df dfVar7 = zl1.p;
                afVar.w(21, 2, dfVar7);
                afVar.y(dfVar7);
                return dfVar7;
            }
            bf bfVar7 = bfVar;
            String str18 = str7;
            if (TextUtils.isEmpty(bfVar7.a.b.optString(str18))) {
                z2 = false;
            } else {
                bundle.putString("skuPackageName", bfVar7.a.b.optString(str18));
                z2 = true;
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("accountName", null);
            }
            Intent intent = z7Var.getIntent();
            if (intent == null) {
                str5 = str8;
                pn1.g(str5, "Activity's intent is null.");
            } else {
                str5 = str8;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra);
                    try {
                        str11 = str4;
                        try {
                            bundle.putString(str11, afVar.f.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                        } catch (PackageManager.NameNotFoundException unused) {
                            bundle.putString(str11, "package not found");
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str11 = str4;
                    }
                }
            }
            if (afVar.q && !em1Var.isEmpty()) {
                i2 = 17;
            } else if (afVar.o && z2) {
                i2 = 15;
            } else if (afVar.m) {
                i3 = 9;
                final String str19 = str;
                final String str20 = str2;
                futureH = h(new Callable(i3, str20, str19, cfVar, bundle) { // from class: tk1
                    public final /* synthetic */ int b;
                    public final /* synthetic */ String c;
                    public final /* synthetic */ String d;
                    public final /* synthetic */ Bundle e;

                    {
                        this.e = bundle;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Bundle bundleI;
                        sk1 sk1Var;
                        af afVar2 = this.a;
                        int i15 = this.b;
                        String str21 = this.c;
                        String str22 = this.d;
                        Bundle bundle2 = this.e;
                        try {
                            synchronized (afVar2.a) {
                                sk1Var = afVar2.h;
                            }
                            if (sk1Var == null) {
                                return pn1.i(zl1.k, 119);
                            }
                            return ((pk1) sk1Var).f(i15, afVar2.f.getPackageName(), str21, str22, bundle2);
                        } catch (DeadObjectException e) {
                            df dfVar8 = zl1.k;
                            String strA = vl1.a(e);
                            bundleI = pn1.i(dfVar8, 5);
                            if (strA != null) {
                                bundleI.putString("ADDITIONAL_LOG_DETAILS", strA);
                            }
                            return bundleI;
                        } catch (Exception e2) {
                            df dfVar9 = zl1.i;
                            String strA2 = vl1.a(e2);
                            bundleI = pn1.i(dfVar9, 5);
                            if (strA2 != null) {
                                bundleI.putString("ADDITIONAL_LOG_DETAILS", strA2);
                            }
                            return bundleI;
                        }
                    }
                }, 5000L, null, afVar.d, afVar.l());
            } else {
                i2 = 6;
            }
            i3 = i2;
            final String str192 = str;
            final String str202 = str2;
            futureH = h(new Callable(i3, str202, str192, cfVar, bundle) { // from class: tk1
                public final /* synthetic */ int b;
                public final /* synthetic */ String c;
                public final /* synthetic */ String d;
                public final /* synthetic */ Bundle e;

                {
                    this.e = bundle;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundleI;
                    sk1 sk1Var;
                    af afVar2 = this.a;
                    int i15 = this.b;
                    String str21 = this.c;
                    String str22 = this.d;
                    Bundle bundle2 = this.e;
                    try {
                        synchronized (afVar2.a) {
                            sk1Var = afVar2.h;
                        }
                        if (sk1Var == null) {
                            return pn1.i(zl1.k, 119);
                        }
                        return ((pk1) sk1Var).f(i15, afVar2.f.getPackageName(), str21, str22, bundle2);
                    } catch (DeadObjectException e) {
                        df dfVar8 = zl1.k;
                        String strA = vl1.a(e);
                        bundleI = pn1.i(dfVar8, 5);
                        if (strA != null) {
                            bundleI.putString("ADDITIONAL_LOG_DETAILS", strA);
                        }
                        return bundleI;
                    } catch (Exception e2) {
                        df dfVar9 = zl1.i;
                        String strA2 = vl1.a(e2);
                        bundleI = pn1.i(dfVar9, 5);
                        if (strA2 != null) {
                            bundleI.putString("ADDITIONAL_LOG_DETAILS", strA2);
                        }
                        return bundleI;
                    }
                }
            }, 5000L, null, afVar.d, afVar.l());
        } else {
            str5 = "BillingClient";
            futureH = h(new rk1(afVar, str2, str, 3), 5000L, null, afVar.d, afVar.l());
        }
        try {
            if (futureH == null) {
                df dfVar8 = zl1.d;
                afVar.w(25, 2, dfVar8);
                afVar.y(dfVar8);
                return dfVar8;
            }
            Bundle bundle2 = (Bundle) futureH.get(5000L, TimeUnit.MILLISECONDS);
            int iA = pn1.a(str5, bundle2);
            String strE = pn1.e(str5, bundle2);
            if (iA == 0) {
                Intent intent2 = new Intent(z7Var, (Class<?>) ProxyBillingActivity.class);
                String str21 = str3;
                intent2.putExtra(str21, (PendingIntent) bundle2.getParcelable(str21));
                z7Var.startActivity(intent2);
                return zl1.j;
            }
            pn1.g(str5, "Unable to buy item, Error response code: " + iA);
            df dfVarA2 = zl1.a(strE, iA);
            if (bundle2 == null) {
                iD = 1;
            } else {
                try {
                    Object obj2 = bundle2.get("LOG_REASON");
                    if (obj2 != null) {
                        if (obj2 instanceof Integer) {
                            iD = yb0.D(((Integer) obj2).intValue());
                        } else {
                            pn1.g(str5, "Unexpected type for bundle log reason: " + obj2.getClass().getName());
                        }
                    }
                } catch (Throwable th) {
                    pn1.g(str5, "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                }
                iD = 1;
            }
            if (iD == 1) {
                iD = 23;
            }
            if (bundle2 == null) {
                i = 2;
                string = null;
            } else {
                try {
                    string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                    i = 2;
                } catch (Throwable th2) {
                    pn1.g(str5, "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    i = 2;
                    string = null;
                }
            }
            afVar.x(iD, i, dfVarA2, string);
            afVar.y(dfVarA2);
            return dfVarA2;
        } catch (CancellationException e) {
            e = e;
            pn1.h(str5, "Time out while launching billing flow. Try to reconnect", e);
            df dfVar9 = zl1.l;
            afVar.x(4, 2, dfVar9, vl1.a(e));
            afVar.y(dfVar9);
            return dfVar9;
        } catch (TimeoutException e2) {
            e = e2;
            pn1.h(str5, "Time out while launching billing flow. Try to reconnect", e);
            df dfVar92 = zl1.l;
            afVar.x(4, 2, dfVar92, vl1.a(e));
            afVar.y(dfVar92);
            return dfVar92;
        } catch (Exception e3) {
            pn1.h(str5, "Exception while launching billing flow. Try to reconnect", e3);
            df dfVar10 = zl1.k;
            afVar.x(5, 2, dfVar10, vl1.a(e3));
            afVar.y(dfVar10);
            return dfVar10;
        }
    }

    public void e(gs0 gs0Var, ir0 ir0Var) {
        if (!c()) {
            df dfVar = zl1.k;
            w(2, 7, dfVar);
            ir0Var.e(dfVar, new ArrayList());
        } else {
            if (!this.q) {
                pn1.g("BillingClient", "Querying product details is not supported.");
                df dfVar2 = zl1.q;
                w(20, 7, dfVar2);
                ir0Var.e(dfVar2, new ArrayList());
                return;
            }
            if (h(new rk1(this, gs0Var, ir0Var, 0), 30000L, new vn1(this, 17, ir0Var), u(), l()) == null) {
                df dfVarI = i();
                w(25, 7, dfVarI);
                ir0Var.e(dfVarI, new ArrayList());
            }
        }
    }

    public final void f(c1 c1Var, as0 as0Var) {
        String str = c1Var.c;
        if (!c()) {
            w(2, 9, zl1.k);
            bm1 bm1Var = em1.c;
            as0Var.a(tm1.f);
        } else {
            if (TextUtils.isEmpty(str)) {
                pn1.g("BillingClient", "Please provide a valid product type.");
                w(50, 9, zl1.f);
                bm1 bm1Var2 = em1.c;
                as0Var.a(tm1.f);
                return;
            }
            if (h(new rk1(this, str, as0Var, 1), 30000L, new vn1(this, 14, as0Var), u(), l()) == null) {
                w(25, 9, i());
                bm1 bm1Var3 = em1.c;
                as0Var.a(tm1.f);
            }
        }
    }

    public void g(sp1 sp1Var) {
        df dfVarV;
        df dfVar;
        synchronized (this.a) {
            try {
                if (c()) {
                    dfVarV = v();
                } else {
                    if (this.b == 1) {
                        pn1.g("BillingClient", "Client is already in the process of connecting to billing service.");
                        dfVar = zl1.e;
                        w(37, 6, dfVar);
                    } else if (this.b == 3) {
                        pn1.g("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                        dfVar = zl1.k;
                        w(38, 6, dfVar);
                    } else {
                        o(1);
                        p();
                        pn1.f("BillingClient", "Starting in-app billing setup.");
                        this.i = new bl1(this, sp1Var);
                        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                        intent.setPackage("com.android.vending");
                        List<ResolveInfo> listQueryIntentServices = this.f.getPackageManager().queryIntentServices(intent, 0);
                        int i = 41;
                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                            o(0);
                            pn1.f("BillingClient", "Billing service unavailable on device.");
                            df dfVar2 = zl1.c;
                            w(i, 6, dfVar2);
                            dfVarV = dfVar2;
                        } else {
                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                            i = 40;
                            if (serviceInfo != null) {
                                String str = serviceInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                    pn1.g("BillingClient", "The device doesn't have valid Play Store.");
                                } else {
                                    ComponentName componentName = new ComponentName(str, str2);
                                    Intent intent2 = new Intent(intent);
                                    intent2.setComponent(componentName);
                                    intent2.putExtra("playBillingLibraryVersion", this.c);
                                    synchronized (this.a) {
                                        try {
                                            if (this.b == 2) {
                                                dfVarV = v();
                                            } else if (this.b != 1) {
                                                pn1.g("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                                dfVar = zl1.k;
                                                w(117, 6, dfVar);
                                            } else {
                                                bl1 bl1Var = this.i;
                                                if (this.f.bindService(intent2, bl1Var, 1)) {
                                                    pn1.f("BillingClient", "Service was bonded successfully.");
                                                    dfVarV = null;
                                                } else {
                                                    pn1.g("BillingClient", "Connection to Billing service is blocked.");
                                                    i = 39;
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            } else {
                                pn1.g("BillingClient", "The device doesn't have valid Play Store.");
                            }
                            o(0);
                            pn1.f("BillingClient", "Billing service unavailable on device.");
                            df dfVar22 = zl1.c;
                            w(i, 6, dfVar22);
                            dfVarV = dfVar22;
                        }
                    }
                    dfVarV = dfVar;
                }
            } finally {
            }
        }
        if (dfVarV != null) {
            ((xg) sp1Var.c).d();
        }
    }

    public final df i() {
        int[] iArr = {0, 3};
        synchronized (this.a) {
            for (int i = 0; i < 2; i++) {
                if (this.b == iArr[i]) {
                    return zl1.k;
                }
            }
            return zl1.i;
        }
    }

    public final void j() {
        if (TextUtils.isEmpty(null)) {
            this.f.getPackageName();
        }
    }

    public final synchronized ExecutorService l() {
        try {
            if (this.w == null) {
                this.w = Executors.newFixedThreadPool(pn1.a, new vk1());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.w;
    }

    public final void m(sq1 sq1Var) {
        try {
            pn0 pn0Var = this.g;
            int i = this.k;
            pn0Var.getClass();
            try {
                dr1 dr1Var = (dr1) ((er1) pn0Var.c).g();
                dr1Var.c();
                er1.o((er1) dr1Var.c, i);
                pn0Var.c = (er1) dr1Var.b();
                pn0Var.b0(sq1Var);
            } catch (Throwable th) {
                pn1.h("BillingLogger", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            pn1.h("BillingClient", "Unable to log.", th2);
        }
    }

    public final void n(wq1 wq1Var) {
        try {
            pn0 pn0Var = this.g;
            int i = this.k;
            pn0Var.getClass();
            try {
                dr1 dr1Var = (dr1) ((er1) pn0Var.c).g();
                dr1Var.c();
                er1.o((er1) dr1Var.c, i);
                pn0Var.c = (er1) dr1Var.b();
                pn0Var.c0(wq1Var);
            } catch (Throwable th) {
                pn1.h("BillingLogger", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            pn1.h("BillingClient", "Unable to log.", th2);
        }
    }

    public final void o(int i) {
        synchronized (this.a) {
            try {
                if (this.b == 3) {
                    return;
                }
                int i2 = this.b;
                pn1.f("BillingClient", "Setting clientState from " + (i2 != 0 ? i2 != 1 ? i2 != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED") + " to " + (i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED"));
                this.b = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() {
        synchronized (this.a) {
            if (this.i != null) {
                try {
                    this.f.unbindService(this.i);
                } catch (Throwable th) {
                    try {
                        pn1.h("BillingClient", "There was an exception while unbinding service!", th);
                        this.h = null;
                        this.i = null;
                    } finally {
                        this.h = null;
                        this.i = null;
                    }
                }
            }
        }
    }

    public final f9 q(df dfVar, int i, String str, Exception exc) {
        pn1.h("BillingClient", str, exc);
        x(i, 7, dfVar, vl1.a(exc));
        return new f9(dfVar.a, dfVar.b, new ArrayList());
    }

    public final pn0 r(df dfVar, int i, String str, Exception exc) {
        pn1.h("BillingClient", str, exc);
        x(i, 11, dfVar, vl1.a(exc));
        return new pn0(dfVar, 22, (Object) null);
    }

    public final tb0 s(df dfVar, int i, String str, Exception exc) {
        x(i, 9, dfVar, vl1.a(exc));
        pn1.h("BillingClient", str, exc);
        return new tb0(dfVar, (ArrayList) null);
    }

    public final void t(df dfVar, int i, Exception exc) {
        pn1.h("BillingClient", "Error in acknowledge purchase!", exc);
        x(i, 3, dfVar, vl1.a(exc));
        s1.o(dfVar);
    }

    public final Handler u() {
        return Looper.myLooper() == null ? this.d : new Handler(Looper.myLooper());
    }

    public final df v() {
        pn1.f("BillingClient", "Service connection is valid. No need to re-initialize.");
        vq1 vq1VarQ = wq1.q();
        vq1VarQ.c();
        wq1.p((wq1) vq1VarQ.c, 6);
        qr1 qr1VarP = rr1.p();
        qr1VarP.c();
        rr1.o((rr1) qr1VarP.c);
        vq1VarQ.c();
        wq1.o((wq1) vq1VarQ.c, (rr1) qr1VarP.b());
        n((wq1) vq1VarQ.b());
        return zl1.j;
    }

    public final void w(int i, int i2, df dfVar) {
        try {
            m(vl1.b(i, i2, dfVar));
        } catch (Throwable th) {
            pn1.h("BillingClient", "Unable to log.", th);
        }
    }

    public final void x(int i, int i2, df dfVar, String str) {
        try {
            m(vl1.c(i, i2, dfVar, str));
        } catch (Throwable th) {
            pn1.h("BillingClient", "Unable to log.", th);
        }
    }

    public final void y(df dfVar) {
        if (Thread.interrupted()) {
            return;
        }
        this.d.post(new vn1(this, 19, dfVar));
    }

    public af(ix ixVar, z7 z7Var, sf sfVar) {
        String strK = k();
        this.a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.k = 0;
        long jNextLong = new Random().nextLong();
        this.y = Long.valueOf(jNextLong);
        this.c = strK;
        this.f = z7Var.getApplicationContext();
        dr1 dr1VarS = er1.s();
        dr1VarS.c();
        er1.r((er1) dr1VarS.c, strK);
        String packageName = this.f.getPackageName();
        dr1VarS.c();
        er1.q((er1) dr1VarS.c, packageName);
        dr1VarS.c();
        er1.p((er1) dr1VarS.c, jNextLong);
        this.g = new pn0(this.f, (er1) dr1VarS.b());
        if (sfVar == null) {
            pn1.g("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.e = new o90(this.f, sfVar, this.g);
        this.u = ixVar;
        this.v = false;
        this.f.getPackageName();
    }
}
