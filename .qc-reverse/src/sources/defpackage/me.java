package defpackage;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class me implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            message.obj.getClass();
            s1.d();
            return false;
        }
        if (i != 1) {
            return false;
        }
        message.obj.getClass();
        s1.d();
        return false;
    }
}
