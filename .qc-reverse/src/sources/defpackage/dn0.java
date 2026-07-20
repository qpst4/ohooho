package defpackage;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dn0 {
    public final NotificationManager a;

    static {
        new HashSet();
    }

    public dn0(Context context) {
        this.a = (NotificationManager) context.getSystemService("notification");
    }
}
