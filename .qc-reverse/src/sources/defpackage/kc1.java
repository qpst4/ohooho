package defpackage;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kc1 {
    public static final ac1 A;
    public static final lz B;
    public static final ac1 a;
    public static final ac1 b;
    public static final ec1 c;
    public static final cc1 d;
    public static final cc1 e;
    public static final cc1 f;
    public static final cc1 g;
    public static final ac1 h;
    public static final ac1 i;
    public static final ac1 j;
    public static final ib1 k;
    public static final cc1 l;
    public static final nb1 m;
    public static final ob1 n;
    public static final pb1 o;
    public static final ac1 p;
    public static final ac1 q;
    public static final ac1 r;
    public static final ac1 s;
    public static final ac1 t;
    public static final ac1 u;
    public static final ac1 v;
    public static final ac1 w;
    public static final gn0 x;
    public static final ac1 y;
    public static final qd0 z;

    static {
        int i2 = 0;
        a = new ac1(Class.class, new rb1().a(), i2);
        b = new ac1(BitSet.class, new bc1().a(), i2);
        dc1 dc1Var = new dc1();
        c = new ec1();
        d = new cc1(Boolean.TYPE, Boolean.class, dc1Var);
        e = new cc1(Byte.TYPE, Byte.class, new fc1());
        f = new cc1(Short.TYPE, Short.class, new gc1());
        g = new cc1(Integer.TYPE, Integer.class, new hc1());
        h = new ac1(AtomicInteger.class, new ic1().a(), i2);
        i = new ac1(AtomicBoolean.class, new jc1().a(), i2);
        j = new ac1(AtomicIntegerArray.class, new hb1().a(), i2);
        k = new ib1();
        new jb1();
        new kb1();
        l = new cc1(Character.TYPE, Character.class, new lb1());
        mb1 mb1Var = new mb1();
        m = new nb1();
        n = new ob1();
        o = new pb1();
        p = new ac1(String.class, mb1Var, i2);
        q = new ac1(StringBuilder.class, new qb1(), i2);
        r = new ac1(StringBuffer.class, new sb1(), i2);
        s = new ac1(URL.class, new tb1(), i2);
        t = new ac1(URI.class, new ub1(), i2);
        int i3 = 1;
        u = new ac1(InetAddress.class, new vb1(), i3);
        v = new ac1(UUID.class, new wb1(), i2);
        w = new ac1(Currency.class, new xb1().a(), i2);
        x = new gn0(new yb1(), i3);
        y = new ac1(Locale.class, new zb1(), i2);
        qd0 qd0Var = qd0.a;
        z = qd0Var;
        A = new ac1(pd0.class, qd0Var, i3);
        B = mz.d;
    }
}
