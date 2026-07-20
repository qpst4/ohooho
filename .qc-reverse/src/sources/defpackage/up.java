package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class up extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up(Uri uri, String str) {
        super("crop: Failed to load sampled bitmap: " + uri + "\r\n" + str);
        uri.getClass();
    }
}
