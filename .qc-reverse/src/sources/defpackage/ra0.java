package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ra0 {
    public static final byte[] b = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    public final sp1 a;

    public ra0(InputStream inputStream) {
        this.a = new sp1(27, inputStream);
    }

    public final int a() throws IOException {
        int i;
        InputStream inputStream = (InputStream) this.a.c;
        short s = 255;
        int i2 = ((inputStream.read() << 8) & 65280) | (inputStream.read() & 255);
        if ((i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761) {
            while (true) {
                short s2 = (short) (inputStream.read() & s);
                if (s2 == s) {
                    short s3 = (short) (inputStream.read() & s);
                    if (s3 == 218) {
                        break;
                    }
                    if (s3 != 217) {
                        i = (((inputStream.read() << 8) & 65280) | (inputStream.read() & s)) - 2;
                        if (s3 == 225) {
                            break;
                        }
                        long j = i;
                        long j2 = 0;
                        if (j >= 0) {
                            long j3 = j;
                            while (j3 > 0) {
                                long jSkip = inputStream.skip(j3);
                                if (jSkip <= 0) {
                                    if (inputStream.read() == -1) {
                                        break;
                                    }
                                    jSkip = 1;
                                }
                                j3 -= jSkip;
                            }
                            j2 = j - j3;
                        }
                        if (j2 == j) {
                            s = 255;
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) s3) + ", wanted to skip: " + i + ", but actually skipped: " + j2);
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) s2));
                }
            }
            i = -1;
            if (i != -1) {
                byte[] bArr = new byte[i];
                int i3 = i;
                while (i3 > 0) {
                    int i4 = inputStream.read(bArr, i - i3, i3);
                    if (i4 == -1) {
                        break;
                    }
                    i3 -= i4;
                }
                int i5 = i - i3;
                if (i5 == i) {
                    byte[] bArr2 = b;
                    boolean z = i > bArr2.length;
                    if (z) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= bArr2.length) {
                                break;
                            }
                            if (bArr[i6] != bArr2[i6]) {
                                z = false;
                                break;
                            }
                            i6++;
                        }
                    }
                    if (z) {
                        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                        ByteBuffer byteBuffer = (ByteBuffer) byteBufferWrap.order(byteOrder).limit(i);
                        short s4 = byteBuffer.getShort(6);
                        if (s4 != 19789) {
                            if (s4 == 18761) {
                                byteOrder = ByteOrder.LITTLE_ENDIAN;
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) s4));
                            }
                        }
                        byteBuffer.order(byteOrder);
                        int i7 = byteBuffer.getInt(10);
                        short s5 = byteBuffer.getShort(i7 + 6);
                        for (int i8 = 0; i8 < s5; i8++) {
                            int i9 = (i8 * 12) + i7 + 8;
                            short s6 = byteBuffer.getShort(i9);
                            if (s6 == 274) {
                                short s7 = byteBuffer.getShort(i9 + 2);
                                if (s7 >= 1 && s7 <= 12) {
                                    int i10 = byteBuffer.getInt(i9 + 4);
                                    if (i10 >= 0) {
                                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                                            Log.d("ImageHeaderParser", "Got tagIndex=" + i8 + " tagType=" + ((int) s6) + " formatCode=" + ((int) s7) + " componentCount=" + i10);
                                        }
                                        int i11 = i10 + c[s7];
                                        if (i11 <= 4) {
                                            int i12 = i9 + 8;
                                            if (i12 >= 0 && i12 <= byteBuffer.remaining()) {
                                                if (i11 >= 0 && i11 + i12 <= byteBuffer.remaining()) {
                                                    return byteBuffer.getShort(i12);
                                                }
                                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) s6));
                                                }
                                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i12 + " tagType=" + ((int) s6));
                                            }
                                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) s7));
                                        }
                                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                        Log.d("ImageHeaderParser", "Negative tiff component count");
                                    }
                                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Got invalid format code = " + ((int) s7));
                                }
                            }
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + i5);
                    return -1;
                }
            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                return -1;
            }
        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Parser doesn't handle magic number: " + i2);
            return -1;
        }
        return -1;
    }
}
