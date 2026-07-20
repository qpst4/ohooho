package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kt0 implements Closeable {
    public final /* synthetic */ int b;
    public final long c;
    public final oh d;

    public /* synthetic */ kt0(long j, oh ohVar, int i) {
        this.b = i;
        this.c = j;
        this.d = ohVar;
    }

    public final long a() {
        switch (this.b) {
        }
        return this.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        be1.c(g());
    }

    public final oh g() {
        int i = this.b;
        oh ohVar = this.d;
        switch (i) {
            case 0:
                return (gt0) ohVar;
            default:
                return (mh) ohVar;
        }
    }
}
