package defpackage;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rd1 implements t31 {
    public final /* synthetic */ int b;
    public final /* synthetic */ dx0 c;

    public /* synthetic */ rd1(dx0 dx0Var, int i) {
        this.b = i;
        this.c = dx0Var;
    }

    @Override // defpackage.t31
    public final Object f() {
        int i = this.b;
        dx0 dx0Var = this.c;
        switch (i) {
            case 0:
                dx0Var.getClass();
                int i2 = wk.e;
                g7 g7Var = new g7();
                g7Var.c = null;
                g7Var.d = new ArrayList();
                g7Var.e = null;
                g7Var.b = "";
                HashMap map = new HashMap();
                SQLiteDatabase sQLiteDatabaseA = dx0Var.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    wk wkVar = (wk) dx0.s(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new qs(dx0Var, map, g7Var, 4));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return wkVar;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            default:
                Integer num = (Integer) dx0Var.h(new zw0(dx0Var, dx0Var.c.d() - dx0Var.e.d));
                num.getClass();
                return num;
        }
    }
}
