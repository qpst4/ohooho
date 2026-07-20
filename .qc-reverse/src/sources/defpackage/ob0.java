package defpackage;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ob0 {
    public static final Pattern i = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    public static final Pattern j = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    public static final Pattern k = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    public static final Pattern l = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    public static final Pattern m = Pattern.compile("`+");
    public static final Pattern n = Pattern.compile("^`+");
    public static final Pattern o = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    public static final Pattern p = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    public static final Pattern q = Pattern.compile("^ *(?:\n *)?");
    public static final Pattern r = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    public static final Pattern s = Pattern.compile("\\s+");
    public static final Pattern t = Pattern.compile(" *$");
    public final BitSet a;
    public final BitSet b;
    public final HashMap c;
    public final i9 d;
    public String e;
    public int f;
    public ct g;
    public bh h;

    public ob0(i9 i9Var) {
        List list = (List) i9Var.c;
        HashMap map = new HashMap();
        b(Arrays.asList(new rb('*'), new rb('_')), map);
        b(list, map);
        this.c = map;
        Set setKeySet = map.keySet();
        BitSet bitSet = new BitSet();
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        this.b = bitSet;
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        this.a = bitSet2;
        this.d = i9Var;
    }

    public static void a(char c, dt dtVar, HashMap map) {
        if (((dt) map.put(Character.valueOf(c), dtVar)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c + "'");
    }

    public static void b(Iterable iterable, HashMap map) {
        f21 f21Var;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            dt dtVar = (dt) it.next();
            char cE = dtVar.e();
            char cA = dtVar.a();
            if (cE == cA) {
                dt dtVar2 = (dt) map.get(Character.valueOf(cE));
                if (dtVar2 == null || dtVar2.e() != dtVar2.a()) {
                    a(cE, dtVar, map);
                } else {
                    if (dtVar2 instanceof f21) {
                        f21Var = (f21) dtVar2;
                    } else {
                        f21 f21Var2 = new f21(cE);
                        f21Var2.f(dtVar2);
                        f21Var = f21Var2;
                    }
                    f21Var.f(dtVar);
                    map.put(Character.valueOf(cE), f21Var);
                }
            } else {
                a(cE, dtVar, map);
                a(cA, dtVar, map);
            }
        }
    }

    public static void d(u41 u41Var, u41 u41Var2, int i2) {
        if (u41Var == null || u41Var2 == null || u41Var == u41Var2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(u41Var.f);
        vm0 vm0Var = u41Var.e;
        vm0 vm0Var2 = u41Var2.e;
        while (vm0Var != vm0Var2) {
            sb.append(((u41) vm0Var).f);
            vm0 vm0Var3 = vm0Var.e;
            vm0Var.f();
            vm0Var = vm0Var3;
        }
        u41Var.f = sb.toString();
    }

    public static void e(vm0 vm0Var, vm0 vm0Var2) {
        u41 u41Var = null;
        u41 u41Var2 = null;
        int length = 0;
        while (vm0Var != null) {
            if (vm0Var instanceof u41) {
                u41Var2 = (u41) vm0Var;
                if (u41Var == null) {
                    u41Var = u41Var2;
                }
                length = u41Var2.f.length() + length;
            } else {
                d(u41Var, u41Var2, length);
                u41Var = null;
                u41Var2 = null;
                length = 0;
            }
            if (vm0Var == vm0Var2) {
                break;
            } else {
                vm0Var = vm0Var.e;
            }
        }
        d(u41Var, u41Var2, length);
    }

    public final String c(Pattern pattern) {
        if (this.f >= this.e.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.e);
        matcher.region(this.f, this.e.length());
        if (!matcher.find()) {
            return null;
        }
        this.f = matcher.end();
        return matcher.group();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ef A[PHI: r6
  0x01ef: PHI (r6v35 char) = (r6v34 char), (r6v36 char), (r6v37 char) binds: [B:113:0x01e4, B:115:0x01e8, B:118:0x01ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0543 A[LOOP:0: B:3:0x0013->B:265:0x0543, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x054a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f1  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r27v0, types: [vm0] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v17, types: [vm0, zk] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v27, types: [vm0] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v44, types: [u41] */
    /* JADX WARN: Type inference failed for: r4v45, types: [u41] */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v55, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v60, types: [vm0] */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v63 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r4v66 */
    /* JADX WARN: Type inference failed for: r5v22, types: [nb0] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r8v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r26, defpackage.vm0 r27) {
        /*
            Method dump skipped, instruction units count: 1380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ob0.f(java.lang.String, vm0):void");
    }

    public final char g() {
        if (this.f < this.e.length()) {
            return this.e.charAt(this.f);
        }
        return (char) 0;
    }

    public final void h(ct ctVar) {
        boolean z;
        vm0 vm0Var;
        HashMap map = new HashMap();
        ct ctVar2 = this.g;
        while (ctVar2 != null) {
            ct ctVar3 = ctVar2.e;
            if (ctVar3 == ctVar) {
                break;
            } else {
                ctVar2 = ctVar3;
            }
        }
        while (ctVar2 != null) {
            u41 u41Var = ctVar2.a;
            char c = ctVar2.b;
            dt dtVar = (dt) this.c.get(Character.valueOf(c));
            if (!ctVar2.d || dtVar == null) {
                ctVar2 = ctVar2.f;
            } else {
                char cE = dtVar.e();
                ct ctVar4 = ctVar2.e;
                int iC = 0;
                boolean z2 = false;
                while (ctVar4 != null && ctVar4 != ctVar && ctVar4 != map.get(Character.valueOf(c))) {
                    if (ctVar4.c && ctVar4.b == cE) {
                        iC = dtVar.c(ctVar4, ctVar2);
                        z2 = true;
                        if (iC > 0) {
                            z = true;
                            break;
                        }
                    }
                    ctVar4 = ctVar4.e;
                }
                z = z2;
                z2 = false;
                if (z2) {
                    u41 u41Var2 = ctVar4.a;
                    ctVar4.g -= iC;
                    ctVar2.g -= iC;
                    String str = u41Var2.f;
                    u41Var2.f = str.substring(0, str.length() - iC);
                    String str2 = u41Var.f;
                    u41Var.f = str2.substring(0, str2.length() - iC);
                    ct ctVar5 = ctVar2.e;
                    while (ctVar5 != null && ctVar5 != ctVar4) {
                        ct ctVar6 = ctVar5.e;
                        i(ctVar5);
                        ctVar5 = ctVar6;
                    }
                    if (u41Var2 != u41Var && (vm0Var = u41Var2.e) != u41Var) {
                        e(vm0Var, u41Var.d);
                    }
                    dtVar.d(u41Var2, u41Var, iC);
                    if (ctVar4.g == 0) {
                        ctVar4.a.f();
                        i(ctVar4);
                    }
                    if (ctVar2.g == 0) {
                        ct ctVar7 = ctVar2.f;
                        u41Var.f();
                        i(ctVar2);
                        ctVar2 = ctVar7;
                    }
                } else {
                    if (!z) {
                        map.put(Character.valueOf(c), ctVar2.e);
                        if (!ctVar2.c) {
                            i(ctVar2);
                        }
                    }
                    ctVar2 = ctVar2.f;
                }
            }
        }
        while (true) {
            ct ctVar8 = this.g;
            if (ctVar8 == null || ctVar8 == ctVar) {
                return;
            } else {
                i(ctVar8);
            }
        }
    }

    public final void i(ct ctVar) {
        ct ctVar2 = ctVar.e;
        if (ctVar2 != null) {
            ctVar2.f = ctVar.f;
        }
        ct ctVar3 = ctVar.f;
        if (ctVar3 == null) {
            this.g = ctVar2;
        } else {
            ctVar3.e = ctVar2;
        }
    }
}
