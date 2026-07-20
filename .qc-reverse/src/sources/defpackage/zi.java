package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zi implements za0 {
    public static final int[] c = h(ByteBuffer.wrap(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107}));
    public final sp1 a;
    public final int b;

    public zi(int i, byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.a = new sp1(bArr.length, bArr);
        this.b = i;
    }

    public static void g(int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int i6 = i5 ^ iArr[i4];
        int i7 = (i6 >>> (-16)) | (i6 << 16);
        iArr[i4] = i7;
        int i8 = iArr[i3] + i7;
        iArr[i3] = i8;
        int i9 = iArr[i2] ^ i8;
        int i10 = (i9 >>> (-12)) | (i9 << 12);
        iArr[i2] = i10;
        int i11 = iArr[i] + i10;
        iArr[i] = i11;
        int i12 = iArr[i4] ^ i11;
        int i13 = (i12 >>> (-8)) | (i12 << 8);
        iArr[i4] = i13;
        int i14 = iArr[i3] + i13;
        iArr[i3] = i14;
        int i15 = iArr[i2] ^ i14;
        iArr[i2] = (i15 >>> (-7)) | (i15 << 7);
    }

    public static int[] h(ByteBuffer byteBuffer) {
        IntBuffer intBufferAsIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    @Override // defpackage.za0
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > 2147483635) {
            s1.l("plaintext too long");
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12 + bArr.length);
        d(byteBufferAllocate, bArr);
        return byteBufferAllocate.array();
    }

    @Override // defpackage.za0
    public final byte[] b(byte[] bArr) {
        return c(ByteBuffer.wrap(bArr));
    }

    public final byte[] c(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 12) {
            s1.l("ciphertext too short");
            return null;
        }
        byte[] bArr = new byte[12];
        byteBuffer.get(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        f(bArr, byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    public final void d(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() - 12 < bArr.length) {
            zy.n("Given ByteBuffer output is too small");
            return;
        }
        byte[] bArrA = dt0.a(12);
        byteBuffer.put(bArrA);
        f(bArrA, byteBuffer, ByteBuffer.wrap(bArr));
    }

    public final ByteBuffer e(int i, byte[] bArr) {
        int i2 = 16;
        int[] iArr = new int[16];
        int[] iArr2 = c;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        byte[] bArr2 = (byte[]) this.a.c;
        byte[] bArr3 = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        int[] iArrH = h(ByteBuffer.wrap(bArr3));
        int i3 = 4;
        System.arraycopy(iArrH, 0, iArr, 4, iArrH.length);
        iArr[12] = i;
        System.arraycopy(h(ByteBuffer.wrap(bArr)), 0, iArr, 13, 3);
        int[] iArr3 = (int[]) iArr.clone();
        int i4 = 0;
        while (i4 < 10) {
            g(0, i3, 8, 12, iArr3);
            g(1, 5, 9, 13, iArr3);
            g(2, 6, 10, 14, iArr3);
            g(3, 7, 11, 15, iArr3);
            g(0, 5, 10, 15, iArr3);
            g(1, 6, 11, 12, iArr3);
            g(2, 7, 8, 13, iArr3);
            g(3, 4, 9, 14, iArr3);
            i4++;
            i3 = 4;
            i2 = 16;
        }
        int i5 = 0;
        for (int i6 = i2; i5 < i6; i6 = 16) {
            iArr[i5] = iArr[i5] + iArr3[i5];
            i5++;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArr, 0, 16);
        return byteBufferOrder;
    }

    public final void f(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iRemaining = byteBuffer2.remaining();
        int i = iRemaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBufferE = e(this.b + i3, bArr);
            if (i3 == i) {
                f01.S(byteBuffer, byteBuffer2, byteBufferE, iRemaining % 64);
            } else {
                f01.S(byteBuffer, byteBuffer2, byteBufferE, 64);
            }
        }
    }
}
