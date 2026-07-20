package defpackage;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class be1 {
    public static final byte[] a;
    public static final String[] b = new String[0];
    public static final kt0 c;
    public static final Charset d;
    public static final TimeZone e;
    public static final ik f;
    public static final Method g;
    public static final Pattern h;

    static {
        Method declaredMethod;
        byte[] bArr = new byte[0];
        a = bArr;
        mh mhVar = new mh();
        mhVar.v(0, bArr);
        c = new kt0(0L, mhVar, 1);
        ai.a("efbbbf");
        ai.a("feff");
        ai.a("fffe");
        ai.a("0000ffff");
        ai.a("ffff0000");
        d = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        e = TimeZone.getTimeZone("GMT");
        f = new ik(6);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        g = declaredMethod;
        h = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String b(String str) {
        int i = -1;
        int i2 = 0;
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                while (i2 < lowerCase.length()) {
                    char cCharAt = lowerCase.charAt(i2);
                    if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                        return null;
                    }
                    i2++;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressF = (str.startsWith("[") && str.endsWith("]")) ? f(1, str.length() - 1, str) : f(0, str.length(), str);
        if (inetAddressF == null) {
            return null;
        }
        byte[] address = inetAddressF.getAddress();
        if (address.length != 16) {
            throw new AssertionError(l11.j("Invalid IPv6 address: '", str, "'"));
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < address.length) {
            int i5 = i3;
            while (i5 < 16 && address[i5] == 0 && address[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        mh mhVar = new mh();
        while (i2 < address.length) {
            if (i2 == i) {
                mhVar.w(58);
                i2 += i4;
                if (i2 == 16) {
                    mhVar.w(58);
                }
            } else {
                if (i2 > 0) {
                    mhVar.w(58);
                }
                mhVar.x(((address[i2] & 255) << 8) | (address[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return mhVar.s();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!m(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static int e(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return c2 - '7';
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c6, code lost:
    
        if (r7 == 16) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c8, code lost:
    
        if (r8 != (-1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cc, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dc, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e2, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress f(int r16, int r17, java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.be1.f(int, int, java.lang.String):java.net.InetAddress");
    }

    public static int g(int i, int i2, String str, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int h(String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean i(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String j(ga0 ga0Var, boolean z) {
        String str = ga0Var.d;
        int i = ga0Var.e;
        boolean zContains = str.contains(":");
        String strJ = ga0Var.d;
        if (zContains) {
            strJ = l11.j("[", strJ, "]");
        }
        if (!z && i == ga0.b(ga0Var.a)) {
            return strJ;
        }
        return strJ + ":" + i;
    }

    public static List k(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static String[] l(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean m(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean n(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean o(n11 n11Var, int i) {
        long jNanoTime = System.nanoTime();
        long jC = n11Var.b().e() ? n11Var.b().c() - jNanoTime : Long.MAX_VALUE;
        n11Var.b().d(Math.min(jC, TimeUnit.MILLISECONDS.toNanos(i)) + jNanoTime);
        try {
            mh mhVar = new mh();
            while (n11Var.j(mhVar, 8192L) != -1) {
                try {
                    mhVar.skip(mhVar.c);
                } catch (EOFException e2) {
                    throw new AssertionError(e2);
                }
            }
            if (jC == Long.MAX_VALUE) {
                n11Var.b().a();
                return true;
            }
            n11Var.b().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                n11Var.b().a();
                return false;
            }
            n11Var.b().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                n11Var.b().a();
            } else {
                n11Var.b().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static int p(int i, int i2, String str) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int q(int i, int i2, String str) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static w70 r(ArrayList arrayList) {
        jj jjVar = new jj(1);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            v70 v70Var = (v70) obj;
            c70 c70Var = c70.l;
            String strL = v70Var.a.l();
            String strL2 = v70Var.b.l();
            c70Var.getClass();
            jjVar.f(strL, strL2);
        }
        return new w70(jjVar);
    }
}
