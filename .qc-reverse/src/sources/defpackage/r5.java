package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r5 implements za0 {
    public final SecretKeySpec a;
    public final int b;
    public final int c;

    public r5(int i, byte[] bArr) throws GeneralSecurityException {
        ee1.a(bArr.length);
        this.a = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) jz.e.a("AES/CTR/NoPadding")).getBlockSize();
        this.c = blockSize;
        if (i < 12 || i > blockSize) {
            s1.l("invalid IV size");
            throw null;
        }
        this.b = i;
    }

    @Override // defpackage.za0
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.b;
        if (length > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - i));
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] bArrA = dt0.a(i);
        System.arraycopy(bArrA, 0, bArr2, 0, i);
        c(bArr, 0, bArr.length, bArr2, this.b, bArrA, true);
        return bArr2;
    }

    @Override // defpackage.za0
    public final byte[] b(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.b;
        if (length < i) {
            s1.l("ciphertext too short");
            return null;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int length2 = bArr.length;
        int i2 = this.b;
        byte[] bArr3 = new byte[length2 - i2];
        c(bArr, i2, bArr.length - i2, bArr3, 0, bArr2, false);
        return bArr3;
    }

    public final void c(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3, boolean z) throws GeneralSecurityException {
        Cipher cipher = (Cipher) jz.e.a("AES/CTR/NoPadding");
        byte[] bArr4 = new byte[this.c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        SecretKeySpec secretKeySpec = this.a;
        if (z) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i2, bArr2, i3) == i2) {
            return;
        }
        s1.l("stored output's length does not match input's length");
    }
}
