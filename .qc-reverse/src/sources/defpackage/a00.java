package defpackage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a00 extends FilterOutputStream {
    public final OutputStream b;
    public ByteOrder c;

    public a00(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.b = outputStream;
        this.c = byteOrder;
    }

    public final void a(int i) throws IOException {
        this.b.write(i);
    }

    public final void g(int i) throws IOException {
        ByteOrder byteOrder = this.c;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        OutputStream outputStream = this.b;
        if (byteOrder == byteOrder2) {
            outputStream.write(i & 255);
            outputStream.write((i >>> 8) & 255);
            outputStream.write((i >>> 16) & 255);
            outputStream.write((i >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            outputStream.write((i >>> 24) & 255);
            outputStream.write((i >>> 16) & 255);
            outputStream.write((i >>> 8) & 255);
            outputStream.write(i & 255);
        }
    }

    public final void h(short s) throws IOException {
        ByteOrder byteOrder = this.c;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        OutputStream outputStream = this.b;
        if (byteOrder == byteOrder2) {
            outputStream.write(s & 255);
            outputStream.write((s >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            outputStream.write((s >>> 8) & 255);
            outputStream.write(s & 255);
        }
    }

    public final void i(long j) throws IOException {
        if (j <= 4294967295L) {
            g((int) j);
        } else {
            zy.n("val is larger than the maximum value of a 32-bit unsigned integer");
        }
    }

    public final void m(int i) throws IOException {
        if (i <= 65535) {
            h((short) i);
        } else {
            zy.n("val is larger than the maximum value of a 16-bit unsigned integer");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.b.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        this.b.write(bArr, i, i2);
    }
}
