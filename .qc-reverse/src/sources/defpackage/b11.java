package defpackage;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b11 extends f01 {
    public sm m;
    public Uri n;

    @Override // defpackage.f01
    public final long D() {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.m.getContentResolver().query(this.n, new String[]{"_size"}, null, null, null);
                if (!cursorQuery.moveToFirst() || cursorQuery.isNull(0)) {
                    try {
                        l11.n(cursorQuery);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                    return 0L;
                }
                long j = cursorQuery.getLong(0);
                try {
                    l11.n(cursorQuery);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused2) {
                }
                return j;
            } catch (Exception e3) {
                Log.w("DocumentFile", "Failed query: " + e3);
                if (cursorQuery != null) {
                    try {
                        l11.n(cursorQuery);
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception unused3) {
                    }
                }
                return 0L;
            }
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                l11.n(cursorQuery);
                throw th;
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused4) {
                throw th;
            }
        }
    }
}
