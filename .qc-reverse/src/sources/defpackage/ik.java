package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ik implements Comparator {
    public final /* synthetic */ int b;

    public /* synthetic */ ik(int i) {
        this.b = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.b) {
            case 0:
                String str = (String) obj;
                String str2 = (String) obj2;
                int iMin = Math.min(str.length(), str2.length());
                int i = 4;
                while (true) {
                    if (i >= iMin) {
                        int length = str.length();
                        int length2 = str2.length();
                        if (length == length2) {
                            return 0;
                        }
                        if (length >= length2) {
                            return 1;
                        }
                    } else {
                        char cCharAt = str.charAt(i);
                        char cCharAt2 = str2.charAt(i);
                        if (cCharAt == cCharAt2) {
                            i++;
                        } else if (cCharAt >= cCharAt2) {
                            return 1;
                        }
                    }
                }
                return -1;
            case 1:
                WeakHashMap weakHashMap = uf1.a;
                float fG = lf1.g((View) obj);
                float fG2 = lf1.g((View) obj2);
                if (fG > fG2) {
                    return -1;
                }
                return fG < fG2 ? 1 : 0;
            case 2:
                m50 m50Var = (m50) obj;
                m50 m50Var2 = (m50) obj2;
                RecyclerView recyclerView = m50Var.d;
                if ((recyclerView == null) == (m50Var2.d == null)) {
                    boolean z = m50Var.a;
                    if (z == m50Var2.a) {
                        int i2 = m50Var2.b - m50Var.b;
                        if (i2 != 0) {
                            return i2;
                        }
                        int i3 = m50Var.c - m50Var2.c;
                        if (i3 != 0) {
                            return i3;
                        }
                        return 0;
                    }
                    if (!z) {
                        return 1;
                    }
                } else if (recyclerView == null) {
                    return 1;
                }
                return -1;
            case 3:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 4:
                return ((m11) obj).c - ((m11) obj2).c;
            case 5:
                return ((View) obj).getTop() - ((View) obj2).getTop();
            case 6:
                return ((String) obj).compareTo((String) obj2);
            default:
                return ((ig1) obj).b - ((ig1) obj2).b;
        }
    }
}
