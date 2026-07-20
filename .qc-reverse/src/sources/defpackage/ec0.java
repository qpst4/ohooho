package defpackage;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ec0 {
    public static final Charset a = Charset.forName("UTF-8");
    public static final byte[] b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        cl clVar = new cl(bArr, 0, 0, false);
        try {
            int i = clVar.f;
            if (i > Integer.MAX_VALUE) {
                throw new ic0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            clVar.g = i;
            clVar.j();
        } catch (ic0 e) {
            throw new IllegalArgumentException(e);
        }
    }
}
