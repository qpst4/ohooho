package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class km0 implements Runnable {
    public final String b;

    public km0(String str, Object... objArr) {
        byte[] bArr = be1.a;
        this.b = String.format(Locale.US, str, objArr);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.b);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
