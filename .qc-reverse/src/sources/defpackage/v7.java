package defpackage;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class v7 extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public v7(Status status) {
        int i = status.b;
        String str = status.c;
        super(i + ": " + (str == null ? "" : str));
    }
}
