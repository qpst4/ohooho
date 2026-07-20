package defpackage;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Path;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Provider;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ow0 implements dp, vp1, yh, yr0, kz, z00, kr0, ny0 {
    public static ow0 c;
    public static final /* synthetic */ ow0 d = new ow0(1);
    public static final ow0 e = new ow0(2);
    public static final /* synthetic */ ow0 f = new ow0(3);
    public static final ow0 g = new ow0(4);
    public static final ow0 h = new ow0(5);
    public static final ow0 i = new ow0(6);
    public static ow0 j;
    public final /* synthetic */ int b;

    public /* synthetic */ ow0(int i2) {
        this.b = i2;
    }

    public static Path g(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        return path;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(defpackage.xx r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ow0.i(xx, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // defpackage.yh
    public byte[] a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    @Override // defpackage.vp1
    public cq1 b(Class cls) {
        if (!hp1.class.isAssignableFrom(cls)) {
            zy.n("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (cq1) hp1.h(cls.asSubclass(hp1.class)).d(3);
        } catch (Exception e2) {
            zy.l("Unable to get message info for ".concat(cls.getName()), e2);
            return null;
        }
    }

    @Override // defpackage.kz
    public Object c(String str, Provider provider) {
        switch (this.b) {
            case 14:
                return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
            default:
                return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    @Override // defpackage.vp1
    public boolean d(Class cls) {
        return hp1.class.isAssignableFrom(cls);
    }

    @Override // defpackage.wr0
    public Object get() {
        return new pv0(1, Executors.newSingleThreadExecutor());
    }

    public Signature[] h(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public String toString() {
        switch (this.b) {
            case 5:
                return "kotlin.Unit";
            default:
                return super.toString();
        }
    }

    @Override // defpackage.kr0
    public void e() {
    }

    @Override // defpackage.kr0
    public void f(int i2, Object obj) {
    }

    @Override // defpackage.ny0
    public void onScrollLimit(int i2, int i3, int i4, boolean z) {
    }

    @Override // defpackage.ny0
    public void onScrollProgress(int i2, int i3, int i4, int i5) {
    }
}
