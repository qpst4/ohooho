package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ga0 {
    public static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final List f;
    public final String g;
    public final String h;

    public ga0(fa0 fa0Var) {
        this.a = fa0Var.a;
        String str = fa0Var.b;
        this.b = g(str, 0, str.length(), false);
        String str2 = fa0Var.c;
        this.c = g(str2, 0, str2.length(), false);
        this.d = fa0Var.d;
        int i2 = fa0Var.e;
        this.e = i2 == -1 ? b(fa0Var.a) : i2;
        h(fa0Var.f, false);
        ArrayList arrayList = fa0Var.g;
        this.f = arrayList != null ? h(arrayList, true) : null;
        String str3 = fa0Var.h;
        this.g = str3 != null ? g(str3, 0, str3.length(), false) : null;
        this.h = fa0Var.toString();
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int iCharCount = i2;
        while (iCharCount < i3) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z || (z2 && !i(iCharCount, i3, str)))) || (iCodePointAt == 43 && z3)))) {
                mh mhVar = new mh();
                mhVar.A(i2, iCharCount, str);
                mh mhVar2 = null;
                while (iCharCount < i3) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z3) {
                            String str3 = z ? "+" : "%2B";
                            mhVar.A(0, str3.length(), str3);
                        } else if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || ((iCodePointAt2 >= 128 && z4) || str2.indexOf(iCodePointAt2) != -1 || (iCodePointAt2 == 37 && (!z || (z2 && !i(iCharCount, i3, str)))))) {
                            if (mhVar2 == null) {
                                mhVar2 = new mh();
                            }
                            mhVar2.B(iCodePointAt2);
                            while (!mhVar2.h()) {
                                byte b = mhVar2.readByte();
                                mhVar.w(37);
                                char[] cArr = i;
                                mhVar.w(cArr[((b & 255) >> 4) & 15]);
                                mhVar.w(cArr[b & 15]);
                            }
                        } else {
                            mhVar.B(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                }
                return mhVar.s();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i2, i3);
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(java.lang.String r8, int r9, int r10, boolean r11) {
        /*
            r0 = r9
        L1:
            if (r0 >= r10) goto L60
            char r1 = r8.charAt(r0)
            r2 = 43
            r3 = 37
            if (r1 == r3) goto L15
            if (r1 != r2) goto L12
            if (r11 == 0) goto L12
            goto L15
        L12:
            int r0 = r0 + 1
            goto L1
        L15:
            mh r1 = new mh
            r1.<init>()
            r1.A(r9, r0, r8)
        L1d:
            if (r0 >= r10) goto L5b
            int r9 = r8.codePointAt(r0)
            if (r9 != r3) goto L48
            int r4 = r0 + 2
            if (r4 >= r10) goto L48
            int r5 = r0 + 1
            char r5 = r8.charAt(r5)
            int r5 = defpackage.be1.e(r5)
            char r6 = r8.charAt(r4)
            int r6 = defpackage.be1.e(r6)
            r7 = -1
            if (r5 == r7) goto L52
            if (r6 == r7) goto L52
            int r0 = r5 << 4
            int r0 = r0 + r6
            r1.w(r0)
            r0 = r4
            goto L55
        L48:
            if (r9 != r2) goto L52
            if (r11 == 0) goto L52
            r4 = 32
            r1.w(r4)
            goto L55
        L52:
            r1.B(r9)
        L55:
            int r9 = java.lang.Character.charCount(r9)
            int r0 = r0 + r9
            goto L1d
        L5b:
            java.lang.String r8 = r1.s()
            return r8
        L60:
            java.lang.String r8 = r8.substring(r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ga0.g(java.lang.String, int, int, boolean):java.lang.String");
    }

    public static List h(ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = (String) arrayList.get(i2);
            arrayList2.add(str != null ? g(str, 0, str.length(), z) : null);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public static boolean i(int i2, int i3, String str) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && be1.e(str.charAt(i2 + 1)) != -1 && be1.e(str.charAt(i4)) != -1;
    }

    public static ArrayList j(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iIndexOf = str.indexOf(38, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i2);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i2, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i2 = iIndexOf + 1;
        }
        return arrayList;
    }

    public final String c() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.h;
        return str.substring(str.indexOf(58, length) + 1, str.indexOf(64));
    }

    public final ArrayList d() {
        int length = this.a.length() + 3;
        String str = this.h;
        int iIndexOf = str.indexOf(47, length);
        int iG = be1.g(iIndexOf, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iG) {
            int i2 = iIndexOf + 1;
            int iH = be1.h(str, i2, iG, '/');
            arrayList.add(str.substring(i2, iH));
            iIndexOf = iH;
        }
        return arrayList;
    }

    public final String e() {
        if (this.f == null) {
            return null;
        }
        String str = this.h;
        int iIndexOf = str.indexOf(63) + 1;
        return str.substring(iIndexOf, be1.h(str, iIndexOf, str.length(), '#'));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ga0) && ((ga0) obj).h.equals(this.h);
    }

    public final String f() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.h;
        return str.substring(length, be1.g(length, str.length(), str, ":@"));
    }

    public final int hashCode() {
        return this.h.hashCode();
    }

    public final URI k() {
        String strSubstring;
        fa0 fa0Var = new fa0();
        String str = this.a;
        fa0Var.a = str;
        fa0Var.b = f();
        fa0Var.c = c();
        fa0Var.d = this.d;
        int iB = b(str);
        int i2 = this.e;
        if (i2 == iB) {
            i2 = -1;
        }
        fa0Var.e = i2;
        ArrayList arrayList = fa0Var.f;
        arrayList.clear();
        arrayList.addAll(d());
        String strE = e();
        fa0Var.g = strE != null ? j(a(strE, 0, strE.length(), " \"'<>#", true, false, true, true)) : null;
        if (this.g == null) {
            strSubstring = null;
        } else {
            String str2 = this.h;
            strSubstring = str2.substring(str2.indexOf(35) + 1);
        }
        fa0Var.h = strSubstring;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str3 = (String) arrayList.get(i3);
            arrayList.set(i3, a(str3, 0, str3.length(), "[]", true, true, false, true));
        }
        ArrayList arrayList2 = fa0Var.g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                String str4 = (String) fa0Var.g.get(i4);
                if (str4 != null) {
                    fa0Var.g.set(i4, a(str4, 0, str4.length(), "\\^`{|}", true, true, true, true));
                }
            }
        }
        String str5 = fa0Var.h;
        if (str5 != null) {
            fa0Var.h = a(str5, 0, str5.length(), " \"#<>\\^`{|}", true, true, false, false);
        }
        String string = fa0Var.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                zy.m(e);
                return null;
            }
        }
    }

    public final String toString() {
        return this.h;
    }
}
