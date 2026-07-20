package defpackage;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class zz extends InputStream implements DataInput {
    public final DataInputStream b;
    public int c;
    public ByteOrder d;
    public byte[] e;
    public final int f;

    public zz(InputStream inputStream, ByteOrder byteOrder) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.b = dataInputStream;
        dataInputStream.mark(0);
        this.c = 0;
        this.d = byteOrder;
        this.f = inputStream instanceof zz ? ((zz) inputStream).f : -1;
    }

    public final void a(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = i - i2;
            DataInputStream dataInputStream = this.b;
            int iSkip = (int) dataInputStream.skip(i3);
            if (iSkip <= 0) {
                if (this.e == null) {
                    this.e = new byte[8192];
                }
                iSkip = dataInputStream.read(this.e, 0, Math.min(8192, i3));
                if (iSkip == -1) {
                    throw new EOFException("Reached EOF while skipping " + i + " bytes.");
                }
            }
            i2 += iSkip;
        }
        this.c += i2;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.b.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.c++;
        return this.b.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.c++;
        return this.b.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.c++;
        int i = this.b.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.c += 2;
        return this.b.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.c += bArr.length;
        this.b.readFully(bArr);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.c += 4;
        DataInputStream dataInputStream = this.b;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        if ((i | i2 | i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
        }
        zy.o("Invalid byte order: ", this.d);
        return 0;
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        this.c += 8;
        DataInputStream dataInputStream = this.b;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8) + ((long) i);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8) + ((long) i8);
        }
        zy.o("Invalid byte order: ", this.d);
        return 0L;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.c += 2;
        DataInputStream dataInputStream = this.b;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (short) ((i2 << 8) + i);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((i << 8) + i2);
        }
        zy.o("Invalid byte order: ", this.d);
        return (short) 0;
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.c += 2;
        return this.b.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.c++;
        return this.b.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.c += 2;
        DataInputStream dataInputStream = this.b;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i2 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 8) + i2;
        }
        zy.o("Invalid byte order: ", this.d);
        return 0;
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.c += i2;
        this.b.readFully(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int i3 = this.b.read(bArr, i, i2);
        this.c += i3;
        return i3;
    }

    public zz(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    public zz(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        this.f = bArr.length;
    }
}
