package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p6 implements lt {
    public static final List c = Arrays.asList(64);
    public static final byte[] d = new byte[16];
    public static final byte[] e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    public final d5 a;
    public final byte[] b;

    public p6(byte[] bArr) throws InvalidKeyException {
        if (c.contains(Integer.valueOf(bArr.length))) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.a = new d5(bArrCopyOfRange);
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    @Override // defpackage.lt
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            s1.l("plaintext too long");
            return null;
        }
        Cipher cipher = (Cipher) jz.e.a("AES/CTR/NoPadding");
        byte[] bArrC = c(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrC.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(1, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(bArr3));
        return f01.r(bArrC, cipher.doFinal(bArr));
    }

    @Override // defpackage.lt
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            s1.l("Ciphertext too short.");
            return null;
        }
        Cipher cipher = (Cipher) jz.e.a("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(bArr3));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null) {
            try {
                Class.forName("android.app.Application", false, null);
                bArrDoFinal = new byte[0];
            } catch (Exception unused) {
            }
        }
        if (f01.t(bArrCopyOfRange, c(bArr2, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    public final byte[] c(byte[]... bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        byte[] bArrU;
        int length = bArr.length;
        d5 d5Var = this.a;
        if (length == 0) {
            return d5Var.a(e);
        }
        byte[] bArrA = d5Var.a(d);
        for (int i = 0; i < bArr.length - 1; i++) {
            bArrA = f01.U(fp1.d(bArrA), d5Var.a(bArr[i]));
        }
        byte[] bArr2 = bArr[bArr.length - 1];
        if (bArr2.length >= 16) {
            if (bArr2.length < bArrA.length) {
                zy.n("xorEnd requires a.length >= b.length");
                return null;
            }
            int length2 = bArr2.length - bArrA.length;
            bArrU = Arrays.copyOf(bArr2, bArr2.length);
            for (int i2 = 0; i2 < bArrA.length; i2++) {
                int i3 = length2 + i2;
                bArrU[i3] = (byte) (bArrU[i3] ^ bArrA[i2]);
            }
        } else {
            if (bArr2.length >= 16) {
                zy.n("x must be smaller than a block.");
                return null;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr2, 16);
            bArrCopyOf[bArr2.length] = -128;
            bArrU = f01.U(bArrCopyOf, fp1.d(bArrA));
        }
        return d5Var.a(bArrU);
    }
}
