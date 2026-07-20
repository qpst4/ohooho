package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zw0 implements bx0 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;

    public /* synthetic */ zw0(long j, hd hdVar) {
        this.c = j;
        this.d = hdVar;
    }

    @Override // defpackage.bx0
    public final Object apply(Object obj) {
        int i = this.b;
        Object obj2 = this.d;
        long j = this.c;
        switch (i) {
            case 0:
                dx0 dx0Var = (dx0) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                dx0Var.getClass();
                String[] strArr = {String.valueOf(j)};
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        dx0Var.m(cursorRawQuery.getInt(0), pi0.d, cursorRawQuery.getString(1));
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                    break;
                }
                cursorRawQuery.close();
                return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
            default:
                hd hdVar = (hd) obj2;
                SQLiteDatabase sQLiteDatabase2 = (SQLiteDatabase) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j));
                String str = hdVar.a;
                tq0 tq0Var = hdVar.c;
                if (sQLiteDatabase2.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(vq0.a(tq0Var))}) < 1) {
                    contentValues.put("backend_name", str);
                    contentValues.put("priority", Integer.valueOf(vq0.a(tq0Var)));
                    sQLiteDatabase2.insert("transport_contexts", null, contentValues);
                }
                return null;
        }
    }

    public /* synthetic */ zw0(dx0 dx0Var, long j) {
        this.d = dx0Var;
        this.c = j;
    }
}
