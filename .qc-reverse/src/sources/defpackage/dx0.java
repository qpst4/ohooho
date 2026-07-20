package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dx0 implements Closeable {
    public static final uy g = new uy("proto");
    public final vx0 b;
    public final xk c;
    public final xk d;
    public final zc e;
    public final wr0 f;

    public dx0(xk xkVar, xk xkVar2, zc zcVar, vx0 vx0Var, wr0 wr0Var) {
        this.b = vx0Var;
        this.c = xkVar;
        this.d = xkVar2;
        this.e = zcVar;
        this.f = wr0Var;
    }

    public static Long g(SQLiteDatabase sQLiteDatabase, hd hdVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(hdVar.a, String.valueOf(vq0.a(hdVar.c))));
        byte[] bArr = hdVar.b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String r(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((ed) it.next()).a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object s(Cursor cursor, bx0 bx0Var) {
        try {
            return bx0Var.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        vx0 vx0Var = this.b;
        Objects.requireNonNull(vx0Var);
        xk xkVar = this.d;
        long jD = xkVar.d();
        while (true) {
            try {
                return vx0Var.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (xkVar.d() >= ((long) this.e.c) + jD) {
                    throw new s31("Timed out while trying to open db.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    public final Object h(bx0 bx0Var) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = bx0Var.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final ArrayList i(SQLiteDatabase sQLiteDatabase, hd hdVar, int i) {
        ArrayList arrayList = new ArrayList();
        Long lG = g(sQLiteDatabase, hdVar);
        if (lG == null) {
            return arrayList;
        }
        s(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lG.toString()}, null, null, null, String.valueOf(i)), new qs(this, (Object) arrayList, hdVar, 3));
        return arrayList;
    }

    public final void m(long j, pi0 pi0Var, String str) {
        h(new ax0(j, str, pi0Var));
    }

    public final Object q(t31 t31Var) {
        SQLiteDatabase sQLiteDatabaseA = a();
        xk xkVar = this.d;
        long jD = xkVar.d();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objF = t31Var.f();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objF;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (xkVar.d() >= ((long) this.e.c) + jD) {
                    throw new s31("Timed out while trying to acquire the lock.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
