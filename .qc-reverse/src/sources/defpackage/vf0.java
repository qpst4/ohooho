package defpackage;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vf0 extends OutputStream {
    public long b;

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.b += (long) i2;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.b += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.b++;
    }
}
