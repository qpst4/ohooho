package defpackage;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f6 extends fc0 {
    public final int l;

    public f6(byte[] bArr, int i, int i2) throws InvalidAlgorithmParameterException {
        if (bArr.length < 16 || bArr.length < i) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i));
        }
        ee1.a(i);
        if (i2 <= this.l + 24) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        Arrays.copyOf(bArr, bArr.length);
        this.l = i;
    }
}
