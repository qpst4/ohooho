package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r21 {
    public static final ReentrantLock c = new ReentrantLock();
    public static r21 d;
    public final ReentrantLock a = new ReentrantLock();
    public final SharedPreferences b;

    public r21(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String a(String str) {
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            return this.b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
