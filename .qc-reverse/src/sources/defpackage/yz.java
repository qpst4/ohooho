package defpackage;

import android.media.MediaDataSource;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yz extends MediaDataSource {
    public long b;
    public final /* synthetic */ e00 c;

    public yz(e00 e00Var) {
        this.c = e00Var;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        e00 e00Var = this.c;
        DataInputStream dataInputStream = e00Var.b;
        if (i2 == 0) {
            return 0;
        }
        if (j >= 0) {
            try {
                long j2 = this.b;
                if (j2 != j) {
                    if (j2 < 0 || j < j2 + ((long) dataInputStream.available())) {
                        e00Var.g(j);
                        this.b = j;
                    }
                }
                if (i2 > dataInputStream.available()) {
                    i2 = dataInputStream.available();
                }
                int i3 = e00Var.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.b += (long) i3;
                    return i3;
                }
            } catch (IOException unused) {
            }
            this.b = -1L;
            return -1;
        }
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
