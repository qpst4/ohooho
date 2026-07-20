package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xi implements c91 {
    public final tb0 a;
    public final ConnectivityManager b;
    public final Context c;
    public final URL d;
    public final xk e;
    public final xk f;
    public final int g;

    public xi(Context context, xk xkVar, xk xkVar2) {
        od0 od0Var = new od0();
        zb zbVar = zb.a;
        od0Var.a(ue.class, zbVar);
        od0Var.a(uc.class, zbVar);
        cc ccVar = cc.a;
        od0Var.a(ri0.class, ccVar);
        od0Var.a(bd.class, ccVar);
        ac acVar = ac.a;
        od0Var.a(vk.class, acVar);
        od0Var.a(vc.class, acVar);
        yb ybVar = yb.a;
        od0Var.a(d7.class, ybVar);
        od0Var.a(sc.class, ybVar);
        bc bcVar = bc.a;
        od0Var.a(oi0.class, bcVar);
        od0Var.a(ad.class, bcVar);
        dc dcVar = dc.a;
        od0Var.a(um0.class, dcVar);
        od0Var.a(dd.class, dcVar);
        od0Var.d = true;
        this.a = new tb0(1, od0Var);
        this.c = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = b(bi.c);
        this.e = xkVar2;
        this.f = xkVar;
        this.g = 130000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.yc a(defpackage.yc r8) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xi.a(yc):yc");
    }
}
