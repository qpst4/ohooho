package defpackage;

import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lj0 {
    public static final KeyGenParameterSpec a = new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build();

    public static String a(KeyGenParameterSpec keyGenParameterSpec) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        if (keyGenParameterSpec.getKeySize() != 256) {
            s1.g("invalid key size, want 256 bits got ", keyGenParameterSpec.getKeySize(), " bits");
            return null;
        }
        if (keyGenParameterSpec.getBlockModes().equals(new String[]{"GCM"})) {
            s1.j("invalid block mode, want GCM got ", Arrays.toString(keyGenParameterSpec.getBlockModes()));
            return null;
        }
        if (keyGenParameterSpec.getPurposes() != 3) {
            ay0.d("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got ", keyGenParameterSpec.getPurposes());
            return null;
        }
        if (keyGenParameterSpec.getEncryptionPaddings().equals(new String[]{"NoPadding"})) {
            s1.j("invalid padding mode, want NoPadding got ", Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
            return null;
        }
        String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (!keyStore.containsAlias(keystoreAlias)) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(keyGenParameterSpec);
            keyGenerator.generateKey();
        }
        return keyGenParameterSpec.getKeystoreAlias();
    }
}
