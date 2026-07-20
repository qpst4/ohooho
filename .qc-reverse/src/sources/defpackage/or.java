package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class or implements Closeable {
    public wr0 b;
    public m0 c;
    public wr0 d;
    public tz e;
    public wr0 f;
    public wr0 g;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((dx0) this.f.get()).close();
    }
}
