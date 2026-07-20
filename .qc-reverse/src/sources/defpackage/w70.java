package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w70 {
    public final String[] a;

    public w70(jj jjVar) {
        ArrayList arrayList = jjVar.b;
        this.a = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final String a(String str) {
        String[] strArr = this.a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String b(int i) {
        return this.a[i * 2];
    }

    public final jj c() {
        jj jjVar = new jj(1);
        Collections.addAll(jjVar.b, this.a);
        return jjVar;
    }

    public final int d() {
        return this.a.length / 2;
    }

    public final String e(int i) {
        return this.a[(i * 2) + 1];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof w70) && Arrays.equals(((w70) obj).a, this.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int iD = d();
        for (int i = 0; i < iD; i++) {
            sb.append(b(i));
            sb.append(": ");
            sb.append(e(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
