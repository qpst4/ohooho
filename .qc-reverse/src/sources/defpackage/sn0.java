package defpackage;

import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sn0 implements Cloneable {
    public static final List y = be1.k(vr0.f, vr0.d);
    public static final List z = be1.k(an.e, an.f);
    public final g7 b;
    public final List c;
    public final List d;
    public final List e;
    public final List f;
    public final c70 g;
    public final ProxySelector h;
    public final ix i;
    public final SocketFactory j;
    public final SSLSocketFactory k;
    public final i1 l;
    public final rn0 m;
    public final yi n;
    public final ix o;
    public final ix p;
    public final wm q;
    public final ix r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final int v;
    public final int w;
    public final int x;

    static {
        c70.l = new c70(21);
    }

    public sn0() {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        g7 g7Var = new g7(4);
        c70 c70Var = new c70(16);
        ProxySelector en0Var = ProxySelector.getDefault();
        en0Var = en0Var == null ? new en0() : en0Var;
        ix ixVar = ix.d;
        SocketFactory socketFactory = SocketFactory.getDefault();
        yi yiVar = yi.c;
        ix ixVar2 = ix.c;
        wm wmVar = new wm();
        ix ixVar3 = ix.e;
        this.b = g7Var;
        this.c = y;
        List list = z;
        this.d = list;
        this.e = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f = Collections.unmodifiableList(new ArrayList(arrayList2));
        this.g = c70Var;
        this.h = en0Var;
        this.i = ixVar;
        this.j = socketFactory;
        Iterator it = list.iterator();
        loop0: while (true) {
            z2 = false;
            while (it.hasNext()) {
                z2 = (z2 || ((an) it.next()).a) ? true : z2;
            }
        }
        if (z2) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        try {
                            qp0 qp0Var = qp0.a;
                            SSLContext sSLContextH = qp0Var.h();
                            sSLContextH.init(null, new TrustManager[]{x509TrustManager}, null);
                            this.k = sSLContextH.getSocketFactory();
                            this.l = qp0Var.c(x509TrustManager);
                        } catch (GeneralSecurityException e) {
                            throw be1.a("No System TLS", e);
                        }
                    }
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e2) {
                throw be1.a("No System TLS", e2);
            }
        }
        this.k = null;
        this.l = null;
        SSLSocketFactory sSLSocketFactory = this.k;
        if (sSLSocketFactory != null) {
            qp0.a.e(sSLSocketFactory);
        }
        this.m = rn0.a;
        i1 i1Var = this.l;
        this.n = be1.i(yiVar.b, i1Var) ? yiVar : new yi(yiVar.a, i1Var);
        this.o = ixVar2;
        this.p = ixVar2;
        this.q = wmVar;
        this.r = ixVar3;
        this.s = true;
        this.t = true;
        this.u = true;
        this.v = 10000;
        this.w = 10000;
        this.x = 10000;
        if (this.e.contains(null)) {
            zy.t("Null interceptor: ", this.e);
            throw null;
        }
        if (this.f.contains(null)) {
            zy.t("Null network interceptor: ", this.f);
            throw null;
        }
    }
}
