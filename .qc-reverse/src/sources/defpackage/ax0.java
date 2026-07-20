package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ax0 implements bx0, t31 {
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ ax0(long j, Object obj, Object obj2) {
        this.c = obj;
        this.d = obj2;
        this.b = j;
    }

    @Override // defpackage.bx0
    public Object apply(Object obj) {
        String str = (String) this.c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((pi0) this.d).b;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
        try {
            boolean z = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j = this.b;
            if (z) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i));
            contentValues.put("events_dropped_count", Long.valueOf(j));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // defpackage.t31
    public Object f() {
        vd1 vd1Var = (vd1) this.c;
        hd hdVar = (hd) this.d;
        dx0 dx0Var = vd1Var.c;
        long jD = vd1Var.g.d() + this.b;
        dx0Var.getClass();
        dx0Var.h(new zw0(jD, hdVar));
        return null;
    }
}
