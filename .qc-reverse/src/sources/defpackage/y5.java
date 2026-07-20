package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y5 implements x4 {
    public final byte[] a;
    public final byte[] b;
    public final SecretKeySpec c;
    public final int d;

    public y5(int i, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i != 12 && i != 16) {
            zy.n("IV size should be either 12 or 16 bytes");
            throw null;
        }
        this.d = i;
        ee1.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.c = secretKeySpec;
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, secretKeySpec);
        byte[] bArrC = c(cipher.doFinal(new byte[16]));
        this.a = bArrC;
        this.b = c(bArrC);
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) (((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // defpackage.x4
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.d;
        if (length > 2147483631 - i) {
            s1.l("plaintext too long");
            return null;
        }
        byte[] bArr3 = new byte[bArr.length + i + 16];
        byte[] bArrA = dt0.a(i);
        System.arraycopy(bArrA, 0, bArr3, 0, i);
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        SecretKeySpec secretKeySpec = this.c;
        cipher.init(1, secretKeySpec);
        byte[] bArrD = d(cipher, 0, bArrA, 0, bArrA.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrD));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.d);
        byte[] bArrD3 = d(cipher, 2, bArr3, this.d, bArr.length);
        int length2 = bArr.length + i;
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[length2 + i2] = (byte) ((bArrD2[i2] ^ bArrD[i2]) ^ bArrD3[i2]);
        }
        return bArr3;
    }

    @Override // defpackage.x4
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.d;
        int i2 = (length - i) - 16;
        if (i2 < 0) {
            s1.l("ciphertext too short");
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        SecretKeySpec secretKeySpec = this.c;
        cipher.init(1, secretKeySpec);
        byte[] bArrD = d(cipher, 0, bArr, 0, this.d);
        byte[] bArr3 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrD3 = d(cipher, 2, bArr, this.d, i2);
        int length2 = bArr.length - 16;
        byte b = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            b = (byte) (b | (((bArr[length2 + i3] ^ bArrD2[i3]) ^ bArrD[i3]) ^ bArrD3[i3]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrD));
        return cipher2.doFinal(bArr, i, i2);
    }

    public final byte[] d(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrCopyOf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        byte[] bArr3 = this.a;
        if (i3 == 0) {
            return cipher.doFinal(e(bArr2, bArr3));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArrDoFinal[i5] = (byte) (bArrDoFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i4 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (bArrCopyOfRange.length == 16) {
            bArrCopyOf = e(bArrCopyOfRange, bArr3);
        } else {
            bArrCopyOf = Arrays.copyOf(this.b, 16);
            for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                bArrCopyOf[i6] = (byte) (bArrCopyOf[i6] ^ bArrCopyOfRange[i6]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
        }
        return cipher.doFinal(e(bArrDoFinal, bArrCopyOf));
    }
}
