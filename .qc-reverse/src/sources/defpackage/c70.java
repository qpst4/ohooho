package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.Reference;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class c70 implements dp, yh, yr0, xr0, kz, dg1, z00, xk {
    public static c70 c;
    public static volatile c70 e;
    public static volatile c70 k;
    public static c70 l;
    public final /* synthetic */ int b;
    public static final Object d = new Object();
    public static final /* synthetic */ c70 f = new c70(2);
    public static final c70 g = new c70(3);
    public static final c70 h = new c70(4);
    public static final c70 i = new c70(5);
    public static final c70 j = new c70(6);

    public c70(View view) {
        this.b = 26;
        if (Build.VERSION.SDK_INT >= 30) {
            new k11(view);
        } else {
            new ix(view);
        }
    }

    public static RectF e(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.F || !(view instanceof e41)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        e41 e41Var = (e41) view;
        int contentWidth = e41Var.getContentWidth();
        int contentHeight = e41Var.getContentHeight();
        int iP = (int) i1.p(e41Var.getContext(), 24);
        if (contentWidth < iP) {
            contentWidth = iP;
        }
        int right = (e41Var.getRight() + e41Var.getLeft()) / 2;
        int bottom = (e41Var.getBottom() + e41Var.getTop()) / 2;
        int i2 = contentWidth / 2;
        return new RectF(right - i2, bottom - (contentHeight / 2), i2 + right, (right / 2) + bottom);
    }

    public static String f(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    public static Socket g(wm wmVar, n4 n4Var, u21 u21Var) {
        for (it0 it0Var : wmVar.d) {
            if (it0Var.g(n4Var, null) && it0Var.h != null && it0Var != u21Var.a()) {
                if (u21Var.n != null || u21Var.j.n.size() != 1) {
                    throw new IllegalStateException();
                }
                Reference reference = (Reference) u21Var.j.n.get(0);
                Socket socketB = u21Var.b(true, false, false);
                u21Var.j = it0Var;
                it0Var.n.add(reference);
                return socketB;
            }
        }
        return null;
    }

    public static void j(wm wmVar, n4 n4Var, u21 u21Var, uw0 uw0Var) {
        for (it0 it0Var : wmVar.d) {
            if (it0Var.g(n4Var, uw0Var)) {
                if (u21Var.j != null) {
                    throw new IllegalStateException();
                }
                u21Var.j = it0Var;
                u21Var.k = true;
                it0Var.n.add(new t21(u21Var, u21Var.g));
                return;
            }
        }
    }

    public static final hq1 m(PackageInfo packageInfo, hq1... hq1VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            uq1 uq1Var = new uq1(packageInfo.signatures[0].toByteArray());
            for (int i2 = 0; i2 < hq1VarArr.length; i2++) {
                if (hq1VarArr[i2].equals(uq1Var)) {
                    return hq1VarArr[i2];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean o(android.content.pm.PackageInfo r4) {
        /*
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L2c
            java.lang.String r2 = "com.android.vending"
            java.lang.String r3 = r4.packageName
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L1c
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L19
            goto L1c
        L19:
            r2 = r4
        L1a:
            r3 = r0
            goto L2e
        L1c:
            android.content.pm.ApplicationInfo r2 = r4.applicationInfo
            if (r2 != 0) goto L22
        L20:
            r2 = r1
            goto L29
        L22:
            int r2 = r2.flags
            r2 = r2 & 129(0x81, float:1.81E-43)
            if (r2 == 0) goto L20
            r2 = r0
        L29:
            r3 = r2
            r2 = r4
            goto L2e
        L2c:
            r2 = 0
            goto L1a
        L2e:
            if (r4 == 0) goto L4c
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L4c
            if (r3 == 0) goto L3d
            hq1[] r4 = defpackage.tr1.a
            hq1 r4 = m(r2, r4)
            goto L49
        L3d:
            hq1[] r4 = defpackage.tr1.a
            r4 = r4[r1]
            hq1[] r4 = new defpackage.hq1[]{r4}
            hq1 r4 = m(r2, r4)
        L49:
            if (r4 == 0) goto L4c
            return r0
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c70.o(android.content.pm.PackageInfo):boolean");
    }

    @Override // defpackage.yh
    public byte[] a(byte[] bArr, int i2, int i3) {
        return Arrays.copyOfRange(bArr, i2, i3 + i2);
    }

    @Override // defpackage.dg1
    public bg1 b(Class cls) {
        switch (this.b) {
            case 18:
                return new a40(true);
            default:
                return new yh0();
        }
    }

    @Override // defpackage.kz
    public Object c(String str, Provider provider) {
        switch (this.b) {
            case 14:
                return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
            default:
                return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }

    @Override // defpackage.xk
    public long d() {
        return SystemClock.elapsedRealtime();
    }

    @Override // defpackage.wr0
    public Object get() {
        ix ixVar = new ix(29);
        HashMap map = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            zy.r("Null flags");
            return null;
        }
        map.put(tq0.b, new gd(30000L, 86400000L, set));
        if (set == null) {
            zy.r("Null flags");
            return null;
        }
        map.put(tq0.d, new gd(1000L, 86400000L, set));
        if (set == null) {
            zy.r("Null flags");
            return null;
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(tx0.c)));
        if (setUnmodifiableSet == null) {
            zy.r("Null flags");
            return null;
        }
        map.put(tq0.c, new gd(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() >= tq0.values().length) {
            new HashMap();
            return new fd(ixVar, map);
        }
        s1.f("Not all priorities have been configured");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.jn0 i(defpackage.mc1 r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c70.i(mc1, boolean):jn0");
    }

    public void k(Context context, zr1 zr1Var) {
        try {
            context.unbindService(zr1Var);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public void l(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        RectF rectFE = e(tabLayout, view);
        RectF rectFE2 = e(tabLayout, view2);
        drawable.setBounds(s7.c(f2, (int) rectFE.left, (int) rectFE2.left), drawable.getBounds().top, s7.c(f2, (int) rectFE.right, (int) rectFE2.right), drawable.getBounds().bottom);
    }

    public boolean n(Context context, String str, Intent intent, zr1 zr1Var, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((cj1.a(context).a.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (executor == null) {
            executor = null;
        }
        return (Build.VERSION.SDK_INT < 29 || executor == null) ? context.bindService(intent, zr1Var, 4225) : context.bindService(intent, 4225, executor, zr1Var);
    }

    public String toString() {
        switch (this.b) {
            case 10:
                return Collections.EMPTY_MAP.toString();
            default:
                return super.toString();
        }
    }

    public c70() {
        this.b = 1;
        new ConcurrentHashMap();
    }

    public /* synthetic */ c70(int i2) {
        this.b = i2;
    }
}
