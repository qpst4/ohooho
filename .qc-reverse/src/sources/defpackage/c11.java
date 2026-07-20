package defpackage;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public interface c11 extends Closeable, Flushable {
    a61 b();

    void c(mh mhVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
