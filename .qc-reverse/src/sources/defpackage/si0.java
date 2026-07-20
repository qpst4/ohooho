package defpackage;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class si0 {
    public static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void a(String str) {
        if (pn0.t().A()) {
            b(str);
        }
    }

    public static void b(String str) {
        Log.d("QuickCursorTag", str);
        pn0.t().b(a.format(new Date()) + ": " + str);
    }
}
