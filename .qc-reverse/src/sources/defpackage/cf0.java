package defpackage;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;
import javax.crypto.AEADBadTagException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cf0 implements x4 {
    public static final byte[] d = new byte[0];
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final Object c;

    public cf0(byte[] bArr) throws CloneNotSupportedException {
        bArr.clone();
        this.b = new zi(1, bArr);
        this.c = new zi(0, bArr);
    }

    public static byte[] c(ByteBuffer byteBuffer, byte[] bArr) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining % 16;
        int i2 = (i == 0 ? iRemaining : (iRemaining + 16) - i) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i2);
        byteBufferOrder.putLong(bArr.length);
        byteBufferOrder.putLong(iRemaining);
        return byteBufferOrder.array();
    }

    @Override // defpackage.x4
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                je0 je0Var = (je0) obj2;
                byte[] bArrL = ev0.d(je0Var).l();
                byte[] bArrA = ((a5) obj).a(bArrL, d);
                byte[] bArrA2 = ((x4) ev0.b(je0Var.d).d(zh.c(bArrL, 0, bArrL.length))).a(bArr, bArr2);
                return ByteBuffer.allocate(bArrA.length + 4 + bArrA2.length).putInt(bArrA.length).put(bArrA).put(bArrA2).array();
            default:
                int length = bArr.length;
                zi ziVar = (zi) obj2;
                ziVar.getClass();
                if (length > 2147483619) {
                    s1.l("plaintext too long");
                    return null;
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 28);
                if (byteBufferAllocate.remaining() < bArr.length + 28) {
                    zy.n("Given ByteBuffer output is too small");
                    return null;
                }
                int iPosition = byteBufferAllocate.position();
                ziVar.d(byteBufferAllocate, bArr);
                byteBufferAllocate.position(iPosition);
                byte[] bArr3 = new byte[12];
                byteBufferAllocate.get(bArr3);
                byteBufferAllocate.limit(byteBufferAllocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                ((zi) obj).e(0, bArr3).get(bArr4);
                byte[] bArrD = tk0.d(bArr4, c(byteBufferAllocate, bArr2));
                byteBufferAllocate.limit(byteBufferAllocate.limit() + 16);
                byteBufferAllocate.put(bArrD);
                return byteBufferAllocate.array();
        }
    }

    @Override // defpackage.x4
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                try {
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    int i2 = byteBufferWrap.getInt();
                    if (i2 <= 0 || i2 > bArr.length - 4) {
                        throw new GeneralSecurityException("invalid ciphertext");
                    }
                    byte[] bArr3 = new byte[i2];
                    byteBufferWrap.get(bArr3, 0, i2);
                    byte[] bArr4 = new byte[byteBufferWrap.remaining()];
                    byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
                    byte[] bArrB = ((a5) obj).b(bArr3, d);
                    String str = ((je0) obj2).d;
                    Logger logger = ev0.a;
                    zh zhVar = zh.d;
                    return ((x4) ev0.b(str).d(zh.c(bArrB, 0, bArrB.length))).b(bArr4, bArr2);
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    throw new GeneralSecurityException("invalid ciphertext", e);
                } catch (NegativeArraySizeException e2) {
                    e = e2;
                    throw new GeneralSecurityException("invalid ciphertext", e);
                } catch (BufferUnderflowException e3) {
                    e = e3;
                    throw new GeneralSecurityException("invalid ciphertext", e);
                }
            default:
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                int iRemaining = byteBufferWrap2.remaining();
                zi ziVar = (zi) obj2;
                ziVar.getClass();
                if (iRemaining < 28) {
                    s1.l("ciphertext too short");
                    return null;
                }
                int iPosition = byteBufferWrap2.position();
                byte[] bArr5 = new byte[16];
                byteBufferWrap2.position(byteBufferWrap2.limit() - 16);
                byteBufferWrap2.get(bArr5);
                byteBufferWrap2.position(iPosition);
                byteBufferWrap2.limit(byteBufferWrap2.limit() - 16);
                byte[] bArr6 = new byte[12];
                byteBufferWrap2.get(bArr6);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                try {
                    byte[] bArr7 = new byte[32];
                    ((zi) obj).e(0, bArr6).get(bArr7);
                    if (!f01.t(tk0.d(bArr7, c(byteBufferWrap2, bArr2)), bArr5)) {
                        throw new GeneralSecurityException("invalid MAC");
                    }
                    byteBufferWrap2.position(iPosition);
                    return ziVar.c(byteBufferWrap2);
                } catch (GeneralSecurityException e4) {
                    throw new AEADBadTagException(e4.toString());
                }
        }
    }

    public cf0(je0 je0Var, a5 a5Var) {
        this.b = je0Var;
        this.c = a5Var;
    }
}
