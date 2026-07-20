package defpackage;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j20 implements Comparator {
    public final /* synthetic */ int b;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.b) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b2 = bArr2[i];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            default:
                try {
                    return ((to0) obj).b.compareToIgnoreCase(((to0) obj2).b);
                } catch (Throwable th) {
                    si0.b("getInstalledPackages sorted crash: " + th);
                    return 0;
                }
        }
    }
}
