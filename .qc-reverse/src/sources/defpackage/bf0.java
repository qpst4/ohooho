package defpackage;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bf0 {
    public static final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public static i7 a(String str) throws GeneralSecurityException {
        for (i7 i7Var : a) {
            i7Var.getClass();
            if (str.toLowerCase().startsWith("android-keystore://")) {
                return i7Var;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
