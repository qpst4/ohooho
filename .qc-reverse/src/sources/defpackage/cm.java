package defpackage;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class cm extends RuntimeException {
    public cm(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }

    public cm() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
