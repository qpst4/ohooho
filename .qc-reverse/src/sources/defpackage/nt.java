package defpackage;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nt implements lt {
    public final /* synthetic */ sq0 a;

    public nt(sq0 sq0Var) {
        this.a = sq0Var;
    }

    @Override // defpackage.lt
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        sq0 sq0Var = this.a;
        byte[] bArr3 = sq0Var.b.b;
        return f01.r(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((lt) sq0Var.b.a).a(bArr, bArr2));
    }

    @Override // defpackage.lt
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        sq0 sq0Var = this.a;
        if (length > 5) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = sq0Var.a(bArrCopyOfRange).iterator();
            while (it.hasNext()) {
                try {
                    return ((lt) ((rq0) it.next()).a).b(bArrCopyOfRange2, bArr2);
                } catch (GeneralSecurityException e) {
                    ot.a.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                }
            }
        }
        Iterator it2 = sq0Var.a(fp1.a).iterator();
        while (it2.hasNext()) {
            try {
                return ((lt) ((rq0) it2.next()).a).b(bArr, bArr2);
            } catch (GeneralSecurityException unused) {
            }
        }
        s1.l("decryption failed");
        return null;
    }
}
