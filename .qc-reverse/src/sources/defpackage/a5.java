package defpackage;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a5 implements x4 {
    public final /* synthetic */ int a = 2;
    public final Object b;

    public a5(String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        this.b = (SecretKey) keyStore.getKey(str, null);
    }

    public static AlgorithmParameterSpec c(int i, byte[] bArr) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i);
        } catch (ClassNotFoundException unused) {
            try {
                Class.forName("android.app.Application", false, null);
                return new IvParameterSpec(bArr, 0, i);
            } catch (Exception unused2) {
                s1.l("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
                return null;
            }
        }
    }

    @Override // defpackage.x4
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                sq0 sq0Var = (sq0) obj;
                byte[] bArr3 = sq0Var.b.b;
                return f01.r(bArr3 != null ? Arrays.copyOf(bArr3, bArr3.length) : null, ((x4) sq0Var.b.a).a(bArr, bArr2));
            case 1:
                if (bArr.length > 2147483619) {
                    s1.l("plaintext too long");
                    return null;
                }
                byte[] bArr4 = new byte[bArr.length + 28];
                byte[] bArrA = dt0.a(12);
                System.arraycopy(bArrA, 0, bArr4, 0, 12);
                Cipher cipher = (Cipher) jz.e.a("AES/GCM/NoPadding");
                cipher.init(1, (SecretKeySpec) obj, c(bArrA.length, bArrA));
                if (bArr2 != null && bArr2.length != 0) {
                    cipher.updateAAD(bArr2);
                }
                int iDoFinal = cipher.doFinal(bArr, 0, bArr.length, bArr4, 12);
                if (iDoFinal == bArr.length + 16) {
                    return bArr4;
                }
                throw new GeneralSecurityException("encryption failed; GCM tag must be 16 bytes, but got only " + (iDoFinal - bArr.length) + " bytes");
            default:
                if (bArr.length > 2147483619) {
                    s1.l("plaintext too long");
                    return null;
                }
                byte[] bArr5 = new byte[bArr.length + 28];
                Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
                cipher2.init(1, (SecretKey) obj);
                cipher2.updateAAD(bArr2);
                cipher2.doFinal(bArr, 0, bArr.length, bArr5, 12);
                System.arraycopy(cipher2.getIV(), 0, bArr5, 0, 12);
                return bArr5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be A[SYNTHETIC] */
    @Override // defpackage.x4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] b(byte[] r9, byte[] r10) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a5.b(byte[], byte[]):byte[]");
    }

    public a5(byte[] bArr) throws InvalidAlgorithmParameterException {
        ee1.a(bArr.length);
        this.b = new SecretKeySpec(bArr, "AES");
    }

    public a5(sq0 sq0Var) {
        this.b = sq0Var;
    }
}
