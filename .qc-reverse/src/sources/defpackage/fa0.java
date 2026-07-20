package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fa0 {
    public String a;
    public String d;
    public final ArrayList f;
    public ArrayList g;
    public String h;
    public String b = "";
    public String c = "";
    public int e = -1;

    public fa0() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add("");
    }

    public final ga0 a() {
        if (this.a == null) {
            s1.f("scheme == null");
            return null;
        }
        if (this.d != null) {
            return new ga0(this);
        }
        s1.f("host == null");
        return null;
    }

    public final void b(ga0 ga0Var, String str) {
        char cCharAt;
        int i;
        char c;
        int iG;
        ArrayList arrayList;
        String str2;
        int i2;
        int i3;
        ArrayList arrayList2;
        int i4;
        String str3;
        char c2;
        ArrayList arrayList3;
        char cCharAt2;
        String str4 = str;
        int iP = be1.p(0, str4.length(), str4);
        int iQ = be1.q(iP, str4.length(), str4);
        if (iQ - iP >= 2 && (((cCharAt = str4.charAt(iP)) >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
            int i5 = iP + 1;
            while (true) {
                if (i5 >= iQ) {
                    break;
                }
                char cCharAt3 = str4.charAt(i5);
                if ((cCharAt3 >= 'a' && cCharAt3 <= 'z') || ((cCharAt3 >= 'A' && cCharAt3 <= 'Z') || ((cCharAt3 >= '0' && cCharAt3 <= '9') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                    i5++;
                } else if (cCharAt3 == ':') {
                    i = i5;
                }
            }
        } else {
            i = -1;
        }
        if (i != -1) {
            if (str4.regionMatches(true, iP, "https:", 0, 6)) {
                this.a = "https";
                iP += 6;
                str4 = str;
            } else {
                str4 = str;
                if (!str4.regionMatches(true, iP, "http:", 0, 5)) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, i) + "'");
                }
                this.a = "http";
                iP += 5;
            }
        } else {
            if (ga0Var == null) {
                zy.n("Expected URL scheme 'http' or 'https' but no colon was found");
                return;
            }
            this.a = ga0Var.a;
        }
        int i6 = iP;
        int i7 = 0;
        while (true) {
            c = '\\';
            if (i6 >= iQ || !((cCharAt2 = str4.charAt(i6)) == '\\' || cCharAt2 == '/')) {
                break;
            }
            i7++;
            i6++;
        }
        char c3 = '?';
        ArrayList arrayList4 = this.f;
        char c4 = '#';
        if (i7 >= 2 || ga0Var == null || !ga0Var.a.equals(this.a)) {
            int i8 = iP + i7;
            boolean z = false;
            boolean z2 = false;
            while (true) {
                iG = be1.g(i8, iQ, str4, "@/\\?#");
                byte bCharAt = iG != iQ ? str4.charAt(iG) : (byte) -1;
                if (bCharAt == -1 || bCharAt == c4 || bCharAt == 47 || bCharAt == c || bCharAt == c3) {
                    break;
                }
                if (bCharAt != 64) {
                    str3 = str4;
                    arrayList2 = arrayList4;
                } else {
                    if (z) {
                        arrayList2 = arrayList4;
                        i4 = iG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.c);
                        sb.append("%40");
                        str3 = str;
                        sb.append(ga0.a(str3, i8, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                        this.c = sb.toString();
                    } else {
                        ArrayList arrayList5 = arrayList4;
                        int iH = be1.h(str4, i8, iG, ':');
                        arrayList2 = arrayList5;
                        String strA = ga0.a(str, i8, iH, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        if (z2) {
                            strA = this.b + "%40" + strA;
                        }
                        this.b = strA;
                        if (iH != iG) {
                            int i9 = iH + 1;
                            i4 = iG;
                            this.c = ga0.a(str, i9, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            z = true;
                        } else {
                            i4 = iG;
                        }
                        str3 = str;
                        z2 = true;
                    }
                    i8 = i4 + 1;
                }
                arrayList4 = arrayList2;
                str4 = str3;
                c4 = '#';
                c = '\\';
                c3 = '?';
            }
            arrayList = arrayList4;
            int i10 = i8;
            str2 = str4;
            int i11 = i10;
            while (true) {
                if (i11 < iG) {
                    char cCharAt4 = str2.charAt(i11);
                    if (cCharAt4 == ':') {
                        i2 = i11;
                        break;
                    }
                    if (cCharAt4 == '[') {
                        do {
                            i11++;
                            if (i11 < iG) {
                            }
                        } while (str2.charAt(i11) != ']');
                    }
                    i11++;
                } else {
                    i2 = iG;
                    break;
                }
            }
            int i12 = i2 + 1;
            if (i12 < iG) {
                this.d = be1.b(ga0.g(str2, i10, i2, false));
                try {
                    i3 = Integer.parseInt(ga0.a(str2, i12, iG, "", false, false, false, true));
                } catch (NumberFormatException unused) {
                }
                if (i3 <= 0 || i3 > 65535) {
                    i3 = -1;
                }
                this.e = i3;
                if (i3 == -1) {
                    throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i12, iG) + '\"');
                }
            } else {
                this.d = be1.b(ga0.g(str2, i10, i2, false));
                this.e = ga0.b(this.a);
            }
            if (this.d == null) {
                throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i10, i2) + '\"');
            }
            iP = iG;
        } else {
            this.b = ga0Var.f();
            this.c = ga0Var.c();
            this.d = ga0Var.d;
            this.e = ga0Var.e;
            arrayList4.clear();
            arrayList4.addAll(ga0Var.d());
            if (iP == iQ || str4.charAt(iP) == '#') {
                String strE = ga0Var.e();
                this.g = strE != null ? ga0.j(ga0.a(strE, 0, strE.length(), " \"'<>#", true, false, true, true)) : null;
            }
            str2 = str4;
            arrayList = arrayList4;
        }
        int iG2 = be1.g(iP, iQ, str2, "?#");
        if (iP != iG2) {
            char cCharAt5 = str2.charAt(iP);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                arrayList3 = arrayList;
                arrayList3.clear();
                arrayList3.add("");
                iP++;
            } else {
                arrayList3 = arrayList;
                arrayList3.set(arrayList.size() - 1, "");
            }
            int i13 = iP;
            while (i13 < iG2) {
                int iG3 = be1.g(i13, iG2, str2, "/\\");
                boolean z3 = iG3 < iG2;
                String strA2 = ga0.a(str2, i13, iG3, " \"<>^`{}|/\\?#", true, false, false, true);
                if (!strA2.equals(".") && !strA2.equalsIgnoreCase("%2e")) {
                    if (!strA2.equals("..") && !strA2.equalsIgnoreCase("%2e.") && !strA2.equalsIgnoreCase(".%2e") && !strA2.equalsIgnoreCase("%2e%2e")) {
                        if (((String) arrayList3.get(arrayList3.size() - 1)).isEmpty()) {
                            arrayList3.set(arrayList3.size() - 1, strA2);
                        } else {
                            arrayList3.add(strA2);
                        }
                        if (z3) {
                            arrayList3.add("");
                        }
                    } else if (!((String) arrayList3.remove(arrayList3.size() - 1)).isEmpty() || arrayList3.isEmpty()) {
                        arrayList3.add("");
                    } else {
                        arrayList3.set(arrayList3.size() - 1, "");
                    }
                }
                if (z3) {
                    iG3++;
                }
                i13 = iG3;
            }
        }
        if (iG2 >= iQ || str2.charAt(iG2) != '?') {
            c2 = '#';
        } else {
            c2 = '#';
            int iH2 = be1.h(str2, iG2, iQ, '#');
            this.g = ga0.j(ga0.a(str2, iG2 + 1, iH2, " \"'<>#", true, false, true, true));
            iG2 = iH2;
        }
        if (iG2 >= iQ || str2.charAt(iG2) != c2) {
            return;
        }
        this.h = ga0.a(str2, iG2 + 1, iQ, "", true, false, false, false);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.a;
        if (str != null) {
            sb.append(str);
            sb.append("://");
        } else {
            sb.append("//");
        }
        if (!this.b.isEmpty() || !this.c.isEmpty()) {
            sb.append(this.b);
            if (!this.c.isEmpty()) {
                sb.append(':');
                sb.append(this.c);
            }
            sb.append('@');
        }
        String str2 = this.d;
        if (str2 != null) {
            if (str2.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
        }
        int iB = this.e;
        if (iB != -1 || this.a != null) {
            if (iB == -1) {
                iB = ga0.b(this.a);
            }
            String str3 = this.a;
            if (str3 == null || iB != ga0.b(str3)) {
                sb.append(':');
                sb.append(iB);
            }
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append((String) arrayList.get(i));
        }
        if (this.g != null) {
            sb.append('?');
            ArrayList arrayList2 = this.g;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2 += 2) {
                String str4 = (String) arrayList2.get(i2);
                String str5 = (String) arrayList2.get(i2 + 1);
                if (i2 > 0) {
                    sb.append('&');
                }
                sb.append(str4);
                if (str5 != null) {
                    sb.append('=');
                    sb.append(str5);
                }
            }
        }
        if (this.h != null) {
            sb.append('#');
            sb.append(this.h);
        }
        return sb.toString();
    }
}
