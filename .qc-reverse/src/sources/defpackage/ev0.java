package defpackage;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ev0 {
    public static final Logger a = Logger.getLogger(ev0.class.getName());
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    public static synchronized void a(String str, y4 y4Var) {
        try {
            ConcurrentHashMap concurrentHashMap = d;
            if (concurrentHashMap.containsKey(str.toLowerCase())) {
                if (!y4Var.getClass().equals(((y4) concurrentHashMap.get(str.toLowerCase())).getClass())) {
                    a.warning("Attempted overwrite of a catalogueName catalogue for name ".concat(str));
                    throw new GeneralSecurityException("catalogue for name " + str + " has been already registered");
                }
            }
            concurrentHashMap.put(str.toLowerCase(), y4Var);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static he0 b(String str) throws GeneralSecurityException {
        he0 he0Var = (he0) b.get(str);
        if (he0Var != null) {
            return he0Var;
        }
        throw new GeneralSecurityException(l11.j("No key manager found for key type: ", str, ".  Check the configuration of the registry."));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static sq0 c(tb0 tb0Var) throws GeneralSecurityException {
        sq0 sq0Var;
        byte[] bArrArray;
        se0 se0Var = (se0) tb0Var.c;
        int i = de1.a;
        sq0 sq0Var2 = null;
        if (se0Var.e.c.size() == 0) {
            s1.l("empty keyset");
            return null;
        }
        int i2 = se0Var.d;
        Iterator<E> it = se0Var.e.iterator();
        byte b2 = 0;
        boolean z = false;
        boolean z2 = true;
        while (true) {
            char c2 = 5;
            if (!it.hasNext()) {
                if (!z && !z2) {
                    s1.l("keyset doesn't contain a valid primary key");
                    return null;
                }
                sq0 sq0Var3 = new sq0();
                sq0Var3.a = new ConcurrentHashMap();
                for (re0 re0Var : se0Var.e) {
                    if (re0Var.q() == 2) {
                        Object objD = b(re0Var.p().d).d(re0Var.p().e);
                        ConcurrentHashMap concurrentHashMap = sq0Var3.a;
                        int iB = l11.b(re0Var.g);
                        if (iB == 0) {
                            iB = 6;
                        }
                        int iR = l11.r(iB);
                        if (iR == 1) {
                            sq0Var = sq0Var2;
                            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(re0Var.f).array();
                        } else if (iR == 2) {
                            sq0Var = sq0Var2;
                            bArrArray = ByteBuffer.allocate(5).put(b2).putInt(re0Var.f).array();
                        } else if (iR != 3) {
                            if (iR != 4) {
                                s1.l("unknown output prefix type");
                                return sq0Var2;
                            }
                            sq0Var = sq0Var2;
                            bArrArray = ByteBuffer.allocate(5).put(b2).putInt(re0Var.f).array();
                        } else {
                            bArrArray = fp1.a;
                            sq0Var = sq0Var2;
                        }
                        rq0 rq0Var = new rq0(objD, bArrArray);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(rq0Var);
                        byte[] bArr = rq0Var.b;
                        String str = new String(bArr == null ? sq0Var : Arrays.copyOf(bArr, bArr.length), sq0.c);
                        List list = (List) concurrentHashMap.put(str, Collections.unmodifiableList(arrayList));
                        if (list != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(list);
                            arrayList2.add(rq0Var);
                            concurrentHashMap.put(str, Collections.unmodifiableList(arrayList2));
                        }
                        if (re0Var.f == se0Var.d) {
                            sq0Var3.b = rq0Var;
                        }
                    } else {
                        sq0Var = sq0Var2;
                    }
                    b2 = 0;
                    sq0Var2 = sq0Var;
                }
                return sq0Var3;
            }
            re0 re0Var2 = (re0) it.next();
            if (re0Var2.d == null) {
                throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(re0Var2.f)));
            }
            int iB2 = l11.b(re0Var2.g);
            if (iB2 == 0) {
                iB2 = 6;
            }
            if (iB2 == 1) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(re0Var2.f)));
            }
            if (re0Var2.q() == 1) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(re0Var2.f)));
            }
            if (re0Var2.q() == 2 && re0Var2.f == i2) {
                if (z) {
                    s1.l("keyset contains multiple primary keys");
                    return null;
                }
                z = true;
            }
            int i3 = re0Var2.p().f;
            if (i3 == 0) {
                c2 = 1;
            } else if (i3 == 1) {
                c2 = 2;
            } else if (i3 == 2) {
                c2 = 3;
            } else if (i3 == 3) {
                c2 = 4;
            } else if (i3 != 4) {
                c2 = 0;
            }
            if ((c2 != 0 ? c2 : (char) 6) != 4) {
                z2 = false;
            }
        }
    }

    public static synchronized w50 d(je0 je0Var) {
        he0 he0VarB;
        he0VarB = b(je0Var.d);
        if (!((Boolean) c.get(je0Var.d)).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + je0Var.d);
        }
        return he0VarB.f(je0Var.e);
    }

    public static synchronized w50 e(String str, w50 w50Var) {
        he0 he0VarB;
        he0VarB = b(str);
        if (!((Boolean) c.get(str)).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(str));
        }
        return he0VarB.e(w50Var);
    }

    public static synchronized fe0 f(je0 je0Var) {
        he0 he0VarB;
        he0VarB = b(je0Var.d);
        if (!((Boolean) c.get(je0Var.d)).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + je0Var.d);
        }
        return he0VarB.a(je0Var.e);
    }

    public static synchronized void g(he0 he0Var, boolean z) {
        try {
            if (he0Var == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String strC = he0Var.c();
            ConcurrentHashMap concurrentHashMap = b;
            if (concurrentHashMap.containsKey(strC)) {
                he0 he0VarB = b(strC);
                boolean zBooleanValue = ((Boolean) c.get(strC)).booleanValue();
                if (!he0Var.getClass().equals(he0VarB.getClass()) || (!zBooleanValue && z)) {
                    a.warning("Attempted overwrite of a registered key manager for key type ".concat(strC));
                    throw new GeneralSecurityException("typeUrl (" + strC + ") is already registered with " + he0VarB.getClass().getName() + ", cannot be re-registered with " + he0Var.getClass().getName());
                }
            }
            concurrentHashMap.put(strC, he0Var);
            c.put(strC, Boolean.valueOf(z));
        } catch (Throwable th) {
            throw th;
        }
    }
}
