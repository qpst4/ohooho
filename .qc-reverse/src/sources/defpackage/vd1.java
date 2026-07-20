package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vd1 {
    public final Context a;
    public final tl0 b;
    public final dx0 c;
    public final ra d;
    public final Executor e;
    public final dx0 f;
    public final xk g;
    public final xk h;
    public final dx0 i;

    public vd1(Context context, tl0 tl0Var, dx0 dx0Var, ra raVar, Executor executor, dx0 dx0Var2, xk xkVar, xk xkVar2, dx0 dx0Var3) {
        this.a = context;
        this.b = tl0Var;
        this.c = dx0Var;
        this.d = raVar;
        this.e = executor;
        this.f = dx0Var2;
        this.g = xkVar;
        this.h = xkVar2;
        this.i = dx0Var3;
    }

    public final void a(final hd hdVar, int i) {
        byte[] bArr;
        long j;
        tc tcVar;
        String str;
        tc tcVar2;
        int i2;
        wi wiVarJ;
        String str2;
        Integer numValueOf;
        f71 f71Var;
        final vd1 vd1Var = this;
        final hd hdVar2 = hdVar;
        byte[] bArr2 = hdVar2.b;
        c91 c91VarA = vd1Var.b.a(hdVar2.a);
        long jMax = 0;
        while (true) {
            final int i3 = 0;
            t31 t31Var = new t31(vd1Var) { // from class: td1
                public final /* synthetic */ vd1 c;

                {
                    this.c = vd1Var;
                }

                @Override // defpackage.t31
                public final Object f() {
                    Boolean bool;
                    int i4 = i3;
                    hd hdVar3 = hdVar2;
                    vd1 vd1Var2 = this.c;
                    switch (i4) {
                        case 0:
                            dx0 dx0Var = vd1Var2.c;
                            SQLiteDatabase sQLiteDatabaseA = dx0Var.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lG = dx0.g(sQLiteDatabaseA, hdVar3);
                                if (lG == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = dx0Var.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lG.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseA.setTransactionSuccessful();
                                return bool;
                            } finally {
                                sQLiteDatabaseA.endTransaction();
                            }
                        default:
                            dx0 dx0Var2 = vd1Var2.c;
                            dx0Var2.getClass();
                            return (Iterable) dx0Var2.h(new ff(dx0Var2, 5, hdVar3));
                    }
                }
            };
            dx0 dx0Var = vd1Var.f;
            if (!((Boolean) dx0Var.q(t31Var)).booleanValue()) {
                dx0Var.q(new ax0(jMax, vd1Var, hdVar2));
                return;
            }
            final int i4 = 1;
            final Iterable iterable = (Iterable) dx0Var.q(new t31(vd1Var) { // from class: td1
                public final /* synthetic */ vd1 c;

                {
                    this.c = vd1Var;
                }

                @Override // defpackage.t31
                public final Object f() {
                    Boolean bool;
                    int i42 = i4;
                    hd hdVar3 = hdVar2;
                    vd1 vd1Var2 = this.c;
                    switch (i42) {
                        case 0:
                            dx0 dx0Var2 = vd1Var2.c;
                            SQLiteDatabase sQLiteDatabaseA = dx0Var2.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lG = dx0.g(sQLiteDatabaseA, hdVar3);
                                if (lG == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = dx0Var2.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lG.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseA.setTransactionSuccessful();
                                return bool;
                            } finally {
                                sQLiteDatabaseA.endTransaction();
                            }
                        default:
                            dx0 dx0Var22 = vd1Var2.c;
                            dx0Var22.getClass();
                            return (Iterable) dx0Var22.h(new ff(dx0Var22, 5, hdVar3));
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            if (c91VarA == null) {
                lc1.p("Uploader", "Unknown backend for %s, deleting event batch for it...", hdVar2);
                tcVar2 = new tc(3, -1L);
                bArr = bArr2;
                j = jMax;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ed) it.next()).c);
                }
                if (bArr2 != null) {
                    dx0 dx0Var2 = vd1Var.i;
                    Objects.requireNonNull(dx0Var2);
                    wk wkVar = (wk) dx0Var.q(new rd1(dx0Var2, i3));
                    a9 a9Var = new a9();
                    a9Var.f = new HashMap();
                    a9Var.d = Long.valueOf(vd1Var.g.d());
                    a9Var.e = Long.valueOf(vd1Var.h.d());
                    a9Var.a = "GDT_CLIENT_METRICS";
                    uy uyVar = new uy("proto");
                    wkVar.getClass();
                    ra raVar = pr0.a;
                    raVar.getClass();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        raVar.s(wkVar, byteArrayOutputStream);
                    } catch (IOException unused) {
                    }
                    a9Var.c = new ry(uyVar, byteArrayOutputStream.toByteArray());
                    arrayList.add(((xi) c91VarA).a(a9Var.c()));
                }
                xi xiVar = (xi) c91VarA;
                HashMap map = new HashMap();
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    yc ycVar = (yc) obj;
                    String str3 = ycVar.a;
                    if (map.containsKey(str3)) {
                        ((List) map.get(str3)).add(ycVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ycVar);
                        map.put(str3, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    yc ycVar2 = (yc) ((List) entry.getValue()).get(0);
                    fs0 fs0Var = fs0.b;
                    long jD = xiVar.f.d();
                    long jD2 = xiVar.e.d();
                    vc vcVar = new vc(new sc(Integer.valueOf(ycVar2.b("sdk-version")), ycVar2.a("model"), ycVar2.a("hardware"), ycVar2.a("device"), ycVar2.a("product"), ycVar2.a("os-uild"), ycVar2.a("manufacturer"), ycVar2.a("fingerprint"), ycVar2.a("locale"), ycVar2.a("country"), ycVar2.a("mcc_mnc"), ycVar2.a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused2) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (yc ycVar3 : (List) entry.getValue()) {
                        byte[] bArr3 = bArr2;
                        ry ryVar = ycVar3.c;
                        uy uyVar2 = ryVar.a;
                        byte[] bArr4 = ryVar.b;
                        long j2 = jMax;
                        if (uyVar2.equals(new uy("proto"))) {
                            f71Var = new f71();
                            f71Var.e = bArr4;
                        } else if (uyVar2.equals(new uy("json"))) {
                            String str4 = new String(bArr4, Charset.forName("UTF-8"));
                            f71 f71Var2 = new f71();
                            f71Var2.f = str4;
                            f71Var = f71Var2;
                        } else {
                            String strL = lc1.L("CctTransportBackend");
                            if (Log.isLoggable(strL, 5)) {
                                Log.w(strL, "Received event of unsupported encoding " + uyVar2 + ". Skipping...");
                            }
                            bArr2 = bArr3;
                            jMax = j2;
                        }
                        f71Var.b = Long.valueOf(ycVar3.d);
                        f71Var.d = Long.valueOf(ycVar3.e);
                        String str5 = (String) ycVar3.f.get("tz-offset");
                        f71Var.g = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        f71Var.h = new dd((tm0) tm0.b.get(ycVar3.b("net-type")), (sm0) sm0.b.get(ycVar3.b("mobile-subtype")));
                        Integer num = ycVar3.b;
                        if (num != null) {
                            f71Var.c = num;
                        }
                        String strConcat = ((Long) f71Var.b) == null ? " eventTimeMs" : "";
                        if (((Long) f71Var.d) == null) {
                            strConcat = strConcat.concat(" eventUptimeMs");
                        }
                        if (((Long) f71Var.g) == null) {
                            strConcat = strConcat.concat(" timezoneOffsetSeconds");
                        }
                        if (!strConcat.isEmpty()) {
                            s1.f("Missing required properties:".concat(strConcat));
                            return;
                        } else {
                            arrayList4.add(new ad(((Long) f71Var.b).longValue(), (Integer) f71Var.c, ((Long) f71Var.d).longValue(), (byte[]) f71Var.e, (String) f71Var.f, ((Long) f71Var.g).longValue(), (dd) f71Var.h));
                            bArr2 = bArr3;
                            jMax = j2;
                        }
                    }
                    arrayList3.add(new bd(jD, jD2, vcVar, numValueOf, str2, arrayList4));
                    bArr2 = bArr2;
                }
                bArr = bArr2;
                j = jMax;
                uc ucVar = new uc(arrayList3);
                URL urlB = xiVar.d;
                if (bArr != null) {
                    try {
                        bi biVarA = bi.a(bArr);
                        str = biVarA.b;
                        if (str == null) {
                            str = null;
                        }
                        urlB = xi.b(biVarA.a);
                    } catch (IllegalArgumentException unused3) {
                        tcVar = new tc(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    ra raVar2 = new ra(urlB, ucVar, str, 4);
                    r1 r1Var = new r1(7, xiVar);
                    int i6 = 5;
                    do {
                        wiVarJ = r1Var.j(raVar2);
                        URL url = wiVarJ.b;
                        if (url != null) {
                            lc1.p("CctTransportBackend", "Following redirect to: %s", url);
                            raVar2 = new ra(url, (uc) raVar2.d, (String) raVar2.e, 4);
                        } else {
                            raVar2 = null;
                        }
                        if (raVar2 == null) {
                            break;
                        } else {
                            i6--;
                        }
                    } while (i6 >= 1);
                    int i7 = wiVarJ.a;
                    if (i7 == 200) {
                        tcVar2 = new tc(1, wiVarJ.c);
                    } else {
                        if (i7 >= 500 || i7 == 404) {
                            tcVar = new tc(2, -1L);
                        } else if (i7 == 400) {
                            try {
                                tcVar = new tc(4, -1L);
                            } catch (IOException e) {
                                e = e;
                                lc1.r("CctTransportBackend", "Could not make request to the backend", e);
                                i2 = 2;
                                tcVar2 = new tc(2, -1L);
                            }
                        } else {
                            tcVar = new tc(3, -1L);
                        }
                        tcVar2 = tcVar;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
            i2 = 2;
            int i8 = tcVar2.a;
            if (i8 == i2) {
                final long j3 = j;
                dx0Var.q(new t31() { // from class: ud1
                    @Override // defpackage.t31
                    public final Object f() {
                        vd1 vd1Var2 = this.b;
                        dx0 dx0Var3 = vd1Var2.c;
                        dx0Var3.getClass();
                        Iterable iterable2 = iterable;
                        if (iterable2.iterator().hasNext()) {
                            String strConcat2 = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ".concat(dx0.r(iterable2));
                            SQLiteDatabase sQLiteDatabaseA = dx0Var3.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                sQLiteDatabaseA.compileStatement(strConcat2).execute();
                                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                                while (cursorRawQuery.moveToNext()) {
                                    try {
                                        dx0Var3.m(cursorRawQuery.getInt(0), pi0.g, cursorRawQuery.getString(1));
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                cursorRawQuery.close();
                                sQLiteDatabaseA.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                                sQLiteDatabaseA.setTransactionSuccessful();
                            } finally {
                                sQLiteDatabaseA.endTransaction();
                            }
                        }
                        dx0Var3.h(new zw0(vd1Var2.g.d() + j3, hdVar));
                        return null;
                    }
                });
                this.d.P(hdVar, i + 1, true);
                return;
            }
            vd1Var = this;
            hdVar2 = hdVar;
            jMax = j;
            dx0Var.q(new ff(vd1Var, 6, iterable));
            if (i8 == 1) {
                jMax = Math.max(jMax, tcVar2.b);
                if (bArr != null) {
                    dx0Var.q(new r1(23, vd1Var));
                }
            } else if (i8 == 4) {
                HashMap map2 = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String str6 = ((ed) it2.next()).c.a;
                    if (map2.containsKey(str6)) {
                        map2.put(str6, Integer.valueOf(((Integer) map2.get(str6)).intValue() + 1));
                    } else {
                        map2.put(str6, 1);
                    }
                }
                dx0Var.q(new ff(vd1Var, 7, map2));
            }
            bArr2 = bArr;
        }
    }
}
