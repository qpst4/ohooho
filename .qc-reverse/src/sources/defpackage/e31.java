package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e31 extends c31 {
    public static boolean b0(String str, String str2, boolean z) {
        return c0(str, str2, 0, z) >= 0;
    }

    public static final int c0(CharSequence charSequence, String str, int i, boolean z) {
        String str2;
        boolean z2;
        boolean zRegionMatches;
        charSequence.getClass();
        str.getClass();
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        bc0 bc0Var = new bc0(i, length, 1);
        boolean z3 = charSequence instanceof String;
        int i2 = bc0Var.d;
        int i3 = bc0Var.c;
        int i4 = bc0Var.b;
        if (z3 && (str instanceof String)) {
            if ((i2 > 0 && i4 <= i3) || (i2 < 0 && i3 <= i4)) {
                int i5 = i4;
                while (true) {
                    String str3 = (String) charSequence;
                    int length3 = str.length();
                    if (z) {
                        str2 = str;
                        z2 = z;
                        zRegionMatches = str2.regionMatches(z2, 0, str3, i5, length3);
                    } else {
                        zRegionMatches = str.regionMatches(0, str3, i5, length3);
                        str2 = str;
                        z2 = z;
                    }
                    if (!zRegionMatches) {
                        if (i5 == i3) {
                            break;
                        }
                        i5 += i2;
                        str = str2;
                        z = z2;
                    } else {
                        return i5;
                    }
                }
            }
        } else if ((i2 > 0 && i4 <= i3) || (i2 < 0 && i3 <= i4)) {
            while (!f0(str, charSequence, i4, str.length(), z)) {
                if (i4 != i3) {
                    i4 += i2;
                }
            }
            return i4;
        }
        return -1;
    }

    public static boolean d0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static int e0(int i, String str, String str2) {
        int length = (i & 2) != 0 ? str.length() - 1 : 0;
        str2.getClass();
        return str.lastIndexOf(str2, length);
    }

    public static final boolean f0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        char upperCase;
        char upperCase2;
        charSequence.getClass();
        charSequence2.getClass();
        if (i >= 0 && charSequence.length() - i2 >= 0 && i <= charSequence2.length() - i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char cCharAt = charSequence.charAt(i3);
                char cCharAt2 = charSequence2.charAt(i + i3);
                if (cCharAt == cCharAt2 || (z && ((upperCase = Character.toUpperCase(cCharAt)) == (upperCase2 = Character.toUpperCase(cCharAt2)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)))) {
                }
            }
            return true;
        }
        return false;
    }

    public static String g0(String str, String str2, String str3) {
        int iC0 = c0(str, str2, 0, false);
        if (iC0 < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i2 = 0;
        do {
            sb.append((CharSequence) str, i2, iC0);
            sb.append(str3);
            i2 = iC0 + length;
            if (iC0 >= str.length()) {
                break;
            }
            iC0 = c0(str, str2, iC0 + i, false);
        } while (iC0 > 0);
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }

    public static List h0(String str, String[] strArr) {
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                int iC0 = c0(str, str2, 0, false);
                if (iC0 == -1) {
                    return lc1.V(str.toString());
                }
                ArrayList arrayList = new ArrayList(10);
                int length = 0;
                do {
                    arrayList.add(str.subSequence(length, iC0).toString());
                    length = str2.length() + iC0;
                    iC0 = c0(str, str2, length, false);
                } while (iC0 != -1);
                arrayList.add(str.subSequence(length, str.length()).toString());
                return arrayList;
            }
        }
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        bt btVar = new bt(str, new d31(listAsList));
        ArrayList arrayList2 = new ArrayList(ll.L0(new ez0(btVar)));
        at atVar = new at(btVar);
        while (atVar.hasNext()) {
            bc0 bc0Var = (bc0) atVar.next();
            arrayList2.add(str.subSequence(bc0Var.b, bc0Var.c + 1).toString());
        }
        return arrayList2;
    }

    public static String i0(String str) {
        str.getClass();
        str.getClass();
        int iLastIndexOf = str.lastIndexOf(46, str.length() - 1);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1, str.length());
    }
}
