package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w90 implements Closeable {
    public static final Logger f = Logger.getLogger(h90.class.getName());
    public final oh b;
    public final v90 c;
    public final boolean d;
    public final t80 e;

    public w90(gt0 gt0Var, boolean z) {
        this.b = gt0Var;
        this.d = z;
        v90 v90Var = new v90(gt0Var);
        this.c = v90Var;
        this.e = new t80(v90Var);
    }

    public static int a(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        h90.c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    public static int r(oh ohVar) {
        return (ohVar.readByte() & 255) | ((ohVar.readByte() & 255) << 16) | ((ohVar.readByte() & 255) << 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    public final boolean g(boolean z, s90 s90Var) throws IOException {
        int i;
        aa0[] aa0VarArr;
        int i2 = 0;
        try {
            this.b.n(9L);
            int iR = r(this.b);
            if (iR < 0 || iR > 16384) {
                h90.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(iR));
                throw null;
            }
            byte b = (byte) (this.b.readByte() & 255);
            if (z && b != 4) {
                h90.c("Expected a SETTINGS frame but was %s", Byte.valueOf(b));
                throw null;
            }
            byte b2 = (byte) (this.b.readByte() & 255);
            int i3 = this.b.readInt();
            int i4 = Integer.MAX_VALUE & i3;
            Logger logger = f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(h90.a(true, i4, iR, b, b2));
            }
            switch (b) {
                case 0:
                    i(s90Var, iR, b2, i4);
                    return true;
                case 1:
                    q(s90Var, iR, b2, i4);
                    return true;
                case 2:
                    if (iR != 5) {
                        h90.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iR));
                        throw null;
                    }
                    if (i4 == 0) {
                        h90.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                        throw null;
                    }
                    oh ohVar = this.b;
                    ohVar.readInt();
                    ohVar.readByte();
                    return true;
                case 3:
                    if (iR != 4) {
                        h90.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(iR));
                        throw null;
                    }
                    if (i4 == 0) {
                        h90.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        throw null;
                    }
                    int i5 = this.b.readInt();
                    int[] iArrX = l11.x(11);
                    int length = iArrX.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            int i7 = iArrX[i6];
                            if (l11.e(i7) == i5) {
                                i2 = i7;
                            } else {
                                i6++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        h90.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i5));
                        throw null;
                    }
                    u90 u90Var = (u90) s90Var.d;
                    if (i4 != 0 && (i3 & 1) == 0) {
                        u90Var.m(new m90(u90Var, new Object[]{u90Var.e, Integer.valueOf(i4)}, i4, i2));
                        return true;
                    }
                    aa0 aa0VarQ = u90Var.q(i4);
                    if (aa0VarQ != null) {
                        synchronized (aa0VarQ) {
                            if (aa0VarQ.k == 0) {
                                aa0VarQ.k = i2;
                                aa0VarQ.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    return true;
                case 4:
                    t(s90Var, iR, b2, i4);
                    return true;
                case 5:
                    s(s90Var, iR, b2, i4);
                    return true;
                case 6:
                    if (iR != 8) {
                        h90.c("TYPE_PING length != 8: %s", Integer.valueOf(iR));
                        throw null;
                    }
                    if (i4 != 0) {
                        h90.c("TYPE_PING streamId != 0", new Object[0]);
                        throw null;
                    }
                    int i8 = this.b.readInt();
                    int i9 = this.b.readInt();
                    boolean z2 = (b2 & 1) != 0;
                    u90 u90Var2 = (u90) s90Var.d;
                    if (z2) {
                        synchronized (u90Var2) {
                            u90 u90Var3 = (u90) s90Var.d;
                            u90Var3.l = false;
                            u90Var3.notifyAll();
                            break;
                        }
                    } else {
                        try {
                            u90Var2.i.execute(new r90(u90Var2, true, i8, i9));
                            break;
                        } catch (RejectedExecutionException unused) {
                        }
                    }
                    return true;
                case 7:
                    if (iR < 8) {
                        h90.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(iR));
                        throw null;
                    }
                    if (i4 != 0) {
                        h90.c("TYPE_GOAWAY streamId != 0", new Object[0]);
                        throw null;
                    }
                    int i10 = this.b.readInt();
                    int i11 = this.b.readInt();
                    int i12 = iR - 8;
                    int[] iArrX2 = l11.x(11);
                    int length2 = iArrX2.length;
                    int i13 = 0;
                    while (true) {
                        if (i13 < length2) {
                            i = iArrX2[i13];
                            if (l11.e(i) != i11) {
                                i13++;
                            }
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        h90.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i11));
                        throw null;
                    }
                    ai aiVarE = ai.f;
                    if (i12 > 0) {
                        aiVarE = this.b.e(i12);
                    }
                    aiVarE.i();
                    synchronized (((u90) s90Var.d)) {
                        aa0VarArr = (aa0[]) ((u90) s90Var.d).d.values().toArray(new aa0[((u90) s90Var.d).d.size()]);
                        ((u90) s90Var.d).h = true;
                        break;
                    }
                    int length3 = aa0VarArr.length;
                    while (i2 < length3) {
                        aa0 aa0Var = aa0VarArr[i2];
                        if (aa0Var.c > i10 && aa0Var.f()) {
                            synchronized (aa0Var) {
                                if (aa0Var.k == 0) {
                                    aa0Var.k = 5;
                                    aa0Var.notifyAll();
                                }
                            }
                            ((u90) s90Var.d).q(aa0Var.c);
                        }
                        i2++;
                    }
                    return true;
                case 8:
                    if (iR != 4) {
                        h90.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iR));
                        throw null;
                    }
                    long j = ((long) this.b.readInt()) & 2147483647L;
                    if (j == 0) {
                        h90.c("windowSizeIncrement was 0", Long.valueOf(j));
                        throw null;
                    }
                    u90 u90Var4 = (u90) s90Var.d;
                    if (i4 == 0) {
                        synchronized (u90Var4) {
                            u90 u90Var5 = (u90) s90Var.d;
                            u90Var5.n += j;
                            u90Var5.notifyAll();
                            break;
                        }
                        return true;
                    }
                    aa0 aa0VarH = u90Var4.h(i4);
                    if (aa0VarH != null) {
                        synchronized (aa0VarH) {
                            aa0VarH.b += j;
                            if (j > 0) {
                                aa0VarH.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    return true;
                default:
                    this.b.skip(iR);
                    return true;
            }
        } catch (IOException unused2) {
            return false;
        }
    }

    public final void h(s90 s90Var) {
        if (this.d) {
            if (g(true, s90Var)) {
                return;
            }
            h90.c("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        ai aiVar = h90.a;
        ai aiVarE = this.b.e(aiVar.b.length);
        Level level = Level.FINE;
        Logger logger = f;
        if (logger.isLoggable(level)) {
            String strE = aiVarE.e();
            byte[] bArr = be1.a;
            Locale locale = Locale.US;
            logger.fine("<< CONNECTION " + strE);
        }
        if (aiVar.equals(aiVarE)) {
            return;
        }
        h90.c("Expected a connection header but was %s", aiVarE.l());
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x012b, code lost:
    
        if (r9 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x012d, code lost:
    
        r2.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(defpackage.s90 r17, int r18, byte r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w90.i(s90, int, byte, int):void");
    }

    public final ArrayList m(int i, short s, byte b, int i2) throws IOException {
        v90 v90Var = this.c;
        v90Var.f = i;
        v90Var.c = i;
        v90Var.g = s;
        v90Var.d = b;
        v90Var.e = i2;
        t80 t80Var = this.e;
        gt0 gt0Var = t80Var.b;
        ArrayList arrayList = t80Var.a;
        while (!gt0Var.a()) {
            byte b2 = gt0Var.readByte();
            int i3 = b2 & 255;
            if (i3 == 128) {
                zy.p("index == 0");
                return null;
            }
            if ((b2 & 128) == 128) {
                int iE = t80Var.e(i3, 127);
                int i4 = iE - 1;
                if (i4 >= 0) {
                    v70[] v70VarArr = v80.a;
                    if (i4 <= v70VarArr.length - 1) {
                        arrayList.add(v70VarArr[i4]);
                    }
                }
                int length = t80Var.f + 1 + (i4 - v80.a.length);
                if (length >= 0) {
                    v70[] v70VarArr2 = t80Var.e;
                    if (length < v70VarArr2.length) {
                        arrayList.add(v70VarArr2[length]);
                    }
                }
                zy.p(qq0.i("Header index too large ", iE));
                return null;
            }
            if (i3 == 64) {
                ai aiVarD = t80Var.d();
                v80.a(aiVarD);
                t80Var.c(new v70(aiVarD, t80Var.d()));
            } else if ((b2 & 64) == 64) {
                t80Var.c(new v70(t80Var.b(t80Var.e(i3, 63) - 1), t80Var.d()));
            } else if ((b2 & 32) == 32) {
                int iE2 = t80Var.e(i3, 31);
                t80Var.d = iE2;
                if (iE2 < 0 || iE2 > t80Var.c) {
                    throw new IOException("Invalid dynamic table size update " + t80Var.d);
                }
                int i5 = t80Var.h;
                if (iE2 < i5) {
                    if (iE2 == 0) {
                        Arrays.fill(t80Var.e, (Object) null);
                        t80Var.f = t80Var.e.length - 1;
                        t80Var.g = 0;
                        t80Var.h = 0;
                    } else {
                        t80Var.a(i5 - iE2);
                    }
                }
            } else if (i3 == 16 || i3 == 0) {
                ai aiVarD2 = t80Var.d();
                v80.a(aiVarD2);
                arrayList.add(new v70(aiVarD2, t80Var.d()));
            } else {
                arrayList.add(new v70(t80Var.b(t80Var.e(i3, 15) - 1), t80Var.d()));
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList.clear();
        return arrayList2;
    }

    public final void q(s90 s90Var, int i, byte b, int i2) throws IOException {
        boolean zG;
        boolean z = false;
        if (i2 == 0) {
            h90.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z2 = (b & 1) != 0;
        short s = (b & 8) != 0 ? (short) (this.b.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            oh ohVar = this.b;
            ohVar.readInt();
            ohVar.readByte();
            i -= 5;
        }
        ArrayList arrayListM = m(a(i, b, s), s, b, i2);
        u90 u90Var = (u90) s90Var.d;
        if (i2 != 0 && (i2 & 1) == 0) {
            z = true;
        }
        if (z) {
            try {
                u90Var.m(new m90(u90Var, new Object[]{u90Var.e, Integer.valueOf(i2)}, i2, arrayListM, z2));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (u90Var) {
            try {
                aa0 aa0VarH = ((u90) s90Var.d).h(i2);
                if (aa0VarH != null) {
                    synchronized (aa0VarH) {
                        aa0VarH.f = true;
                        aa0VarH.e.add(be1.r(arrayListM));
                        zG = aa0VarH.g();
                        aa0VarH.notifyAll();
                    }
                    if (!zG) {
                        aa0VarH.d.q(aa0VarH.c);
                    }
                    if (z2) {
                        aa0VarH.h();
                        return;
                    }
                    return;
                }
                u90 u90Var2 = (u90) s90Var.d;
                if (u90Var2.h) {
                    return;
                }
                if (i2 <= u90Var2.f) {
                    return;
                }
                if (i2 % 2 == u90Var2.g % 2) {
                    return;
                }
                aa0 aa0Var = new aa0(i2, (u90) s90Var.d, false, z2, be1.r(arrayListM));
                u90 u90Var3 = (u90) s90Var.d;
                u90Var3.f = i2;
                u90Var3.d.put(Integer.valueOf(i2), aa0Var);
                u90.v.execute(new s90(s90Var, new Object[]{((u90) s90Var.d).e, Integer.valueOf(i2)}, aa0Var));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s(s90 s90Var, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            h90.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short s = (b & 8) != 0 ? (short) (this.b.readByte() & 255) : (short) 0;
        int i3 = this.b.readInt() & Integer.MAX_VALUE;
        ArrayList arrayListM = m(a(i - 4, b, s), s, b, i2);
        u90 u90Var = (u90) s90Var.d;
        synchronized (u90Var) {
            try {
                if (u90Var.u.contains(Integer.valueOf(i3))) {
                    u90Var.u(i3, 2);
                    return;
                }
                u90Var.u.add(Integer.valueOf(i3));
                try {
                    u90Var.m(new m90(u90Var, new Object[]{u90Var.e, Integer.valueOf(i3)}, i3, arrayListM));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(s90 s90Var, int i, byte b, int i2) {
        long j;
        aa0[] aa0VarArr = null;
        if (i2 != 0) {
            h90.c("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b & 1) != 0) {
            if (i == 0) {
                return;
            }
            h90.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            throw null;
        }
        if (i % 6 != 0) {
            h90.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        jl1 jl1Var = new jl1(8);
        for (int i3 = 0; i3 < i; i3 += 6) {
            int i4 = this.b.readShort() & 65535;
            int i5 = this.b.readInt();
            if (i4 == 2) {
                if (i5 != 0 && i5 != 1) {
                    h90.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
            } else if (i4 == 3) {
                i4 = 4;
            } else if (i4 != 4) {
                if (i4 == 5 && (i5 < 16384 || i5 > 16777215)) {
                    h90.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                    throw null;
                }
            } else {
                if (i5 < 0) {
                    h90.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    throw null;
                }
                i4 = 7;
            }
            jl1Var.e(i4, i5);
        }
        synchronized (((u90) s90Var.d)) {
            try {
                int iD = ((u90) s90Var.d).p.d();
                jl1 jl1Var2 = ((u90) s90Var.d).p;
                jl1Var2.getClass();
                for (int i6 = 0; i6 < 10; i6++) {
                    if (((1 << i6) & jl1Var.b) != 0) {
                        jl1Var2.e(i6, ((int[]) jl1Var.c)[i6]);
                    }
                }
                try {
                    u90 u90Var = (u90) s90Var.d;
                    u90Var.i.execute(new s90(s90Var, new Object[]{u90Var.e}, jl1Var));
                } catch (RejectedExecutionException unused) {
                }
                int iD2 = ((u90) s90Var.d).p.d();
                if (iD2 == -1 || iD2 == iD) {
                    j = 0;
                } else {
                    j = iD2 - iD;
                    u90 u90Var2 = (u90) s90Var.d;
                    if (!u90Var2.q) {
                        u90Var2.q = true;
                    }
                    if (!u90Var2.d.isEmpty()) {
                        aa0VarArr = (aa0[]) ((u90) s90Var.d).d.values().toArray(new aa0[((u90) s90Var.d).d.size()]);
                    }
                }
                u90.v.execute(new t90(s90Var, ((u90) s90Var.d).e));
            } finally {
            }
        }
        if (aa0VarArr == null || j == 0) {
            return;
        }
        for (aa0 aa0Var : aa0VarArr) {
            synchronized (aa0Var) {
                aa0Var.b += j;
                if (j > 0) {
                    aa0Var.notifyAll();
                }
            }
        }
    }
}
