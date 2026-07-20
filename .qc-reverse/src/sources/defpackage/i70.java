package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i70 {
    public static final z20 h = z20.d;
    public static final int i = 1;
    public static final int j = 1;
    public static final int k = 2;
    public final ThreadLocal a;
    public final ConcurrentHashMap b;
    public final c70 c;
    public final jd0 d;
    public final List e;
    public final boolean f;
    public final z20 g;

    public i70() {
        vz vzVar = vz.d;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this.a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        c70 c70Var = new c70(10);
        this.c = c70Var;
        int i2 = 1;
        this.f = true;
        this.g = h;
        ArrayList arrayList = new ArrayList();
        arrayList.add(kc1.A);
        int i3 = j;
        arrayList.add(i3 == 1 ? nn0.c : new mn0(i3));
        arrayList.add(vzVar);
        arrayList.addAll(list);
        arrayList.add(kc1.p);
        arrayList.add(kc1.g);
        arrayList.add(kc1.d);
        arrayList.add(kc1.e);
        arrayList.add(kc1.f);
        ib1 ib1Var = kc1.k;
        arrayList.add(new cc1(Long.TYPE, Long.class, ib1Var));
        int i4 = 0;
        arrayList.add(new cc1(Double.TYPE, Double.class, new f70(i4)));
        arrayList.add(new cc1(Float.TYPE, Float.class, new f70(i2)));
        int i5 = k;
        arrayList.add(i5 == 2 ? hn0.b : new gn0(new hn0(i5), i4));
        arrayList.add(kc1.h);
        arrayList.add(kc1.i);
        arrayList.add(new ac1(AtomicLong.class, new g70(ib1Var, i4).a(), i4));
        arrayList.add(new ac1(AtomicLongArray.class, new g70(ib1Var, i2).a(), i4));
        arrayList.add(kc1.j);
        arrayList.add(kc1.l);
        arrayList.add(kc1.q);
        arrayList.add(kc1.r);
        arrayList.add(new ac1(BigDecimal.class, kc1.m, i4));
        arrayList.add(new ac1(BigInteger.class, kc1.n, i4));
        arrayList.add(new ac1(sf0.class, kc1.o, i4));
        arrayList.add(kc1.s);
        arrayList.add(kc1.t);
        arrayList.add(kc1.v);
        arrayList.add(kc1.w);
        arrayList.add(kc1.y);
        arrayList.add(kc1.u);
        arrayList.add(kc1.b);
        arrayList.add(bs.c);
        arrayList.add(kc1.x);
        if (d21.a) {
            arrayList.add(d21.c);
            arrayList.add(d21.b);
            arrayList.add(d21.d);
        }
        arrayList.add(ob.c);
        arrayList.add(kc1.a);
        arrayList.add(new il(c70Var, i4));
        arrayList.add(new il(c70Var, i2));
        jd0 jd0Var = new jd0(c70Var);
        this.d = jd0Var;
        arrayList.add(jd0Var);
        arrayList.add(kc1.B);
        arrayList.add(new dv0(c70Var, i, vzVar, jd0Var));
        this.e = Collections.unmodifiableList(arrayList);
    }

    public static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object b(pd0 pd0Var) {
        mc1 mc1Var = new mc1(db.class);
        if (pd0Var == null) {
            return null;
        }
        yd0 yd0Var = new yd0(yd0.u);
        yd0Var.q = new Object[32];
        yd0Var.r = 0;
        yd0Var.s = new String[32];
        yd0Var.t = new int[32];
        yd0Var.Y(pd0Var);
        return c(yd0Var, mc1Var);
    }

    public final Object c(vd0 vd0Var, mc1 mc1Var) {
        int i2 = vd0Var.p;
        boolean z = true;
        if (i2 == 2) {
            vd0Var.p = 1;
        }
        try {
            try {
                try {
                    vd0Var.I();
                    z = false;
                    fb1 fb1VarG = g(mc1Var);
                    Object objB = fb1VarG.b(vd0Var);
                    Class clsW0 = lc1.w0(mc1Var.a());
                    if (objB != null && !clsW0.isInstance(objB)) {
                        throw new ClassCastException("Type adapter '" + fb1VarG + "' returned wrong type; requested " + mc1Var.a() + " but got instance of " + objB.getClass() + "\nVerify that the adapter was registered for the correct type.");
                    }
                    return objB;
                } catch (AssertionError e) {
                    throw new AssertionError("AssertionError (GSON 2.13.1): " + e.getMessage(), e);
                } catch (IllegalStateException e2) {
                    throw new wd0(e2);
                }
            } catch (EOFException e3) {
                if (!z) {
                    throw new wd0(e3);
                }
                vd0Var.L(i2);
                return null;
            } catch (IOException e4) {
                throw new wd0(e4);
            }
        } finally {
            vd0Var.L(i2);
        }
    }

    public final Object d(Reader reader, mc1 mc1Var) {
        vd0 vd0Var = new vd0(reader);
        vd0Var.L(2);
        Object objC = c(vd0Var, mc1Var);
        if (objC != null) {
            try {
                if (vd0Var.I() != 10) {
                    throw new wd0("JSON document was not fully consumed.");
                }
            } catch (ej0 e) {
                throw new wd0(e);
            } catch (IOException e2) {
                throw new rd0(e2);
            }
        }
        return objC;
    }

    public final Object e(String str, mc1 mc1Var) {
        if (str == null) {
            return null;
        }
        return d(new StringReader(str), mc1Var);
    }

    public final Object f(String str, Type type) {
        return e(str, new mc1(type));
    }

    public final fb1 g(mc1 mc1Var) {
        boolean z;
        ConcurrentHashMap concurrentHashMap = this.b;
        fb1 fb1Var = (fb1) concurrentHashMap.get(mc1Var);
        if (fb1Var != null) {
            return fb1Var;
        }
        ThreadLocal threadLocal = this.a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z = true;
        } else {
            fb1 fb1Var2 = (fb1) map.get(mc1Var);
            if (fb1Var2 != null) {
                return fb1Var2;
            }
            z = false;
        }
        try {
            h70 h70Var = new h70();
            map.put(mc1Var, h70Var);
            Iterator it = this.e.iterator();
            fb1 fb1VarA = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                fb1VarA = ((gb1) it.next()).a(this, mc1Var);
                if (fb1VarA != null) {
                    if (h70Var.a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    h70Var.a = fb1VarA;
                    map.put(mc1Var, fb1VarA);
                }
            }
            if (z) {
                threadLocal.remove();
            }
            if (fb1VarA == null) {
                zy.h("GSON (2.13.1) cannot handle ", mc1Var);
                return null;
            }
            if (z) {
                concurrentHashMap.putAll(map);
            }
            return fb1VarA;
        } catch (Throwable th) {
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final ae0 h(Writer writer) {
        ae0 ae0Var = new ae0(writer);
        ae0Var.v(this.g);
        ae0Var.j = this.f;
        ae0Var.w(2);
        ae0Var.l = false;
        return ae0Var;
    }

    public final String i(Object obj) {
        if (obj != null) {
            return j(obj, obj.getClass());
        }
        StringWriter stringWriter = new StringWriter();
        try {
            k(h(stringWriter));
            return stringWriter.toString();
        } catch (IOException e) {
            throw new rd0(e);
        }
    }

    public final String j(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        try {
            l(obj, type, h(stringWriter));
            return stringWriter.toString();
        } catch (IOException e) {
            throw new rd0(e);
        }
    }

    public final void k(ae0 ae0Var) {
        sd0 sd0Var = sd0.b;
        int i2 = ae0Var.i;
        boolean z = ae0Var.j;
        boolean z2 = ae0Var.l;
        ae0Var.j = this.f;
        ae0Var.l = false;
        if (i2 == 2) {
            ae0Var.i = 1;
        }
        try {
            try {
                kc1.z.getClass();
                qd0.e(ae0Var, sd0Var);
                ae0Var.w(i2);
                ae0Var.j = z;
                ae0Var.l = z2;
            } catch (IOException e) {
                throw new rd0(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.13.1): " + e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            ae0Var.w(i2);
            ae0Var.j = z;
            ae0Var.l = z2;
            throw th;
        }
    }

    public final void l(Object obj, Type type, ae0 ae0Var) {
        fb1 fb1VarG = g(new mc1(type));
        int i2 = ae0Var.i;
        if (i2 == 2) {
            ae0Var.i = 1;
        }
        boolean z = ae0Var.j;
        boolean z2 = ae0Var.l;
        ae0Var.j = this.f;
        ae0Var.l = false;
        try {
            try {
                fb1VarG.c(ae0Var, obj);
            } catch (IOException e) {
                throw new rd0(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.13.1): " + e2.getMessage(), e2);
            }
        } finally {
            ae0Var.w(i2);
            ae0Var.j = z;
            ae0Var.l = z2;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }
}
