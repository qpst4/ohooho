package defpackage;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wy implements x4 {
    public final za0 a;
    public final d5 b;
    public final int c;

    public wy(za0 za0Var, d5 d5Var, int i) {
        this.a = za0Var;
        this.b = d5Var;
        this.c = i;
    }

    @Override // defpackage.x4
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrA = this.a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return f01.r(bArrA, this.b.a(f01.r(bArr2, bArrA, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }

    @Override // defpackage.x4
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.c;
        if (length < i) {
            s1.l("ciphertext too short");
            return null;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - i, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrR = f01.r(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8));
        d5 d5Var = this.b;
        switch (d5Var.a) {
            case 0:
                if (!f01.t(bArrCopyOfRange2, d5Var.a(bArrR))) {
                    s1.l("invalid MAC");
                }
                break;
            default:
                if (!f01.t(d5Var.a(bArrR), bArrCopyOfRange2)) {
                    s1.l("invalid MAC");
                }
                break;
        }
        return this.a.b(bArrCopyOfRange);
    }
}
