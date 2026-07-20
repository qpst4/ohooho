package defpackage;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u21 {
    public final n4 a;
    public jl1 b;
    public uw0 c;
    public final wm d;
    public final ht0 e;
    public final c70 f;
    public final Object g;
    public final ww0 h;
    public int i;
    public it0 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ca0 n;

    public u21(wm wmVar, n4 n4Var, ht0 ht0Var, c70 c70Var, Object obj) {
        this.d = wmVar;
        this.a = n4Var;
        this.e = ht0Var;
        this.f = c70Var;
        c70.l.getClass();
        this.h = new ww0(n4Var, wmVar.e, ht0Var, c70Var);
        this.g = obj;
    }

    public final synchronized it0 a() {
        return this.j;
    }

    public final Socket b(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.n = null;
        }
        if (z2) {
            this.l = true;
        }
        it0 it0Var = this.j;
        if (it0Var != null) {
            if (z) {
                it0Var.k = true;
            }
            if (this.n == null && (this.l || it0Var.k)) {
                ArrayList arrayList = it0Var.n;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (((Reference) arrayList.get(i)).get() == this) {
                        arrayList.remove(i);
                        if (this.j.n.isEmpty()) {
                            this.j.o = System.nanoTime();
                            c70 c70Var = c70.l;
                            it0 it0Var2 = this.j;
                            c70Var.getClass();
                            wm wmVar = this.d;
                            wmVar.getClass();
                            if (it0Var2.k || wmVar.a == 0) {
                                wmVar.d.remove(it0Var2);
                                socket = this.j.e;
                            } else {
                                wmVar.notifyAll();
                                socket = null;
                            }
                        } else {
                            socket = null;
                        }
                        this.j = null;
                        return socket;
                    }
                }
                throw new IllegalStateException();
            }
        }
        return null;
    }

    public final it0 c(int i, int i2, int i3, boolean z) throws Throwable {
        it0 it0Var;
        boolean z2;
        it0 it0Var2;
        Socket socketB;
        it0 it0Var3;
        boolean z3;
        uw0 uw0Var;
        boolean z4;
        it0 it0Var4;
        it0 it0Var5;
        Socket socketG;
        jl1 jl1Var;
        String hostName;
        int port;
        boolean zContains;
        synchronized (this.d) {
            try {
                if (this.l) {
                    throw new IllegalStateException("released");
                }
                if (this.n != null) {
                    throw new IllegalStateException("codec != null");
                }
                if (this.m) {
                    throw new IOException("Canceled");
                }
                it0Var = this.j;
                z2 = true;
                it0Var2 = null;
                socketB = (it0Var == null || !it0Var.k) ? null : b(false, false, true);
                it0Var3 = this.j;
                if (it0Var3 != null) {
                    it0Var = null;
                } else {
                    it0Var3 = null;
                }
                if (!this.k) {
                    it0Var = null;
                }
                if (it0Var3 == null) {
                    c70 c70Var = c70.l;
                    wm wmVar = this.d;
                    n4 n4Var = this.a;
                    c70Var.getClass();
                    c70.j(wmVar, n4Var, this, null);
                    it0 it0Var6 = this.j;
                    if (it0Var6 != null) {
                        z3 = true;
                        it0Var3 = it0Var6;
                    } else {
                        uw0Var = this.c;
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                uw0Var = null;
            } finally {
            }
        }
        be1.d(socketB);
        if (it0Var != null) {
            this.f.getClass();
        }
        if (z3) {
            this.f.getClass();
        }
        if (it0Var3 != null) {
            return it0Var3;
        }
        if (uw0Var != null || ((jl1Var = this.b) != null && jl1Var.b < ((ArrayList) jl1Var.c).size())) {
            z4 = false;
        } else {
            ww0 ww0Var = this.h;
            if (ww0Var.e >= ww0Var.d.size() && ww0Var.g.isEmpty()) {
                throw new NoSuchElementException();
            }
            ArrayList arrayList = new ArrayList();
            while (ww0Var.e < ww0Var.d.size()) {
                n4 n4Var2 = ww0Var.a;
                if (ww0Var.e >= ww0Var.d.size()) {
                    throw new SocketException("No route to " + n4Var2.a.d + "; exhausted proxy configurations: " + ww0Var.d);
                }
                List list = ww0Var.d;
                int i4 = ww0Var.e;
                ww0Var.e = i4 + 1;
                Proxy proxy = (Proxy) list.get(i4);
                c70 c70Var2 = ww0Var.c;
                ww0Var.f = new ArrayList();
                if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                    ga0 ga0Var = n4Var2.a;
                    hostName = ga0Var.d;
                    port = ga0Var.e;
                } else {
                    SocketAddress socketAddressAddress = proxy.address();
                    if (!(socketAddressAddress instanceof InetSocketAddress)) {
                        s1.j("Proxy.address() is not an InetSocketAddress: ", socketAddressAddress.getClass());
                        return it0Var2;
                    }
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    InetAddress address = inetSocketAddress.getAddress();
                    hostName = address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
                    port = inetSocketAddress.getPort();
                }
                if (port < 1 || port > 65535) {
                    throw new SocketException("No route to " + hostName + ":" + port + "; port is out of range");
                }
                if (proxy.type() == Proxy.Type.SOCKS) {
                    ww0Var.f.add(InetSocketAddress.createUnresolved(hostName, port));
                } else {
                    c70Var2.getClass();
                    n4Var2.b.getClass();
                    if (hostName == null) {
                        throw new UnknownHostException("hostname == null");
                    }
                    try {
                        List listAsList = Arrays.asList(InetAddress.getAllByName(hostName));
                        if (listAsList.isEmpty()) {
                            throw new UnknownHostException(n4Var2.b + " returned no addresses for " + hostName);
                        }
                        int size = listAsList.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            ww0Var.f.add(new InetSocketAddress((InetAddress) listAsList.get(i5), port));
                        }
                    } catch (NullPointerException e) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostName));
                        unknownHostException.initCause(e);
                        throw unknownHostException;
                    }
                }
                int size2 = ww0Var.f.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    uw0 uw0Var2 = new uw0(ww0Var.a, proxy, (InetSocketAddress) ww0Var.f.get(i6));
                    tb0 tb0Var = ww0Var.b;
                    synchronized (tb0Var) {
                        zContains = ((LinkedHashSet) tb0Var.c).contains(uw0Var2);
                    }
                    if (zContains) {
                        ww0Var.g.add(uw0Var2);
                    } else {
                        arrayList.add(uw0Var2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
                it0Var2 = null;
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(ww0Var.g);
                ww0Var.g.clear();
            }
            this.b = new jl1(arrayList);
            z4 = true;
        }
        synchronized (this.d) {
            try {
                if (this.m) {
                    throw new IOException("Canceled");
                }
                if (z4) {
                    jl1 jl1Var2 = this.b;
                    jl1Var2.getClass();
                    ArrayList arrayList2 = new ArrayList((ArrayList) jl1Var2.c);
                    int size3 = arrayList2.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size3) {
                            break;
                        }
                        uw0 uw0Var3 = (uw0) arrayList2.get(i7);
                        c70 c70Var3 = c70.l;
                        wm wmVar2 = this.d;
                        n4 n4Var3 = this.a;
                        c70Var3.getClass();
                        c70.j(wmVar2, n4Var3, this, uw0Var3);
                        it0 it0Var7 = this.j;
                        if (it0Var7 != null) {
                            this.c = uw0Var3;
                            z3 = true;
                            it0Var3 = it0Var7;
                            break;
                        }
                        i7++;
                    }
                }
                if (!z3) {
                    if (uw0Var == null) {
                        jl1 jl1Var3 = this.b;
                        if (!(jl1Var3.b < ((ArrayList) jl1Var3.c).size())) {
                            throw new NoSuchElementException();
                        }
                        ArrayList arrayList3 = (ArrayList) jl1Var3.c;
                        int i8 = jl1Var3.b;
                        jl1Var3.b = i8 + 1;
                        uw0Var = (uw0) arrayList3.get(i8);
                    }
                    this.c = uw0Var;
                    this.i = 0;
                    it0Var3 = new it0(this.d, uw0Var);
                    if (this.j != null) {
                        throw new IllegalStateException();
                    }
                    this.j = it0Var3;
                    this.k = false;
                    it0Var3.n.add(new t21(this, this.g));
                }
                it0Var4 = it0Var3;
            } finally {
            }
        }
        if (z3) {
            this.f.getClass();
            return it0Var4;
        }
        it0Var4.c(i, i2, i3, z, this.f);
        c70 c70Var4 = c70.l;
        wm wmVar3 = this.d;
        c70Var4.getClass();
        wmVar3.e.c(it0Var4.c);
        synchronized (this.d) {
            try {
                this.k = true;
                c70 c70Var5 = c70.l;
                wm wmVar4 = this.d;
                c70Var5.getClass();
                if (!wmVar4.f) {
                    wmVar4.f = true;
                    wm.g.execute(wmVar4.c);
                }
                wmVar4.d.add(it0Var4);
                if (it0Var4.h == null) {
                    z2 = false;
                }
                if (z2) {
                    c70 c70Var6 = c70.l;
                    wm wmVar5 = this.d;
                    n4 n4Var4 = this.a;
                    c70Var6.getClass();
                    socketG = c70.g(wmVar5, n4Var4, this);
                    it0Var5 = this.j;
                } else {
                    it0Var5 = it0Var4;
                    socketG = null;
                }
            } finally {
            }
        }
        be1.d(socketG);
        this.f.getClass();
        return it0Var5;
    }

    public final it0 d(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        it0 it0VarC;
        int soTimeout;
        boolean zA;
        Socket socket;
        boolean z3;
        while (true) {
            it0VarC = c(i, i2, i3, z);
            synchronized (this.d) {
                try {
                    if (it0VarC.l != 0) {
                        boolean z4 = false;
                        if (!it0VarC.e.isClosed() && !it0VarC.e.isInputShutdown() && !it0VarC.e.isOutputShutdown()) {
                            u90 u90Var = it0VarC.h;
                            if (u90Var != null) {
                                synchronized (u90Var) {
                                    z3 = u90Var.h;
                                }
                                z4 = !z3;
                            } else if (z2) {
                                try {
                                    soTimeout = it0VarC.e.getSoTimeout();
                                    try {
                                        it0VarC.e.setSoTimeout(1);
                                        zA = it0VarC.i.a();
                                        socket = it0VarC.e;
                                    } catch (Throwable th) {
                                        it0VarC.e.setSoTimeout(soTimeout);
                                        throw th;
                                    }
                                } catch (SocketTimeoutException unused) {
                                } catch (IOException unused2) {
                                }
                                if (zA) {
                                    socket.setSoTimeout(soTimeout);
                                } else {
                                    socket.setSoTimeout(soTimeout);
                                    z4 = true;
                                }
                            } else {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            break;
                        }
                        e();
                    } else {
                        break;
                    }
                } finally {
                }
            }
        }
        return it0VarC;
    }

    public final void e() {
        it0 it0Var;
        Socket socketB;
        synchronized (this.d) {
            it0Var = this.j;
            socketB = b(true, false, false);
            if (this.j != null) {
                it0Var = null;
            }
        }
        be1.d(socketB);
        if (it0Var != null) {
            this.f.getClass();
        }
    }

    public final void f() {
        it0 it0Var;
        Socket socketB;
        synchronized (this.d) {
            it0Var = this.j;
            socketB = b(false, true, false);
            if (this.j != null) {
                it0Var = null;
            }
        }
        be1.d(socketB);
        if (it0Var != null) {
            c70 c70Var = c70.l;
            ht0 ht0Var = this.e;
            c70Var.getClass();
            ht0Var.d(null);
            this.f.getClass();
            this.f.getClass();
        }
    }

    public final void g(IOException iOException) {
        it0 it0Var;
        boolean z;
        Socket socketB;
        synchronized (this.d) {
            try {
                it0Var = null;
                if (iOException instanceof v21) {
                    int i = ((v21) iOException).b;
                    if (i == 5) {
                        int i2 = this.i + 1;
                        this.i = i2;
                        if (i2 > 1) {
                            this.c = null;
                            z = true;
                        }
                        z = false;
                    } else {
                        if (i != 6) {
                            this.c = null;
                            z = true;
                        }
                        z = false;
                    }
                } else {
                    it0 it0Var2 = this.j;
                    if (it0Var2 != null) {
                        if (!(it0Var2.h != null) || (iOException instanceof ym)) {
                            if (it0Var2.l == 0) {
                                uw0 uw0Var = this.c;
                                if (uw0Var != null && iOException != null) {
                                    this.h.a(uw0Var, iOException);
                                }
                                this.c = null;
                            }
                            z = true;
                        }
                    }
                    z = false;
                }
                it0 it0Var3 = this.j;
                socketB = b(z, false, true);
                if (this.j == null && this.k) {
                    it0Var = it0Var3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        be1.d(socketB);
        if (it0Var != null) {
            this.f.getClass();
        }
    }

    public final void h(boolean z, ca0 ca0Var, IOException iOException) {
        it0 it0Var;
        Socket socketB;
        boolean z2;
        this.f.getClass();
        synchronized (this.d) {
            try {
                if (ca0Var != this.n) {
                    throw new IllegalStateException("expected " + this.n + " but was " + ca0Var);
                }
                if (!z) {
                    this.j.l++;
                }
                it0Var = this.j;
                socketB = b(z, false, true);
                if (this.j != null) {
                    it0Var = null;
                }
                z2 = this.l;
            } catch (Throwable th) {
                throw th;
            }
        }
        be1.d(socketB);
        if (it0Var != null) {
            this.f.getClass();
        }
        if (iOException != null) {
            c70 c70Var = c70.l;
            ht0 ht0Var = this.e;
            c70Var.getClass();
            ht0Var.d(iOException);
            this.f.getClass();
            return;
        }
        if (z2) {
            c70 c70Var2 = c70.l;
            ht0 ht0Var2 = this.e;
            c70Var2.getClass();
            ht0Var2.d(null);
            this.f.getClass();
        }
    }

    public final String toString() {
        it0 it0VarA = a();
        return it0VarA != null ? it0VarA.toString() : this.a.toString();
    }
}
