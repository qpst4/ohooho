package defpackage;

import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d5 {
    public final /* synthetic */ int a = 1;
    public final int b;
    public final SecretKeySpec c;
    public final Cloneable d;
    public final Serializable e;

    public d5(String str, SecretKeySpec secretKeySpec, int i) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        switch (str) {
            case "HMACSHA1":
                if (i > 20) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case "HMACSHA256":
                if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case "HMACSHA512":
                if (i > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
        }
        this.e = str;
        this.b = i;
        this.c = secretKeySpec;
        Mac mac = (Mac) jz.f.a(str);
        this.d = mac;
        mac.init(secretKeySpec);
    }

    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Mac mac;
        byte[] bArrU;
        int i = this.a;
        SecretKeySpec secretKeySpec = this.c;
        Object obj = this.e;
        Object obj2 = this.d;
        int i2 = this.b;
        switch (i) {
            case 0:
                Cipher cipher = (Cipher) jz.e.a("AES/ECB/NoPadding");
                cipher.init(1, secretKeySpec);
                int iMax = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
                if (iMax * 16 == bArr.length) {
                    bArrU = f01.T(bArr, (iMax - 1) * 16, (byte[]) obj2, 0, 16);
                } else {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length);
                    if (bArrCopyOfRange.length >= 16) {
                        zy.n("x must be smaller than a block.");
                        return null;
                    }
                    byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
                    bArrCopyOf[bArrCopyOfRange.length] = -128;
                    bArrU = f01.U(bArrCopyOf, (byte[]) obj);
                }
                byte[] bArrDoFinal = new byte[16];
                for (int i3 = 0; i3 < iMax - 1; i3++) {
                    bArrDoFinal = cipher.doFinal(f01.T(bArrDoFinal, 0, bArr, i3 * 16, 16));
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(cipher.doFinal(f01.U(bArrU, bArrDoFinal)), 0, bArr2, 0, i2);
                return bArr2;
            default:
                try {
                    mac = (Mac) ((Mac) obj2).clone();
                    break;
                } catch (CloneNotSupportedException unused) {
                    mac = (Mac) jz.f.a((String) obj);
                    mac.init(secretKeySpec);
                }
                mac.update(bArr);
                byte[] bArr3 = new byte[i2];
                System.arraycopy(mac.doFinal(), 0, bArr3, 0, i2);
                return bArr3;
        }
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [byte[], java.lang.Cloneable] */
    /* JADX WARN: Type inference failed for: r4v5, types: [byte[], java.io.Serializable] */
    public d5(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ee1.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.c = secretKeySpec;
        this.b = 16;
        Cipher cipher = (Cipher) jz.e.a("AES/ECB/NoPadding");
        cipher.init(1, secretKeySpec);
        ?? D = fp1.d(cipher.doFinal(new byte[16]));
        this.d = D;
        this.e = fp1.d(D);
    }
}
