package defpackage;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vg1 {
    public static boolean a;
    public static Method b;
    public static final boolean c;

    static {
        c = Build.VERSION.SDK_INT >= 27;
    }
}
