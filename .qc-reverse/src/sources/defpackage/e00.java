package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e00 extends zz {
    public e00(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.b.mark(Integer.MAX_VALUE);
        } else {
            zy.n("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            throw null;
        }
    }

    public final void g(long j) throws IOException {
        int i = this.c;
        if (i > j) {
            this.c = 0;
            this.b.reset();
        } else {
            j -= (long) i;
        }
        a((int) j);
    }

    public e00(byte[] bArr) {
        super(bArr);
        this.b.mark(Integer.MAX_VALUE);
    }
}
