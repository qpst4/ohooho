package defpackage;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public interface nh extends c11, WritableByteChannel {
    nh d(long j);

    @Override // defpackage.c11, java.io.Flushable
    void flush();

    nh o(String str);

    nh write(byte[] bArr);

    nh writeByte(int i);

    nh writeInt(int i);

    nh writeShort(int i);
}
