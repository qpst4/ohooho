package defpackage;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ww0 {
    public final n4 a;
    public final tb0 b;
    public final c70 c;
    public final List d;
    public int e;
    public List f;
    public final ArrayList g;

    public ww0(n4 n4Var, tb0 tb0Var, ht0 ht0Var, c70 c70Var) {
        List list = Collections.EMPTY_LIST;
        this.d = list;
        this.f = list;
        this.g = new ArrayList();
        this.a = n4Var;
        this.b = tb0Var;
        this.c = c70Var;
        List<Proxy> listSelect = n4Var.g.select(n4Var.a.k());
        this.d = (listSelect == null || listSelect.isEmpty()) ? be1.k(Proxy.NO_PROXY) : Collections.unmodifiableList(new ArrayList(listSelect));
        this.e = 0;
    }

    public final void a(uw0 uw0Var, IOException iOException) {
        n4 n4Var;
        ProxySelector proxySelector;
        if (uw0Var.b.type() != Proxy.Type.DIRECT && (proxySelector = (n4Var = this.a).g) != null) {
            proxySelector.connectFailed(n4Var.a.k(), uw0Var.b.address(), iOException);
        }
        tb0 tb0Var = this.b;
        synchronized (tb0Var) {
            ((LinkedHashSet) tb0Var.c).add(uw0Var);
        }
    }
}
