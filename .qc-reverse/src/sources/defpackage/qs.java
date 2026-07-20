package defpackage;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qs implements t31, q2, bx0, hh0, e4 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ qs(dx0 dx0Var, Object obj, hd hdVar, int i) {
        this.b = i;
        this.c = dx0Var;
        this.e = obj;
        this.d = hdVar;
    }

    @Override // defpackage.hh0
    public void a(jh0 jh0Var) {
        m3 m3Var = (m3) this.c;
        n3 n3Var = (n3) this.d;
        Boolean bool = (Boolean) this.e;
        l3 l3Var = m01.k;
        if (jh0Var == null) {
            return;
        }
        m01.p(m3Var, n3Var, bool, jh0Var.d.toString());
    }

    @Override // defpackage.bx0
    public Object apply(Object obj) throws Throwable {
        long jInsert;
        Cursor cursor;
        dx0 dx0Var;
        pi0 pi0Var;
        int i = this.b;
        int i2 = 6;
        int i3 = 5;
        int i4 = 4;
        int i5 = 3;
        pi0 pi0Var2 = pi0.e;
        int i6 = 2;
        int i7 = 1;
        Object obj2 = this.e;
        Object obj3 = this.d;
        Object obj4 = this.c;
        int i8 = 0;
        switch (i) {
            case 2:
                dx0 dx0Var2 = (dx0) obj4;
                yc ycVar = (yc) obj2;
                ry ryVar = ycVar.c;
                String str = ycVar.a;
                hd hdVar = (hd) obj3;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long jSimpleQueryForLong = dx0Var2.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * dx0Var2.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                zc zcVar = dx0Var2.e;
                if (jSimpleQueryForLong >= zcVar.a) {
                    dx0Var2.m(1L, pi0Var2, str);
                    return -1L;
                }
                Long lG = dx0.g(sQLiteDatabase, hdVar);
                if (lG != null) {
                    jInsert = lG.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", hdVar.a);
                    contentValues.put("priority", Integer.valueOf(vq0.a(hdVar.c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = hdVar.b;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i9 = zcVar.e;
                byte[] bArr2 = ryVar.b;
                boolean z = bArr2.length <= i9;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(ycVar.d));
                contentValues2.put("uptime_ms", Long.valueOf(ycVar.e));
                contentValues2.put("payload_encoding", ryVar.a.a);
                contentValues2.put("code", ycVar.b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                contentValues2.put("payload", z ? bArr2 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i9));
                    for (int i10 = 1; i10 <= iCeil; i10++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i10 - 1) * i9, Math.min(i10 * i9, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i10));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(ycVar.f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 3:
                dx0 dx0Var3 = (dx0) obj4;
                ArrayList arrayList = (ArrayList) obj2;
                hd hdVar2 = (hd) obj3;
                Cursor cursor2 = (Cursor) obj;
                while (cursor2.moveToNext()) {
                    long j = cursor2.getLong(0);
                    int i11 = cursor2.getInt(7) != 0 ? i7 : 0;
                    a9 a9Var = new a9();
                    a9Var.f = new HashMap();
                    String string = cursor2.getString(i7);
                    if (string == null) {
                        zy.r("Null transportName");
                        return null;
                    }
                    a9Var.a = string;
                    a9Var.d = Long.valueOf(cursor2.getLong(i6));
                    a9Var.e = Long.valueOf(cursor2.getLong(3));
                    if (i11 != 0) {
                        String string2 = cursor2.getString(4);
                        a9Var.c = new ry(string2 == null ? dx0.g : new uy(string2), cursor2.getBlob(5));
                        dx0Var = dx0Var3;
                    } else {
                        String string3 = cursor2.getString(4);
                        uy uyVar = string3 == null ? dx0.g : new uy(string3);
                        Cursor cursorQuery = dx0Var3.a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList2 = new ArrayList();
                            int length = 0;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList2.add(blob);
                                length += blob.length;
                                break;
                            }
                            byte[] bArr3 = new byte[length];
                            int i12 = 0;
                            int length2 = 0;
                            while (i12 < arrayList2.size()) {
                                byte[] bArr4 = (byte[]) arrayList2.get(i12);
                                dx0 dx0Var4 = dx0Var3;
                                cursor = cursorQuery;
                                try {
                                    System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
                                    length2 += bArr4.length;
                                    i12++;
                                    cursorQuery = cursor;
                                    dx0Var3 = dx0Var4;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            }
                            dx0Var = dx0Var3;
                            cursorQuery.close();
                            a9Var.c = new ry(uyVar, bArr3);
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        a9Var.b = Integer.valueOf(cursor2.getInt(6));
                    }
                    arrayList.add(new ed(j, hdVar2, a9Var.c()));
                    dx0Var3 = dx0Var;
                    i6 = 2;
                    i7 = 1;
                }
                return null;
            default:
                dx0 dx0Var5 = (dx0) obj4;
                HashMap map = (HashMap) obj3;
                g7 g7Var = (g7) obj2;
                ArrayList arrayList3 = (ArrayList) g7Var.d;
                Cursor cursor3 = (Cursor) obj;
                dx0Var5.getClass();
                while (cursor3.moveToNext()) {
                    String string4 = cursor3.getString(i8);
                    int i13 = cursor3.getInt(1);
                    pi0 pi0Var3 = pi0.c;
                    if (i13 != 0) {
                        if (i13 == 1) {
                            pi0Var3 = pi0.d;
                        } else if (i13 == 2) {
                            pi0Var = pi0Var2;
                        } else if (i13 == i5) {
                            pi0Var3 = pi0.f;
                        } else if (i13 == i4) {
                            pi0Var3 = pi0.g;
                        } else if (i13 == i3) {
                            pi0Var3 = pi0.h;
                        } else if (i13 == i2) {
                            pi0Var3 = pi0.i;
                        } else {
                            lc1.p("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i13));
                        }
                        pi0Var = pi0Var3;
                    } else {
                        pi0Var = pi0Var3;
                    }
                    long j2 = cursor3.getLong(2);
                    if (!map.containsKey(string4)) {
                        map.put(string4, new ArrayList());
                    }
                    ((List) map.get(string4)).add(new qi0(j2, pi0Var));
                    i2 = 6;
                    i3 = 5;
                    i4 = 4;
                    i5 = 3;
                    i8 = 0;
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    int i14 = ti0.c;
                    new ArrayList();
                    arrayList3.add(new ti0((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                }
                long jD = dx0Var5.c.d();
                SQLiteDatabase sQLiteDatabaseA = dx0Var5.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                    try {
                        cursorRawQuery.moveToNext();
                        v51 v51Var = new v51(cursorRawQuery.getLong(0), jD);
                        cursorRawQuery.close();
                        sQLiteDatabaseA.setTransactionSuccessful();
                        sQLiteDatabaseA.endTransaction();
                        g7Var.c = v51Var;
                        g7Var.e = new t60(new s21(dx0Var5.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * dx0Var5.a().compileStatement("PRAGMA page_count").simpleQueryForLong(), zc.f.a));
                        g7Var.b = (String) dx0Var5.f.get();
                        return new wk((v51) g7Var.c, Collections.unmodifiableList(arrayList3), (t60) g7Var.e, (String) g7Var.b);
                    } catch (Throwable th3) {
                        cursorRawQuery.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    sQLiteDatabaseA.endTransaction();
                    throw th4;
                }
        }
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        Bitmap bitmap;
        m3 m3Var = (m3) this.c;
        n3 n3Var = (n3) this.d;
        Intent intent = (Intent) this.e;
        d4 d4Var = (d4) obj;
        l3 l3Var = o41.k;
        String packageName = intent.getComponent().getPackageName();
        if (d4Var.b == -1) {
            Bundle extras = d4Var.c.getExtras();
            HashMap map = new HashMap();
            Intent intent2 = (Intent) extras.get("android.intent.extra.shortcut.INTENT");
            map.put("packageName", packageName);
            map.put("intent", intent2.toUri(0));
            if (extras.containsKey("android.intent.extra.shortcut.ICON") && (bitmap = (Bitmap) extras.get("android.intent.extra.shortcut.ICON")) != null) {
                map.put("ICON_BASE64_PNG", xr.j(bitmap));
            }
            m3Var.q(new i(n3Var, map));
        }
    }

    @Override // defpackage.t31
    public Object f() {
        ss ssVar = (ss) this.c;
        hd hdVar = (hd) this.d;
        yc ycVar = (yc) this.e;
        dx0 dx0Var = ssVar.d;
        dx0Var.getClass();
        tq0 tq0Var = hdVar.c;
        String str = ycVar.a;
        String str2 = hdVar.a;
        String strL = lc1.L("SQLiteEventStore");
        if (Log.isLoggable(strL, 3)) {
            Log.d(strL, "Storing event with priority=" + tq0Var + ", name=" + str + " for destination " + str2);
        }
        ((Long) dx0Var.h(new qs(dx0Var, (Object) ycVar, hdVar, 2))).getClass();
        ssVar.a.P(hdVar, 1, false);
        return null;
    }

    @Override // defpackage.q2
    public void i(i iVar) {
        EdgeActionsSettings edgeActionsSettings = (EdgeActionsSettings) this.c;
        nw nwVar = (nw) this.d;
        EdgeBarConstraintLayout edgeBarConstraintLayout = (EdgeBarConstraintLayout) this.e;
        int i = EdgeActionsSettings.S;
        if (iVar == null) {
            return;
        }
        nwVar.getEdgeAction().e(iVar);
        edgeActionsSettings.L(edgeBarConstraintLayout.getEdgeBar());
        try {
            ((rw) edgeActionsSettings.w().C(R.id.settings)).c0.getAdapter().d();
        } catch (Exception unused) {
            si0.b("Error at notifyAdapterChanged()");
        }
    }

    public /* synthetic */ qs(Object obj, Object obj2, Object obj3, int i) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }
}
